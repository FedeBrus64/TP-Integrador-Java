CREATE DATABASE  IF NOT EXISTS `tienda_ropa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tienda_ropa`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tienda_ropa
-- ------------------------------------------------------
-- Server version	8.0.26

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
  `telefono` int DEFAULT NULL,
  PRIMARY KEY (`codLocal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Local 1','España 1237',4498669),(2,'Local 2','Córdoba 1171',4498924),(3,'Local 3','San Martín 1001',4242551);
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
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
  `precioUnitario` double DEFAULT NULL,
  `codLocal` int DEFAULT NULL,
  PRIMARY KEY (`codPrenda`),
  KEY `prenda_tipoPrenda_fk_idx` (`codTipoPrenda`),
  KEY `prendaLocalFK_idx` (`codLocal`),
  CONSTRAINT `prenda_tipoPrenda_fk` FOREIGN KEY (`codTipoPrenda`) REFERENCES `tipoprenda` (`codTipoPrenda`),
  CONSTRAINT `prendaLocalFK` FOREIGN KEY (`codLocal`) REFERENCES `local` (`codLocal`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenda`
--

LOCK TABLES `prenda` WRITE;
/*!40000 ALTER TABLE `prenda` DISABLE KEYS */;
INSERT INTO `prenda` VALUES (4,'Pantalon Polo','M','Negro','Polo',1,28000,1),(5,'Camisa Polo','S','Blanco','Polo',2,23000,1),(6,'Pantalón Polo','L','Azul','Polo',1,31000,2),(7,'Camisa Polo','L','Azul','Polo',2,30000,3),(8,'Camisa Polo','L','Rojo','Polo',2,2500,3),(9,'Pantalón Polo','L','Azul','Polo',1,2500,2),(10,'Pantalón Polo','L','Blanco','Polo',1,2500,1),(11,'Saco Crawford Negro Largo','42','Negro','Crawford',5,32000,2);
/*!40000 ALTER TABLE `prenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoprenda`
--

DROP TABLE IF EXISTS `tipoprenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoprenda` (
  `codTipoPrenda` int NOT NULL AUTO_INCREMENT,
  `descTipoPrenda` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codTipoPrenda`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoprenda`
--

LOCK TABLES `tipoprenda` WRITE;
/*!40000 ALTER TABLE `tipoprenda` DISABLE KEYS */;
INSERT INTO `tipoprenda` VALUES (1,'Pantalon'),(2,'Camisa'),(3,'Zapatos'),(4,'Remera'),(5,'Saco');
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
  `contraseña` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tipoUsuario` varchar(45) DEFAULT NULL,
  `codigoPostal` int DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'fedeBruschi','fede1234','Federico','Bruschi','fedejbruschi@gmail.com','admin',2000,'Rosario','EspaÃ±a 2700','2022-10-19'),(2,'johnDoe','john456','John','Doe','johnDoe@gmail.com','empleado',NULL,'San Nicolas de los Arroyos','Pte Roca 1234','2017-02-23'),(25,'keanu4000','asdasd','Keanu','Reeves','kreeves@gmail.com','cliente',2000,'Rosario','San Marcos 3300',NULL),(26,'ejemplo2000','hola','Nombre','Apellido','ejemplo@gmail.com','cliente',1200,'Rosario','Italia 3000',NULL);
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
  `formaPago` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nroVenta`),
  KEY `ventaClienteFK_idx` (`idCliente`),
  KEY `ventaPrendaFK_idx` (`idPrenda`),
  CONSTRAINT `ventaClienteFK` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `ventaPrendaFK` FOREIGN KEY (`idPrenda`) REFERENCES `prenda` (`codPrenda`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (2,'2025-03-13',2500,25,8,'Transferencia','Pendiente'),(3,'2025-03-13',2500,25,10,'Transferencia','Pendiente'),(4,'2025-03-13',2500,25,8,'Transferencia','Pendiente'),(5,'2025-03-13',2500,25,9,'Transferencia','Pendiente'),(6,'2025-03-13',2500,25,9,'Transferencia','Pendiente'),(7,'2025-03-31',30000,25,7,'Transferencia','Pendiente'),(8,'2025-03-31',32000,25,11,'Transferencia','Pendiente'),(9,'2025-04-03',32000,25,11,'Tarjeta de DÃ©bito','Pendiente'),(10,'2025-04-03',32000,26,11,'Tarjeta de CrÃ©dito','Pendiente');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tienda_ropa'
--

--
-- Dumping routines for database 'tienda_ropa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-03 19:55:29
