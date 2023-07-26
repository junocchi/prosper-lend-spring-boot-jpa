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
image VARCHAR(100),
primary key (userLoginId));
 
insert into userDetails (userLoginName, passcode, salt, businessName, businessAdminEmail, merchantId, image) values  
('test_user',  SHA1(concat("123456", "password")) , "123456" , 'TestBusiness',  'Test@Business.com',  123456789, 'static/images/user-pictures/avatar-logo.jpg');

select * from userdetails;






-- Create the "loans" table
CREATE TABLE loans (
loanID INT  AUTO_INCREMENT,
loanStatus VARCHAR(10),
amount DOUBLE(10, 2),
interest DOUBLE(5, 2),
userLoginId INT,
loanDate DATE,
FOREIGN KEY (userLoginId) REFERENCES UserDetails(userLoginId),
PRIMARY KEY (loanID));

-- Insert sample values into the "loans" table
INSERT INTO loans (loanStatus, amount, interest, userLoginId, loanDate)
VALUES
('approved', 5000.00, 0.05, 1, '2023-07-01');

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
(1, 10000, "2023-06-01");

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