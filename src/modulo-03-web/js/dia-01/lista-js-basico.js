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
  	for (var i = 0, maiorTexto = '', len = textos.length; i < len; i++) {
    	if (textos[i].length > maiorTexto.length) {
      		maiorTexto = textos[i];
    	}
  	}
  	return maior;
};

/*============================*/

// 3
function imprime(nomes, fn) {
    if (isFunction(fn)) {
        nomes.forEach(fn);
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
// Implementação recursiva
function fibonacci(n) {
    if (n === 1) return 1;
    if (n === 2) return 1;

    return fibonacci(n - 1) + fibonacci(n - 2);
};

function fiboSum(n) {
    return fibonacci(n+2)-1;
    /* Implementação sem recursão
    var sum = 1, pen = 0, ult = 1, atual = 0;
    for (var i = 1; i < n; i++) {
        atual = pen + ult;
        pen = ult;
        ult = atual;
        sum += atual;
    }
    return sum;
    */
};

/*============================*/

// 5
function excelis(col) {
    referencia = referencia.toUpperCase();
    for (var i = 0, soma = 0, len = referencia.length; i < len; i++) {
        soma = soma * 26 + (referencia.charCodeAt(i) - 64);
    }
    return soma;
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