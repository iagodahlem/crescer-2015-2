/* ======================================= *
 *	Exercicios de functions básico         *
 * ======================================= */

// 1
function dailyGame(num) {
  	if (num % 2 === 0 ) {
    	console.log('Love me not');
	}
  	else {
  		console.log('Love me');
  	}
}

// 2
function maiorTexto(texto) {
 	var maior = texto[0];
  	for (i = 1; i < texto.length; i++) {
    	if (texto[i].length > maior.length) {
      		maior = texto[i];
    	}
  	}
  	return maior;
}

// 3
function imprime(nomes, fn) {
    for (i = 0; i < nomes.length; i++) {
        var nome = nomes[i];
        fn(nome);
    }
}

function instrutor(instrutor) {
    console.log('Olá querido instrutor: ', instrutor);
}