import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { LineChart, Line, XAxis, YAxis, Tooltip, ResponsiveContainer } from 'recharts';

export default function Dashboard() {
  const [nombreStagiaires, setNombreStagiaires] = useState(0);
  const [nombreTuteurs, setNombreTuteurs] = useState(0);
  const [nombreEvaluations, setNombreEvaluations] = useState(0);

  useEffect(() => {
    // Récupérer le nombre de stagiaires
    axios
      .get('http://localhost:8081/api/statistiques/nombre-stagiaires')
      .then((res) => setNombreStagiaires(res.data))
      .catch((err) => console.error("Erreur API stagiaires :", err));

    // Récupérer le nombre de tuteurs
    axios
      .get('http://localhost:8081/api/statistiques/nombre-tuteurs')
      .then((res) => setNombreTuteurs(res.data))
      .catch((err) => console.error("Erreur API tuteurs :", err));

    // Récupérer le nombre d’évaluations
    axios
      .get('http://localhost:8081/api/statistiques/nombre-evaluations')
      .then((res) => setNombreEvaluations(res.data))
      .catch((err) => console.error("Erreur API évaluations :", err));
  }, []);

  const sampleStats = [
    { name: 'Stage évalué', value: nombreEvaluations },
    { name: 'Stage non évalué', value: Math.max(nombreStagiaires - nombreEvaluations, 0) },
  ];

  return (
    <main className="flex-1 p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold mb-6">Statistiques</h1>

      <div className="grid grid-cols-3 gap-6 mb-8">
        {/* Nombre de stagiaire */}
        <div className="p-6 bg-white rounded-2xl shadow">
          <h3 className="text-xl font-medium">Nombre de stagiaire</h3>
          <p className="text-4xl font-bold mt-2">{nombreStagiaires}</p>
        </div>

        {/* Nombre de tuteur */}
        <div className="p-6 bg-white rounded-2xl shadow">
          <h3 className="text-xl font-medium">Nombre de tuteur</h3>
          <p className="text-4xl font-bold mt-2">{nombreTuteurs}</p>
        </div>

        {/* Nombre de stage évalué */}
        <div className="p-6 bg-white rounded-2xl shadow">
          <h3 className="text-xl font-medium">Nombre de stage évalué</h3>
          <p className="text-4xl font-bold mt-2">{nombreEvaluations}</p>
        </div>
      </div>

      <div className="p-6 bg-white rounded-2xl shadow h-80">
        <h3 className="text-xl font-medium mb-4">Évaluation</h3>
        <ResponsiveContainer width="100%" height="100%">
          <LineChart data={sampleStats}>
            <XAxis dataKey="name" />
            <YAxis allowDecimals={false} />
            <Tooltip />
            <Line type="monotone" dataKey="value" stroke="#3b82f6" strokeWidth={3} />
          </LineChart>
        </ResponsiveContainer>
      </div>
    </main>
  );
}
