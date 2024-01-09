DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `preco` decimal(39) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO produtos (id, nome, codigo, descricao, preco) VALUES
    (1,'Bola','B0L4','Bola de futebol 2024',79.90),
    (2,'Bola','B0L4','Bola de futebol 2023',49.90),
    (3,'Bola','B0L4','Bola de vôlei',59.90),
    (4,'Mochila','M0CH','Mochila Nunes Sports 2024',199.90),
    (5,'Mochila','M0CH','Mochila Nunes Sports 2023',149.90),
    (6,'Tênis','T3N1S','Tênis Masculino Nunes Sports 2024',299.90),
    (7,'Tênis','T3N1S','Tênis Feminino Nunes Sports 2024',249.90),
    (8,'KIT','K1T01','Kit Nunes Sports Masculino 2024 (bola de futebol, mochila e tênis)',539.90),
    (9,'KIT','K1T02','Kit Nunes Sports Feminino 2024 (bola de vôlei, mochila e tênis)',490.90);