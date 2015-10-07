use Crescer15_2;

-- Exercicios adicionais - SQL JOINS

-- 1
SELECT 
	COUNT(1) as TotalDePedidos 
FROM 
	Pedido 
WHERE 
	DataPedido BETWEEN convert(datetime, '01/09/2015', 103) 
				   AND convert(datetime, '30/09/2015', 103)+.99999;

create index IX_Pedido_DataPedido on Pedido (DataPedido)

-- 2
SELECT * FROM 
	Cliente 
WHERE 
	   Nome		   LIKE '%LTDA%' 
	or RazaoSocial LIKE '%LTDA%'

-- 3
INSERT INTO 
	Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
VALUES
	('Galocha Maragato', 35.67, 77.95, 'A');

-- 4
SELECT IDProduto,
	   Nome
FROM 
	Produto 
WHERE 
	NOT EXISTS (Select 1 
				 From PedidoItem
				 WHERE PedidoItem.IDProduto = Produto.IDProduto);

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
	
---

 Select p.IDPedido, 
        c.IDCliente, 
		c.Nome, 
        p.ValorPedido, p.DataPedido, p.DataEntrega
 From   Pedido p
   inner join Cliente c on c.IDCliente = p.IDCliente
 Where  DataEntrega between convert(datetime, '01/10/2015', 103)
                        and convert(datetime, '31/10/2015', 103)+.99999   -- garante que será o último instante daquele dia
 and    exists (Select 1 
                From   PedidoItem i
				where  i.IDPedido = p.IDPedido
				and    exists (select 1
				               from   ProdutoMaterial pm
							   where  pm.IDProduto = i.IDProduto
							   and    pm.IDMaterial in (14650,15703,15836,16003,16604,17226)
							   )
				)

-- 7
SELECT * FROM Produto pr
INNER JOIN ProdutoMaterial prMa ON prMa.IDMaterial = 15386;

Select IDProduto, Nome
From   Produto p
Where  exists (select 1
               from    ProdutoMaterial pm
			   where   pm.IDProduto  = p.IDProduto
			   and     pm.IDMaterial = 15836);

-- 8
Select pro.IDProduto, pro.Nome
From   Produto pro
Where  NOT EXISTS (Select 1
                   From   ProdutoMaterial pm
			       where  pm.IDProduto = pro.IDProduto );

-- 9
Select TOP 1
       Substring( Nome, 1, charIndex(' ', Nome)-1) PrimeiroNome, 
       count(1) Total
From   Cliente
Group  by Substring( Nome, 1, charIndex(' ', Nome)-1)  
Order by Total DESC;