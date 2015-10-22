/* ======================================= *
 *	Sub-classe da classe Elfo - Herança    *
 * ======================================= */

function ElfoNoturno () {
	// super(nome, flechas);
	// Elfo.call(this, nome ,flechas);
	Elfo.apply(this, arguments);
};

// public class ElfoNoturno extends Elfo
ElfoNoturno.prototype = Object.create(Elfo.prototype);

// override
ElfoNoturno.protype.atirarFlecha = function() {
	// super.atirarFlecha();
	// Elfo.protoype.atirarFlecha.call(this, dwarf);
	Elfo.protoype.atirarFlecha.apply(this, arguments);
	console.log('sobrecarga do atirarFlecha');
};

// static
ElfoNoturno.mediaDeAltura = function() {
	return 2.15;
};