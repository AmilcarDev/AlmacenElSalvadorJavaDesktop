CREATE DATABASE  IF NOT EXISTS `bdalmacen` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdalmacen`;
-- MySQL dump 10.16  Distrib 10.1.13-MariaDB, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: bdalmacen
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aroma`
--

DROP TABLE IF EXISTS `aroma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aroma` (
  `Id_Aroma` int(11) NOT NULL,
  `Nombre_Aroma` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Aroma`),
  KEY `fk_Aroma_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Aroma_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aroma`
--

LOCK TABLES `aroma` WRITE;
/*!40000 ALTER TABLE `aroma` DISABLE KEYS */;
INSERT INTO `aroma` VALUES (1,'AMADERADO Y CANELA',2),(2,'AMADERADA',2),(3,'FLORAL',2),(4,'HERBAL O VERDE',2),(5,'ARIENTAL',2),(6,'FRUTAL',2),(7,'FRESCAS',2),(8,'CHRIPRES',2);
/*!40000 ALTER TABLE `aroma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacora` (
  `idBitacora` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(45) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`idBitacora`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
INSERT INTO `bitacora` VALUES (1,'2017-01-16 18:21:12','Admin','Inicio de sesion en el sistema INTEGRA '),(2,'2017-01-16 18:23:00','Admin','Fin de sesion en el sistema INTEGRA'),(3,'2017-01-16 19:01:16','Admin','Inicio de sesion en el sistema INTEGRA '),(4,'2017-01-16 19:28:15','Admin','Inicio de sesion en el sistema INTEGRA '),(5,'2017-01-16 19:29:32','Admin','Inicio de sesion en el sistema INTEGRA ');
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camara`
--

DROP TABLE IF EXISTS `camara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camara` (
  `Id_Camara` int(11) NOT NULL,
  `Nombre_Camara` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Camara`),
  KEY `fk_Camara_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Camara_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camara`
--

LOCK TABLES `camara` WRITE;
/*!40000 ALTER TABLE `camara` DISABLE KEYS */;
INSERT INTO `camara` VALUES (1,'13MP',1),(2,'21MP',1),(3,'5MP',1),(4,'3MP',1);
/*!40000 ALTER TABLE `camara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `Id_Categoria` int(11) NOT NULL,
  `Nombre_Categoria` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Categoria`),
  KEY `fk_Categoria_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Categoria_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'TACTIL',1),(2,'NO TACTIL',1),(3,'SPRAY',2),(4,'ROLON',2),(5,'COLONIA',2),(6,'DEPORTIVO',3),(7,'VESTIR',3),(8,'CASUAL',3),(9,'DEPORTIVO',4),(10,'VESTIR',4),(11,'CASUAL',4);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clasificacion`
--

DROP TABLE IF EXISTS `clasificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clasificacion` (
  `Id_Clasificacion` int(11) NOT NULL,
  `Nombre_Clasificacion` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Clasificacion`),
  KEY `fk_Clasificacion_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Clasificacion_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificacion`
--

LOCK TABLES `clasificacion` WRITE;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` VALUES (1,'MUJER',2),(2,'HOMBRE',2),(3,'MUJER',3),(4,'HOMBRE',3),(5,'MUJER',4),(6,'HOMBRE',4),(7,'GAMA BAJA',1),(8,'GAMA MEDIA',1),(9,'GAMA ALTA',1);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `Id_Color` int(11) NOT NULL,
  `Nombre_Color` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Color`),
  KEY `fk_Color_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Color_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'NEGRO',3),(2,'ROJO',3),(3,'VERDE',3),(4,'MORADO',3),(5,'AMARILLO',3),(6,'VINO',3),(7,'ANARANJADO',3),(8,'BLANCO',3),(9,'NEGRO-BLANCO',3),(10,'AZUL',3),(11,'CAFE',3),(12,'VERDE',2),(13,'ROJO',2),(14,'GRIS',2),(15,'CAFE',2),(16,'AZUL',2),(17,'VERDE',4),(18,'ROJO',4),(19,'GRIS',4),(20,'CAFE',4),(21,'AZUL',4),(22,'NEGRO',4),(23,'GRIS ROJO',1),(24,'GRIS',1),(25,'CAFE',1),(26,'NEGRO',1);
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `Id_Compras` int(11) NOT NULL,
  `Numero_Factura` varchar(45) DEFAULT NULL,
  `Tipo_Pago` varchar(45) DEFAULT NULL,
  `Fecha_Compra` varchar(45) DEFAULT NULL,
  `Fecha_Pago` varchar(45) DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Id_Proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Compras`),
  KEY `fk_Compras_Usuario1_idx` (`Id_Usuario`),
  CONSTRAINT `fk_Compras_Usuario1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenido`
