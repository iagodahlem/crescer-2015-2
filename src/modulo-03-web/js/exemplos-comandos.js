/* ======================================= *
 *	Exemplos de funções JavaScript         *
 * ======================================= */

// DECLARAÇÃO DE FUNÇÕES E FUNÇÕES BÁSICAS

// função atribuida a variavel
var fn = function() {
	return 'hello JS.'
};

// função auto declaravel
(function(texto){
	alert(texto);
})('oi');

/*============================*/

// EXEMPLOS DE FORS

// for in
var arr = ['a', 'b', 'c'];
for (var prop in arr) {
	console.log(arr[prop]);
};

// for each
exemplo.forEach() {
	function(elem, i) {
		console.log();
	};
};

/*============================*/

throw new Error('');

/*============================*/

// Funções para Array

arr.reverse();

var arr1 = ['one', 'two'];

var arr2 = arr1.concat();

arr2.shift();

arr2.unshift();

arr2.pop();

arr2.push();

arr2.splice(parametro1, parametro2);
parametro1 = a partir da onde; parametro2 = até aonde;

/*============================*/

// Datas

new Date(ano, mes, dia);
new Date(2015, 1, 1);
// mes é um array de meses, sendo passado o indice do mes. Janeiro = 0

.getDate();

// timestamp
// quantidade em milissegundos desde 1970
.getTime();

// bliblioteca de datas
// moment.js

/*============================*/

// Perbolação (apenas no Chrome)

console.log('%o', parametro);

/*============================*/

// REDUCE
// reduz coleções agrupando-as.
ARRAY.reduce(function(acumulador, elemAtual) {
	return acumulador + elemAtual;
}, 0);

/*============================*/

// MAP
// Projeta e altera valores de uma sequência.

ARRAY.map(function(clube) {
	// clube.nome += ' FC';
	return clube.nome += ' FC', clube;
});


// copia para novo arrays
ARRAY.map(function(clube) {
	return {
		nome: clube.nome += ' FC', clube;
	}
});