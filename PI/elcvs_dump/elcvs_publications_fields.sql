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
-- Table structure for table `publications_fields`
--

DROP TABLE IF EXISTS `publications_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publications_fields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publications_id` int(11) NOT NULL,
  `fields_id` int(11) NOT NULL,
  `value` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_publications_fields_publications1_idx` (`publications_id`),
  KEY `fk_publications_fields_bibfields1_idx` (`fields_id`),
  CONSTRAINT `fk_publications_fields_publications1` FOREIGN KEY (`publications_id`) REFERENCES `publications` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_publications_fields_bibfields1` FOREIGN KEY (`fields_id`) REFERENCES `bibfields` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications_fields`
--

LOCK TABLES `publications_fields` WRITE;
/*!40000 ALTER TABLE `publications_fields` DISABLE KEYS */;
INSERT INTO `publications_fields` VALUES (1,1,1,'ARRAY(0x7fdae3ac1f50)'),(2,1,2,'PT'),(3,1,3,'February'),(4,1,4,'José João Almeida and Alberto Simões'),(5,1,5,'INPROCEEDINGS'),(6,1,6,'{XATA 2004} - XML, Aplicações e Tecnologias Associadas'),(7,1,7,'José Carlos Ramalho and Alberto Simões'),(8,1,8,'http://alfarrabio.di.uminho.pt/~albie/publications/xata04-tx.pdf'),(9,1,9,' Desde o advento do SGML e posteriormente do XML, que a validação de documentos tem sido focada. Esta validação surgiu para analisar a estrutura dos documentos SGML e XML usando DTDs. Além dessa, e devido às restrições do XML em relação ao SGML, a validação de XML bem formado também tem sido usada. Mais recentemente, os Schema e Schematron vieram permitir a validação a um nível superior: não só a estrutura do documento mas também alguma validação de conteúdo. Neste artigo apresentamos a ferramenta TX que visa outro nível de validação, em que os tipos possam ser mais ricos e/ou calculados dinamicamente, e onde se possa definir funções de anotação e/ou correcção das porções do documento que não sigam as especificações. '),(10,1,10,'{TX} --- {V}alidação de {XML} baseada em tipos dinâmicos'),(11,1,11,'972-99166-0-8'),(12,1,12,'217--224'),(13,1,13,'2004'),(14,2,14,'http://alfarrabio.di.uminho.pt/~albie/publications/msc.pdf'),(15,2,15,'Parallel Corpora word alignment and applications'),(16,2,16,'2004'),(17,4,17,'ARRAY(0x7fdae3ab8d20)'),(18,4,18,'http://natura.di.uminho.pt/~jcr/bib/dbib.html'),(19,4,19,'From {BiBTeX} to {HTML} semantic nets'),(20,4,20,'1996'),(21,5,21,'{NLlex} -- a tool to generate lexical analysers for natural language'),(22,5,22,'81--90'),(23,5,23,'1996'),(24,6,24,'2002'),(25,8,25,'AMiLP\'95'),(26,8,26,'1995'),(27,9,27,'may'),(28,9,28,'2012'),(29,17,29,'1-4'),(30,20,30,'2007'),(31,32,31,'Rajendra Akerkar'),(32,32,32,'27--34'),(33,32,33,'2011'),(34,58,34,'2011'),(35,65,35,'2007'),(36,66,36,'ARTICLE'),(37,66,37,'{Wiki::Score} A collaborative environment for music transcription and publishing'),(38,66,38,'DOI 10.3233/ISU-2012-0647'),(39,67,39,'2012'),(40,90,40,'2011'),(41,101,41,'2012');
/*!40000 ALTER TABLE `publications_fields` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-19 19:40:00
