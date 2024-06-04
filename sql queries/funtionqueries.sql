DELIMITER //

CREATE FUNCTION GetMovieNameById(movieId INT)
RETURNS VARCHAR(45) READS SQL DATA
BEGIN
    DECLARE movieName VARCHAR(45);
    
    DECLARE rowCount INT DEFAULT 0;
    SELECT COUNT(*) INTO rowCount FROM movie WHERE id = movieId;
    
    IF rowCount > 0 THEN
        SELECT name INTO movieName FROM movie WHERE id = movieId;
    ELSE
        SET movieName = 'Movie not found';
    END IF;
    
    RETURN movieName;
END //

DELIMITER ;
SELECT GetMovieNameById(1);