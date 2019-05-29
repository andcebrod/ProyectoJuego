-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: juegopokemon
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `jugadores` (
  `idJugador` int(11) NOT NULL AUTO_INCREMENT,
  `nombreJugador` varchar(15) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `idPokemonFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `idPokemonFK` (`idPokemonFK`),
  CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`idPokemonFK`) REFERENCES `pokemons` (`idPokemon`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (7,'Manuel',2),(8,'Pedro',1),(9,'pepe',1),(10,'pepito',2),(11,'mengano',1),(12,'fulano',2),(13,'a',1),(14,'as',2),(15,'asa',1),(16,'swa',2),(17,'aqwe',1),(18,'aswqwe',2),(19,'Pepe',1),(20,'Juan',2),(21,'José',1),(22,'Francisco',2),(23,'Manolo',1),(24,'Joseluis',2),(25,'Ola',1),(26,'Adios',2),(27,'Juan',1),(28,'Pepe',2),(29,'JUGADOR1',1),(30,'JUGADOR2',2),(31,'JUGADOR1',1),(32,'JUGADOR2',2),(33,'JUGADOR1',2),(34,'JUGADOR2',1),(35,'jugador1',1),(36,'jugador2',1),(37,'j1',1),(38,'j2',1),(39,'Sulivan',1),(40,'Serresiete',2);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineamovimientos`
--

DROP TABLE IF EXISTS `lineamovimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lineamovimientos` (
  `idMovimientoFK` int(11) NOT NULL,
  `idPokemonFK` int(11) NOT NULL,
  PRIMARY KEY (`idMovimientoFK`,`idPokemonFK`),
  KEY `idPokemonFK` (`idPokemonFK`),
  CONSTRAINT `lineamovimientos_ibfk_1` FOREIGN KEY (`idPokemonFK`) REFERENCES `pokemons` (`idPokemon`),
  CONSTRAINT `lineamovimientos_ibfk_2` FOREIGN KEY (`idMovimientoFK`) REFERENCES `movimientos` (`idMovimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineamovimientos`
--

LOCK TABLES `lineamovimientos` WRITE;
/*!40000 ALTER TABLE `lineamovimientos` DISABLE KEYS */;
INSERT INTO `lineamovimientos` VALUES (4,1),(5,1),(6,1),(7,1),(1,2),(2,2),(3,2),(4,2);
/*!40000 ALTER TABLE `lineamovimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movimientos` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMovimiento` varchar(30) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `danioMovimiento` int(3) DEFAULT NULL,
  `idTipoFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `idTipoFK` (`idTipoFK`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`idTipoFK`) REFERENCES `tipos` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'Hidrobomba',110,2),(2,'Mordisco',60,14),(3,'Hidropulso',60,2),(4,'Placaje',40,10),(5,'Lanzallamas',100,7),(6,'Envite Ígneo',120,7),(7,'Tajo Aéreo',75,17);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemons`
--

DROP TABLE IF EXISTS `pokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pokemons` (
  `idPokemon` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePokemon` varchar(30) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `puntosSalud` int(3) DEFAULT NULL,
  `ataque` int(3) DEFAULT NULL,
  `defensa` int(3) DEFAULT NULL,
  `idTipoFK` int(11) DEFAULT NULL,
  `imagen` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idPokemon`),
  KEY `idTipoFK` (`idTipoFK`),
  CONSTRAINT `pokemons_ibfk_1` FOREIGN KEY (`idTipoFK`) REFERENCES `tipos` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons`
--

LOCK TABLES `pokemons` WRITE;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` VALUES (1,'Charizard',460,293,280,7,'charizard.png'),(2,'Blastoise',462,291,328,2,'blastoise.png');
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuaciones`
--

DROP TABLE IF EXISTS `puntuaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puntuaciones` (
  `idPuntuacion` int(11) NOT NULL AUTO_INCREMENT,
  `puntuacion` int(15) DEFAULT NULL,
  `idJugadorFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPuntuacion`),
  KEY `idJugadorFK` (`idJugadorFK`),
  CONSTRAINT `puntuaciones_ibfk_1` FOREIGN KEY (`idJugadorFK`) REFERENCES `jugadores` (`idJugador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuaciones`
--

LOCK TABLES `puntuaciones` WRITE;
/*!40000 ALTER TABLE `puntuaciones` DISABLE KEYS */;
INSERT INTO `puntuaciones` VALUES (1,2,33),(2,6,37),(3,3,40);
/*!40000 ALTER TABLE `puntuaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipos` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipo` varchar(30) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'Acero'),(2,'Agua'),(3,'Bicho'),(4,'Dragón'),(5,'Eléctrico'),(6,'Fantasma'),(7,'Fuego'),(8,'Hielo'),(9,'Lucha'),(10,'Normal'),(11,'Planta'),(12,'Psíquico'),(13,'Roca'),(14,'Siniestro'),(15,'Tierra'),(16,'Veneno'),(17,'Volador');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-29  8:33:47
