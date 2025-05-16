import axios from 'axios';

const API_URL = 'http://localhost:8081/auth';

export const login = (usernameOrEmail, password) =>
  axios.post(`${API_URL}/login`, { usernameOrEmail, password });

axios.interceptors.request.use(config => {
  const token = localStorage.getItem('token');
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

export const logout = () => {
  localStorage.removeItem('token');
};