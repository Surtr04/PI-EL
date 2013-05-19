CREATE DATABASE  IF NOT EXISTS `elcvs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elcvs`;
-- MySQL dump 10.13  Distrib 5.6.10, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: elcvs
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `bibfields`
--

DROP TABLE IF EXISTS `bibfields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bibfields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_UNIQUE` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bibfields`
--

LOCK TABLES `bibfields` WRITE;
/*!40000 ALTER TABLE `bibfields` DISABLE KEYS */;
INSERT INTO `bibfields` VALUES (1,'authors',NULL),(2,'lang',NULL),(3,'month',NULL),(4,'author',NULL),(5,'entryType',NULL),(6,'booktitle',NULL),(7,'editor',NULL),(8,'url',NULL),(9,'abstract',NULL),(10,'title',NULL),(11,'isbn',NULL),(12,'pages',NULL),(13,'year',NULL),(14,'superviser',NULL),(15,'school',NULL),(16,'type',NULL),(17,'keyword',NULL),(18,'docpage',NULL),(19,'number',NULL),(20,'institution',NULL),(21,'volume',NULL),(22,'publisher',NULL),(23,'journal',NULL),(24,'address',NULL),(25,'note',NULL),(26,'series',NULL),(27,'language',NULL),(28,'date',NULL),(29,'location',NULL),(30,'shortin',NULL),(31,'bibsource',NULL),(32,'booktitle_full',NULL),(33,'ee',NULL),(34,'pp',NULL),(35,'isbn13',NULL),(36,'issn',NULL),(37,'comment',NULL),(38,'journal_small',NULL),(39,'journal_full',NULL),(40,'part',NULL),(41,'doi',NULL);
/*!40000 ALTER TABLE `bibfields` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-19 23:48:02
