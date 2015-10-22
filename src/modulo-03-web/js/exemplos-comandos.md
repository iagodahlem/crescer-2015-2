# Exemplos de comandos JavaScript

## Funções

### Criação e chamada

* Função atribuida a variavel
```
var fn = function() {
	return 'hello JS.'
};
```

* Função auto declaravel
```
(function(texto){
	alert(texto);
})('oi');
```

### Outras formas de chamar funções

* .call
```
function soma(num1, num2) { return num1 + num2 };

soma.call(null, 1, 2);
soma.call(undefined, 1, 2);
soma.call(this, 1, 2);
```

* .apply
```
function soma(num1, num2) { return num1 + num2 };

soma.apply(this, [1,2]);
```
## Fors

* for
```
for (var i = 0, len = array.length; i < len; i++) {
	// comandos...
};
```

* for in

```
var arr = ['a', 'b', 'c'];
for (var prop in arr) {
	console.log(arr[prop]);
};
```

* for each
```
exemplo.forEach() {
	function(elem, i) {
		console.log(elem);
	};
};
```

## Error

```
throw new Error('');
```

## Array

```
var arr = [];
var arr = ['1', '2', '3'];
```

### Funções de Array

```
arr.reverse();

var arr1 = ['one', 'two'];

var arr2 = arr1.concat();

arr2.shift();

arr2.unshift();

arr2.pop();

arr2.push();

arr2.splice(parametro1, parametro2);
// parametro1 = a partir da onde 
// parametro2 = até aonde;
```

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

/*============================*/

setTimeOut()

setInterval()

/*============================*/



/*============================*/

// API DOM

document
document.all
document.all.innerHTML = '';
