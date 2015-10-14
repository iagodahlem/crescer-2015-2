CREATE USER URNA IDENTIFIED  BY URNA;

GRANT CONNECT, RESOURCE, CREATE VIEW TO URNA;

SELECT * FROM ALL_DIRECTORIES;

GRANT READ ON DIRECTORY CURSOSQL TO URNA;
GRANT WRITE ON DIRECTORY CURSOSQL TO URNA;

CREATE USER TESTE_UNITARIO IDENTIFIED BY TESTE_UNITARIO;

GRANT CONNECT, RESOURCE, CREATE VIEW TO TESTE_UNITARIO;

SELECT * FROM USER_TABLES;

EXEC DBMS_STATS.GATHER_SCHEMA_STATS(user);

CREATE TABLESPACE DESAFIO1_DAT datafile 'C:\ORACLEXE\APP\ORACLE\ORADATA\XE\DESAFIO1_D'

Create tablespace DESAFIO1_DAT
datafile'C:\oraclexe\app\oracle\oradata\XE\DESAFIO_DAT01.DBF'
size 100m
autoextend on
next 100m
maxsize 6000m;

ALTER USER DESAFIO1 IDENTIFIED BY DESAFIO1
DEFAULT TABLESPACE DESAFIO1_DAT;

grant connect, resource, create view to DESAFIO1;
