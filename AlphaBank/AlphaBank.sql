-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: alphabank
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
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deposit` double NOT NULL,
  `name` varchar(13) NOT NULL,
  `kredit` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,525813.0322048893,'checkout',-525813.0322048893),(2,9499649.035616312,'SFRB',7690.666666666668),(3,-2100,'1234567890000',2100),(4,0,'9876543210000',76.50410958904108),(5,0,'9876543210001',0),(6,0,'1234567890001',0),(7,-2200,'1488148814881',2280),(8,-134,'1863186318631',55.561643835616486),(9,308333.3333333334,'1234567899876',-300000),(10,2736.2988715559295,'1234567899874',-0.4),(13,204166.66666666666,'9876543211234',-200000),(14,2408.3333333333335,'9876543214321',-0.26666666666666666),(15,0,'9988776654320',0),(16,0,'9988776654321',0),(17,0,'9988776654320',0),(18,0,'9988776654321',0);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `billsview`
--

DROP TABLE IF EXISTS `billsview`;
/*!50001 DROP VIEW IF EXISTS `billsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `billsview` AS SELECT 
 1 AS `id`,
 1 AS `idklient`,
 1 AS `idcurrent`,
 1 AS `idpercent`,
 1 AS `idNum`,
 1 AS `startdate`,
 1 AS `enddate`,
 1 AS `dName`,
 1 AS `isUrgent`,
 1 AS `percent`,
 1 AS `vName`,
 1 AS `toBYN`,
 1 AS `deposit`,
 1 AS `kredit`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `citizenship`
--

