import React, { useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
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

const UploadImage = () => {
  const { productId } = useParams();
  const [image, setImage] = useState(null);

  const handleImageChange = (e) => {
    setImage(e.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('image', image);
    formData.append('productId', productId);

    try {
      const response = await axios.post("http://localhost:3001/upload", formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });

      const imageUrl = response.data.imageUrl;
      console.log("Image uploaded successfully:", imageUrl);
    alert("Image uploaded successfully!");
  } catch (error) {
    console.error("There was an error uploading the image!", error);
    alert("There was an error uploading the image!");
  }
  };

  return (
    <Container>
      <Title>Upload Product Image</Title>
      <Form onSubmit={handleSubmit}>
        <FormControl>
          <Label>Product Image: </Label>
          <Input
            type="file"
            onChange={handleImageChange}
          />
        </FormControl>
        <Button type="submit">Upload</Button>
      </Form>
    </Container>
  );
};

export default UploadImage;
