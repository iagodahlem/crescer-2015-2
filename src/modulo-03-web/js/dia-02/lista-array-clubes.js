/* ======================================= *
 *	Exercicios de coleções JS	           *
 * ======================================= */

// Exercicio 1

// 1.A
function ordenaPorNacionais(clubes) {
  	return ordenaPorTitulo(0, clubes);
};

// 1.B
function ordenaPorContinentais(clubes) {
	return ordenaPorTitulo(1, clubes);
};

// 1.C
function ordenaPorMundiais(clubes) {
	return ordenaPorTitulo(2, clubes);
};

/*============================*/

// Exercicio 2

// 2.A
function somaPorNacionais(clubes) {
	return somaPorTitulo(0, clubes);
};

// 2.B
function somaPorContinentais(clubes) {
	return somaPorTitulo(1, clubes);
};

// 2.C
function somaPorTodosTitulos(clubes) {
	return somaPorNacionais(clubes)
		+ somaPorContinentais(clubes)
		+ somaPorTitulo(2, clubes);
};

/*============================*/

// Exercicio 3 
function apenasOsMelhores(clubes) {
	return clubes.filter(function(elem) {
		return elem.titulos[0].qtd > 18;
	});
};

/*============================*/

// Exercicio 4
// Exemplo de utilização de map() e reduce()

function calcularIdadeMedia(clubes) {
	var soma = clubes
		.map(function(elem) {
			// Projeta a idade de cada Clube
			return new Date().getFullYear() - elem.fundacao.getFullYear();
		})
		.reduce(function(acumulador, elem) {
			// Reduz a todas as idades somadas
			return acumulador + elem;
		}, 0);
	// Retorna a média das idades
	return soma / arr.length;
};

/*============================*/

// Funções auxiliares para utilização nas demais funções

function ordenaPorTitulo(indiceTitulo, clubes) {
	return clubes.sort(function(a, b) {
		return a.titulos[indiceTitulo].qtd < b.titulos[indTitulo].qtd;
	});
};

function somaPorTitulo(indiceTitulo, clubes) {
	return clubes.reduce(function(acumulador, elem) {
		return acumulador + elem.titulos[indiceTitulo].qtd;
	}, 0);
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