DROP DATABASE IF EXISTS lars_test;
CREATE DATABASE IF NOT EXISTS lars_test;
USE lars_test;

-- ------------------------------------------------------
--  DDL for Table ELEMENTS
-- ------------------------------------------------------

  CREATE TABLE ELEMENTS
   (	`ID` INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, 
	`NAME` VARCHAR(100) NOT NULL, 
	`HTML` VARCHAR(4000)
   ) 
  ;
-- ------------------------------------------------------
--  DDL for Table PAGES
-- ------------------------------------------------------

  CREATE TABLE PAGES
   (	`ID` INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, 
	`NAME` VARCHAR(100) NOT NULL
   ) 
  ;
-- ------------------------------------------------------
--  DDL for Table PAGES_SECTIONS_REF
-- ------------------------------------------------------

  CREATE TABLE PAGES_SECTIONS_REF
   (	`PAGES_ID` INTEGER NOT NULL,
	`SECTIONS_ID` INTEGER NOT NULL, 
	`SEQ_NUM` INTEGER DEFAULT 1 NOT NULL
   ) 
  ;
-- ------------------------------------------------------
--  DDL for Table SECTIONS
-- ------------------------------------------------------

  CREATE TABLE SECTIONS 
   (	`ID` INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, 
	`NAME` VARCHAR(100) NOT NULL
   ) 
  ;
-- ------------------------------------------------------
--  DDL for Table SECTIONS_ELEMENTS_REF
-- ------------------------------------------------------

  CREATE TABLE SECTIONS_ELEMENTS_REF
   (	`SECTIONS_ID` INTEGER NOT NULL, 
	`ELEMENTS_ID` INTEGER NOT NULL, 
	`SEQ_NUM` INTEGER DEFAULT 1 NOT NULL, 
	`CLASS_TYPE` VARCHAR(100) DEFAULT 'full-col' NOT NULL
   ) 
  ;

-- ------------------------------------------------------
--  Constraints for Table ELEMENTS
-- ------------------------------------------------------

  ALTER TABLE ELEMENTS AUTO_INCREMENT = 295;
-- ------------------------------------------------------
--  Constraints for Table PAGES
-- ------------------------------------------------------

  ALTER TABLE PAGES AUTO_INCREMENT = 62;

-- ------------------------------------------------------
--  Constraints for Table SECTIONS
-- ------------------------------------------------------

  ALTER TABLE SECTIONS AUTO_INCREMENT = 188;
