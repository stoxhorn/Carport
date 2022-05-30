-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema carport_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `carport_db` ;

-- -----------------------------------------------------
-- Schema carport_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carport_db` DEFAULT CHARACTER SET utf8 ;
USE `carport_db` ;

-- -----------------------------------------------------
-- Table `carport_db`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`user` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`user` (
  `email` VARCHAR(155) NOT NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`customer` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`customer` (
  `user_email` VARCHAR(155) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `zip_code` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`user_email`),
  INDEX `fk_customer_user1_idx` (`user_email` ASC) VISIBLE,
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC) VISIBLE,
  CONSTRAINT `fk_customer_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `carport_db`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`employee` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`employee` (
  `user_email` VARCHAR(155) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  INDEX `fk_employee_user_idx` (`user_email` ASC) VISIBLE,
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC) VISIBLE,
  PRIMARY KEY (`user_email`),
  CONSTRAINT `fk_employee_user`
    FOREIGN KEY (`user_email`)
    REFERENCES `carport_db`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`customer_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`customer_request` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`customer_request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_user_email` VARCHAR(155) NOT NULL,
  `status` ENUM('pending', 'completed') NULL,
  `carport_width` VARCHAR(45) NULL,
  `carport_length` VARCHAR(45) NULL,
  `roof_type` VARCHAR(45) NULL,
  `roof_material` VARCHAR(45) NULL,
  `roof_slope` VARCHAR(45) NULL,
  `shed_width` VARCHAR(45) NULL,
  `shed_length` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `deleted_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_request_customer1_idx` (`customer_user_email` ASC) VISIBLE,
  UNIQUE INDEX `customer_user_email_UNIQUE` (`customer_user_email` ASC) VISIBLE,
  CONSTRAINT `fk_customer_request_customer1`
    FOREIGN KEY (`customer_user_email`)
    REFERENCES `carport_db`.`customer` (`user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`materials_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`materials_list` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`materials_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_request_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_materials_list_customer_request1_idx` (`customer_request_id` ASC) VISIBLE,
  CONSTRAINT `fk_materials_list_customer_request1`
    FOREIGN KEY (`customer_request_id`)
    REFERENCES `carport_db`.`customer_request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`materials` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`materials` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carport_db`.`materials_list_lines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carport_db`.`materials_list_lines` ;

CREATE TABLE IF NOT EXISTS `carport_db`.`materials_list_lines` (
  `id` INT NOT NULL,
  `materials_list_id` INT NOT NULL,
  `materials_id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  `qantity` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_materials_list_lines_materials_list1_idx` (`materials_list_id` ASC) VISIBLE,
  INDEX `fk_materials_list_lines_materials1_idx` (`materials_id` ASC) VISIBLE,
  CONSTRAINT `fk_materials_list_lines_materials_list1`
    FOREIGN KEY (`materials_list_id`)
    REFERENCES `carport_db`.`materials_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_materials_list_lines_materials1`
    FOREIGN KEY (`materials_id`)
    REFERENCES `carport_db`.`materials` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO user (email, password, role ) VALUES ('admin@admin.com', 'admin', 'admin');
INSERT INTO employee (user_email, first_name, last_name ) VALUES ('admin@admin.com', 'admin', 'admin');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
