DROP DATABASE IF EXISTS TestProjectProsperLend;
CREATE DATABASE TestProjectProsperLend;
USE TestProjectProsperLend;

DROP DATABASE IF EXISTS ProjectProsperLend;
CREATE DATABASE ProjectProsperLend;
USE ProjectProsperLend;

CREATE TABLE Messages (
  messageId INT AUTO_INCREMENT,
  userLoginId INT, CONSTRAINT FOREIGN KEY (userLoginId) REFERENCES Business(userLoginId) ON UPDATE CASCADE ON DELETE CASCADE,
  message VARCHAR(255),
  CONSTRAINT PK_messageId PRIMARY KEY (messageId));
  