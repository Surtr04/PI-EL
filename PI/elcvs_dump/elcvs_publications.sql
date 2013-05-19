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
-- Table structure for table `publications`
--

DROP TABLE IF EXISTS `publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `key` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `year` int(11) NOT NULL,
  `institutions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_publications_institutions1_idx` (`institutions_id`),
  CONSTRAINT `fk_publications_institutions1` FOREIGN KEY (`institutions_id`) REFERENCES `institutions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES (1,'INPROCEEDINGS','xata04:tx','{TX} --- {V}alidação de {XML} baseada em tipos dinâmicos',2004,NULL),(2,'MASTERSTHESIS','teseambs','Parallel Corpora word alignment and applications',2004,NULL),(3,'INPROCEEDINGS','xata:museudapessoa','{H}istórias de {V}ida + {P}rocessamento {E}strutural = {M}useu da {P}essoa',2003,NULL),(4,'TECHREPORT','Almeida96c','From {BiBTeX} to {HTML} semantic nets',1996,NULL),(5,'ARTICLE','jj96','{NLlex} -- a tool to generate lexical analysers for natural language',1996,NULL),(6,'INPROCEEDINGS','freq2002',' Cálculo de frequências de palavras para entradas de dicionários através do uso conjunto de analisad',2002,NULL),(7,'INPROCEEDINGS','ABNO97a','\\textsc{Camila}: Formal Software Engineering Supported by Functional Programming',1997,NULL),(8,'INPROCEEDINGS','Ramalho95','Algebraic Specification of Documents',1995,NULL),(9,'INPROCEEDINGS','LREC12.967','Structural alignment of plain text books',2012,NULL),(10,'INPROCEEDINGS','brett:lrec',' Identification, extraction and population of collective named entities from business news',2010,NULL),(11,'INPROCEEDINGS','navegante08','{NAVEGANTE} --- An Intrusive Browseing Framework',2008,NULL),(12,'INPROCEEDINGS','jj2001x','Smallbook -- comando para produção de livros em pequena escala',2000,NULL),(13,'INPROCEEDINGS','jspell2002',' Jspell.pm -- um módulo de análise morfológica para uso em processamento de linguagem natural',2002,NULL),(14,'ARTICLE','velharia2','Sistemas de Programação Modular',1988,NULL),(15,'INPROCEEDINGS','Almeida94c','Jspell -- um módulo para análise léxica genérica de linguagem natural',1995,NULL),(16,'INPROCEEDINGS','markers09','Bilingual Example Segmentation based on Markers Hypothesis',2009,NULL),(17,'INPROCEEDINGS','drury1','Classifying News Stories to Estimate the Direction of a Stock Market Index',2011,NULL),(18,'INPROCEEDINGS','epia:DruryA09','Construction of a Local Domain Ontology from News Stories',2009,NULL),(19,'ARTICLE','parguess2002','Grabbing parallel corpora from the web',2002,NULL),(20,'INCOLLECTION','harem:rena','{RENA} - Reconhecedor de Entidades',2007,NULL),(21,'INPROCEEDINGS','propor-apslt08',' A Textual Rewriting system for NLP',2008,NULL),(22,'ARTICLE','sepln2003','{NATools} -- A Statistical Word Aligner Workbench',2003,NULL),(23,'INPROCEEDINGS','Barbosa2000','Polytypic Recursion Patterns',2000,NULL),(24,'INPROCEEDINGS','Ramalho96','Document Semantics: two approaches',1996,NULL),(25,'INPROCEEDINGS','ABNO97b','\\textsc{Camila}: Prototyping and Refinement of Constructive Specifications',1997,NULL),(26,'INPROCEEDINGS','Ulisses96','Tratamento automático de termos compostos',1996,NULL),(27,'ARTICLE','ocr2010','A Case Study of Rule Based and Probabilistic Word Error Correction of Portuguese OCR Text in a \"Real',2010,NULL),(28,'INPROCEEDINGS','epia-music-2007','Using Text Mining Techniques for Classical Music Scores Analysis',2007,NULL),(29,'INPROCEEDINGS','xmldt99','{XML::DT} a Perl Down-Translation module',1999,NULL),(30,'INPROCEEDINGS','xata05:tdt','Inferência de tipos em documentos {XML}',2005,NULL),(31,'INPROCEEDINGS','xata06:xmlauto','Geração dinâmica de {API}s {P}erl para criação de {XML}',2006,NULL),(32,'INPROCEEDINGS','wims2011','Identification of fine grained feature based event and sentiment phrases from business news stories',2011,NULL),(33,'TECHREPORT','PDavid','David -- Processamento estruturado de documentos',1998,NULL),(34,'INPROCEEDINGS','cgiauto08','{CGI::Auto} --- Automatic Web-Service Creation',2008,NULL),(35,'ARTICLE','cP','Cooking Perl with flex',2002,NULL),(36,'INPROCEEDINGS','Reis98','Etiquetador morfo-sintáctico para o Português',1998,NULL),(37,'ARTICLE','sepln08','Bilingual Terminology Extraction based on Translation Patterns',2008,NULL),(38,'INPROCEEDINGS','dag2002','Directory Attribute Grammars',2002,NULL),(39,'INPROCEEDINGS','RPA99','{MAPit} - A tool set for automatically generation of {HTML} Maps',1999,NULL),(40,'ARTICLE','velharia1','Descrição de um Núcleo Gráfico e Aplicação em {CAD}',1987,NULL),(41,'INCOLLECTION','avalon:jspell','Jspellando nas morfolimpíadas: Sobre a participação do {Jspell} nas Morfolimpíadas',2007,NULL),(42,'INPROCEEDINGS','linguateca','Linguateca: um centro de recursos distribuído para o processamento computacional da língua portugues',2004,NULL),(43,'ARTICLE','xmldt2','{XML::DT} - Down-Translating XML',2004,NULL),(44,'ARTICLE','RRAH99','SGML documents: Where does quality go?',1999,NULL),(45,'INPROCEEDINGS','nuno1',' Oml: A Scripting Approach For Manipulating Ontologies',2011,NULL),(46,'INPROCEEDINGS','bucc2010','Automatic Parallel Corpora and Bilingual Terminology extraction from Parallel WebSites ',2010,NULL),(47,'ARTICLE','sepln07','Parallel Corpora based Translation Resources Extraction',2007,NULL),(48,'TECHREPORT','tlc89','Teoria das Linguagens ',1988,NULL),(49,'INPROCEEDINGS','Almeida94b','{GPC} -- a Tool for higher-order grammar specification',1994,NULL),(50,'INPROCEEDINGS','elpub06-t2o','Publishing multilingual ontologies: a quick way of obtaining feedback',2006,NULL),(51,'ARTICLE','sepln2004','Distributed Translation Memories implementation using WebServices',2004,NULL),(52,'INPROCEEDINGS','xata04:mtd','Memórias de Tradução Distribuídas',2004,NULL),(53,'INPROCEEDINGS','Almeida96a','Especificação e tratamento de Dicionários',1996,NULL),(54,'ARTICLE','da2012','Dicionário-Aberto -- A Source of Resources for the Portuguese Language Processing',2012,NULL),(55,'INPROCEEDINGS','AH97','Dynamic Dictionary = cooperative information sources',1998,NULL),(56,'INPROCEEDINGS','xata05:fs','Representação em {XML} da {F}loresta {S}intáctica',2005,NULL),(57,'INPROCEEDINGS','Gis99','Formal Methods for {GI} Systems Development',1999,NULL),(58,'INPROCEEDINGS','sepln:bookcleaner','{Text::Perfide::BookCleaner}, a Perl module to clean and normalize plain text books',2011,NULL),(59,'ARTICLE','drury4','Maintenance of a Fuzzy Temporal Ontology from News Stories',2012,NULL),(60,'ARTICLE','speaker:sepln2001','Text to speech -- a rewriting system approach',2001,NULL),(61,'INPROCEEDINGS','drury-torgo-almeida:2011:ROBUS','Guided Self Training for Sentiment Classification',2011,NULL),(62,'INPROCEEDINGS','MP07','{Makefile::Parallel} Dependency Specification Language',2007,NULL),(63,'INPROCEEDINGS','eamt06','Combinatory Examples Extraction for Machine Translation',2006,NULL),(64,'TECHREPORT','Barbosa95','System Prototyping in \\textsc{Camila}',1995,NULL),(65,'INPROCEEDINGS','epia-bio-2007','An Ontology-Based Approach To Systems Biology Literature Retrieval and Processing',2007,NULL),(66,'ARTICLE','wikiscore','{Wiki::Score} A collaborative environment for music transcription and publishing',2012,NULL),(67,'ARTICLE','drury5','Classifying News Stories with a Constrained Learning Strategy to Estimate the Direction of a Market ',2012,NULL),(68,'INPROCEEDINGS','RSea99','Sobre a Utilização de Metodologias Formais no Desenvolvimento de {SIG}',1999,NULL),(69,'INPROCEEDINGS','lrec06','{$T_2O$} --- Recycling Thesauri into a Multilingual Ontology',2006,NULL),(70,'INPROCEEDINGS','xata06:navegante','Navegante: um proxy de ordem superior para navegação intusiva',2006,NULL),(71,'INPROCEEDINGS','elpub2002','Library::* -- a toolkit for digital libraries',2002,NULL),(72,'INPROCEEDINGS','APL2k2.Parguess','Extracção de corpora paralelo a partir da web: construção e disponibilização',2003,NULL),(73,'INPROCEEDINGS','LREC12.611','The Minho Quotation Resource',2012,NULL),(74,'TECHREPORT','Barbosa95a','\\textsc{Camila}: A reference Manual',1995,NULL),(75,'INPROCEEDINGS','Almeida96b','{YaLG} a tool for higher-order grammar specification',1996,NULL),(76,'ARTICLE','Ramalho98','Algebraic specification of documents',1998,NULL),(77,'INPROCEEDINGS','Almeida95a','{YaLG} -- extending {DCG} for natural language processing',1995,NULL),(78,'INPROCEEDINGS','graminteractivas1990','Mecanismos para Especificação e Prototipagem de Interfaces Utilizador-Sistema',1990,NULL),(79,'INPROCEEDINGS','elpub2003','Music publishing',2003,NULL),(80,'ARTICLE','opencert2010','Testing as a Certification Approach',2010,NULL),(81,'ARTICLE','sepln06','{NatServer:} A Client-Server Architecture for building Parallel Corpora applications',2006,NULL),(82,'TECHREPORT','Natura','{Natura} - Natural language processing',1997,NULL),(83,'TECHREPORT','estruturasdedados90','Estruturas de Dados',1990,NULL),(84,'TECHREPORT','Barbosa95b','Growing Up With \\textsc{Camila}',1995,NULL),(85,'INPROCEEDINGS','cp3a:natools2003','Alinhamento de corpora paralelos',2003,NULL),(86,'TECHREPORT','jspell1','Manual de Utilizador do {JSpell}',1994,NULL),(87,'INPROCEEDINGS','museums98','Adapting Museum Structures for the Web: No Changes Needed!',1998,NULL),(88,'INPROCEEDINGS','xata07:xmltmx','{XML::TMX} --- Processamento de Memórias de Tradução de Grandes Dimensões',2007,NULL),(89,'INPROCEEDINGS','cp3a:kvec2003','{Lingua-Biterm}: um módulo Perl para extracção de terminologia bilingue',2003,NULL),(90,'INPROCEEDINGS','drury3','An Error Correction Methodology for Time Dependent Ontologies',2011,NULL),(91,'TECHREPORT','jj95','{NLlex} -- a tool to generate lexical analysers for natural language',1995,NULL),(92,'INPROCEEDINGS','Almeida94a','Documents in an Informatic Academic environment',1994,NULL),(93,'INPROCEEDINGS','fala2010-triPsi','Automating psycholinguistic statistics computation: Procura-Palavras ',2010,NULL),(94,'TECHREPORT','Camila','\\textsc{Camila} - A Platform for Software Mathematical Development',1998,NULL),(95,'INPROCEEDINGS','lrec10:bigorna','Bigorna -- A Toolkit for Orthography Migration Challenges',2010,NULL),(96,'INPROCEEDINGS','ABBN98','On The Development of \\textsc{Camila}',1998,NULL),(97,'INPROCEEDINGS','drury2',' Magellan: An Adaptive Ontology Driven \"breaking Financial News\" Recommender',2011,NULL),(98,'TECHREPORT','BA97a','Systems Prototyping in \\textsc{Camila}',1998,NULL),(99,'MISC','nllex','NLlex -- Natural Language LEX',1996,NULL),(100,'INPROCEEDINGS','SGML97','SGML Documents: where does quality go?',1997,NULL),(101,'INPROCEEDINGS','CAPH12a','Probabilistic SynSet Based Concept Location',2012,NULL),(102,'MISC','jspell','Jspell a module for morphological analyser for natural language',1997,NULL),(103,'INPROCEEDINGS','elpub06-blind','Transcoding for Web Accessibility for the Blind: Semantics from Structure',2006,NULL),(104,'INPROCEEDINGS','APL2k2.Synthesis','Geração de voz com sotaque',2003,NULL),(105,'INPROCEEDINGS','alfarrabio2001','Alfarrábio: Adding value to an Heterogeneous Site Collection',2001,NULL),(106,'INPROCEEDINGS','cp3a:terminum2003','Projecto {TerminUM}',2003,NULL),(107,'PHDTHESIS','tesejj','Dicionários dinâmicos multi-fonte',2003,NULL),(108,'INPROCEEDINGS','xata:xmldt','Engenharia reversa de {HTML} usando tecnologia {XML}',2003,NULL),(109,'INPROCEEDINGS','Almeida98','Programação de dicionários',1998,NULL),(110,'INPROCEEDINGS','lrec10:dicaberto','Processing and Extracting Data from Dicionário Aberto',2010,NULL),(111,'INPROCEEDINGS','mp2001','{Museu da Pessoa} -- Arquitectura',2001,NULL),(112,'INCOLLECTION','avalon:avalinha','Avaliação de alinhadores',2007,NULL);
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
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
