DROP TABLE IF EXISTS order_items;

DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS items;

DROP TABLE IF EXISTS customers;



CREATE TABLE IF NOT EXISTS customers (
`customer_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(40) DEFAULT NULL,
`surname` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`customer_id`)
);



CREATE TABLE IF NOT EXISTS items (
`item_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) NOT NULL,
`price` INT(6) NOT NULL,
PRIMARY KEY (`item_id`)
);


CREATE TABLE IF NOT EXISTS orders (
`order_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
`customer_id` INT(11) NOT NULL,
PRIMARY KEY (`order_id`),
FOREIGN KEY (`customer_id`) REFERENCES `customers`(`customer_id`)
);


CREATE TABLE IF NOT EXISTS order_items (
`orderitems_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
`order_id` INT(40) NOT NULL,
`item_id` INT(40) NOT NULL,
`item_quantity` INT (4) NOT NULL,
PRIMARY KEY (`orderitems_id`),
FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`),
FOREIGN KEY (`item_id`) REFERENCES `items`(`item_id`)
);