CREATE SCHEMA IF NOT EXISTS `webshopmusicdb` DEFAULT CHARACTER SET utf8 ;
USE webshopmusicdb;

DROP TABLE IF EXISTS `orderline`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `customer`;

DROP TABLE IF EXISTS `instrument`;
DROP TABLE IF EXISTS `brand`;
DROP TABLE IF EXISTS `discount`;

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


CREATE TABLE `discount` ( 
	`id_discount` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `percentage_discount` double check(`percentage_discount` between 0.0 AND 1.0),
    `start_at` timestamp,
    `end_at` timestamp
);

CREATE TABLE `brand` ( 
	`id_brand` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(250) not null
);

CREATE TABLE `category` ( 
	`id_category` INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE `language` ( 
	`id_language` INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE `tcategory` ( 
	`id_translation` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null unique,
    `fk_category` int not null,
    `fk_language` int not null,
    CONSTRAINT `fk_language` FOREIGN key (`fk_language`) REFERENCES  `language` (`id_language`),
    CONSTRAINT `fk_category` FOREIGN key (`fk_category`) REFERENCES  `category` (`id_category`)
);

CREATE TABLE `instrument` ( 
	`id_instrument` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) not null unique,
    `description` text,
    `price` double not null unique,
    `fk_category` int not null,
    `fk_discount` int not null,
    `fk_brand` int not null,
    CONSTRAINT `fk_category_in` FOREIGN key (`fk_category`) REFERENCES  `category` (`id_category`),
    CONSTRAINT `fk_discount` FOREIGN key (`fk_discount`) REFERENCES  `discount` (`id_discount`),
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


INSERT INTO customer(username, email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("admin","email@email.com","admin","adminLastname","2222","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_ADMIN", 1,1,1,1);
 
 INSERT INTO customer(username,email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("customer","customer@email.com","customer","customerLastname","5555","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_USER", 1,1,1,1);
 
 INSERT INTO customer(username,email,firstname,lastname,phone,`password`,postcode,country,city, number_house, street, authorities,`account_non_expired`, `account_non_locked`, `credentials_non_expired`,`enabled`)
 VALUES ("locked","locked@email.com","locked","locker","6666","$2a$10$qECA6EH5ND2xA.PJ5qeMnOUo.g55rBIIWQagvlHxXv4hNbBoDjTiG",6700,"Belgique","Arlon", 10, "rue d'arlon","ROLE_USER", 0,0,0,0);