DROP TABLE IF EXISTS `citizenship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `citizenship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `citizen` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizenship`
--

LOCK TABLES `citizenship` WRITE;
/*!40000 ALTER TABLE `citizenship` DISABLE KEYS */;
INSERT INTO `citizenship` VALUES (1,'Беларусь'),(2,'Россия'),(3,'Україна'),(4,'Polska'),(5,'Lietuva');
/*!40000 ALTER TABLE `citizenship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Surname` text NOT NULL,
  `Name` text NOT NULL,
  `FatherName` text NOT NULL,
  `BDay` date NOT NULL,
  `SerioPass` text NOT NULL,
  `NumPass` varchar(9) NOT NULL,
  `Vydan` text NOT NULL,
  `IDNum` text NOT NULL,
  `BPlace` text NOT NULL,
  `Adress` text NOT NULL,
  `HomePhone` varchar(5) DEFAULT NULL,
  `MobilePhone` varchar(13) DEFAULT NULL,
  `EMail` text,
  `Pensioner` tinyint(2) NOT NULL,
  `Income` double DEFAULT NULL,
  `Reservist` tinyint(2) NOT NULL,
  `idTown` int(11) NOT NULL,
  `idMarital` int(11) NOT NULL,
  `idCityzen` int(11) NOT NULL,
  `idDisability` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTown_idx` (`idTown`),
  KEY `idMarital_idx` (`idMarital`),
  KEY `idCityzen_idx` (`idCityzen`),
  KEY `idDisability_idx` (`idDisability`),
  CONSTRAINT `idCityzen` FOREIGN KEY (`idCityzen`) REFERENCES `citizenship` (`id`),
  CONSTRAINT `idDisability` FOREIGN KEY (`idDisability`) REFERENCES `disability` (`id`),
  CONSTRAINT `idMarital` FOREIGN KEY (`idMarital`) REFERENCES `marital` (`id`),
  CONSTRAINT `idTown` FOREIGN KEY (`idTown`) REFERENCES `towns` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (5,'Žoraŭ','Jaś','Baćkavič','2001-07-09','DS','1234567','РОВД Любани','4110873B058PB8','Lubań','Internat 4','63464','+375445142410','pcmast2001@gmail.com',0,210,1,1,1,1,1),(7,'Avis','Iohanan','Rubrum','2001-07-09','DS','123456789','wertyuikjhgfd','4110873B058PB0','Lubań','Internat 4','63464','+375445142410','pcmast2001@gmail.com',0,100,1,8,1,4,1),(8,'Caesar','Iulius','Roma','1974-07-01','DS','1234567','wertyuikjhgfd','4450873B058PB8','Lubań','Internat 4','63464','+375445142410','pcmast2001@gmail.com',1,1000,0,10,1,5,1),(9,'Хадускина','Светлана','Игоревна','2000-06-09','MC','1234567','Минское РОВД','1234567F123DS4','Минск','Минск','53535','+880535353500','non',0,1234,0,1,1,1,1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientbills`
--

DROP TABLE IF EXISTS `clientbills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientbills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idklient` int(11) NOT NULL,
  `idcurrent` int(11) NOT NULL,
  `idpercent` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idklient_idx` (`idklient`),
  KEY `idcurrent_idx` (`idcurrent`),
  KEY `idpercent_idx` (`idpercent`),
  CONSTRAINT `idcurrent` FOREIGN KEY (`idcurrent`) REFERENCES `bills` (`id`),
  CONSTRAINT `idklient` FOREIGN KEY (`idklient`) REFERENCES `client` (`id`),
  CONSTRAINT `idpercent` FOREIGN KEY (`idpercent`) REFERENCES `bills` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientbills`
--

LOCK TABLES `clientbills` WRITE;
/*!40000 ALTER TABLE `clientbills` DISABLE KEYS */;
INSERT INTO `clientbills` VALUES (2,5,1,2),(3,5,3,4),(4,8,5,6),(5,8,7,8),(6,5,9,10),(8,8,13,14),(9,9,15,16),(10,9,15,16);
/*!40000 ALTER TABLE `clientbills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `clientview`
--

DROP TABLE IF EXISTS `clientview`;
/*!50001 DROP VIEW IF EXISTS `clientview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `clientview` AS SELECT 
 1 AS `id`,
 1 AS `Surname`,
 1 AS `Name`,
 1 AS `FatherName`,
 1 AS `BDay`,
 1 AS `SerioPass`,
 1 AS `NumPass`,
 1 AS `Vydan`,
 1 AS `IDNum`,
 1 AS `BPlace`,
 1 AS `Adress`,
 1 AS `HomePhone`,
 1 AS `MobilePhone`,
 1 AS `EMail`,
 1 AS `Pensioner`,
 1 AS `Income`,
 1 AS `Reservist`,
 1 AS `TownName`,
 1 AS `Status`,
 1 AS `Type`,
 1 AS `citizen`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iddeposit` int(11) NOT NULL,
  `idcurrency` int(11) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `idclientbills` int(11) NOT NULL,
  `summ` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `iddep_idx` (`iddeposit`),
  KEY `idcur_idx` (`idcurrency`),
  KEY `idclientbill_idx` (`idclientbills`),
  CONSTRAINT `idclientbill` FOREIGN KEY (`idclientbills`) REFERENCES `clientbills` (`id`),
  CONSTRAINT `idcur` FOREIGN KEY (`idcurrency`) REFERENCES `currency` (`id`),
  CONSTRAINT `iddep` FOREIGN KEY (`iddeposit`) REFERENCES `deposits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,2,1,'2021-03-15','2021-05-31',3,2000),(3,1,2,'2021-03-31','2021-07-31',5,2000);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `contractsview`
--

DROP TABLE IF EXISTS `contractsview`;
/*!50001 DROP VIEW IF EXISTS `contractsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `contractsview` AS SELECT 
 1 AS `id`,
 1 AS `idNum`,
 1 AS `depos`,
 1 AS `val`,
 1 AS `startdate`,
 1 AS `enddate`,
 1 AS `now`,
 1 AS `percent`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `crbillsview`
--

DROP TABLE IF EXISTS `crbillsview`;
/*!50001 DROP VIEW IF EXISTS `crbillsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `crbillsview` AS SELECT 
 1 AS `id`,
 1 AS `idklient`,
 1 AS `idcurrent`,
 1 AS `idpercent`,
 1 AS `idNum`,
 1 AS `startdate`,
 1 AS `enddate`,
 1 AS `cash`,
 1 AS `allpayments`,
 1 AS `payments`,
 1 AS `cName`,
 1 AS `deposit`,
 1 AS `kredit`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `creditcontract`
--

DROP TABLE IF EXISTS `creditcontract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `creditcontract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idclientbills` int(11) NOT NULL,
  `idcredit` int(11) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `allpayments` int(11) NOT NULL,
  `payments` int(11) NOT NULL,
  `cash` double NOT NULL,
  `isstarted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idclbills_idx` (`idclientbills`),
  KEY `idcred_idx` (`idcredit`),
  CONSTRAINT `idclbills` FOREIGN KEY (`idclientbills`) REFERENCES `clientbills` (`id`),
  CONSTRAINT `idcred` FOREIGN KEY (`idcredit`) REFERENCES `credits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcontract`
--

LOCK TABLES `creditcontract` WRITE;
/*!40000 ALTER TABLE `creditcontract` DISABLE KEYS */;
INSERT INTO `creditcontract` VALUES (1,6,1,'2021-03-01','2023-03-01',24,2,100000,1),(3,8,2,'2021-03-01','2023-03-01',24,1,100000,1),(4,9,1,'2021-04-01','2023-04-01',24,0,10000,NULL);
/*!40000 ALTER TABLE `creditcontract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `creditcontractsview`
--

DROP TABLE IF EXISTS `creditcontractsview`;
/*!50001 DROP VIEW IF EXISTS `creditcontractsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `creditcontractsview` AS SELECT 
 1 AS `id`,
 1 AS `idNum`,
 1 AS `credit`,
 1 AS `startdate`,
 1 AS `enddate`,
 1 AS `now`,
 1 AS `percent`,
 1 AS `cash`,
 1 AS `perc`,
 1 AS `isann`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `credits`
--

DROP TABLE IF EXISTS `credits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `credits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `isAnnuitet` tinyint(4) NOT NULL,
  `percent` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credits`
--

LOCK TABLES `credits` WRITE;
/*!40000 ALTER TABLE `credits` DISABLE KEYS */;
INSERT INTO `credits` VALUES (1,'Просто деньги (аннуитетный)',1,28.9),(2,'Просто деньги (дифференцированный)',0,28.9);
/*!40000 ALTER TABLE `credits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `toBYN` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'BYN',1),(2,'USD',2.6),(3,'EUR',3.1);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposits`
--

DROP TABLE IF EXISTS `deposits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deposits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `isUrgent` tinyint(4) NOT NULL,
  `percent` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposits`
--

LOCK TABLES `deposits` WRITE;
/*!40000 ALTER TABLE `deposits` DISABLE KEYS */;
INSERT INTO `deposits` VALUES (1,'Альфа-Вклад(отзывной)',1,13),(2,'Альфа-Вклад(безотзывной)',0,17.9);
/*!40000 ALTER TABLE `deposits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disability`
--

DROP TABLE IF EXISTS `disability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `disability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disability`
--

LOCK TABLES `disability` WRITE;
/*!40000 ALTER TABLE `disability` DISABLE KEYS */;
INSERT INTO `disability` VALUES (1,'0'),(2,'1'),(3,'2'),(4,'3');
/*!40000 ALTER TABLE `disability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital`
--

DROP TABLE IF EXISTS `marital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital`
--

LOCK TABLES `marital` WRITE;
/*!40000 ALTER TABLE `marital` DISABLE KEYS */;
INSERT INTO `marital` VALUES (1,'холост/а'),(2,'в браке'),(3,'разведён/на');
/*!40000 ALTER TABLE `marital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentplan`
--

DROP TABLE IF EXISTS `paymentplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paymentplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcontract` int(11) NOT NULL,
  `totek` double NOT NULL,
  `toperc` double NOT NULL,
  `numofpay` int(11) NOT NULL,
  `ispayd` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idcontr_idx` (`idcontract`),
  CONSTRAINT `idcontr` FOREIGN KEY (`idcontract`) REFERENCES `creditcontract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentplan`
--

LOCK TABLES `paymentplan` WRITE;
/*!40000 ALTER TABLE `paymentplan` DISABLE KEYS */;
INSERT INTO `paymentplan` VALUES (1,1,4166.666666666667,1368.1494357779648,1,1),(2,1,4166.666666666667,1368.1494357779648,2,1),(3,1,4166.666666666667,1368.1494357779648,3,0),(4,1,4166.666666666667,1368.1494357779648,4,0),(5,1,4166.666666666667,1368.1494357779648,5,0),(6,1,4166.666666666667,1368.1494357779648,6,0),(7,1,4166.666666666667,1368.1494357779648,7,0),(8,1,4166.666666666667,1368.1494357779648,8,0),(9,1,4166.666666666667,1368.1494357779648,9,0),(10,1,4166.666666666667,1368.1494357779648,10,0),(11,1,4166.666666666667,1368.1494357779648,11,0),(12,1,4166.666666666667,1368.1494357779648,12,0),(13,1,4166.666666666667,1368.1494357779648,13,0),(14,1,4166.666666666667,1368.1494357779648,14,0),(15,1,4166.666666666667,1368.1494357779648,15,0),(16,1,4166.666666666667,1368.1494357779648,16,0),(17,1,4166.666666666667,1368.1494357779648,17,0),(18,1,4166.666666666667,1368.1494357779648,18,0),(19,1,4166.666666666667,1368.1494357779648,19,0),(20,1,4166.666666666667,1368.1494357779648,20,0),(21,1,4166.666666666667,1368.1494357779648,21,0),(22,1,4166.666666666667,1368.1494357779648,22,0),(23,1,4166.666666666667,1368.1494357779648,23,0),(24,1,4166.666666666667,1368.1494357779648,24,0),(49,3,4166.666666666667,2408.3333333333335,1,1),(50,3,4166.666666666667,2307.986111111111,2,0),(51,3,4166.666666666667,2207.6388888888887,3,0),(52,3,4166.666666666667,2107.2916666666665,4,0),(53,3,4166.666666666667,2006.9444444444441,5,0),(54,3,4166.666666666667,1906.5972222222217,6,0),(55,3,4166.666666666667,1806.25,7,0),(56,3,4166.666666666667,1705.9027777777776,8,0),(57,3,4166.666666666667,1605.5555555555554,9,0),(58,3,4166.666666666667,1505.2083333333335,10,0),(59,3,4166.666666666667,1404.8611111111109,11,0),(60,3,4166.666666666667,1304.5138888888887,12,0),(61,3,4166.666666666667,1204.1666666666667,13,0),(62,3,4166.666666666667,1103.8194444444443,14,0),(63,3,4166.666666666667,1003.4722222222221,15,0),(64,3,4166.666666666667,903.1249999999999,16,0),(65,3,4166.666666666667,802.7777777777777,17,0),(66,3,4166.666666666667,702.4305555555553,18,0),(67,3,4166.666666666667,602.0833333333334,19,0),(68,3,4166.666666666667,501.736111111111,20,0),(69,3,4166.666666666667,401.38888888888863,21,0),(70,3,4166.666666666667,301.0416666666667,22,0),(71,3,4166.666666666667,200.69444444444431,23,0),(72,3,4166.666666666667,100.34722222222199,24,0),(73,3,4166.666666666667,2408.3333333333335,1,0),(74,3,4166.666666666667,2307.986111111111,2,0),(75,3,4166.666666666667,2207.6388888888887,3,0),(76,3,4166.666666666667,2107.2916666666665,4,0),(77,3,4166.666666666667,2006.9444444444441,5,0),(78,3,4166.666666666667,1906.5972222222217,6,0),(79,3,4166.666666666667,1806.25,7,0),(80,3,4166.666666666667,1705.9027777777776,8,0),(81,3,4166.666666666667,1605.5555555555554,9,0),(82,3,4166.666666666667,1505.2083333333335,10,0),(83,3,4166.666666666667,1404.8611111111109,11,0),(84,3,4166.666666666667,1304.5138888888887,12,0),(85,3,4166.666666666667,1204.1666666666667,13,0),(86,3,4166.666666666667,1103.8194444444443,14,0),(87,3,4166.666666666667,1003.4722222222221,15,0),(88,3,4166.666666666667,903.1249999999999,16,0),(89,3,4166.666666666667,802.7777777777777,17,0),(90,3,4166.666666666667,702.4305555555553,18,0),(91,3,4166.666666666667,602.0833333333334,19,0),(92,3,4166.666666666667,501.736111111111,20,0),(93,3,4166.666666666667,401.38888888888863,21,0),(94,3,4166.666666666667,301.0416666666667,22,0),(95,3,4166.666666666667,200.69444444444431,23,0),(96,3,4166.666666666667,100.34722222222199,24,0),(97,4,416.6666666666667,136.81494357779644,1,0),(98,4,416.6666666666667,136.81494357779644,2,0),(99,4,416.6666666666667,136.81494357779644,3,0),(100,4,416.6666666666667,136.81494357779644,4,0),(101,4,416.6666666666667,136.81494357779644,5,0),(102,4,416.6666666666667,136.81494357779644,6,0),(103,4,416.6666666666667,136.81494357779644,7,0),(104,4,416.6666666666667,136.81494357779644,8,0),(105,4,416.6666666666667,136.81494357779644,9,0),(106,4,416.6666666666667,136.81494357779644,10,0),(107,4,416.6666666666667,136.81494357779644,11,0),(108,4,416.6666666666667,136.81494357779644,12,0),(109,4,416.6666666666667,136.81494357779644,13,0),(110,4,416.6666666666667,136.81494357779644,14,0),(111,4,416.6666666666667,136.81494357779644,15,0),(112,4,416.6666666666667,136.81494357779644,16,0),(113,4,416.6666666666667,136.81494357779644,17,0),(114,4,416.6666666666667,136.81494357779644,18,0),(115,4,416.6666666666667,136.81494357779644,19,0),(116,4,416.6666666666667,136.81494357779644,20,0),(117,4,416.6666666666667,136.81494357779644,21,0),(118,4,416.6666666666667,136.81494357779644,22,0),(119,4,416.6666666666667,136.81494357779644,23,0),(120,4,416.6666666666667,136.81494357779644,24,0);
/*!40000 ALTER TABLE `paymentplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `towns`
--

DROP TABLE IF EXISTS `towns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `towns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TownName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `towns`
--

LOCK TABLES `towns` WRITE;
/*!40000 ALTER TABLE `towns` DISABLE KEYS */;
INSERT INTO `towns` VALUES (1,'Мінск'),(2,'Брэст'),(3,'Віцебск'),(4,'Гродна'),(5,'Гомель'),(6,'Магілёў'),(7,'Москва'),(8,'Київ'),(9,'Warszawa'),(10,'Vilnius');
/*!40000 ALTER TABLE `towns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'alphabank'
--
/*!50003 DROP PROCEDURE IF EXISTS `delClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delClient`(idv int)
BEGIN
	DELETE FROM `alphabank`.`client` WHERE (`id` = idv);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertClient`( sname text, fstname text, frname text, BDay date,
SPass text, NumPass varchar(9), vdn text, IDNum text,
BPlace text, Adress text,  HPhone varchar(5), MPhone varchar(13),
EMail text, Pnsnr tinyint(2), incm double, Rsrvst tinyint(2),
idTown int, idMarital int, idCiryzen int, idDsblt int)
BEGIN
INSERT INTO `alphabank`.`client` 
(`Surname`, `Name`, `FatherName`, `BDay`, 
`SerioPass`, `NumPass`, `Vydan`, `IDNum`, 
`BPlace`, `Adress`, `HomePhone`, `MobilePhone`, 
`EMail`, `Pensioner`, `Income`, `Reservist`, 
`idTown`, `idMarital`, `idCityzen`, `idDisability`)
 VALUES 
 (sname, fstname, frname, BDay,
SPass, NumPass, vdn, IDNum,
BPlace, Adress,  HPhone, MPhone,
EMail, Pnsnr, incm, Rsrvst,
idTown, idMarital, idCiryzen, idDsblt);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updClient`(
sname text, fstname text, frname text, BDay date,
SPass text, NumPass varchar(9), vdn text, IDNum text,
BPlace text, Adress text,  HPhone varchar(5), MPhone varchar(13),
EMail text, Pnsnr tinyint(2), incm double, Rsrvst tinyint(2),
idTown int, idMarital int, idCiryzen int, idDsblt int ,idu int)
BEGIN
UPDATE `alphabank`.`client` SET `Surname` = sname, `Name` = fstname, `FatherName` = frname, `BDay` = BDay, `SerioPass` = SPass, `NumPass` = NumPass, `Vydan` = vdn, `IDNum` = IDNum , `BPlace` = BPlace, `Adress` = Adress, `HomePhone` = HPhone, `MobilePhone` = MPhone, `EMail` = EMail, `Pensioner` =Pnsnr, `Income` = incm, `Reservist` =  Rsrvst, `idTown` = idTown, `idMarital` = idMarital, `idCityzen` = idCiryzen, `idDisability` =  idDsblt WHERE (`id` = idu);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `billsview`
--

/*!50001 DROP VIEW IF EXISTS `billsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `billsview` AS select `contract`.`id` AS `id`,`clientbills`.`idklient` AS `idklient`,`clientbills`.`idcurrent` AS `idcurrent`,`clientbills`.`idpercent` AS `idpercent`,`client`.`IDNum` AS `idNum`,`contract`.`startdate` AS `startdate`,`contract`.`enddate` AS `enddate`,`deposits`.`name` AS `dName`,`deposits`.`isUrgent` AS `isUrgent`,`deposits`.`percent` AS `percent`,`currency`.`name` AS `vName`,`currency`.`toBYN` AS `toBYN`,`bills`.`deposit` AS `deposit`,`bills`.`kredit` AS `kredit` from (((((`contract` join `deposits` on((`contract`.`iddeposit` = `deposits`.`id`))) join `currency` on((`contract`.`idcurrency` = `currency`.`id`))) join `clientbills` on((`contract`.`idclientbills` = `clientbills`.`id`))) join `client` on((`clientbills`.`idklient` = `client`.`id`))) join `bills` on(((`clientbills`.`idcurrent` = `bills`.`id`) or (`clientbills`.`idpercent` = `bills`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientview`
--

/*!50001 DROP VIEW IF EXISTS `clientview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientview` AS select `client`.`id` AS `id`,`client`.`Surname` AS `Surname`,`client`.`Name` AS `Name`,`client`.`FatherName` AS `FatherName`,`client`.`BDay` AS `BDay`,`client`.`SerioPass` AS `SerioPass`,`client`.`NumPass` AS `NumPass`,`client`.`Vydan` AS `Vydan`,`client`.`IDNum` AS `IDNum`,`client`.`BPlace` AS `BPlace`,`client`.`Adress` AS `Adress`,`client`.`HomePhone` AS `HomePhone`,`client`.`MobilePhone` AS `MobilePhone`,`client`.`EMail` AS `EMail`,`client`.`Pensioner` AS `Pensioner`,`client`.`Income` AS `Income`,`client`.`Reservist` AS `Reservist`,`towns`.`TownName` AS `TownName`,`marital`.`Status` AS `Status`,`disability`.`Type` AS `Type`,`citizenship`.`citizen` AS `citizen` from ((((`client` join `towns` on((`client`.`idTown` = `towns`.`id`))) join `marital` on((`client`.`idMarital` = `marital`.`id`))) join `disability` on((`client`.`idDisability` = `disability`.`id`))) join `citizenship` on((`client`.`idCityzen` = `citizenship`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `contractsview`
--

/*!50001 DROP VIEW IF EXISTS `contractsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `contractsview` AS select `contract`.`id` AS `id`,`client`.`IDNum` AS `idNum`,`deposits`.`name` AS `depos`,`currency`.`name` AS `val`,`contract`.`startdate` AS `startdate`,`contract`.`enddate` AS `enddate`,`bills`.`name` AS `now`,`bills`.`name` AS `percent` from (((((`contract` join `deposits` on((`contract`.`iddeposit` = `deposits`.`id`))) join `currency` on((`contract`.`idcurrency` = `currency`.`id`))) join `clientbills` on((`contract`.`idclientbills` = `clientbills`.`id`))) join `client` on((`clientbills`.`idklient` = `client`.`id`))) join `bills` on(((`clientbills`.`idcurrent` = `bills`.`id`) or (`clientbills`.`idpercent` = `bills`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `crbillsview`
--

/*!50001 DROP VIEW IF EXISTS `crbillsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `crbillsview` AS select `creditcontract`.`id` AS `id`,`clientbills`.`idklient` AS `idklient`,`clientbills`.`idcurrent` AS `idcurrent`,`clientbills`.`idpercent` AS `idpercent`,`client`.`IDNum` AS `idNum`,`creditcontract`.`start` AS `startdate`,`creditcontract`.`end` AS `enddate`,`creditcontract`.`cash` AS `cash`,`creditcontract`.`allpayments` AS `allpayments`,`creditcontract`.`payments` AS `payments`,`credits`.`name` AS `cName`,`bills`.`deposit` AS `deposit`,`bills`.`kredit` AS `kredit` from ((((`creditcontract` join `credits` on((`creditcontract`.`idcredit` = `credits`.`id`))) join `clientbills` on((`creditcontract`.`idclientbills` = `clientbills`.`id`))) join `client` on((`clientbills`.`idklient` = `client`.`id`))) join `bills` on(((`clientbills`.`idcurrent` = `bills`.`id`) or (`clientbills`.`idpercent` = `bills`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `creditcontractsview`
--

/*!50001 DROP VIEW IF EXISTS `creditcontractsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `creditcontractsview` AS select `creditcontract`.`id` AS `id`,`client`.`IDNum` AS `idNum`,`credits`.`name` AS `credit`,`creditcontract`.`start` AS `startdate`,`creditcontract`.`end` AS `enddate`,`bills`.`name` AS `now`,`bills`.`name` AS `percent`,`creditcontract`.`cash` AS `cash`,`credits`.`percent` AS `perc`,`credits`.`isAnnuitet` AS `isann` from ((((`creditcontract` join `credits` on((`creditcontract`.`idcredit` = `credits`.`id`))) join `clientbills` on((`creditcontract`.`idclientbills` = `clientbills`.`id`))) join `client` on((`clientbills`.`idklient` = `client`.`id`))) join `bills` on(((`clientbills`.`idcurrent` = `bills`.`id`) or (`clientbills`.`idpercent` = `bills`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 19:48:15
