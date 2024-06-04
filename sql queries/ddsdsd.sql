

DELIMITER //

CREATE FUNCTION GetCustomerNameById(customerId INT)
RETURNS VARCHAR(100) READS SQL DATA
BEGIN
    DECLARE customerName VARCHAR(100);
    SELECT name INTO customerName FROM customer WHERE customerid = customerId LIMIT 1;
    RETURN customerName;
END //

DELIMITER ;

DELIMITER ;
SELECT GetCustomerNameById(1);



DELIMITER ;
