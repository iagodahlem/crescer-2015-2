Use CursoSQL;

SELECT * FROM Associado

Insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF) values (3, 'Julio de Castilhos', convert(datetime, '14/12/1947', 103), 'M', 21234567895);
Insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF) values (4, 'Antonio Augusto Borges de Medeiros', convert(datetime, '19/03/1942', 103),'M', 81234567891);
Insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF) values (5, 'Osvaldo Aranha', convert(datetime, '08/02/1958', 103),'M', 01234567893);

Select * into CidadeAux From Cidade;

Select * From CidadeAux;

Truncate table CidadeAux;

Insert into CidadeAux Select * From Cidade;