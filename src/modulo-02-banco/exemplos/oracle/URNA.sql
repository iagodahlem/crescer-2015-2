declare
  cursos c_cidade is 
    select nome,
           uf,
           min(idcidade) idcidade
    from cidade
    group by nome, uf;
begin
 for i in c_cidade loop
  dbms_output.put_line('Cidade ' || i.nome);
 end loop;
end;

select * from table(dbms_xplan.display);