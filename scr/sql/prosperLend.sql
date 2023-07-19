DROP DATABASE IF EXISTS TestProjectProsperLend;
CREATE DATABASE TestProjectProsperLend;
USE TestProjectProsperLend;

create table UserLogin (
userLoginId int auto_increment primary key,
userLoginName varchar(30) not null,
passcode varchar(500) not null,
salt varchar(6) not null,
userRole varchar(6) not null
);  

insert into UserLogin values
(1, "admin_account", SHA1(concat(salt, "AdminProsperLend2023")), "254896", "admin"),
(2, "test_user", SHA1(concat(salt, "password123")), "145896", "user");

select * from UserLogin;

create table InterestDeduction (
interestDeductionId int auto_increment primary key,
items varchar(50) not null,
deductionAmount decimal(4,2)
);

insert into InterestDeduction values 
(1, "Carbon neutral", 1),
(2, "Diversity", 1),
(3, "Equity", 1),
(4, "Community Outreach", 1),
(5, "Ethically Sourced", 1);

select * from InterestDeduction;

-- DROP TABLE Messages;
CREATE TABLE Messages (
  messageId INT AUTO_INCREMENT,
  userLoginId INT, CONSTRAINT FOREIGN KEY (userLoginId) REFERENCES Businesses(userLoginId) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));

-- DROP TABLE Transactions;
CREATE TABLE Transactions (
  transactionId INT AUTO_INCREMENT,
  loanId INT, CONSTRAINT FOREIGN KEY (loanId) REFERENCES Loans(loanId) ON UPDATE CASCADE ON DELETE CASCADE,
  amount DOUBLE,
  transactionDate DATE,
  CONSTRAINT PK_transactionId PRIMARY KEY (transactionId));

-- Create the "loans" table
CREATE TABLE loans (
  loanID INT PRIMARY KEY,
  status VARCHAR(10),
  amount DECIMAL(10, 2),
  interest DECIMAL(5, 2),
  businessID INT,
  loanDate DATE,
  FOREIGN KEY (businessID) REFERENCES business(businessID)
);

-- Insert sample values into the "loans" table
INSERT INTO loans (loanID, status, amount, interest, businessID, loanDate)
VALUES
  (1, 'approved', 5000.00, 0.05, 1, '2023-07-01'),
  (2, 'approved', 10000.00, 0.06, 2, '2023-07-05'),
  (3, 'declined', 2000.00, 0.04, 3, '2023-07-08');
  
-- DROP TABLE Businesses;
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
    (1, 101, 'GreenTech Solutions', 1001, 'admin@greentechsolutions.com', 123456789),
    (2, 102, 'EcoWise Enterprises', 1002, 'admin@ecowiseenterprises.com', 987654321),
    (3, 103, 'Sustainable Harvest Co.', 1003, 'admin@sustainableharvestco.com', 456789123),
    (4, 104, 'CleanEnergy Innovations', 1004, 'admin@cleanenergyinnovations.com', 789456123),
    (5, 105, 'Nature\'s Bounty Foods', 1005, 'admin@naturesbountyfoods.com', 321654987),
    (6, 106, 'EarthGuard Technologies', 1006, 'admin@earthguardtechnologies.com', 654789321),
    (7, 107, 'RenewWell Fitness', 1007, 'admin@renewwellfitness.com', 987123456),
    (8, 108, 'GreenGrove Builders', 1008, 'admin@greengrovebuilders.com', 741258963),
    (9, 109, 'EnviroTech Solutions', 1009, 'admin@envirotechsolutions.com', 852369741),
    (10, 110, 'EcoBlend Clothing', 1010, 'admin@ecoblendclothing.com', 963147852);

SELECT * FROM BUSINESSES;
