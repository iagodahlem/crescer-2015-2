/* ======================================= *
 * Extensões de String			           *
 * ======================================= */

String.prototype.comecaComB = function() {
	return this.toUpperCase()[0] === 'B';
};

String.prototype.palindromo = function() {
	return this.split('').join('') === this.split('').reverse().join('');
};