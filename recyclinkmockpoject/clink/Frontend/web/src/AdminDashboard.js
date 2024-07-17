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
  background-color: #343a40;
  color: #ffffff;
  text-align: left;
  border-bottom: 1px solid #dddddd;
`;

const Td = styled.td`
  padding: 10px;
  border-bottom: 1px solid #dddddd;
`;

const Button = styled.button`
  padding: 5px 10px;
  margin-right: 10px;
  color: #ffffff;
  background-color: ${(props) => (props.approve ? "#28a745" : "#dc3545")};
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  &:hover {
    background-color: ${(props) => (props.approve ? "#218838" : "#c82333")};
  }
`;

const AdminDashboard = () => {
  const [listings, setListings] = useState([]);

  useEffect(() => {
    const fetchUnapprovedListings = async () => {
      try {
        const response = await axios.get("http://localhost:3001/unapprove");
        setListings(response.data);
      } catch (error) {
        console.error("Error fetching unapproved listings:", error);
      }
    };

    fetchUnapprovedListings();
  }, []);

  const handleApprove = async (id) => {
    console.log('Approving listing with id:', id);
    try {
      await axios.put(`http://localhost:3001/approve/${id}`);
      setListings((prevListings) =>
        prevListings.filter((listing) => listing.listingid !== id)
      );
    } catch (error) {
      console.error("Error approving listing:", error);
    }
  };

  const handleReject = async (id) => {
    try {
      await axios.delete(`http://localhost:3001/reject/${id}`);
      setListings((prevListings) =>
        prevListings.filter((listing) => listing.listingid !== id)
      );
    } catch (error) {
      console.error("Error rejecting listing:", error);
    }
  };

  return (
    <Container>
      <Title>Admin Dashboard</Title>
      <Table>
        <thead>
          <tr>
            <Th>Product Name</Th>
            <Th>Quantity</Th>
            <Th>Actions</Th>
          </tr>
        </thead>
        <tbody>
          {listings.map((listing) => (
            <tr key={listing.listid}>
              <Td>{listing.productname}</Td>
              <Td>{listing.quantity}</Td>
              <Td>
                <Button approve onClick={() => handleApprove(listing.listingid)}>
                  Approve
                </Button>
                <Button onClick={() => handleReject(listing.listingid)}>
                  Reject
                </Button>
              </Td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Link to="/add-product">Add Product</Link>
    </Container>
  );
};

export default AdminDashboard;
