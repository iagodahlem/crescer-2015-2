/* ================================================= *
 *	Instâncias das classes Item e CarrinhoDeCompras  *
 * ================================================= */

// instância carrinho
var carrinho = new CarrinhoDeCompras();

// instâncias de item
var item1 = new Item(1234, 'iPhone 6s', 10, 5000);
var item2 = new Item(2345, 'MacBook Pro 15"', 2, 7000);
var item3 = new Item(3456, 'Play 4', 2, 1000);

// adicionar itens ao carrinho
carrinho.adicionarItem(item1);
carrinho.adicionarItem(item2);
carrinho.adicionarItem(item3);