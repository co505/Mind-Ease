/* DELETES AND RECREATES DATABASE EVERY TIME THE SYSTEM IS BOOTED*/
DROP DATABASE IF EXISTS mindease;
CREATE DATABASE IF NOT EXISTS mindease;
USE mindease;
/****************************************************************/

/* DROPS ALL TABLES IF THEY EXIST (Error Prevention) */

DROP TABLE IF EXISTS users;

/****************************************************************/

/* CREATES ALL TABLES */
create table if not exists users
(
    ID varchar(128) primary key,
    name varchar(128),
    emailAddress varchar(128),
    password varchar(128) /* Encrypt at later date. */
)   engine=InnoDB;
