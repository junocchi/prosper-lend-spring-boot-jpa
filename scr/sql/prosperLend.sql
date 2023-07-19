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
