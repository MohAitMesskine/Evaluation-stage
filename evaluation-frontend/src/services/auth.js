import axios from 'axios';

// ⚠️ Base URL corrigée (plus de double /login)
const API_URL = 'http://localhost:8081/auth';

export const login = (usernameOrEmail, password) =>
  axios.post(`${API_URL}/login`, { usernameOrEmail, password });

// Intercepteur pour ajouter automatiquement le JWT
axios.interceptors.request.use(config => {
  const token = localStorage.getItem('token');
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export const logout = () => {
  localStorage.removeItem('token');
};
