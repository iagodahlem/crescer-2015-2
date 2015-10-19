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
  	for (var i = 1; i < texto.length; i++) {
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
        for (var i = 0; i < nomes.length; i++) {
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
    for (var i = 1; i < n; i++) {
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
    if (col.length !== 1) {
        var valor = col.toUpperCase().charCodeAt() - 64;    
    }
    var valor = col.toUpperCase().charCodeAt() - 64;
    return valor;
}

// 6
function queroCafe(mascada, preco) {
    var mascadaType = typeof mascada;
    var precoType = typeof preco;
    
    if (mascadaType === 'number' && precoType === 'object') {
        var precos = [];
        for (var i = 0; i < preco.length; i++) {
            if (preco[i] <= mascada) {
                precos.push(preco[i]);
            }
        }
        console.log(precos.sort().toString());
    }
    else {
        console.log('Valores passados não são validos.');
    }
}