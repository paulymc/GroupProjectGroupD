INSERT INTO Customer(custAddr, custName, custPass) VALUES('30 Georges Quay, Dublin 4', 'John Murphy', 'passwrd');
INSERT INTO Customer(custAddr, custName, custPass) VALUES('App. 123, 57 Merrion Square', 'Eoin Collins', 'lol');
INSERT INTO Customer(custAddr, custName, custPass) VALUES('40 Church Park Drive', 'Loui Anderson', 'nnn');

INSERT INTO Stock(dvdYear, dvdTitle, dvdDirector, dvdrentFee) VALUES(1999, 'The Boondock Saints', 'Wachowski', 3);
INSERT INTO Stock(dvdYear, dvdTitle, dvdDirector, dvdrentFee) VALUES(1998, 'Dogma', NULL, 4);
INSERT INTO Stock(dvdYear, dvdTitle, dvdDirector, dvdrentFee) VALUES(2012, 'Lawless', NULL, 3.50);
INSERT INTO Stock(dvdYear, dvdTitle, dvdDirector, dvdrentFee) VALUES(2012, 'Harry Potter and Holy Shit', 'J.K.Roaling', 4);

INSERT INTO Dvd(dvdState, stockId) VALUES('A', 1);
INSERT INTO Dvd(dvdState, stockId) VALUES('B', 2);
INSERT INTO Dvd(dvdState, stockId) VALUES('A', 4);
INSERT INTO Dvd(dvdState, stockId) VALUES('R', 3);
INSERT INTO Dvd(dvdState, stockId) VALUES('O', 1);
INSERT INTO Dvd(dvdState, stockId) VALUES('B', 4);

INSERT INTO Rented(startDate, dueDate, custId, dvdId) VALUES(NOW(), '20-03-
2013 15:00:00', 3, 2);
INSERT INTO Rented(startDate, dueDate, custId, dvdId) VALUES(NOW(), '11-03-2013 18:30:00', 2, 1);

INSERT INTO Employee(empNam, empPassword, accessLevel) VALUES('Jack London', 'jacke16', 'SAL');
INSERT INTO Employee(empNam, empPassword, accessLevel) VALUES('Oscar Wilde', 'iamfag', 'SAL');
INSERT INTO Employee(empNam, empPassword, accessLevel) VALUES('O. de Balsac', 'alco', 'SAL');
INSERT INTO Employee(empNam, empPassword, accessLevel) VALUES('Old Fag', 'iamfag', 'MNG');



