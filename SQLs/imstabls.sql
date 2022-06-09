DROP SCHEMA `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

INSERT INTO customers Values (1, "Adi", "Pan"),(2, "Sam", "Noll"),(3, "Kate", "Hund"),(4, "Chris", "Hem");

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `price` INT(6) NOT NULL,
    PRIMARY KEY (`item_id`)
);

INSERT INTO items Values(1, "Bat", 40), (2, "Ball", 13), (3, "stumps", 15), (4, "helmet", 40);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers`(`customer_id`)
);
INSERT INTO orders Values (1,2),(2,4),(3,1),(4,2),(5,4),(6,2),(7,3),(8,4),(9,1),(10,3), (11,3);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `orderitems_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `order_id` INT(40) NOT NULL, 
    `item_id` INT(40) NOT NULL,
    `item_quantity` INT (4) NOT NULL, 
    PRIMARY KEY (`orderitems_id`),
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`orders`(`order_id`),
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items`(`item_id`)
);

INSERT INTO order_items Values (1,1,2,29),(2,1,4,23),(3,2,2,20),(4,2,4,39),(6,2,3,45),(7,4,3,29),(8,2,3,2),(9,1,4,1),(10,6,2,15),(11,6,1,2),(12,7,3,1),(13,8,2,1),(14,8,1,2),(15,8,4,2),(16,9,1,3),(17,9,2,1),(18,4,2,32),(19,3,4,23),(20,2,4,12);

-- SELECT orders.customer_id, first_name, order_items.order_id,items.item_id,item_name,item_quantity,price, sum(price*item_quantity) AS total FROM order_items
-- Join orders on orders.order_id = order_items.order_id
-- Join customers ON customers.customer_id = orders.customer_id
-- Join items on order_items.item_id = items.item_id
-- 	Group By order_id;
