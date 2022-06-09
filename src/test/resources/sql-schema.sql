DROP SCHEMA `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `price` INT(6) NOT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers`(`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `orderitems_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `order_id` INT(40) NOT NULL, 
    `item_id` INT(40) NOT NULL,
    `item_quantity` INT (4) NOT NULL, 
    PRIMARY KEY (`orderitems_id`),
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`orders`(`order_id`),
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items`(`item_id`)
);