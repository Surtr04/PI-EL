SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ped` DEFAULT CHARACTER SET utf8 ;
USE `ped` ;

-- -----------------------------------------------------
-- Table `ped`.`sip_supervisores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_supervisores` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `identificador` VARCHAR(8) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `web` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `identificador_UNIQUE` (`identificador` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_autores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_autores` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `identificador` VARCHAR(8) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `web` VARCHAR(45) NOT NULL ,
  UNIQUE INDEX `identificador_UNIQUE` (`identificador` ASC) ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_groups`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_groups` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(50) NOT NULL ,
  `senha` VARCHAR(90) NOT NULL ,
  `nome` VARCHAR(75) NOT NULL ,
  `email` VARCHAR(75) NOT NULL ,
  `morada` TEXT NOT NULL ,
  `foto` VARCHAR(250) ,
  `grupo` INT NOT NULL ,
  `is_online` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Utilizador_Tipos1_idx` (`grupo` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) ,
  CONSTRAINT `fk_Utilizador_Tipos1`
    FOREIGN KEY (`grupo` )
    REFERENCES `ped`.`sip_groups` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2;


-- -----------------------------------------------------
-- Table `ped`.`sip_categorias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_categorias` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `inicio` DATE NOT NULL ,
  `fim` DATE NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_sips`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_sips` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `ident` VARCHAR(20) NOT NULL ,
  `titulo` VARCHAR(45) NOT NULL ,
  `subtitulo` VARCHAR(45) NOT NULL ,
  `data_inic` DATE NULL ,
  `data_fim` DATE NOT NULL ,
  `data_submissao` DATETIME NOT NULL ,
  `privado` TINYINT(1) NOT NULL ,
  `submetido` INT NOT NULL ,
  `id_categoria` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_SIP_Utilizador1_idx` (`submetido` ASC) ,
  INDEX `fk_sip_sips_sip_categorias1_idx` (`id_categoria` ASC) ,
  CONSTRAINT `fk_SIP_Utilizador1`
    FOREIGN KEY (`submetido` )
    REFERENCES `ped`.`sip_users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sip_sips_sip_categorias1`
    FOREIGN KEY (`id_categoria` )
    REFERENCES `ped`.`sip_categorias` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_resumos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_resumos` (
  `id_sip` INT NOT NULL ,
  `ordem` INT NOT NULL ,
  `para` VARCHAR(1000) NOT NULL ,
  PRIMARY KEY (`id_sip`, `ordem`) ,
  INDEX `fk_Resumo_SIP1_idx` (`id_sip` ASC) ,
  CONSTRAINT `fk_Resumo_SIP1`
    FOREIGN KEY (`id_sip` )
    REFERENCES `ped`.`sip_sips` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_resultados`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_resultados` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `id_sip` INT NOT NULL ,
  `realname` VARCHAR(45) NOT NULL ,
  `url` VARCHAR(45) NOT NULL ,
  `desc` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_sip_resultados_sip_sips1_idx` (`id_sip` ASC) ,
  CONSTRAINT `fk_sip_resultados_sip_sips1`
    FOREIGN KEY (`id_sip` )
    REFERENCES `ped`.`sip_sips` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_sips_autores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_sips_autores` (
  `id_sip` INT NOT NULL ,
  `id_autor` INT NOT NULL ,
  PRIMARY KEY (`id_sip`, `id_autor`) ,
  INDEX `fk_SIPautor_SIP1_idx` (`id_sip` ASC) ,
  INDEX `fk_sip_sips_autores_sip_autores1_idx` (`id_autor` ASC) ,
  CONSTRAINT `fk_SIPautor_SIP1`
    FOREIGN KEY (`id_sip` )
    REFERENCES `ped`.`sip_sips` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sip_sips_autores_sip_autores1`
    FOREIGN KEY (`id_autor` )
    REFERENCES `ped`.`sip_autores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_sips_supervisores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_sips_supervisores` (
  `id_sip` INT NOT NULL ,
  `id_supervisor` INT NOT NULL ,
  PRIMARY KEY (`id_sip`, `id_supervisor`) ,
  INDEX `fk_SIPsupervisor_SIP1_idx` (`id_sip` ASC) ,
  INDEX `fk_sip_ sips_supervisores_sip_supervisores1_idx` (`id_supervisor` ASC) ,
  CONSTRAINT `fk_SIPsupervisor_SIP1`
    FOREIGN KEY (`id_sip` )
    REFERENCES `ped`.`sip_sips` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sip_ sips_supervisores_sip_supervisores1`
    FOREIGN KEY (`id_supervisor` )
    REFERENCES `ped`.`sip_supervisores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_logs`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_logs` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `utilizador` INT NOT NULL ,
  `data` DATETIME NOT NULL ,
  `operacao` VARCHAR(45) NOT NULL ,
  `descricao` VARCHAR(100) NOT NULL ,
  `auto` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_logs_Utilizador1_idx` (`utilizador` ASC) ,
  CONSTRAINT `fk_logs_Utilizador1`
    FOREIGN KEY (`utilizador` )
    REFERENCES `ped`.`sip_users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_perms_tipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_perms_tipo` (
  `id_perm` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id_perm`) ,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_perms`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_perms` (
  `id_perm` INT NOT NULL ,
  `id_grupo` INT NOT NULL ,
  `perm` VARCHAR(4) NOT NULL ,
  PRIMARY KEY (`id_perm`, `id_grupo`) ,
  INDEX `fk_sip_perms_sip_groups1_idx` (`id_grupo` ASC) ,
  INDEX `fk_sip_perms_sip_perms_tipo1_idx` (`id_perm` ASC) ,
  CONSTRAINT `fk_sip_perms_sip_groups1`
    FOREIGN KEY (`id_grupo` )
    REFERENCES `ped`.`sip_groups` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sip_perms_sip_perms_tipo1`
    FOREIGN KEY (`id_perm` )
    REFERENCES `ped`.`sip_perms_tipo` (`id_perm` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_logs_params`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_logs_params` (
  `id_log` INT NOT NULL ,
  `key` VARCHAR(20) NOT NULL ,
  `value` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`key`, `id_log`) ,
  INDEX `fk_sip_logs_params_sip_logs1_idx` (`id_log` ASC) ,
  CONSTRAINT `fk_sip_logs_params_sip_logs1`
    FOREIGN KEY (`id_log` )
    REFERENCES `ped`.`sip_logs` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_sips_stats`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_sips_stats` (
  `id_sip` INT NOT NULL ,
  `dia` DATE NOT NULL ,
  `visualizacoes` INT NOT NULL ,
  `downzip` INT NOT NULL ,
  PRIMARY KEY (`id_sip`, `dia`) ,
  CONSTRAINT `fk_sips_sips_stats_sip_sips1`
    FOREIGN KEY (`id_sip` )
    REFERENCES `ped`.`sip_sips` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ped`.`sip_categorias_grupos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ped`.`sip_categorias_grupos` (
  `id_categoria` INT NOT NULL ,
  `id_grupo` INT NOT NULL ,
  PRIMARY KEY (`id_categoria`, `id_grupo`) ,
  INDEX `fk_sip_categorias_grupos_sip_categorias1_idx` (`id_categoria` ASC) ,
  INDEX `fk_sip_categorias_grupos_sip_groups1_idx` (`id_grupo` ASC) ,
  CONSTRAINT `fk_sip_categorias_grupos_sip_categorias1`
    FOREIGN KEY (`id_categoria` )
    REFERENCES `ped`.`sip_categorias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sip_categorias_grupos_sip_groups1`
    FOREIGN KEY (`id_grupo` )
    REFERENCES `ped`.`sip_groups` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE USER `pedman` IDENTIFIED BY 'D}60za7vEi_-OfF';

grant ALL on TABLE `ped`.`sip_autores` to pedman;
grant ALL on TABLE `ped`.`sip_categorias` to pedman;
grant ALL on TABLE `ped`.`sip_groups` to pedman;
grant ALL on TABLE `ped`.`sip_logs` to pedman;
grant ALL on TABLE `ped`.`sip_perms` to pedman;
grant ALL on TABLE `ped`.`sip_perms_tipo` to pedman;
grant ALL on TABLE `ped`.`sip_resultados` to pedman;
grant ALL on TABLE `ped`.`sip_resumos` to pedman;
grant ALL on TABLE `ped`.`sip_sips` to pedman;
grant ALL on TABLE `ped`.`sip_sips_autores` to pedman;
grant ALL on TABLE `ped`.`sip_sips_supervisores` to pedman;
grant ALL on TABLE `ped`.`sip_supervisores` to pedman;
grant ALL on TABLE `ped`.`sip_users` to pedman;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ped`.`sip_groups`
-- -----------------------------------------------------
START TRANSACTION;
USE `ped`;
INSERT INTO `ped`.`sip_groups` (`id`, `nome`) VALUES (1, 'Administrador');
INSERT INTO `ped`.`sip_groups` (`id`, `nome`) VALUES (2, 'Visitante');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ped`.`sip_users`
-- -----------------------------------------------------
START TRANSACTION;
USE `ped`;
INSERT INTO `ped`.`sip_users` (`id`, `username`, `senha`, `nome`, `email`, `morada`, `foto`, `grupo`, `is_online`) VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin', 'admin@localhost', 'Internet', NULL, 1, 0);

COMMIT;
