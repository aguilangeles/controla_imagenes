CREATE DATABASE  IF NOT EXISTS `qualitys` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `qualitys`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: qualitys
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `tipos_documentos`
--

DROP TABLE IF EXISTS `tipos_documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_documentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_documentos`
--

LOCK TABLES `tipos_documentos` WRITE;
/*!40000 ALTER TABLE `tipos_documentos` DISABLE KEYS */;
insert into tipos_documentos values(1,'Recibo'),(2,'Boletas'),(3,'Ejercicio'),(4,'Sumaria');
/*!40000 ALTER TABLE `tipos_documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rangos_qs`
--

DROP TABLE IF EXISTS `rangos_qs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rangos_qs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `minimo` int(11) NOT NULL,
  `maximo` int(11) NOT NULL,
  `muestra` int(11) NOT NULL,
  `cant_rechazo` int(11) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT '0',
  -- `activo` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rangos_qs`
--

LOCK TABLES `rangos_qs` WRITE;
/*!40000 ALTER TABLE `rangos_qs` DISABLE KEYS */;
INSERT INTO `rangos_qs` VALUES (1,1,100,3,1,1),(2,101,1000,4,2,1),(3,1001,5000,5,3,1);
/*!40000 ALTER TABLE `rangos_qs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traza_archivo_controles`
--

DROP TABLE IF EXISTS `traza_archivo_controles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traza_archivo_controles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idtraza` int(11) NOT NULL,
  `idarchivo` int(11) NOT NULL,
  `idcontrol` int(11) NOT NULL,
  `estado` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_traza_archcontr_archivo` (`idarchivo`),
  KEY `fk_traza_archcontr_controles` (`idcontrol`),
  CONSTRAINT `fk_traza_archcontr_archivo` FOREIGN KEY (`idarchivo`) REFERENCES `archivo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_traza_archcontr_controles` FOREIGN KEY (`idcontrol`) REFERENCES `controles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traza_archivo_controles`
--

LOCK TABLES `traza_archivo_controles` WRITE;
/*!40000 ALTER TABLE `traza_archivo_controles` DISABLE KEYS */;
/*!40000 ALTER TABLE `traza_archivo_controles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_verificacion`
--

DROP TABLE IF EXISTS `tipos_verificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_verificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  -- `activo` int(1) NOT NULL DEFAULT '0',
  `estado` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_verificacion`
--

LOCK TABLES `tipos_verificacion` WRITE;
/*!40000 ALTER TABLE `tipos_verificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_verificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_usuarios`
--

DROP TABLE IF EXISTS `tipos_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_usuarios`
--

LOCK TABLES `tipos_usuarios` WRITE;
/*!40000 ALTER TABLE `tipos_usuarios` DISABLE KEYS */;
INSERT INTO `tipos_usuarios` VALUES (1,'admin'),(2,'carga');
/*!40000 ALTER TABLE `tipos_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traza`
--

DROP TABLE IF EXISTS `traza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_control` datetime NOT NULL,
  `tamanio_lote` int(11) NOT NULL,
  `cantidad_muestreada` int(11) NOT NULL,
  `nro_rechazo` int(11) NOT NULL,
  `linea_captura` varchar(45) DEFAULT NULL,
  `digitalizador` varchar(45) DEFAULT NULL,
  `idRango` int(11) NOT NULL,
  `estadoLote` int(1) DEFAULT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `idVerificacion` int(11) NOT NULL,
  `idUsuarios` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_traza_rango` (`idRango`),
  KEY `fk_traza_verificacion` (`idVerificacion`),
  CONSTRAINT `fk_traza_verificacion` FOREIGN KEY (`idVerificacion`) REFERENCES `tipos_verificacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_traza_rango` FOREIGN KEY (`idRango`) REFERENCES `rangos_qs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traza`
--

LOCK TABLES `traza` WRITE;
/*!40000 ALTER TABLE `traza` DISABLE KEYS */;
-- agrego tipo de documento

