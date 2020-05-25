CREATE DATABASE  IF NOT EXISTS `networkdata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `networkdata`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: networkdata
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `clientsID` int NOT NULL,
  `client1IP` varchar(16) NOT NULL,
  `client1MAC` varchar(18) NOT NULL,
  `client2IP` varchar(16) NOT NULL,
  `client2MAC` varchar(18) NOT NULL,
  PRIMARY KEY (`clientsID`),
  UNIQUE KEY `clientsID_UNIQUE` (`clientsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='In dieser Tabelle werden die beteiligten Clients pro Test gespeichert.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `networkmeasurment`
--

DROP TABLE IF EXISTS `networkmeasurment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `networkmeasurment` (
  `measurmentID` int NOT NULL,
  `networkspeed` float NOT NULL,
  `interval` float NOT NULL,
  `transfer` float NOT NULL,
  `bandwith` float NOT NULL,
  `testID` int NOT NULL,
  PRIMARY KEY (`measurmentID`),
  UNIQUE KEY `measurmentID_UNIQUE` (`measurmentID`),
  KEY `test in networkmeasurement_idx` (`testID`),
  CONSTRAINT `test in networkmeasurement` FOREIGN KEY (`testID`) REFERENCES `networktest` (`testID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Diese Tabelle speichert die aktuelle Netzwerk Messung.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `networktest`
--

DROP TABLE IF EXISTS `networktest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `networktest` (
  `testID` int NOT NULL,
  `timestamp` datetime NOT NULL,
  `clients` int NOT NULL,
  `measurement` int NOT NULL,
  PRIMARY KEY (`testID`),
  UNIQUE KEY `testID_UNIQUE` (`testID`),
  KEY `clientsID_idx` (`clients`),
  CONSTRAINT `clientsID` FOREIGN KEY (`clients`) REFERENCES `clients` (`clientsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='In dieser Tabelle werden einzelne Netzwerktests gespeichert';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-25 21:38:53
