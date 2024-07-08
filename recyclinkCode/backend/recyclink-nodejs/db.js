const mysql = require("mysql2");

const pool = mysql.createPool({
  host: "recyclink-master-db.c7m0qyaogty5.us-east-1.rds.amazonaws.com", // Replace with your MySQL host
  user: "recyclinkadmin", // Replace with your MySQL username
  password: "rootadmin", // Replace with your MySQL password
  database: "recyclinkmock", // Replace with your MySQL database name
});

module.exports = pool.promise();
