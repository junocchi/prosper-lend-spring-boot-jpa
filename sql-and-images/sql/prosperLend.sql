DROP DATABASE IF EXISTS TestProjectProsperLend;
CREATE DATABASE TestProjectProsperLend;
USE TestProjectProsperLend;

DROP DATABASE IF EXISTS ProjectProsperLend;
CREATE DATABASE ProjectProsperLend;
USE ProjectProsperLend;

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
  userLoginId INT, CONSTRAINT FOREIGN KEY (userLoginId) REFERENCES userLogins(userLoginId) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));
  
  SELECT * FROM MESSAGES;


CREATE TABLE Businesses (
businessId INT PRIMARY KEY,
userLoginId INT,
businessName VARCHAR(100),
loanId INT,
businessAdminEmail VARCHAR(100),
merchantId LONG,
FOREIGN KEY (userLoginId) REFERENCES UserLogins(userLoginId)
);

INSERT INTO Businesses (businessId, userLoginId, businessName, loanId, businessAdminEmail, merchantId)
VALUES
    (101, 1, 'GreenTech Solutions', 1001, 'admin@greentechsolutions.com', 123456789),
    (102, 2, 'EcoWise Enterprises', 1002, 'admin@ecowiseenterprises.com', 987654321),
    (103, 1, 'Sustainable Harvest Co.', 1003, 'admin@sustainableharvestco.com', 456789123);

SELECT * FROM BUSINESSES;



-- Create the "loans" table
CREATE TABLE loans (
  loanID INT PRIMARY KEY,
  loanStatus VARCHAR(10),
  amount DECIMAL(10, 2),
  interest DECIMAL(5, 2),
  businessID INT,
  loanDate DATE,
  FOREIGN KEY (businessID) REFERENCES businesses(businessID)
);

-- Insert sample values into the "loans" table
INSERT INTO loans (loanID, loanStatus, amount, interest, businessID, loanDate)
VALUES
  (1001, 'approved', 5000.00, 0.05, 101, '2023-07-01'),
  (1002, 'approved', 10000.00, 0.06, 102, '2023-07-05'),
  (1003, 'declined', 2000.00, 0.04, 103, '2023-07-08');

SELECT * FROM LOANS;



-- DROP TABLE Transactions;
CREATE TABLE Transactions (
  transactionId INT AUTO_INCREMENT,
  loanId INT, CONSTRAINT FOREIGN KEY (loanId) REFERENCES Loans(loanId) ON UPDATE CASCADE ON DELETE CASCADE,
  amount DOUBLE,
  transactionDate DATE,
  CONSTRAINT PK_transactionId PRIMARY KEY (transactionId));
  
  INSERT INTO Transactions (transactionId, loanId, amount, transactionDate) VALUES
(101, 1001, 10000.00, "2023-06-01"),
(102, 1002, 5000.00, "2021-07-01"),
(103, 1003, 13000.00, "2023-07-01");

SELECT * FROM TRANSACTIONS;



CREATE TABLE loanDeductions (
  loanId INT,
  interestDeductionId INT,
  FOREIGN KEY (loanId) REFERENCES Loans(loanId),
  FOREIGN KEY (interestDeductionId) REFERENCES InterestDeductions(interestDeductionId)
);


INSERT INTO loanDeductions (loanId, interestDeductionId)
VALUES
  (1001, 1), 
  (1002, 2), 
  (1003, 3); 
  
  SELECT * FROM LOANDEDUCTIONS;

