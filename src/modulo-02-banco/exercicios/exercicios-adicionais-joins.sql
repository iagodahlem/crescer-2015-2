use Crescer15_2;

-- Exercicios adicionais - SQL JOINS

-- 1
SELECT 
	COUNT(1) as TotalDePedidos 
FROM 
	Pedido 
WHERE 
	DataPedido BETWEEN '2015-09-01' AND '2015-09-30';

-- 2
SELECT * FROM 
	Cliente 
WHERE 
	Nome LIKE '%LTDA%' or RazaoSocial LIKE '%LTDA%'

-- 3
INSERT INTO 
	Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
VALUES
	('Galocha Maragato', 35.67, 77.95, 'A');

-- 4
SELECT * FROM 
	Produto 
WHERE 
	Nome = 'Galocha Maragato' OR 
	(NOT EXISTS (Select 1 
				 From PedidoItem
				 WHERE PedidoItem.IDProduto = Produto.IDProduto));

-- 5
SELECT * FROM 
(SELECT TOP 1 
	COUNT(c1.IDCidade) as TotalClientes,
	c1.UF as NomeEstado
FROM 
	Cidade c1
WHERE EXISTS (SELECT 1 
			  FROM Cliente
			  WHERE c1.IDCidade = Cliente.IDCidade)
GROUP BY 
	UF
ORDER BY 
	TotalClientes DESC) a
UNION ALL
SELECT * FROM 
(SELECT TOP 1
	COUNT(c2.IDCidade) as TotalClientes,
	c2.UF as NomeEstado
FROM 
	Cidade c2
WHERE EXISTS (SELECT 1 
			  FROM Cliente
			  WHERE c2.IDCidade = Cliente.IDCidade)
GROUP BY 
	UF
ORDER BY 
	TotalClientes) b;





Select Cliente.Nome as NomeCliente,
	   Cidade.UF as NomeEstado
From   Cliente
INNER JOIN Cidade ON Cidade.IDCidade = Cliente.IDCidade;