/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table discount_rules
# ------------------------------------------------------------

DROP TABLE IF EXISTS `discount_rules`;

CREATE TABLE `discount_rules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `external_id` char(16) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rule` text NOT NULL,
  `type` enum('MAX_DISCOUNT','DISCOUNT') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `discount_external_id` (`external_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `discount_rules` WRITE;
/*!40000 ALTER TABLE `discount_rules` DISABLE KEYS */;

INSERT INTO `discount_rules` (`id`, `external_id`, `name`, `rule`, `type`)
VALUES
	(1,'RUL-AAAAAAAAAAAA','5% discount on User birthday','const sameDay = ( user.dateOfBirth.getDate() == now.getDate() )\nconst sameMonth = (user.dateOfBirth.getMonth() == now.getMonth()); \n\nif (sameDay && sameMonth) { \n	percentage = 0.05; \n}','DISCOUNT'),
	(2,'RUL-BBBBBBBBBBBB','10% discount on 2019 Black Friday','const now = new Date(); if (now.getTime() == new Date(2019, 11, 25).getTime() ) { percentage = 0.1; }','DISCOUNT'),
	(3,'RUL-CCCCCCCCCCCC','Max Discount of 10%','percentage = 0.10\n','MAX_DISCOUNT');

/*!40000 ALTER TABLE `discount_rules` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table products
# ------------------------------------------------------------

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `external_id` char(16) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;

INSERT INTO `products` (`id`, `external_id`, `price`, `title`, `description`)
VALUES
	(1,'PRO-AAAAAAAAAAAA',300000,'iPhone 8','An overpriced phone with a fanbase'),
	(2,'PRO-BBBBBBBBBBBB',200000,'Xiaomi Mi 8','An underpriced phone with a fanbase'),
	(3,'PRO-CCCCCCCCCCCC',10000,'Nokia','An very resistent phone made of adamantium'),
	(4,'PRO-DDDDDDDDDDDD',50000,'AirPods','Wireless earbuds for twice the price. Nice!');

/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `external_id` char(16) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_external_id` (`external_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `external_id`, `first_name`, `last_name`, `date_of_birth`)
VALUES
	(1,'USR-AAAAAAAAAAAA','John','Doe','2000-02-15'),
	(2,'USR-BBBBBBBBBBBB','Jane','Doe','1995-02-25'),
	(3,'USR-CCCCCCCCCCCC','Forrest','Gump','2000-10-31'),
	(4,'USR-DDDDDDDDDDDD','Wade','Wilson','1985-03-12');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
