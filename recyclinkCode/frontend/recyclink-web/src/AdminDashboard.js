// //npm start

import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  background-color: #f8f9fa;
  min-height: 100vh;
`;

const Title = styled.h2`
  color: #343a40;
  margin-bottom: 20px;
`;

const Table = styled.table`
  width: 80%;
  border-collapse: collapse;
  margin: 20px 0;
  background: #ffffff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

const Th = styled.th`
  padding: 10px;
  background-color: #007bff;
  color: #ffffff;
  text-align: left;
  border-bottom: 2px solid #dee2e6;
`;

const Td = styled.td`
  padding: 10px;
  border-bottom: 1px solid #dee2e6;
`;

const Button = styled.button`
  padding: 8px 16px;
  margin: 0 5px;
  color: #ffffff;
  background-color: ${(props) => (props.approve ? "#28a745" : "#dc3545")};
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  &:hover {
    background-color: ${(props) => (props.approve ? "#218838" : "#c82333")};
  }
`;

const AddButton = styled(Link)`
  margin-top: 20px;
  display: inline-block;
  padding: 10px 20px;
  color: #ffffff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  text-decoration: none;
  font-size: 16px;
  &:hover {
    background-color: #0056b3;
  }
`;

const AdminDashboard = () => {
  const [listings, setListings] = useState([]);

  useEffect(() => {
    fetchListings();
  }, []);

  const fetchListings = async () => {
    try {
      const response = await axios.get("http://localhost:3001/unapprove");
      console.log("Fetched listings:", response.data); // Log fetched data
      setListings(response.data);
    } catch (error) {
      console.error("Error fetching listings:", error);
    }
  };

  const handleApprove = async (id) => {
    try {
      await axios.put(`http://localhost:3001/approve/${id}`);
      fetchListings(); // Refresh the listings after approving
    } catch (error) {
      console.error("Error approving listing:", error);
    }
  };

  const handleReject = async (id) => {
    try {
      await axios.delete(`http://localhost:3001/reject/${id}`);
      fetchListings(); // Refresh the listings after rejecting
    } catch (error) {
      console.error("Error rejecting listing:", error);
    }
  };

  return (
    <Container>
      <Title>Admin Dashboard</Title>
      {listings.length === 0 ? (
        <p>No unapproved listings found</p>
      ) : (
        <Table>
          <thead>
            <tr>
              <Th>ID</Th>
              <Th>Product Name</Th>
              <Th>Quantity</Th>
              <Th>Actions</Th>
            </tr>
          </thead>
          <tbody>
            {listings.map((listing) => (
              <tr key={listing.listid}>
                <Td>{listing.listid}</Td>
                <Td>{listing.productname}</Td>
                <Td>{listing.quantity}</Td>
                <Td>
                  <Button approve onClick={() => handleApprove(listing.listid)}>
                    Approve
                  </Button>
                  <Button onClick={() => handleReject(listing.listid)}>
                    Reject
                  </Button>
                </Td>
              </tr>
            ))}
          </tbody>
        </Table>
      )}
      <AddButton to="/add-product">Add Product</AddButton>
    </Container>
  );
};

export default AdminDashboard;
