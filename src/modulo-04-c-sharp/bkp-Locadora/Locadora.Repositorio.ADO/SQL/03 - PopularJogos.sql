INSERT INTO dbo.Categoria VALUES (1, 'RPG')
INSERT INTO dbo.Categoria VALUES (2, 'Corrida')
INSERT INTO dbo.Categoria VALUES (3, 'Aventura')
INSERT INTO dbo.Categoria VALUES (4, 'Luta')
INSERT INTO dbo.Categoria VALUES (5, 'Esporte')

INSERT INTO dbo.Selo VALUES (1, 'Ouro');
INSERT INTO dbo.Selo VALUES (2, 'Prata');
INSERT INTO dbo.Selo VALUES (3, 'Bronze');

INSERT INTO dbo.Jogo VALUES ('Chrono Trigger',60,1, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Top Gear',20,2, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Megaman X',40,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Super Metroid',35,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Donkey Kong Country',25,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Super Mario Kart',40,2, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Super Street Fighter',25,4, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Mortal Kombat 2',37,4, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Killer Instinct',18,4, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Final Fight',12,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Super Mario 1',70,1, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Aladdin',16,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Rock ''n Roll Racing',22,2, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Zelda: A link to the past',110,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Final Fantasy VI',30.5,1, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('International Super Star Soccer Deluxe',45,5, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Contra III',28,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Sunset Riders',37.9,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Goof Troop',41.9,3, null, '', 1, null, null)
INSERT INTO dbo.Jogo VALUES ('Mickey to Donald: Magical Adventure 3',32.9,3, null, '', 1, null, null)

ALTER TABLE dbo.Jogo ALTER COLUMN Descricao VARCHAR(300) NOT NULL;
ALTER TABLE dbo.Jogo ALTER COLUMN IdSelo INT NOT NULL;
