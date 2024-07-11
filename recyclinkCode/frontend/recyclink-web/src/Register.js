
import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  background-color: #f8f9fa;
  height: 100vh;
  justify-content: center;
`;

const Title = styled.h2`
  color: #343a40;
  margin-bottom: 20px;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  background: #ffffff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 400px;
`;

const FormControl = styled.div`
  margin-bottom: 15px;
  width: 80%;
`;

const Label = styled.label`
  display: block;
  margin-bottom: 5px;
  color: #495057;
  font-weight: 500;
`;

const Input = styled.input`
  width: 100%;
  padding: 10px;
  border: 1px solid #ced4da;
  border-radius: 4px;
  font-size: 16px;
`;

const Button = styled.button`
  padding: 10px 20px;
  color: #ffffff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  &:hover {
    background-color: #0056b3;
  }
`;

const AdminButton = styled(Button)`
  margin-top: 20px;
  background-color: #28a745;
  &:hover {
    background-color: #218838;
  }
`;

const Register = () => {
  const [productname, setProductName] = useState("");
  const [quantity, setQuantity] = useState("");
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    
    // Assuming validation passed, navigate to UploadImage page
    navigate(`/upload/${productname}/${quantity}`);
  };

  return (
    <Container>
      <Title>Enter Product Details</Title>
      <Form onSubmit={handleSubmit}>
        <FormControl>
          <Label>Product Name: </Label>
          <Input
            type="text"
            value={productname}
            onChange={(e) => setProductName(e.target.value)}
            required
          />
        </FormControl>
        <FormControl>
          <Label>Quantity: </Label>
          <Input
            type="number"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            required
          />
        </FormControl>
        <Button type="submit">Submit</Button>
        <AdminButton>Go to Admin Dashboard</AdminButton>
      </Form>
    </Container>
  );
};

export default Register;
