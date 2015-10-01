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

-- 6
-- Faça uma consulta que retorne o nome do associado e a 
-- data de quando cada completará (ou completou) 50 anos, 
-- liste também o dia da semana.
SELECT 
	Nome, 
	DATEADD(Year, 50, DataNascimento) as Data50Anos,
	DATENAME(weekday, DATEADD(Year, 50, DataNascimento)) as DiaSemana 
FROM 
	Associado;

-- 7
-- Liste a quantidade de cidades agrupando por UF.
SELECT UF, COUNT(1) as QuantidadeDeCidades FROM Cidade GROUP BY UF;

-- 8
-- Liste as cidades que possuem o mesmo nome e UF.
SELECT 
	Nome, UF, COUNT(1) as Total
FROM 
	Cidade
GROUP BY 
	Nome, UF
HAVING COUNT(1) > 1;

-- 9
SELECT 
	MAX(IDAssociado) + 1 as ProximoID 
FROM 
	Associado;

-- 10
INSERT into CidadeAux Select MIN(IDCidade) as MenorID, Nome, UF FROM Cidade;