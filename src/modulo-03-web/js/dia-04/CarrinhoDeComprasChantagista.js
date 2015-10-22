/* =================================================== *
 *	Definição da classe CarrinhoDeComprasChantagitac   *
 * =================================================== */

function CarrinhoDeComprasChantagista() {
	CarrinhoDeCompras.call(this);
};

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

// Under Pressure
CarrinhoDeComprasChantagista.prototype.forcarCompra = function() {
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
CarrinhoDeComprasChantagista.prototype.concluirPedido = function() {
	clearInterval(this.intervalo);
	// limpa propriedade intervalo
	delete this.intervalo;
};
