const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

// Create a MySQL connection
const mysqlConnection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root',
  database: 'employeedb'
});

// Connect to the MySQL database
mysqlConnection.connect((err) => {
  if (err) {
    console.error('Database connection failed: ' + err.stack);
    return;
  }
  console.log('Connected to database.');
});

// Example route that uses the MySQL connection
app.get('/users', (req, res) => {
  mysqlConnection.query('SELECT * FROM employee', (err, results) => {
    if (err) {
      console.error('Failed to retrieve users: ' + err.stack);
      res.status(500).send('Failed to retrieve users');
      return;
    }
    res.json(results);
    console.log(results);
  });
});

// For getting particular id
app.get('/users/:id', (req, res) => {
  mysqlConnection.query('SELECT * FROM employee WHERE id = ?', [req.params.id], (err, results) => {
    if (err) {
      console.error('Failed to retrieve user: ' + err.stack);
      res.status(500).send('Failed to retrieve user');
      return;
    }
    res.json(results);
    console.log(results);
  });
});

// Delete user
app.delete('/users/:id', (req, res) => {
  mysqlConnection.query('DELETE FROM employee WHERE id = ?', [req.params.id], (err, results) => {
    if (err) {
      console.error('Failed to delete user: ' + err.stack);
      res.status(500).send('Failed to delete user');
      return;
    }
    console.log('Deleted successfully');
    res.send('Deleted successfully');
  });
});

// Insert or update user
app.post('/users', (req, res) => {
  let emp = req.body;
  console.log('Request body:', emp); // Log the request body to debug

  mysqlConnection.query('SELECT * FROM employee WHERE id = ?', [emp.id], (err, results) => {
    if (err) {
      console.error('Failed to retrieve user: ' + err.stack);
      res.status(500).send('Failed to retrieve user');
      return;
    }

    if (results.length > 0) {
      // Update existing employee
      const updateSql = 'UPDATE employee SET name = ? WHERE id = ?';
      mysqlConnection.query(updateSql, [emp.name, emp.id], (err, results) => {
        if (err) {
          console.error('Failed to update user: ' + err.stack);
          res.status(500).send('Failed to update user');
          return;
        }
        console.log('Updated successfully');
        res.send('Updated successfully');
      });
    } else {
      // Insert new employee
      const insertSql = 'INSERT INTO employee (id, name) VALUES (?, ?)';
      mysqlConnection.query(insertSql, [emp.id, emp.name], (err, results) => {
        if (err) {
          console.error('Failed to insert user: ' + err.stack);
          res.status(500).send('Failed to insert user');
          return;
        }
        console.log('Inserted successfully');
        res.send('Inserted successfully');
      });
    }
  });
});

// Start the Express server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
