-- DROP DATABASE IF EXISTS TestProjectProsperLend;
-- CREATE DATABASE TestProjectProsperLend;
-- USE TestProjectProsperLend;

DROP DATABASE IF EXISTS ProjectProsperLend;
CREATE DATABASE ProjectProsperLend;
USE ProjectProsperLend;


create table InterestDeductions (
interestDeductionId int auto_increment,
items varchar(50) not null,
deductionAmount double,
PRIMARY KEY (interestDeductionId));

insert into InterestDeductions (items, deductionAmount) values  
("Carbon neutral", 1),
("Diversity", 1),
("Equity", 1),
("Community Outreach", 1),
("Ethically Sourced", 1);

select * from InterestDeductions;






-- DROP TABLE Messages;
CREATE TABLE Messages (
messageId INT AUTO_INCREMENT,
userEmail VARCHAR(100),
userName VARCHAR(100),
message VARCHAR(255),
CONSTRAINT PK_messageId PRIMARY KEY (messageId));
  
insert into messages(userEmail, username, message) values 
("Email@email.com", "MyName", "Test"),
("Email2@email.com", "MyName2", "Test2");
  
SELECT * FROM MESSAGES;



CREATE TABLE UserDetails (
userLoginId INT auto_increment not null,
userLoginName varchar(30) not null,
passcode varchar(500) not null,
salt varchar(6) not null,
businessName VARCHAR(100) not null ,
businessAdminEmail VARCHAR(100) not null ,
merchantId LONG,
image VARCHAR(150),
primary key (userLoginId));
 
insert into userDetails (userLoginName, passcode, salt, businessName, businessAdminEmail, merchantId, image) values  
('test_user', SHA1(concat("123456", "password")) , "123456" , 'TestBusiness',  'Test@Business.com',  123456789, '/images/user-pictures/avatar-logo.png'),
('pizza_user', SHA1(concat("154823", "pizzapizza")) , "154823" , 'Pizza World',  'admin@PizzaWorld.com',  555556789, 'static/images/user-pictures/avatar-logo.jpg'),
('barber_user', SHA1(concat("145862", "barberbarber")) , "145862" , 'Razor Edge Barber',  'admin@RazorEdge.com',  555556789, 'static/images/user-pictures/avatar-logo.jpg'),
('pub_user', SHA1(concat("659823", "pubpub_pass")) , "659823" , 'Tipsy Tavern',  'admin@TipsyTavern.com',  777776789, 'static/images/user-pictures/avatar-logo.jpg');

select * from userdetails;




-- Create the "loans" table
CREATE TABLE loans (
loanID INT  AUTO_INCREMENT,
<<<<<<< HEAD
loanStatus VARCHAR(10),
amount DECIMAL(10, 2),
interest DECIMAL(5, 2),
currentDebt DECIMAL(10,2),
=======
loanStatus VARCHAR(15),
amount DOUBLE(10, 2),
interest DOUBLE(5, 2),
>>>>>>> 96c44370fdcab96f604ddb2f9cd78442a4c155dc
userLoginId INT,
loanDate DATE,
FOREIGN KEY (userLoginId) REFERENCES UserDetails(userLoginId),
PRIMARY KEY (loanID));

-- Insert sample values into the "loans" table
INSERT INTO loans (loanStatus, amount, currentDebt, interest, userLoginId, loanDate)
VALUES
<<<<<<< HEAD
('approved', 5000.00, 25000.00, 0.05, 1, '2023-07-01');
=======
('In progress', 5000.00, 0.05, 1, '2023-01-01'),
('Completed', 7000.00, 0.03, 1, '2022-07-01'),
('Completed', 10000.00, 0.01, 1, '2022-02-01'),
('In progress', 5000.00, 0.05, 2, '2023-07-01'),
('In progress', 5000.00, 0.05, 3, '2023-07-01');
>>>>>>> 96c44370fdcab96f604ddb2f9cd78442a4c155dc

SELECT * FROM LOANS;






-- DROP TABLE Transactions;
CREATE TABLE Transactions (
transactionId INT AUTO_INCREMENT,
loanId INT,
amount DOUBLE,
transactionDate DATE,
PRIMARY KEY (transactionId),
FOREIGN KEY (loanID) REFERENCES Loans(loanID));
  
INSERT INTO Transactions (loanId, amount, transactionDate) VALUES
(3, 2525.00, "2022-03-05"),
(3, 2525.00, "2022-04-05"),
(3, 2525.00, "2022-05-05"),
(3, 2525.00, "2022-06-05"),
(2, 5100.00, "2022-09-20"),
(2, 2110.00, "2022-10-10"),
(1, 750.00, "2023-04-15"),
(1, 750.00, "2023-05-15"),
(1, 750.00, "2023-07-02");

SELECT * FROM TRANSACTIONS;






CREATE TABLE loanDeductions (
loanDeductionId INT auto_increment, 
loanId INT,
interestDeductionId INT,
PRIMARY KEY (loanDeductionId),
FOREIGN KEY (loanId) REFERENCES Loans(loanId),
FOREIGN KEY (interestDeductionId) REFERENCES InterestDeductions(interestDeductionId)
);

INSERT INTO loanDeductions VALUES
(1, 1, 1), 
(2, 1, 2), 
(3, 1, 3); 
  
SELECT * FROM LOANDEDUCTIONS;






-- create table UserLogin (
-- userLoginId int not null auto_increment,
-- userLoginName varchar(30) not null,
-- passcode varchar(500) not null,
-- -- salt varchar(6) not null,
-- PRIMARY KEY (userLoginId)

-- );  
-- insert into UserLogin (userLoginName, passcode) values 
-- ( "admin_account",  "AdminProsperLend2023"),
-- ( "test_user",  "password123"),
-- ("test_user2", "password");

-- insert into UserLogin (userLoginName, passcode, salt) values 
-- ( "admin_account", SHA1(concat(salt, "AdminProsperLend2023")), "254896"),
-- ( "test_user", SHA1(concat(salt, "password123")), "145896"),
-- ("test_user2", SHA1(concat(salt, "password")), "465987");



-- select * from UserLogin;
-- CREATE TABLE Businesses (
-- businessId INT AUTO_INCREMENT not null,
-- userLoginId INT not null,
-- businessName VARCHAR(100) not null ,
-- businessAdminEmail VARCHAR(100) not null ,
-- merchantId LONG,
-- FOREIGN KEY (userLoginId) REFERENCES UserLogin(userLoginId),
-- PRIMARY KEY (businessId)
-- );

-- INSERT INTO Businesses (userLoginId, businessName, businessAdminEmail, merchantId)
-- VALUES
--     (1, 'GreenTech Solutions', 'admin@greentechsolutions.com', 123456789),
--     (2, 'EcoWise Enterprises', 'admin@ecowiseenterprises.com', 987654321),
--     (1, 'Sustainable Harvest Co.', 'admin@sustainableharvestco.com', 456789123);

-- SELECT * FROM BUSINESSES;
 --  ('approved', 10000.00, 0.06, 2, '2023-07-05'),
--   ('declined', 2000.00, 0.04, 3, '2023-07-08');
-- (2, 5000, "2021-07-01"),
-- (3, 1300, "2023-07-01");
