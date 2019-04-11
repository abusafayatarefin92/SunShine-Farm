-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.40-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sunshinefarm2
--

CREATE DATABASE IF NOT EXISTS sunshinefarm2;
USE sunshinefarm2;

--
-- Definition of table `crops`
--

DROP TABLE IF EXISTS `crops`;
CREATE TABLE `crops` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `duration` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `per_unit_selling_price` double DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crops`
--

/*!40000 ALTER TABLE `crops` DISABLE KEYS */;
INSERT INTO `crops` (`id`,`duration`,`name`,`per_unit_selling_price`,`product_code`,`quantity`) VALUES 
 (1,'Winter','Broccoli',50,'10001',1000),
 (2,'Spring','Cabbage',50,'10002',1000),
 (3,'Late Autumn - Winter','Carrots',50,'10003',1000),
 (4,'Spring','Cauliflower',50,'10004',1000),
 (5,'October-November','Wheat',50,'10005',1000),
 (6,'June-July','Cotton',100,'10006',1000),
 (7,'October-November','Jute',200,'10007',1000),
 (8,'October-November','Sugarcane',150,'10008',1000),
 (9,'March-June','Coffee',500,'10009',1000);
/*!40000 ALTER TABLE `crops` ENABLE KEYS */;


--
-- Definition of table `crops_summary`
--

DROP TABLE IF EXISTS `crops_summary`;
CREATE TABLE `crops_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_quantity` int(11) DEFAULT NULL,
  `last_update` date DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `sales_quantity` int(11) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hs5njjt73pdt1quinahnvick1` (`product_code`),
  UNIQUE KEY `UK_po8smxmmkrebv6p3f54p7lqxv` (`product_name`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crops_summary`
--

/*!40000 ALTER TABLE `crops_summary` DISABLE KEYS */;
INSERT INTO `crops_summary` (`id`,`available_quantity`,`last_update`,`product_code`,`product_name`,`sales_quantity`,`total_quantity`) VALUES 
 (1,50,'2019-03-10','10001','Broccoli',950,1000),
 (2,50,'2019-03-10','10002','Cabbage',950,1000),
 (3,50,'2019-03-10','10003','Carrots',950,1000),
 (4,50,'2019-03-10','10004','Cauliflower',950,1000),
 (5,500,'2019-03-13','10005','Wheat',500,1000),
 (6,500,'2019-03-13','10006','Cotton',500,1000),
 (7,500,'2019-03-13','10007','Jute',500,1000),
 (8,500,'2019-03-13','10008','Sugarcane',500,1000),
 (9,500,'2019-03-13','10009','Coffee',500,1000);
/*!40000 ALTER TABLE `crops_summary` ENABLE KEYS */;


--
-- Definition of table `designation`
--

DROP TABLE IF EXISTS `designation`;
CREATE TABLE `designation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `designation_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ab40di1ei0421webla3ahr5mc` (`designation_name`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `designation`
--

/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
INSERT INTO `designation` (`id`,`designation_name`) VALUES 
 (1,'Driver'),
 (2,'Farmer'),
 (3,'Security Guard'),
 (4,'Manager'),
 (5,'Executive');
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) DEFAULT NULL,
  `monthly_salary` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `starting_date` date DEFAULT NULL,
  `designation_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sm5olvg1ctp19dcrvbr755pi5` (`mobile`),
  KEY `FKcd520nbfuhck2u094el0j57hu` (`designation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`id`,`mobile`,`monthly_salary`,`name`,`starting_date`,`designation_id`) VALUES 
 (1,'0123456787',20000,'Azad Hossain','2019-03-09',1),
 (2,'0123456789',40000,'Jubaiyer Hossain','2019-03-09',4),
 (3,'0123456784',5000,'Mahabub-ur Rahman','2019-03-09',2),
 (4,'0123456788',20000,'Mehedee Hossain','2019-03-09',1),
 (5,'0123456782',5000,'Mehedi Haque','2019-03-09',2),
 (6,'0123456783',5000,'Mortuza Ahmed','2019-03-09',2),
 (7,'0123456785',10000,'Mostafiz-ur Rahman','2019-03-09',3),
 (8,'0123456786',10000,'Shofiqule Jobbar','2019-03-09',3),
 (9,'0123456780',5000,'Shohidul Islam','2019-03-09',2),
 (11,'0123456781',5000,'Zakir Hossain','2019-03-11',2),
 (12,'01743525594',25000,'Julqar Nain','2019-03-13',5);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `purchase_price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment`
--

/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` (`id`,`name`,`person_name`,`product_code`,`purchase_price`,`quantity`) VALUES 
 (1,'Blower','Jubaiyer','20005',1500,5),
 (2,'Brush Cutter','Jubaiyer','20004',15000,15),
 (3,'Chain Saw','Jubaiyer','20006',20000,5),
 (4,'Hand Push Brush','Jubaiyer','20001',20000,10),
 (5,'Turnar Tools Tiller Attatchment','Jubaiyer','20002',5000,15),
 (6,'Water Filter Pressure','Jubaiyer','20003',1000,20),
 (7,'Ojal Hand Push Brush','Julqar','20007',18000,10);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;


--
-- Definition of table `equipment_crops`
--

DROP TABLE IF EXISTS `equipment_crops`;
CREATE TABLE `equipment_crops` (
  `equipment_id` bigint(20) NOT NULL,
  `crops_id` bigint(20) NOT NULL,
  PRIMARY KEY (`equipment_id`,`crops_id`),
  KEY `FK8ngm7b33ud1ulhul28xd11oj0` (`crops_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment_crops`
--

/*!40000 ALTER TABLE `equipment_crops` DISABLE KEYS */;
INSERT INTO `equipment_crops` (`equipment_id`,`crops_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,3),
 (3,1),
 (3,2),
 (3,4),
 (4,2),
 (5,4),
 (6,1),
 (6,2),
 (6,3),
 (6,4),
 (7,5),
 (7,7),
 (7,8),
 (7,9);
/*!40000 ALTER TABLE `equipment_crops` ENABLE KEYS */;


--
-- Definition of table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `expense_name` varchar(255) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` (`id`,`amount`,`date`,`expense_name`,`person_name`) VALUES 
 (1,2000,'2019-03-09','Car-Fuel Expense','Azad'),
 (2,2500,'2019-03-09','Car-Fuel Expense','Mehedee'),
 (3,125000,'2019-03-09','Employee Salary','Jubaiyer'),
 (4,1000,'2019-03-17','Miscellaneous Expenses','Julqar'),
 (5,5000,'2019-03-09','Monthly Rent','Jubaiyer'),
 (6,3000,'2019-03-09','Utiliy Expenses','Jubaiyer');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;


--
-- Definition of table `insecticides`
--

DROP TABLE IF EXISTS `insecticides`;
CREATE TABLE `insecticides` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `purchase_price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `insecticides`
--

/*!40000 ALTER TABLE `insecticides` DISABLE KEYS */;
INSERT INTO `insecticides` (`id`,`name`,`person_name`,`product_code`,`purchase_price`,`quantity`) VALUES 
 (1,'Green Beauveria','Mahbub','30001',800,50),
 (2,'MMR Falidol Dust Household Insecticide','Mortuza','30005',600,50),
 (3,'Powerful Ant Killer Jallad Powder Pest Control','Zakir','30004',500,50),
 (4,'Sarovers neem \"O\" Care','Shohidul','30003',300,50),
 (5,'TATA Tafgor Demithoate Insecticide','Mehedi','30002',800,50);
/*!40000 ALTER TABLE `insecticides` ENABLE KEYS */;


--
-- Definition of table `insecticides_crops`
--

DROP TABLE IF EXISTS `insecticides_crops`;
CREATE TABLE `insecticides_crops` (
  `insecticides_id` bigint(20) NOT NULL,
  `crops_id` bigint(20) NOT NULL,
  PRIMARY KEY (`insecticides_id`,`crops_id`),
  KEY `FKcs4uibv5gp95c0swaongk3fet` (`crops_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `insecticides_crops`
--

/*!40000 ALTER TABLE `insecticides_crops` DISABLE KEYS */;
INSERT INTO `insecticides_crops` (`insecticides_id`,`crops_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,1),
 (2,4),
 (3,3),
 (4,2),
 (4,3),
 (5,1);
/*!40000 ALTER TABLE `insecticides_crops` ENABLE KEYS */;


--
-- Definition of table `pesticides`
--

DROP TABLE IF EXISTS `pesticides`;
CREATE TABLE `pesticides` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `purchase_price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesticides`
--

/*!40000 ALTER TABLE `pesticides` DISABLE KEYS */;
INSERT INTO `pesticides` (`id`,`name`,`person_name`,`product_code`,`purchase_price`,`quantity`) VALUES 
 (1,'Accon Organic Plant Pesticide','Mortuza','40003',400,40),
 (2,'Argo Plus','Zakir','40001',500,40),
 (3,'Liquide Bio Pesticide','Zakir','40006',700,40),
 (4,'Mahagro Natural & Organic Pesticide','Mehedi','40004',400,40),
 (5,'Organic Neem Oil','Shohidul','40007',700,40),
 (6,'Plant Immune Simulator','Mahbub','40005',400,40),
 (7,'TrustBuskate Neem Oil','Shohidul','40002',400,40);
/*!40000 ALTER TABLE `pesticides` ENABLE KEYS */;


--
-- Definition of table `pesticides_crops`
--

DROP TABLE IF EXISTS `pesticides_crops`;
CREATE TABLE `pesticides_crops` (
  `pesticides_id` bigint(20) NOT NULL,
  `crops_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pesticides_id`,`crops_id`),
  KEY `FK6due8aaowvmk6hux0mpii0sjv` (`crops_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesticides_crops`
--

/*!40000 ALTER TABLE `pesticides_crops` DISABLE KEYS */;
INSERT INTO `pesticides_crops` (`pesticides_id`,`crops_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,3),
 (3,4),
 (4,2),
 (4,3),
 (5,1),
 (5,4),
 (6,1),
 (6,2),
 (6,3),
 (7,2),
 (7,3),
 (7,4);
/*!40000 ALTER TABLE `pesticides_crops` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_name`) VALUES 
 (1,'CUSTOMERS'),
 (2,'ADMIN'),
 (3,'SUPERADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `per_unit_sales_price` double DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `sales_date` date DEFAULT NULL,
  `crops_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnmpe5wcmsq4c0949khg37rtxi` (`crops_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` (`id`,`per_unit_sales_price`,`product_code`,`product_name`,`quantity`,`sales_date`,`crops_id`) VALUES 
 (5,60,'10001','Broccoli',150,'2019-03-10',1),
 (6,60,'10002','Cabbage',150,'2019-03-10',2),
 (7,60,'10003','Carrots',150,'2019-03-10',3),
 (8,50,'10004','Cauliflower',150,'2019-03-10',4),
 (9,60,'10005','Wheat',500,'2019-03-13',5),
 (10,120,'10006','Cotton',500,'2019-03-13',6),
 (11,230,'10007','Jute',500,'2019-03-13',7),
 (12,160,'10008','Sugarcane',500,'2019-03-13',8),
 (13,550,'10009','Coffee',500,'2019-03-13',9);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `confirmation_token` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gj2fy3dcix7ph7k8684gka40c` (`name`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`confirmation_token`,`email`,`enabled`,`file_extension`,`file_name`,`file_path`,`file_size`,`mobile`,`name`,`password`,`registration_date`,`user_name`) VALUES 
 (1,'71b85cd7-d420-496a-bc39-8b995043618b','arefinsafayat92@gmail.com',0x01,'image/jpeg','new-3.jpg','images/new-3.jpg',92395,'01788857672','Safayat Arefin','$2a$10$aW2iDT51S3ExzYnaBB4ZHO11CFGFC3LTjOFmbVfOZLezxhMKUcbUC','2019-03-10','arefin'),
 (2,'b0b9dde9-9038-4bff-81ac-d7bc791cd82a','ariful@mail.com',0x01,'image/jpeg','new-images36718474_1755427607859157_1801922261674885120_n.jpg','images/new-images36718474_1755427607859157_1801922261674885120_n.jpg',41298,'0198765435','Ariful Hasan','$2a$10$GaCAuHO5WUkw6R4XyCQXg.J1Jtotok0QRrhZ1qVM3h324hDFabaZC','2019-03-10','ariful'),
 (3,'01266d03-bdb3-4567-858d-872d2b52bac1','jubaiyer@mail.com',0x01,'image/jpeg','new-jubaiyer.jpg','images/new-jubaiyer.jpg',16644,'0198765436','Jubaiyer Hossain','$2a$10$wCykUsQ4pBF8ezxhrZx5o.jhS1TiPk9yiaM0zsDhRxTha1IgtOZwK','2019-03-10','jubaiyer'),
 (6,'2588084a-54ca-4271-bb36-10580ad94f00','masud@mail.com',0x01,'image/jpeg','new-masud.jpg','images/new-masud.jpg',164304,'0198765433','Masud-ur Rahman','$2a$10$8eEOyMF90yxg1Av54jkk5eAgvoIuVwYsZH7esoUKHGd4cQI9S4KSi','2019-03-11','masud'),
 (7,'e081e1a6-eea6-40d1-a306-aeadea2956f8','yeasin@mail.com',0x01,'image/jpeg','new-shuvo.jpg','images/new-shuvo.jpg',138789,'0198765434','Yeasin Bhuiyan','$2a$10$nvSzNTCca55c26EIvxpmheAbDlK/fGbjGtSw8RIVyh/QGiQQOiLwy','2019-03-11','yeasin'),
 (9,'45b28767-1045-4cfe-82e0-c9d247062043','ahmedzakir1092@gmail.com',0x01,'image/jpeg','new-zakir.jpg','images/new-zakir.jpg',55365,'01922525289','Zakir Ahmed','$2a$10$PJVC71HDn7TbVtr7sGSQmODlCNjti8722F10mHfBFpD0LWaOW2ORe','2019-03-13','zakir'),
 (11,'13d1f5d1-9f64-4124-a76e-30f5aa54f614','abusafayatarefin92@gmail.com',0x01,NULL,NULL,NULL,0,'01515213836','Abu Safayat Arefin','$2a$10$98WxtFDP1YXimTE.oekhF.zwQ6HEsiYP5Y7Z.uiH/pUwt9IaTkAX.','2019-03-18','safayat');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  PRIMARY KEY (`u_id`,`r_id`),
  KEY `FKto8gqveqi41eyylx7a2tqlfip` (`r_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`u_id`,`r_id`) VALUES 
 (1,2),
 (2,1),
 (3,2),
 (6,1),
 (7,1),
 (8,1),
 (9,1),
 (11,2),
 (11,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
