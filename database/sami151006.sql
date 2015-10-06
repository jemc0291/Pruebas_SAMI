CREATE DATABASE  IF NOT EXISTS `sami_prueba` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sami_prueba`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sami_prueba
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `acta_verificacion`
--

DROP TABLE IF EXISTS `acta_verificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acta_verificacion` (
  `id_acta_verificacion` int(11) NOT NULL AUTO_INCREMENT,
  `proveedores` varchar(45) NOT NULL,
  `num_contrato` int(11) NOT NULL,
  `entrega` varchar(45) NOT NULL,
  `lugar_recepcion` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `hora` datetime NOT NULL,
  `valor` int(11) NOT NULL,
  `total_recibido_factura` int(11) NOT NULL,
  `tipo_verificacion` varchar(45) NOT NULL,
  `unidades_revisadas` int(11) NOT NULL,
  `aprobo` varchar(50) NOT NULL,
  `pendiente_entrega` tinyint(1) NOT NULL,
  `observaciones` varchar(200) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  PRIMARY KEY (`id_acta_verificacion`),
  KEY `fk_Acta_Verificacion_Usuarios1_idx` (`id_usuario`),
  KEY `fk_Acta_Verificacion_facturas1_idx` (`id_factura`),
  CONSTRAINT `fk_Acta_Verificacion_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acta_Verificacion_facturas1` FOREIGN KEY (`id_factura`) REFERENCES `facturas` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acta_verificacion`
--

