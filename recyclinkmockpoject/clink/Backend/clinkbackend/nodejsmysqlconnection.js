require('dotenv').config();
const express = require("express");
const { S3Client } = require("@aws-sdk/client-s3");
const multer = require("multer");
const multerS3 = require('multer-s3');
const bodyParser = require("body-parser");
const cors = require("cors");
const path = require("path");
const db = require("./db"); // Ensure this file has the local MySQL configuration

const app = express();
const port = 3001; // backend running

app.use(cors({ origin: "*" }));
app.use(bodyParser.json());

// Configure AWS SDK
const s3Client = new S3Client({
  region: process.env.AWS_REGION,
  credentials: {
    accessKeyId: process.env.AWS_ACCESS_KEY_ID,
    secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY,
  },
});

// Configure multer to use S3 for storage
const upload = multer({
  storage: multerS3({
    s3: s3Client,
    bucket: process.env.AWS_BUCKET_NAME,
    metadata: function (req, file, cb) {
      cb(null, { fieldName: file.fieldname });
    },
    key: function (req, file, cb) {
      cb(null, Date.now().toString() + path.extname(file.originalname));
    },
  }),
});

// Route to handle file upload
app.post('/upload', upload.single('image'), async (req, res) => {
  if (!req.file) {
    return res.status(400).json({ error: "No file uploaded" });
  }

  const { listingId } = req.body;
  if (!listingId) {
    return res.status(400).json({ error: "Listing ID is required" });
  }

  console.log("Image URL:", req.file.location); // Log the URL

  try {
    await db.execute(
      "INSERT INTO images (listingid, imageurl) VALUES (?, ?)",
      [listingId, req.file.location]
    );

    res.json({ 
      message: "File uploaded and database updated successfully",
      imageUrl: req.file.location 
    });
  } catch (error) {
    console.error("Error updating database:", error);
    res.status(500).json({ error: "Error updating database", details: error.message });
  }
});


// Route to handle POST requests to insert data into the database
app.post('/addlisting', async (req, res) => {
  const { productname, quantity } = req.body;
  if (!productname || !quantity) {
    return res.status(400).send("Product name and quantity are required");
  }
  try {
    const [result] = await db.execute(
      "INSERT INTO listing (productname, quantity) VALUES (?, ?)",
      [productname, quantity]
    );
    res.status(201).json({ message: `Listing added with ID: ${result.insertId}`, listingId: result.insertId });
  } catch (error) {
    console.error("Error inserting data into database:", error);
    res.status(500).send("Error inserting data into database");
  }
});

app.get("/unapprove", async (req, res) => {
  try {
    const [results] = await db.query("SELECT * FROM listing WHERE approved = 0");
    res.send(results);
  } catch (error) {
    console.error("Error fetching unapproved listings:", error);
    res.status(500).send("Error fetching unapproved listings");
  }
});

// Route to approve a listing
app.put("/approve/:id", async (req, res) => {
  const { id } = req.params;
  const listingId = req.params.id;
  console.log('Received approval request for listing id:', listingId);

  try {
    const [result] = await db.execute("UPDATE listing SET approved = 1 WHERE listingid = ?", [id]);
    res.sendStatus(200);
  } catch (error) {
    console.error("Error approving listing:", error);
    res.status(500).send("Error approving listing");
  }
});

// Route to reject (delete) a listing
app.delete("/reject/:id", async (req, res) => {
  const { id } = req.params;
  try {
    const [result] = await db.execute("DELETE FROM listing WHERE listingid = ?", [id]);
    res.sendStatus(200);
  } catch (error) {
    console.error("Error rejecting listing:", error);
    res.status(500).send("Error rejecting listing");
  }
});

// Route to get approved listings
// app.get("/listings", async (req, res) => {
//   try {
//     const [results] = await db.query("SELECT * FROM listing WHERE approved = 1");
//     res.send(results);
//   } catch (error) {
//     console.error("Error fetching listings:", error);
//     res.status(500).send("Error fetching listings");
//   }
// });
// Route to get approved listings with images
app.get("/listings", async (req, res) => {
  try {
    const [results] = await db.query(`
      SELECT l.*, i.imageurl
      FROM listing l
      LEFT JOIN images i ON l.listingid = i.listingid
      WHERE l.approved = 1
    `);
    
    // Group listings by listingid
    const listings = results.reduce((acc, curr) => {
      const { listingid, productname, quantity, imageurl } = curr;
      const existingListing = acc.find(item => item.listingid === listingid);
      if (existingListing) {
        existingListing.images.push(imageurl);
      } else {
        acc.push({
          listingid,
          productname,
          quantity,
          images: imageurl ? [imageurl] : []
        });
      }
      return acc;
    }, []);

    res.send(listings);
  } catch (error) {
    console.error("Error fetching listings:", error);
    res.status(500).send("Error fetching listings");
  }
});


app.get("/listings/:id", async (req, res) => {
  const { id } = req.params;
  try {
    const [results] = await db.query(`
      SELECT l.*, i.imageurl 
      FROM listing l
      LEFT JOIN images i ON l.listingid = i.listingid
      WHERE l.listingid = ?
    `, [id]);
    if (results.length > 0) {
      res.json(results[0]);
    } else {
      res.status(404).json({ error: "Product not found" });
    }
  } catch (error) {
    console.error("Error fetching product details:", error);
    res.status(500).json({ error: "Error fetching product details" });
  }
});

// Start the server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}/`);
});
