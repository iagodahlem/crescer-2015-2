USE Crescer15_2;

create procedure prc_total_pedidos_produto
	(@IDProduto int) as

-- 1 Crie uma rotina que tenha um parametro que recebra um id produto e então projete o total de pedidos deste produto
BEGIN

	SELECT COUNT(distinct IDPedido) as TotalPedidos
	FROM 
		PedidoItem
	WHERE 
		 IDProduto = @IDProduto;

END

exec prc_total_pedidos_produto @IDProduto = 123

select * from PedidoItem;