LOCK TABLES `acta_verificacion` WRITE;
/*!40000 ALTER TABLE `acta_verificacion` DISABLE KEYS */;
INSERT INTO `acta_verificacion` VALUES (1,'compusistemas',111,'servientrega','cbisena','2009-09-09 12:11:11','2005-05-05 11:12:11',5000,5000,'ninguna',1,'si',0,'ninguna',1,1),(2,'torrepac',222,'deprisa','cbisena','2010-05-05 11:05:13','2006-06-06 12:12:05',200,200,'nada',2,'no',1,'alguna',2,2);
/*!40000 ALTER TABLE `acta_verificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `id_area` int(11) NOT NULL,
  `nombre_area` varchar(50) NOT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arl`
--

DROP TABLE IF EXISTS `arl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arl` (
  `id_arl` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_arl` varchar(45) NOT NULL,
  PRIMARY KEY (`id_arl`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arl`
--

LOCK TABLES `arl` WRITE;
/*!40000 ALTER TABLE `arl` DISABLE KEYS */;
INSERT INTO `arl` VALUES (1,'COLMENA RIESGOS PROFESIONALES S.A.'),(2,'COMPAÑIA AGRICOLA DE SEGUROS DE VIDA S.A.'),(3,'SEGUROS DE VIDA COLPATRIA S.A.'),(4,'SEGUROS DE VIDA DEL ESTADO S.A.'),(5,'SEGUROS BOLIVAR S.A.'),(6,'COMPAÑIA DE SEGUROS DE VIDA AURORA S.A.'),(7,'LA PREVISORA VIDA S.A. COMPAÑÍA DE SEGUROS'),(8,'SEGUROS DE VIDA ALFA S.A.'),(9,'INSTITUTO DE SEGUROS SOCIALES'),(10,'LIBERTY SEGUROS DE VIDA S.A.'),(11,'ASEGURADORA DE VIDA COLSEGUROS S.A.'),(12,'SURATEP S.A.'),(13,'BBVA SEGUROS DE VIDA S.A.'),(14,'LA EQUIDAD SEGUROS DE VIDA');
/*!40000 ALTER TABLE `arl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aseguradora`
--

DROP TABLE IF EXISTS `aseguradora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aseguradora` (
  `id_aseguradora` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_aseguradora` varchar(100) NOT NULL,
  PRIMARY KEY (`id_aseguradora`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aseguradora`
--

LOCK TABLES `aseguradora` WRITE;
/*!40000 ALTER TABLE `aseguradora` DISABLE KEYS */;
INSERT INTO `aseguradora` VALUES (1,'Colseguros');
/*!40000 ALTER TABLE `aseguradora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avance`
--

DROP TABLE IF EXISTS `avance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance` (
  `id_avance` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_avance` datetime DEFAULT NULL,
  `descripcion` varchar(145) DEFAULT NULL,
  `fue_atendido` tinyint(1) DEFAULT NULL,
  `fue_solucionado` tinyint(1) DEFAULT NULL,
  `id_prioridades` int(11) NOT NULL,
  `id_solicitud_servicio` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_avance`),
  KEY `fk_solicitud_servicios_has_estados_estados1_idx` (`id_estado`),
  KEY `fk_solicitud_servicios_has_estados_solicitud_servicios1_idx` (`id_solicitud_servicio`),
  KEY `fk_avance_Prioridades1_idx` (`id_prioridades`),
  CONSTRAINT `fk_avance_Prioridades1` FOREIGN KEY (`id_prioridades`) REFERENCES `prioridades` (`id_prioridades`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_servicios_has_estados_estados1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_servicios_has_estados_solicitud_servicios1` FOREIGN KEY (`id_solicitud_servicio`) REFERENCES `solicitud_servicios` (`id_solicitud_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avance`
--

LOCK TABLES `avance` WRITE;
/*!40000 ALTER TABLE `avance` DISABLE KEYS */;
INSERT INTO `avance` VALUES (1,'2015-02-06 07:55:00','inincio trabajo',1,1,1,1,1),(2,'2015-02-06 08:10:00','termino trabajo',1,0,2,2,2),(3,'2015-09-09 08:06:41','se realizara la revision para determinar el problema',1,0,2,3,5),(4,'2015-09-09 09:00:49','se revisara el problema para determinar cual es el principal inconveniente',1,0,2,1,2),(5,'2015-09-09 09:02:07','se revisara la tuberia despues de suspender el paso del agua en esa zona',1,0,2,6,2),(6,'2015-09-14 09:35:44','terminación de la obra',1,1,1,1,6),(7,'2015-09-15 16:26:54','se revisó de aire acondicionado, se encontró que la unidad esta quemada, hay que esperar el nuevo contrato de mantenimiento y reparación de aires',1,0,1,8,5);
/*!40000 ALTER TABLE `avance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avance_usuarios`
--

DROP TABLE IF EXISTS `avance_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance_usuarios` (
  `id_avance` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `idtipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_avance`,`id_usuario`),
  KEY `fk_avance_has_usuarios_usuarios1_idx` (`id_usuario`),
  KEY `fk_avance_has_usuarios_avance1_idx` (`id_avance`),
  KEY `fk_avance_usuarios_tipo_usuario1_idx` (`idtipo_usuario`),
  CONSTRAINT `fk_avance_has_usuarios_avance1` FOREIGN KEY (`id_avance`) REFERENCES `avance` (`id_avance`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avance_has_usuarios_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avance_usuarios_tipo_usuario1` FOREIGN KEY (`idtipo_usuario`) REFERENCES `tipo_usuario` (`idtipo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avance_usuarios`
--

LOCK TABLES `avance_usuarios` WRITE;
/*!40000 ALTER TABLE `avance_usuarios` DISABLE KEYS */;
INSERT INTO `avance_usuarios` VALUES (1,2,1),(1,1,2);
/*!40000 ALTER TABLE `avance_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bancos`
--

DROP TABLE IF EXISTS `bancos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bancos` (
  `id_banco` int(11) NOT NULL AUTO_INCREMENT,
  `nit_banco` varchar(15) DEFAULT NULL,
  `nombre_de_banco` varchar(70) NOT NULL,
  PRIMARY KEY (`id_banco`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bancos`
--

LOCK TABLES `bancos` WRITE;
/*!40000 ALTER TABLE `bancos` DISABLE KEYS */;
INSERT INTO `bancos` VALUES (1,'','Banco Agrario'),(2,NULL,'Banco AV Villas'),(3,NULL,'BancaMia'),(4,NULL,'BBVA'),(5,NULL,'Banco De Bogota'),(6,NULL,'Banco Caja Social'),(7,NULL,'CitiBanck'),(8,NULL,'Bancolombia'),(9,NULL,'BancoColpatria'),(10,NULL,'Banco Coomeva'),(11,NULL,'Banco Corpbanca'),(12,NULL,'Davivienda'),(13,NULL,'Banco Falabella'),(14,NULL,'Banco Finandina'),(15,NULL,'Banco GNB Sudameris'),(16,NULL,'Helm Bank'),(17,NULL,'HSBC Colombia'),(18,NULL,'Banco De Occidente'),(19,NULL,'Banco Pichincha'),(20,NULL,'Banco Popular'),(21,NULL,'Banco Procredito'),(22,NULL,'Banco De La Republica'),(23,NULL,'Scotiabank'),(24,NULL,'Banco WWB'),(25,NULL,'ANIF'),(26,NULL,'Asobancaria'),(27,NULL,'FogaFin'),(28,NULL,'Super Financiera');
/*!40000 ALTER TABLE `bancos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barrios`
--

DROP TABLE IF EXISTS `barrios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barrios` (
  `id_barrio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_barrio` varchar(45) DEFAULT NULL,
  `id_comuna` int(11) NOT NULL,
  PRIMARY KEY (`id_barrio`),
  KEY `fk_barrios_comunas1_idx` (`id_comuna`),
  CONSTRAINT `fk_barrios_comunas1` FOREIGN KEY (`id_comuna`) REFERENCES `comunas` (`id_comuna`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barrios`
--

LOCK TABLES `barrios` WRITE;
/*!40000 ALTER TABLE `barrios` DISABLE KEYS */;
INSERT INTO `barrios` VALUES (2,'Los Mangos',1),(3,'La Vega',1),(4,'Camilo Torres',1),(5,'Urb. Brisas del Norte',1),(6,'Urb. Caimitos',1),(7,'Urb. Villa del Caimito',1),(8,'Coronado',1),(9,'Urb. 20 de Julio',1),(10,'Urb. Simón Bolívar',1),(11,'Urb. Villa Diana',1),(12,'Urb. La Esperanza',1),(13,'Urb. Monteclaro',1),(14,'Urb. Villa del Rosario',1),(15,'Urb. Harold Eder',1),(16,'Urb. Hugo Varela Mondragón',1),(17,'Santiago Eder',1),(18,'Ciudadela Comfaunión',1),(19,'Urb. Emmanuel',1),(20,'Poblado de Lourdes',1),(21,'Ciudad Belén',1),(22,'Palma Real',1),(23,'El Porvenir',1),(24,'Bosques de Morelia',2),(25,'Urb. Villa Claudia',2),(26,'Industrial',2),(27,'Urb. Ignacio Torres Giraldo',2),(28,'Urb. Juan Pablo II',2),(29,'Urb. Santa Teresita',2),(30,'La Benedicta',2),(31,'Estonia',2),(32,'Berlín',2),(33,'Santa Isabel',2),(34,'Versalles',2),(35,'Mirriñao',2),(36,'Urb. Los Samanes',2),(37,'Las Mercedes',2),(38,'Urb. Samanes de la Merced',2),(39,'Urb. Almenares de la Merced',2),(40,'Santa María del Palmar',2),(41,'Urb. Campestre',2),(42,'Portal de las Palmas',2),(43,'Urb. Llanogrande',2),(44,'Urb. Departamental',2),(45,'Urb. Parque de la Merced',2),(46,'Urb. Plazuela de la Merced',2),(47,'Villas de Caña Miel',2),(48,'Poblado de Comfaunión',2),(49,'Altamira',2),(50,'La Orlidia',2),(51,'Betania de Comfandi',2),(52,'Fray Luis Amigó',3),(53,'El Prado',3),(54,'Urb. Santa Ana',3),(55,'Emilia',3),(56,'La Concordia',3),(57,'Llanogrande',3),(58,'Acacias',3),(59,'Pomona y Brisas del Bolo',3),(60,'Santa Bárbara',3),(61,'Rivera Escobar',3),(62,'Olímpico',3),(63,'Urb. Villa de las Palmas',3),(64,'Urb. Bosques de Santa Bárbara',3),(65,'Casas de Alicanto',3),(66,'Jorge Eliécer Gaitán',4),(67,'Loreto',4),(68,'Alfonso López',4),(69,'Colombia',4),(70,'Santa Rita',4),(71,'Obrero',4),(72,'San Cayetano',4),(73,'Bizerta',4),(74,'Uribe Uribe',4),(75,'Prados de Oriente',5),(76,'San Pedro',5),(77,'Primero de Mayo',5),(78,'Providencia',5),(79,'Campestre',5),(80,'San Carlos',5),(81,'Danubio',5),(82,'San Jorge',5),(83,'San José',5),(84,'José Antonio Galán',5),(85,'Palmeras',5),(86,'María Cano',5),(87,'Popular Modelo',5),(88,'Municipal',5),(89,'Los Sauces',5),(90,'Urb. Siete de Agosto',5),(91,'Urb. El Jardín',5),(92,'Urb. El Bosque',5),(93,'Urb. Palmeras del Oriente',5),(94,'Palmeras de Marsella',5),(95,'Urb. Buenos Aires',5),(96,'Urb. Mejor Vivir',5),(97,'La Alameda',5),(98,'Urb. La Estrella',5),(99,'Central',6),(100,'Colombina',6),(101,'Libertadores',6),(102,'Fátima',6),(103,'El Triunfo',6),(104,'Caicelandia',6),(105,'Urb. Las Flores',6),(106,'Urb. El Paraíso',6),(107,'Ciudadela Palmira',6),(108,'La Trinidad',6),(109,'Luis Carlos Galán',7),(110,'Barrio Nuevo',7),(111,'Las Delicias',7),(112,'El Recreo',7),(113,'Santa Clara',7),(114,'Urb. Petruc',7),(115,'Urb. Las Américas',7),(116,'La Independencia',7),(117,'Chapinero',7),(118,'Urb. Guayacán',7),(119,'Sesquicentenario',7),(120,'Parques de la Italia',7),(121,'Las Victorias',7),(122,'Urb. El Trébol',7),(123,'Urb. Portales del Recreo',7),(124,'Urb. Los Robles',7),(125,'Guayacanes del Ingenio',7),(126,'Urb. La Palmirana',7),(127,'El Sembrador',7),(128,'Los Coches',7),(129,'La Liberta',5),(130,'zamorano',1);
/*!40000 ALTER TABLE `barrios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cargo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Almacenista 		'),(2,'Auxiliar gestion documental		'),(3,'Auxiliar supervision contratista		'),(4,'Coordinador academico		'),(5,'Coordinador administrativo		'),(6,'Coordinador general		'),(7,'Encargado mantenimiento		'),(8,'Instructor		'),(9,'Gestor contractual 		'),(10,'Lider gestion documental		'),(11,'Profesional talento humano 		'),(12,'Responsable contratacion		'),(13,'Supervisor contractual		'),(14,'Supervisor mantenimiento		'),(15,'Contratista');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(35) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccf`
--

DROP TABLE IF EXISTS `ccf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ccf` (
  `id_ccf` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_ccf` varchar(100) NOT NULL,
  PRIMARY KEY (`id_ccf`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccf`
--

LOCK TABLES `ccf` WRITE;
/*!40000 ALTER TABLE `ccf` DISABLE KEYS */;
INSERT INTO `ccf` VALUES (1,'CAJA DE COMPENSACION FAMILIAR COMFENALCO CUNDINAMARCA'),(2,'CAJA DE COMPENSACION FAMILIAR COMPENSAR'),(3,'COMFENALCO VALLE'),(4,'CAJA DE COMPENSACION FAMILIAR COMFENALCO SANTANDER'),(5,'CAJA COLOMBIANA DE SUBSIDIO FAMILIAR COLSUBSIDIO'),(6,'CAJA DE COMPENSACION FAMILIAR CAJASAI'),(7,'CAJA DE COMPENSACION FAMILIAR DE BOYACA COMFABOY'),(8,'CAJA DE COMPENSACION FAMILIAR DE NARIÑO'),(9,'CAJA DE COMPENSACION FAMILIAR DEL ORIENTE COMFAORIENTE'),(10,'COMFACASANARE'),(11,'COMFENALCO DEL TOLIMA'),(12,'CAJA DE COMPENSACION FAMILIAR DE ARAUCA COMFIAR'),(13,'CAJA DE COMPENSACION FAMILIAR DE CALDAS CONFAMILIARES'),(14,'CAJA DE COMPENSACION FAMILIAR DE CORDOBA COMFACOR'),(15,'CAJA DE COMPENSACION FAMILIAR DE HONDA COMFAHONDA'),(16,'CAJA DE COMPENSACION FAMILIAR DE TULUA'),(17,'CAJA DE COMPENSACION FAMILIAR DEL CAQUETA COMFACA'),(18,'CAJA DE COMPENSACION FAMILIAR REGIONAL DEL META COFREM'),(19,'COMFASUCRE'),(20,'COMFENALCO CARTAGENA'),(21,'CAJA DE COMPENSACION FAMILIAR COMFENALCO QUINDIO'),(22,'CAJA DE COMPENSACION FAMILIAR DE CARTAGO'),(23,'CAJA DE COMPENSACION FAMILIAR DEL MAGDALENA'),(24,'CAJA DE COMPENSACION FAMILIAR DEL NORTE DE SANTANDER COMFANORTE'),(25,'CAJA DE COMPENSACION FAMILIAR DEL QUINDIO'),(26,'CAJA DE COMPENSACION FAMILIAR DEL VALLE DEL CAUCA'),(27,'COMFAMILIAR HUILA'),(28,'COMFAMILIARES UNIDAS DEL VALLE'),(29,'CAJA DE COMPENSACION FAMILIAR DE BARRANCABERMEJA CAFABA'),(30,'CAJA DE COMPENSACION FLIAR DEL SUR DEL TOLIMA CAFASUR'),(31,'CAJA DE COMPENSACION FAMILIAR CAJACOPI ATLANTICO'),(32,'CAJA DE COMPENSACION FAMILIAR DE BUENAVENTURA COMFAMAR'),(33,'CAJA DE COMPENSACION FAMILIAR DE CARTAGENA COMFAMILIAR'),(34,'CAJA SANTANDEREANA DE SUBSIDIO FAMILIAR CAJASAN'),(35,'COMFAMILIAR AFIDRO'),(36,'CAJA DE COMPENSACION FAMILIAR DE BARRANQUILLA COMBARRANQUILLA'),(37,'CAJA DE COMPENSACION FAMILIAR CAMACOL COMFAMILIAR CAMACOL'),(38,'CAJA DE COMPENSACION FAMILIAR COMFENALCO ANTIOQUIA'),(39,'CAJA DE COMPENSACION FAMILIAR DE ANTIOQUIA COMFAMA'),(40,'CAJA DE COMPENSACION FAMILIAR DE LA GUAJIRA'),(41,'CAJA DE COMPENSACION FLIAR. DEL CAUCA COMFACAUCA'),(42,'COMFAMILIAR DEL ATLANTICO'),(43,'CAJA DE COMPENSACION FAMILIAR DEL AMAZONAS'),(44,'CAJA DE COMPENSACION FAMILIAR DEL PUTUMAYO'),(45,'CAJA DE COMPENSACION FAMILIAR CAFAM '),(46,'CAJA DE COMPENSACION FAMILIAR CAMPESINA COMCAJA'),(47,'COMFACESAR'),(48,'CAJA DE COMPENSACION FAMILIAR DE LA DORADA COMFAMILIAR'),(49,'CAJA DE COMPENSACION FAMILIAR DEL CHOCO'),(50,'CAJA DE COMPENSACION FAMILIAR DE CUNDINAMARCA COMFACUNDI'),(51,'CAJA DE COMPENSACION FAMILIAR DEL TOLIMA COMFATOLIMA'),(52,'CAJA DE COMPENSACION FAMILIAR DE RISARALDA');
/*!40000 ALTER TABLE `ccf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cdp`
--

DROP TABLE IF EXISTS `cdp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cdp` (
  `numero_cdp` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_solicitud` date NOT NULL,
  `fecha_recepcion` date NOT NULL,
  `objetivo_del_gasto` varchar(100) NOT NULL,
  `id_tipo_solicitud` int(11) NOT NULL,
  `codigo_de_dependencia` int(10) NOT NULL,
  `codigo_gestion` varchar(50) NOT NULL,
  `id_rubro` varchar(45) NOT NULL,
  PRIMARY KEY (`numero_cdp`),
  KEY `fk_cdp_tipos_de_solicitudes1_idx` (`id_tipo_solicitud`),
  KEY `fk_cdp_dependencias1_idx` (`codigo_de_dependencia`),
  KEY `fk_cdp_gestiones1_idx` (`codigo_gestion`),
  KEY `fk_cdp_rubros1_idx` (`id_rubro`),
  CONSTRAINT `fk_cdp_dependencias1` FOREIGN KEY (`codigo_de_dependencia`) REFERENCES `dependencias` (`codigo_de_dependencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cdp_gestiones1` FOREIGN KEY (`codigo_gestion`) REFERENCES `gestiones` (`codigo_gestion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cdp_rubros1` FOREIGN KEY (`id_rubro`) REFERENCES `rubros` (`id_rubro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cdp_tipos_de_solicitudes1` FOREIGN KEY (`id_tipo_solicitud`) REFERENCES `tipos_de_solicitudes` (`id_tipo_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=441 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdp`
--

LOCK TABLES `cdp` WRITE;
/*!40000 ALTER TABLE `cdp` DISABLE KEYS */;
INSERT INTO `cdp` VALUES (440,'2014-11-02','2015-01-01','Garantizar presupuesto',1,1,'C-310-704-207','2041104');
/*!40000 ALTER TABLE `cdp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro_formacion`
--

DROP TABLE IF EXISTS `centro_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centro_formacion` (
  `id_centro_formacion` int(11) NOT NULL,
  `nombre_centro_formacion` varchar(150) NOT NULL,
  `direccion_centro_formacion` varchar(80) DEFAULT NULL,
  `telefono_centro_formacion` varchar(15) DEFAULT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_dpto` int(11) NOT NULL,
  PRIMARY KEY (`id_centro_formacion`),
  KEY `fk_centro_formacion_ciudad1_idx` (`id_ciudad`,`id_dpto`),
  CONSTRAINT `fk_centro_formacion_ciudad1` FOREIGN KEY (`id_ciudad`, `id_dpto`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro_formacion`
--

LOCK TABLES `centro_formacion` WRITE;
/*!40000 ALTER TABLE `centro_formacion` DISABLE KEYS */;
INSERT INTO `centro_formacion` VALUES (9032,'CENTRO DE COMERCIO Y SERVICIOS','Km 1 via Turbaco Troncal Occidente','095 6537251',1,13),(9101,'CENTRO DE LOS RECURSOS NATURALES RENOVABLES LA SALADA','Kim 6 Via la Pintada','094 2785747',129,5),(9103,'CENTRO PARA EL DESARROLLO AGROECOLOGICO Y AGROINDUSTRIAL','Cra  43 No 42  40','095 3510799',1,8),(9104,'CENTRO AGROEMPRESARIAL Y MINERO','Ternera vIa turbaco Km 1','095 6536699',1,13),(9105,'CENTRO NAUTICO ACUICOLA Y PESQUERO','Via a Mamonal','095 6687224',1,13),(9110,'CENTRO DE DESARROLLO AGROPECUARIO Y AGROINDUSTRIAL','Km 1 via Duitama Pantano de Vargas',' 098 638742',759,15),(9111,'CENTRO MINERO','Km 4 via Belencito','098 7708091',464,15),(9112,'CENTRO PARA LA FORMACION CAFETERA','Kilometro 10 via al Magdalena','PBX 096 8741400',1,17),(9113,'CENTRO AGROPECUARIO','Calle 4 No  2 80','092 8247678',1,19),(9114,'CENTRO BIOTECNOLOGICO DEL CARIBE','Kilometro 7 Salida la Paz','095 5717092',1,20),(9115,'CENTRO AGROPECUARIO Y DE BIOTECNOLOGIA EL PORVENIR','Km 35 Carretera Santa Isabel','947838050',1,23),(9116,'CENTRO DE FORMACION AGROINDUSTRIAL','Carretera a Campoalegre Sur Km 38','098 8380191',132,41),(9117,'CENTRO AGROINDUSTRIAL DEL META','Km 17 via Puerto Lopez','098 6698395',1,50),(9118,'CENTRO ACUICOLA  Y AGROINDUSTRIAL DE GAIRA','Km 5 carretera Gairca','095 4229052',676,41),(9119,'CENTRO ATENCION SECTOR AGROPECUARIO','Calle 2N Avda 4 y 5 Barrio Pescadero','097 5783030',223,54),(9120,'CENTRO AGROINDUSTRIAL','Vereda San Juan','097 7495738',1,63),(9121,'CENTRO ATENCION SECTOR AGROPECUARIO','Cra 8a No 26 79','096 3261666',1,66),(9122,'CENTRO ATENCION SECTOR AGROPECUARIO','Km 2 via Aguatiguara','097 6561718',1,68),(9123,'CENTRO AGROPECUARIO LA GRANJA','Km 5 carretera Espinal','098 3260373',1,73),(9124,'CENTRO AGROPECUARIO DE BUGA','Carretera Central variante a Buga','092 2280048',111,76),(9125,'CENTRO LATINOAMERICANO DE  ESPECIES MENORES','Carretera Central a Cali Km 2','092 2244921',834,76),(9126,'CENTRO NAUTICO PESQUERO DE BUENAVENTURA','Avda Simon Bolivar Km 5','092 2428250',109,76),(9201,'CENTRO DEL CALZADO Y MANUFACTURA DE CUERO','Calle 63 No  58B 03 Barrio Calatraba',' 094 3738585',360,5),(9202,'CENTRO DE FORMACION EN DISEÑO CONFECCION Y MODA',' Calle 63 No  58B 03 Barrio Calatraba','094 3719125',360,5),(9203,'CENTRO PARA EL DESARROLLO DEL HABITAT Y LA CONSTRUCCION','Diagonal 104 No  69 120 Barrio  Pedregal','094 4442800',1,5),(9204,'CENTRO DE TECNOLOGIA DE LA MANUFACTURA AVANZADA','Diagonal 104 No  69 120 Barrio Pedregal','094 4442800',1,5),(9205,'CENTRO TECNOLOGICO DEL MOBILIARIO','Calle 63 No  58B 03 Barrio Calatraba','094 2816600',360,5),(9206,'CENTRO NACIONAL TEXTIL','Diagonal 104 No 69 120 Barrio Pedregal','094 4442800',1,5),(9207,'CENTRO NACIONAL COLOMBO ALEMAN','Calle 30 No  3E  164','095 3740254',1,8),(9208,'CENTRO INDUSTRIAL Y DE AVIACION','Calle 30 No  3E - 164','095 3752244',1,8),(9209,'CENTRO DE TECNOLOGIAS PARA LA CONSTRUCCION Y LA MADERA','Cra 18A No 2  18 sur Barrio San Antonio','2890065',1,11),(9210,'CENTRO DE ELECTRICIDAD ELECTRONICA Y TELECOMUNICACIONES','Avenida 30 No 17B 25 Sur','PBX 5960050',1,11),(9211,'CENTRO DE GESTION INDUSTRIAL','Cra 31 No 14  20 P 4 Torre Occidente','PBX 5960100',1,11),(9212,'CENTRO DE MANUFACTURA EN TEXTILES Y CUERO','Avenida 30 No 17B 25 Sur','PBX 5960050',1,11),(9213,'CENTRO DE TECNOLOGIAS DEL TRANSPORTE',' Avenida 30 No  17B 25 Sur','PBX 5960050',1,11),(9214,'CENTRO METALMECANICO','Avenida 30 No 17B 25 Sur','PBX 5960050',1,11),(9215,'CENTRO DE MATERIALES Y ENSAYOS','Avenida 30 No 17B 25 Sur','PBX 5960050',1,11),(9216,'CENTRO DE DISEÑO Y METROLOGIA',' Cra 31 No 14  20','PBX 5960100',1,11),(9217,'CENTRO PARA LA INDUSTRIA DE LA COMUNICACION GRAFICA','Cra 31 No 14  20','PBX 5960100',1,11),(9218,'CENTRO PARA LA INDUSTRIA PETROQUIMICA','Avenida Pedro de Heredia','095 6697100',1,13),(9219,'CENTRO DE AUTOMATIZACION INDUSTRIAL','Kilometro 10 via al Magdalena','PBX 096 8741400',1,17),(9220,'CENTRO DE PROCESOS INDUSTRIALES',' Kilometro 10 via al Magdalena','PBX 096 8741400',1,17),(9221,'CENTRO DE TELEINFORMATICA Y PRODUCCION INDUSTRIAL','Cra 9 No 69 00 Alto Cauca','092 8247679',1,19),(9222,'CENTRO INDUSTRIAL Y DE ENERGIAS ALTERNATIVAS','Avda aeropuerto Calle 21','095 7270461',551,41),(9223,'CENTRO DE DISEÑO E INNOVACION TECNOLOGICA INDUSTRIAL','Diagonal 7 Transv 7 Barrio Sta Isabel','096 3230034',170,66),(9224,'CENTRO INDUSTRIAL DE MANTENIMIENTO INTEGRAL','Calle 16 No 27 37','097 6468036',307,68),(9225,'CENTRO INDUSTRIAL DE DISEÑO Y LA MANUFACTURA','El Palanque Km 7 via Rincon de Giron','097 6386521',276,68),(9226,'CENTRO DE INDUSTRIA Y CONSTRUCCION','Km 4 via a Picaleña','098 2655286',1,73),(9227,'CENTRO DE ELECTRICIDAD Y AUTOMATIZACION INDUSTRIAL','Calle 52 No 2 Bis 15 Salomia','924315817',1,76),(9228,'CENTRO DE LA CONSTRUCCION','Calle 34 No 17B 23 Barrio Atanasio Giradot','092 4488470',1,76),(9229,'CENTRO DE DISEÑO TECNOLOGICO INDUSTRIAL','Calle 52 No 2 Bis 15 Salomia','092 4315828',1,76),(9230,'CENTRO NACIONAL DE ASISTENCIA TECNICA A LA INDUSTRIA ASTIN','Calle 52 No 2 Bis 15 Salomia','092 4315848',1,76),(9231,'CENTRO PARA EL DESARROLLO TECNOLOGICO DE LA CONSTRUCCION','Vereda San Juan','096 7498118',1,63),(9232,'CENTRO INDUSTRIAL Y DESARROLLO EMPRESARIAL DE SOACHA','Calle 13 No 10  60','5757220',754,25),(9301,'CENTRO DE COMERCIO','Calle 51 No 57 70','094 5760000',1,5),(9302,'CENTRO DE COMERCIO Y SERVICIOS','Cra 43 No  42  40','095 3720467',1,8),(9305,'CENTRO DE GESTION ADMINISTRATIVA Y FORTALECIMIENTO EMPRESARIAL','Calle 19 No 12 29','098 7422220',1,15),(9306,'CENTRO DE COMERCIO Y SERVICIOS','Kilometro 10 via al Magdalena','PBX 096 8741400',1,17),(9307,'CENTRO DE COMERCIO Y SERVICIOS','Calle 4 No 2 67','092 8244303',1,19),(9308,'CENTRO DE COMERCIO INDUSTRIA Y TURISMO','Cra 19 No 7 75','096 7493782',1,63),(9309,'CENTRO DE SERVICIOS EMPRESARIALES Y TURISTICOS','Cra 27 No 15 07','097 6800600',1,68),(9310,'CENTRO DE COMERCIO Y SERVICIOS','Cra 4a Estadio Calle 44 Av Ferrocarril','098 2640901',1,73),(9311,'CENTRO DE GESTION TECNOLOGICA DE SERVICIOS','Calle 52 No 2 Bis 15 Salomia','092 4315837',1,76),(9401,'CENTRO DE SERVICIOS DE SALUD','Calle 51 No 57  70','094 5760000',1,5),(9402,'CENTRO DE SERVICIOS Y GESTION EMPRESARIAL','Calle 51 No 57  70',' 094 5760000',1,5),(9403,'CENTRO DE FORMACION DE TALENTO HUMANO EN SALUD','Cra 6a No 45  52','2858748',1,11),(9404,'CENTRO DE GESTION ADMINISTRATIVA','Avenida Caracas No 13  88','PBX 3341600',1,11),(9405,'CENTRO DE SERVICIOS FINANCIEROS','Cra 13 No 65  10','PBX 5461600',1,11),(9406,'CENTRO NACIONAL DE HOTELERIA TURISMO Y ALIMENTOS','Cra 30 No 14 53','PBX 3704949',1,11),(9501,'COMPLEJO TECNOLOGICO PARA LA GESTION AGROEMPRESARIAL','Diagonal al Hospital CUP','094 8392373',154,5),(9502,'COMPLEJO TECNOLOGICO MINERO AGROEMPRESARIAL','Calle 6 Barrio La Malena','094 8332862',579,5),(9503,'CENTRO DE LA INNOVACION LA AGROINDUSTRIA Y EL TURISMO','Cra 48 No 49  62','094 5311896',615,5),(9504,'COMPLEJO TECNOLOGICO AGROINDUSTRIAL PECUARIO Y TURISTICO','Km 1 Via salida a Turbo','094 8280072',45,5),(9508,'CENTRO DE GESTION DE MERCADOS LOGISTICA Y TECN INFORM','Calle 52 No 13  65','PBX 5941301',1,11),(9509,'CENTRO DE DESARROLLO AGROINDUSTRIAL Y EMPRESARIAL','Calle 2 No 13 08 Barrio San Rafael','8444305',875,25),(9510,'CENTRO AGROECOLOGICO Y EMPRESARIAL','Avda Tierra Grata Calle 16','8673476',290,25),(9511,'CENTRO DE LA TECNOLOGIA DEL DISEÑO Y LA PRODUCTIVIDAD EMPRESARIAL','Cra 10 No 10 04','8339933',307,25),(9512,'CENTRO DE BIOTECNOLOGIA AGROPECUARIA','Km 7 via Mosquera','5462323',473,25),(9513,'CENTRO DE DESARROLLO AGROEMPRESARIAL','Cra 9 No 11 34','8633557-58',175,25),(9514,'CENTRO INDUSTRIAL DE MANTENIMIENTO Y MANUFACTURA','Cra 12 No 55A 51','098 7721313',759,15),(9515,'CENTRO PECUARIO Y AGROEMPRESARIAL','Calle 42 Carrera 1 Alfonso Lopez','096 8573904',380,17),(9516,'CENTRO TECNOLOGICO DE LA AMAZONIA','Km 3 via aeropuerto','098 4374792',1,18),(9517,'CENTRO PARA LA BIODIVERSIDAD Y EL TURISMO DEL AMAZONAS','Calle 12 No 10 60','098 5927626',1,91),(9518,'CENTRO AGROFORESTAL Y ACUICOLA ARAPAIMA','Cra 23 No 19 06 Barrio 20 de Julio','098 4227376',568,86),(9519,'CENTRO AGROINDUSTRIAL Y FORTALECIMIENTO EMPRESARIAL DE CASANARE','Cra 19 No 36 68','0986356017-18',1,85),(9521,'CENTRO DE OPERACION Y MANTENIMIENTO MINERO','Kilometro 7 Salida la Paz','092 5703366',1,20),(9522,'CENTRO DE RECURSOS NATURALES INDUSTRIA Y BIODIVERSIDAD','Cra 1 No 28 71','094 6723800',1,27),(9523,'CENTRO DE COMERCIO INDUSTRIA Y TURISMO DE CORDOBA','Calle 24 y 27 Avda Circunvalar','947838046',1,23),(9524,'CENTRO AGROEMPRESARIAL Y ACUICOLA','Km 1 via a Barrancas','095 7274609',1,44),(9525,'CENTRO AGROEMPRESARIAL Y DESARROLLO PECUARIO DEL HUILA','Cra 10 No 11 22','988335024',298,41),(9526,'CENTRO DE DESARROLLO AGROEMPRESARIAL Y TURISTICO DEL HUILA','Cra 3a No 2 03','098 8372192',396,41),(9527,'CENTRO DE LA INDUSTRIA LA EMPRESA Y LOS SERVICIOS','Km 3 via Tello','098 8757026',1,41),(9528,'CENTRO DE GESTION Y DESARROLLO SOSTENIBLE SURCOLOMBIANO','Cra 8a No 7 53','098 8368747',551,41),(9529,'CENTRO DE LOGISTICA Y PROMOCION ECOTURISTICA DEL MAGDALENA','Avda del Ferrocarril 27 97','095 4211929',676,41),(9530,'CENTRODE GESTION Y DESARROLLO AGROINDUSTRIAL DE ARAUCA','Cra 20 No 28 163','978853345',1,81),(9531,'CENTRO DE PRODUCCION Y TRANSFORMACION AGROINDUSTRIAL DE LA ORINOQUIA','Calle 10 No 18 185','098 5654465',1,99),(9532,'CENTRO DE INDUSTRIA Y SERVICIOS DEL META','Km 1 via Acacias','098 6825151',1,50),(9533,'CENTRO DE DESARROLLO AGROINDUSTRIAL TURISTICO Y TECNOLOGICO DEL GUAVIARE','Cra 24 No 7  10 B Centro','098 5840403',1,95),(9534,'CENTRO SUR COLOMBIANO DE LOGISTICA INTERNACIONAL','Cra 7a No 24 48','092 7733168',356,52),(9535,'CENTRO AGROINDUSTRIAL Y PESQUERO DE LA COSTA PACIFICPO','Calle del comercio Muellle Tumaco','092 7272630',835,52),(9536,'CENTRO INTERNACIONAL DE PRODUCCION LIMPIA LOPE','Calle 22 No 11E 05 Via Oriente','092 7303324',720,52),(9539,'CENTRO DE FORMACION TURISTICA GENTE DE MAR Y DE SERVICIOS','Avda Francisco Newball','098 5121752',1,88),(9540,'CENTRO INDUSTRIAL Y DEL DESARROLLO TECNOLOGICO','Avda del SENA Calle l6 y 18','097 6201691',81,68),(9541,'CENTRO AGROTURISTICO','Cra 10 No 22 40','097 7248113',679,68),(9542,'CENTRO DE LA INNOVACION LA TECNOLOGIA Y LOS SERVICIOS','Calle 25B No 31 260','095 2801809',1,70),(9543,'CENTRO DE TECNOLOGIAS AGROINDUSTRIALES','Cra 9a No 12 14','092 2112778',147,76),(9544,'CENTRO DE BIOTECNOLOGIA INDUSTRIAL','Cra 30 No 40  25','092 2750944',520,76),(9545,'CENTRO AGROEMPRESARIAL Y TURISTICO DE LOS ANDES','Cra 11 No 13 13','097 6607425',432,68),(9546,'CENTRO DE GESTION AGROEMPRESARIAL DEL ORIENTE',' Avda las cuadras','097 7563017',861,68),(9547,'CENTRO AMBIENTAL Y ECOTURISTICO DEL NORORIENTE AMAZONICO','Antigua Sede Fer','098 5656270',1,94),(9548,'CENTRO AGROPECUARIO Y DE SERVICIOS AMBIENTALES JIRI JIRIMO ','Avda 15 No 6 176','098 5642223',1,97),(9803,'CENTRO COMERCIO Y SERVICIOS','Cra 8a No 26 79','096 3261666',1,66),(9805,'CENTRO DE GESTION Y FORTALECIMIENTO SOCIO EMPRESARIAL ','Transv 79 No 41D 15 Sur Kemmedy','4503802',1,11),(9852,'CENTRO AGROEMPRESARIAL ','Cra 40 Km 1 via Bucaramanga','095 565470',11,20);
/*!40000 ALTER TABLE `centro_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id_ciudad` int(11) NOT NULL,
  `nombre_ciudad` varchar(45) DEFAULT NULL,
  `id_dpto` int(11) NOT NULL,
  PRIMARY KEY (`id_ciudad`,`id_dpto`),
  KEY `fk_ciudad_departamentos1_idx` (`id_dpto`),
  CONSTRAINT `fk_ciudad_departamentos1` FOREIGN KEY (`id_dpto`) REFERENCES `departamentos` (`id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'MEDELLÍN',5),(1,'BARRANQUILLA',8),(1,'BOGOTÁ, D.C.',11),(1,'CARTAGENA',13),(1,'TUNJA',15),(1,'MANIZALES',17),(1,'FLORENCIA',18),(1,'POPAYÁN',19),(1,'VALLEDUPAR',20),(1,'MONTERÍA',23),(1,'AGUA DE DIOS',25),(1,'QUIBDÓ',27),(1,'NEIVA',41),(1,'RIOHACHA',44),(1,'SANTA MARTA',47),(1,'VILLAVICENCIO',50),(1,'PASTO',52),(1,'CÚCUTA',54),(1,'ARMENIA',63),(1,'PEREIRA',66),(1,'BUCARAMANGA',68),(1,'SINCELEJO',70),(1,'IBAGUÉ',73),(1,'CALI',76),(1,'ARAUCA',81),(1,'YOPAL',85),(1,'MOCOA',86),(1,'SAN ANDRÉS',88),(1,'LETICIA',91),(1,'INÍRIDA',94),(1,'SAN JOSÉ DEL GUAVIARE',95),(1,'MITÚ',97),(1,'PUERTO CARREÑO',99),(2,'ABEJORRAL',5),(3,'ABREGO',54),(4,'ABRIAQUÍ',5),(6,'ACHÍ',13),(6,'ACANDÍ',27),(6,'ACEVEDO',41),(6,'ACACÍAS',50),(10,'AGUAZUL',85),(11,'AGUACHICA',20),(13,'AGUADAS',17),(13,'AGUSTÍN CODAZZI',20),(13,'AGRADO',41),(13,'AGUADA',68),(15,'CHAMEZA',85),(15,'CALAMAR',95),(16,'AIPE',41),(19,'ALBÁN',25),(19,'ALBÁN',52),(20,'ALGECIRAS',41),(20,'ALBANIA',68),(20,'ALCALÁ',76),(21,'ALEJANDRÍA',5),(22,'ALMEIDA',15),(22,'ALMAGUER',19),(22,'ALDANA',52),(24,'ALPUJARRA',73),(25,'ALTO BAUDÓ',27),(25,'EL RETORNO',95),(26,'ALTAMIRA',41),(26,'ALVARADO',73),(29,'ALBANIA',18),(30,'AMAGÁ',5),(30,'ALTOS DEL ROSARIO',13),(30,'ALGARROBO',47),(30,'AMBALEMA',73),(31,'AMALFI',5),(32,'ASTREA',20),(34,'ANDES',5),(35,'ANAPOIMA',25),(35,'ALBANIA',44),(36,'ANGELÓPOLIS',5),(36,'ANCUYÁ',52),(36,'ANDALUCÍA',76),(38,'ANGOSTURA',5),(40,'ANORÍ',5),(40,'ANOLAIMA',25),(41,'ANSERMANUEVO',76),(42,'SANTAFÉ DE ANTIOQUIA',5),(42,'ARENAL',13),(42,'ANSERMA',17),(43,'ANZOÁTEGUI',73),(44,'ANZA',5),(45,'APARTADÓ',5),(45,'BECERRIL',20),(45,'APÍA',66),(47,'AQUITANIA',15),(50,'ARANZAZU',17),(50,'ARGELIA',19),(50,'ATRATO',27),(51,'ARBOLETES',5),(51,'ARCABUCO',15),(51,'ARBOLEDA',52),(51,'ARBOLEDAS',54),(51,'ARATOCA',68),(52,'ARJONA',13),(53,'ARBELÁEZ',25),(53,'ARACATACA',47),(54,'ARGELIA',76),(55,'ARGELIA',5),(55,'ARMERO',73),(58,'ARIGUANÍ',47),(59,'ARMENIA',5),(60,'BOSCONIA',20),(62,'ARROYOHONDO',13),(65,'ARAUQUITA',81),(67,'ATACO',73),(68,'AYAPEL',23),(73,'BAGADÓ',27),(74,'BARRANCO DE LOBA',13),(75,'BALBOA',19),(75,'BAHÍA SOLANO',27),(75,'BALBOA',66),(77,'BAJO BAUDÓ',27),(77,'BARBOSA',68),(78,'BARANOA',8),(78,'BARAYA',41),(78,'BARRANCAS',44),(79,'BARBOSA',5),(79,'BUENAVISTA',23),(79,'BARBACOAS',52),(79,'BARICHARA',68),(81,'BARRANCABERMEJA',68),(83,'BELÉN',52),(86,'BELMIRA',5),(86,'BELTRÁN',25),(87,'BELÉN',15),(88,'BELLO',5),(88,'BELALCÁZAR',17),(88,'BELÉN DE UMBRÍA',66),(90,'BERBEO',15),(90,'CANALETE',23),(90,'DIBULLA',44),(91,'BETANIA',5),(92,'BETÉITIVA',15),(92,'BETULIA',68),(93,'BETULIA',5),(94,'BELÉN DE LOS ANDAQUÍES',18),(95,'BITUIMA',25),(97,'BOAVITA',15),(98,'DISTRACCIÓN',44),(99,'BOJACÁ',25),(99,'BOJAYA',27),(99,'BOCHALEMA',54),(100,'BOLÍVAR',19),(100,'BOLÍVAR',76),(101,'CIUDAD BOLÍVAR',5),(101,'BOLÍVAR',68),(104,'BOYACÁ',15),(106,'BRICEÑO',15),(107,'BRICEÑO',5),(109,'BUENAVISTA',15),(109,'BUCARASICA',54),(109,'BUENAVENTURA',76),(110,'BUENOS AIRES',19),(110,'EL MOLINO',44),(110,'BARRANCA DE UPÍA',50),(110,'BUESACO',52),(110,'BUENAVISTA',70),(111,'BUENAVISTA',63),(111,'GUADALAJARA DE BUGA',76),(113,'BURITICÁ',5),(113,'BUGALAGRANDE',76),(114,'BUSBANZÁ',15),(120,'CÁCERES',5),(120,'CABRERA',25),(121,'CABRERA',68),(122,'CAICEDONIA',76),(123,'CACHIPAY',25),(124,'CABUYARO',50),(124,'CAIMITO',70),(124,'CAJAMARCA',73),(125,'CAICEDO',5),(125,'CÁCOTA',54),(125,'HATO COROZAL',85),(126,'CAJICÁ',25),(126,'CALIMA',76),(128,'CACHIRÁ',54),(129,'CALDAS',5),(130,'CAJIBÍO',19),(130,'CALARCA',63),(130,'CANDELARIA',76),(131,'CALDAS',15),(132,'CAMPOALEGRE',41),(132,'CALIFORNIA',68),(134,'CAMPAMENTO',5),(135,'CAMPOHERMOSO',15),(135,'EL CANTÓN DEL SAN PABLO',27),(136,'LA SALINA',85),(137,'CAMPO DE LA CRUZ',8),(137,'CALDONO',19),(138,'CAÑASGORDAS',5),(139,'MANÍ',85),(140,'CALAMAR',13),(141,'CANDELARIA',8),(142,'CARACOLÍ',5),(142,'CALOTO',19),(145,'CARAMANTA',5),(147,'CAREPA',5),(147,'CAPITANEJO',68),(147,'CARTAGO',76),(148,'EL CARMEN DE VIBORAL',5),(148,'CAPARRAPÍ',25),(148,'CARMEN DE APICALÁ',73),(150,'CAROLINA',5),(150,'CARTAGENA DEL CHAIRÁ',18),(150,'CARMEN DEL DARIÉN',27),(150,'CASTILLA LA NUEVA',50),(151,'CAQUEZA',25),(152,'CARCASÍ',68),(152,'CASABIANCA',73),(154,'CAUCASIA',5),(154,'CARMEN DE CARUPA',25),(160,'CANTAGALLO',13),(160,'CÉRTEGUI',27),(160,'CEPITÁ',68),(161,'CERRO SAN ANTONIO',47),(161,'CARURU',97),(162,'CERINZA',15),(162,'CERETÉ',23),(162,'CERRITO',68),(162,'MONTERREY',85),(167,'CHARALÁ',68),(168,'CHIMÁ',23),(168,'CHAGUANÍ',25),(168,'CHAPARRAL',73),(169,'CHARTA',68),(170,'CHIVOLO',47),(170,'DOSQUEBRADAS',66),(172,'CHIGORODÓ',5),(172,'CHINAVITA',15),(172,'CHINÁCOTA',54),(174,'CHINCHINÁ',17),(174,'CHITAGÁ',54),(175,'CHIMICHAGUA',20),(175,'CHÍA',25),(176,'CHIQUINQUIRÁ',15),(176,'CHIMA',68),(178,'CHIRIGUANÁ',20),(178,'CHIPAQUE',25),(179,'CHIPATÁ',68),(180,'CHISCAS',15),(181,'CHOACHÍ',25),(182,'CHINÚ',23),(183,'CHITA',15),(183,'CHOCONTÁ',25),(185,'CHITARAQUE',15),(187,'CHIVATÁ',15),(188,'CICUCO',13),(189,'CIÉNEGA',15),(189,'CIÉNAGA DE ORO',23),(189,'CIÉNAGA',47),(190,'CISNEROS',5),(190,'CIRCASIA',63),(190,'CIMITARRA',68),(197,'COCORNÁ',5),(200,'COGUA',25),(200,'COELLO',73),(200,'MIRAFLORES',95),(203,'COLÓN',52),(204,'CÓMBITA',15),(204,'COLOSO',70),(205,'CURILLO',18),(205,'CONDOTO',27),(205,'CONCORDIA',47),(206,'CONCEPCIÓN',5),(206,'COLOMBIA',41),(206,'CONVENCIÓN',54),(207,'CONSACA',52),(207,'CONCEPCIÓN',68),(209,'CONCORDIA',5),(209,'CONFINES',68),(210,'CONTADERO',52),(211,'CONTRATACIÓN',68),(212,'COPACABANA',5),(212,'CÓRDOBA',13),(212,'COPER',15),(212,'CORINTO',19),(212,'CÓRDOBA',63),(214,'COTA',25),(215,'CORRALES',15),(215,'CÓRDOBA',52),(215,'COROZAL',70),(217,'COROMORO',68),(217,'COYAIMA',73),(218,'COVARACHÍA',15),(219,'COLÓN',86),(220,'CRAVO NORTE',81),(221,'COVEÑAS',70),(222,'CLEMENCIA',13),(223,'CUBARÁ',15),(223,'CUBARRAL',50),(223,'CUCUTILLA',54),(224,'CUCAITA',15),(224,'CUCUNUBÁ',25),(224,'CUASPUD',52),(225,'NUNCHÍA',85),(226,'CUÍTIVA',15),(226,'CUMARAL',50),(226,'CUNDAY',73),(227,'CUMBAL',52),(228,'CURUMANÍ',20),(229,'CURITÍ',68),(230,'CHALÁN',70),(230,'OROCUÉ',85),(232,'CHÍQUIZA',15),(233,'CUMBITARA',52),(233,'EL ROBLE',70),(233,'DAGUA',76),(234,'DABEIBA',5),(235,'EL CARMEN DE CHUCURÍ',68),(235,'GALERAS',70),(236,'CHIVOR',15),(236,'DOLORES',73),(237,'DONMATÍAS',5),(238,'DUITAMA',15),(238,'EL COPEY',20),(239,'DURANIA',54),(240,'EBÉJICO',5),(240,'CHACHAGÜÍ',52),(243,'EL ÁGUILA',76),(244,'EL CARMEN DE BOLÍVAR',13),(244,'EL COCUY',15),(244,'ELÍAS',41),(245,'EL COLEGIO',25),(245,'EL CARMEN DE ATRATO',27),(245,'EL BANCO',47),(245,'EL CALVARIO',50),(245,'EL CARMEN',54),(245,'EL GUACAMAYO',68),(246,'EL CAIRO',76),(247,'EL DONCELLO',18),(248,'EL GUAMO',13),(248,'EL ESPINO',15),(248,'EL CERRITO',76),(250,'EL BAGRE',5),(250,'EL PASO',20),(250,'EL LITORAL DEL SAN JUAN',27),(250,'EL CHARCO',52),(250,'EL TARRA',54),(250,'EL PEÑÓN',68),(250,'EL DOVIO',76),(250,'PAZ DE ARIPORO',85),(251,'EL CASTILLO',50),(254,'EL PEÑOL',52),(255,'EL PLAYÓN',68),(256,'EL PAUJIL',18),(256,'EL TAMBO',19),(256,'EL ROSARIO',52),(258,'EL PEÑÓN',25),(258,'EL PIÑON',47),(258,'EL TABLÓN DE GÓMEZ',52),(260,'EL ROSAL',25),(260,'EL TAMBO',52),(261,'EL ZULIA',54),(263,'PORE',85),(263,'EL ENCANTO',91),(264,'ENTRERRIOS',5),(264,'ENCINO',68),(265,'GUARANDA',70),(266,'ENVIGADO',5),(266,'ENCISO',68),(268,'EL PEÑÓN',13),(268,'EL RETÉN',47),(268,'ESPINAL',73),(269,'FACATATIVÁ',25),(270,'EL DORADO',50),(270,'FALAN',73),(271,'FLORIÁN',68),(272,'FIRAVITOBA',15),(272,'FILADELFIA',17),(272,'FILANDIA',63),(275,'FLANDES',73),(275,'FLORIDA',76),(276,'FLORESTA',15),(276,'FLORIDABLANCA',68),(279,'FOMEQUE',25),(279,'FONSECA',44),(279,'RECETOR',85),(281,'FOSCA',25),(282,'FREDONIA',5),(283,'FRESNO',73),(284,'FRONTINO',5),(286,'FUNZA',25),(287,'FUENTE DE ORO',50),(287,'FUNES',52),(288,'FÚQUENE',25),(288,'FUNDACIÓN',47),(290,'FLORENCIA',19),(290,'FUSAGASUGÁ',25),(293,'GACHANTIVÁ',15),(293,'GACHALA',25),(295,'GAMARRA',20),(295,'GACHANCIPÁ',25),(296,'GALAPA',8),(296,'GAMEZA',15),(296,'GALÁN',68),(297,'GACHETÁ',25),(298,'GARZÓN',41),(298,'GAMBITA',68),(299,'GARAGOA',15),(299,'GAMA',25),(300,'HATILLO DE LOBA',13),(300,'GUACHENÉ',19),(300,'COTORRA',23),(300,'FORTUL',81),(300,'SABANALARGA',85),(302,'GÉNOVA',63),(306,'GIRALDO',5),(306,'GIGANTE',41),(306,'GINEBRA',76),(307,'GIRARDOT',25),(307,'GIRÓN',68),(308,'GIRARDOTA',5),(310,'GÓMEZ PLATA',5),(310,'GONZÁLEZ',20),(312,'GRANADA',25),(313,'GRANADA',5),(313,'GRANADA',50),(313,'GRAMALOTE',54),(315,'GUADALUPE',5),(315,'SÁCAMA',85),(317,'GUACAMAYAS',15),(317,'GUACHETÁ',25),(317,'GUACHUCAL',52),(318,'GUARNE',5),(318,'GUAPI',19),(318,'GUAMAL',47),(318,'GUAMAL',50),(318,'GUÁTICA',66),(318,'GUACA',68),(318,'GUACARÍ',76),(319,'GUADALUPE',41),(319,'GUAMO',73),(320,'GUADUAS',25),(320,'GUAITARILLA',52),(320,'GUADALUPE',68),(320,'ORITO',86),(321,'GUATAPE',5),(322,'GUATEQUE',15),(322,'GUASCA',25),(322,'GUAPOTÁ',68),(323,'GUALMATÁN',52),(324,'GUATAQUÍ',25),(324,'GUAVATÁ',68),(325,'GUAYATÁ',15),(325,'MAPIRIPÁN',50),(325,'SAN LUIS DE PALENQUE',85),(326,'GUATAVITA',25),(327,'GÜEPSA',68),(328,'GUAYABAL DE SIQUIMA',25),(330,'MESETAS',50),(332,'GÜICÁN',15),(335,'GUAYABETAL',25),(339,'GUTIÉRREZ',25),(343,'BARRANCO MINAS',94),(344,'HACARÍ',54),(344,'HATO',68),(347,'HELICONIA',5),(347,'HERRÁN',54),(347,'HERVEO',73),(349,'HOBO',41),(349,'HONDA',73),(350,'LA APARTADA',23),(350,'LA MACARENA',50),(352,'ILES',52),(352,'ICONONZO',73),(353,'HISPANIA',5),(354,'IMUÉS',52),(355,'INZÁ',19),(356,'IPIALES',52),(357,'IQUIRA',41),(359,'ISNOS',41),(360,'ITAGUI',5),(361,'ITUANGO',5),(361,'ISTMINA',27),(362,'IZA',15),(364,'JARDÍN',5),(364,'JAMBALÓ',19),(364,'JAMUNDÍ',76),(367,'JENESANO',15),(368,'JERICÓ',5),(368,'JERICÓ',15),(368,'JERUSALÉN',25),(368,'JESÚS MARÍA',68),(370,'URIBE',50),(370,'JORDÁN',68),(372,'JUAN DE ACOSTA',8),(372,'JUNÍN',25),(372,'JURADÓ',27),(376,'LA CEJA',5),(377,'LABRANZAGRANDE',15),(377,'LA CALERA',25),(377,'LABATECA',54),(377,'LA BELLEZA',68),(377,'LA CUMBRE',76),(378,'LA ARGENTINA',41),(378,'HATONUEVO',44),(378,'LA CRUZ',52),(380,'LA ESTRELLA',5),(380,'LA CAPILLA',15),(380,'LA DORADA',17),(381,'LA FLORIDA',52),(383,'LA GLORIA',20),(383,'LA CELIA',66),(385,'LA LLANADA',52),(385,'LA ESPERANZA',54),(385,'LANDÁZURI',68),(386,'LA MESA',25),(388,'LA MERCED',17),(390,'LA PINTADA',5),(390,'LA TOLA',52),(392,'LA SIERRA',19),(394,'LA PALMA',25),(396,'LA PLATA',41),(397,'LA VEGA',19),(397,'LA PAZ',68),(398,'LA PEÑA',25),(398,'LA PLAYA',54),(399,'LA UNIÓN',52),(400,'LA UNIÓN',5),(400,'LA JAGUA DE IBIRICO',20),(400,'LEJANÍAS',50),(400,'LA VIRGINIA',66),(400,'LA UNIÓN',70),(400,'LA UNIÓN',76),(400,'TÁMARA',85),(401,'LA VICTORIA',15),(401,'LA TEBAIDA',63),(402,'LA VEGA',25),(403,'LA UVITA',15),(403,'LA VICTORIA',76),(405,'LEIVA',52),(405,'LOS PATIOS',54),(405,'LA CHORRERA',91),(406,'LEBRIJA',68),(407,'VILLA DE LEYVA',15),(407,'LENGUAZAQUE',25),(407,'LA PEDRERA',91),(408,'LÉRIDA',73),(410,'LA MONTAÑITA',18),(410,'TAURAMENA',85),(411,'LIBORINA',5),(411,'LINARES',52),(411,'LÍBANO',73),(413,'LLORÓ',27),(417,'LORICA',23),(418,'LÓPEZ',19),(418,'LOS ANDES',52),(418,'LOURDES',54),(418,'LOS SANTOS',68),(418,'LOS PALMITOS',70),(419,'LOS CÓRDOBAS',23),(420,'LA JAGUA DEL PILAR',44),(421,'LURUACO',8),(425,'MACEO',5),(425,'MACANAL',15),(425,'MEDIO ATRATO',27),(425,'MACARAVITA',68),(426,'MACHETA',25),(427,'MAGÜI',52),(429,'MAJAGUAL',70),(430,'MAGANGUÉ',13),(430,'MADRID',25),(430,'MEDIO BAUDÓ',27),(430,'MAICAO',44),(430,'TRINIDAD',85),(430,'LA VICTORIA',91),(432,'MÁLAGA',68),(433,'MALAMBO',8),(433,'MAHATES',13),(433,'MANZANARES',17),(435,'MALLAMA',52),(436,'MANATÍ',8),(436,'MANTA',25),(438,'MEDINA',25),(440,'MARINILLA',5),(440,'MARGARITA',13),(440,'MARSELLA',66),(440,'VILLANUEVA',85),(442,'MARÍA LA BAJA',13),(442,'MARIPÍ',15),(442,'MARMATO',17),(443,'MANAURE',20),(443,'SAN SEBASTIÁN DE MARIQUITA',73),(444,'MARQUETALIA',17),(444,'MATANZA',68),(446,'MARULANDA',17),(449,'MELGAR',73),(450,'MERCADERES',19),(450,'MEDIO SAN JUAN',27),(450,'PUERTO CONCORDIA',50),(455,'MIRAFLORES',15),(455,'MIRANDA',19),(456,'MISTRATÓ',66),(458,'MONTECRISTO',13),(460,'MILÁN',18),(460,'NUEVA GRANADA',47),(460,'MIRITI - PARANÁ',91),(461,'MURILLO',73),(464,'MONGUA',15),(464,'MOMIL',23),(464,'MOGOTES',68),(466,'MONGUÍ',15),(466,'MONTELÍBANO',23),(467,'MONTEBELLO',5),(468,'MOMPÓS',13),(468,'MOLAGAVITA',68),(469,'MONIQUIRÁ',15),(470,'MONTENEGRO',63),(473,'MORALES',13),(473,'MORALES',19),(473,'MOSQUERA',25),(473,'MOSQUERA',52),(473,'MORROA',70),(475,'MURINDÓ',5),(476,'MOTAVITA',15),(479,'MORELIA',18),(480,'MUTATÁ',5),(480,'MUZO',15),(480,'NARIÑO',52),(480,'MUTISCUA',54),(483,'NARIÑO',5),(483,'NARIÑO',25),(483,'NÁTAGA',41),(483,'NATAGAIMA',73),(486,'NEIRA',17),(486,'NEMOCÓN',25),(488,'NILO',25),(489,'NIMAIMA',25),(490,'NECOCLÍ',5),(490,'NOROSÍ',13),(490,'OLAYA HERRERA',52),(491,'NOBSA',15),(491,'NOCAIMA',25),(491,'NÓVITA',27),(494,'NUEVO COLÓN',15),(495,'NECHÍ',5),(495,'NORCASIA',17),(495,'NUQUÍ',27),(497,'OBANDO',76),(498,'OCAÑA',54),(498,'OCAMONTE',68),(500,'OICATÁ',15),(500,'MOÑITOS',23),(500,'OIBA',68),(501,'OLAYA',5),(502,'ONZAGA',68),(503,'OPORAPA',41),(504,'ORTEGA',73),(506,'VENECIA',25),(506,'OSPINA',52),(507,'OTANCHE',15),(508,'OVEJAS',70),(511,'PACHAVITA',15),(511,'PACOA',97),(513,'PÁCORA',17),(513,'PADILLA',19),(513,'PACHO',25),(514,'PÁEZ',15),(516,'PAIPA',15),(517,'PAEZ',19),(517,'PAILITAS',20),(518,'PAJARITO',15),(518,'PAIME',25),(518,'PAICOL',41),(518,'PAMPLONA',54),(520,'PALMAR DE VARELA',8),(520,'FRANCISCO PIZARRO',52),(520,'PAMPLONITA',54),(520,'PALOCABILDO',73),(520,'PALMIRA',76),(522,'PANQUEBA',15),(522,'PALMAR',68),(523,'PALMITO',70),(524,'PALESTINA',17),(524,'PANDI',25),(524,'PALERMO',41),(524,'PALMAS DEL SOCORRO',68),(524,'LA PRIMAVERA',99),(530,'PARATEBUENO',25),(530,'PALESTINA',41),(530,'PUERTO ALEGRÍA',91),(531,'PAUNA',15),(532,'PATÍA',19),(533,'PAYA',15),(533,'PIAMONTE',19),(533,'PÁRAMO',68),(535,'PASCA',25),(536,'PUERTO ARICA',91),(537,'PAZ DE RÍO',15),(540,'POLICARPA',52),(540,'PUERTO NARIÑO',91),(541,'PEÑOL',5),(541,'PENSILVANIA',17),(541,'PEDRAZA',47),(542,'PESCA',15),(543,'PEQUE',5),(545,'PIJIÑO DEL CARMEN',47),(547,'PIEDECUESTA',68),(547,'PIEDRAS',73),(548,'PIENDAMÓ',19),(548,'PITAL',41),(548,'PIJAO',63),(549,'PIOJÓ',8),(549,'PINILLOS',13),(549,'PINCHOTE',68),(550,'PISBA',15),(550,'PELAYA',20),(551,'PITALITO',41),(551,'PIVIJAY',47),(553,'PUERTO SANTANDER',54),(555,'PLANETA RICA',23),(555,'PLATO',47),(555,'PLANADAS',73),(558,'POLONUEVO',8),(560,'PONEDERA',8),(560,'MANAURE',44),(560,'POTOSÍ',52),(563,'PRADO',73),(563,'PRADERA',76),(564,'PROVIDENCIA',88),(565,'PROVIDENCIA',52),(568,'PUERTO GAITÁN',50),(568,'PUERTO ASÍS',86),(569,'PUERTO CAICEDO',86),(570,'PUEBLO BELLO',20),(570,'PUEBLO NUEVO',23),(570,'PUEBLOVIEJO',47),(571,'PUERTO GUZMÁN',86),(572,'PUERTO BOYACÁ',15),(572,'PUERTO SALGAR',25),(572,'PUEBLO RICO',66),(572,'PUENTE NACIONAL',68),(573,'PUERTO COLOMBIA',8),(573,'PUERTO TEJADA',19),(573,'PUERTO LÓPEZ',50),(573,'PUERRES',52),(573,'PUERTO PARRA',68),(573,'PUERTO LEGUÍZAMO',86),(574,'PUERTO ESCONDIDO',23),(575,'PUERTO WILCHES',68),(576,'PUEBLORRICO',5),(577,'PUERTO LLERAS',50),(579,'PUERTO BERRÍO',5),(580,'REGIDOR',13),(580,'QUÍPAMA',15),(580,'PUERTO LIBERTADOR',23),(580,'PULÍ',25),(580,'RÍO IRÓ',27),(585,'PUERTO NARE',5),(585,'PURACÉ',19),(585,'PUPIALES',52),(585,'PURIFICACIÓN',73),(586,'PURÍSIMA',23),(590,'PUERTO RICO',50),(591,'PUERTO TRIUNFO',5),(591,'PUERTO RONDÓN',81),(592,'PUERTO RICO',18),(592,'QUEBRADANEGRA',25),(594,'QUETAME',25),(594,'QUIMBAYA',63),(594,'QUINCHÍA',66),(596,'QUIPILE',25),(599,'RAMIRIQUÍ',15),(599,'APULO',25),(599,'RAGONVALIA',54),(600,'RÍO VIEJO',13),(600,'RÁQUIRA',15),(600,'RÍO QUITO',27),(604,'REMEDIOS',5),(605,'REMOLINO',47),(606,'REPELÓN',8),(606,'RESTREPO',50),(606,'RESTREPO',76),(607,'RETIRO',5),(610,'SAN JOSÉ DEL FRAGUA',18),(612,'RICAURTE',25),(612,'RICAURTE',52),(614,'RIOSUCIO',17),(614,'RÍO DE ORO',20),(615,'RIONEGRO',5),(615,'RIOSUCIO',27),(615,'RIVERA',41),(615,'RIONEGRO',68),(616,'RISARALDA',17),(616,'RIOBLANCO',73),(616,'RIOFRÍO',76),(620,'SAN CRISTÓBAL',13),(621,'RONDÓN',15),(621,'LA PAZ',20),(621,'ROBERTO PAYÁN',52),(622,'ROSAS',19),(622,'RONCESVALLES',73),(622,'ROLDANILLO',76),(624,'ROVIRA',73),(624,'SANTA ROSALÍA',99),(628,'SABANALARGA',5),(631,'SABANETA',5),(632,'SABOYÁ',15),(634,'SABANAGRANDE',8),(638,'SABANALARGA',8),(638,'SÁCHICA',15),(642,'SALGAR',5),(645,'SAN ANTONIO DEL TEQUENDAMA',25),(646,'SAMACÁ',15),(647,'SAN ANDRÉS DE CUERQUÍA',5),(647,'SAN ESTANISLAO',13),(649,'SAN CARLOS',5),(649,'SAN BERNARDO',25),(650,'SAN FERNANDO',13),(650,'SAN JUAN DEL CESAR',44),(652,'SAN FRANCISCO',5),(653,'SALAMINA',17),(653,'SAN CAYETANO',25),(654,'SAN JACINTO',13),(655,'SAN JACINTO DEL CAUCA',13),(655,'SABANA DE TORRES',68),(656,'SAN JERÓNIMO',5),(657,'SAN JUAN NEPOMUCENO',13),(658,'SAN JOSÉ DE LA MONTAÑA',5),(658,'SAN FRANCISCO',25),(659,'SAN JUAN DE URABÁ',5),(660,'SAN LUIS',5),(660,'SAN EDUARDO',15),(660,'SAHAGÚN',23),(660,'SAN JOSÉ DEL PALMAR',27),(660,'SALADOBLANCO',41),(660,'SABANAS DE SAN ANGEL',47),(660,'SALAZAR',54),(662,'SAMANÁ',17),(662,'SAN JUAN DE RÍO SECO',25),(663,'MAPIRIPANA',94),(664,'SAN PEDRO DE LOS MILAGROS',5),(664,'SAN JOSÉ DE PARE',15),(665,'SAN PEDRO DE URABA',5),(665,'SAN JOSÉ',17),(666,'TARAIRA',97),(667,'SAN RAFAEL',5),(667,'SAN MARTÍN DE LOBA',13),(667,'SAN LUIS DE GACENO',15),(668,'SAN AGUSTÍN',41),(669,'SAN ANDRÉS',68),(669,'PUERTO SANTANDER',91),(670,'SAN ROQUE',5),(670,'SAN PABLO',13),(670,'SAN ANDRÉS SOTAVENTO',23),(670,'SAN CALIXTO',54),(670,'SAMPUÉS',70),(670,'SAN PEDRO',76),(671,'SALDAÑA',73),(672,'SAN ANTERO',23),(673,'SANTA CATALINA',13),(673,'SAN MATEO',15),(673,'SAN CAYETANO',54),(673,'SAN BENITO',68),(674,'SAN VICENTE',5),(675,'SANTA LUCÍA',8),(675,'SAN BERNARDO DEL VIENTO',23),(675,'SALAMINA',47),(675,'SAN ANTONIO',73),(676,'SAN MIGUEL DE SEMA',15),(676,'SANTA MARÍA',41),(678,'SAN CARLOS',23),(678,'SAMANIEGO',52),(678,'SAN BENITO ABAD',70),(678,'SAN LUIS',73),(679,'SANTA BÁRBARA',5),(679,'SAN GIL',68),(680,'SAN CARLOS DE GUAROA',50),(680,'SANTIAGO',54),(681,'SAN PABLO DE BORBUR',15),(682,'SAN JOSÉ DE URÉ',23),(682,'SANTA ROSA DE CABAL',66),(682,'SAN JOAQUÍN',68),(683,'SANTA ROSA',13),(683,'SAN JUAN DE ARAMA',50),(683,'SANDONÁ',52),(684,'SAN JOSÉ DE MIRANDA',68),(685,'SANTO TOMÁS',8),(685,'SAN BERNARDO',52),(686,'SANTA ROSA DE OSOS',5),(686,'SANTANA',15),(686,'SAN PELAYO',23),(686,'SAN JUANITO',50),(686,'SAN MIGUEL',68),(686,'SANTA ISABEL',73),(687,'SAN LORENZO',52),(687,'SANTUARIO',66),(688,'SANTA ROSA DEL SUR',13),(689,'SAN MARTÍN',50),(689,'SAN VICENTE DE CHUCURÍ',68),(690,'SANTO DOMINGO',5),(690,'SANTA MARÍA',15),(690,'SALENTO',63),(692,'SAN SEBASTIÁN DE BUENAVISTA',47),(693,'SANTA ROSA DE VITERBO',15),(693,'SAN SEBASTIÁN',19),(693,'SAN PABLO',52),(694,'SAN PEDRO DE CARTAGO',52),(696,'SANTA SOFÍA',15),(696,'SANTA BÁRBARA',52),(697,'EL SANTUARIO',5),(698,'SANTANDER DE QUILICHAO',19),(699,'SANTACRUZ',52),(701,'SANTA ROSA',19),(702,'SAN JUAN DE BETULIA',70),(703,'SAN ZENÓN',47),(705,'SANTA BÁRBARA',68),(707,'SANTA ANA',47),(708,'SAN MARCOS',70),(710,'SAN ALBERTO',20),(711,'VISTAHERMOSA',50),(713,'SAN ONOFRE',70),(717,'SAN PEDRO',70),(718,'SASAIMA',25),(720,'SATIVANORTE',15),(720,'SANTA BÁRBARA DE PINTO',47),(720,'SAPUYES',52),(720,'SARDINATA',54),(720,'SANTA HELENA DEL OPÓN',68),(723,'SATIVASUR',15),(736,'SEGOVIA',5),(736,'SESQUILÉ',25),(736,'SEVILLA',76),(736,'SARAVENA',81),(740,'SIACHOQUE',15),(740,'SIBATÉ',25),(742,'SAN LUIS DE SINCÉ',70),(743,'SILVIA',19),(743,'SILVANIA',25),(743,'SILOS',54),(744,'SIMITÍ',13),(745,'SIMIJACA',25),(745,'SIPÍ',27),(745,'SITIONUEVO',47),(745,'SIMACOTA',68),(749,'SIBUNDOY',86),(750,'SAN DIEGO',20),(753,'SOATÁ',15),(753,'SAN VICENTE DEL CAGUÁN',18),(754,'SOACHA',25),(755,'SOCOTÁ',15),(755,'SOCORRO',68),(755,'SAN FRANCISCO',86),(756,'SONSON',5),(756,'SOLANO',18),(757,'SOCHA',15),(757,'SAN MIGUEL',86),(758,'SOLEDAD',8),(758,'SOPÓ',25),(759,'SOGAMOSO',15),(760,'SOPLAVIENTO',13),(760,'SOTARA',19),(760,'SANTIAGO',86),(761,'SOPETRÁN',5),(761,'SOMONDOCO',15),(762,'SORA',15),(763,'SOTAQUIRÁ',15),(764,'SORACÁ',15),(769,'SUBACHOQUE',25),(770,'SUAN',8),(770,'SAN MARTÍN',20),(770,'SUAZA',41),(770,'SUAITA',68),(770,'SUÁREZ',73),(771,'SUCRE',70),(772,'SUESCA',25),(773,'SUCRE',68),(773,'CUMARIBO',99),(774,'SUSACÓN',15),(776,'SUTAMARCHÁN',15),(777,'SUPÍA',17),(777,'SUPATÁ',25),(777,'PAPUNAUA',97),(778,'SUTATENZA',15),(779,'SUSA',25),(780,'TALAIGUA NUEVO',13),(780,'SUÁREZ',19),(780,'SURATÁ',68),(781,'SUTATAUSA',25),(785,'SOLITA',18),(785,'SUCRE',19),(785,'TABIO',25),(786,'TAMINANGO',52),(787,'TAMALAMEQUE',20),(787,'TADÓ',27),(788,'TANGUA',52),(789,'TÁMESIS',5),(790,'TARAZÁ',5),(790,'TASCO',15),(791,'TARQUI',41),(792,'TARSO',5),(793,'TAUSA',25),(794,'TAME',81),(797,'TENA',25),(797,'TESALIA',41),(798,'TENZA',15),(798,'TENERIFE',47),(798,'TARAPACÁ',91),(799,'TENJO',25),(799,'TELLO',41),(800,'UNGUÍA',27),(800,'TEORAMA',54),(801,'TERUEL',41),(804,'TIBANÁ',15),(805,'TIBACUY',25),(806,'TIBASOSA',15),(807,'TIMBÍO',19),(807,'TIERRALTA',23),(807,'TIBIRITA',25),(807,'TIMANÁ',41),(808,'TINJACÁ',15),(809,'TITIRIBÍ',5),(809,'TIMBIQUÍ',19),(810,'TIQUISIO',13),(810,'TIPACOQUE',15),(810,'UNIÓN PANAMERICANA',27),(810,'TIBÚ',54),(814,'TOCA',15),(815,'TUCHÍN',23),(815,'TOCAIMA',25),(816,'TOGÜÍ',15),(817,'TOCANCIPÁ',25),(819,'TOLEDO',5),(820,'TÓPAGA',15),(820,'TOLEDO',54),(820,'TONA',68),(820,'SANTIAGO DE TOLÚ',70),(821,'TORIBIO',19),(822,'TOTA',15),(823,'TOPAIPÍ',25),(823,'TOLÚ VIEJO',70),(823,'TORO',76),(824,'TOTORÓ',19),(828,'TRUJILLO',76),(832,'TUBARÁ',8),(832,'TUNUNGUÁ',15),(834,'TULUÁ',76),(835,'TURMEQUÉ',15),(835,'SAN ANDRES DE TUMACO',52),(836,'TURBACO',13),(837,'TURBO',5),(837,'TUTA',15),(838,'TURBANÁ',13),(838,'TÚQUERRES',52),(839,'TUTAZÁ',15),(839,'UBALÁ',25),(841,'UBAQUE',25),(842,'URAMITA',5),(842,'UMBITA',15),(843,'VILLA DE SAN DIEGO DE UBATE',25),(845,'VILLA RICA',19),(845,'UNE',25),(845,'ULLOA',76),(847,'URRAO',5),(847,'URIBIA',44),(849,'USIACURÍ',8),(851,'ÚTICA',25),(854,'VALDIVIA',5),(854,'VALLE DE SAN JUAN',73),(855,'VALENCIA',23),(855,'URUMITA',44),(855,'VALLE DE SAN JOSÉ',68),(856,'VALPARAÍSO',5),(858,'VEGACHÍ',5),(860,'VALPARAÍSO',18),(861,'VENECIA',5),(861,'VENTAQUEMADA',15),(861,'VÉLEZ',68),(861,'VENADILLO',73),(862,'VERGARA',25),(863,'VERSALLES',76),(865,'VALLE DEL GUAMUEZ',86),(867,'VICTORIA',17),(867,'VIANÍ',25),(867,'VETAS',68),(869,'VIJES',76),(870,'VILLAHERMOSA',73),(871,'VILLAGÓMEZ',25),(871,'VILLA CARO',54),(872,'VILLAVIEJA',41),(872,'VILLANUEVA',68),(873,'VIGÍA DEL FUERTE',5),(873,'VILLANUEVA',13),(873,'VILLAMARÍA',17),(873,'VILLAPINZÓN',25),(873,'VILLARRICA',73),(874,'VILLANUEVA',44),(874,'VILLA DEL ROSARIO',54),(875,'VILLETA',25),(877,'VITERBO',17),(878,'VIOTÁ',25),(879,'VIRACACHÁ',15),(883,'SAN FELIPE',94),(884,'PUERTO COLOMBIA',94),(885,'YALÍ',5),(885,'YACOPÍ',25),(885,'YAGUARÁ',41),(885,'YACUANQUER',52),(885,'VILLAGARZÓN',86),(885,'LA GUADALUPE',94),(886,'CACAHUAL',94),(887,'YARUMAL',5),(887,'PANA PANA',94),(888,'MORICHAL',94),(889,'YAVARATÉ',97),(890,'YOLOMBÓ',5),(890,'YOTOCO',76),(892,'YUMBO',76),(893,'YONDÓ',5),(894,'ZAMBRANO',13),(895,'ZARAGOZA',5),(895,'ZAPATOCA',68),(895,'ZARZAL',76),(897,'ZETAQUIRA',15),(898,'ZIPACÓN',25),(899,'ZIPAQUIRÁ',25),(960,'ZAPAYÁN',47),(980,'ZONA BANANERA',47);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad_comisiones`
--

DROP TABLE IF EXISTS `ciudad_comisiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad_comisiones` (
  `id_ciudad` int(11) NOT NULL,
  `id_dpto` int(11) NOT NULL,
  `id_comision` int(10) NOT NULL,
  `salida_estimada` date DEFAULT NULL,
  `llegada_estimada` date DEFAULT NULL,
  `empresa_vereda` varchar(100) DEFAULT NULL,
  `valor_viatico` double DEFAULT NULL,
  `id_ciudadComision` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_ciudadComision`),
  KEY `fk_ciudad_has_comisiones_comisiones1_idx` (`id_comision`),
  KEY `fk_ciudad_has_comisiones_ciudad1_idx` (`id_ciudad`,`id_dpto`),
  CONSTRAINT `fk_ciudad_has_comisiones_ciudad1` FOREIGN KEY (`id_ciudad`, `id_dpto`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ciudad_has_comisiones_comisiones1` FOREIGN KEY (`id_comision`) REFERENCES `comisiones` (`id_comision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_comisiones`
--

LOCK TABLES `ciudad_comisiones` WRITE;
/*!40000 ALTER TABLE `ciudad_comisiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad_comisiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comisiones`
--

DROP TABLE IF EXISTS `comisiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comisiones` (
  `id_comision` int(10) NOT NULL AUTO_INCREMENT,
  `objetivo_comision` varchar(100) NOT NULL,
  `fecha_tramite` datetime NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_dpto` int(11) NOT NULL,
  `id_centro_formacion` int(11) NOT NULL,
  `id_ficha_caracterizacion` int(11) NOT NULL,
  `id_descripcion` int(11) NOT NULL,
  `id_banco` int(11) NOT NULL,
  `id_tipo_pasaje` int(11) DEFAULT NULL,
  `transp_intermunicipal` tinyint(1) DEFAULT NULL,
  `num_com_servicios` int(11) DEFAULT NULL,
  `observaciones_orden` varchar(1000) DEFAULT NULL,
  `suministra_vehiculo` tinyint(1) DEFAULT NULL,
  `objetivos` varchar(3000) DEFAULT NULL,
  `mesa_planificar` varchar(45) DEFAULT NULL,
  `num_dias` int(11) DEFAULT NULL,
  `aprobado` tinyint(1) DEFAULT NULL,
  `trans_intermunicipal` int(11) DEFAULT NULL,
  `trans_comision` int(11) DEFAULT NULL,
  `otros_gastos` int(11) DEFAULT NULL,
  `vehiculo_sena` int(11) DEFAULT NULL,
  `vehiculo_comisionado` int(11) DEFAULT NULL,
  `auxilio_manutencion` int(11) DEFAULT NULL,
  `fecha_entrega_informe` date DEFAULT NULL,
  `actividades_o_temas` varchar(3000) DEFAULT NULL,
  `compromiso_sena` varchar(3000) DEFAULT NULL,
  `prod_entragados` varchar(3000) DEFAULT NULL,
  `saldo_negativo` double DEFAULT NULL,
  `saldo_positivo` double DEFAULT NULL,
  `presupuesto` varchar(45) DEFAULT NULL,
  `id_grupo` int(11) DEFAULT NULL,
  `fecha_orden` datetime DEFAULT NULL,
  `id_contrato` int(11) NOT NULL,
  PRIMARY KEY (`id_comision`),
  KEY `fk_comisiones_Usuarios1_idx` (`id_usuario`),
  KEY `fk_comisiones_ciudad1_idx` (`id_ciudad`,`id_dpto`),
  KEY `fk_comisiones_centro_formacion1_idx` (`id_centro_formacion`),
  KEY `fk_comisiones_ficha_caracterizacion1_idx` (`id_ficha_caracterizacion`),
  KEY `fk_comisiones_descripciones_referencias_viaticos1_idx` (`id_descripcion`),
  KEY `fk_comisiones_bancos1_idx` (`id_banco`),
  KEY `fk_comisiones_tipos_pasajes1_idx` (`id_tipo_pasaje`),
  KEY `fk_comisiones_grupos1_idx` (`id_grupo`),
  KEY `fk_comisiones_contratos1_idx` (`id_contrato`),
  CONSTRAINT `fk_comisiones_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_bancos1` FOREIGN KEY (`id_banco`) REFERENCES `bancos` (`id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_centro_formacion1` FOREIGN KEY (`id_centro_formacion`) REFERENCES `centro_formacion` (`id_centro_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_ciudad1` FOREIGN KEY (`id_ciudad`, `id_dpto`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_descripciones_referencias_viaticos1` FOREIGN KEY (`id_descripcion`) REFERENCES `descripciones_referencias_viaticos` (`id_descripcion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_ficha_caracterizacion1` FOREIGN KEY (`id_ficha_caracterizacion`) REFERENCES `ficha_caracterizacion` (`id_ficha_caracterizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_grupos1` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_tipos_pasajes1` FOREIGN KEY (`id_tipo_pasaje`) REFERENCES `tipos_pasajes` (`id_tipo_pasaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comisiones`
--

LOCK TABLES `comisiones` WRITE;
/*!40000 ALTER TABLE `comisiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `comisiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comisiones_cdp`
--

DROP TABLE IF EXISTS `comisiones_cdp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comisiones_cdp` (
  `id_comision` int(10) NOT NULL,
  `numero_cdp` int(11) NOT NULL,
  PRIMARY KEY (`id_comision`,`numero_cdp`),
  KEY `fk_comisiones_has_cdp_cdp1_idx` (`numero_cdp`),
  KEY `fk_comisiones_has_cdp_comisiones1_idx` (`id_comision`),
  CONSTRAINT `fk_comisiones_has_cdp_cdp1` FOREIGN KEY (`numero_cdp`) REFERENCES `cdp` (`numero_cdp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comisiones_has_cdp_comisiones1` FOREIGN KEY (`id_comision`) REFERENCES `comisiones` (`id_comision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comisiones_cdp`
--

LOCK TABLES `comisiones_cdp` WRITE;
/*!40000 ALTER TABLE `comisiones_cdp` DISABLE KEYS */;
/*!40000 ALTER TABLE `comisiones_cdp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comunas`
--

DROP TABLE IF EXISTS `comunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comunas` (
  `id_comuna` int(11) NOT NULL,
  `nombre_comuna` varchar(45) DEFAULT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_dpto` int(11) NOT NULL,
  PRIMARY KEY (`id_comuna`),
  KEY `fk_comunas_ciudad1_idx` (`id_ciudad`,`id_dpto`),
  CONSTRAINT `fk_comunas_ciudad1` FOREIGN KEY (`id_ciudad`, `id_dpto`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comunas`
--

LOCK TABLES `comunas` WRITE;
/*!40000 ALTER TABLE `comunas` DISABLE KEYS */;
INSERT INTO `comunas` VALUES (1,'Comuna Uno',520,76),(2,'Comuna Dos',520,76),(3,'Comuna Tres ',520,76),(4,'Comuna Cuatro',520,76),(5,'Comuna Cinco',520,76),(6,'Comuna Seis',520,76),(7,'Comuna Siete',520,76);
/*!40000 ALTER TABLE `comunas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contratos` (
  `id_contrato` int(11) NOT NULL AUTO_INCREMENT,
  `numero_de_contrato` varchar(20) NOT NULL,
  `Fecha_suscripcion` date NOT NULL,
  `fecha_inicio_contrato` date NOT NULL,
  `fecha_fin_contrato` date NOT NULL,
  `plazo_dias` int(11) DEFAULT NULL,
  `plazo_meses` tinyint(4) DEFAULT NULL,
  `objeto_contractual` varchar(500) NOT NULL,
  `obligaciones` varchar(4000) DEFAULT NULL,
  `valor_contrato` decimal(10,0) DEFAULT NULL,
  `primer_pago` decimal(9,0) DEFAULT NULL,
  `ultimo_pago` decimal(10,0) DEFAULT NULL,
  `numero_de_mensualidades` tinyint(4) DEFAULT NULL,
  `valor_mensual` decimal(9,0) DEFAULT NULL,
  `fecha_anexo` date DEFAULT NULL,
  `fecha_de_autorizacion` date DEFAULT NULL,
  `fecha_de_estudio_previo` date DEFAULT NULL,
  `fecha_de_idoneidad` date DEFAULT NULL,
  `adicion_presupuestal` decimal(9,0) DEFAULT NULL,
  `adicion_plazo_nueva_fecha` date DEFAULT NULL,
  `id_poliza` int(11) DEFAULT NULL,
  `id_cuentas_bancarias` int(11) DEFAULT NULL,
  `observaciones` varchar(5000) DEFAULT NULL,
  `id_tipo_contrato` int(11) NOT NULL,
  `justificacion` varchar(500) DEFAULT NULL,
  `crp` int(11) DEFAULT NULL,
  `registro_presupuestal` varchar(25) DEFAULT NULL,
  `fecha_reg_presupuestal` date DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  UNIQUE KEY `numero_de_contrato_UNIQUE` (`numero_de_contrato`),
  KEY `fk_contratos_tipo_de_contrato1_idx` (`id_tipo_contrato`),
  CONSTRAINT `fk_contratos_tipo_de_contrato1` FOREIGN KEY (`id_tipo_contrato`) REFERENCES `tipo_de_contrato` (`id_tipo_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratos`
--

LOCK TABLES `contratos` WRITE;
/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
INSERT INTO `contratos` VALUES (1,'4060','2014-02-02','2014-02-20','2015-01-01',NULL,NULL,'Mejorar Locaciones','',15000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,'hay un inconveniente en el área administrativa',NULL,'',NULL),(2,'5000','2013-02-02','2014-05-05','2014-06-05',NULL,NULL,'Pintar El Sena',NULL,10000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL),(3,'1','2015-04-01','2015-04-06','2016-04-04',1,12,'objeto de prueba','obligación de prueba',12000000,10000000,2000000,2,NULL,'2015-04-08','2015-04-03','2015-03-25','2015-04-02',NULL,'2015-09-02',NULL,NULL,'',1,'',NULL,NULL,NULL),(4,'2','2015-06-02','2015-06-08','2016-06-15',1,12,'this is not real','well a lot of it',23000000,2000000,21000000,2,1999997,'2015-06-01','2015-06-01','2015-06-01','2015-06-01',10000,'2015-07-01',NULL,NULL,'this is not real',2,'this is not real',NULL,'1234567','2015-07-01'),(5,'3','2015-01-06','2015-02-02','2016-02-02',NULL,NULL,'materiales para la construcción del laboratorio','',45000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,'algo distinta',NULL,'',NULL),(7,'4','2015-01-05','2015-02-02','2016-02-02',NULL,NULL,'materiales para reparaciones locativas','',45000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,'',NULL,'',NULL);
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_onbase_producidas`
--

DROP TABLE IF EXISTS `datos_onbase_producidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_onbase_producidas` (
  `num_radicado_producida` varchar(100) NOT NULL,
  `nis` varchar(100) DEFAULT NULL,
  `codigo_regional` varchar(100) DEFAULT NULL,
  `medio_de_ingreso` varchar(100) DEFAULT NULL,
  `entrega_a_la_mano` varchar(100) DEFAULT NULL,
  `tipo_documento` varchar(100) DEFAULT NULL,
  `tiempo_respuesta` varchar(100) DEFAULT NULL,
  `num_anexos` varchar(100) DEFAULT NULL,
  `descripcion_anexos` varchar(100) DEFAULT NULL,
  `tipo_digitalizacion` varchar(100) DEFAULT NULL,
  `asunto` varchar(100) DEFAULT NULL,
  `descripcion_asunto` varchar(100) DEFAULT NULL,
  `cod_dependencia_remitente_interno` varchar(100) DEFAULT NULL,
  `dependencia_remitente_interno` varchar(100) DEFAULT NULL,
  `funcionario_remitente_interno` varchar(100) DEFAULT NULL,
  `mail_from_address` varchar(100) DEFAULT NULL,
  `firmado_por` varchar(100) DEFAULT NULL,
  `cfp_destino` varchar(100) DEFAULT NULL,
  `funcionario_destino` varchar(100) DEFAULT NULL,
  `email_destino` varchar(100) DEFAULT NULL,
  `dependencia_destino` varchar(100) DEFAULT NULL,
  `regional_remitente_interno` varchar(100) DEFAULT NULL,
  `cod_regional_destino` varchar(100) DEFAULT NULL,
  `nom_regional_destino` varchar(100) DEFAULT NULL,
  `sw_envio_correo` varchar(100) DEFAULT NULL,
  `copia_cod_dependencia` varchar(100) DEFAULT NULL,
  `copia_funcionario_destinatario` varchar(100) DEFAULT NULL,
  `copia_email_usuario` varchar(100) DEFAULT NULL,
  `mail_cc` varchar(100) DEFAULT NULL,
  `copia_dependencia` varchar(100) DEFAULT NULL,
  `copia_cod_regional` varchar(100) DEFAULT NULL,
  `copia_nom_regional` varchar(100) DEFAULT NULL,
  `destinatario_externo` varchar(100) DEFAULT NULL,
  `dependencia_destinatario_externo` varchar(100) DEFAULT NULL,
  `funcionario_destinatario_externo` varchar(100) DEFAULT NULL,
  `direccion_destinatario_externo` varchar(100) DEFAULT NULL,
  `municipio_destinatario_externo` varchar(100) DEFAULT NULL,
  `depto_destinatario_externo` varchar(100) DEFAULT NULL,
  `pais_destinatario_externo` varchar(100) DEFAULT NULL,
  `ciudad_destinatario_ext_internacional` varchar(100) DEFAULT NULL,
  `empresa_transportadora` varchar(100) DEFAULT NULL,
  `num_guia` varchar(100) DEFAULT NULL,
  `valor_1` varchar(100) DEFAULT NULL,
  `entregado_a_externo` varchar(100) DEFAULT NULL,
  `mail_to` varchar(100) DEFAULT NULL,
  `copia_otros_destinatario_externo` varchar(100) DEFAULT NULL,
  `copia_dependencia_destinatario_externo` varchar(100) DEFAULT NULL,
  `copia_funcionario_externo` varchar(100) DEFAULT NULL,
  `copia_direccion_destinatario_externo` varchar(100) DEFAULT NULL,
  `copia_municipio_destinatario_externo` varchar(100) DEFAULT NULL,
  `copia_depto_detinatario_externo` varchar(100) DEFAULT NULL,
  `pais_otros_destinatario_externo` varchar(100) DEFAULT NULL,
  `copia_ciudad_destinatarios_externos` varchar(100) DEFAULT NULL,
  `cde_empresa_transportadora` varchar(100) DEFAULT NULL,
  `cde_num_guia` varchar(100) DEFAULT NULL,
  `cde_valor` varchar(100) DEFAULT NULL,
  `cde_entregado_a_externo` varchar(100) DEFAULT NULL,
  `num_guia_sipos` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `username_od` varchar(100) DEFAULT NULL,
  `entregado_a_interno` varchar(100) DEFAULT NULL,
  `entregado_a_regional` varchar(100) DEFAULT NULL,
  `fecha_hora` varchar(100) DEFAULT NULL,
  `num_plantilla` varchar(100) DEFAULT NULL,
  `realizado_por` varchar(100) DEFAULT NULL,
  `flag` varchar(100) DEFAULT NULL,
  `cod_regional_destino_original` varchar(100) DEFAULT NULL,
  `nom_regional_destino_original` varchar(100) DEFAULT NULL,
  `cod_cfp_destino_original` varchar(100) DEFAULT NULL,
  `dependencia_destino_original` varchar(100) DEFAULT NULL,
  `funcionario_destino_original` varchar(100) DEFAULT NULL,
  `wf_usuario_balanceo` varchar(100) DEFAULT NULL,
  `fecha_hora_acuse` varchar(100) DEFAULT NULL,
  `handle` varchar(100) DEFAULT NULL,
  `num_antecendente` varchar(100) DEFAULT NULL,
  `control_keyword` varchar(100) DEFAULT NULL,
  `fecha_procedencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`num_radicado_producida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_onbase_producidas`
--

LOCK TABLES `datos_onbase_producidas` WRITE;
/*!40000 ALTER TABLE `datos_onbase_producidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_onbase_producidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_onbase_recibidas`
--

DROP TABLE IF EXISTS `datos_onbase_recibidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_onbase_recibidas` (
  `num_radicado_recibida` varchar(100) NOT NULL,
  `nis` varchar(100) DEFAULT NULL,
  `codigo_regional` varchar(100) DEFAULT NULL,
  `modo_ingreso` varchar(100) DEFAULT NULL,
  `entraga_a_la_mano` varchar(100) DEFAULT NULL,
  `fecha_procedencia` varchar(100) DEFAULT NULL,
  `numero_radicado_origen` varchar(100) DEFAULT NULL,
  `tipo_documento` varchar(100) DEFAULT NULL,
  `tiempo_respuesta_dias` varchar(100) DEFAULT NULL,
  `fecha_respuesta` varchar(100) DEFAULT NULL,
  `numero_de_anexos` varchar(100) DEFAULT NULL,
  `descripcion_anexos` varchar(100) DEFAULT NULL,
  `tipo_digitalizacion` varchar(100) DEFAULT NULL,
  `asunto` varchar(100) DEFAULT NULL,
  `dp_tipo_de_peticion` varchar(100) DEFAULT NULL,
  `tema_q_y_r` varchar(100) DEFAULT NULL,
  `descripcion_asunto` varchar(100) DEFAULT NULL,
  `empresa_transportadora` varchar(100) DEFAULT NULL,
  `numero_guia_r` varchar(100) DEFAULT NULL,
  `cc_nit_remitente` varchar(100) DEFAULT NULL,
  `remitente_nombre_entidad_externa` varchar(100) DEFAULT NULL,
  `nombre_persona` varchar(100) DEFAULT NULL,
  `cargo_persona_o_dependencia` varchar(100) DEFAULT NULL,
  `municipio` varchar(100) DEFAULT NULL,
  `departamento` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `direccion_remitente` varchar(100) DEFAULT NULL,
  `telefono_remitente` varchar(100) DEFAULT NULL,
  `email_remitente` varchar(100) DEFAULT NULL,
  `cod_dependencia_cfp_destino` varchar(100) DEFAULT NULL,
  `nombre_regional_destino` varchar(100) DEFAULT NULL,
  `cod_regional_destino` varchar(100) DEFAULT NULL,
  `funcionario_destino` varchar(100) DEFAULT NULL,
  `email_usuario` varchar(100) DEFAULT NULL,
  `dependencia_destino` varchar(100) DEFAULT NULL,
  `copia_cod_dependencia` varchar(100) DEFAULT NULL,
  `copia_cod_regional` varchar(100) DEFAULT NULL,
  `copia_funcionario_destino` varchar(100) DEFAULT NULL,
  `copia_dependencia` varchar(100) DEFAULT NULL,
  `copia_nombre_regional` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `sw_envio_correo` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `wf_usuario_actual` varchar(100) DEFAULT NULL,
  `fecha_hora` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `copia_email_usuario` varchar(100) DEFAULT NULL,
  `copia_username` varchar(100) DEFAULT NULL,
  `usar_name_od` varchar(100) DEFAULT NULL,
  `cod_archivo_fisico` varchar(100) DEFAULT NULL,
  `mail_mesageid` varchar(100) DEFAULT NULL,
  `wf_usuario_balanceo` varchar(100) DEFAULT NULL,
  `entregado_a_interno` varchar(100) DEFAULT NULL,
  `superior_funcionario_destino_mail` varchar(100) DEFAULT NULL,
  `mail_cc` varchar(100) DEFAULT NULL,
  `tipo_de_proceso` varchar(100) DEFAULT NULL,
  `realizado_por` varchar(100) DEFAULT NULL,
  `flag` varchar(100) DEFAULT NULL,
  `cod_dependencia_o_cfp_destino` varchar(100) DEFAULT NULL,
  `dependencia_destino_original` varchar(100) DEFAULT NULL,
  `funcionario_destino_original` varchar(100) DEFAULT NULL,
  `handle` varchar(100) DEFAULT NULL,
  `numero_antecedentes` varchar(100) DEFAULT NULL,
  `control_security_keyword` varchar(100) DEFAULT NULL,
  `email_superior_destino` varchar(100) DEFAULT NULL,
  `regional_remitente_interno` varchar(100) DEFAULT NULL,
  `cod_regional_remitente_interno` varchar(100) DEFAULT NULL,
  `funcionario_remitente_interno` varchar(100) DEFAULT NULL,
  `cod_dependencia_remitente_interno` varchar(100) DEFAULT NULL,
  `dependencia_remitente_interna` varchar(100) DEFAULT NULL,
  `fecha_del_documento` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`num_radicado_recibida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_onbase_recibidas`
--

LOCK TABLES `datos_onbase_recibidas` WRITE;
/*!40000 ALTER TABLE `datos_onbase_recibidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_onbase_recibidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `id_dpto` int(11) NOT NULL,
  `nombre_dpto` varchar(45) DEFAULT NULL,
  `id_pais` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id_dpto`),
  KEY `fk_Departamentos_Pais1_idx` (`id_pais`),
  CONSTRAINT `fk_Departamentos_Pais1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (5,'ANTIOQUIA','COL'),(8,'ATLANTICO','COL'),(11,'BOGOTA','COL'),(13,'BOLIVAR','COL'),(15,'BOYACA','COL'),(17,'CALDAS','COL'),(18,'CAQUETA','COL'),(19,'CAUCA','COL'),(20,'CESAR','COL'),(23,'CORDOBA','COL'),(25,'CUNDINAMARCA','COL'),(27,'CHOCO','COL'),(41,'HUILA','COL'),(44,'LA GUAJIRA','COL'),(47,'MAGDALENA','COL'),(50,'META','COL'),(52,'NARIÑO','COL'),(54,'N. DE SANTANDER','COL'),(63,'QUINDIO','COL'),(66,'RISARALDA','COL'),(68,'SANTANDER','COL'),(70,'SUCRE','COL'),(73,'TOLIMA','COL'),(76,'VALLE DEL CAUCA','COL'),(81,'ARAUCA','COL'),(85,'CASANARE','COL'),(86,'PUTUMAYO','COL'),(88,'SAN ANDRES','COL'),(91,'AMAZONAS','COL'),(94,'GUAINIA','COL'),(95,'GUAVIARE','COL'),(97,'VAUPES','COL'),(99,'VICHADA','COL');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependencias`
--

DROP TABLE IF EXISTS `dependencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependencias` (
  `codigo_de_dependencia` int(10) NOT NULL,
  `descripcion_dependencia` varchar(100) NOT NULL,
  `id_presupuestos` int(11) NOT NULL,
  PRIMARY KEY (`codigo_de_dependencia`),
  KEY `fk_dependencias_presupuestos1_idx` (`id_presupuestos`),
  CONSTRAINT `fk_dependencias_presupuestos1` FOREIGN KEY (`id_presupuestos`) REFERENCES `presupuestos` (`id_presupuestos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependencias`
--

LOCK TABLES `dependencias` WRITE;
/*!40000 ALTER TABLE `dependencias` DISABLE KEYS */;
INSERT INTO `dependencias` VALUES (1,'subdireccion',10);
/*!40000 ALTER TABLE `dependencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripciones_referencias_viaticos`
--

DROP TABLE IF EXISTS `descripciones_referencias_viaticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descripciones_referencias_viaticos` (
  `id_descripcion` int(11) NOT NULL,
  `nombre_descripcion` varchar(5000) NOT NULL,
  PRIMARY KEY (`id_descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripciones_referencias_viaticos`
--

LOCK TABLES `descripciones_referencias_viaticos` WRITE;
/*!40000 ALTER TABLE `descripciones_referencias_viaticos` DISABLE KEYS */;
INSERT INTO `descripciones_referencias_viaticos` VALUES (1,'viatcos gastos de viajes para capacitacion'),(2,'viatcos gastos de viajes administrativos');
/*!40000 ALTER TABLE `descripciones_referencias_viaticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentos`
--

DROP TABLE IF EXISTS `documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentos` (
  `id_documentos` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) DEFAULT NULL,
  `fecha_ingreso` datetime DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `idtipos_documento_gd` int(11) NOT NULL,
  PRIMARY KEY (`id_documentos`),
  KEY `fk_documentos_usuarios1_idx` (`id_usuario`),
  KEY `fk_documentos_tipos_documento_gd1_idx` (`idtipos_documento_gd`),
  CONSTRAINT `fk_documentos_tipos_documento_gd1` FOREIGN KEY (`idtipos_documento_gd`) REFERENCES `tipos_documento_gd` (`idtipos_documento_gd`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documentos_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentos`
--

LOCK TABLES `documentos` WRITE;
/*!40000 ALTER TABLE `documentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eps`
--

DROP TABLE IF EXISTS `eps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eps` (
  `id_eps` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_eps` varchar(100) NOT NULL,
  PRIMARY KEY (`id_eps`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eps`
--

LOCK TABLES `eps` WRITE;
/*!40000 ALTER TABLE `eps` DISABLE KEYS */;
INSERT INTO `eps` VALUES (1,'COLMEDICA ENTIDAD PROMOTORA DE SALUD S.A.'),(2,'CAJA DE COMPENSACION FAMILIAR COMPENSAR.'),(3,'COMFENALCO VALLE.'),(4,'SALUD COLPATRIA S.A.'),(5,'CAFESALUD EPS.'),(6,'CRUZBLANCA S.A.'),(7,'E.P.S. FAMISANAR LTDA. CAFAM COLSUBSIDIO.'),(8,'E.P.S. SANITAS S.A.'),(9,'SALUDCOLOMBIA EPS S.A.'),(10,'SALUDCOOP EPS Avenida.'),(11,'SALUDVIDA S.A. EPS.'),(12,'SALUDVIDA S.A. EPS.'),(13,'SERVICIO OCCIDENTAL DE SALUD S.A. S.O.S.'),(14,'SOLIDARIA DE SALUD SOLSALUD S.A.'),(15,'COOMEVA EPS S.A.'),(16,'INSTITUTO DE SEGUROS SOCIALES.'),(17,'CAPRECOM.'),(18,'SALUD TOTAL S.A. '),(19,'CAJA DE COMPENSACION FAMILIAR COMFENALCO ANTIOQUIA.'),(20,'COMPAÑIA SURAMERICANA DE SERVICIOS DE SALUD S.A. '),(21,'HUMANA VIVIR S.A. EPS.'),(22,'REDSALUD ATENCION HUMANA EPS S.A.');
/*!40000 ALTER TABLE `eps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_civil` (
  `id_estado_civil` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_estado_civil` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_estado_civil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
INSERT INTO `estado_civil` VALUES (1,'Soltero'),(2,'Casado'),(3,'Divorciado'),(4,'Viudo'),(5,'Separado'),(6,'Union Libre');
/*!40000 ALTER TABLE `estado_civil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Ignorado'),(2,'Iniciado'),(3,'Interrumpido'),(4,'En Curso'),(5,'Por Resolver'),(6,'Finalizado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estrato_social`
--

DROP TABLE IF EXISTS `estrato_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estrato_social` (
  `id_estrato_social` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_estrato` varchar(20) NOT NULL,
  PRIMARY KEY (`id_estrato_social`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estrato_social`
--

LOCK TABLES `estrato_social` WRITE;
/*!40000 ALTER TABLE `estrato_social` DISABLE KEYS */;
INSERT INTO `estrato_social` VALUES (1,'Bajo Bajo'),(2,'Bajo'),(3,'Medio Bajo'),(4,'Medio'),(5,'Medio Alto'),(6,'Alto');
/*!40000 ALTER TABLE `estrato_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `id_factura` int(11) NOT NULL,
  `numero_factura` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_facturas_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_facturas_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,555,'2015-08-08',1),(2,666,'2015-05-05',2);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas_nota_entrada`
--

DROP TABLE IF EXISTS `facturas_nota_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas_nota_entrada` (
  `d_factura` int(11) NOT NULL,
  `id_Nota` int(11) NOT NULL,
  PRIMARY KEY (`d_factura`,`id_Nota`),
  KEY `fk_facturas_has_nota_entrada_nota_entrada1_idx` (`id_Nota`),
  KEY `fk_facturas_has_nota_entrada_facturas1_idx` (`d_factura`),
  CONSTRAINT `fk_facturas_has_nota_entrada_facturas1` FOREIGN KEY (`d_factura`) REFERENCES `facturas` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_has_nota_entrada_nota_entrada1` FOREIGN KEY (`id_Nota`) REFERENCES `nota_entrada` (`id_Nota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas_nota_entrada`
--

LOCK TABLES `facturas_nota_entrada` WRITE;
/*!40000 ALTER TABLE `facturas_nota_entrada` DISABLE KEYS */;
INSERT INTO `facturas_nota_entrada` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `facturas_nota_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ficha_caracterizacion`
--

