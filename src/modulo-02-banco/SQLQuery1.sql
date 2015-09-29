select * from cidade
select * from cliente
select * from empregado

--------------

Insert Cidade
	(IDCidade, Nome, UF)
values
	(1, 'São Leopoldo', 'RS') ;

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

--------------

alter table Cidade add constraint PK_Cidade primary key (IDCidade);

--------------

/* Inicia uma transação */
begin transaction;

/* Deleta todos os campos da tabela determinada */
delete from Cidade;

/* Salva alterações dentro da transação */
commit

/* Desfaz alterações dentro da transação */
rollback;

/* Apaga a tabela e reseta geral */
truncate table Cidade;

--------------

/* Lista estrutura da tabela determinada */
SP_HELP 'Cliente'