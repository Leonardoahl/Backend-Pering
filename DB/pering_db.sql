-- MySQL Script generated by MySQL Workbench
-- Mon Sep 18 18:51:40 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pering
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pering
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pering` DEFAULT CHARACTER SET utf8 ;
USE `pering` ;

-- -----------------------------------------------------
-- Table `pering`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `firstname` VARCHAR(50) NOT NULL,
  `lastname` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `birthdate` DATE NULL,
  `profilepic` VARCHAR(400) NULL,
  `description` VARCHAR(400) NULL,
  `register_date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`hashtag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`hashtag` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`posts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `publication_date` TIMESTAMP NULL,
  `likes` INT NULL,
  `content` VARCHAR(250) NULL,
  `fk_users_id` BIGINT NOT NULL,
  `fk_hashtag_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `fk_users_id`, `fk_hashtag_id`),
  INDEX `fk_posts_users_idx` (`fk_users_id` ASC) VISIBLE,
  INDEX `fk_posts_hashtag1_idx` (`fk_hashtag_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_id`
    FOREIGN KEY (`fk_users_id`)
    REFERENCES `pering`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hashtag_id`
    FOREIGN KEY (`fk_hashtag_id`)
    REFERENCES `pering`.`hashtag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`connections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`connections` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `acepted` TINYINT(1) NULL,
  `sender` VARCHAR(45) NULL,
  `receiver` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`comments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(250) NULL,
  `likes` INT NULL,
  `comment_date` TIMESTAMP NULL,
  `fk_posts_id` BIGINT NOT NULL,
  `fk_users_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `fk_posts_id`, `fk_users_id`),
  INDEX `fk_comments_posts1_idx` (`fk_posts_id` ASC) VISIBLE,
  INDEX `fk_comments_users1_idx` (`fk_users_id` ASC) VISIBLE,
  CONSTRAINT `fk_posts_id`
    FOREIGN KEY (`fk_posts_id`)
    REFERENCES `pering`.`posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usersid`
    FOREIGN KEY (`fk_users_id`)
    REFERENCES `pering`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`soft_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`soft_skills` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`tech_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`tech_skills` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`users_has_soft_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`users_has_soft_skills` (
  `fk_users_id` BIGINT NOT NULL,
  `fk_soft_skills_id` BIGINT NOT NULL,
  PRIMARY KEY (`fk_users_id`, `fk_soft_skills_id`),
  INDEX `fk_users_has_soft_skills_soft_skills1_idx` (`fk_soft_skills_id` ASC) VISIBLE,
  INDEX `fk_users_has_soft_skills_users1_idx` (`fk_users_id` ASC) VISIBLE,
  CONSTRAINT `fk_has_soft_skills_user_id`
    FOREIGN KEY (`fk_users_id`)
    REFERENCES `pering`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_has_soft_skills_skill_id`
    FOREIGN KEY (`fk_soft_skills_id`)
    REFERENCES `pering`.`soft_skills` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`users_has_tech_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`users_has_tech_skills` (
  `fk_users_id` BIGINT NOT NULL,
  `fk_tech_skills_id` BIGINT NOT NULL,
  PRIMARY KEY (`fk_users_id`, `fk_tech_skills_id`),
  INDEX `fk_users_has_tech_skills_tech_skills1_idx` (`fk_tech_skills_id` ASC) VISIBLE,
  INDEX `fk_users_has_tech_skills_users1_idx` (`fk_users_id` ASC) VISIBLE,
  CONSTRAINT `fk_has_tech_skills_user_id`
    FOREIGN KEY (`fk_users_id`)
    REFERENCES `pering`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_has_tech_skills_skill_id`
    FOREIGN KEY (`fk_tech_skills_id`)
    REFERENCES `pering`.`tech_skills` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pering`.`users_has_connections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pering`.`users_has_connections` (
  `fk_users_id` BIGINT NOT NULL,
  `fk_connections_id` INT NOT NULL,
  PRIMARY KEY (`fk_users_id`, `fk_connections_id`),
  INDEX `fk_users_has_connections_connections1_idx` (`fk_connections_id` ASC) VISIBLE,
  INDEX `fk_users_has_connections_users1_idx` (`fk_users_id` ASC) VISIBLE,
  CONSTRAINT `fk_has_connections_users_id`
    FOREIGN KEY (`fk_users_id`)
    REFERENCES `pering`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_has_connections_connections_id`
    FOREIGN KEY (`fk_connections_id`)
    REFERENCES `pering`.`connections` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
