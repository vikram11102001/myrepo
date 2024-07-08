// cd recyclink-nodejs
// node nodejsmysqlconnection.js

const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const db = require("./db");

const app = express();
const port = 3001; //backend running

app.use(
  cors({
    origin: "*", // Change this to the React app's port front end
  })
);
// Middleware to parse JSON bodies
app.use(bodyParser.json());

// Route to handle POST requests to insert data into the database
//construction company listing
app.post("/addlisting", async (req, res) => {
  const { productname, quantity } = req.body;

  if (!productname || !quantity) {
    return res.status(400).send("Product name and quantity are required");
  }

  try {
    const [result] = await db.execute(
      "INSERT INTO listing (productname, quantity) VALUES (?, ?)", //query
      [productname, quantity]
    );
    res.status(201).send(`Listing added with ID: ${result.insertId}`);
  } catch (error) {
    console.error("Error inserting data into database:", error);
    res.status(500).send("Error inserting data into database");
  }
});
//admin approval function
//show the product waiting for approval
app.get("/unapprove", async (req, res) => {
  try {
    const [results] = await db.query(
      "SELECT * FROM recyclinkmock.listing WHERE approved = 0"
    );
    res.send(results);
  } catch (error) {
    console.error("Error fetching unapproved listings:", error);
    res.status(500).send("Error fetching unapproved listings");
  }
});

// to approve the listing
//admin function
app.put("/approve/:id", async (req, res) => {
  const { id } = req.params;

  try {
    const [result] = await db.execute(
      "UPDATE listing SET approved = 1 WHERE listid = ?",
      [id]
    );
    res.sendStatus(200);
  } catch (error) {
    console.error("Error approving listing:", error);
    res.status(500).send("Error approving listing");
  }
});

// to reject a listing (delete it)
//admin function
app.delete("/reject/:id", async (req, res) => {
  const { id } = req.params;
  try {
    const [result] = await db.execute("DELETE FROM listing WHERE listid = ?", [
      id,
    ]);
    res.sendStatus(200);
  } catch (error) {
    console.error("Error approving listing:", error);
    res.status(500).send("Error approving listing");
  }
});

//react-native app
//customer
app.get("/listings", async (req, res) => {
  try {
    const [results] = await db.query(
      "SELECT * FROM recyclinkmock.listing where approved = 1"
    );
    res.send(results);
  } catch (error) {
    console.error("Error fetching unapproved listings:", error);
    res.status(500).send("Error fetching unapproved listings");
  }
});

// Start the server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}/`);
});
