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
    (9,'KIT','K1T02','Kit Nunes Sports Feminino 2024 (bola de vôlei, mochila e tênis)',490.90),
    (11,'Teste','ASD','Bola de TESTE 2024',792.90),
    (12,'Equipe','21AS','Bola de TESTE 2023',1.90),
    (13,'Nome','AD2','Bola de KEVIN',312.90),
    (14,'Celular','DWQ','KEVIN Nunes Sports 2024',454.90),
    (15,'Carregador','SAD','DESCRICAO Nunes Sports 2023',234.32),
    (16,'Nao','ZXCA','DESCRICAO Masculino Sports 2024',5334.90),
    (17,'Sei','CXZ','DESCRICAO Feminino Nunes Sports 2024',64.90),
    (18,'KIT','XAXC','DESCRICAO Nunes Sports KEVIN 2024 (bola de futebol, mochila e tênis)',76.90),
    (19,'Gamer','XCV','Kit DESCRICAO Sports Feminino 2024 (bola de vôlei, mochila e tênis)',8167.90),
    (20,'Pc','EWQR','Bola de futebol 2024',978.90),
    (21,'test','as','TESTE de DESCRICAO 2024',453.90),
    (22,'pola','EQW','Bola de KEVIN 2023',2343.90),
    (23,'bula','DSDW','Bola de KEVIN',1923.90),
    (24,'mushila','WQE','MONITOR Nunes Sports 2024',902.90),
    (25,'moxhila','TTR','Mochila CELULAR TESTE 2023',12.90),
    (26,'Tênis','QWRW','Tênis Masculino Nunes Sports 2024',32.90),
    (27,'Tênis','RWQ','Tênis Feminino Nunes Sports 2024',43.90),
    (28,'KIT','TEST','Kit CELULAR Sports Masculino 2024 (bola de futebol, mochila e tênis)',241.90),
    (29,'KIT','LPOR','Kit Nunes Sports Feminino 2024 (bola de vôlei, mochila e tênis)',534.221),
    (30,'Bola','REWD','Bola de futebol 2024',534.90),
    (31,'Bola','EWREW','Bola de futebol 2024',654.90),
    (32,'agua','QWER','Bola de futebol 2023',765.90),
    (33,'coca','DWA','Bola de vôlei',64.90),
    (34,'tes','HTR','Mochila Nunes TESTE 2024',123.90),
    (35,'teste2','BVC','Mochila Nunes Sports 2023',432.90),
    (36,'test4','EQWE','Tênis CELULAR Nunes Sports 2024',31.90),
    (37,'stes2','ERG','Tênis CELULAR Nunes Sports 2024',543.90),
    (38,'kitzao','EQW','Kit Nunes KEVIN TESTE 2024 (bola de futebol, mochila e tênis)',765.90),
    (39,'ktzin','FSD','Kit Nunes KEVIN Feminino 2024 (bola de vôlei, mochila e tênis)',876.90);
INSERT INTO produtos (nome, codigo, descricao, preco) VALUES
    ('Bola','B0L4','Bola de futebol 2024',987.90),
    ('Bola','B0L4','Bola de futebol 2023',234.90),
    ('Bola','B0L4','Bola de vôlei',12.90),
    ('Mochila','M0CH','Mochila Nunes Sports 2024',32.43),
    ('Mochila','M0CH','Mochila Nunes Sports 2023',149.43),
    ('Tênis','T3N1S','Tênis Masculino Nunes Sports 2024',299.32),
    ('Tênis','T3N1S','Tênis Feminino Nunes Sports 2024',2349.324),
    ('KIT','K1T01','Kit Nunes Sports Masculino 2024 (bola de futebol, mochila e tênis)',43.90),
    ('KIT','K1T02','Kit Nunes Sports Feminino 2024 (bola de vôlei, mochila e tênis)',234.90),
    ('Teste','ASD','Bola de TESTE 2024',79.90),
    ('Equipe','21AS','Bola de TESTE 2023',13.90),
    ('Nome','AD2','Bola de KEVIN',312.90),
    ('Celular','DWQ','KEVIN Nunes Sports 2024',45.90),
    ('Carregador','SAD','DESCRICAO Nunes Sports 2023',234.32),
    ('Nao','ZXCA','DESCRICAO Masculino Sports 2024',534.90),
    ('Sei','CXZ','DESCRICAO Feminino Nunes Sports 2024',654.90),
    ('KIT','XAXC','DESCRICAO Nunes Sports KEVIN 2024 (bola de futebol, mochila e tênis)',756.90),
    ('Gamer','XCV','Kit DESCRICAO Sports Feminino 2024 (bola de vôlei, mochila e tênis)',867.90),
    ('Pc','EWQR','Bola de futebol 2024',978.90),
    ('test','as','TESTE de DESCRICAO 2024',453.90),
    ('pola','EQW','Bola de KEVIN 2023',2343.90),
    ('bula','DSDW','Bola de KEVIN',123.90),
    ('mushila','WQE','MONITOR Nunes Sports 2024',321.90),
    ('moxhila','TTR','Mochila CELULAR TESTE 2023',149.90),
    ('Tênis','QWRW','Tênis Masculino Nunes Sports 2024',534.90),
    ('Tênis','RWQ','Tênis Feminino Nunes Sports 2024',312.90),
    ('KIT','TEST','Kit CELULAR Sports Masculino 2024 (bola de futebol, mochila e tênis)',312.90),
    ('KIT','LPOR','Kit Nunes Sports Feminino 2024 (bola de vôlei, mochila e tênis)',534.90),
    ('Bola','REWD','Bola de futebol 2024',534.90),
    ('Bola','EWREW','Bola de futebol 2024',79.90),
    ('agua','QWER','Bola de futebol 2023',49.90),
    ('coca','DWA','Bola de vôlei',654.90),
    ('tes','HTR','Mochila Nunes TESTE 2024',4213.90),
    ('teste2','BVC','Mochila Nunes Sports 2023',149.90),
    ('test4','EQWE','Tênis CELULAR Nunes Sports 2024',412.90),
    ('stes2','ERG','Tênis CELULAR Nunes Sports 2024',321.90),
    ('kitzao','EQW','Kit Nunes KEVIN TESTE 2024 (bola de futebol, mochila e tênis)',5643.90),
    ('ktzin','FSD','Kit Nunes KEVIN Feminino 2024 (bola de vôlei, mochila e tênis)',321.90);
