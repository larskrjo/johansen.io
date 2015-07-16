CREATE TABLE User (
  id char(36) NOT NULL,
  email varchar(250) NOT NULL,
  firstName varchar(512) NOT NULL,
  lastName varchar(512) NOT NULL,
  profilePicture varchar(512) NOT NULL,
  locale varchar(512) NOT NULL,
  password varchar(512),
  lastUpdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
)