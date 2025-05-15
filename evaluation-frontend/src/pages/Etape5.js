// src/components/Step5EvaluationForm.jsx
import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export default function Step5EvaluationForm() {
  const navigate = useNavigate();
  const location = useLocation();

  const { analyseConceptionPreliminaire = '' } = location.state || {};

  const [competenceScientifique, setCompetenceScientifique] = useState('');
  const [noteSci, setNoteSci] = useState('');
  const [rows, setRows] = useState(
    Array.from({ length: 5 }, () => ({ competence: '', evaluation: '' }))
  );

  useEffect(() => {
    setCompetenceScientifique(analyseConceptionPreliminaire);
  }, [analyseConceptionPreliminaire]);

  const handleRowChange = (index, field, value) => {
    setRows(prev =>
      prev.map((row, i) => (i === index ? { ...row, [field]: value } : row))
    );
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // Récupère toutes les étapes
      const etape1Data = JSON.parse(sessionStorage.getItem('etape1Data')) || {};
      const etape2Data = JSON.parse(sessionStorage.getItem('etape2Data')) || {};
      const etape3Data = JSON.parse(sessionStorage.getItem('etape3Data')) || {};
      const etape4Data = JSON.parse(sessionStorage.getItem('etape4Data')) || {};

      // Extrait les IDs dynamiques
      const { idTuteur, idPeriode } = etape1Data;
      console.log('IDs dynamiques récupérés:', 'idTuteur =', idTuteur, ', idPeriode =', idPeriode);

      const {
        intituleEntreprise,
        appreciationIdTuteur,
        appreciationIdPeriode,
        analyseFonctionnementEntreprise,
        analyseDemarcheProjet,
        comprehensionPolitiqueEnvironnementale,
        rechercheEtSelectionInformation,
        note: noteEntreprise
      } = etape4Data;

      // 1. POST stagiaire+stage
      let res = await fetch('http://localhost:8081/api/stagiaire-stage/add', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(etape1Data),
      });
      if (!res.ok) throw new Error(`stagiaire-stage ${res.status}`);

      // 2. POST évaluation globale (Etape2)
      res = await fetch('http://localhost:8081/api/evaluations', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(etape2Data),
      });
      if (!res.ok) throw new Error(`evaluations ${res.status}`);

      // 3. POST compétences individuelles (Etape3)
      res = await fetch('http://localhost:8081/api/competences-individu', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(etape3Data),
      });
      if (!res.ok) throw new Error(`competences-individu ${res.status}`);

      // 4. POST compétence-entreprise (Etape4)
      const entreprisePayload = {
        intituleEntreprise,
        appreciationIdTuteur,
        appreciationIdPeriode,
        analyseFonctionnementEntreprise,
        analyseDemarcheProjet,
        comprehensionPolitiqueEnvironnementale,
        rechercheEtSelectionInformation,
        note: Number(noteEntreprise)
      };
      res = await fetch('http://localhost:8081/api/competence-entreprise', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(entreprisePayload),
      });
      if (!res.ok) throw new Error(`competence-entreprise ${res.status}`);

      // 5. POST compétences scientifiques (Étape préliminaire)
      const sciPayload = {
        produitsServicesProcessusUsages: competenceScientifique,
        note: Number(noteSci),
        appreciationIdTuteur: appreciationIdTuteur || idTuteur,
        appreciationIdPeriode: appreciationIdPeriode || idPeriode
      };
      console.log('Payload scientifique :', sciPayload);
      res = await fetch('http://localhost:8081/api/competences-scientifiques', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(sciPayload),
      });
      if (!res.ok) throw new Error(`competences-scientifiques ${res.status}`);

      // 6. POST compétences métier (Étape5)
      const metierPayload = {
        appreciationIdTuteur: appreciationIdTuteur || idTuteur,
        appreciationIdPeriode: appreciationIdPeriode || idPeriode
      };
      rows.forEach((row, i) => {
        metierPayload[`competence${i+1}`] = row.competence;
        metierPayload[`niveau${i+1}`] = row.evaluation;
      });
      console.log('Payload métier :', metierPayload);
      res = await fetch('http://localhost:8081/api/competences-metier', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(metierPayload),
      });
      if (!res.ok) throw new Error(`competences-metier ${res.status}`);

      // 7. Nettoyage et redirection
      ['etape1Data','etape2Data','etape3Data','etape4Data']
        .forEach(key => sessionStorage.removeItem(key));
      navigate('/confirmation');
    } catch(err) {
      console.error(err);
      alert('Erreur lors de l’envoi : ' + err.message);
    }
  };

  return (
    <div className="w-[90%] mx-auto p-4 shadow-lg rounded-lg">
      <form className="space-y-6" onSubmit={handleSubmit}>
        {/* Préliminaire scientifique */}
        <div className="bg-gray-100 border-l-4 border-green-500 p-4">
          <p className="font-semibold">Compétence scientifique :</p>
          <p className="ml-4">{competenceScientifique || 'Aucune sélection'}</p>
        </div>
        <div className="bg-gray-100 border-l-4 border-red-500 p-4">
          <label className="block font-semibold mb-2">
            * Note scientifique (sur 20)
          </label>
          <input
            type="number"
            min="0"
            max="20"
            step="0.1"
            value={noteSci}
            onChange={e => setNoteSci(e.target.value)}
            className="w-24 px-2 py-1 border rounded"
          />
        </div>

        {/* Compétences métier */}
        <div className="bg-white border rounded">
          <div className="px-4 py-2 border-b">
            <p className="font-semibold">Compétences métier</p>
          </div>
          <table className="w-full table-auto">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-4 py-2">#</th>
                <th className="px-4 py-2">Compétence</th>
                <th className="px-4 py-2">Niveau</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((row,i) => (
                <tr key={i}>
                  <td className="px-4 py-2">{i+1}</td>
                  <td className="px-4 py-2">
                    <input
                      type="text"
                      value={row.competence}
                      onChange={e => handleRowChange(i,'competence',e.target.value)}
                      className="w-full px-2 py-1 border rounded"
                    />
                  </td>
                  <td className="px-4 py-2">
                    <input
                      type="text"
                      value={row.evaluation}
                      onChange={e => handleRowChange(i,'evaluation',e.target.value)}
                      className="w-full px-2 py-1 border rounded"
                    />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="flex justify-between">
          <button
            type="button"
            onClick={() => navigate(-1)}
            className="px-4 py-2 border rounded"
          >
            Précédent
          </button>
          <button
            type="submit"
            className="px-6 py-2 bg-blue-600 text-white rounded"
          >
            Envoyer
          </button>
        </div>
      </form>
    </div>
  );
}
