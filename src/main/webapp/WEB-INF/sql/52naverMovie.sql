CREATE DATABASE mydb4;
USE mydb4;
SHOW CREATE TABLE Movie;

CREATE TABLE `Movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `time` varchar(255) DEFAULT '0',
  `releaseDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

SHOW CREATE TABLE Director;
CREATE TABLE `Director` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
 
 SHOW CREATE TABLE MovieDirector;
 CREATE TABLE `MovieDirector` (
   `movieId` int(11) NOT NULL,
   `directorId` int(11) NOT NULL,
   PRIMARY KEY (`movieId`,`directorId`),
   KEY `fk_Movie_has_Director_Director1_idx` (`directorId`),
   KEY `fk_Movie_has_Director_Movie_idx` (`movieId`),
   CONSTRAINT `fk_Movie_has_Director_Director1` FOREIGN KEY (`directorId`) REFERENCES `Director` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `fk_Movie_has_Director_Movie` FOREIGN KEY (`movieId`) REFERENCES `Movie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;