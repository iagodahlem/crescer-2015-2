Select NomeEmpregado From Empregado Order By DataAdmissao;

Select NomeEmpregado, (Salario*12) as 'Salario Anual'  From Empregado Where Cargo = 'Atendente' or (Salario*12) < 18500;

Select IDCidade From Cidade Where Nome = 'Uberl�ndia';

Select IDCidade, Nome From Cidade Where UF = 'RS';