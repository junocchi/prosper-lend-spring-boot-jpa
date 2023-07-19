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

CREATE TABLE Messages (
  messageId INT AUTO_INCREMENT,
  userLoginId INT, CONSTRAINT FOREIGN KEY (userLoginId) REFERENCES Business(userLoginId) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));
  

