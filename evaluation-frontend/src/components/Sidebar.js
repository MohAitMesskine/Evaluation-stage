import React from 'react';
import { useNavigate } from 'react-router-dom';

export default function Sidebar() {
  const navigate = useNavigate();
  return (
    <aside className="w-64 bg-white h-screen shadow-md flex flex-col p-4">
      <h2 className="text-2xl font-semibold mb-6">Menu</h2>
      <button
        onClick={() => navigate('/')}
        className="mb-4 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition"
      >
        Tableau de bord
      </button>
      <button
        onClick={() => navigate('/inscription/etape1')}
        className="px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700 transition"
      >
        Inscription 
      </button>
    </aside>
  );
}