CREATE DATABASE  IF NOT EXISTS `tienda_ropa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tienda_ropa`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda_ropa
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `codLocal` int NOT NULL AUTO_INCREMENT,
  `descLocal` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `codLocalidad` int DEFAULT NULL,
  PRIMARY KEY (`codLocal`),
  KEY `local_localidad_fk_idx` (`codLocalidad`),
  CONSTRAINT `local_localidad_fk` FOREIGN KEY (`codLocalidad`) REFERENCES `localidad` (`codLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidad` (
  `codLocalidad` int NOT NULL AUTO_INCREMENT,
  `descLocalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenda`
--

DROP TABLE IF EXISTS `prenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenda` (
  `codPrenda` int NOT NULL AUTO_INCREMENT,
  `nombrePrenda` varchar(45) DEFAULT NULL,
  `talle` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `codTipoPrenda` int NOT NULL,
  PRIMARY KEY (`codPrenda`),
  KEY `prenda_tipoPrenda_fk_idx` (`codTipoPrenda`),
  CONSTRAINT `prenda_tipoPrenda_fk` FOREIGN KEY (`codTipoPrenda`) REFERENCES `tipoprenda` (`codTipoPrenda`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenda`
--

LOCK TABLES `prenda` WRITE;
/*!40000 ALTER TABLE `prenda` DISABLE KEYS */;
INSERT INTO `prenda` VALUES (1,'pantalon polo M negro','M','negro','polo',1),(2,'Campera verde marca Crawford','L','Verde','Crawford',4),(3,'Remera Union Pacific azul','S','Azul','Union Pacific',2);
/*!40000 ALTER TABLE `prenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoprenda`
--

DROP TABLE IF EXISTS `tipoprenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoprenda` (
  `codTipoPrenda` int NOT NULL AUTO_INCREMENT,
  `descTipoPrenda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codTipoPrenda`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoprenda`
--

LOCK TABLES `tipoprenda` WRITE;
/*!40000 ALTER TABLE `tipoprenda` DISABLE KEYS */;
INSERT INTO `tipoprenda` VALUES (1,'pantalon'),(2,'remera'),(3,'medias'),(4,'campera'),(5,'Ambo');
/*!40000 ALTER TABLE `tipoprenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nomUsuario` varchar(45) DEFAULT NULL,
  `contrase??a` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tipoUsuario` varchar(45) DEFAULT NULL,
  `informacionPago` varchar(255) DEFAULT NULL,
  `codigoPostal` int DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'fedeBruschi','fede1234','Federico','Bruschi','fedejbruschi@gmail.com','cliente','Visa nro 123456789012 cvv 123 fecha venc 02/30',2000,'Rosario','Espa??a 270','2022-10-19'),(2,'John',NULL,'John','Doe','johndoe@gmail.com',NULL,NULL,NULL,'Rosario','Espa??a 400',NULL),(4,'EdwardElric',NULL,'Edward','Elric','edElric@gmail.com',NULL,NULL,NULL,'Venado Tuerto','Santa Fe 1975','2000-05-10'),(5,'RoyMustang',NULL,'Roy','Mustang','royMustang@gmail.com',NULL,NULL,NULL,'Funes','Italia 1400','1999-11-20'),(8,'AlphonseElric',NULL,'Alphonse','Elric','alElric@gmail.com',NULL,'Mastercard nro 1231234334564567 cvv 444 fecha venc 05/28',2400,'Venado Tuerto','Santa Fe 1978',NULL),(9,'MarioSantos',NULL,'Mario','Santos','mSantos@gmail.com',NULL,'Visa nro 584379164852 cvv 888 fecha venc 02/32',2100,'Caballito','San Lorenzo 458',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `nroVenta` int NOT NULL AUTO_INCREMENT,
  `fechaVenta` date DEFAULT NULL,
  `importeTotal` float DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  `idPrenda` int DEFAULT NULL,
  PRIMARY KEY (`nroVenta`),
  KEY `ventaClienteFK_idx` (`idCliente`),
  KEY `ventaPrendaFK_idx` (`idPrenda`),
  CONSTRAINT `ventaClienteFK` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventaPrendaFK` FOREIGN KEY (`idPrenda`) REFERENCES `prenda` (`codPrenda`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2022-11-20',250.32,8,2),(2,'2022-11-20',250.32,8,2),(3,'1999-11-20',500.64,1,3),(4,'1999-11-20',456.3,9,3);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-31  3:07:33
