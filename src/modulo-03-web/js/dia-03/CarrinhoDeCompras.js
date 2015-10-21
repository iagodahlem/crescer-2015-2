/* ======================================= *
 *	Definição da classe CarrinhoDeCompras  *
 * ======================================= */

function CarrinhoDeCompras() {
	this.itens = [];
};

// Método para adicionar Itens ao Carrinho
CarrinhoDeCompras.prototype.adicionarItem = function(item) {
	this.itens.push(item);
};

// Método para remover Itens ao Carrinho
CarrinhoDeCompras.prototype.removerItem = function(sku) {
	this.itens.splice(this.getIndexOfItem(sku), 1);
};

// Método para atualizar quantidade de determinado Item pelo seu sku
CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, quantidade) {
	this.itens[this.getIndexOfItem(sku)].quantidade = quantidade;
};

// Retorna o valor total de itens no carrinho considerando desconto caso o cliente tenha sote
CarrinhoDeCompras.prototype.valorTotal = function() {
	var valor = this.itens
		.reduce(function(acumulador, item) {
			return acumulador + item.subTotal();
		}, 0);
	return valor - (this.sortearDesconto() ? valor * 0.1 : 0);
};

// Gera numero aleatório e retorna bool
CarrinhoDeCompras.prototype.sortearDesconto = function() {
	return Math.random() < 0.4; 
}

// Under Pressure
CarrinhoDeCompras.prototype.forcarCompra = function() {
	if (!this.intervalo) {
		// var self = this;
		// self.itens
		this.intervalo = setInterval(function(){
			this.itens.forEach(function(elem) {
				elem.valorUnitario += elem.valorUnitario * 0.1;
				console.log('Valor:', elem.valorUnitario);
			})
		}.bind(this), 5000);
	}
};

// Conclui pedido 
CarrinhoDeCompras.prototype.concluirPedido = function() {
	clearInterval(this.intervalo);
	// limpa propriedade intervalo
	delete this.intervalo;
};

// Retorna indice do Item contido em Itens através de seu sku
CarrinhoDeCompras.prototype.getIndexOfItem = function(sku) {
	return this.itens.map(function(elem) {
		return elem.sku;
	}).indexOf(sku);
};