DROP TABLE IF EXISTS `ficha_caracterizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ficha_caracterizacion` (
  `id_ficha_caracterizacion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `id_programa_formacion` int(11) NOT NULL,
  `codigo_ficha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_ficha_caracterizacion`),
  KEY `fk_Ficha_caracterizacion_Programa_de_formacion1_idx` (`id_programa_formacion`),
  CONSTRAINT `fk_Ficha_caracterizacion_Programa_de_formacion1` FOREIGN KEY (`id_programa_formacion`) REFERENCES `programa_de_formacion` (`id_programa_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ficha_caracterizacion`
--

LOCK TABLES `ficha_caracterizacion` WRITE;
/*!40000 ALTER TABLE `ficha_caracterizacion` DISABLE KEYS */;
INSERT INTO `ficha_caracterizacion` VALUES (1,'2013-02-10','2015-02-10',1,'576110'),(2,'2013-02-10','2015-02-10',1,'576111');
/*!40000 ALTER TABLE `ficha_caracterizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fondo_de_pensiones`
--

DROP TABLE IF EXISTS `fondo_de_pensiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fondo_de_pensiones` (
  `id_fondo_pensiones` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_fondo_pensiones` varchar(100) NOT NULL,
  PRIMARY KEY (`id_fondo_pensiones`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fondo_de_pensiones`
--

LOCK TABLES `fondo_de_pensiones` WRITE;
/*!40000 ALTER TABLE `fondo_de_pensiones` DISABLE KEYS */;
INSERT INTO `fondo_de_pensiones` VALUES (1,'Administradora de Fondos de Pensiones y Cesantía Protección S.A.'),(2,'Sociedad Administradora de Fondos de Pensiones y Cesantías Porvenir S.A.'),(3,'Bbva Horizonte Sociedad Administradora de Fondos de Pensiones y de Cesantías S.A'),(4,'Fondos de Pensiones y Cesantía Santander S.A.'),(5,'Skandia Administradora de Fondos de Pensiones y Cesantías S.A.'),(6,'Skandia Alternativo'),(7,'Compañía Colombiana Administradora de Fondos de Pensiones y Cesantías S.A. COLFONDOS'),(8,'Instituto de Seguros Sociales I.S.S. Riesgos Profesionales'),(9,'Instituto de Seguros Sociales I.S.S. Pensiones'),(10,'Caja de Auxilios y Prestaciones de la Asociación Colombiana de Aviadores Civiles Acdac \"Caxdac\"'),(11,'Fondo de Previsión Social del Congreso de la República Fonprecon-'),(12,'Caja de Previsión Social de Comunicaciones -Caprecom-'),(13,'Pensiones de Antioquia'),(14,'Caja Nacional de Previsión Social - CAJANAL E.I.C.E'),(15,'Caja de Previsión Social de Los Trabajadores de la Universidad del Cauca'),(16,'Fondo de solidaridad pensional');
/*!40000 ALTER TABLE `fondo_de_pensiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formacion_academica`
--

DROP TABLE IF EXISTS `formacion_academica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formacion_academica` (
  `id_formacion` int(11) NOT NULL,
  `nombre_formacion` varchar(45) DEFAULT NULL,
  `soportado_formacion` tinyint(1) DEFAULT NULL,
  `id_niveles_formacion` int(11) NOT NULL,
  PRIMARY KEY (`id_formacion`),
  KEY `fk_formacion_academica_niveles_formacion1_idx` (`id_niveles_formacion`),
  CONSTRAINT `fk_formacion_academica_niveles_formacion1` FOREIGN KEY (`id_niveles_formacion`) REFERENCES `niveles_formacion` (`id_niveles_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formacion_academica`
--

LOCK TABLES `formacion_academica` WRITE;
/*!40000 ALTER TABLE `formacion_academica` DISABLE KEYS */;
/*!40000 ALTER TABLE `formacion_academica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestiones`
--

DROP TABLE IF EXISTS `gestiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gestiones` (
  `codigo_gestion` varchar(50) NOT NULL,
  `nombre_gestion` varchar(70) NOT NULL,
  PRIMARY KEY (`codigo_gestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestiones`
--

LOCK TABLES `gestiones` WRITE;
/*!40000 ALTER TABLE `gestiones` DISABLE KEYS */;
INSERT INTO `gestiones` VALUES ('C-310-704-207','pagos comisiones');
/*!40000 ALTER TABLE `gestiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_grupo` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'administrativos');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informes`
--

DROP TABLE IF EXISTS `informes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informes` (
  `id_informes` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_informe` date NOT NULL,
  `id_contrato` int(11) NOT NULL,
  `observaciones` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id_informes`),
  KEY `fk_informes_contratos1_idx` (`id_contrato`),
  CONSTRAINT `fk_informes_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informes`
--

LOCK TABLES `informes` WRITE;
/*!40000 ALTER TABLE `informes` DISABLE KEYS */;
INSERT INTO `informes` VALUES (1,'2014-02-20',1,'Contrato con retrasos'),(2,'2015-01-01',2,'Contrato en ejecucion');
/*!40000 ALTER TABLE `informes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas_de_chequeos`
--

DROP TABLE IF EXISTS `listas_de_chequeos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listas_de_chequeos` (
  `id_lista_de_chekeo` int(11) NOT NULL,
  `item_de_chequeo` varchar(45) NOT NULL,
  `descripcion_item` varchar(140) NOT NULL,
  PRIMARY KEY (`id_lista_de_chekeo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas_de_chequeos`
--

LOCK TABLES `listas_de_chequeos` WRITE;
/*!40000 ALTER TABLE `listas_de_chequeos` DISABLE KEYS */;
/*!40000 ALTER TABLE `listas_de_chequeos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiales` (
  `id_materiales` int(11) NOT NULL,
  `nombre_material` varchar(35) NOT NULL,
  `unidad_medida` varchar(25) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `tipo_material` char(1) DEFAULT NULL,
  `Descripcion_elemento` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_materiales`),
  KEY `fk_materiales_categorias1_idx` (`id_categoria`),
  CONSTRAINT `fk_materiales_categorias1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivel` (
  `id_nivel` int(11) NOT NULL,
  `minimo` int(11) DEFAULT NULL,
  `maximo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_nivel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niveles_formacion`
--

DROP TABLE IF EXISTS `niveles_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveles_formacion` (
  `id_niveles_formacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_nivel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_niveles_formacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveles_formacion`
--

LOCK TABLES `niveles_formacion` WRITE;
/*!40000 ALTER TABLE `niveles_formacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `niveles_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_entrada`
--

DROP TABLE IF EXISTS `nota_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_entrada` (
  `id_Nota` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_Nota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_entrada`
--

LOCK TABLES `nota_entrada` WRITE;
/*!40000 ALTER TABLE `nota_entrada` DISABLE KEYS */;
INSERT INTO `nota_entrada` VALUES (1,'2009-09-09 12:11:11'),(2,'2005-05-05 11:05:53');
/*!40000 ALTER TABLE `nota_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_entrada_materiales`
--

DROP TABLE IF EXISTS `nota_entrada_materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_entrada_materiales` (
  `id_Nota` int(11) NOT NULL,
  `id_material` int(11) NOT NULL,
  PRIMARY KEY (`id_Nota`,`id_material`),
  KEY `fk_NotaEntrada/Materiales_Nota_Entrada1_idx` (`id_Nota`),
  KEY `fk_NotaEntrada/Materiales_Materiales1_idx` (`id_material`),
  CONSTRAINT `fk_NotaEntrada/Materiales_Materiales1` FOREIGN KEY (`id_material`) REFERENCES `materiales` (`id_materiales`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaEntrada/Materiales_Nota_Entrada1` FOREIGN KEY (`id_Nota`) REFERENCES `nota_entrada` (`id_Nota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_entrada_materiales`
--

LOCK TABLES `nota_entrada_materiales` WRITE;
/*!40000 ALTER TABLE `nota_entrada_materiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_entrada_materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificaciones` (
  `idnotificaciones` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_contrato` int(11) DEFAULT NULL,
  `id_comision` int(10) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `texto` varchar(3000) DEFAULT NULL,
  `visto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idnotificaciones`),
  KEY `fk_notificaciones_usuarios1_idx` (`id_usuario`),
  KEY `fk_notificaciones_contratos1_idx` (`id_contrato`),
  KEY `fk_notificaciones_comisiones1_idx` (`id_comision`),
  CONSTRAINT `fk_notificaciones_comisiones1` FOREIGN KEY (`id_comision`) REFERENCES `comisiones` (`id_comision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_notificaciones_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_notificaciones_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedades`
--

DROP TABLE IF EXISTS `novedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novedades` (
  `id_novedad` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `fecha_navedad` date NOT NULL,
  `descripcion_novedad` varchar(500) NOT NULL,
  PRIMARY KEY (`id_novedad`),
  KEY `fk_novedades_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_novedades_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedades`
--

LOCK TABLES `novedades` WRITE;
/*!40000 ALTER TABLE `novedades` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedades_listas_de_chequeos`
--

DROP TABLE IF EXISTS `novedades_listas_de_chequeos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novedades_listas_de_chequeos` (
  `id_novedad` int(11) NOT NULL,
  `id_lista_de_chequeo` int(11) NOT NULL,
  `valor_item` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_novedad`,`id_lista_de_chequeo`),
  KEY `fk_novedades_has_listas_de_chekeos_listas_de_chekeos1_idx` (`id_lista_de_chequeo`),
  KEY `fk_novedades_has_listas_de_chekeos_novedades1_idx` (`id_novedad`),
  CONSTRAINT `fk_novedades_has_listas_de_chekeos_listas_de_chekeos1` FOREIGN KEY (`id_lista_de_chequeo`) REFERENCES `listas_de_chequeos` (`id_lista_de_chekeo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_novedades_has_listas_de_chekeos_novedades1` FOREIGN KEY (`id_novedad`) REFERENCES `novedades` (`id_novedad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedades_listas_de_chequeos`
--

LOCK TABLES `novedades_listas_de_chequeos` WRITE;
/*!40000 ALTER TABLE `novedades_listas_de_chequeos` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedades_listas_de_chequeos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos` (
  `id_pagos` int(11) NOT NULL,
  `valor_cuota` decimal(10,0) DEFAULT NULL,
  `horas_ejecutadas` datetime DEFAULT NULL,
  `id_contrato` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_pagos`),
  KEY `fk_pagos_contratos1_idx` (`id_contrato`),
  KEY `fk_pagos_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_pagos_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagos_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos_contratos`
--

DROP TABLE IF EXISTS `pagos_contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos_contratos` (
  `id_pago` int(11) NOT NULL AUTO_INCREMENT,
  `num_factura` int(11) NOT NULL,
  `fecha_factura` date NOT NULL,
  `val_factura` float NOT NULL,
  `fecha_de_pago` date DEFAULT NULL,
  `id_contrato` int(11) NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `fk_pagos_contratos_contratos1_idx` (`id_contrato`),
  CONSTRAINT `fk_pagos_contratos_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos_contratos`
--

LOCK TABLES `pagos_contratos` WRITE;
/*!40000 ALTER TABLE `pagos_contratos` DISABLE KEYS */;
INSERT INTO `pagos_contratos` VALUES (1,5,'2014-02-02',12000000,'2014-05-05',1),(2,6,'2014-05-20',10000000,'2014-07-20',2);
/*!40000 ALTER TABLE `pagos_contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id_pais` varchar(3) NOT NULL,
  `nombre_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES ('ABW','ARUBA'),('AFG','AFGHANISTAN'),('AGO','ANGOLA'),('AIA','ANGUILLA'),('ALB','ALBANIA'),('AND','ANDORRA'),('ANT','NETHERLANDS ANTILLES'),('ARE','UNITED ARAB EMIRATES'),('ARG','ARGENTINA'),('ARM','ARMENIA'),('ASM','AMERICAN SAMOA'),('ATA','ANTARCTICA'),('ATF','FRENCH SOUTHERN TERRITORIES'),('ATG','ANTIGUA AND BARBUDA'),('AUS','AUSTRALIA'),('AUT','AUSTRIA'),('AZE','AZERBAIJAN'),('BDI','BURUNDI'),('BEL','BELGIUM'),('BEN','BENIN'),('BFA','BURKINA FASO'),('BGD','BANGLADESH'),('BGR','BULGARIA'),('BHR','BAHRAIN'),('BHS','BAHAMAS'),('BIH','BOSNIA AND HERZEGOVINA'),('BLR','BELARUS'),('BLZ','BELIZE'),('BMU','BERMUDA'),('BOL','BOLIVIA'),('BRA','BRAZIL'),('BRB','BARBADOS'),('BRN','BRUNEI'),('BTN','BHUTAN'),('BVT','BOUVET ISLAND'),('BWA','BOTSWANA'),('CAF','CENTRAL AFRICAN REPUBLIC'),('CAN','CANADA'),('CCK','COCOS (KEELING) ISLANDS'),('CHE','SWITZERLAND'),('CHL','CHILE'),('CHN','CHINA'),('CIV','CÔTE DIVOIRE'),('CMR','CAMEROON'),('COD','CONGO'),('COG','CONGO'),('COK','COOK ISLANDS'),('COL','COLOMBIA'),('COM','COMOROS'),('CPV','CAPE VERDE'),('CRI','COSTA RICA'),('CUB','CUBA'),('CXR','CHRISTMAS ISLAND'),('CYM','CAYMAN ISLANDS'),('CYP','CYPRUS'),('CZE','CZECH REPUBLIC'),('DEU','GERMANY'),('DJI','DJIBOUTI'),('DMA','DOMINICA'),('DNK','DENMARK'),('DOM','DOMINICAN REPUBLIC'),('DZA','ALGERIA'),('ECU','ECUADOR'),('EGY','EGYPT'),('ERI','ERITREA'),('ESH','WESTERN SAHARA'),('ESP','SPAIN'),('EST','ESTONIA'),('ETH','ETHIOPIA'),('FIN','FINLAND'),('FJI','FIJI ISLANDS'),('FLK','FALKLAND ISLANDS'),('FRA','FRANCE'),('FRO','FAROE ISLANDS'),('FSM','MICRONESIA'),('GAB','GABON'),('GBR','UNITED KINGDOM'),('GEO','GEORGIA'),('GHA','GHANA'),('GIB','GIBRALTAR'),('GIN','GUINEA'),('GLP','GUADELOUPE'),('GMB','GAMBIA'),('GNB','GUINEA-BISSAU'),('GNQ','EQUATORIAL GUINEA'),('GRC','GREECE'),('GRD','GRENADA'),('GRL','GREENLAND'),('GTM','GUATEMALA'),('GUF','FRENCH GUIANA'),('GUM','GUAM'),('GUY','GUYANA'),('HKG','HONG KONG'),('HMD','HEARD ISLAND AND MCDONALD ISLANDS'),('HND','HONDURAS'),('HRV','CROATIA'),('HTI','HAITI'),('HUN','HUNGARY'),('IDN','INDONESIA'),('IND','INDIA'),('IOT','BRITISH INDIAN OCEAN TERRITORY'),('IRL','IRELAND'),('IRN','IRAN'),('IRQ','IRAQ'),('ISL','ICELAND'),('ISR','ISRAEL'),('ITA','ITALY'),('JAM','JAMAICA'),('JOR','JORDAN'),('JPN','JAPAN'),('KAZ','KAZAKSTAN'),('KEN','KENYA'),('KGZ','KYRGYZSTAN'),('KHM','CAMBODIA'),('KIR','KIRIBATI'),('KNA','SAINT KITTS AND NEVIS'),('KOR','SOUTH KOREA'),('KWT','KUWAIT'),('LAO','LAOS'),('LBN','LEBANON'),('LBR','LIBERIA'),('LBY','LIBYAN ARAB JAMAHIRIYA'),('LCA','SAINT LUCIA'),('LIE','LIECHTENSTEIN'),('LKA','SRI LANKA'),('LSO','LESOTHO'),('LTU','LITHUANIA'),('LUX','LUXEMBOURG'),('LVA','LATVIA'),('MAC','MACAO'),('MAR','MOROCCO'),('MCO','MONACO'),('MDA','MOLDOVA'),('MDG','MADAGASCAR'),('MDV','MALDIVES'),('MEX','MEXICO'),('MHL','MARSHALL ISLANDS'),('MKD','MACEDONIA'),('MLI','MALI'),('MLT','MALTA'),('MMR','MYANMAR'),('MNG','MONGOLIA'),('MNP','NORTHERN MARIANA ISLANDS'),('MOZ','MOZAMBIQUE'),('MRT','MAURITANIA'),('MSR','MONTSERRAT'),('MTQ','MARTINIQUE'),('MUS','MAURITIUS'),('MWI','MALAWI'),('MYS','MALAYSIA'),('MYT','MAYOTTE'),('NAM','NAMIBIA'),('NCL','NEW CALEDONIA'),('NER','NIGER'),('NFK','NORFOLK ISLAND'),('NGA','NIGERIA'),('NIC','NICARAGUA'),('NIU','NIUE'),('NLD','NETHERLANDS'),('NOR','NORWAY'),('NPL','NEPAL'),('NRU','NAURU'),('NZL','NEW ZEALAND'),('OMN','OMAN'),('PAK','PAKISTAN'),('PAN','PANAMA'),('PCN','PITCAIRN'),('PER','PERU'),('PHL','PHILIPPINES'),('PLW','PALAU'),('PNG','PAPUA NEW GUINEA'),('POL','POLAND'),('PRI','PUERTO RICO'),('PRK','NORTH KOREA'),('PRT','PORTUGAL'),('PRY','PARAGUAY'),('PSE','PALESTINE'),('PYF','FRENCH POLYNESIA'),('QAT','QATAR'),('REU','RÉUNION'),('ROM','ROMANIA'),('RUS','RUSSIAN FEDERATION'),('RWA','RWANDA'),('SAU','SAUDI ARABIA'),('SDN','SUDAN'),('SEN','SENEGAL'),('SGP','SINGAPORE'),('SGS','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS'),('SHN','SAINT HELENA'),('SJM','SVALBARD AND JAN MAYEN'),('SLB','SOLOMON ISLANDS'),('SLE','SIERRA LEONE'),('SLV','EL SALVADOR'),('SMR','SAN MARINO'),('SOM','SOMALIA'),('SPM','SAINT PIERRE AND MIQUELON'),('STP','SAO TOME AND PRINCIPE'),('SUR','SURINAME'),('SVK','SLOVAKIA'),('SVN','SLOVENIA'),('SWE','SWEDEN'),('SWZ','SWAZILAND'),('SYC','SEYCHELLES'),('SYR','SYRIA'),('TCA','TURKS AND CAICOS ISLANDS'),('TCD','CHAD'),('TGO','TOGO'),('THA','THAILAND'),('TJK','TAJIKISTAN'),('TKL','TOKELAU'),('TKM','TURKMENISTAN'),('TMP','EAST TIMOR'),('TON','TONGA'),('TTO','TRINIDAD AND TOBAGO'),('TUN','TUNISIA'),('TUR','TURKEY'),('TUV','TUVALU'),('TWN','TAIWAN'),('TZA','TANZANIA'),('UGA','UGANDA'),('UKR','UKRAINE'),('UMI','UNITED STATES MINOR OUTLYING ISLANDS'),('URY','URUGUAY'),('USA','UNITED STATES'),('UZB','UZBEKISTAN'),('VAT','HOLY SEE (VATICAN CITY STATE)'),('VCT','SAINT VINCENT AND THE GRENADINES'),('VEN','VENEZUELA'),('VGB','VIRGIN ISLANDS'),('VIR','VIRGIN ISLANDS'),('VNM','VIETNAM'),('VUT','VANUATU'),('WLF','WALLIS AND FUTUNA'),('WSM','SAMOA'),('YEM','YEMEN'),('YUG','YUGOSLAVIA'),('ZAF','SOUTH AFRICA'),('ZMB','ZAMBIA'),('ZWE','ZIMBABWE');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polizas`
--

DROP TABLE IF EXISTS `polizas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `polizas` (
  `numero_de_poliza` int(11) NOT NULL,
  `valor_de_poliza` int(11) NOT NULL,
  `vigencia_desde` date NOT NULL,
  `vigencia_hasta` date NOT NULL,
  `id_aseguradora` int(11) NOT NULL,
  `fecha_aprobacion` date DEFAULT NULL,
  PRIMARY KEY (`numero_de_poliza`),
  KEY `fk_Polizas_Aseguradora1_idx` (`id_aseguradora`),
  CONSTRAINT `fk_Polizas_Aseguradora1` FOREIGN KEY (`id_aseguradora`) REFERENCES `aseguradora` (`id_aseguradora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polizas`
--

LOCK TABLES `polizas` WRITE;
/*!40000 ALTER TABLE `polizas` DISABLE KEYS */;
INSERT INTO `polizas` VALUES (1,12000000,'2015-04-06','2016-04-04',1,'2015-04-06'),(2,45000000,'2015-02-02','2016-02-03',1,NULL),(33,45000000,'2015-02-02','2016-02-04',1,NULL),(34,23000000,'2015-06-01','2016-07-15',1,'2015-06-01'),(55,16000000,'2015-04-06','2016-09-05',1,'2015-04-01');
/*!40000 ALTER TABLE `polizas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuestos`
--

DROP TABLE IF EXISTS `presupuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presupuestos` (
  `id_presupuestos` int(11) NOT NULL,
  `nombre_presupuesto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_presupuestos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuestos`
--

LOCK TABLES `presupuestos` WRITE;
/*!40000 ALTER TABLE `presupuestos` DISABLE KEYS */;
INSERT INTO `presupuestos` VALUES (10,'pagos a funcionarios'),(11,'pagos a instructores');
/*!40000 ALTER TABLE `presupuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prioridades`
--

DROP TABLE IF EXISTS `prioridades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prioridades` (
  `id_prioridades` int(11) NOT NULL,
  `nombre_prioridad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_prioridades`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prioridades`
--

LOCK TABLES `prioridades` WRITE;
/*!40000 ALTER TABLE `prioridades` DISABLE KEYS */;
INSERT INTO `prioridades` VALUES (1,'Alta'),(2,'Medio'),(3,'Baja');
/*!40000 ALTER TABLE `prioridades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programa_de_formacion`
--

DROP TABLE IF EXISTS `programa_de_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programa_de_formacion` (
  `id_programa_formacion` int(11) NOT NULL,
  `nombre_programa_formacion` varchar(35) NOT NULL,
  PRIMARY KEY (`id_programa_formacion`),
  UNIQUE KEY `Nombre_programa_formacion_UNIQUE` (`nombre_programa_formacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programa_de_formacion`
--

LOCK TABLES `programa_de_formacion` WRITE;
/*!40000 ALTER TABLE `programa_de_formacion` DISABLE KEYS */;
INSERT INTO `programa_de_formacion` VALUES (1,'adsi'),(2,'matenimiento equipos');
/*!40000 ALTER TABLE `programa_de_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto_formacion`
--

DROP TABLE IF EXISTS `proyecto_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto_formacion` (
  `id_proyecto_formacion` int(11) NOT NULL,
  `nombre_proyecto_formacion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_proyecto_formacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto_formacion`
--

LOCK TABLES `proyecto_formacion` WRITE;
/*!40000 ALTER TABLE `proyecto_formacion` DISABLE KEYS */;
INSERT INTO `proyecto_formacion` VALUES (1,'proyecto UNO'),(2,'proyecto DOS');
/*!40000 ALTER TABLE `proyecto_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos_fichas`
--

DROP TABLE IF EXISTS `proyectos_fichas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyectos_fichas` (
  `id_proyecto_formacion` int(11) NOT NULL,
  `id_ficha_caracterizacion` int(11) NOT NULL,
  PRIMARY KEY (`id_proyecto_formacion`,`id_ficha_caracterizacion`),
  KEY `fk_proyectos_fichas_Proyecto_formacion1_idx` (`id_proyecto_formacion`),
  KEY `fk_proyectos_fichas_Ficha_caracterizacion1_idx` (`id_ficha_caracterizacion`),
  CONSTRAINT `fk_proyectos_fichas_Ficha_caracterizacion1` FOREIGN KEY (`id_ficha_caracterizacion`) REFERENCES `ficha_caracterizacion` (`id_ficha_caracterizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyectos_fichas_Proyecto_formacion1` FOREIGN KEY (`id_proyecto_formacion`) REFERENCES `proyecto_formacion` (`id_proyecto_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos_fichas`
--

LOCK TABLES `proyectos_fichas` WRITE;
/*!40000 ALTER TABLE `proyectos_fichas` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectos_fichas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riesgos_laborales`
--

DROP TABLE IF EXISTS `riesgos_laborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riesgos_laborales` (
  `id_riesgos_laborales` int(11) NOT NULL,
  `descripcion_riesgo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_riesgos_laborales`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riesgos_laborales`
--

LOCK TABLES `riesgos_laborales` WRITE;
/*!40000 ALTER TABLE `riesgos_laborales` DISABLE KEYS */;
/*!40000 ALTER TABLE `riesgos_laborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Contratación de prestación de servicios'),(2,'Mantenimiento'),(3,'Supervisión de contratos '),(4,'Gestión y talento humano'),(5,'Gestión documental'),(6,'Gestión de materiales de formación'),(8,'Invitado Mantenimiento'),(9,'Supervisor Mantenimiento'),(10,'GestorContractual'),(11,'InvitadoContractual');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_usuarios`
--

DROP TABLE IF EXISTS `rol_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_usuarios` (
  `id_rol` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_rol`,`id_usuario`),
  KEY `fk_Rol/Usuarios_Rol1_idx` (`id_rol`),
  KEY `fk_rol_usuarios_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_Rol/Usuarios_Rol1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_usuarios_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_usuarios`
--

LOCK TABLES `rol_usuarios` WRITE;
/*!40000 ALTER TABLE `rol_usuarios` DISABLE KEYS */;
INSERT INTO `rol_usuarios` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(2,4),(2,5),(2,10),(2,11),(3,1),(3,2),(3,3),(3,4),(4,1),(4,2),(5,1),(5,2),(6,1),(6,2),(8,4),(8,10),(9,5),(10,4),(11,3);
/*!40000 ALTER TABLE `rol_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubros`
--

DROP TABLE IF EXISTS `rubros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubros` (
  `id_rubro` varchar(45) NOT NULL,
  `rubro` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rubro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubros`
--

LOCK TABLES `rubros` WRITE;
/*!40000 ALTER TABLE `rubros` DISABLE KEYS */;
INSERT INTO `rubros` VALUES ('2041104','Administrativos');
/*!40000 ALTER TABLE `rubros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexo` (
  `id_sexo` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre_sexo` varchar(15) NOT NULL,
  PRIMARY KEY (`id_sexo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Femenino'),(2,'Masculino');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_materiales_almacen`
--

DROP TABLE IF EXISTS `solicitud_materiales_almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud_materiales_almacen` (
  `id_solicitud_material` int(11) NOT NULL AUTO_INCREMENT,
  `id_ficha_caracterizacion` int(11) NOT NULL,
  `id_area` int(11) NOT NULL,
  `fecha_de_solicitud` datetime NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `aprobado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_solicitud_material`),
  KEY `fk_Solicitud_materiales_almacen_Ficha_caracterizacion1_idx` (`id_ficha_caracterizacion`),
  KEY `fk_Solicitud_materiales_almacen_areas1_idx` (`id_area`),
  CONSTRAINT `fk_Solicitud_materiales_almacen_Ficha_caracterizacion1` FOREIGN KEY (`id_ficha_caracterizacion`) REFERENCES `ficha_caracterizacion` (`id_ficha_caracterizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_materiales_almacen_areas1` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_materiales_almacen`
--

LOCK TABLES `solicitud_materiales_almacen` WRITE;
/*!40000 ALTER TABLE `solicitud_materiales_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud_materiales_almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_materiales_almacen_materiales`
--

DROP TABLE IF EXISTS `solicitud_materiales_almacen_materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud_materiales_almacen_materiales` (
  `id_solicitud_material` int(11) NOT NULL AUTO_INCREMENT,
  `id_materiales` int(11) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `aprobado` tinyint(1) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_solicitud_material`,`id_materiales`),
  KEY `fk_Solicitud_materiales_almacen_has_materiales_materiales1_idx` (`id_materiales`),
  KEY `fk_Solicitud_materiales_almacen_has_materiales_Solicitud_ma_idx` (`id_solicitud_material`),
  CONSTRAINT `fk_Solicitud_materiales_almacen_has_materiales_Solicitud_mate1` FOREIGN KEY (`id_solicitud_material`) REFERENCES `solicitud_materiales_almacen` (`id_solicitud_material`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_materiales_almacen_has_materiales_materiales1` FOREIGN KEY (`id_materiales`) REFERENCES `materiales` (`id_materiales`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_materiales_almacen_materiales`
--

LOCK TABLES `solicitud_materiales_almacen_materiales` WRITE;
/*!40000 ALTER TABLE `solicitud_materiales_almacen_materiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud_materiales_almacen_materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_servicios`
--

DROP TABLE IF EXISTS `solicitud_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud_servicios` (
  `id_solicitud_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_servicio_Solicitud` varchar(500) NOT NULL,
  `ubicacion_solicitud` varchar(40) DEFAULT NULL,
  `fecha_solicitud_servicio` datetime NOT NULL,
  `id_tipo_serv` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_solicitud_servicio`),
  UNIQUE KEY `id_solicitud_servicio_UNIQUE` (`id_solicitud_servicio`),
  KEY `fk_solicitud_servicios_tipo_de_servicios1_idx` (`id_tipo_serv`),
  KEY `fk_solicitud_servicios_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_solicitud_servicios_tipo_de_servicios1` FOREIGN KEY (`id_tipo_serv`) REFERENCES `tipo_de_servicios` (`id_tipo_serv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_servicios_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_servicios`
--

LOCK TABLES `solicitud_servicios` WRITE;
/*!40000 ALTER TABLE `solicitud_servicios` DISABLE KEYS */;
INSERT INTO `solicitud_servicios` VALUES (1,'Daño en los lava manos','Baños','2015-02-06 07:55:00',3,1),(2,'Cristal Roto','Aula','2015-02-06 08:11:00',3,2),(3,'el aire acondicionado de la oficina de jovenes rurales emprendedores se encuentra en mal estado','Oficina de jovenes rurales emprendedores','2015-09-09 08:05:11',3,3),(4,'problemas con baterias sanitarias en oficina de gestion documental','oficina de gestion documental','2015-09-09 08:09:02',NULL,4),(5,'problemas con lampara en coordinacion academica','coordinacion academica','2015-09-09 08:11:08',NULL,5),(6,'tuberia rota ','cancha cbi','2015-09-09 08:59:10',3,11),(7,'inconveniente con lampara en el ambiente de formacion 109','ambiente de formacion 109','2015-09-09 09:07:08',NULL,4),(8,'problemas con aire acondicionado','aula 115','2015-09-15 16:17:56',NULL,4),(9,'daño eléctrico','aula 201','2015-09-18 11:28:06',NULL,11),(10,'problema con tuberia en el baño','Coordinacion academica','2015-09-23 08:09:32',NULL,5);
/*!40000 ALTER TABLE `solicitud_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soportes_de_documentos`
--

DROP TABLE IF EXISTS `soportes_de_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soportes_de_documentos` (
  `id_soporte` int(11) NOT NULL AUTO_INCREMENT,
  `url_documento` varchar(500) DEFAULT NULL,
  `id_contrato` int(11) NOT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `destino_archivo` blob,
  `tipo_soporte` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_soporte`),
  KEY `fk_soportes_de_documentos_contratos1_idx` (`id_contrato`),
  CONSTRAINT `fk_soportes_de_documentos_contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soportes_de_documentos`
--

LOCK TABLES `soportes_de_documentos` WRITE;
/*!40000 ALTER TABLE `soportes_de_documentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `soportes_de_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifas`
--

DROP TABLE IF EXISTS `tarifas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarifas` (
  `id_tarifa` int(3) NOT NULL,
  `nombre_tarifa` varchar(5) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_dpto` int(11) NOT NULL,
  PRIMARY KEY (`id_tarifa`),
  KEY `fk_tarifas_ciudad1_idx` (`id_ciudad`,`id_dpto`),
  CONSTRAINT `fk_tarifas_ciudad1` FOREIGN KEY (`id_ciudad`, `id_dpto`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifas`
--

LOCK TABLES `tarifas` WRITE;
/*!40000 ALTER TABLE `tarifas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarifas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_contrato`
--

DROP TABLE IF EXISTS `tipo_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_contrato` (
  `id_tipo_contrato` tinyint(4) NOT NULL AUTO_INCREMENT,
  `nombre_contrato` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_contrato`
--

LOCK TABLES `tipo_contrato` WRITE;
/*!40000 ALTER TABLE `tipo_contrato` DISABLE KEYS */;
INSERT INTO `tipo_contrato` VALUES (1,'Carrera Administrativa'),(2,'Contratista');
/*!40000 ALTER TABLE `tipo_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_de_contrato`
--

DROP TABLE IF EXISTS `tipo_de_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_de_contrato` (
  `id_tipo_contrato` int(11) NOT NULL,
  `nombre_tipo_contrato` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_contrato`
--

LOCK TABLES `tipo_de_contrato` WRITE;
/*!40000 ALTER TABLE `tipo_de_contrato` DISABLE KEYS */;
INSERT INTO `tipo_de_contrato` VALUES (1,'Compraventa'),(2,'Suministros');
/*!40000 ALTER TABLE `tipo_de_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_de_servicios`
--

DROP TABLE IF EXISTS `tipo_de_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_de_servicios` (
  `id_tipo_serv` int(11) NOT NULL,
  `nombre_Servicio` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_serv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_servicios`
--

LOCK TABLES `tipo_de_servicios` WRITE;
/*!40000 ALTER TABLE `tipo_de_servicios` DISABLE KEYS */;
INSERT INTO `tipo_de_servicios` VALUES (1,'Preventivo'),(2,'Predictivo'),(3,'Correctivo');
/*!40000 ALTER TABLE `tipo_de_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documentos`
--

DROP TABLE IF EXISTS `tipo_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documentos` (
  `id_tipo_doc` varchar(4) NOT NULL,
  `nombre_tipo_doc` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documentos`
--

LOCK TABLES `tipo_documentos` WRITE;
/*!40000 ALTER TABLE `tipo_documentos` DISABLE KEYS */;
INSERT INTO `tipo_documentos` VALUES ('CC','Cédula de Ciudadanía'),('CE','Cédula de Extranjería'),('PAS','Pasaporte'),('TI','Tarjeta de Identidad');
/*!40000 ALTER TABLE `tipo_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `idtipo_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Registra'),(2,'Responsable');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_de_solicitudes`
--

DROP TABLE IF EXISTS `tipos_de_solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_de_solicitudes` (
  `id_tipo_solicitud` int(11) NOT NULL,
  `nombre_tipo_solicitud` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_solicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_de_solicitudes`
--

LOCK TABLES `tipos_de_solicitudes` WRITE;
/*!40000 ALTER TABLE `tipos_de_solicitudes` DISABLE KEYS */;
INSERT INTO `tipos_de_solicitudes` VALUES (1,'Inicial'),(2,'Adicion');
/*!40000 ALTER TABLE `tipos_de_solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_documento_gd`
--

DROP TABLE IF EXISTS `tipos_documento_gd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_documento_gd` (
  `idtipos_documento_gd` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_documento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipos_documento_gd`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_documento_gd`
--

LOCK TABLES `tipos_documento_gd` WRITE;
/*!40000 ALTER TABLE `tipos_documento_gd` DISABLE KEYS */;
INSERT INTO `tipos_documento_gd` VALUES (1,'acta'),(2,'acuerdo'),(3,'carta'),(4,'cicular'),(5,'contrato'),(6,'convenio'),(7,'lista de asistencia'),(8,'resolucion'),(9,'norma gestion documental'),(10,'norma pqrsf');
/*!40000 ALTER TABLE `tipos_documento_gd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_pasajes`
--

DROP TABLE IF EXISTS `tipos_pasajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_pasajes` (
  `id_tipo_pasaje` int(11) NOT NULL,
  `nombre_tipo_pasaje` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_pasaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_pasajes`
--

LOCK TABLES `tipos_pasajes` WRITE;
/*!40000 ALTER TABLE `tipos_pasajes` DISABLE KEYS */;
INSERT INTO `tipos_pasajes` VALUES (1,'Aereo'),(2,'Terrestre');
/*!40000 ALTER TABLE `tipos_pasajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_formacion_academica`
--

DROP TABLE IF EXISTS `usuario_formacion_academica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_formacion_academica` (
  `id_usuario` int(11) NOT NULL,
  `id_formacion` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_formacion`),
  KEY `fk_Usuarios_has_formacion academica_formacion academica1_idx` (`id_formacion`),
  KEY `fk_Usuarios_has_formacion academica_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_Usuarios_has_formacion academica_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_formacion academica_formacion academica1` FOREIGN KEY (`id_formacion`) REFERENCES `formacion_academica` (`id_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_formacion_academica`
--

LOCK TABLES `usuario_formacion_academica` WRITE;
/*!40000 ALTER TABLE `usuario_formacion_academica` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_formacion_academica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `usuario_roles`
--

DROP TABLE IF EXISTS `usuario_roles`;
/*!50001 DROP VIEW IF EXISTS `usuario_roles`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `usuario_roles` AS SELECT 
 1 AS `numero_documento`,
 1 AS `password`,
 1 AS `rol`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `numero_doc` varchar(15) NOT NULL,
  `id_tipo_doc` varchar(4) NOT NULL,
  `fecha_expedicion_doc` date DEFAULT NULL,
  `id_ciudad_exp_doc` int(11) DEFAULT NULL,
  `id_dpto_exp_doc` int(11) DEFAULT NULL,
  `razon_social` varchar(20) DEFAULT NULL,
  `primer_nombre` varchar(20) NOT NULL,
  `segundo_nombre` varchar(20) DEFAULT NULL,
  `primer_apellido` varchar(20) NOT NULL,
  `segundo_apellido` varchar(20) DEFAULT NULL,
  `nombre_repre_legal` varchar(45) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `telefono_principal_usu` varchar(15) NOT NULL,
  `telefono_alterno_usu` varchar(15) DEFAULT NULL,
  `direccion_usu` varchar(80) NOT NULL,
  `id_ciudad_residencia` int(11) NOT NULL,
  `id_dpto_residencia` int(11) NOT NULL,
  `password` varchar(64) NOT NULL,
  `gp_rh` varchar(3) DEFAULT NULL,
  `id_centro_formacion` int(11) DEFAULT NULL,
  `id_arl` smallint(6) DEFAULT NULL,
  `id_eps` smallint(6) DEFAULT NULL,
  `id_fondo_pensiones` smallint(6) DEFAULT NULL,
  `id_ccf` smallint(6) DEFAULT NULL,
  `id_sexo` smallint(6) DEFAULT NULL,
  `id_estado_civil` smallint(6) DEFAULT NULL,
  `id_estrato_social` smallint(6) DEFAULT NULL,
  `calificacion` varchar(10) DEFAULT NULL,
  `fecha_de_creacion` datetime DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  `num_cuenta_banco` varchar(30) DEFAULT NULL,
  `nombre_tipo_cuenta` varchar(45) DEFAULT NULL,
  `id_banco` int(11) DEFAULT NULL,
  `id_tipo_contrato` tinyint(4) DEFAULT NULL,
  `grado` int(100) DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `numero_de_cedula_UNIQUE` (`numero_doc`),
  KEY `fk_Usuarios_centro_formacion1_idx` (`id_centro_formacion`),
  KEY `fk_Usuarios_ciudad1_idx` (`id_ciudad_residencia`,`id_dpto_residencia`),
  KEY `fk_Usuarios_ciudad2_idx` (`id_ciudad_exp_doc`,`id_dpto_exp_doc`),
  KEY `fk_Usuarios_arl1_idx` (`id_arl`),
  KEY `fk_Usuarios_eps1_idx` (`id_eps`),
  KEY `fk_Usuarios_fondo_de_pensiones1_idx` (`id_fondo_pensiones`),
  KEY `fk_Usuarios_ccf1_idx` (`id_ccf`),
  KEY `fk_Usuarios_sexo1_idx` (`id_sexo`),
  KEY `fk_Usuarios_estado_civil1_idx` (`id_estado_civil`),
  KEY `fk_Usuarios_estrato_social1_idx` (`id_estrato_social`),
  KEY `fk_Usuarios_tipo_documentos1_idx` (`id_tipo_doc`),
  KEY `fk_usuarios_bancos1_idx` (`id_banco`),
  KEY `fk_usuarios_tipo_contrato1_idx` (`id_tipo_contrato`),
  CONSTRAINT `fk_Usuarios_arl1` FOREIGN KEY (`id_arl`) REFERENCES `arl` (`id_arl`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_ccf1` FOREIGN KEY (`id_ccf`) REFERENCES `ccf` (`id_ccf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_centro_formacion1` FOREIGN KEY (`id_centro_formacion`) REFERENCES `centro_formacion` (`id_centro_formacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_ciudad1` FOREIGN KEY (`id_ciudad_residencia`, `id_dpto_residencia`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_ciudad2` FOREIGN KEY (`id_ciudad_exp_doc`, `id_dpto_exp_doc`) REFERENCES `ciudad` (`id_ciudad`, `id_dpto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_eps1` FOREIGN KEY (`id_eps`) REFERENCES `eps` (`id_eps`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_estado_civil1` FOREIGN KEY (`id_estado_civil`) REFERENCES `estado_civil` (`id_estado_civil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_estrato_social1` FOREIGN KEY (`id_estrato_social`) REFERENCES `estrato_social` (`id_estrato_social`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_fondo_de_pensiones1` FOREIGN KEY (`id_fondo_pensiones`) REFERENCES `fondo_de_pensiones` (`id_fondo_pensiones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_sexo1` FOREIGN KEY (`id_sexo`) REFERENCES `sexo` (`id_sexo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_tipo_documentos1` FOREIGN KEY (`id_tipo_doc`) REFERENCES `tipo_documentos` (`id_tipo_doc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_bancos1` FOREIGN KEY (`id_banco`) REFERENCES `bancos` (`id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_tipo_contrato1` FOREIGN KEY (`id_tipo_contrato`) REFERENCES `tipo_contrato` (`id_tipo_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'1113666977','CC','2014-01-01',1,5,'Franky   ltda','Franky','','Romero','Mazuera',NULL,'1995-11-23','fromero779@misena.edu.co','2649785','316852003','Calle 12 20 30',1,5,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','O+',9101,1,1,1,1,2,1,3,NULL,'2015-02-04 08:55:00',1,NULL,NULL,NULL,1,11,700000,'2015-02-02'),(2,'1114894727','CC','2014-01-01',1,5,'Geovany sas','Geovany','Andres','Caicedo','Martinez',NULL,'1995-11-23','fromero779@misena.edu.co','4323456','3168687215','Calle 12 20 30',1,5,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','o-',9101,2,2,2,2,2,2,2,NULL,'2015-02-04 08:55:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'1113653101','CC',NULL,520,76,'Jose','Jose','','Maldonado','',NULL,NULL,'jemaldonado1@outlook.com','3155893640','','calle 39 1 b 16',520,76,'985b0dff711672505d598f0334e7afdee56583e959dc26844c51703e6f933f8c',NULL,9544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-08-28 09:17:30',1,NULL,NULL,NULL,1,NULL,NULL,NULL),(4,'1234','CC',NULL,1,76,NULL,'Invitado','','Mantenimiento','',NULL,NULL,'example@outlook.com','3155893640','','Carrera 30 40 25',1,76,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',NULL,9544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-08-28 09:28:22',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'0000','CC',NULL,1,76,NULL,'Supervisor','','Mantenimiento','',NULL,NULL,'example@outlook.com','3155893640','','Carrera 30 cll 40 25',1,76,'9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0',NULL,9544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-08-28 09:30:07',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'31152863','CC',NULL,1,76,NULL,'Beatriz','','Cardona','',NULL,NULL,'jemaldonado1@outlook.com','3155893640','','calle 39 1 b 16',1,76,'aeeb1c9e57bbe3064c2f90729ebe7f56e5eb3b548618c21be39c6aa2cb20d12e',NULL,9544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-09-01 10:03:26',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'12345','CC',NULL,1,76,NULL,'Encargado','','Mantenimiento','',NULL,NULL,'example@outlook.com','3151234590','','calle 30 calle 40 12',520,76,'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',NULL,9544,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-09-09 08:38:37',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'2345678','CC',NULL,1,76,NULL,'ok',NULL,'ok',NULL,NULL,'2015-09-01','asasd@sdfasdfa.com','1234567890',NULL,'cdd',1,13,'0c08a9536b5dd78713f440acb930872fd69f7a71ad0cf9cdedc9628ddf9ac3d7',NULL,9032,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-09-30 10:35:37',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_cargo`
--

DROP TABLE IF EXISTS `usuarios_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_cargo` (
  `id_usuario` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_cargo`),
  KEY `fk_usuarios_has_cargo_cargo1_idx` (`id_cargo`),
  KEY `fk_usuarios_has_cargo_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_usuarios_has_cargo_cargo1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_cargo_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_cargo`
--

LOCK TABLES `usuarios_cargo` WRITE;
/*!40000 ALTER TABLE `usuarios_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_contratos`
--

DROP TABLE IF EXISTS `usuarios_contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_contratos` (
  `id_contrato` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `numero_de_poliza` int(11) NOT NULL,
  `fecha_sesion` datetime DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`,`id_usuario`,`id_rol`,`numero_de_poliza`),
  KEY `fk_Usuarios_has_Contratos_Contratos1_idx` (`id_contrato`),
  KEY `fk_usuarios_contratos_Usuarios1_idx` (`id_usuario`),
  KEY `fk_usuarios_contratos_rol1_idx` (`id_rol`),
  KEY `fk_usuarios_contratos_polizas1_idx` (`numero_de_poliza`),
  CONSTRAINT `fk_Usuarios_has_Contratos_Contratos1` FOREIGN KEY (`id_contrato`) REFERENCES `contratos` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_contratos_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_contratos_polizas1` FOREIGN KEY (`numero_de_poliza`) REFERENCES `polizas` (`numero_de_poliza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_contratos_rol1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='<double-click to overwrite multiple objects>';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_contratos`
--

LOCK TABLES `usuarios_contratos` WRITE;
/*!40000 ALTER TABLE `usuarios_contratos` DISABLE KEYS */;
INSERT INTO `usuarios_contratos` VALUES (3,3,1,1,NULL,NULL),(4,2,1,34,NULL,NULL),(5,2,1,2,NULL,NULL),(7,1,1,33,NULL,NULL);
/*!40000 ALTER TABLE `usuarios_contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_ficha_caracterizacion`
--

DROP TABLE IF EXISTS `usuarios_ficha_caracterizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_ficha_caracterizacion` (
  `id_usuario` int(11) NOT NULL,
  `id_ficha_caracterizacion` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_ficha_caracterizacion`),
  KEY `fk_Usuarios_has_ficha_caracterizacion_ficha_caracterizacion_idx` (`id_ficha_caracterizacion`),
  KEY `fk_Usuarios_has_ficha_caracterizacion_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_Usuarios_has_ficha_caracterizacion_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_ficha_caracterizacion_ficha_caracterizacion1` FOREIGN KEY (`id_ficha_caracterizacion`) REFERENCES `ficha_caracterizacion` (`id_ficha_caracterizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_ficha_caracterizacion`
--

LOCK TABLES `usuarios_ficha_caracterizacion` WRITE;
/*!40000 ALTER TABLE `usuarios_ficha_caracterizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_ficha_caracterizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_riesgos_laborales`
--

DROP TABLE IF EXISTS `usuarios_riesgos_laborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_riesgos_laborales` (
  `id_usuario` int(11) NOT NULL,
  `id_riesgos_laborales` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_riesgos_laborales`),
  KEY `fk_Usuarios_has_riesgos_laborales_riesgos_laborales1_idx` (`id_riesgos_laborales`),
  KEY `fk_Usuarios_has_riesgos_laborales_Usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_Usuarios_has_riesgos_laborales_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_riesgos_laborales_riesgos_laborales1` FOREIGN KEY (`id_riesgos_laborales`) REFERENCES `riesgos_laborales` (`id_riesgos_laborales`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_riesgos_laborales`
--

LOCK TABLES `usuarios_riesgos_laborales` WRITE;
/*!40000 ALTER TABLE `usuarios_riesgos_laborales` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_riesgos_laborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_solicitud_materiales_almacen`
--

DROP TABLE IF EXISTS `usuarios_solicitud_materiales_almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_solicitud_materiales_almacen` (
  `id_usuario` int(11) NOT NULL,
  `id_solicitud_material` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_solicitud_material`,`id_rol`),
  KEY `fk_Usuarios_has_Solicitud_materiales_almacen_Solicitud_mate_idx` (`id_solicitud_material`),
  KEY `fk_Usuarios_has_Solicitud_materiales_almacen_Usuarios1_idx` (`id_usuario`),
  KEY `fk_Usuarios_Solicitud_materiales_almacen_rol1_idx` (`id_rol`),
  CONSTRAINT `fk_Usuarios_Solicitud_materiales_almacen_rol1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_Solicitud_materiales_almacen_Solicitud_materi1` FOREIGN KEY (`id_solicitud_material`) REFERENCES `solicitud_materiales_almacen` (`id_solicitud_material`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_has_Solicitud_materiales_almacen_Usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_solicitud_materiales_almacen`
--

LOCK TABLES `usuarios_solicitud_materiales_almacen` WRITE;
/*!40000 ALTER TABLE `usuarios_solicitud_materiales_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_solicitud_materiales_almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valor_gasto`
--

DROP TABLE IF EXISTS `valor_gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valor_gasto` (
  `id_valor_gasto` int(11) NOT NULL AUTO_INCREMENT,
  `valor_gastos` varchar(45) DEFAULT NULL,
  `id_nivel` int(11) NOT NULL,
  `id_tarifa` int(3) NOT NULL,
  PRIMARY KEY (`id_valor_gasto`),
  KEY `fk_valor_gasto_nivel1_idx` (`id_nivel`),
  KEY `fk_valor_gasto_tarifas1_idx` (`id_tarifa`),
  CONSTRAINT `fk_valor_gasto_nivel1` FOREIGN KEY (`id_nivel`) REFERENCES `nivel` (`id_nivel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_valor_gasto_tarifas1` FOREIGN KEY (`id_tarifa`) REFERENCES `tarifas` (`id_tarifa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valor_gasto`
--

LOCK TABLES `valor_gasto` WRITE;
/*!40000 ALTER TABLE `valor_gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `valor_gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sami_prueba'
--

--
-- Dumping routines for database 'sami_prueba'
--

--
-- Final view structure for view `usuario_roles`
--

/*!50001 DROP VIEW IF EXISTS `usuario_roles`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `usuario_roles` AS select `usuarios`.`numero_doc` AS `numero_documento`,`usuarios`.`password` AS `password`,`rol`.`id_rol` AS `rol` from ((`usuarios` join `rol`) join `rol_usuarios`) where ((`usuarios`.`id_usuario` = `rol_usuarios`.`id_usuario`) and (`rol`.`id_rol` = `rol_usuarios`.`id_rol`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-06 10:45:09
