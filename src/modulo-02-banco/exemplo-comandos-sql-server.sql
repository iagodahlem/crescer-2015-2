Use CursoSQL;

Select * From Cidade;
Select * From Cliente;
Select * From Empregado;
Select * From Associado;

--------------

Insert into Cidade (IDCidade, Nome, UF) values (1, 'São Leopoldo', 'RS');

--------------

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
		constraint FK_Emprego_Cidade Foreign Key (IDCidade) References Cidade (IDCidade)
);

--------------

alter table Cliente drop constraint PK_Cliente_28374892374;

alter table Cliente add constraint PK_Cliente primary key (IDCliente);

alter table Cidade add constraint PK_Cidade primary key (IDCidade);

--------------

/* Altera dados já existentes na tabela determinada */
Update  Cidade
Set		Nome = 'Novo Hamburgo'
Where	IDCidade = 1;

/* Delete linha inteira da tabela determinada e estipulada pela clausula WHERE */
Delete From Cidade
Where		IDCidade = 1;

--------------

/* Inicia uma transação */
begin transaction;

/* Salva alterações dentro da transação */
commit;

/* Desfaz alterações dentro da transação */
rollback;

/* Apaga a tabela e reseta geral */
truncate table Cidade;

--------------

/* Copiar tabelas */
Select * into CopiaCidade From Cidade;

--------------

/* FUNÇÕES DE GRUPO */

Select COUNT(IDEmpregado) as TotalEmpregados,
	   COUNT(1) as Total2,
	   COUNT(*) as Total2
	   From Empregado;

Select Distinct Cargo From Empregado;

--------------

/* JOINS */

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

	----

-- LEFT (OUTER) JOIN

Select a.Nome as NomeAssociado,
	   c.Nome as NomeCidade
From Associado a
LEFT JOIN Cidade c ON c.IDCidade = a.IDCidade

	----

-- SELF JOIN (auto-relacionamento)

Select e.NomeEmpregado as NomeEmpregado,
	   g.NomeEmpregado as NomeGerente
From Empregado e
  INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado

--------------

/* Lista estrutura da tabela determinada */
SP_HELP 'Cliente'

--------------