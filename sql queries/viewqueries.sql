CREATE VIEW `action movies` AS
SELECT Name, Year
FROM movie
WHERE genre = 'ACTION THRILLER';

SELECT * FROM `action movies`;