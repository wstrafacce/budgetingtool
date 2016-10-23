-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: budgetingtool
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `budgetingtool`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `budgetingtool` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `budgetingtool`;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `TYPE` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_2` (`NAME`),
  KEY `NAME` (`NAME`) USING BTREE,
  KEY `TYPE` (`TYPE`),
  CONSTRAINT `tb_category_ibfk_1` FOREIGN KEY (`TYPE`) REFERENCES `tb_category_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
INSERT INTO `tb_category` VALUES (1,'SALARY',1),(2,'GAS STATION',2);
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_category_type`
--

DROP TABLE IF EXISTS `tb_category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category_type` (
  `ID` tinyint(4) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_2` (`NAME`),
  KEY `NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category_type`
--

LOCK TABLES `tb_category_type` WRITE;
/*!40000 ALTER TABLE `tb_category_type` DISABLE KEYS */;
INSERT INTO `tb_category_type` VALUES (1,'EXPENSE'),(2,'INCOME');
/*!40000 ALTER TABLE `tb_category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_insert_mode`
--

DROP TABLE IF EXISTS `tb_insert_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_insert_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_2` (`NAME`),
  KEY `NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_insert_mode`
--

LOCK TABLES `tb_insert_mode` WRITE;
/*!40000 ALTER TABLE `tb_insert_mode` DISABLE KEYS */;
INSERT INTO `tb_insert_mode` VALUES (1,'AUTO'),(2,'MANUAL');
/*!40000 ALTER TABLE `tb_insert_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_operation`
--

DROP TABLE IF EXISTS `tb_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_operation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `VALUE` float(10,2) NOT NULL,
  `OP_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CATEGORY` int(11) DEFAULT NULL,
  `USER` int(11) NOT NULL,
  `INSERT_MODE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `NAME` (`NAME`) USING BTREE,
  KEY `OP_DATE` (`OP_DATE`) USING BTREE,
  KEY `CATEGORY` (`CATEGORY`),
  KEY `USER` (`USER`),
  KEY `INSERT_MODE` (`INSERT_MODE`),
  CONSTRAINT `tb_operation_ibfk_1` FOREIGN KEY (`CATEGORY`) REFERENCES `tb_category` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `tb_operation_ibfk_2` FOREIGN KEY (`USER`) REFERENCES `tb_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_operation_ibfk_3` FOREIGN KEY (`INSERT_MODE`) REFERENCES `tb_insert_mode` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_operation`
--

LOCK TABLES `tb_operation` WRITE;
/*!40000 ALTER TABLE `tb_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_status`
--

DROP TABLE IF EXISTS `tb_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_2` (`NAME`),
  KEY `NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_status`
--

LOCK TABLES `tb_status` WRITE;
/*!40000 ALTER TABLE `tb_status` DISABLE KEYS */;
INSERT INTO `tb_status` VALUES (1,'ACTIVE'),(2,'INACTIVE'),(3,'PENDING');
/*!40000 ALTER TABLE `tb_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `LASTNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `EMAIL` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `PICTURE` blob,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL_2` (`EMAIL`),
  KEY `EMAIL` (`EMAIL`) USING BTREE,
  KEY `STATUS` (`STATUS`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`STATUS`) REFERENCES `tb_status` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,NULL,NULL,'teste@teste.com','¨$&#*¨$&*',NULL,3),(6,NULL,NULL,'testeBO@teste.com','¨$&#*¨$&*',NULL,3);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-23  6:23:01
