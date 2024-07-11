// import React from "react";
// import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
// import Register from "./Register";
// import AdminDashboard from "./AdminDashboard"; // Ensure this matches the exact file name
// import AddProduct from "./AddProduct"; // Import the new AddProduct component

// const App = () => {
//   return (
//     <Router>
//       <div className="App">
//         <header className="App-header">
//           <h1>Listing</h1>
//         </header>
//         <Routes>
//           <Route path="/" element={<Register />} />
//           <Route path="/admin" element={<AdminDashboard />} />
//           <Route path="/add-product" element={<AddProduct />} />{" "}
//           {/* Add route for AddProduct */}
//         </Routes>
//       </div>
//     </Router>
//   );
// };

// export default App;

import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Register from './Register';
import AdminDashboard from './AdminDashboard';
import UploadImage from './UploadImage';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/register" />} />
        <Route path="/register" element={<Register />} />
        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/upload/:productname/:quantity" element={<UploadImage />} />
      </Routes>
    </Router>
  );
};

export default App;

