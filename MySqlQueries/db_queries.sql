--CUSTOMERS queries:

--Login

SELECT custId, custPass FROM Customer WHERE custId = _custId AND custPass = _custPass;

--Get customers details

SELECT custName, custPhone, custEmail FROM Customer WHERE custId = _custId;

--Search for a user

SELECT custName, custPhone, custEmail FROM Customer WHERE custName LIKE '%_usrname%';


--Create a new customer

INSERT INTO Customer(custAddr, custName, custPhone, custEmail) VALUES(_custAddr, _custName, _custPhone, _custEmail);

--Update existing customer details

UPDATE Customer SET custPhone = _custPhone, custEmail = _custEmail WHERE custId = _custId;

--Delete a customer

DELETE FROM Customer WHERE custId = _custId;

----------------------------------------------------------------------

--Employee

--login

SELECT empId, empPassword, accessLevel FROM Employee WHERE empId = _empId AND empPass = _empPass;

--Get employee details

SELECT empName, accessLevel FROM Employee WHERE empId = _empId;

--Add a new employee

INSERT INTO Employee(empName, empPassword, accessLevel) VALUES(_empName, _empPassword, accessLevel);

--Update existing employee's access level

UPDATE Employee SET accessLevel = _accessLevel, empName = _empName WHERE empId = _empId;

--Delete an employee

DELETE FROM Employee WHERE empId = empId;


---------------------------------------------------------------------

--DVD

--Update dvdState

UPDATE Dvd SET dvdState = _dvdState;

--Delete

DELETE FROM Dvd WHERE dvdId = _dvdId;

--how many copies of this movie is available

SELECT COUNT(*) FROM Dvd WHERE stockid = _stockId AND dvdState = 'F';

SELECT dvdId FROM Dvd WHERE stockId = _stockId AND dvdState = 'F';

------------------------------------------------------------------------

--Stock

--get movie details

SELECT dvdYear, dvdTitle, dvdQuant, dvdDirector, rentFee FROM Stock WHERE stockId = _stockId;

--Search by name
SELECT dvdYear, dvdTitle, dvdQuant, dvdDirector, rentFee FROM Stock WHERE dvdTitle LIKE '%_dvdTitle%';

--add a new record

INSERT INTO Stock(dvdYear, dvdTitle, dvdDirector, rentFee) VALUES(_dvdYear, _dvdTitle, _dvdDirector, _rentFee);

--Update movie details

UPDATE Stock SET dvdYear = _dvdYear WHERE stockId = _stockId;

UPDATE Stock SET dvdTitle = _dvdTitle WHERE stockId = _stockId;

UPDATE Stock SET dvdDirector = _dvdDirector WHERE stockId = _stockId;

--DELETE a movie

DELETE FROM Stock WHERE stockId = _stockId;

--Update quantity

UPDATE Stock SET dvdQuant = (SELECT COUNT(*) FROM Dvd WHERE stockId = _stockId);

----------------------------------------------------------------------

--RENTED

--add a new record

INSERT INTO Rented(custId, dvdId, startDate, dueDate) VALUES(_custId, _dvdId, _startDate, _dueDate);

--Check the rent details

SELECT * FROM Rented WHERE rentId = _rentId;

DELETE * FROM Rented WHERE rentId = _rentId;

UPDATE Rented SET dueDate = _dueDate WHERE rentId = _rentId;

--Viewing a list of all of the DVD’s that are currently in stock

SELECT dvdId, stockId, dvdTitle, dvdYear, dvdQuant, dvdDirector, rentFee FROM Stock
JOIN Dvd USING(stockId)
WHERE dvdState LIKE 'A';

--Viewing a list of all of the DVD’s that are currently overdue
SELECT dvdId, stockId, dvdTitle, dvdYear, dvdQuant, dvdDirector, rentFee FROM Stock
JOIN Dvd USING(stockId)
WHERE dvdState LIKE 'O';
 

