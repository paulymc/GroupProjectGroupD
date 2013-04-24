
--create tables and triggers

--create tables

CREATE TABLE Customer (
custId INT(10) UNSIGNED AUTO_INCREMENT NOT NULL,
custAddr CHAR(50) NOT NULL,
custPhone CHAR(15) UNIQUE,
custEmail CHAR(20),
custName CHAR(25),
branch CHAR(25),
county CHAR(20),
dateJoined DATE, 
PRIMARY KEY(custId)
);

CREATE TABLE Stock (
stockId INT(10) UNSIGNED AUTO_INCREMENT NOT NULL,
dvdYear INT(4) UNSIGNED,
dvdTitle CHAR(20),
dvdQuant INT(2) UNSIGNED,
dvdDirector CHAR(25),
dvdRentFee INT(3) UNSIGNED,
PRIMARY KEY(stockId)
);

CREATE TABLE Dvd (
stockId INT(10) UNSIGNED NOT NULL,
dvdId INT(10) UNSIGNED AUTO_INCREMENT NOT NULL,
dvdState CHAR(1),
FOREIGN KEY (stockId) REFERENCES Stock(stockId) ON DELETE CASCADE,
PRIMARY KEY (dvdId)
);

CREATE TABLE Rent (
rentId INT(10) UNSIGNED AUTO_INCREMENT NOT NULL,
startDate DATE,
returnDate DATE,
rentDays INT(2),
dvdId INT(10) UNSIGNED NOT NULL,
custId INT(10) UNSIGNED NOT NULL,
FOREIGN KEY (custId) REFERENCES Customer(custId) ON DELETE CASCADE,
FOREIGN KEY (dvdId) REFERENCES Dvd(dvdId) ON DELETE CASCADE,
PRIMARY KEY (rentId)
);

CREATE TABLE Reservation(
reservId INT(10) UNSIGNED AUTO_INCREMENT NOT NULL,
reservDate DATE,
dvdId INT(10) UNSIGNED NOT NULL,
custId INT(10) UNSIGNED NOT NULL,
FOREIGN KEY (custId) REFERENCES Customer(custId) ON DELETE CASCADE,
FOREIGN KEY (dvdId) REFERENCES Dvd(dvdId) ON DELETE CASCADE,
PRIMARY KEY (reservId)
);

--TRIGGERS:
--set quantity of current dvd in stock
delimiter //
CREATE TRIGGER count_quant_ins after insert ON Dvd
FOR EACH ROW 
  BEGIN
  UPDATE Stock SET dvdQuant = (SELECT COUNT(*) FROM Dvd WHERE stockId = NEW.stockId) WHERE stockId = NEW.stockId;
  END//
  
delimiter ;

  
delimiter //
CREATE PROCEDURE set_quant_a_del(IN sId INT)
BEGIN
  UPDATE Stock SET dvdQuant = (SELECT COUNT(*) FROM Dvd WHERE stockId = sId) WHERE stockId = sId;
END//

CALL set_quant_a_del();

--check the availability of such dvd in stock and if customer has an overdue dvd 
delimiter //
CREATE TRIGGER bi_rent
  BEFORE INSERT 
  ON Rent
  FOR EACH ROW 
  BEGIN 
	DECLARE over_count INTEGER;
	DECLARE not_returned_over INTEGER;
	DECLARE check_dvd_in_stock INTEGER;
    SELECT COUNT(*) into over_count FROM Rent WHERE (startDate + rentDays) < returnDate AND custId = NEW.custId;
	SELECT COUNT(*) into not_returned_over FROM Rent WHERE (startDate + rentDays) < sysdate() AND custId = NEW.custId AND returnDate is NULL;
	SELECT COUNT(*) into check_dvd_in_stock FROM Rent WHERE dvdId = NEW.dvdId AND returnDate IS NULL;
    IF (over_count > 0) THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer has overdue dvds.';
	ELSEIF (not_returned_over > 0) THEN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer has overdue dvds.';
	ELSEIF (check_dvd_in_stock > 0) THEN 
	SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'DVD is currently rented. You cannot take it.';
    END IF;
  END//
  delimiter ;
  
--change dvd state to 'R' after inserting it into rent table
delimiter //
CREATE TRIGGER ai_rent
  AFTER INSERT 
  ON Rent
  FOR EACH ROW 
  BEGIN 
    UPDATE Dvd SET dvdState = 'r' WHERE dvdId = NEW.dvdId;
  END//
  delimiter ;
  
  --change dvd state after update the Rent table - when customer returns a dvd
  delimiter //
  CREATE TRIGGER au_rent
  AFTER UPDATE 
  ON Rent
  FOR EACH ROW 
  BEGIN 
	IF (NEW.returnDate = curdate()) THEN
	UPDATE Dvd SET dvdState = 'a' WHERE dvdId = NEW.dvdId;
    END IF;
  END//
  delimiter ;
  
  
  --check the availability of such dvd in stock before reserving it

delimiter //
CREATE TRIGGER bi_reserv
  BEFORE INSERT 
  ON Reservation
  FOR EACH ROW 
  BEGIN 
	DECLARE check_dvd_in_stock INTEGER;
	DECLARE check_dvd_is_reserved INTEGER;
	SELECT COUNT(*) into check_dvd_in_stock FROM Rent WHERE dvdId = NEW.dvdId AND returnDate IS NULL;
	SELECT COUNT(*) into check_dvd_is_reserved FROM Reservation WHERE dvdId = NEW.dvdId;
	IF (check_dvd_in_stock > 0) THEN 
	SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'DVD is currently rented. You cannot take it.';
	ELSEIF (check_dvd_is_reserved > 0) THEN
	SIGNAL SQLSTATE '45003' SET MESSAGE_TEXT = 'DVD is currently reserved. Try another one.';
    END IF;
  END//
  delimiter ;