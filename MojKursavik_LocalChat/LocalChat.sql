-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: chat
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chatinfo` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'<ci>\r 	<img src=\"\" width=\"40\" height=\"50\">\r \r 	<addtext><h3>Pravieračnik</h3>\r </addtext>\r </ci>'),(6,'<ci>\r 	<img src=\"data:image/jpeg;base64,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\" width=\"40\" height=\"50\">\r \r 	<addtext><h3>Alebarda</h3>\r </addtext>\r </ci>');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatuser`
--

DROP TABLE IF EXISTS `chatuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chatuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idchat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `iduser_idx` (`iduser`),
  KEY `idchat_idx` (`idchat`),
  CONSTRAINT `idchat` FOREIGN KEY (`idchat`) REFERENCES `chat` (`id`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatuser`
--

LOCK TABLES `chatuser` WRITE;
/*!40000 ALTER TABLE `chatuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massages`
--

DROP TABLE IF EXISTS `massages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `massages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `massagetext` text NOT NULL,
  `idchat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idofchat_idx` (`idchat`),
  CONSTRAINT `idofchat` FOREIGN KEY (`idchat`) REFERENCES `chat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massages`
--

LOCK TABLES `massages` WRITE;
/*!40000 ALTER TABLE `massages` DISABLE KEYS */;
INSERT INTO `massages` VALUES (1,'<ui>\r\n	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Nieśmiarotny</h4>wefrgthry<img src=\"https://images.chesscomfiles.com/uploads/v1/group/79602.0cf5856c.1200x1200o.14b8ae907d8c.jpeg\" width=\"100\" height=\"200\">\n</addtext>\r\n	</ui>',1),(2,'<ui>\r\n	<img src=\"https://pbs.twimg.com/profile_images/1191487220286291969/PVrzxqNL_400x400.jpg\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Non serviam</h4>qwerty</addtext>\r\n	</ui>',1),(3,'<ui>\r\n	<img src=\"https://pbs.twimg.com/profile_images/1191487220286291969/PVrzxqNL_400x400.jpg\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Non serviam</h4>ytrew</addtext>\r\n	</ui>',1),(8,'<ui>\r\n	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Nieśmiarotny</h4>sa esfd</addtext>\r\n	</ui>',1),(9,'<ui>\r\n	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Nieśmiarotny</h4>sa esfd</addtext>\r\n	</ui>',1),(10,'<ui>\r\n	<img src=\"https://pbs.twimg.com/profile_images/1191487220286291969/PVrzxqNL_400x400.jpg\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Non serviam</h4>sdfretvssdfd</addtext>\r\n	</ui>',1),(11,'<ui>\r\n	<img src=\"https://pbs.twimg.com/profile_images/1191487220286291969/PVrzxqNL_400x400.jpg\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Non serviam</h4>wqewretrgfdfddfwgre</addtext>\r\n	</ui>',1),(12,'<ui>\r\n	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Nieśmiarotny</h4>ewrgetfvdefwrge</addtext>\r\n	</ui>',1),(14,'<ui>\r\n	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"30\" height=\"50\">\r\n\r\n	<addtext><h4>Nieśmiarotny</h4>drftuyu rytfuygh rftugyihu rytfugyih rtfuygiuh ljkhgj dxcfygvuhbn ioluiyutf rdytugyihu iouiytry edtryftugy piuuyttr </addtext>\r\n	</ui>',1),(15,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4></addtext>\r\n	</ui>',6),(16,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>123</addtext>\r\n	</ui>',6),(17,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>123<img src=\"https://cutt.ly/DhDZM0Y\" width=\"200\" height=\"200\">\n</addtext>\r\n	</ui>',6),(18,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>123<a href=\"https://cutt.ly/DhDZM0Y\">Кашэрны кот</a>\n</addtext>\r\n	</ui>',6),(19,'<ui>\r\n	<img src=\"https://avatars3.githubusercontent.com/u/9851915?s=400&v=4\" width=\"40\" height=\"50\">\r\n\r\n	<addtext><h4>Somebody</h4>esr er  sgdhgjhg<img src=\"https://avatars3.githubusercontent.com/u/9851915?s=400&v=4\" width=\"150\" height=\"150\">\n<a href=\"https://avatars3.githubusercontent.com/u/9851915?s=400&v=4\">Vyjaŭka</a>\n</addtext>\r\n	</ui>',1),(20,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>Lorem ipsum dolor sit amet</addtext>\r\n	</ui>',1),(21,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>Ave Caesar, morituri te salutam</addtext>\r\n	</ui>',1),(22,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4><img src=\"https://sun9-44.userapi.com/impg/QT_dETCM7suOZanEtKWxJGYp9_krXJysM9Il-A/g9ncV0LzZ9w.jpg?size=1440x1920&quality=96&sign=a254c743418ebf72662f5403ccc4074b&type=album\" width=\"200\" height=\"300\">\n</addtext>\r\n	</ui>',1),(23,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4><a href=\"https://sun9-44.userapi.com/impg/QT_dETCM7suOZanEtKWxJGYp9_krXJysM9Il-A/g9ncV0LzZ9w.jpg?size=1440x1920&quality=96&sign=a254c743418ebf72662f5403ccc4074b&type=album\">Vyjaŭka</a>\n</addtext>\r\n	</ui>',1),(24,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4><img src=\"https://sun9-44.userapi.com/impg/QT_dETCM7suOZanEtKWxJGYp9_krXJysM9Il-A/g9ncV0LzZ9w.jpg?size=1440x1920&quality=96&sign=a254c743418ebf72662f5403ccc4074b&type=album\" width=\"200\" height=\"500\">\n</addtext>\r\n	</ui>',1),(25,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4><a href=\"https://sun9-44.userapi.com/impg/QT_dETCM7suOZanEtKWxJGYp9_krXJysM9Il-A/g9ncV0LzZ9w.jpg?size=1440x1920&quality=96&sign=a254c743418ebf72662f5403ccc4074b&type=album\">Vyjava</a>\n</addtext>\r\n	</ui>',1),(26,'<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4><a href=\"https://www.youtube.com/watch?v=vqteoE83zIA&list=RDMMvqteoE83zIA&start_radio=1\">Vid</a>\n</addtext>\r\n	</ui>',1);
/*!40000 ALTER TABLE `massages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userinfo` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'wdewf','wqdef','wqfe'),(2,'Zhorau','1863','<ui>\r 	<img src=\"https://sun9-58.userapi.com/impg/SI6ZORVfgLzK4suTJ5N8d51mJRx7o3Uq2eDygg/S4jxjT3D2Eg.jpg?size=185x273&quality=96&proxy=1&sign=f108cab59dcec079db84376d9b759236&type=album\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Nieśmiarotny</h4>'),(3,'Jasik','2001','<ui>\r 	<img src=\"https://pbs.twimg.com/profile_images/1191487220286291969/PVrzxqNL_400x400.jpg\" width=\"40\" height=\"50\">\r \r 	<addtext><h4>Non serviam</h4>'),(4,'Niechta','chtości','<ui>\r\n	<img src=\"https://avatars3.githubusercontent.com/u/9851915?s=400&v=4\" width=\"40\" height=\"50\">\r\n\r\n	<addtext><h4>Somebody</h4>');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'chat'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 19:48:39
