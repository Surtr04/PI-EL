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
  `publications_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`,`publications_id`),
  KEY `fk_nonusers_publications_publications1_idx` (`publications_id`),
  CONSTRAINT `fk_nonusers_publications_publications1` FOREIGN KEY (`publications_id`) REFERENCES `publications` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonusers_publications`
--

LOCK TABLES `nonusers_publications` WRITE;
/*!40000 ALTER TABLE `nonusers_publications` DISABLE KEYS */;
INSERT INTO `nonusers_publications` VALUES (1,'Alberto Simões'),(1,'José João Almeida'),(2,'Alberto Manuel Brandão Simões'),(3,'Alberto Manuel Simões'),(3,'J.J. Almeida'),(4,'J.C. Ramalho'),(4,'J.J. Almeida'),(5,'J.J. Almeida'),(6,'Alberto M. Simões'),(6,'J.J. Almeida'),(6,'Paulo A. Rocha'),(7,'Barbosa, L.S.'),(7,'J.J. Almeida'),(7,'Neves, F.L.'),(7,'Oliveira, J.N.'),(8,'J.C. Ramalho'),(8,'J.J. Almeida'),(8,'P.R. Henriques'),(9,'André Santos'),(9,'José João Almeida'),(9,'Nuno Carvalho'),(10,'Brett Drury'),(10,'José João Almeida'),(11,'Alberto Simões'),(11,'José João Almeida'),(11,'Nuno Carvalho'),(12,'J.J. Almeida'),(13,'Alberto M. Simões'),(13,'J.J. Almeida'),(14,'C. Ferreira'),(14,'F. Ferreira'),(14,'F. Martins'),(14,'J.J. Almeida'),(14,'L. Barbosa'),(15,'J.J. Almeida'),(15,'Ulisses Pinto'),(16,'Alberto Simões'),(16,'José João Almeida'),(17,'Brett Drury'),(17,'J.J. Almeida'),(17,'Luis Torgo'),(18,'Brett Drury'),(18,'J. J. Almeida'),(19,'Alberto M. Simões'),(19,'J. Alves de Castro'),(19,'J.J. Almeida'),(20,'J.João Almeida'),(21,'Alberto Simões'),(21,'J. J. Almeida'),(22,'Alberto M. Simões'),(22,'J.J. Almeida'),(23,'J.B. Barros'),(23,'J.J. Almeida'),(23,'L.S. Barbosa'),(24,'J.C. Ramalho'),(24,'J.J. Almeida'),(24,'P.R. Henriques'),(25,'Barbosa, L.S.'),(25,'J.J. Almeida'),(25,'Neves, F.L.'),(25,'Oliveira, J.N.'),(26,'J.J. Almeida'),(26,'Ulisses Pinto'),(27,'Brett Drury'),(27,'José João Almeida'),(28,'Alberto Simões'),(28,'Anália Lourenço'),(28,'José João Almeida'),(29,'J.J. Almeida'),(29,'José Carlos Ramalho'),(30,'Alberto Simões'),(30,'J.J. Almeida'),(31,'Alberto Simões'),(31,'J.J. Almeida'),(32,'Brett Drury'),(32,'J.J. Almeida'),(33,'{projecto David}'),(34,'Alberto Simões'),(34,'Davide Sousa'),(34,'José João Almeida'),(35,'Alberto Manuel Simões'),(36,'J.J. Almeida'),(36,'Ricardo Reis'),(37,'Alberto Simões'),(37,'José João Almeida'),(38,'Alberto M. Simões'),(38,'J.J. Almeida'),(38,'Pedro R. Henriques'),(39,'J.J. Almeida'),(39,'Jorge Rocha'),(39,'Tiago Pedroso'),(40,'A. Filipe'),(40,'J.J. Almeida'),(41,'Alberto Simões'),(41,'José João Almeida'),(42,'Alberto Simões'),(42,'Ana Frankenberg-Garcia'),(42,'Ana Pinto'),(42,'Anabela Barreiro'),(42,'Belinda Maia'),(42,'Cristina Mota'),(42,'Débora Oliveira'),(42,'Diana Santos'),(42,'Eckhard Bick'),(42,'Elisabete Ranchhod'),(42,'J.J. Almeida'),(42,'Luís Cabral'),(42,'Luís Costa'),(42,'Luís Sarmento'),(42,'Marcirio Chaves'),(42,'Nuno Cardoso'),(42,'Paulo Rocha'),(42,'Rachel Aires'),(42,'Rosário Silva'),(42,'Rui Vilela'),(42,'Susana Afonso'),(43,'Alberto Simões'),(44,'J.C. Ramalho'),(44,'J.G. Rocha'),(44,'J.J. Almeida'),(44,'P.R. Henriques'),(45,'Alberto Simões'),(45,'J.J. Almeida'),(45,'Nuno Carvalho'),(46,'Alberto Simões'),(46,'José João Almeida'),(47,'Alberto Simões'),(47,'José João Almeida'),(48,'J.B. Barros'),(48,'J.J. Almeida'),(49,'J.J. Almeida'),(50,'Alberto Simões'),(50,'J. João Almeida'),(51,'Alberto Simões'),(51,'J.J. Almeida'),(51,'Xavier Gómez Guinovart'),(52,'Alberto Simões'),(52,'José João Almeida'),(52,'Xavier Gomez Guinovart'),(53,'J.J. Almeida'),(54,'Alberto Simões'),(54,'Álvaro Iriarte Sanromán'),(54,'José João Almeida'),(55,'J.J. Almeida'),(55,'P.R. Henriques'),(56,'Alberto Simões'),(56,'Eckhard Bick'),(56,'J.J. Almeida'),(56,'Rui Vilela'),(57,'Ana Silva'),(57,'J.J. Almeida'),(57,'Jorge Rocha'),(57,'Pedro Henriques'),(57,'Ricardo Henriques'),(58,'José João Almeida'),(58,'Santos, André'),(59,'Brett Drury'),(59,'Helena Morais'),(59,'J.J. Almeida'),(60,'A. M. Simões'),(60,'J.J. Almeida'),(61,'Drury, Brett'),(61,'J.J. Almeida'),(61,'Torgo, Luis'),(62,'Alberto Simões'),(62,'José João Almeida'),(62,'Rúben Fonseca'),(63,'Alberto Simões'),(63,'J. João Almeida'),(64,'J.J. Almeida'),(64,'L.S. Barbosa'),(65,'Alberto Simões'),(65,'Anália Lourenço'),(65,'Eugénio Ferreira'),(65,'Isabel Rocha'),(65,'José João Almeida'),(65,'Miguel Rocha'),(66,'J.J. Almeida'),(66,'José Nuno Oliveira'),(66,'Nuno Ramos Carvalho'),(67,'Brett Drury'),(67,'J.J. Almeida'),(67,'Luis Torgo'),(68,'Ana Silva'),(68,'J.J. Almeida'),(68,'Jorge Gustavo Rocha'),(68,'Mario Ricardo Henriques'),(68,'Pedro Rangel Henriques'),(69,'Alberto Simões'),(69,'José João Almeida'),(70,'Alberto Simões'),(70,'J.J. Almeida'),(71,'Alberto M. Simões'),(71,'J.J. Almeida'),(72,'Alberto Manuel Simões'),(72,'J.J. Almeida'),(72,'José Alves Castro'),(73,'Brett Drury'),(73,'José João Almeida'),(74,'J.J. Almeida'),(74,'L.S. Barbosa'),(75,'J.B. Barros'),(75,'J.J. Almeida'),(76,'J.C. Ramalho'),(76,'J.J. Almeida'),(76,'P.R. Henriques'),(77,'J.J. Almeida'),(78,'F. Mário Martins'),(78,'J.J. Almeida'),(78,'P.R. Henriques'),(79,'Alberto Manuel Simões'),(79,'J.J. Almeida'),(80,'Alberto Simões'),(80,'José João Almeida'),(80,'Nuno Carvalho'),(81,'Alberto Simões'),(81,'J. João Almeida'),(82,'J.J. Almeida'),(83,'J.B. Barros'),(83,'J.J. Almeida'),(84,'J.J. Almeida'),(84,'L.S. Barbosa'),(85,'Alberto Simões'),(86,'J.J. Almeida'),(86,'Ulisses Pinto'),(87,'J.C. Ramalho'),(87,'J.G. Rocha'),(87,'J.J. Almeida'),(87,'J.L. Faria'),(87,'M.R. Henriques'),(87,'P.R. Henriques'),(88,'Alberto Simões'),(88,'José João Almeida'),(89,'Bruno Martins'),(90,'Brett Drury'),(90,'Helena Morais'),(90,'J.J. Almeida'),(91,'J.J. Almeida'),(92,'J.J. Almeida'),(93,'Alberto Simões'),(93,'Ana Soares'),(93,'João Filipe Machado'),(93,'José João Almeida'),(94,'{projecto Camila}'),(95,'Alberto Simões'),(95,'José João Almeida, André Santos'),(96,'Almeida, J.J.'),(96,'Barbosa, L.S.'),(96,'Barros, J.B.'),(96,'Neves, L.F.'),(97,'Brett Drury'),(97,'Helena Morais'),(97,'J.J. Almeida'),(98,'J.J. Almeida'),(98,'L.S. Barbosa'),(99,'J.J. Almeida'),(100,'J.C. Ramalho'),(100,'J.G. Rocha'),(100,'J.J. Almeida'),(100,'P.R. Henriques'),(101,'Jose Joao Almeida'),(101,'Maria João Varanda Pereira'),(101,'Nuno Ramos Carvalho'),(101,'Pedro Rangel Henriques'),(102,'J.J. Almeida'),(102,'Ulisses Pinto'),(103,'Alberto Simões'),(103,'Alexandre Carvalho'),(103,'António R. Fernandes'),(103,'J. João Almeida'),(104,'Alberto Manuel Simões'),(104,'J.J. Almeida'),(105,'Alberto Simões'),(105,'J. Gustavo Rocha'),(105,'J.J. Almeida'),(105,'P. Rangel Henriques'),(106,'Alberto Simões'),(106,'Bruno Martins'),(106,'J.J. Almeida'),(106,'José Castro'),(106,'Paulo Silva'),(107,'José João Dias de Almeida'),(108,'Alberto Manuel Simões'),(108,'J.J. Almeida'),(109,'J.J. Almeida'),(110,'Alberto Simões, José João Almeida'),(110,'Rita Farinha'),(111,'Alberto Simões'),(111,'J. Gustavo Rocha'),(111,'J.J. Almeida'),(111,'P. Rangel Henriques'),(111,'Sónia Moreira'),(112,'Alberto Simões'),(112,'José João Almeida');
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

-- Dump completed on 2013-05-19 23:48:02
