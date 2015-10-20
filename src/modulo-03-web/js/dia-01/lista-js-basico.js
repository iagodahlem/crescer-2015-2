/* ======================================= *
 *	Exercicios de functions básico         *
 * ======================================= */

// 1
function daisyGame(petals) {
  	if (isNumber(petals)) {
        return 'Love me' + (petals % 2 === 0 ? ' not' : '');
    }
    else {
        throw new Error('Parametro informado não é um numero.');
    }
};

/*============================*/

// 2
function maiorTexto(textos) {
 	var maior = '';
    var len = textos.length;
  	for (var i = 0; i < len; i++) {
    	if (textos[i].length > maior.length) {
      		maior = textos[i];
    	}
  	}
  	return maior;
};

/*============================*/

// 3
function imprime(nomes, fn) {
    if (isFunction(fn)) {
        for (var i = 0; i < nomes.length; i++) {
            var nome = nomes[i];
            fn(nome);
        }
    }
    else {
        return('Jabulani: \n', 'Type error: paramêtro passado não é uma função.');
    }
};

function instrutor(instrutor) {
    console.log('olá querido instrutor: ', instrutor);
};

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
};

/*============================*/

// 5
function excelis(col) {
    var valor = col.toUpperCase().charCodeAt() - 64;
    return valor;
};

/*============================*/

// 6
function queroCafe(mascada, preco) {
    var mascadaType = typeof mascada;
    var precoType = typeof preco;

    if (isNumber && precoType === 'object') {
        var precos = [];
        for (var i = 0; i < preco.length; i++) {
            if (preco[i] <= mascada) {
                precos.push(preco[i]);
            }
        }
        return (precos.sort().toString());
    }
    else {
        return ('Valores passados não são validos.');
    }
};

/*============================*/

// funções para utilização nas demais funções
function isNumber(n) {
    return typeof n === 'number';
};

function isFunction(fn) {
    return typeof fn === 'function';
};