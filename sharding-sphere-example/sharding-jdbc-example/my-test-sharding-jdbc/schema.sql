SET NAMES utf8mb4;

-- ----------------------------
-- 创建数据库 my-test0 及相关表
-- ----------------------------
CREATE DATABASE IF NOT EXISTS `my-test0`;
USE `my-test0`;

DROP TABLE IF EXISTS `book_0`;
CREATE TABLE `book_0` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `book_1`;
CREATE TABLE `book_1` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- 创建数据库 my-test1 及相关表
-- ----------------------------
CREATE DATABASE IF NOT EXISTS `my-test1`;
USE `my-test1`;

DROP TABLE IF EXISTS `book_0`;
CREATE TABLE `book_0` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `book_1`;
CREATE TABLE `book_1` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- 创建数据库 my-test2 及相关表
-- ----------------------------
CREATE DATABASE IF NOT EXISTS `my-test2`;
USE `my-test2`;

DROP TABLE IF EXISTS `book_0`;
CREATE TABLE `book_0` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `book_1`;
CREATE TABLE `book_1` (
	`id` INT ( 11 ) NOT NULL,
	`name` VARCHAR ( 255 ) DEFAULT NULL,
	`count` INT ( 11 ) DEFAULT NULL,
	PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;