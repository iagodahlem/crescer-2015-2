/* ======================================= *
 *	Definição da classe Item			   *
 * ======================================= */

function Item(options) {
	options = options || {};
	this.sku = options.sku;
	this.descricao = options.descricao;
	this.quantidade = options.quantidade || 0;
	this.valorUnitario = options.valorUnitario;
};

// Retorna o sub-total de Item
Item.prototype.subTotal = function() {
	return this.quantidade * this.valorUnitario;
};