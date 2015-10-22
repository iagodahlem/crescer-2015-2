/* ================================================= *
 *	Instâncias das classes Item e CarrinhoDeCompras  *
 * ================================================= */

// instância carrinho
var carrinho = new CarrinhoDeCompras();

// instâncias de item
var item1 = new Item({ 
	sku: 1234,
	descricao: 'iPhone 6s',
	quantidade: 10,
	valorUnitario: 5000 
});
var item2 = new Item({ 
	sku: 2345,
	descricao: 'MacBook Pro 15"',
	quantidade: 2,
	valorUnitario: 7000 });
var item3 = new Item({ 
	sku: 3456,
	descricao: 'Play 4',
	quantidade: 2,
	valorUnitario: 1000 });

// adicionar itens ao carrinho
carrinho.adicionarItem(item1);
carrinho.adicionarItem(item2);
carrinho.adicionarItem(item3);