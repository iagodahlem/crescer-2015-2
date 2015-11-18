Dia-01
	
	Class anonymous
		Declarar um objeto no qual se deseja herdar métodos para sobrescrever. Ex:

		Objeto objeto = new Objeto() {
			
			public metodoSobreescrito() {
				//override
			}
		};

	Inherited class
		Declarar uma nova classe dentro da classe na qual vai ser exclusivamente utilizada

	Tratamento de Excessões
		Criar proprias execeções
			Bussiness exception
			Utilizado para regras de negocio especificas

		Checked / Unchecked Exception
		RuntimeException

	Generics
		<T><E>

Dia-02

	IO
		java.io

		File file = new File("caminho diretorio ou arquivo");

		Leitura de Arquivos
			readerbuffer
			scanner
			nio

	JDBC
		java.sql

		Connection conexao = DriverManager.getConnection("string conexao")
