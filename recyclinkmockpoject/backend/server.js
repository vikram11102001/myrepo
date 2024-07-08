const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

// MySQL connection configuration
const db = mysql.createConnection({
    host: 'recyclink-master-db.c7m0qyaogty5.us-east-1.rds.amazonaws.com',
    user: 'recyclinkadmin',
    password: 'rootadmin',
    database: 'recyclinkmock'
});

// Connect to the database
db.connect((err) => {
    if (err) {
        console.error('Error connecting to MySQL database:', err);
        return;
    }
    console.log('Connected to MySQL database');
});

// API endpoint to get data from listing table
app.get('/listings', (req, res) => {
    const query = 'SELECT * FROM recyclinkmock.listing where approved = 1';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Error executing query:', err);
            res.status(500).send('Error executing query');
            return;
        }
        res.json(results);
    });
});

app.listen(port,  () => {
    console.log(`Server running on http://localhost:${port}`);
});
