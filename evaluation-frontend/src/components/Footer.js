import React from 'react';

export default function Footer() {
  return (
    <footer className="w-full bg-white shadow-inner p-4 text-center text-gray-600">
      © {new Date().getFullYear()} Mon Projet. Tous droits réservés.
    </footer>
  );
}