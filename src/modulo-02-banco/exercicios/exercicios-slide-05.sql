/* Exercicios slide 05 */

-- 1
Select e.NomeEmpregado as 'Nome do Empregado', 
	   d.NomeDepartamento as 'Nome do Departamento' 
From Empregado as e
INNER JOIN Departamento as d ON d.IDDepartamento = e.IDDepartamento;

-- 2
Select a.Nome as 'Nome do Associado',
	   c.Nome as 'Nome da Cidade'
From Associado as a
LEFT JOIN Cidade as c ON c.IDCidade = a.IDCidade;

-- 3
-- Lista os estados (UF) e total de cidades que não possuem associados relacionados 
-- (dica: pode ser utilizado count + group by + exists).

Select UF as Estados, 
	   COUNT(Nome) as TotalDeCidades 
From Cidade as c
Where NOT EXISTS (Select 1 From Associado a Where a.IDCidade = c.IDCidade)
GROUP BY UF;

select * from Associado;

-- 4 
-- Faça uma consulta que liste o nome do associado, o nome da cidade, 
-- e uma coluna que indique se a cidade é da região SUL (RS, SC, PR), 
-- se for imprimir *** (3 asteriscos), senão imprimir nulo.

Select a.Nome as 'Nome do Associado', 
	   c.Nome as 'Nome do Departamento',
	   Case when c.UF = 'RS' then '***'
			when c.UF = 'SC' then '***'
			when c.UF = 'PR' then '***'
			else NULL
	   End Estado
From Associado as a
INNER JOIN Cidade as c ON c.IDCidade = a.IDCidade;