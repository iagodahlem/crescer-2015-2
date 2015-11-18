/* ======================================= *
 *	Snippet para testes via console JS     *
 * ======================================= */

// inicializa um array de objetos
[
	// objeto
	// parametro: valor passado ao parametro da função
	// esperado: valor esperado que a função retorne
  	{ parametro: 'valor', esperado: 123 },
  	{ parametro: 'valor', esperado: 123 }

// percorre os objetos
].forEach(function(elem) {
  	// comando que realiza os testes
  	console.assert(
  		// funçãoX: função na qual deseja realizar os testes
    	funçãoX(elem.parametro) === elem.esperado
  	)
});

/*============================*/

[
  	{ referencia: 'A', esperado: 1 },
].forEach(function(elem) {
  	console.assert(
    	excelis(elem.referencia) === elem.esperado
  	)
});