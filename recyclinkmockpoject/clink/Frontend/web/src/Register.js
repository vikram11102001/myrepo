
import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import styled from "styled-components";
import axios from "axios";

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

const AdminButton = styled.button`
  margin-top: 20px;
  background-color: #28a745;
  padding: 10px 20px;
  color: #ffffff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  &:hover {
    background-color: #218838;
  }
`;

function Register() {
  const [productname, setProductName] = useState('');
  const [quantity, setQuantity] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    try {
      const response = await axios.post('http://localhost:3001/addlisting', {
        productname: productname,
        quantity: quantity
      });
      
      alert(response.data.message);

      navigate(`/upload/${response.data.listingId}`);

      // Clear form after successful submission
      setProductName('');
      setQuantity('');

    } catch (error) {
      alert(`Error adding listing: ${error.response?.data?.error || error.message}`);
    }
  };

  const goToAdminDashboard = () => {
    navigate('/admin'); // Replace with your actual admin dashboard route
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
      </Form>
      <AdminButton onClick={goToAdminDashboard}>Go to Admin Dashboard</AdminButton>
    </Container>
  );
};

export default Register;
// import React, { useState } from "react";
// import { Link } from "react-router-dom";
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

// const AdminButton = styled(Button)`
//   margin-top: 20px;
//   background-color: #28a745;
//   &:hover {
//     background-color: #218838;
//   }
// `;

// const Register = () => {
//   const [productname, setProductName] = useState("");
//   const [quantity, setQuantity] = useState("");
//   const navigate = useNavigate();
//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     try {
//       const response = await axios.post("http://localhost:3001/addlisting", {
//         productname,
//         quantity,
//       });

//       alert(response.data);
//       setProductName("");
//       setQuantity("");
//     } catch (error) {
//       console.error("There was an error!", error);
//       alert("There was an error adding the listing!");
//     }
//   };

//   return (
//     <Container>
//       <Title>Enter Product Details</Title>
//       <Form onSubmit={handleSubmit}>
//         <FormControl>
//           <Label>Product Name: </Label>
//           <Input
//             type="text"
//             value={productname}
//             onChange={(e) => setProductName(e.target.value)}
//           />
//         </FormControl>
//         <FormControl>
//           <Label>Quantity: </Label>
//           <Input
//             type="number"
//             value={quantity}
//             onChange={(e) => setQuantity(e.target.value)}
//           />
//         </FormControl>
//         <Button type="submit">Submit</Button>
//       </Form>
//       <Link to="/admin">
//         <AdminButton>Admin Dashboard</AdminButton>
//       </Link>
//     </Container>
//   );
// };

// export default Register;
