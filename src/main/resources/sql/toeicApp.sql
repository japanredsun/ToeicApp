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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `question_detail` */

insert  into `question_detail`(`id`,`question_id`,`question`,`audio`,`picture`,`answers`) values 
(15,21,'1.','/audio/P1_1.mp3','/picture/P1_1.png','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"She is repairing the printer.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"She is storing some boxes.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"She is working in a copy room.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"She is opening a cabinet door.\"}]'),
(16,22,'2.','/audio/P1_2.mp3','/picture/P1_2.png','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"People are walking across the bridge.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"People are using the handrails.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"People are enjoying a boat ride.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"People are crossing the street.\"}]'),
(17,23,'3.','/audio/P1_3.mp3','/picture/P1_3.png','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The sign is hanging over the sidewalk.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"The address is above the entrance.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"There is a sign posted on the wall.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"There is a security guard in front of the gate.\"}]'),
(18,24,'4.','/audio/P1_4.mp3','/picture/P1_4.png','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"He is cleaning the kitchen.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"He is weighing something.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"He is cutting some meat.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"He is standing on a scale.\"}]'),
(19,25,'5.','/audio/P1_5.mp3','/picture/P1_5.png','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The couple is shaking hands.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The couple is wearing sunglasses.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The woman is holding some balloons.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"The man is passing out some brochures. \"}]'),
(20,26,'1.','/audio/P2_1.mp3','','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"To deposit his paycheck.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The Madison Street branch.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"- When is Tom going to the bank?\\n- Sometime after lunch. \"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(21,27,'2.','/audio/P2_2.mp3','','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"- Does the airport bus stop here?\\n- Oh, you can catch it on the next block.\\n\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"The workshop is near the airport.\"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"Because it’s very crowded.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(22,28,'3.','/audio/P2_3.mp3','','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"Yes, they did. \"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"It’s better if you fax it. \"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"- Why did you e-mail the clients?\\n- To send them the revised proposal.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(23,29,'4.','/audio/P2_4.mp3','','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"That’s a surprise.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"- Who usually orders office supplies?\\n- Linda, I think. \"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"They gave him a discount.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(24,30,'5.','/audio/P2_5.mp3','','[{\"id\":1,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"He sits over there.\"},{\"id\":2,\"answer\":\"\",\"rightAnswer\":true,\"explain\":\"- Is that your laptop on the desk?\\n- No, it’s Ms. Cheng’s. \"},{\"id\":3,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"Mostly for its power.\"},{\"id\":4,\"answer\":\"\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(25,31,'1. What service is the woman asking about?','/audio/P3_1_1.mp3','','[{\"id\":1,\"answer\":\"Room cleaning \\n\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Laundry service\",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Express check-in \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Conference room rental\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(26,31,'2. When most likely will the woman give a speech?','/audio/P3_1_2.mp3','','[{\"id\":1,\"answer\":\"On Sunday\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"On Monday\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"On Tuesday \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"On Wednesday\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(27,31,'What will the man probably do next?','/audio/P3_1_3.mp3','','[{\"id\":1,\"answer\":\"Process the woman’s payment\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Help the woman with her luggage \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"Take the woman’s jacket \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Give the woman a bag\",\"rightAnswer\":true,\"explain\":\"\"}]'),
(28,32,'1. Why does the woman say the meeting should be postponed?','/audio/P3_2_1.mp3','','[{\"id\":1,\"answer\":\"Some important data is missing. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Some employees will be absent. \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"The computer system has a problem. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"An executive is scheduled to visit the office.\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(29,32,'2. When will the meeting most likely be held?','/audio/P3_2_2.mp3','','[{\"id\":1,\"answer\":\"Thursday morning\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Thursday afternoon\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"Friday morning\",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"Friday afternoon\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(30,32,'3. What will the man probably do next?','/audio/P3_2_3.mp3','','[{\"id\":1,\"answer\":\"Visit a computer facility \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Take a lunch break \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Reserve a meeting room\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Write an e-mail message \",\"rightAnswer\":false,\"explain\":\"\"}]'),
(31,33,'1. Why have the airline’s jets changed appearance?','/audio/P4_1_1.mp3','','[{\"id\":1,\"answer\":\"It purchased new planes\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"It changed its slogan.\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"It is celebrating an anniversary\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"It merged with another airline.\",\"rightAnswer\":true,\"explain\":\"\"}]'),
(32,33,'2. What will the airline do next month?','/audio/P4_1_2.mp3','','[{\"id\":1,\"answer\":\"Begin an online reservations system \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Expand its hours of its operation \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Change its name to Globe Airways \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Open new ticket counters at airports\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(33,33,'3. Who will receive a discount with the airline this month?','/audio/P4_1_3.mp3','','[{\"id\":1,\"answer\":\"New customers \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":2,\"answer\":\"Frequent fliers\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"First-class travelers \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Holders of travel discount cards\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(34,34,'1. When will the office open again?','/audio/P4_2_1.mp3','','[{\"id\":1,\"answer\":\"On Thursday \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"On Friday\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"On Monday \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"On Tuesday \",\"rightAnswer\":true,\"explain\":\"\"}]'),
(35,34,'2. According to the recording, what does STS provide?','/audio/P4_2_2.mp3','','[{\"id\":1,\"answer\":\"A list of local hotels \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":2,\"answer\":\"Tour guides for groups\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"Updates on ski conditions \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Information for volunteers \",\"rightAnswer\":false,\"explain\":\"\"}]'),
(36,34,'3. What should a caller do to speak to a representative?','/audio/P4_2_3.mp3','','[{\"id\":1,\"answer\":\"Record a message \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Dial a different extension\",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Press number one\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Stay on the line\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(37,35,'1. Heavy rain caused the ------- of Taylor City’s third annual outdoor arts and crafts festival.','','','[{\"id\":1,\"answer\":\"cancel\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"cancels\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"cancelled\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"cancellation\\n\",\"rightAnswer\":true,\"explain\":\"\"}]'),
(38,36,'2. Our banquet rooms are capable of ------- events of all types and sizes.','','','[{\"id\":1,\"answer\":\"accommodate \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"accommodated \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"accommodating \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"accommodation\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(39,37,'3. The monthly rent cost includes heat and hot water, ------- not electricity and cooking gas. ','','','[{\"id\":1,\"answer\":\"or \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"but \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"both \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"unless\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(40,38,'4. It can often be difficult to ------- real antique furniture from imitation items.','','','[{\"id\":1,\"answer\":\"merge \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"suppose \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"distinguish \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"expect\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(41,39,'5. Upon ------- of your résumé, one of our skilled recruiters will review it to determine the most suitable position for you.','','','[{\"id\":1,\"answer\":\"receive \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"receiver \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"receipt \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"received\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(42,40,'1.','','','[{\"id\":1,\"answer\":\"flexible \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"flexibly \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"flexibility \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"more flexible\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(43,40,'2.','','','[{\"id\":1,\"answer\":\"weight \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"value \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"degree \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"rate\\n\",\"rightAnswer\":true,\"explain\":\"\"}]'),
(44,40,'3.','','','[{\"id\":1,\"answer\":\"besides \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":2,\"answer\":\"except \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"until \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"between\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(45,41,'1.','','','[{\"id\":1,\"answer\":\"centrally \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"centralize \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"centralized \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"centralization\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(46,41,'2.','','','[{\"id\":1,\"answer\":\"requested \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"requesting \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"are requested \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"requests\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(47,41,'3.','','','[{\"id\":1,\"answer\":\"habits \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"supplies \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"sources \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"factors\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(48,42,'1.','','','[{\"id\":1,\"answer\":\"acquire \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"acquired \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"acquiring \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"acquisition\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(49,42,'2.','','','[{\"id\":1,\"answer\":\"choose \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"choosing \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"to choose \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"to have chosen\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(50,42,'3.','','','[{\"id\":1,\"answer\":\"keeps \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"passes \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"streams \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"runs\",\"rightAnswer\":true,\"explain\":\"\"}]'),
(51,43,'1. What is NOT indicated about Tower Park?','','','[{\"id\":1,\"answer\":\"It has an outdoor theater. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"It is in the downtown area. \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"It has several picnic areas.\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"It contains the city’s highest hill.\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(52,43,'1. What is NOT indicated about Tower Park?','','','[{\"id\":1,\"answer\":\"It has an outdoor theater. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"It is in the downtown area. \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"It has several picnic areas.\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"It contains the city’s highest hill.\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(53,44,'1. What kind of company most likely is being advertised?','','','[{\"id\":1,\"answer\":\"An interior design company \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"A plant watering service\",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"A garden supply shop \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"An outdoor landscaping business\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(54,44,'2. What is NOT mentioned in the advertisement?','','','[{\"id\":1,\"answer\":\"The address of the company’s Web site\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"The cost of one of the company’s services \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"How long the company has been in business\",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"How to get a free consultation from the company\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(55,45,'1. What is NOT sold in the store? ','','','[{\"id\":1,\"answer\":\"Cleaning supplies \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Shop display cabinets \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Equipment that does not work \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Equipment that is no longer made\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(56,45,'2. When most likely could Mr. Nelson only be reached online?','','','[{\"id\":1,\"answer\":\"Wednesday at 7 P.M. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"Thursday at 4 P.M. \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"Friday at 8 P.M. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"Saturday at 11 A.M.\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(57,45,'3. On what day did Mr. Sanders most likely visit the store?','','','[{\"id\":1,\"answer\":\"On Thursday\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"On Friday \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"On Saturday \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":4,\"answer\":\"On Sunday\\n\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(58,45,'4. What did Mr. Sanders say he liked most about the store?','','','[{\"id\":1,\"answer\":\"The atmosphere \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":2,\"answer\":\"The prices on merchandise\",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":3,\"answer\":\"The knowledgeable sales staff \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"The availability of repair service\",\"rightAnswer\":false,\"explain\":\"\"}]'),
(59,45,'5. What is indicated about Mr. Nelson?','','','[{\"id\":1,\"answer\":\"He is a colleague of Mr. Sanders. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":2,\"answer\":\"He used to be a sound engineer. \",\"rightAnswer\":true,\"explain\":\"\"},{\"id\":3,\"answer\":\"He works about 17 hours a week. \",\"rightAnswer\":false,\"explain\":\"\"},{\"id\":4,\"answer\":\"He is a member of a music group.\",\"rightAnswer\":false,\"explain\":\"\"}]');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paragraph` text COLLATE utf8_unicode_ci,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `questions` */

insert  into `questions`(`id`,`type`,`paragraph`,`created_date`,`status`) values 
(21,'Listening - Part 1','','2018-04-01 20:06:21',1),
(22,'Listening - Part 1','','2018-04-01 20:07:17',1),
(23,'Listening - Part 1','','2018-04-01 20:07:55',1),
(24,'Listening - Part 1','','2018-04-01 20:08:54',1),
(25,'Listening - Part 1','','2018-04-01 20:09:36',1),
(26,'Listening - Part 2','','2018-04-01 20:13:05',1),
(27,'Listening - Part 2','','2018-04-01 20:15:12',1),
(28,'Listening - Part 2','','2018-04-01 20:16:09',1),
(29,'Listening - Part 2','','2018-04-01 20:17:17',1),
(30,'Listening - Part 2','','2018-04-01 20:17:57',1),
(31,'Listening - Part 3','','2018-04-01 20:24:32',1),
(32,'Listening - Part 3','','2018-04-01 20:33:56',1),
(33,'Listening - Part 4','','2018-04-01 20:41:50',1),
(34,'Listening - Part 4','','2018-04-01 20:52:31',1),
(35,'Reading - Part 5','','2018-04-01 20:55:12',1),
(36,'Reading - Part 5','','2018-04-01 20:56:16',1),
(37,'Reading - Part 5','','2018-04-01 20:57:32',1),
(38,'Reading - Part 5','','2018-04-01 20:58:27',1),
(39,'Reading - Part 5','','2018-04-01 20:59:38',1),
(40,'Reading - Part 6','Are you ready to earn some extra cash over the holidays?\nParadise Clothing Store wants part-time store clerks needed to help out during our busy holiday shopping season. The positions are perfect for students, parents or anyone else who \ndesires (1)------- in their work schedule. Come and apply today. We offer paid training, a competitive pay (2)-------, and generous employee discounts. But that’s not all. We offer many \nmore benefits (3)------- these, including free uniforms, sales bonuses, and regular pay increases. To find out more about the positions, visit our employment Web site at  www.paradise.com.\n','2018-04-01 21:03:48',1),
(41,'Reading - Part 6','INTER OFFICE MEMORANDUM\nTo:     All Operations Department staff \nFrom:    Daniel Burnham, Managing Director \nSubject: Moving Instructions\nI have some good news! Work crews will start our long-awaited office renovation project next Tuesday. During the construction, we will move to offices on the 9th floor. After the \nupgrades are completed, our office will have a (1)------- layout that will give us all easy access to equipment. We do the move on Monday afternoon, and all employees (2)------- to use \nthe back exits while moving. Later today, you will receive boxes, tape, labels and other (3)------- for the move. We will pack on Monday morning, and later today you will get a seating \nmap for the new office. Thank you in advance for your cooperation on this relocation.','2018-04-01 21:34:16',1),
(42,'Reading - Part 6','The Danforth Public Library is having a big book sale!\nTo make room for its newly (1)------- books, the Danforth Public Library is having a big one-week book sale. You’ll be able (2)------- from thousands of quality used books, DVDs, CDs, and             \nmagazines on sale at amazingly low prices. The sale starts Friday April 11th and (3)------- through April 18th, and it will take place during regular library hours (8 A.M. to 7 P.M.). We hope to \nsee you at this great event! ','2018-04-01 21:39:00',1),
(43,'Reading - Part 7','Tower Park (East Gate)\nThis is the East Gate entrance of Tower Park, a historic pleasure ground situated in the southern part of the city. The park is linked to the Harbor Island Recreation area by the Taylor \nBridge on its far west side. Along the park’s ridges you will find several round hills, including Grayson Hill (100 meters), which offers fine panoramic views of the city. Though not especially \ntall, it towers above every other hill in the city. The Sawyer, Hamlin, and Pulaski picnic areas, as well as three others, let visitors relax in harmony with nature. Live plays are performed both \nat the park’s Milton Theater and open-air Youth Theater. Just a few steps from this entrance, you’ll find the Kendall Stadium. As part of a program of improvements to Tower City, the \ngate’s appearance was recently upgraded by park volunteers. We hope you enjoy this fine pleasure ground. \nPark hours (main gate access):     \n	Monday – Saturday 7 A.M. to 9 P.M. (East Gate closes at 8 P.M.)   \n	Sunday 7 A.M. to 7 P.M. (East Gate closes at 6 P.M.)','2018-04-01 21:47:17',1),
(44,'Reading - Part 7','We’re Planet Green Inc., and we’re here to help busy professionals with their plants!\nPlants do a lot of things for our homes and offices. They make the indoor environment cleaner and purer, and they beautify all types of interiors. They even make your staff happier and \nmore productive employees. But what happens when you are too busy to care for your plants? That’s where we can help. Here at Planet Green Inc., our goal is simple: to keep your thirsty \nplants supplied with water while you or your staff is on vacation. Our basic $20 service gives you a 20-minute visit by our plant experts. \nThe service includes:  	*  Watering                      \n					*  Removal of dry leaves if needed                      \n					*  Advice about soils/fertilizers                     \n					*  Guaranteed healthy plants! \nPlease visit us now at www.planetgreen.ntt or call us at 555-0023 for a no-cost initial consultation.\n\n\n','2018-04-01 21:52:26',1),
(45,'Reading - Part 7','					Weekend Audio and Video Exchange 20 W. Fulton Street \nNow open four days a week: 	Thursdays and Fridays 5 – 9 P.M.                   \n						Saturdays 10 A.M. – 6 P.M.                  \n						Sundays 11 A.M. – 4 P.M. \nInternet inquiries and phone orders (all handled personally by the owner):                   \n						Monday – Wednesday 10 A.M. – 6 P.M.                  \n						Thursdays and Fridays 1 – 9 P.M.                  \n						Saturdays and Sundays 10 A.M. – 8 P.M. \n www.infoaudio@ml.org        1-800-55-STEREO   \n					About Us \nOwned and operated by former sound engineer Brad Nelson for nearly 20 years, Weekend Audio and Video Exchange is a small, friendly store that sells only the finest new and \nsecond-hand audio and video equipment. We offer 90-day warranties on all of the used gear we sell, even on items discontinued by the manufacturer. Are you an electronics hobbyist? \nWe often sell vintage non-working stereo equipment at low prices as “projects” simply because we cannot stand to throw the items out. We also sell dust cloths, cleaning fluid, and much \nmore. Each day we’re open, we put out a different showcase item on our front display counter – DVD players on Thursdays, new stereos on Fridays, used stereos on Saturdays, and \nflat-screen TVs on Sundays. \nSo come in and look around – you’re sure to find something you like. \nWant to help us and help our environment? During this week’s (March 15–18) store hours, we are giving away some of our old but still usable display cabinets. Please call us if you are \ninterested in a free, gently used cabinet for your home.\n\n\n					Reviews Unlimited \nUser name: Michael Sanders                                   Date posted: 3/22 (Thurs.)\nYou should buy your stereo at Weekend Audio and Video Exchange. When I went there, they had a beautifully-restored used stereo system on display as their “showcase item.” It wasn’t \ncheap, but it sounded terrific. They do offer some lower-priced equipment, and the owner, Brad Nelson, really knows electronics. But, for me, the best thing about this store is the \nambience. I came with two fellow members of my jazz band, and we all had a great time browsing around. It’s like being in an electronics museum. The store is open only 17 hours a \nweek, but Mr. Nelson is always busy repairing equipment in his free time. I highly recommend this place!\n','2018-04-01 21:58:21',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`created_date`,`active`,`role`,`total_point`,`grade`) values 
(1,'japanredsun','12345','2018-02-27 10:03:19',1,'USER',0,''),
(2,'admin','12345','2018-03-10 16:00:39',1,'ADMIN',35,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
