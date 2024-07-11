const mysql = require("mysql2");

const pool = mysql.createPool({
  host: "localhost", // Replace with your MySQL host
  user: "root", // Replace with your MySQL username
  password: "root@123", // Replace with your MySQL password
  database: "recyclinkmock", // Replace with your MySQL database name
});

module.exports = pool.promise();
