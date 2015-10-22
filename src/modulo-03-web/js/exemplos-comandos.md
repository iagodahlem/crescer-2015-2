# Exemplos de comandos JavaScript

## Funções

### Criação e chamada

* Função atribuida a variavel
```javascript
var fn = function() {
	return 'hello JS.'
};
```

* Função auto declaravel
```javascript
(function(texto){
	alert(texto);
})('oi');
```

### Outras formas de chamar funções

* .call
```javascript
function soma(num1, num2) { return num1 + num2 };

soma.call(null, 1, 2);
soma.call(undefined, 1, 2);
soma.call(this, 1, 2);
```

* .apply
```javascript
function soma(num1, num2) { return num1 + num2 };

soma.apply(this, [1,2]);
```
## Fors

* for
```javascript
for (var i = 0, len = array.length; i < len; i++) {
	// comandos...
};
```

* for in

```javascript
var arr = ['a', 'b', 'c'];
for (var prop in arr) {
	console.log(arr[prop]);
};
```

* for each
```javascript
exemplo.forEach() {
	function(elem, i) {
		console.log(elem);
	};
};
```

## Error

```javascript
throw new Error('');
```

## Array

```javascript
var arr = [];
var arr = ['1', '2', '3'];
```

### Funções de Array

* .reverse

```javascript
arr.reverse();
```
* .concat

```javascript
var arr1 = ['one', 'two'];

var arr2 = arr1.concat();
```

* .shift e .unshift

```javascript
arr2.shift();

arr2.unshift();
```

* .pop e .push

```javascript
arr2.pop();

arr2.push();
```

* .splice

```javascript
arr2.splice(parametro1, parametro2);
// parametro1 = a partir da onde 
// parametro2 = até aonde
```
* .reduce

```javascript
// reduz coleções agrupando-as.
arr.reduce(function(acumulador, elemAtual) {
	return acumulador + elemAtual;
}, 0);
```

* .map

```javascript
// projeta e altera valores de uma sequência.
arr.map(function(clube) {
	// clube.nome += ' FC';
	return clube.nome += ' FC', clube;
});

// copia para novo array
arr.map(function(clube) {
	return {
		nome: clube.nome += ' FC', clube;
	}
});
```

## Date

### Criando datas

```javascript
new Date(ano, mes, dia);
new Date(2015, 1, 1);
// mes é um array de meses, sendo passado o indice do mes. Janeiro = 0
```


### Funções de Date

```javascript
.getDate();
// Retorna data completa

.getFullYear();
// Retorna ano completo

.getTime();
// timestamp
// quantidade em milissegundos desde 1970
```

## Perbolação (apenas no Chrome)

```javascript
console.log('%o', parametro);
```

## Events

```javascript
setTimeOut()

setInterval()
```
## document

### Funções de document

```javascript
document
document.all
document.all.innerHTML = '';
```