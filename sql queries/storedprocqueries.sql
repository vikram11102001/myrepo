DELIMITER $$
CREATE PROCEDURE GetMovieData()
BEGIN
    SELECT * FROM movie;
END$$

CALL GetMovieData();

DELIMITER //
CREATE PROCEDURE GetDetailsByMovieName(IN movieId INT)
BEGIN
    SELECT * FROM movie where id = movieId;
END //
CALL GetDetailsByMovieName(1);

DELIMITER //

CREATE PROCEDURE UpdateMovieName(
    IN movieId INT,
    IN newMovieName VARCHAR(45)
)
BEGIN
    UPDATE movie
    SET name = newMovieName
    WHERE id = movieId;
END //

DELIMITER ;
CALL UpdateMovieName(1, 'AYALAAN');
SELECT * FROM movie WHERE id = 1;


