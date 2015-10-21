function Elfo(nome, flechas) {
	this.nome = nome;
	this.flechas = flechas || 42;
};

Elfo.prototype.atirarFlecha = function(dwarf) {
	return 'Atirando flecha...';
};