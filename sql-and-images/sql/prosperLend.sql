DROP DATABASE IF EXISTS TestProjectProsperLend;
CREATE DATABASE TestProjectProsperLend;
USE TestProjectProsperLend;

DROP DATABASE IF EXISTS ProjectProsperLend;
CREATE DATABASE ProjectProsperLend;
-- USE ProjectProsperLend;

create table UserLogins (
userLoginId int auto_increment primary key,
userLoginName varchar(30) not null,
passcode varchar(500) not null,
salt varchar(6) not null,
userRole varchar(6) not null
);  

insert into UserLogins values
(1, "admin_account", SHA1(concat(salt, "AdminProsperLend2023")), "254896", "admin"),
(2, "test_user", SHA1(concat(salt, "password123")), "145896", "user"),
(3, "test_user2", SHA1(concat(salt, "password")), "465987", "user2");

select * from UserLogins;



create table InterestDeductions (
interestDeductionId int auto_increment primary key,
items varchar(50) not null,
deductionAmount decimal(4,2)
);

insert into InterestDeductions values 
(1, "Carbon neutral", 1),
(2, "Diversity", 1),
(3, "Equity", 1),
(4, "Community Outreach", 1),
(5, "Ethically Sourced", 1);

select * from InterestDeductions;



-- DROP TABLE Messages;
CREATE TABLE Messages (
  messageId INT AUTO_INCREMENT,
  userEmail VARCHAR(100),
  userName VARCHAR(100),
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));
  
  SELECT * FROM MESSAGES;


CREATE TABLE Businesses (
businessId INT AUTO_INCREMENT PRIMARY KEY,
userLoginId INT,
businessName VARCHAR(100),
businessAdminEmail VARCHAR(100),
merchantId LONG,
FOREIGN KEY (userLoginId) REFERENCES UserLogins(userLoginId)
PRIMARY KEY 
);

INSERT INTO Businesses (businessId, userLoginId, businessName, businessAdminEmail, merchantId)
VALUES
    (101, 1, 'GreenTech Solutions', 'admin@greentechsolutions.com', 123456789),
    (102, 2, 'EcoWise Enterprises', 'admin@ecowiseenterprises.com', 987654321),
    (103, 1, 'Sustainable Harvest Co.', 'admin@sustainableharvestco.com', 456789123);

SELECT * FROM BUSINESSES;



-- Create the "loans" table
CREATE TABLE loans (
  loanID INT  AUTO_INCREMENT,
  loanStatus VARCHAR(10),
  amount DOUBLE(10, 2),
  interest DOUBLE(5, 2),
  businessID INT,
  loanDate DATE,
  FOREIGN KEY (businessID) REFERENCES businesses(businessID),
  PRIMARY KEY (loanID)
);

-- Insert sample values into the "loans" table
INSERT INTO loans (loanStatus, amount, interest, businessID, loanDate)
VALUES
  ('approved', 5000.00, 0.05, 101, '2023-07-01'),
  ('approved', 10000.00, 0.06, 102, '2023-07-05'),
  ('declined', 2000.00, 0.04, 103, '2023-07-08');

SELECT * FROM LOANS;



-- DROP TABLE Transactions;
CREATE TABLE Transactions (
  transactionId INT AUTO_INCREMENT,
  loanId INT, CONSTRAINT FOREIGN KEY (loanId) REFERENCES Loans(loanId) ON UPDATE CASCADE ON DELETE CASCADE,
  amount DOUBLE,
  transactionDate DATE,
  CONSTRAINT PK_transactionId PRIMARY KEY (transactionId));
  
  INSERT INTO Transactions (transactionId, loanId, amount, transactionDate) VALUES
(101, 1, 10000.00, "2023-06-01"),
(102, 2, 5000.00, "2021-07-01"),
(103, 3, 13000.00, "2023-07-01");

SELECT * FROM TRANSACTIONS;



CREATE TABLE loanDeductions (
  loanId INT,
  interestDeductionId INT,
  FOREIGN KEY (loanId) REFERENCES Loans(loanId),
  FOREIGN KEY (interestDeductionId) REFERENCES InterestDeductions(interestDeductionId)
);


INSERT INTO loanDeductions (loanId, interestDeductionId)
VALUES
  (1, 1), 
  (2, 2), 
  (3, 3); 
  
  SELECT * FROM LOANDEDUCTIONS;

