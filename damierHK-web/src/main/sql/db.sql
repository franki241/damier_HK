CREATE DATABASE damierHKDB  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON damierHKDB.* TO root@localhost IDENTIFIED BY 'damierHK' WITH GRANT OPTION;
CREATE TABLE damierHKDB.GameEntry
(
id int NOT NULL,
winnerColor varchar(45) NOT NULL
);