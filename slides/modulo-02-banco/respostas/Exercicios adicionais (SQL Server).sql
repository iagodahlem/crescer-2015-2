/*
1) 
*/
Select Count(1)
from   pedido
where  datapedido between convert(datetime, '01/09/2015', 103)
                      and convert(datetime, '30/09/2015', 103)

					  
/*
2) Liste todos os clientes que tenham o LTDA no nome ou na razao social.
*/
Select IDCliente, Nome, RazaoSocial
From   Cliente
Where  upper(Nome)        like '%LTDA%'
   or  upper(RazaoSocial) like '%LTDA%'
   
/*
3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
*/   
Insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
 Values  ('Galocha Maragato', 35.67, 77.95, 'A');   
 
 
/*
4) Identifique e liste os produtos que não tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, 
pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
Obs.: o produto criado anteriormente deverá ser listado.
*/

-- opcao 1
 Select IDProduto,
        Nome
 From   Produto
 Where  not exists (select 1
                    from   PedidoItem
					where  PedidoItem.IDProduto = Produto.IDProduto);


/*
5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes 
(tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.
*/ 

-- criando view para reutilização de código
Create view vwEstados as
	Select cid.UF, Count(1) AS TotalClientes
	From   Cidade cid
	 inner join Cliente cli on cli.IDCidade = cid.IDCidade
	Group by cid.UF

-- utilizando a view para projetar o menor e maior
select * from vwEstados
where TotalClientes = (select min(TotalClientes) from vwEstados)
   or TotalClientes = (select max(TotalClientes) from vwEstados);


/*
6) Identifique e liste os produtos que não tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, 
pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
Obs.: o produto criado anteriormente deverá ser listado.
*/

-- opcao 1
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

/*
7)	Liste quais os produtos que utilizam o material de IDMaterial = 15836.
*/
Select IDProduto, Nome
From   Produto p
Where  exists (select 1
               from    ProdutoMaterial pm
			   where   pm.IDProduto  = p.IDProduto
			   and     pm.IDMaterial = 15836);

/*
8) Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial). 
Identifique se existe algum produto sem material relacionado.
Obs.: o produto criado anteriormente deverá ser listado.
*/

Select pro.IDProduto, pro.Nome
From   Produto pro
Where  NOT EXISTS (Select 1
                   From   ProdutoMaterial pm
			       where  pm.IDProduto = pro.IDProduto );


/*
 9) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
*/

Select TOP 1
       Substring( Nome, 1, charIndex(' ', Nome)-1) PrimeiroNome, 
       count(1) Total
From   Cliente
Group  by Substring( Nome, 1, charIndex(' ', Nome)-1)  
Order by Total DESC;