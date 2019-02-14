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
	PRIMARY KEY (`id`),
	UNIQUE KEY unique_external_id (external_id)
);

CREATE TABLE `discount_rules` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`external_id` CHAR(16) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`rule` TEXT NOT NULL,
	`type` ENUM('MAX_DISCOUNT','DISCOUNT')
)

INSERT INTO `discount_rules` VALUES
	(NULL, 'RUL-AAAAAAAAAAAA', '5% discount on User birthday', 'const now = new Date(); const sameDay = user.date_of_birth.getDate() == now.getDate(); const sameMonth = user.date_of_birth.getMonth() == now.getMonth() ; if (sameDay && sameMonth) { discount = 0.05; }', 'DISCOUNT'),
	(NULL, 'RUL-BBBBBBBBBBBB', '10% discount on 2019 Black Friday', 'const now = new Date(); if (now.getTime() == new Date(2019, 11, 25).getTime() ) { discount = 0.1; }', 'DISCOUNT'),
	(NULL, 'RUL-BBBBBBBBBBBB', 'Max Discount of 10%', 'discount = 0.1', 'MAX_DISCOUNT');

INSERT INTO `users` VALUES 
	(NULL,'USR-AAAAAAAAAAAA','John','Doe','2000-10-31'),
	(NULL,'USR-BBBBBBBBBBBB','Jane','Doe','1995-02-25'),
	(NULL,'USR-CCCCCCCCCCCC','Forrest','Gump','2000-10-31'),
	(NULL,'USR-DDDDDDDDDDDD','Wade','Wilson','1985-03-12');

INSERT INTO `products` VALUES
	(NULL,'PRO-AAAAAAAAAAAA',300000,'iPhone 8','An overpriced phone with a fanbase'),
	(NULL,'PRO-BBBBBBBBBBBB',200000,'Xiaomi Mi 8','An underpriced phone with a fanbase'),
	(NULL,'PRO-CCCCCCCCCCCC',10000,'Nokia','An very resistent phone made of adamantium'),
	(NULL,'PRO-DDDDDDDDDDDD',50000,'AirPods','Wireless earbuds for twice the price. Nice!');
