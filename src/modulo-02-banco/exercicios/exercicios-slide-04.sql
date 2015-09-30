/* Exercicios slide 04 - 01 */

Use CursoSQL;

-- 1
Select SUBSTRING(Nome, 0, CHARINDEX(' ', Nome)) as PrimeiroNome From Associado;

-- 2
Select Nome, DATEDIFF(YEAR, DataNascimento, GETDATE()) as Idade From Associado;

-- 3
Select *, 
	   DATEDIFF(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as TotalDeMeses 
From 
	   Empregado 
Where 
	   DataAdmissao between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

-- 4
Select 
	TOP 1 with ties Cargo as CargoComMaisEmpregado, 
	COUNT(Cargo) as NumeroDeEmpregadosNoCargo 
From 
	Empregado 
Group by 
	Cargo
Order by 
	NumeroDeEmpregadosNoCargo DESC;

--5
Select 
	TOP 1 with ties Nome, 
	LEN(Nome) as NumeroDeCaracteresDoNome 
From 
	Associado
Order by	
	NumeroDeCaracteresDoNome DESC;