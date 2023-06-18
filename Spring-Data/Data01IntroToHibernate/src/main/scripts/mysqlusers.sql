DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `bookadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `bookdb`.* TO `bookadmin`@`%`;
CREATE USER IF NOT EXISTS `bookuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `bookdb`.* TO `bookuser`@`%`;
FLUSH PRIVILEGES;

drop table if exists book cascade;
drop table if exists author;

create table book
(
    id        bigint not null auto_increment primary key,
    isbn      varchar(255),
    publisher varchar(255),
    title     varchar(255),
    author_id BIGINT
) engine = InnoDB;

create table author
(
    id         bigint not null auto_increment primary key,
    first_name varchar(255),
    last_name  varchar(255)
) engine = InnoDB;