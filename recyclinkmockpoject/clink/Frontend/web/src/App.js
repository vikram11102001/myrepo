import React, { useEffect } from "react";
import "./App.css";
import { Amplify } from "aws-amplify";
import { Authenticator, withAuthenticator } from "@aws-amplify/ui-react";
import "@aws-amplify/ui-react/styles.css";
import awsExports from "./aws-exports";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Link,
  Navigate,
  useNavigate,
} from "react-router-dom";
import Register from "./Register";
import AdminDashboard from "./AdminDashboard";
import AddProduct from "./AddProduct";
import UploadImage from './UploadImage';
Amplify.configure(awsExports);

function App() {
  const navigate = useNavigate();

  const handleAuthStateChange = (authState) => {
    if (authState === "signedin") {
      navigate("/register");
    }
  };

  return (
    <div className="App">
      <h2>Listing</h2>
      <Authenticator onStateChange={handleAuthStateChange}>
        {({ signOut }) => (
          <>
            <nav>
              <Link to="/register">Register</Link>
              <Link to="/admin">Admin Dashboard</Link>
              <Link to="/add-product">Add Product</Link>
            </nav>
            <button
              onClick={signOut}
              style={{
                margin: "20px",
                fontSize: "0.8rem",
                padding: "5px 10px",
                marginTop: "20px",
              }}
            >
              Sign Out
            </button>
          </>
        )}
      </Authenticator>
      <Routes>
        <Route path="/" element={<Navigate to="/register" />} />
        <Route path="/register" element={<Register />} />
        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/upload/:listingId" element={<UploadImage />} />
        <Route path="/add-product" element={<AddProduct />} />
      </Routes>
    </div>
  );
}

function AppWithRouter() {
  return (
    <Router>
      <App />
    </Router>
  );
}

export default withAuthenticator(AppWithRouter);
