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

-- 6
SELECT
	Pedido.IDPedido,
	Pedido.DataEntrega, 
	Pedido.ValorPedido, 
	PedidoItem.Quantidade as QuantidadeItens,
	Cliente.Nome as NomeCliente
FROM Pedido
	INNER JOIN PedidoItem ON PedidoItem.IDPedido = Pedido.IDPedido
	INNER JOIN Cliente ON Cliente.IDCliente = Pedido.IDCliente
	INNER JOIN  ON PedidoItem.IDPedido = Pedido.IDPedido
WHERE 
	Pedido.DataEntrega BETWEEN '2015-10-01' AND '2015-10-31' AND
	NOT EXISTS ();

-- 7
SELECT * FROM Produto pr
INNER JOIN ProdutoMaterial prMa ON prMa.IDMaterial = 15386;

Select a.Nome as NomeAssociado,
	   c.Nome as NomeCidade
From   Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDCidade