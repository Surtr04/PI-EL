-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 04, 2013 at 02:47 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT=0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ped`
--
CREATE DATABASE `ped` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ped`;

-- --------------------------------------------------------

--
-- Table structure for table `sip_autores`
--

CREATE TABLE IF NOT EXISTS `sip_autores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` varchar(8) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `web` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificador_UNIQUE` (`identificador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `sip_autores`
--

INSERT INTO `sip_autores` (`id`, `identificador`, `nome`, `email`, `web`) VALUES
(4, 'pgXXXXX', 'Aluno UM', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `sip_categorias`
--

CREATE TABLE IF NOT EXISTS `sip_categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `inicio` date NOT NULL,
  `fim` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `sip_categorias`
--

INSERT INTO `sip_categorias` (`id`, `nome`, `inicio`, `fim`) VALUES
(1, 'Outros Trabalhos', '2000-01-01', '2200-12-31'),
(2, 'Trabalho de Casa 1', '2012-12-03', '2012-12-10'),
(3, 'Trabalho de Casa 2', '2012-12-31', '2013-01-03');

-- --------------------------------------------------------

--
-- Table structure for table `sip_groups`
--

CREATE TABLE IF NOT EXISTS `sip_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `sip_groups`
--

INSERT INTO `sip_groups` (`id`, `nome`) VALUES
(1, 'Administrador'),
(2, 'Visitante'),
(3, 'Consumidor'),
(4, 'Alunos');

-- --------------------------------------------------------

--
-- Table structure for table `sip_logs`
--

CREATE TABLE IF NOT EXISTS `sip_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `utilizador` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `operacao` varchar(45) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `auto` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_logs_Utilizador1_idx` (`utilizador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `sip_logs`
--

INSERT INTO `sip_logs` (`id`, `utilizador`, `data`, `operacao`, `descricao`, `auto`) VALUES
(1, 1, '2012-12-21 21:46:25', 'Auth/login', 'Admin login', 1),
(2, 1, '2012-12-21 22:15:10', 'Auth/logout', 'Admin logout', 1),
(3, 1, '2012-12-22 11:04:23', 'Auth/login', 'Admin login', 1),
(5, 1, '2012-12-22 10:50:00', 'Mudar/Ficheiros', 'O utilizador alterou os ficheiros.', 0),
(6, 1, '2012-12-22 12:08:23', 'Auth/logout', 'Admin logout', 1),
(7, 1, '2012-12-22 12:08:34', 'Auth/login', 'Admin login', 1),
(8, 1, '2012-12-22 12:09:17', 'Auth/logout', 'Admin logout', 1),
(9, 1, '2012-12-22 12:09:24', 'Auth/login', 'Admin login', 1),
(10, 1, '2012-12-22 13:04:46', 'Auth/logout', 'Admin logout', 1),
(11, 1, '2012-12-22 16:05:48', 'Auth/login', 'Admin login', 1),
(12, 1, '2012-12-22 16:45:51', 'Auth/logout', 'Admin logout', 1),
(13, 1, '2012-12-24 18:32:59', 'Auth/logout', 'Admin logout', 1),
(14, 1, '2012-12-26 14:57:15', 'Auth/login', 'Admin login', 1),
(15, 1, '2012-12-26 17:26:28', 'Auth/logout', 'Admin logout', 1),
(16, 1, '2012-12-26 18:48:52', 'Auth/login', 'Admin login', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sip_perms`
--

CREATE TABLE IF NOT EXISTS `sip_perms` (
  `id_perm` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  `perm` varchar(4) NOT NULL,
  PRIMARY KEY (`id_perm`,`id_grupo`),
  KEY `fk_sip_perms_sip_groups1_idx` (`id_grupo`),
  KEY `fk_sip_perms_sip_perms_tipo1_idx` (`id_perm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sip_perms`
--

INSERT INTO `sip_perms` (`id_perm`, `id_grupo`, `perm`) VALUES
(2, 1, 'SIUD'),
(2, 2, '----'),
(2, 4, '----'),
(3, 1, 'SIUD'),
(3, 2, '----'),
(3, 4, '----'),
(4, 1, 'SIUD'),
(4, 2, '----'),
(4, 4, '----'),
(5, 1, 'SIUD'),
(5, 2, '----'),
(5, 4, 'S---'),
(6, 1, 'SIUD'),
(6, 2, '----'),
(6, 4, 'SIUD'),
(7, 1, 'SIUD'),
(7, 2, '----'),
(7, 4, '----'),
(8, 1, 'SIUD'),
(8, 2, '----'),
(8, 4, '----'),
(9, 1, 'SIUD'),
(9, 2, '----'),
(9, 4, '----');

-- --------------------------------------------------------

--
-- Table structure for table `sip_perms_tipo`
--

CREATE TABLE IF NOT EXISTS `sip_perms_tipo` (
  `id_perm` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  PRIMARY KEY (`id_perm`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `sip_perms_tipo`
--

INSERT INTO `sip_perms_tipo` (`id_perm`, `nome`) VALUES
(7, 'All Sips'),
(8, 'Authors'),
(5, 'Categories'),
(3, 'Groups'),
(4, 'Logs'),
(6, 'Own Sips'),
(9, 'Supervisors'),
(2, 'Users');

-- --------------------------------------------------------

--
-- Table structure for table `sip_resultados`
--

CREATE TABLE IF NOT EXISTS `sip_resultados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_sip` int(11) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL,
  `desc` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sip_resultados_sip_sips1_idx` (`id_sip`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `sip_resultados`
--

INSERT INTO `sip_resultados` (`id`, `id_sip`, `realname`, `url`, `desc`) VALUES
(1, 6, 'PI_Fase1.pdf', '2C5E.pdf', 'PI Fase 1'),
(2, 7, 'PI_Fase1.pdf', 'C959.pdf', 'PI Fase 1'),
(3, 8, 'PI_Fase1.pdf', 'C1FC.pdf', 'PI Fase 1'),
(14, 19, 'PI_Fase1.pdf', '8EE9.pdf', 'PI Fase 1'),
(16, 21, 'PI_Fase1.pdf', '2A0E.pdf', 'PI Fase 1');

-- --------------------------------------------------------

--
-- Table structure for table `sip_resumos`
--

CREATE TABLE IF NOT EXISTS `sip_resumos` (
  `id_sip` int(11) NOT NULL,
  `ordem` int(11) NOT NULL,
  `para` varchar(1000) NOT NULL,
  PRIMARY KEY (`id_sip`,`ordem`),
  KEY `fk_Resumo_SIP1_idx` (`id_sip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sip_resumos`
--

INSERT INTO `sip_resumos` (`id_sip`, `ordem`, `para`) VALUES
(6, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet elit eget est semper blandit. Donec tempor turpis fermentum mauris ultrices iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris consectetur neque a justo varius luctus. Nam eu sem vitae libero tincidunt aliquet. Nunc ut mi vitae eros interdum mollis. Morbi eu quam neque, ac gravida tellus. Proin eleifend, risus vel lobortis rhoncus, mauris libero bibendum tortor, quis pretium lectus dolor in purus. Suspendisse posuere tristique lobortis. Etiam tempus posuere arcu.'),
(6, 2, 'Integer aliquet nunc in nisi pellentesque eget dictum urna sollicitudin. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vivamus et erat vel nunc viverra semper ac eget purus. Donec nec egestas dui. Nulla vel dolor eget nulla varius lobortis vitae sed nisl. Quisque commodo, odio in dapibus aliquam, arcu sem pulvinar orci, a molestie lectus metus vitae mauris.'),
(6, 3, 'Suspendisse congue ornare sapien a tristique. Nunc quis faucibus diam. Etiam eget leo risus. Aenean ac dolor in sapien mollis viverra sed eget lectus. Cras at arcu arcu, a sodales tortor. Nullam tempor, tortor sed fermentum mollis, nibh eros malesuada dui, non mattis nulla nibh et mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras id elit id nunc accumsan posuere. In augue dolor, tristique et consequat quis, feugiat quis massa. Suspendisse potenti. Duis a venenatis odio. Maecenas ornare feugiat purus, hendrerit pharetra leo scelerisque nec.'),
(6, 4, 'Proin consequat dui vel tellus sollicitudin lacinia. Aliquam et augue nunc, vel dapibus sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium, lorem ac commodo mollis, nulla enim tempus lorem, in lacinia leo sem id ligula. Praesent vel ipsum lectus. Praesent varius tempor nibh non ultricies. Donec id diam elit, ac auctor eros. Vivamus dapibus mattis quam, vitae malesuada enim aliquam ac. Nullam accumsan, tortor nec rhoncus facilisis, augue leo convallis erat, sed accumsan ante lorem vel lorem. Morbi aliquet interdum purus, eu condimentum dui fermentum sit amet. Nam faucibus lectus et diam rutrum non posuere dui tincidunt. In euismod bibendum quam sed hendrerit. Curabitur bibendum purus scelerisque justo cursus vestibulum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.'),
(6, 5, 'Duis vel massa libero, in tristique libero. Phasellus bibendum sodales iaculis. Nullam placerat diam at leo fringilla imperdiet. Cras consequat dapibus elit, et convallis est dapibus non. Suspendisse fermentum vulputate mauris ac tincidunt. Fusce ut tortor turpis, dapibus sodales sapien. Fusce in dui massa, non lacinia nulla. Duis ut dui vel libero vestibulum laoreet. Quisque laoreet dignissim diam, quis adipiscing turpis posuere eu. Morbi odio risus, molestie id aliquet sed, dapibus tempus mauris. Pellentesque faucibus, neque eu adipiscing imperdiet, justo turpis varius neque, a tincidunt tellus tortor ut orci. Sed malesuada neque quis dolor hendrerit gravida. Cras in odio purus. Donec commodo dapibus tortor ac commodo. Vivamus ante est, accumsan ac rutrum in, venenatis sed turpis.'),
(7, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet elit eget est semper blandit. Donec tempor turpis fermentum mauris ultrices iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris consectetur neque a justo varius luctus. Nam eu sem vitae libero tincidunt aliquet. Nunc ut mi vitae eros interdum mollis. Morbi eu quam neque, ac gravida tellus. Proin eleifend, risus vel lobortis rhoncus, mauris libero bibendum tortor, quis pretium lectus dolor in purus. Suspendisse posuere tristique lobortis. Etiam tempus posuere arcu.'),
(7, 2, 'Integer aliquet nunc in nisi pellentesque eget dictum urna sollicitudin. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vivamus et erat vel nunc viverra semper ac eget purus. Donec nec egestas dui. Nulla vel dolor eget nulla varius lobortis vitae sed nisl. Quisque commodo, odio in dapibus aliquam, arcu sem pulvinar orci, a molestie lectus metus vitae mauris.'),
(7, 3, 'Suspendisse congue ornare sapien a tristique. Nunc quis faucibus diam. Etiam eget leo risus. Aenean ac dolor in sapien mollis viverra sed eget lectus. Cras at arcu arcu, a sodales tortor. Nullam tempor, tortor sed fermentum mollis, nibh eros malesuada dui, non mattis nulla nibh et mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras id elit id nunc accumsan posuere. In augue dolor, tristique et consequat quis, feugiat quis massa. Suspendisse potenti. Duis a venenatis odio. Maecenas ornare feugiat purus, hendrerit pharetra leo scelerisque nec.'),
(7, 4, 'Proin consequat dui vel tellus sollicitudin lacinia. Aliquam et augue nunc, vel dapibus sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium, lorem ac commodo mollis, nulla enim tempus lorem, in lacinia leo sem id ligula. Praesent vel ipsum lectus. Praesent varius tempor nibh non ultricies. Donec id diam elit, ac auctor eros. Vivamus dapibus mattis quam, vitae malesuada enim aliquam ac. Nullam accumsan, tortor nec rhoncus facilisis, augue leo convallis erat, sed accumsan ante lorem vel lorem. Morbi aliquet interdum purus, eu condimentum dui fermentum sit amet. Nam faucibus lectus et diam rutrum non posuere dui tincidunt. In euismod bibendum quam sed hendrerit. Curabitur bibendum purus scelerisque justo cursus vestibulum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.'),
(7, 5, 'Duis vel massa libero, in tristique libero. Phasellus bibendum sodales iaculis. Nullam placerat diam at leo fringilla imperdiet. Cras consequat dapibus elit, et convallis est dapibus non. Suspendisse fermentum vulputate mauris ac tincidunt. Fusce ut tortor turpis, dapibus sodales sapien. Fusce in dui massa, non lacinia nulla. Duis ut dui vel libero vestibulum laoreet. Quisque laoreet dignissim diam, quis adipiscing turpis posuere eu. Morbi odio risus, molestie id aliquet sed, dapibus tempus mauris. Pellentesque faucibus, neque eu adipiscing imperdiet, justo turpis varius neque, a tincidunt tellus tortor ut orci. Sed malesuada neque quis dolor hendrerit gravida. Cras in odio purus. Donec commodo dapibus tortor ac commodo. Vivamus ante est, accumsan ac rutrum in, venenatis sed turpis.'),
(8, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet elit eget est semper blandit. Donec tempor turpis fermentum mauris ultrices iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris consectetur neque a justo varius luctus. Nam eu sem vitae libero tincidunt aliquet. Nunc ut mi vitae eros interdum mollis. Morbi eu quam neque, ac gravida tellus. Proin eleifend, risus vel lobortis rhoncus, mauris libero bibendum tortor, quis pretium lectus dolor in purus. Suspendisse posuere tristique lobortis. Etiam tempus posuere arcu.'),
(8, 2, 'Integer aliquet nunc in nisi pellentesque eget dictum urna sollicitudin. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vivamus et erat vel nunc viverra semper ac eget purus. Donec nec egestas dui. Nulla vel dolor eget nulla varius lobortis vitae sed nisl. Quisque commodo, odio in dapibus aliquam, arcu sem pulvinar orci, a molestie lectus metus vitae mauris.'),
(8, 3, 'Suspendisse congue ornare sapien a tristique. Nunc quis faucibus diam. Etiam eget leo risus. Aenean ac dolor in sapien mollis viverra sed eget lectus. Cras at arcu arcu, a sodales tortor. Nullam tempor, tortor sed fermentum mollis, nibh eros malesuada dui, non mattis nulla nibh et mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras id elit id nunc accumsan posuere. In augue dolor, tristique et consequat quis, feugiat quis massa. Suspendisse potenti. Duis a venenatis odio. Maecenas ornare feugiat purus, hendrerit pharetra leo scelerisque nec.'),
(8, 4, 'Proin consequat dui vel tellus sollicitudin lacinia. Aliquam et augue nunc, vel dapibus sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium, lorem ac commodo mollis, nulla enim tempus lorem, in lacinia leo sem id ligula. Praesent vel ipsum lectus. Praesent varius tempor nibh non ultricies. Donec id diam elit, ac auctor eros. Vivamus dapibus mattis quam, vitae malesuada enim aliquam ac. Nullam accumsan, tortor nec rhoncus facilisis, augue leo convallis erat, sed accumsan ante lorem vel lorem. Morbi aliquet interdum purus, eu condimentum dui fermentum sit amet. Nam faucibus lectus et diam rutrum non posuere dui tincidunt. In euismod bibendum quam sed hendrerit. Curabitur bibendum purus scelerisque justo cursus vestibulum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.'),
(8, 5, 'Duis vel massa libero, in tristique libero. Phasellus bibendum sodales iaculis. Nullam placerat diam at leo fringilla imperdiet. Cras consequat dapibus elit, et convallis est dapibus non. Suspendisse fermentum vulputate mauris ac tincidunt. Fusce ut tortor turpis, dapibus sodales sapien. Fusce in dui massa, non lacinia nulla. Duis ut dui vel libero vestibulum laoreet. Quisque laoreet dignissim diam, quis adipiscing turpis posuere eu. Morbi odio risus, molestie id aliquet sed, dapibus tempus mauris. Pellentesque faucibus, neque eu adipiscing imperdiet, justo turpis varius neque, a tincidunt tellus tortor ut orci. Sed malesuada neque quis dolor hendrerit gravida. Cras in odio purus. Donec commodo dapibus tortor ac commodo. Vivamus ante est, accumsan ac rutrum in, venenatis sed turpis.'),
(19, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet elit eget est semper blandit. Donec tempor turpis fermentum mauris ultrices iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris consectetur neque a justo varius luctus. Nam eu sem vitae libero tincidunt aliquet. Nunc ut mi vitae eros interdum mollis. Morbi eu quam neque, ac gravida tellus. Proin eleifend, risus vel lobortis rhoncus, mauris libero bibendum tortor, quis pretium lectus dolor in purus. Suspendisse posuere tristique lobortis. Etiam tempus posuere arcu.'),
(19, 2, 'Integer aliquet nunc in nisi pellentesque eget dictum urna sollicitudin. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vivamus et erat vel nunc viverra semper ac eget purus. Donec nec egestas dui. Nulla vel dolor eget nulla varius lobortis vitae sed nisl. Quisque commodo, odio in dapibus aliquam, arcu sem pulvinar orci, a molestie lectus metus vitae mauris.'),
(19, 3, 'Suspendisse congue ornare sapien a tristique. Nunc quis faucibus diam. Etiam eget leo risus. Aenean ac dolor in sapien mollis viverra sed eget lectus. Cras at arcu arcu, a sodales tortor. Nullam tempor, tortor sed fermentum mollis, nibh eros malesuada dui, non mattis nulla nibh et mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras id elit id nunc accumsan posuere. In augue dolor, tristique et consequat quis, feugiat quis massa. Suspendisse potenti. Duis a venenatis odio. Maecenas ornare feugiat purus, hendrerit pharetra leo scelerisque nec.'),
(19, 4, 'Proin consequat dui vel tellus sollicitudin lacinia. Aliquam et augue nunc, vel dapibus sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium, lorem ac commodo mollis, nulla enim tempus lorem, in lacinia leo sem id ligula. Praesent vel ipsum lectus. Praesent varius tempor nibh non ultricies. Donec id diam elit, ac auctor eros. Vivamus dapibus mattis quam, vitae malesuada enim aliquam ac. Nullam accumsan, tortor nec rhoncus facilisis, augue leo convallis erat, sed accumsan ante lorem vel lorem. Morbi aliquet interdum purus, eu condimentum dui fermentum sit amet. Nam faucibus lectus et diam rutrum non posuere dui tincidunt. In euismod bibendum quam sed hendrerit. Curabitur bibendum purus scelerisque justo cursus vestibulum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.'),
(19, 5, 'Duis vel massa libero, in tristique libero. Phasellus bibendum sodales iaculis. Nullam placerat diam at leo fringilla imperdiet. Cras consequat dapibus elit, et convallis est dapibus non. Suspendisse fermentum vulputate mauris ac tincidunt. Fusce ut tortor turpis, dapibus sodales sapien. Fusce in dui massa, non lacinia nulla. Duis ut dui vel libero vestibulum laoreet. Quisque laoreet dignissim diam, quis adipiscing turpis posuere eu. Morbi odio risus, molestie id aliquet sed, dapibus tempus mauris. Pellentesque faucibus, neque eu adipiscing imperdiet, justo turpis varius neque, a tincidunt tellus tortor ut orci. Sed malesuada neque quis dolor hendrerit gravida. Cras in odio purus. Donec commodo dapibus tortor ac commodo. Vivamus ante est, accumsan ac rutrum in, venenatis sed turpis.'),
(21, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet elit eget est semper blandit. Donec tempor turpis fermentum mauris ultrices iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris consectetur neque a justo varius luctus. Nam eu sem vitae libero tincidunt aliquet. Nunc ut mi vitae eros interdum mollis. Morbi eu quam neque, ac gravida tellus. Proin eleifend, risus vel lobortis rhoncus, mauris libero bibendum tortor, quis pretium lectus dolor in purus. Suspendisse posuere tristique lobortis. Etiam tempus posuere arcu.'),
(21, 2, 'Integer aliquet nunc in nisi pellentesque eget dictum urna sollicitudin. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vivamus et erat vel nunc viverra semper ac eget purus. Donec nec egestas dui. Nulla vel dolor eget nulla varius lobortis vitae sed nisl. Quisque commodo, odio in dapibus aliquam, arcu sem pulvinar orci, a molestie lectus metus vitae mauris.'),
(21, 3, 'Suspendisse congue ornare sapien a tristique. Nunc quis faucibus diam. Etiam eget leo risus. Aenean ac dolor in sapien mollis viverra sed eget lectus. Cras at arcu arcu, a sodales tortor. Nullam tempor, tortor sed fermentum mollis, nibh eros malesuada dui, non mattis nulla nibh et mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras id elit id nunc accumsan posuere. In augue dolor, tristique et consequat quis, feugiat quis massa. Suspendisse potenti. Duis a venenatis odio. Maecenas ornare feugiat purus, hendrerit pharetra leo scelerisque nec.'),
(21, 4, 'Proin consequat dui vel tellus sollicitudin lacinia. Aliquam et augue nunc, vel dapibus sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium, lorem ac commodo mollis, nulla enim tempus lorem, in lacinia leo sem id ligula. Praesent vel ipsum lectus. Praesent varius tempor nibh non ultricies. Donec id diam elit, ac auctor eros. Vivamus dapibus mattis quam, vitae malesuada enim aliquam ac. Nullam accumsan, tortor nec rhoncus facilisis, augue leo convallis erat, sed accumsan ante lorem vel lorem. Morbi aliquet interdum purus, eu condimentum dui fermentum sit amet. Nam faucibus lectus et diam rutrum non posuere dui tincidunt. In euismod bibendum quam sed hendrerit. Curabitur bibendum purus scelerisque justo cursus vestibulum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.'),
(21, 5, 'Duis vel massa libero, in tristique libero. Phasellus bibendum sodales iaculis. Nullam placerat diam at leo fringilla imperdiet. Cras consequat dapibus elit, et convallis est dapibus non. Suspendisse fermentum vulputate mauris ac tincidunt. Fusce ut tortor turpis, dapibus sodales sapien. Fusce in dui massa, non lacinia nulla. Duis ut dui vel libero vestibulum laoreet. Quisque laoreet dignissim diam, quis adipiscing turpis posuere eu. Morbi odio risus, molestie id aliquet sed, dapibus tempus mauris. Pellentesque faucibus, neque eu adipiscing imperdiet, justo turpis varius neque, a tincidunt tellus tortor ut orci. Sed malesuada neque quis dolor hendrerit gravida. Cras in odio purus. Donec commodo dapibus tortor ac commodo. Vivamus ante est, accumsan ac rutrum in, venenatis sed turpis.');

-- --------------------------------------------------------

--
-- Table structure for table `sip_sips`
--

CREATE TABLE IF NOT EXISTS `sip_sips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ident` varchar(20) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `subtitulo` varchar(45) NOT NULL,
  `data_inic` date DEFAULT NULL,
  `data_fim` date NOT NULL,
  `data_submissao` datetime NOT NULL,
  `submetido` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_SIP_Utilizador1_idx` (`submetido`),
  KEY `fk_sip_sips_sip_categorias1_idx` (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `sip_sips`
--

INSERT INTO `sip_sips` (`id`, `ident`, `titulo`, `subtitulo`, `data_inic`, `data_fim`, `data_submissao`, `submetido`, `id_categoria`) VALUES
(6, 'T5', 'TituloX', 'SubtituloX', '2012-03-25', '2012-03-28', '2012-12-31 18:12:24', 1, 3),
(7, 'T5', 'TituloX', 'SubtituloX', '2012-03-25', '2012-03-28', '2013-01-02 11:33:43', 1, 1),
(8, 'T5', 'TituloX', 'SubtituloX', '2012-03-25', '2012-03-28', '2013-01-02 18:28:25', 2, 3),
(19, 'EngLing_T8', 'OutroX', '', NULL, '2013-01-01', '2013-01-04 11:05:04', 2, 3),
(21, 'EngLing_T8', 'OutroX', '', NULL, '2013-01-01', '2013-01-04 14:21:28', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sip_sips_autores`
--

CREATE TABLE IF NOT EXISTS `sip_sips_autores` (
  `id_sip` int(11) NOT NULL,
  `id_autor` int(11) NOT NULL,
  PRIMARY KEY (`id_sip`,`id_autor`),
  KEY `fk_SIPautor_SIP1_idx` (`id_sip`),
  KEY `fk_sip_sips_autores_sip_autores1_idx` (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sip_sips_autores`
--

INSERT INTO `sip_sips_autores` (`id_sip`, `id_autor`) VALUES
(6, 4),
(7, 4),
(8, 4),
(19, 4),
(21, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sip_sips_supervisores`
--

CREATE TABLE IF NOT EXISTS `sip_sips_supervisores` (
  `id_sip` int(11) NOT NULL,
  `id_supervisor` int(11) NOT NULL,
  PRIMARY KEY (`id_sip`,`id_supervisor`),
  KEY `fk_SIPsupervisor_SIP1_idx` (`id_sip`),
  KEY `fk_sip_ sips_supervisores_sip_supervisores1_idx` (`id_supervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sip_sips_supervisores`
--

INSERT INTO `sip_sips_supervisores` (`id_sip`, `id_supervisor`) VALUES
(6, 4),
(7, 4),
(8, 4),
(19, 4),
(21, 4);

-- --------------------------------------------------------

--
-- Table structure for table `sip_supervisores`
--

CREATE TABLE IF NOT EXISTS `sip_supervisores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` varchar(8) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `web` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificador_UNIQUE` (`identificador`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `sip_supervisores`
--

INSERT INTO `sip_supervisores` (`id`, `identificador`, `nome`, `email`, `web`) VALUES
(4, 'jcr', 'Docente supervisor', 'jcr@jcr.pt', 'http://www3.di.uminho.pt/~jcr');

-- --------------------------------------------------------

--
-- Table structure for table `sip_users`
--

CREATE TABLE IF NOT EXISTS `sip_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `senha` varchar(90) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `email` varchar(75) NOT NULL,
  `morada` text NOT NULL,
  `foto` varchar(250) NOT NULL,
  `grupo` int(11) NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_Utilizador_Tipos1_idx` (`grupo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `sip_users`
--

INSERT INTO `sip_users` (`id`, `username`, `senha`, `nome`, `email`, `morada`, `foto`, `grupo`, `is_online`) VALUES
(1, 'xpto', 'db069f1041ae868ddb3e519b6e251d536802b840e98262281f948cb257a34e15', 'Xpto Silva', 'xpto@xpto.pt', 'asdzsdvzs\nadsfvclashdjl', 'b702466d0ca06b2a95fa8eee09b1a415.png', 1, 1),
(2, 'aluno', '11991960d6936cfbe175151137d303e111bdb7344eaefde2860131736f9da800', 'Aluno X', 'aluno@xpto.com', 'dsfjhsljdfl\ndsfksjdfjs\nsdfsjdflsjf\nsdfsflo', '', 4, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sip_logs`
--
ALTER TABLE `sip_logs`
  ADD CONSTRAINT `fk_logs_Utilizador1` FOREIGN KEY (`utilizador`) REFERENCES `sip_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_perms`
--
ALTER TABLE `sip_perms`
  ADD CONSTRAINT `fk_sip_perms_sip_groups1` FOREIGN KEY (`id_grupo`) REFERENCES `sip_groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sip_perms_sip_perms_tipo1` FOREIGN KEY (`id_perm`) REFERENCES `sip_perms_tipo` (`id_perm`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_resultados`
--
ALTER TABLE `sip_resultados`
  ADD CONSTRAINT `fk_sip_resultados_sip_sips1` FOREIGN KEY (`id_sip`) REFERENCES `sip_sips` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_resumos`
--
ALTER TABLE `sip_resumos`
  ADD CONSTRAINT `fk_Resumo_SIP1` FOREIGN KEY (`id_sip`) REFERENCES `sip_sips` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_sips`
--
ALTER TABLE `sip_sips`
  ADD CONSTRAINT `fk_sip_sips_sip_categorias1` FOREIGN KEY (`id_categoria`) REFERENCES `sip_categorias` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_SIP_Utilizador1` FOREIGN KEY (`submetido`) REFERENCES `sip_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_sips_autores`
--
ALTER TABLE `sip_sips_autores`
  ADD CONSTRAINT `fk_SIPautor_SIP1` FOREIGN KEY (`id_sip`) REFERENCES `sip_sips` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sip_sips_autores_sip_autores1` FOREIGN KEY (`id_autor`) REFERENCES `sip_autores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_sips_supervisores`
--
ALTER TABLE `sip_sips_supervisores`
  ADD CONSTRAINT `fk_SIPsupervisor_SIP1` FOREIGN KEY (`id_sip`) REFERENCES `sip_sips` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sip_ sips_supervisores_sip_supervisores1` FOREIGN KEY (`id_supervisor`) REFERENCES `sip_supervisores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sip_users`
--
ALTER TABLE `sip_users`
  ADD CONSTRAINT `fk_Utilizador_Tipos1` FOREIGN KEY (`grupo`) REFERENCES `sip_groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;


GRANT USAGE ON *.* TO 'pedman'@'localhost' IDENTIFIED BY PASSWORD '*16388E53EE361D82036CA1040100E72B0353A21A';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, INDEX, ALTER, CREATE TEMPORARY TABLES, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `ped`.* TO 'pedman'@'localhost';


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
