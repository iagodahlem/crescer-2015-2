/* ======================================= *
 *	Exercicios de functions básico         *
 * ======================================= */

// 1
function dailyGame(num) {
  	if (num % 2 === 0 ) {
    	console.log('Love me not');
	}
  	console.log('Love me');
}

/*============================*/

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

/*============================*/

// 3
function imprime(nomes, fn) {
    var valida = typeof fn;
    if (valida === 'function') {
        for (i = 0; i < nomes.length; i++) {
            var nome = nomes[i];
            fn(nome);
        }
    }
    else {
        console.log('Jabulani: \n');
        console.log('Type error: paramêtro passado não é uma função.');
    }
}

function instrutor(instrutor) {
    console.log('olá querido instrutor: ', instrutor);
}

/*============================*/

// 4
function fiboSum(n) {
    var sum = 1, pen = 0, ult = 1, atual = 0;
    for (i = 1; i < n; i++) {
        atual = pen + ult;
        pen = ult;
        ult = atual;
        sum += atual;
    }
    return sum;
}

/*============================*/

// 5
function excelis(col) {

}