CREATE SCHEMA IF NOT EXISTS `webshopmusicdb` DEFAULT CHARACTER SET utf8 ;
USE webshopmusicdb;

DROP TABLE IF EXISTS `orderline`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `customer`;

DROP TABLE IF EXISTS `discount`;
DROP TABLE IF EXISTS `instrument`;
DROP TABLE IF EXISTS `brand`;


DROP TABLE IF EXISTS `tcategory`;
DROP TABLE IF EXISTS `language`;
DROP TABLE IF EXISTS `category`;


CREATE TABLE `customer` (
    `id_customer` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(45) UNIQUE,
    `email` varchar(45) UNIQUE,
    `firstname` varchar(45) not null,
    `lastname` varchar(45) not null,
    `phone` varchar(45),
    `password` text not null,
    `postcode` int not null,
    `country` varchar(100) not null,
    `city` varchar(100) not null,
    `number_house` varchar(10) not null,
    `street` varchar(100) not null,
    `authorities` varchar(100)  default 'ROLE_USER',
    `account_non_expired` boolean   default 1,
    `account_non_locked` boolean default 1,
    `credentials_non_expired` boolean  default 1,
    `enabled` boolean default 1
);

CREATE TABLE `order` ( 
	`id_order` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ordered_at` date,
    `is_order` boolean,
    `fk_customer` int not null,
    CONSTRAINT `fk_customer` FOREIGN key (`fk_customer`) REFERENCES  `customer` (`id_customer`)
);


CREATE TABLE `brand` ( 
	`id_brand` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(250) not null unique
);

CREATE TABLE `category` ( 
	`id_category` VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE `language` ( 
	`id_language` VARCHAR(2) NOT NULL PRIMARY KEY
);

CREATE TABLE `tcategory` ( 
	`id_translation` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null,
    `fk_category` varchar(50) not null,
    `fk_language` varchar(2) not null,
    CONSTRAINT `fk_language` FOREIGN key (`fk_language`) REFERENCES  `language` (`id_language`),
    CONSTRAINT `fk_category` FOREIGN key (`fk_category`) REFERENCES  `category` (`id_category`)
);

CREATE TABLE `instrument` ( 
	`id_instrument` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null unique,
    `description` text,
    `price` double not null unique,
    `fk_category` varchar(50) not null,
    `fk_brand` int not null,
    CONSTRAINT `fk_category_in` FOREIGN key (`fk_category`) REFERENCES  `category` (`id_category`),
    CONSTRAINT `fk_brand` FOREIGN key (`fk_brand`) REFERENCES  `brand` (`id_brand`)
);

CREATE TABLE `orderline` (
	`id_orderline` int not null primary key,
    `price_product` double not null,
    `quantity` int not null default 1 check( `quantity` > 0),
    `percentage_discount` double check((`percentage_discount` between 0.0 AND 1.0 ) OR (`percentage_discount` = null)),
    `fk_order` int not null,
	`fk_instrument` int not null,
	CONSTRAINT `fk_order` FOREIGN key (`fk_order`) REFERENCES  `order` (`id_order`),
    CONSTRAINT `fk_instrument` FOREIGN key (`fk_instrument`) REFERENCES  `instrument` (`id_instrument`)
);

CREATE TABLE `discount` ( 
	`id_discount` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `percentage_discount` double check(`percentage_discount` between 0.0 AND 1.0),
    `start_at` timestamp,
    `end_at` timestamp,
    `fk_instrument` int not null,
    CONSTRAINT `fk_instrument_discount` FOREIGN key (`fk_instrument`) REFERENCES  `instrument` (`id_instrument`)
);

INSERT INTO customer(username, email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("admin","email@email.com","admin","adminLastname","2222","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_ADMIN", 1,1,1,1);
 
 INSERT INTO customer(username,email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("customer","customer@email.com","customer","customerLastname","5555","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_USER", 1,1,1,1);
 
 INSERT INTO customer(username,email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("locked","locked@email.com","locked","locker","6666","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_USER", 0,0,0,0);
 
 INSERT INTO category VALUES ("guitar");
 INSERT INTO category VALUES ("drum");
 INSERT INTO category VALUES ("piano");
 INSERT INTO category VALUES ("others");
 
 INSERT INTO `language` VALUES("fr");
 INSERT INTO `language` VALUES("en");
 
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Guitare", "guitar", "fr");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Batterie", "drum", "fr");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Piano", "piano", "fr");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Autres", "others", "fr");
 
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Guitar", "guitar", "en");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Drum", "drum", "en");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Piano", "piano", "en");
 INSERT INTO tcategory(`name`, fk_category, fk_language) VALUES ("Others", "others", "en");
 
 
 -- Guitare --
INSERT INTO brand(`name`) VALUES ("Yamaha");
INSERT INTO brand(`name`) VALUES ("Fender");
INSERT INTO brand(`name`) VALUES ("Takamine");
INSERT INTO brand(`name`) VALUES ("Cordoba");
INSERT INTO brand(`name`) VALUES ("Ibanez");
INSERT INTO brand(`name`) VALUES ("Eagletone");

-- drum --
INSERT INTO brand(`name`) VALUES ("Gretsch");
INSERT INTO brand(`name`) VALUES ("Pearl");
INSERT INTO brand(`name`) VALUES ("Tama");
INSERT INTO brand(`name`) VALUES ("Ludwig drums");
INSERT INTO brand(`name`) VALUES ("Sonor");
INSERT INTO brand(`name`) VALUES ("Mapex");

-- piano --
INSERT INTO brand(`name`) VALUES ("Steinways & Sons");
INSERT INTO brand(`name`) VALUES ("BLÜTHNER");
INSERT INTO brand(`name`) VALUES ("BÖSENDORFER");

-- instrument --
-- Yamaha --
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SU 7", "", 30299.99, 1, "piano");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SU118C", "", 18000.0, 1, "piano");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SE132", "", 23775.0, 1, "piano");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SE122", "", 19769.0, 1, "piano");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("b3", "", 7499.99, 1, "piano");

INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("A5R ARE", "", 2252.0, 1, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("AC5R", "", 2252.00 , 1, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("A5M ARE", "", 2109.00 , 1, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SG1820", "", 3705.00 , 1, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SG1820A", "", 3705.00 , 1, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("SG1802", "", 3705.00 , 1, "guitar");

INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("PHX", "", 6999.99 , 1, "drum");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES ("DTX10K-X Real Wood / Black Forest", "", 4599.99 , 1, "drum");


-- FENDER --
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`LIMITED EDITION VINTERA '70S TELECASTER DELUXE, LAKE PLACID BLUE`, "", 1249.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`JV Modified '60s Stratocaster`, "", 1449.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`American Acoustasonic Telecaster All-Mahogany`, "", 1999.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`60th Anniversary Ultra Luxe Jaguar`, "",2899.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Contemporary Stratocaster Special HT`, "",499.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Contemporary Stratocaster Special`, "",499.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Contemporary Telecaster RH`, "",499.99 , 2, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Mustang 90`, "",699.99 , 2, "guitar");

INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Ampli audio - Acoustasonic 15`, "",199.99 , 2, "others");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Ampli audio - Acoustasonic 40`, "",299.99 , 2, "others");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Ampli audio - ’68 Custom Deluxe Reverb`, "",1599.99 , 2, "others");

-- Takamine --
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Takamine GD30CE12 Natural`, "",444.00 , 3, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Takamine GN20CE NS2`, "",389.88 , 3, "guitar");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Takamine EF341SC Black`, "",1199.99 , 3, "guitar");

-- Gretsch --

INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Gretsch Drums RN2-E8246-STB Renown Satin Tobacco Burst`, "",1199.99 , 7, "drum");
INSERT INTO instrument(`name`, `description`,`price`, `fk_brand`, `fk_category`) VALUES (`Gretsch Drums G4164 Solid Aluminum Shell`, "",859.99 , 7, "drum");

