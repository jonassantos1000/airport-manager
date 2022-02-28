create database airport;
use airport;

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `horario_chegada` datetime(6) DEFAULT NULL,
  `horario_saida` datetime(6) DEFAULT NULL,
  `preço_passagem` double DEFAULT NULL,
  `qtde_assento_total` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `assento` int DEFAULT NULL,
  `data_compra` datetime(6) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `flight_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2rjr6m31hp7m00tm1hdxckov` (`client_id`),
  KEY `FKfju27cbcbl1w16qeora1r636q` (`flight_id`),
  CONSTRAINT `FKfju27cbcbl1w16qeora1r636q` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FKj2rjr6m31hp7m00tm1hdxckov` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

