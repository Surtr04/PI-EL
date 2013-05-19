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
-- Table structure for table `nonusers_publications`
--

DROP TABLE IF EXISTS `nonusers_publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nonusers_publications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publications_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nonusers_publications_publications1_idx` (`publications_id`),
  CONSTRAINT `fk_nonusers_publications_publications1` FOREIGN KEY (`publications_id`) REFERENCES `publications` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=295 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonusers_publications`
--

LOCK TABLES `nonusers_publications` WRITE;
/*!40000 ALTER TABLE `nonusers_publications` DISABLE KEYS */;
INSERT INTO `nonusers_publications` VALUES (1,1,'Jos'),(2,1,'Alberto Sim'),(3,2,'Alberto Manuel Brand'),(4,3,'Alberto Manuel Sim'),(5,3,'J.J. Almeida'),(6,4,'J.J. Almeida'),(7,4,'J.C. Ramalho'),(8,5,'J.J. Almeida'),(9,6,'Paulo A. Rocha'),(10,6,'Alberto M. Sim'),(11,6,'J.J. Almeida'),(12,7,'J.J. Almeida'),(13,7,'Barbosa, L.S.'),(14,7,'Neves, F.L.'),(15,7,'Oliveira, J.N.'),(16,8,'J.C. Ramalho'),(17,8,'J.J. Almeida'),(18,8,'P.R. Henriques'),(19,9,'Andr'),(20,9,'Jos'),(21,9,'Nuno Carvalho'),(22,10,'Jos'),(23,10,'Brett Drury'),(24,11,'Nuno Carvalho'),(25,11,'Jos'),(26,11,'Alberto Sim'),(27,12,'J.J. Almeida'),(28,13,'Alberto M. Sim'),(29,13,'J.J. Almeida'),(30,14,'C. Ferreira'),(31,14,'F. Ferreira'),(32,14,'F. Martins'),(33,14,'J.J. Almeida'),(34,14,'L. Barbosa'),(35,15,'J.J. Almeida'),(36,15,'Ulisses Pinto'),(37,16,'Alberto Sim'),(38,16,'Jos'),(39,17,'Brett Drury'),(40,17,'Luis Torgo'),(41,17,'J.J. Almeida'),(42,18,'Brett Drury'),(43,18,'J. J. Almeida'),(44,19,'J.J. Almeida'),(45,19,'Alberto M. Sim'),(46,19,'J. Alves de Castro'),(47,20,'J.Jo'),(48,21,'J. J. Almeida'),(49,21,'Alberto Sim'),(50,22,'Alberto M. Sim'),(51,22,'J.J. Almeida'),(52,23,'L.S. Barbosa'),(53,23,'J.B. Barros'),(54,23,'J.J. Almeida'),(55,24,'J.C. Ramalho'),(56,24,'J.J. Almeida'),(57,24,'P.R. Henriques'),(58,25,'J.J. Almeida'),(59,25,'Barbosa, L.S.'),(60,25,'Neves, F.L.'),(61,25,'Oliveira, J.N.'),(62,26,'Ulisses Pinto'),(63,26,'J.J. Almeida'),(64,27,'Brett Drury'),(65,27,'Jos'),(66,28,'Alberto Sim'),(67,28,'An'),(68,28,'Jos'),(69,29,'J.J. Almeida'),(70,29,'Jos'),(71,30,'J.J. Almeida'),(72,30,'Alberto Sim'),(73,31,'J.J. Almeida'),(74,31,'Alberto Sim'),(75,32,'Brett Drury'),(76,32,'J.J. Almeida'),(77,33,'{projecto David}'),(78,34,'Davide Sousa'),(79,34,'Alberto Sim'),(80,34,'Jos'),(81,35,'Alberto Manuel Sim'),(82,36,'Ricardo Reis'),(83,36,'J.J. Almeida'),(84,37,'Alberto Sim'),(85,37,'Jos'),(86,38,'Alberto M. Sim'),(87,38,'J.J. Almeida'),(88,38,'Pedro R. Henriques'),(89,39,'Jorge Rocha'),(90,39,'Tiago Pedroso'),(91,39,'J.J. Almeida'),(92,40,'J.J. Almeida'),(93,40,'A. Filipe'),(94,41,'Jos'),(95,41,'Alberto Sim'),(96,42,'Diana Santos'),(97,42,'Alberto Sim'),(98,42,'Ana Frankenberg-Garcia'),(99,42,'Ana Pinto'),(100,42,'Anabela Barreiro'),(101,42,'Belinda Maia'),(102,42,'Cristina Mota'),(103,42,'D'),(104,42,'Eckhard Bick'),(105,42,'Elisabete Ranchhod'),(106,42,'J.J. Almeida'),(107,42,'Lu'),(108,42,'Lu'),(109,42,'Lu'),(110,42,'Marcirio Chaves'),(111,42,'Nuno Cardoso'),(112,42,'Paulo Rocha'),(113,42,'Rachel Aires'),(114,42,'Ros'),(115,42,'Rui Vilela'),(116,42,'Susana Afonso'),(117,43,'Alberto Sim'),(118,44,'J.C. Ramalho'),(119,44,'J.G. Rocha'),(120,44,'J.J. Almeida'),(121,44,'P.R. Henriques'),(122,45,'Nuno Carvalho'),(123,45,'Alberto Sim'),(124,45,'J.J. Almeida'),(125,46,'Jos'),(126,46,'Alberto Sim'),(127,47,'Alberto Sim'),(128,47,'Jos'),(129,48,'J.J. Almeida'),(130,48,'J.B. Barros'),(131,49,'J.J. Almeida'),(132,50,'J. Jo'),(133,50,'Alberto Sim'),(134,51,'Alberto Sim'),(135,51,'Xavier G'),(136,51,'J.J. Almeida'),(137,52,'Alberto Sim'),(138,52,'Jos'),(139,52,'Xavier Gomez Guinovart'),(140,53,'J.J. Almeida'),(141,54,'Alberto Sim'),(142,54,''),(143,54,'Jos'),(144,55,'J.J. Almeida'),(145,55,'P.R. Henriques'),(146,56,'Rui Vilela'),(147,56,'Alberto Sim'),(148,56,'Eckhard Bick'),(149,56,'J.J. Almeida'),(150,57,'Jorge Rocha'),(151,57,'Ana Silva'),(152,57,'Ricardo Henriques'),(153,57,'J.J. Almeida'),(154,57,'Pedro Henriques'),(155,58,'Santos, Andr'),(156,58,'Jos'),(157,59,'Brett Drury'),(158,59,'J.J. Almeida'),(159,59,'Helena Morais'),(160,60,'J.J. Almeida'),(161,60,'A. M. Sim'),(162,61,'Drury, Brett'),(163,61,'Torgo, Luis'),(164,61,'J.J. Almeida'),(165,62,'Alberto Sim'),(166,62,'R'),(167,62,'Jos'),(168,63,'Alberto Sim'),(169,63,'J. Jo'),(170,64,'L.S. Barbosa'),(171,64,'J.J. Almeida'),(172,65,'An'),(173,65,'Alberto Sim'),(174,65,'Jos'),(175,65,'Miguel Rocha'),(176,65,'Isabel Rocha'),(177,65,'Eug'),(178,66,'J.J. Almeida'),(179,66,'Nuno Ramos Carvalho'),(180,66,'Jos'),(181,67,'Brett Drury'),(182,67,'Luis Torgo'),(183,67,'J.J. Almeida'),(184,68,'Jorge Gustavo Rocha'),(185,68,'Ana Silva'),(186,68,'J.J. Almeida'),(187,68,'Mario Ricardo Henriques'),(188,68,'Pedro Rangel Henriques'),(189,69,'Jos'),(190,69,'Alberto Sim'),(191,70,'J.J. Almeida'),(192,70,'Alberto Sim'),(193,71,'Alberto M. Sim'),(194,71,'J.J. Almeida'),(195,72,'J.J. Almeida'),(196,72,'Alberto Manuel Sim'),(197,72,'Jos'),(198,73,'Brett Drury'),(199,73,'Jos'),(200,74,'L.S. Barbosa'),(201,74,'J.J. Almeida'),(202,75,'J.J. Almeida'),(203,75,'J.B. Barros'),(204,76,'J.C. Ramalho'),(205,76,'J.J. Almeida'),(206,76,'P.R. Henriques'),(207,77,'J.J. Almeida'),(208,78,'F. M'),(209,78,'J.J. Almeida'),(210,78,'P.R. Henriques'),(211,79,'Alberto Manuel Sim'),(212,79,'J.J. Almeida'),(213,80,'Alberto Sim'),(214,80,'Nuno Carvalho'),(215,80,'Jos'),(216,81,'Alberto Sim'),(217,81,'J. Jo'),(218,82,'J.J. Almeida'),(219,83,'J.B. Barros'),(220,83,'J.J. Almeida'),(221,84,'L.S. Barbosa'),(222,84,'J.J. Almeida'),(223,85,'Alberto Sim'),(224,86,'J.J. Almeida'),(225,86,'Ulisses Pinto'),(226,87,'J.G. Rocha'),(227,87,'M.R. Henriques'),(228,87,'J.C. Ramalho'),(229,87,'J.J. Almeida'),(230,87,'J.L. Faria'),(231,87,'P.R. Henriques'),(232,88,'Jos'),(233,88,'Alberto Sim'),(234,89,'Bruno Martins'),(235,90,'Brett Drury'),(236,90,'J.J. Almeida'),(237,90,'Helena Morais'),(238,91,'J.J. Almeida'),(239,92,'J.J. Almeida'),(240,93,'Jo'),(241,93,'Jos'),(242,93,'Alberto Sim'),(243,93,'Ana Soares'),(244,94,'{projecto Camila}'),(245,95,'Jos'),(246,95,'Alberto Sim'),(247,96,'Almeida, J.J.'),(248,96,'Barbosa, L.S.'),(249,96,'Barros, J.B.'),(250,96,'Neves, L.F.'),(251,97,'Brett Drury'),(252,97,'J.J. Almeida'),(253,97,'Helena Morais'),(254,98,'L.S. Barbosa'),(255,98,'J.J. Almeida'),(256,99,'J.J. Almeida'),(257,100,'J.C. Ramalho'),(258,100,'J.G. Rocha'),(259,100,'J.J. Almeida'),(260,100,'P.R. Henriques'),(261,101,'Nuno Ramos Carvalho'),(262,101,'Jose Joao Almeida'),(263,101,'Maria Jo'),(264,101,'Pedro Rangel Henriques'),(265,102,'J.J. Almeida'),(266,102,'Ulisses Pinto'),(267,103,'Ant'),(268,103,'Alexandre Carvalho'),(269,103,'J. Jo'),(270,103,'Alberto Sim'),(271,104,'J.J. Almeida'),(272,104,'Alberto Manuel Sim'),(273,105,'J.J. Almeida'),(274,105,'P. Rangel Henriques'),(275,105,'J. Gustavo Rocha'),(276,105,'Alberto Sim'),(277,106,'J.J. Almeida'),(278,106,'Alberto Sim'),(279,106,'Jos'),(280,106,'Bruno Martins'),(281,106,'Paulo Silva'),(282,107,'Jos'),(283,108,'J.J. Almeida'),(284,108,'Alberto Manuel Sim'),(285,109,'J.J. Almeida'),(286,110,'Alberto Sim'),(287,110,'Rita Farinha'),(288,111,'J.J. Almeida'),(289,111,'J. Gustavo Rocha'),(290,111,'P. Rangel Henriques'),(291,111,'S'),(292,111,'Alberto Sim'),(293,112,'Alberto Sim'),(294,112,'Jos');
/*!40000 ALTER TABLE `nonusers_publications` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-19 17:17:27
