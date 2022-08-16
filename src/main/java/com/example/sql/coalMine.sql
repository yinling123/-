-- 该文件用于存储数据库语句

CREATE DATABASE coal;

USE coal;

#煤流检验信息表
CREATE TABLE coalmine(
                         `index` INT NOT NULL AUTO_INCREMENT,
                         `area` INT,
                         `datetime` TIMESTAMP,
                         `type` VARCHAR(10),
                         `length` INT,
                         `width` INT,
                         PRIMARY KEY(`index`))

SELECT * FROM coalmine;

#用户信息表
CREATE TABLE users(
                      username VARCHAR(30) NOT NULL,
                      `password` VARCHAR(20) NOT NULL,
                      `type` ENUM('管理员','用户') NOT NULL,
                      email VARCHAR(30) NOT NULL,
                      PRIMARY KEY(username,`type`)
)

SELECT * FROM users;

