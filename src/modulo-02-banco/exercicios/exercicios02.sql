/* Exercicios PDF parte 02 slide 30 */

/* 01 */
Select NomeEmpregado From Empregado Order By DataAdmissao;

/* 02 */
Select NomeEmpregado, (Salario*12) as 'Salario Anual'  From Empregado Where Cargo = 'Atendente' or Salario < 18500 / 12;

/* 03 */
Select IDCidade From Cidade Where Nome = 'Uberlândia';

/* 04 */
Select IDCidade, Nome From Cidade Where UF = 'RS';