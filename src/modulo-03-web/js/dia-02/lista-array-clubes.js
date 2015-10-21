/* ======================================= *
 *	Exercicios de coleções JS	           *
 * ======================================= */

// Exercicio 1

// 1.A
function ordenaPorNacionais(arr) {
  	return ordenaPorTitulo(0, arr);
};

// 1.B
function ordenaPorContinentais(arr) {
	return ordenaPorTitulo(1, arr);
};

// 1.C
function ordenaPorMundiais(arr) {
	return ordenaPorTitulo(2, arr);
};

/*============================*/

// Exercicio 2

// 2.A
function somaPorNacionais(arr) {
	return somaPorTitulo(0, arr);
};

// 2.B
function somaPorContinentais(arr) {
	return somaPorTitulo(1, arr);
};

// 2.C
function somaPorTodosTitulos(arr) {
	return somaPorTitulo(0, arr)
		 + somaPorTitulo(1, arr)
		 + somaPorTitulo(2, arr);
};

/*============================*/

// Exercicio 3 
function apenasOsMelhores(arr) {
	return arr
	.filter(function(club) {
		return club.titulos[0].qtd > 18;
	});
};

/*============================*/

// Exercicio 4

/* 
	Exemplo de utilização de map() e reduce()
 */

function calcularIdadeMedia(arr) {
	var soma = arr
		.map(function(elem) {
			return new Date().getFullYear() - elem.fundacao.getFullYear();
		})
		.reduce(function(acumulador, elem) {
			return acumulador + elem;
		}, 0);
	return soma / arr.length;
};

/*============================*/

// Funções auxiliares para utilização nas demais funções

function ordenaPorTitulo(indTitulo, arr) {
	return arr.sort(function(a, b) {
		return a.titulos[indTitulo].qtd < b.titulos[indTitulo].qtd;
	});
};

function somaPorTitulo(indTitulo, arr) {
	var sum = 0;
	arr.forEach(function(value) {
		sum += value.titulos[indTitulo].qtd;
	});
	return sum;
};

/*============================*/

// Coleção para utilização dos exercicios

var clubes = [
	{
		nome: 'Arsenal',
		fundacao: new Date(1886, 0, 1),
		titulos: [
			{ desc: 'Nacionais', qtd: 13 },
			{ desc: 'Continentais', qtd: 0 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	}, 
	{
		nome: 'Manchester United',
		fundacao: new Date(1878, 0, 1),
		titulos: [
			{ desc: 'Nacionais', qtd: 20 },
			{ desc: 'Continentais', qtd: 3 },
			{ desc: 'Mundiais', qtd: 2 }
		]
	},
	{
		nome: 'Liverpool',
		fundacao: new Date(1892, 2, 15),
		titulos: [
			{ desc: 'Nacionais', qtd: 18 },
			{ desc: 'Continentais', qtd: 5 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	},
	{
		nome: 'Chelsea Football Club',
		fundacao: new Date(1905, 2, 10),
		titulos: [
			{ desc: 'Nacionais', qtd: 5 },
			{ desc: 'Continentais', qtd: 1 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	}
];