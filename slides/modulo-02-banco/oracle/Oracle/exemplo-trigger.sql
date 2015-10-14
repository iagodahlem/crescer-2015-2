create or replace trigger TR_SQ_CLIENTE
 before insert on CLIENTE
 for each row   
when (new.IDCLIENTE is null)
Begin
 Select SQCLIENTE.nextval into :new.IDCLIENTE from dual;
End TR_SQ_CLIENTE;
