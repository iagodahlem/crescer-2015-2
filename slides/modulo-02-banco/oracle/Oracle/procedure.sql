CREATE OR REPLACE PROCEDURE Carrega_Cidade (
      pArquivo IN varchar2
   ) IS

    linha   VARCHAR2(32767); --32767
    arquivo UTL_FILE.FILE_TYPE;
    --
    vNome           varchar2(100);
    vUF             varchar2(10);
BEGIN
   -- Arquivo conforme parametro informado inicialmente
   arquivo := UTL_FILE.FOPEN('CURSOSQL', pArquivo,'R');

   LOOP
        begin
            -- Busca a linha do arquivo texto
            UTL_FILE.GET_LINE(arquivo, linha);

            if (linha not like '#%') then
                vNome  := trim(regexp_substr(linha, '[^;]+', 1, 1));
                vUF    := trim(regexp_substr(linha, '[^;]+', 1, 2));
                
                INSERT INTO Cidade
                     (idcidade   ,
                      Nome          ,
                      UF)
              VALUES
                     (sqCandidato.NextVal,
                      vNome          ,
                      vUF         );
         end if;

         -- Quando não encontrar nenhuma linha no arquivo irá gerar um EXCEPTION (no_data_found)
         EXCEPTION WHEN No_Data_Found THEN EXIT;
         end;

   END LOOP;

   IF UTL_FILE.IS_OPEN(arquivo) THEN
        UTL_FILE.FCLOSE(arquivo);
   END IF;

   -- AQUI PODE TER (RECOMENDADO) UM EXCEPTION PARA PREVER ERROS DE ACESSO AO ARQUIVO
END;
