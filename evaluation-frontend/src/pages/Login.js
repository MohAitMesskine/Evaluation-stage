import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../services/auth';

export default function Login() {
  const [usernameOrEmail, setUsernameOrEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await login(usernameOrEmail, password);
      localStorage.setItem('token', res.data.token);
      navigate('/');
    } catch (err) {
      setError("Nom d’utilisateur ou mot de passe incorrect");
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-100 to-indigo-200 flex items-center justify-center px-4">
      <div className="bg-white shadow-lg rounded-lg max-w-md w-full p-8">
        <h2 className="text-3xl font-semibold text-gray-800 mb-6 text-center">
         Evalutation des stages
        </h2>

        {error && (
          <div className="mb-4 text-red-600 bg-red-100 border border-red-400 px-4 py-2 rounded">
            {error}
          </div>
        )}

        <form onSubmit={handleSubmit} className="space-y-6">
          <div>
            <label
              htmlFor="usernameOrEmail"
              className="block text-gray-700 font-medium mb-2"
            >
              Username ou Email
            </label>
            <input
              id="usernameOrEmail"
              type="text"
              className="w-full px-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition"
              value={usernameOrEmail}
              onChange={(e) => setUsernameOrEmail(e.target.value)}
              placeholder="Entrez votre nom d’utilisateur ou email"
              required
            />
          </div>

          <div>
            <label
              htmlFor="password"
              className="block text-gray-700 font-medium mb-2"
            >
              Mot de passe
            </label>
            <input
              id="password"
              type="password"
              className="w-full px-4 py-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Entrez votre mot de passe"
              required
            />
          </div>

          <button
            type="submit"
            className="w-full py-3 bg-indigo-600 text-white font-semibold rounded-md hover:bg-indigo-700 active:bg-indigo-800 transition"
          >
            Se connecter
          </button>
        </form>
      </div>
    </div>
  );
}