--

DROP TABLE IF EXISTS `contenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenido` (
  `Id_Contenido` int(11) NOT NULL,
  `Nombre_Contenido` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Contenido`),
  KEY `fk_Contenido_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Contenido_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenido`
--

LOCK TABLES `contenido` WRITE;
/*!40000 ALTER TABLE `contenido` DISABLE KEYS */;
INSERT INTO `contenido` VALUES (1,'100ML',2),(2,'75ML',2),(3,'200ML',2),(4,'50ML',2),(5,'150ML',2);
/*!40000 ALTER TABLE `contenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuello`
--

DROP TABLE IF EXISTS `cuello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuello` (
  `Id_Cuello` int(11) NOT NULL,
  `Nombre_Cuello` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Cuello`),
  KEY `fk_Cuello_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Cuello_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuello`
--

LOCK TABLES `cuello` WRITE;
/*!40000 ALTER TABLE `cuello` DISABLE KEYS */;
INSERT INTO `cuello` VALUES (1,'MAO',3),(2,'PETER PAN',3),(3,'POLO',3),(4,'REDONDO',3),(5,'PALABRA DE HORNO',3),(6,'TANK TOP',3),(7,'CRUZADO',3),(8,'ASIMETRICO',3),(9,'CAPA',3),(10,'BARCO',3),(11,'CORAZÓN',3),(12,'CUADRADO',3),(13,'BANDA',3),(14,'CAMISA',3),(15,'CHAL',3),(16,'PICO',3);
/*!40000 ALTER TABLE `cuello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `Id_Departamento` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'CELULARES'),(2,'PERFUMES'),(3,'ROPA'),(4,'ZAPATOS');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compras_producto`
--

DROP TABLE IF EXISTS `detalle_compras_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compras_producto` (
  `Id_Detalle_Compras_Producto` int(11) NOT NULL,
  `Id_Compras` int(11) NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Precio_Compra` float DEFAULT NULL,
  `Cantidad_Compra` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Detalle_Compras_Producto`),
  KEY `fk_Detalle_Compras_Producto_Compras1_idx` (`Id_Compras`),
  KEY `fk_Detalle_Compras_Producto_Producto1_idx` (`Id_Producto`),
  CONSTRAINT `fk_Detalle_Compras_Producto_Compras1` FOREIGN KEY (`Id_Compras`) REFERENCES `compras` (`Id_Compras`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Compras_Producto_Producto1` FOREIGN KEY (`Id_Producto`) REFERENCES `producto` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compras_producto`
--

LOCK TABLES `detalle_compras_producto` WRITE;
/*!40000 ALTER TABLE `detalle_compras_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compras_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas_has_producto`
--

DROP TABLE IF EXISTS `detalle_ventas_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ventas_has_producto` (
  `Id_Detalle_Ventas` int(11) NOT NULL,
  `Ventas_Id_Ventas` int(11) NOT NULL,
  `Producto_Id_Producto` int(11) NOT NULL,
  `Cantidad_Producto` int(11) DEFAULT NULL,
  `SubTotal` float DEFAULT NULL,
  PRIMARY KEY (`Id_Detalle_Ventas`),
  KEY `fk_Detalle_Ventas_has_Producto_Ventas1_idx` (`Ventas_Id_Ventas`),
  KEY `fk_Detalle_Ventas_has_Producto_Producto1_idx` (`Producto_Id_Producto`),
  CONSTRAINT `fk_Detalle_Ventas_has_Producto_Producto1` FOREIGN KEY (`Producto_Id_Producto`) REFERENCES `producto` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Ventas_has_Producto_Ventas1` FOREIGN KEY (`Ventas_Id_Ventas`) REFERENCES `ventas` (`Id_Ventas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas_has_producto`
--

LOCK TABLES `detalle_ventas_has_producto` WRITE;
/*!40000 ALTER TABLE `detalle_ventas_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas_has_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estilo`
--

DROP TABLE IF EXISTS `estilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estilo` (
  `Id_Estilo` int(11) NOT NULL,
  `Nombre_Estilo` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Estilo`),
  KEY `fk_Estilo_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Estilo_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estilo`
--

LOCK TABLES `estilo` WRITE;
/*!40000 ALTER TABLE `estilo` DISABLE KEYS */;
INSERT INTO `estilo` VALUES (1,'BOYFRIEND',3),(2,'BOOTCUT',3),(3,'SUPER SKINNY',3),(4,'SKINNY',3),(5,'STRAIGHT',3),(6,'SLIM',3),(7,'REGULAR FIT',3),(8,'TAILORED FIT',3),(9,'CUSTOM FIT',3),(10,'SLIM FIT',3),(11,'SUPERSLIM FIT',3),(12,'ACAMPANADOS',3),(13,'FLARE',3);
/*!40000 ALTER TABLE `estilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `Producto_Id_Producto` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio_Venta` float DEFAULT NULL,
  KEY `fk_Inventario_Producto1_idx` (`Producto_Id_Producto`),
  CONSTRAINT `fk_Inventario_Producto1` FOREIGN KEY (`Producto_Id_Producto`) REFERENCES `producto` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `Id_Marca` int(11) NOT NULL,
  `Nombre_Marca` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Marca`),
  KEY `fk_Marca_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Marca_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'AGATHA RUIZ DE LA PRADA',2),(2,'ANTONIO BANDERAS',2),(3,'AQUARIUS',2),(4,'AZZARO',2),(5,'BAYLIS & HARDING',2),(6,'BENETTON',2),(7,'BODMAN',2),(8,'BODY FANTASIES',2),(9,'BRITNEY',2),(10,'BRITNEY SPEARS',2),(11,'KALVIN KLEIN',2),(12,'CARON',2),(13,'COTY PRESTIGE',2),(14,'DKNY',2),(15,'ELISABETH ARDEN',2),(16,'ERMENEGILDO ZEGNA',2),(17,'ESSENTIEL',2),(18,'EVAFLO PARIS',2),(19,'GUESS',2),(20,'HUGO BOSS',2),(21,'lACOSTE',2),(22,'MARC KORS',2),(23,'NAUTICA',2),(24,'PARIS HILTON',2),(25,'PENGUIN',2),(26,'PERRY ELLIS',2),(27,'TOUS',2),(28,'ZIPPO',2),(29,'ADIDAS',3),(30,'COLUMBIA',3),(31,'CUBAVERA',3),(32,'DIMITRI',3),(33,'GENTS',3),(34,'DOCKERS',3),(35,'GEORGE & MARTHA',3),(36,'IZOD',3),(37,'JACK & JONES',3),(38,'LEE ',3),(39,'LEVIS',3),(40,'MERCH',3),(41,'MICHAEL KORS',3),(42,'NAUTICA',3),(43,'OSCAR DE LA RENTA',3),(44,'PENGUIN',3),(45,'PIEERRE CARDIN',3),(46,'TEAM MATE',3),(47,'VAN HEUSEN',3),(48,'WARNING',3),(49,'WILSON',3),(50,'DIMITRI',3),(51,'VANS',3),(52,'MAVI',3),(53,'PEPE REVOLUTION',3),(54,'ARTECA',3),(55,'GEOFFREY BEENE',3),(56,'JACK & JONES',3),(57,'LAUREN',3),(58,'MANHATTAN',3),(59,'MODELFIT',3),(60,'UNEXPECTED',3),(61,'SAMIA',3),(62,'HANES',3),(63,'JOCKEY',3),(64,'FRUIT OT THE LOOM',3),(65,'JACK & JONES',3),(66,'ANNE KLEIN',4),(67,'CARLO ROSSETTI',4),(68,'EUROSOFT',4),(69,'FLEXI',4),(70,'HAVAIANAS',4),(71,'JESSICA SIMPSON',4),(72,'KENNETH COLE',4),(73,'LUCKY BRAND',4),(74,'MARC FISHER',4),(75,'NEW BALANCE',4),(76,'NICOLLE',4),(77,'NIKE',4),(78,'NINE WEST',4),(79,'ORANGE',4),(80,'SABRINA',4),(81,'TOMMY HILFIGER',4),(82,'XTI',4),(83,'NAUTICA',4),(84,'GENTS',4),(85,'MICHAEL KORS',4),(86,'DOCKERS',4),(87,'DIMITRI',4),(88,'VANS',4);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memoria_externa`
--

DROP TABLE IF EXISTS `memoria_externa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memoria_externa` (
  `Id_Memoria_Externa` int(11) NOT NULL,
  `Nombre_Memoria_Externa` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Memoria_Externa`),
  KEY `fk_Memoria_Externa_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Memoria_Externa_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memoria_externa`
--

LOCK TABLES `memoria_externa` WRITE;
/*!40000 ALTER TABLE `memoria_externa` DISABLE KEYS */;
INSERT INTO `memoria_externa` VALUES (1,'1GB',1),(2,'2GB',1),(3,'4GB',1),(4,'8GB',1),(5,'16GB',1),(6,'480MB',1);
/*!40000 ALTER TABLE `memoria_externa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memoria_interna`
--

DROP TABLE IF EXISTS `memoria_interna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memoria_interna` (
  `Id_Memoria_Interna` int(11) NOT NULL,
  `Nombre_Memoria_Interna` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Memoria_Interna`),
  KEY `fk_Memoria_Interna_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Memoria_Interna_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memoria_interna`
--

LOCK TABLES `memoria_interna` WRITE;
/*!40000 ALTER TABLE `memoria_interna` DISABLE KEYS */;
INSERT INTO `memoria_interna` VALUES (1,'1GB',1),(2,'2GB',1),(3,'4GB',1),(4,'8GB',1),(5,'16GB',1),(6,'480MB',1);
/*!40000 ALTER TABLE `memoria_interna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `Id_Modelo` int(11) NOT NULL,
  `Nombre_Modelo` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Modelo`),
  KEY `fk_Modelo_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Modelo_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pantalla`
--

DROP TABLE IF EXISTS `pantalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pantalla` (
  `Id_Pantalla` int(11) NOT NULL,
  `Nombre_Pantalla` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Pantalla`),
  KEY `fk_Pantalla_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Pantalla_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pantalla`
--

LOCK TABLES `pantalla` WRITE;
/*!40000 ALTER TABLE `pantalla` DISABLE KEYS */;
INSERT INTO `pantalla` VALUES (1,'5.2 PULG,1080x1920 PX',1),(2,'5 PULG,720x1280 PX',1),(3,'5 PULG,1080x1920 PX',1),(4,'5 PULG,540x960',1),(5,'6,720x1280 px',1),(6,'TFT 1.8,128x160',1),(7,'TFT 2.0,220X176,65K COLOR',1),(8,'TFT,16M COLORES,240X320 PX',1),(9,'TFT,256K COLORES,240X320 PX',1);
/*!40000 ALTER TABLE `pantalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pass_recovery`
--

DROP TABLE IF EXISTS `pass_recovery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pass_recovery` (
  `idpass_recovery` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(45) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Id_Usuario` int(11) NOT NULL,
  PRIMARY KEY (`idpass_recovery`),
  KEY `fk_pass_recovery_Usuario1_idx` (`Id_Usuario`),
  CONSTRAINT `fk_pass_recovery_Usuario1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pass_recovery`
--

LOCK TABLES `pass_recovery` WRITE;
/*!40000 ALTER TABLE `pass_recovery` DISABLE KEYS */;
/*!40000 ALTER TABLE `pass_recovery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilegios`
--

DROP TABLE IF EXISTS `privilegios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilegios` (
  `idprivilegios` int(11) NOT NULL AUTO_INCREMENT,
  `reg_prov` tinyint(1) NOT NULL DEFAULT '0',
  `reg_emp` tinyint(1) NOT NULL DEFAULT '0',
  `reg_prod` tinyint(1) NOT NULL DEFAULT '0',
  `reg_compras` tinyint(1) NOT NULL DEFAULT '0',
  `reg_ventas` tinyint(1) NOT NULL DEFAULT '0',
  `gen_report` tinyint(1) NOT NULL DEFAULT '0',
  `con_inv` tinyint(1) NOT NULL DEFAULT '0',
  `Usuario_Id_Usuario` int(11) NOT NULL,
  PRIMARY KEY (`idprivilegios`,`Usuario_Id_Usuario`),
  KEY `fk_privilegios_Usuario1_idx` (`Usuario_Id_Usuario`),
  CONSTRAINT `fk_privilegios_Usuario1` FOREIGN KEY (`Usuario_Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegios`
--

LOCK TABLES `privilegios` WRITE;
/*!40000 ALTER TABLE `privilegios` DISABLE KEYS */;
INSERT INTO `privilegios` VALUES (1,1,1,1,1,1,1,1,1);
/*!40000 ALTER TABLE `privilegios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `Id_Producto` int(11) NOT NULL,
  `Nombre_Producto` varchar(70) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Id_Proveedor` int(11) NOT NULL,
  `Id_Departamento` int(11) NOT NULL,
  `Precio_unitario` float DEFAULT NULL,
  `Talla` varchar(45) DEFAULT NULL,
  `Estilo` varchar(45) DEFAULT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  `Memoria_Interna` varchar(45) DEFAULT NULL,
  `Memoria_Externa` varchar(45) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Ganancia` int(11) DEFAULT NULL,
  `Clasificacion` varchar(60) DEFAULT NULL,
  `Aroma` varchar(45) DEFAULT NULL,
  `Contenido` varchar(45) DEFAULT NULL,
  `Sistema` varchar(45) DEFAULT NULL,
  `Modelo` varchar(45) DEFAULT NULL,
  `foto` longblob,
  `Tela` varchar(45) DEFAULT NULL,
  `Cuello` varchar(45) DEFAULT NULL,
  `Camara` varchar(45) DEFAULT NULL,
  `Pantalla` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Producto`),
  KEY `fk_Producto_Proveedor1_idx` (`Id_Proveedor`),
  KEY `fk_Producto_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Producto_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Proveedor1` FOREIGN KEY (`Id_Proveedor`) REFERENCES `proveedor` (`Id_Proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `Id_Proveedor` int(11) NOT NULL,
  `Nombre_Proveedor` varchar(45) DEFAULT NULL,
  `Nombre_Representante` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Telefono_Encargado` varchar(45) DEFAULT NULL,
  `Telefono_Empresa` varchar(45) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `foto` blob,
  PRIMARY KEY (`Id_Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistema`
--

DROP TABLE IF EXISTS `sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema` (
  `Id_Sistema` int(11) NOT NULL,
  `Nombre_Sistema` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Sistema`),
  KEY `fk_Sistema_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Sistema_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistema`
--

LOCK TABLES `sistema` WRITE;
/*!40000 ALTER TABLE `sistema` DISABLE KEYS */;
INSERT INTO `sistema` VALUES (1,'SYMBIAN',1),(2,'WINDOWS PHONE',1),(3,'BLACKBERRY',1),(4,'IOS',1),(5,'ANDROID',1);
/*!40000 ALTER TABLE `sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talla`
--

DROP TABLE IF EXISTS `talla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talla` (
  `Id_Talla` int(11) NOT NULL,
  `Nombre_Talla` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Talla`),
  KEY `fk_Talla_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Talla_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talla`
--

LOCK TABLES `talla` WRITE;
/*!40000 ALTER TABLE `talla` DISABLE KEYS */;
INSERT INTO `talla` VALUES (1,'6',4),(2,'7',4),(3,'8',4),(4,'9',4),(5,'10',4),(6,'11',4),(7,'12',4),(8,'13',4),(9,'14',4),(10,'S',3),(11,'M',3),(12,'XL',3),(13,'XXL',3),(14,'XXS',3),(15,'XS',3),(16,'XL',3),(17,'26',3),(18,'28',3),(19,'32',3),(20,'36',3),(21,'38',3);
/*!40000 ALTER TABLE `talla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tela`
--

DROP TABLE IF EXISTS `tela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tela` (
  `Id_Tela` int(11) NOT NULL,
  `Nombre_Tela` varchar(45) DEFAULT NULL,
  `Id_Departamento` int(11) NOT NULL,
  PRIMARY KEY (`Id_Tela`),
  KEY `fk_Tela_Departamento1_idx` (`Id_Departamento`),
  CONSTRAINT `fk_Tela_Departamento1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tela`
--

LOCK TABLES `tela` WRITE;
/*!40000 ALTER TABLE `tela` DISABLE KEYS */;
INSERT INTO `tela` VALUES (1,'MOARÉ',3),(2,'ACETATO',3),(3,'PANA',3),(4,'ACRÍLICA',3),(5,'ALEMANISCO',3),(6,'ALPACA',3),(7,'ANGORA(MOHAIR)',3),(8,'CHENILLE',3),(9,'CACHEMIR',3),(10,'CHIFFON',3),(11,'GABARDINA',3),(12,'GASA',3),(13,'LONA',3),(14,'NYLON',3),(15,'SEDA',3),(16,'ALGODON',3),(17,'POPELINA',3),(18,'ETAMINA',3),(19,'LINO',3),(20,'CHENILLE',3),(21,'CACHEMIR',3);
/*!40000 ALTER TABLE `tela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Empleados_Id_Empleados` int(11) NOT NULL,
  PRIMARY KEY (`Id_Usuario`),
  KEY `fk_Usuario_usuarios1_idx` (`Empleados_Id_Empleados`),
  CONSTRAINT `fk_Usuario_usuarios1` FOREIGN KEY (`Empleados_Id_Empleados`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','IWGZR08+7do=',1,'Admin@info.com',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) DEFAULT NULL,
  `nombres` varchar(70) DEFAULT NULL,
  `apellidos` varchar(70) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `clave` float DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `foto` longblob,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'','Admin','','','','',0,'2017-01-16',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `Id_Ventas` int(11) NOT NULL,
  `Fecha_Ventas` date DEFAULT NULL,
  `Usuario_Id_Usuario` int(11) NOT NULL,
  `Total` float DEFAULT NULL,
  PRIMARY KEY (`Id_Ventas`),
  KEY `fk_Ventas_Usuario1_idx` (`Usuario_Id_Usuario`),
  CONSTRAINT `fk_Ventas_Usuario1` FOREIGN KEY (`Usuario_Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-16 13:29:41