ALTER TABLE `qualitys`.`traza` ADD COLUMN `idTipoDocumento` INT(11) NOT NULL  AFTER `idUsuarios` , 

  ADD CONSTRAINT `fk_tipo_documento`

  FOREIGN KEY (`idTipoDocumento` )

  REFERENCES `qualitys`.`tipos_documentos` (`id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION

, ADD INDEX `fk_tipo_documento` (`idTipoDocumento` ASC) ;


/*!40000 ALTER TABLE `traza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archivo`
--

DROP TABLE IF EXISTS `archivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idTraza` int(11) NOT NULL,
  `ruta_archivo` varchar(200) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_archivo_traza` (`idTraza`),
  CONSTRAINT `fk_archivo_traza` FOREIGN KEY (`idTraza`) REFERENCES `traza` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo`
--

LOCK TABLES `archivo` WRITE;
/*!40000 ALTER TABLE `archivo` DISABLE KEYS */;
ALTER TABLE `qualitys`.`archivo` ADD COLUMN `pagina_pdf` INT(11)   AFTER `estado` ;
ALTER TABLE `qualitys`.`archivo` CHANGE COLUMN `pagina_pdf` `pagina_pdf` INT(11)   AFTER `ruta_archivo` ;
/*!40000 ALTER TABLE `archivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tipo` int(1) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT '0',
   -- `activo` int(1) NOT NULL DEFAULT '0',
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuarios_tipos_usuarios` (`tipo`),
  CONSTRAINT `fk_usuarios_tipos_usuarios` FOREIGN KEY (`tipo`) REFERENCES `tipos_usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin',1,1,'0000-00-00 00:00:00'),(2,'carga','carga',2,1,'0000-00-00 00:00:00')
-- ,(3,'ss','ss',1,1,'0000-00-00 00:00:00')
;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controles_verificacion`
--

DROP TABLE IF EXISTS `controles_verificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controles_verificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idVerificacion` int(11) NOT NULL,
  `idControl` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ctrlVerif_tipoVerif` (`idVerificacion`),
  KEY `fk_ctrlVerif_Controles` (`idControl`),
  CONSTRAINT `fk_ctrlVerif_tipoVerif` FOREIGN KEY (`idVerificacion`) REFERENCES `tipos_verificacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ctrlVerif_Controles` FOREIGN KEY (`idControl`) REFERENCES `controles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controles_verificacion`
--

LOCK TABLES `controles_verificacion` WRITE;
/*!40000 ALTER TABLE `controles_verificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `controles_verificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controles`
--

DROP TABLE IF EXISTS `controles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `texto` varchar(500) NOT NULL,
  `imagen` varchar(200) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT '0',
  -- `activo` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controles`
--

LOCK TABLES `controles` WRITE;
/*!40000 ALTER TABLE `controles` DISABLE KEYS */;
INSERT INTO `controles` VALUES 
(1,'Imágenes torcidas','Estas imágenes tienen un pequeño torcimiento que hace que aparezcan bordes negros en 3 o 4 lados de la imagen.\nDistinguir de la digitalización de fotocopias que ya cuentan con ese problema.','torcida.tif',1)
,(2,'Imágenes con bordes Negros','Estas imágenes tienen bordes negros ya sea a ambos lados de la imagen o bien por arriba y por debajo.\nDistinguir de la digitalización de fotocopias que ya cuentan con ese problema.','bordesNegros.tif',1)
,(3,'Imágenes en blanco','Estas imágenes no contienen ningún tipo de información y por lo tanto deben ser eliminadas.\nSi hay un sello, una firma, un número, etc. no se considerarán como error.','blancas.tif',1)
,(4,'Imágenes con mal contraste','Estas imágenes son ilegibles, ya sea por mucho contraste (oscuras), o poco contraste (muy claras).','malContraste.tif',1),(5,'Imágenes mal rotadas','Estas imágenes están con la orientación equivocada, sea que están de costados o vueltas hacia arriba.','malRotada.tif',1)
,(6,'Imágenes de alimentación múltiple','Estas imágenes reflejan que paso más de un papel al mismo tiempo por el scanner, superponiendose y por la tanto perdiendo información.','alimMultiple.tif',1)
,(7,'Imágenes con esquinas dobladas','Estas imágenes reflejan que la hoja se encontraba doblada sobre si misma, superponiendose y por la tanto perdiendo información.','esqDoblada.tif',1);
/*!40000 ALTER TABLE `controles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'qualitys'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-29 10:35:25
