import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { logout } from '../services/auth';

export default function Header() {
  const navigate = useNavigate();
  const token = localStorage.getItem('token');

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <header className="p-4 bg-white shadow flex justify-between">
      <div>
        <Link to="/">Home</Link>
      </div>
      <nav>
        {token ? (
          <button onClick={handleLogout}>Déconnexion</button>
        ) : (
          <Link to="/login">Connexion</Link>
        )}
      </nav>
    </header>
  );
}