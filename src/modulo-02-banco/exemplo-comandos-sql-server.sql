-- Exemplos de comandos vistos em aula durante o Projeto CRESCER - CWI
-- Módulo 02 - Banco de Dados

Use CursoSQL;

------------------------------

-- COMANDOS DDL

---------------

-- CREATE

Create Table Cliente (
	IDCliente	int IDENTITY (1,1)	NOT NULL,
	Nome		varchar(30)			NOT NULL,
	Endereco	varchar(35),
	Bairro		varchar(35),
	IDCidade	int,
		constraint PK_Cliente Primary Key (IDCliente)
);

Create Table Cidade (
	IDCidade	int			NOT NULL,
	Nome		varchar(30) NOT NULL,
	UF			varchar(2)	NOT NULL,
		constraint PK_Cidade Primary Key (IDCidade),
		constraint UK_Cidade_Nome Unique (Nome)
);

Create Table Empregado (
	IDEmpregado	int			NOT NULL,
	Nome		varchar(50) NOT NULL,
	Sexo		char(1)		NOT NULL,
	IDCidade	int			NOT NULL,
		constraint PK_Empregado		 Primary Key (IDEmpregado),
		constraint CC_Empregado_Sexo Check (Sexo in ('F', 'M')), 
		constraint FK_Emprego_Cidade Foreign Key (IDCidade) 
			References Cidade (IDCidade)
);

--------------

-- ALTER

-- Adiciona uma nova coluna a determinada tabela
Alter Table Cidade Add CodigoIBGE Integer;

-- Altera determinada coluna
Alter Table Cidade Alter column IBGE decimal(8);

-- Renomeia uma coluna
exec sp_RENAME 'Cidade.CodigoIBGE' , 'Cod_IBGE', 'COLUMN'
-- Sintaxe:
exec sp_RENAME 'TableName.[OldColumnName]' , '[NewColumnName]', 'COLUMN'

-- Altera constraints
Alter Table Cliente Drop constraint PK_Cliente_28374892374;
Alter Table Cliente Add constraint PK_Cliente primary key (IDCliente);
Alter Table Cidade Add constraint PK_Cidade primary key (IDCidade);

--------------

-- DROP

-- Deleta tabelas
Drop Table Cidade;

------------------------------

-- COMANDOS DML

--------------

-- INSERT

Insert into Cidade 
	(IDCidade, Nome, UF) 
values 
	(1, 'São Leopoldo', 'RS');

--------------

-- UPDATE

/* Altera dados já existentes na tabela determinada */
Update  Cidade
Set		Nome = 'Novo Hamburgo'
Where	IDCidade = 1;

--------------

-- DELETE

/* Delete linha inteira da tabela determinada e estipulada pela clausula WHERE */
Delete From Cidade
Where		IDCidade = 1;

--------------

-- SELECT

--------------

Select 
	Nome_Cidade as Nome,
	UF			as Estado
From 
	Cidade;

--------------

-- Copiar tabelas
Select * into CopiaCidade From Cidade;

--------------

-- OPERAÇÕES

Select 
	NomeEmpregado as Nome,
	salario		  as SalarioMensal,
    (salario*12)  as SalarioAnual
From 
	Empregado;

--------------

-- ORDER BY

-- ordenando o resultado dos relatórios
Select 
	Nome, UF
From 
	Cidade
Order by 
	Nome ASC -- ou DESC;

--------------

-- OPERADORES SQL

Select 
	IDCidade, Nome, UF
From 
	Cidade
Where UF in ('RS', 'SC', 'PR');

----------------------------

-- FUNÇÕES DE GRUPO

Select COUNT(IDEmpregado) as TotalEmpregados,
	   COUNT(1) as Total2,
	   COUNT(*) as Total2
	   From Empregado;

Select Distinct Cargo From Empregado;

----------------------------

-- TRANSAÇÕES

-- Inicia uma transação
begin transaction;

-- Salva alterações dentro da transação
commit;

-- Desfaz alterações dentro da transação
rollback;

-- Apaga a tabela todos os dados da tabela e não permite desfazer as alterações
truncate table Cidade;

----------------------------

-- JOINS

--------------

-- INNER JOIN

-- Explicito
Select a.Nome as NomeAssociado,
	   c.Nome as NomeCidade
From   Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDCidade

-- Implicito
Select a.Nome as NomeAssociado,
c.Nome as NomeCidade
From Associado a, Cidade c
WHERE c.IDCidade = a.IDCidade

--------------

-- LEFT (OUTER) JOIN
Select a.Nome as NomeAssociado,
	   c.Nome as NomeCidade
From Associado a
LEFT JOIN Cidade c ON c.IDCidade = a.IDCidade

--------------

-- SELF JOIN (auto-relacionamento)
Select e.NomeEmpregado as NomeEmpregado,
	   g.NomeEmpregado as NomeGerente
From Empregado e
  INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado

----------------------------

-- Listar estrutura da tabela determinada
SP_HELP 'Cliente'

--------------