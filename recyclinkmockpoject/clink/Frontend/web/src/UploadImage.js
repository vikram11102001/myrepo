import React, { useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

function ImageUploadForm() {
  const [imageFile, setImageFile] = useState(null);
  const [manualListingId, setManualListingId] = useState('');
  const { listingId: urlListingId } = useParams();
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    if (!imageFile) {
      alert('Please select an image to upload');
      return;
    }

    const listingId = urlListingId || manualListingId;

    if (!listingId) {
      alert('Please enter a listing ID');
      return;
    }

    try {
      const formData = new FormData();
      formData.append('image', imageFile);
      formData.append('listingId', listingId);

      const response = await axios.post('http://localhost:3001/upload', formData, {
        headers: { 'Content-Type': 'multipart/form-data' }
      });

      alert("Image uploaded successfully");
      setImageFile(null);
      setManualListingId('');
      
      // Navigate back to the listing page or wherever you want
      navigate('/');

    } catch (error) {
      alert(`Error uploading image: ${error.response?.data?.error || error.message}`);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Upload Image for Listing</h2>
      {!urlListingId && (
        <input 
          type="text" 
          value={manualListingId}
          onChange={(e) => setManualListingId(e.target.value)}
          placeholder="Enter Listing ID"
          required={!urlListingId}
        />
      )}
      {urlListingId && <p>Uploading for Listing ID: {urlListingId}</p>}
      <input 
        type="file" 
        onChange={e => setImageFile(e.target.files[0])} 
        required 
      />
      <button type="submit">Upload Image</button>
    </form>
  );
}

export default ImageUploadForm;




// import React, { useState } from "react";
// import { useParams } from "react-router-dom";
// import axios from "axios";
// import styled from "styled-components";

// const Container = styled.div`
//   display: flex;
//   flex-direction: column;
//   align-items: center;
//   padding: 20px;
//   background-color: #f8f9fa;
//   height: 100vh;
//   justify-content: center;
// `;

// const Title = styled.h2`
//   color: #343a40;
//   margin-bottom: 20px;
// `;

// const Form = styled.form`
//   display: flex;
//   flex-direction: column;
//   align-items: center;
//   background: #ffffff;
//   padding: 20px;
//   border-radius: 8px;
//   box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
//   width: 400px;
// `;

// const FormControl = styled.div`
//   margin-bottom: 15px;
//   width: 80%;
// `;

// const Label = styled.label`
//   display: block;
//   margin-bottom: 5px;
//   color: #495057;
//   font-weight: 500;
// `;

// const Input = styled.input`
//   width: 100%;
//   padding: 10px;
//   border: 1px solid #ced4da;
//   border-radius: 4px;
//   font-size: 16px;
// `;

// const Button = styled.button`
//   padding: 10px 20px;
//   color: #ffffff;
//   background-color: #007bff;
//   border: none;
//   border-radius: 4px;
//   cursor: pointer;
//   font-size: 16px;
//   &:hover {
//     background-color: #0056b3;
//   }
// `;

// function UploadImage() {
//   const [imageurl, setImageFile] = useState(null);
//   const { listingid } = useParams();

//   const handleSubmit = async (event) => {
//     event.preventDefault();
    
//     if (!imageurl) {
//       alert('Please select an image to upload');
//       return;
//     }

//     if (!listingid) {
//       alert('Please enter a listing ID');
//       return;
//     }

//     try {
//       const formData = new FormData();
//       formData.append('image', imageurl);
//       formData.append('listingId', listingid);

//       const response = await axios.post('http://localhost:3001/upload', formData, {
//         headers: { 'Content-Type': 'multipart/form-data' }
//       });

//       alert("Image uploaded successfully");
//       setImageFile(null);
//       //setListingId('');

//     } catch (error) {
//       alert(`Error uploading image: ${error.response?.data?.error || error.message}`);
//     }
//   };

//   return (
//     <form onSubmit={handleSubmit}>
//       {/* <input 
//         type="text" 
//         value={listingid} 
//         onChange={e => setListingId(e.target.value)} 
//         placeholder="Listing ID" 
//         required 
//       /> */}
//       <input 
//         type="file" 
//         onChange={e => setImageFile(e.target.files[0])} 
//         required 
//       />
//       <button type="submit">Upload Image</button>
//     </form>
//   );
// };

// export default UploadImage;
