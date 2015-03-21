CREATE TABLE Session (
  id char(36) NOT NULL,
  externalId char(36) NOT NULL,
  userId char(36) NOT NULL,
  appType varchar(512) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `externalId` (`externalId`)
)