/*

if (existe usuário lavanderia) {
  
  DROP TABLE cliente;  
  DROP TABLE servico;

} else {

  CREATE USER lavanderia IDENTIFIED BY oracle;  
  GRANT CONNECT, RESOURCE, CREATE VIEW TO lavanderia;
}

*/


-- COM o usuário lavanderia, executar:


-- Cidade
CREATE TABLE Cidade (
  IDCidade INTEGER NOT NULL,
  Nome VARCHAR2(50) NOT NULL,
  UF VARCHAR2(2) NOT NULL,
  CONSTRAINT PK_Cidade PRIMARY KEY (IDCidade)
);


-- Servico
CREATE SEQUENCE SEQ_Servico START WITH 1 INCREMENT BY 1;

CREATE TABLE Servico (
  IDServico INTEGER NOT NULL,
  Descricao VARCHAR2(30) NOT NULL,
  CONSTRAINT PK_Servico PRIMARY KEY (IDServico)
);


-- Material
CREATE SEQUENCE SEQ_Material START WITH 1 INCREMENT BY 1;

CREATE TABLE Material (
  IDMaterial INTEGER NOT NULL,
  Descricao VARCHAR2(30) NOT NULL,
  CONSTRAINT PK_Material PRIMARY KEY (IDMaterial)
);



-- Cliente
CREATE SEQUENCE SEQ_Cliente START WITH 1 INCREMENT BY 1;

CREATE TABLE Cliente (
  IDCliente INTEGER NOT NULL,
  Nome VARCHAR2(70) NOT NULL,
  CPF VARCHAR2(11) NOT NULL,
  Email VARCHAR2(100),
  Endereco VARCHAR2(50),
  Bairro VARCHAR2(50),
  IDCidade INTEGER,
  CEP NUMBER(8),
  Situacao VARCHAR2(1),
  CONSTRAINT PK_Cliente PRIMARY KEY (IDCliente),
  CONSTRAINT UK_Cliente_CPF UNIQUE (CPF),
  CONSTRAINT UK_Cliente_Email UNIQUE (Email),
  CONSTRAINT FK_Cliente_Cidade FOREIGN KEY (IDCidade) REFERENCES Cidade(IDCidade)
);


-- Produto
CREATE SEQUENCE SEQ_Produto START WITH 1 INCREMENT BY 1;

CREATE TABLE Produto (
  IDProduto INTEGER NOT NULL,
  IDServico INTEGER NOT NULL,
  IDMaterial INTEGER NOT NULL,
  Valor NUMBER(12,2) NOT NULL,
  CONSTRAINT PK_Produto PRIMARY KEY (IDProduto),
  CONSTRAINT FK_Item_Servico FOREIGN KEY (IDServico) REFERENCES Servico(IDServico),
  CONSTRAINT FK_Item_Material FOREIGN KEY (IDMaterial) REFERENCES Material(IDMaterial)
);

-- Pedido
CREATE SEQUENCE SEQ_Pedido START WITH 1 INCREMENT BY 1;

CREATE TABLE Pedido (
  IDPedido INTEGER NOT NULL,
  IDCliente INTEGER NOT NULL,
  DataInclusao DATE NOT NULL,
  DataEntrega DATE,
  Valor NUMBER(12,2) NOT NULL,
  Situacao VARCHAR2(1),
  CONSTRAINT PK_Pedido PRIMARY KEY (IDPedido),
  CONSTRAINT FK_Pedido_Cliente FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente)
);

-- Item
CREATE SEQUENCE SEQ_Item START WITH 1 INCREMENT BY 1;

CREATE TABLE Item (
  IDItem INTEGER NOT NULL,
  IDPedido INTEGER NOT NULL,
  IDProduto INTEGER NOT NULL,
  Peso NUMBER(12,2) NOT NULL,
  ValorUnitario NUMBER(12,2) NOT NULL,
  ValorDesconto NUMBER(12,2) NOT NULL,
  ValorTotal NUMBER(12,2) NOT NULL,
  Situacao VARCHAR2(1),
  CONSTRAINT PK_Item PRIMARY KEY (IDItem),
  CONSTRAINT FK_Item_Pedido FOREIGN KEY (IDPedido) REFERENCES Pedido(IDPedido),
  CONSTRAINT FK_Item_Produto FOREIGN KEY (IDProduto) REFERENCES Produto(IDProduto)
);


-- SE for necessário recriar, abaixo seguem os DROPS:
  --DROP TABLE Item;
  --DROP TABLE Pedido;
  --DROP TABLE Produto;
  --DROP TABLE Cliente;
  --DROP TABLE Cidade;
  --DROP TABLE Servico;
  --DROP TABLE Material;
  --DROP SEQUENCE SEQ_Servico;
  --DROP SEQUENCE SEQ_Material;
  --DROP SEQUENCE SEQ_Cliente;
  --DROP SEQUENCE SEQ_Produto;
  --DROP SEQUENCE SEQ_Pedido;
  --DROP SEQUENCE SEQ_Item;


/*

create table cliente (
    idCliente number(10) primary key,
    nmCliente varchar2(50),
    nrCpf varchar2(11)
);

create sequence cliente_seq;

create table servico (
    idServico number(10) primary key,
    dsServico varchar2(50)
);

create table pedido (
    idpedido number(10) primary key,
    idcliente number(10) not null,
    dsPedido varchar2(200)
);
alter table pedido add constraint PED_CLI_FK foreign key(idcliente) references cliente(idcliente);
create index PED_CLI_FK on pedido(idcliente);

create sequence pedido_seq;

*/
