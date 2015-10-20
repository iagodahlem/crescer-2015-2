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
function somaPorMundiais(arr) {
	return somaPorTitulo(2, arr);
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

// Coleção para utilização dos exercicios

var clubes = [
	{
		nome: 'Arsenal',
		titulos: [
			{ desc: 'Nacionais', qtd: 13 },
			{ desc: 'Continentais', qtd: 0 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	}, 
	{
		nome: 'Manchester United',
		titulos: [
			{ desc: 'Nacionais', qtd: 20 },
			{ desc: 'Continentais', qtd: 3 },
			{ desc: 'Mundiais', qtd: 2 }
		]
	},
	{
		nome: 'Liverpool',
		titulos: [
			{ desc: 'Nacionais', qtd: 18 },
			{ desc: 'Continentais', qtd: 5 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	},
	{
		nome: 'Chelsea Football Club',
		titulos: [
			{ desc: 'Nacionais', qtd: 5 },
			{ desc: 'Continentais', qtd: 1 },
			{ desc: 'Mundiais', qtd: 0 }
		]
	}
];

/*============================*/

// Funções extras para utilização nas demais funções

function ordenaPorTitulo(indTitulo, arr) {
	return arr.sort(
		function(a, b) {
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