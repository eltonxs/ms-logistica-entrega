-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: logistica_entrega
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `entrega`
--

DROP TABLE IF EXISTS `entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrega` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep_destino` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `data_atualizacao` datetime(6) NOT NULL,
  `data_criacao` datetime(6) DEFAULT NULL,
  `entregador_id` bigint DEFAULT NULL,
  `estado` varchar(2) NOT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(20) NOT NULL,
  `pedido_id` bigint DEFAULT NULL,
  `status` enum('CANCELADA','EM_TRANSITO','ENTREGUE','PENDENTE') DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrega`
--

LOCK TABLES `entrega` WRITE;
/*!40000 ALTER TABLE `entrega` DISABLE KEYS */;
INSERT INTO `entrega` VALUES (1,'Centro','01001-000','S├úo Paulo','2024-11-13 00:29:41.461216','2024-11-12 16:44:55.713295',1,'SP','Rua Exemplo','123',1,'PENDENTE',-23.5505,-46.6333),(2,'Vila bancaria','03922-150','S├úo Paulo','2024-11-12 10:30:00.000000','2024-11-12 16:45:27.734171',1,'SP','Rua teste','220',1,'PENDENTE',NULL,NULL),(3,'Vila bancaria','03918-090','S├úo Paulo','2024-11-12 10:30:00.000000','2024-11-12 16:46:18.161552',2,'SP','Rua super','12',2,'PENDENTE',NULL,NULL),(4,'Vila guarani','03918-088','S├úo Paulo','2024-11-12 10:30:00.000000','2024-11-13 00:05:48.461594',3,'SP','Rua super nova','05',3,'PENDENTE',NULL,NULL);
/*!40000 ALTER TABLE `entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregador`
--

DROP TABLE IF EXISTS `entregador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entregador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `veiculo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregador`
--

LOCK TABLES `entregador` WRITE;
/*!40000 ALTER TABLE `entregador` DISABLE KEYS */;
INSERT INTO `entregador` VALUES (1,'12345678970','Entregador Vapo ','(11)980808070','Van'),(2,'12345678910','Motoqueiro Fantasma ','(11)980808010','Moto'),(3,'12345678911','Entregador Joao ','(11)980808011','Moto'),(7,'12345678988','Entregador Joao ','(11)980808088','Moto');
/*!40000 ALTER TABLE `entregador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29 18:18:18
