USE Crescer15_2;

-- 1 Crie uma rotina que tenha um parametro que recebra um id produto e então projete o total de pedidos deste produto

create procedure prc_total_pedidos_produto
	(@IDProduto int) as

BEGIN

	SELECT COUNT(distinct IDPedido) as TotalPedidos
	FROM 
		PedidoItem
	WHERE 
		 IDProduto = @IDProduto;

END

exec prc_total_pedidos_produto @IDProduto = 123

-----------------------

-- 2

exec verifica_cidade @Nome = 'teste2', @UF = 'RS'

select * from Cidade; 

create procedure verifica_cidade
 (@Nome     VARCHAR(20),
  @UF       VARCHAR(2)) as

BEGIN
	
	DECLARE @IDCidade INT

	Select @IDCidade = MIN(IDCidade)
	From   Cidade
	Where  Nome = @Nome and
		   UF   = @UF

	IF (@IDCidade is NULL) BEGIN
		Insert into Cidade (Nome, UF)  -- output inserted.IDCidade
		values (@Nome, @UF);
		PRINT 'Novo registro com o ID: ' + Cast(@IDCidade as VARCHAR(10))
	END
	ELSE BEGIN
		PRINT 'Registro encontrado com o ID: ' + Cast(@IDCidade as VARCHAR(10))
	END

END

-----------------

-- 3

exec resumo_pedidos 149

alter procedure resumo_pedidos
	(@IDCliente int) 
	as

BEGIN
	SELECT Pedido.DataPedido, 
		   COUNT(distinct(Pedido.IDPedido)) as TotalPedidos,
		   SUM(Pedido.ValorPedido) as ValorTotal,
		   COUNT(distinct(PedidoItem.IDProduto)) as ProdutosDistintos
	FROM Pedido 
	INNER JOIN PedidoItem ON PedidoItem.IDPedido = Pedido.IDPedido
	WHERE IDCliente = @IDCliente AND DataPedido BETWEEN dateadd(month, -6, getdate()) and getdate()
	GROUP BY Pedido.DataPedido

END