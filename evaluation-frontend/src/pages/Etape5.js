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

  const niveaux = [
    'DEBUTANT',
    'INTERMEDIAIRE',
    'AVANCE',
    'AUTONOME',
    'AUTONOME_PLUS',
    'NA'
  ];

  // Récupération du token
  const token = localStorage.getItem('token');

  useEffect(() => {
    setCompetenceScientifique(analyseConceptionPreliminaire);
    if (!token) navigate('/login');
  }, [analyseConceptionPreliminaire, token, navigate]);

  const handleRowChange = (index, field, value) => {
    setRows(prev =>
      prev.map((row, i) => (i === index ? { ...row, [field]: value } : row))
    );
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!token) return;

    const headers = {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    };

    try {
      const etape1Data = JSON.parse(sessionStorage.getItem('etape1Data')) || {};
      const etape2Data = JSON.parse(sessionStorage.getItem('etape2Data')) || {};
      const etape3Data = JSON.parse(sessionStorage.getItem('etape3Data')) || {};
      const etape4Data = JSON.parse(sessionStorage.getItem('etape4Data')) || {};
      const { idTuteur, idPeriode } = etape1Data;

      // appels API (étapes 1 à 5 identiques)...
      // 6. POST compétences métier
      const metierPayload = {
        appreciationIdTuteur: etape4Data.appreciationIdTuteur || idTuteur,
        appreciationIdPeriode: etape4Data.appreciationIdPeriode || idPeriode
      };
      rows.forEach((row, i) => {
        metierPayload[`competence${i+1}`] = row.competence;
        metierPayload[`niveau${i+1}`] = row.evaluation;
      });
      let res = await fetch('http://localhost:8081/api/competences-metier', {
        method: 'POST',
        headers,
        body: JSON.stringify(metierPayload),
      });
      if (!res.ok) throw new Error(`competences-metier ${res.status}`);

      ['etape1Data','etape2Data','etape3Data','etape4Data'].forEach(k => sessionStorage.removeItem(k));
      navigate('/confirmation');
    } catch (err) {
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
          <label className="block font-semibold mb-2">* Note scientifique (sur 20)</label>
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
          <div className="px-4 py-2 border-b"><p className="font-semibold">Compétences métier</p></div>
          <table className="w-full table-auto">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-4 py-2">#</th>
                <th className="px-4 py-2">Compétence</th>
                <th className="px-4 py-2">Niveau</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((row, i) => (
                <tr key={i}>
                  <td className="px-4 py-2">{i+1}</td>
                  <td className="px-4 py-2">
                    <input
                      type="text"
                      value={row.competence}
                      onChange={e => handleRowChange(i, 'competence', e.target.value)}
                      className="w-full px-2 py-1 border rounded"
                    />
                  </td>
                  <td className="px-4 py-2">
                    <select
                      value={row.evaluation}
                      onChange={e => handleRowChange(i, 'evaluation', e.target.value)}
                      className="w-full px-2 py-1 border rounded"
                    >
                      <option value="">Sélectionner</option>
                      {niveaux.map(niv => (
                        <option key={niv} value={niv}>{niv.replace('_PLUS', ' +')}</option>
                      ))}
                    </select>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="flex justify-between">
          <button type="button" onClick={() => navigate(-1)} className="px-4 py-2 border rounded">Précédent</button>
          <button type="submit" className="px-6 py-2 bg-blue-600 text-white rounded">Envoyer</button>
        </div>
      </form>
    </div>
  );
}
