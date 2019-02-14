CREATE TABLE `products` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`external_id` CHAR(16),
	`price` INT NOT NULL,
	`title` VARCHAR(100) NOT NULL,
	`description` VARCHAR(255)
);

CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`external_id` CHAR(16) NOT NULL,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`date_of_birth` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `users` VALUES 
	(NULL,'USR-010203040506','John','Doe','2000-10-31'),
	(NULL,'USR-020304050607','Jane','Doe','1995-02-25'),
	(NULL,'USR-030405060708','Forrest','Gump','2000-10-31'),
	(NULL,'USR-040506070809','Wade','Wilson','1985-03-12');

INSERT INTO `products` VALUES 
	(NULL,'PRO-010203040506',10000,'','2000-10-31');