import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
  useLocation,
} from 'react-router-dom';
import Header from './components/Header.js';
import Sidebar from './components/Sidebar.js';
import Footer from './components/Footer.js';
import Dashboard from './components/Dashboard.js';
import Login from './pages/Login.js';
import PrivateRoute from './components/PrivateRoute.js';
import Etape1 from './pages/Etape1.js';
import Etape2 from './pages/Etape2.js';
import Etape3 from './pages/Etape3.js';
import Etape4 from './pages/Etape4.js';
import Etape5 from './pages/Etape5.js';
import Confirmation from './pages/Confirmation.js';

function App() {
  return (
    <Router>
      <Layout />
    </Router>
  );
}

function Layout() {
  const { pathname } = useLocation();
  const showSidebar = pathname !== '/login';

  return (
    <div className="flex flex-col min-h-screen">
      {showSidebar && <Header />}
      <div className="flex flex-1">
        {showSidebar && <Sidebar />}
        <main className="flex-1">
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route
              path="/"
              element={
                <PrivateRoute>
                  <Dashboard />
                </PrivateRoute>
              }
            />
            <Route path="/inscription/etape1" element={<PrivateRoute><Etape1 /></PrivateRoute>} />
            <Route path="/inscription/etape2" element={<PrivateRoute><Etape2 /></PrivateRoute>} />
            <Route path="/inscription/etape3" element={<PrivateRoute><Etape3 /></PrivateRoute>} />
            <Route path="/inscription/etape4" element={<PrivateRoute><Etape4 /></PrivateRoute>} />
            <Route path="/inscription/etape5" element={<PrivateRoute><Etape5 /></PrivateRoute>} />
            <Route path="/confirmation" element={<PrivateRoute><Confirmation /></PrivateRoute>} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </main>
      </div>
       {showSidebar && <Footer />}
    </div>
  );
}

export default App;
