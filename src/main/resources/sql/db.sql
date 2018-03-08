/*
SQLyog Community v12.5.0 (32 bit)
MySQL - 5.7.20-log : Database - javafx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javafx` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `javafx`;

/*Table structure for table `question_detail` */

DROP TABLE IF EXISTS `question_detail`;

CREATE TABLE `question_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `question_id` int(10) NOT NULL,
  `question` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `audio` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `answers` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `question_detail` */

insert  into `question_detail`(`id`,`question_id`,`question`,`audio`,`picture`,`answers`) values 
(1,1,'Blade in the ... ?','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(2,2,'Question 1','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(3,2,'Question 2','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(4,2,'Question 3','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(9,6,'Question 1','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(10,6,'Question 2','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(11,8,'Question 1','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]'),
(12,8,'Question 2','','','[{\"id\":1,\"answer\":\"Answer 1\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":2,\"answer\":\"Answer 2\",\"rightAnswer\":false,\"explain\":\"it fail\"},{\"id\":3,\"answer\":\"Answer 3\",\"rightAnswer\":true,\"explain\":\"it true\"},{\"id\":4,\"answer\":\"Answer 4\",\"rightAnswer\":false,\"explain\":\"it fail\"}]');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paragraph` text COLLATE utf8_unicode_ci,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `questions` */

insert  into `questions`(`id`,`type`,`paragraph`,`created_date`,`status`) values 
(1,'Vocabulary',NULL,'2018-03-08 11:47:03',1),
(2,'Reading','ParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraphParagraph','2018-03-08 14:57:33',1),
(6,'Vocabulary',NULL,'2018-03-08 16:21:07',0),
(8,'Vocabulary',NULL,'2018-03-08 16:24:08',0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` int(1) DEFAULT '1',
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_point` int(10) DEFAULT '0',
  `grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`created_date`,`active`,`role`,`total_point`,`grade`) values 
(1,'japanredsun','12345','2018-02-27 10:03:19',1,'USER',0,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
