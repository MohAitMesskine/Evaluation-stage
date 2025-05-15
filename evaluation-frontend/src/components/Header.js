import React from 'react';
import { useNavigate } from 'react-router-dom';

export default function Header() {
  const navigate = useNavigate();
  return (
    <header className="w-full bg-white shadow-md p-4 flex justify-between items-center">
      <h1 className="text-2xl font-bold cursor-pointer" onClick={() => navigate('/')}> Projet de gestion evaluation des Stages</h1>
      <nav className="space-x-4"> 
        <button className="text-gray-700 hover:text-gray-900" onClick={() => navigate('/')}>Dashboard</button>
        <button className="text-gray-700 hover:text-gray-900" onClick={() => navigate('/inscription/etape1')}>Inscription</button>
      </nav>
    </header>
  );
}
