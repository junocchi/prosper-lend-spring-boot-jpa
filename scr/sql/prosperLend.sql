DROP DATABASE IF EXISTS TestProjectProsperLend;
CREATE DATABASE TestProjectProsperLend;
USE TestProjectProsperLend;

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

-- DROP TABLE Messages;
CREATE TABLE Messages (
  messageId INT AUTO_INCREMENT,
  userLoginId INT, CONSTRAINT FOREIGN KEY (userLoginId) REFERENCES Business(userLoginId) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));


-- DROP TABLE Business;
CREATE TABLE Business (
businessId INT PRIMARY KEY,
userLoginId INT,
businessName VARCHAR(100),
loanId INT,
businessAdminEmail VARCHAR(100),
merchantId LONG,
FOREIGN KEY (userLoginId) REFERENCES UserLogin(userLoginId)
);

INSERT INTO Business (businessId, userLoginId, businessName, loanId, businessAdminEmail, merchantId)
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

SELECT * FROM BUSINESS;

