/* ======================================= *
 *	Definição da classe Item			   *
 * ======================================= */

function Item(sku, descricao, quantidade, valorUnitario) {
	this.sku = sku;
	this.descricao = descricao;
	this.quantidade = quantidade;
	this.valorUnitario = valorUnitario;
};

// Retorna o sub-total de Item
Item.prototype.subTotal = function() {
	return this.quantidade * this.valorUnitario;
};