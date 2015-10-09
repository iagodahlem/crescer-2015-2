create table cidade (
  idcidade  integer not null,
  nome      varchar2(100),
  uf        varchar2(2),
    constraint pk_cidade primary key (idcidade));

create sequence sqcidade;	