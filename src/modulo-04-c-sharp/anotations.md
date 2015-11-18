.NET Framework - Plataforma da Microsoft
--------------

ASP.NET

MVC


-----------------
convenções

atributos privados
propriedades public

atributo pascal
métodos e propriedades camel

-----------------

modifiers

public 
internal

-----------------

TIPOS DE DADOS

Tipos primitivos

	Tipos Inteiros
		short, int, long 
		Int16, Int32, Int64
		ushort, uint, ulong

	Tipos pontos flutuantes
		float, double, decimal

	String
	 String, string

Tipos Referencia - Objeto valor

	Array
		Utilizado quando se precisa apenas iterar elementos.
		int[] arrai = new int[tamanho];
		string[] arraiInicializado = { "texto1", "texto2" };

	Lista
		List<int> lista = new List<int>();

		var lista = new List<int>()
		{
			1, 2, 3
		};

	Dictionary 
		var diasDaSemana = Dictionary<int//tipovalor key, string//tipovalor value>();
		diasDaSemana[key];

		// Métodos
		diasDaSemana.Add(1, "Domingo");
		diasDaSemana.ContainsKey(key); // retorna booleano

		var diasDaSemana = Dictionary<string, Dictionary<string, string>>();

Classes

	Enum
		public enum MeuEnum
		{
			Filho = 0,
			Pai   = 1
		}

	// Sempre inicialiar enum com valor

Objetos anonimos

	// Objeto anonimo é imutavel
	var pessoa = new 
	{
		Id = 1,
		Nome = "Iago"
	};

DateTime
	// mes começa em 1
	var data = new DateTime(2015, 1, 25); //ano, mes, dia

	data.Add(new TimeSpan());
	data.AddMonth(3);

	DateTime.Now; // Propriedade estatica que retornar a hora atual

	var diff = DateTime.Now - DateTime.Now.AddDays(-1); // Retorna TimeSpan - Intervalo de tempo
	var diff = (DateTime.Now - DateTime.Now.AddDays(-1)).Days;

Dynamic
	
	// Estrutura de dados dinamica que ocupa bastante memoria
	dynamic num = 1;
	num = "abc";


	public void Exemplo(int? id) 
	{

	}

-----------------

Métodos

	Estático
		Cria em runtime, sem instancias ou objetos

	Objeto

-----------------

OO C Sharp

Classe abstrata

	public abstract class Robo
	{
		public string Nome { get; private set; }

		public Robo(string nome)
		{
			this.Nome = nome;
		}

		// para fazer override de um método pai para filho é preciso lhe dar permissões com o 'virtual' na declaração do método
		public virtual void Atacar()
		{
		
		}

		// Obrigar que uma classe filha tenho um método do pai usa o 'abstract'
		public || protected abstract void Defender()
		{

		}
	}

Herança

	// Mercurio herda de Robo

	public class Mercurio : Robo, IVoar
	{
		// Construtor herdado do pai Robo
		public Mercurio(string nome) : base(nome)
		{
			// java
			// super(nome);
		}

		public override void Atacar()
		{
			// base.Atacar();
		}

		protectd override Defender()
		{
			
		}

		public void Avoa()
		{
			
		}

		public void Explodir()
		{
			
		}
	}


Interface

	public interface IVoar : IExplodable
	{
		void Avoa();
	}

	public interface IExplodable
	{
		void Explodir();
	}

Selead
	// Definindo uma classe com selead ninguem pode herdala ou assinar contrato, java é final

-----------------

Link e Lambda

	Lambda

		int[] arrai = { 1, 2, 3, 4};

		bool temNumero3 = false;
		temNumero3 = arrai.Any(item => item == 3);

		int numero3 = arrai.First(item => item == 3);
		int numero3 = arrai.FirstOfDefault(item => item == 3);
		int numero3 = arrai.Last(item => item == 3);

		long[] todosOsNumeros3 = arrai.Where(item => item == 3).ToArray();
	
	Link
		
		var query = from funcionario in funcionarios
					where funcionario.Id = id
					select funcionario;

		return query.FirstOfDefault();

-----------------

Trabalhando com Arquivos

	classe file
	using system io

Recursos gerenciaveis 
Recursos não gerenciaveis

-----------------

Conexao com Banco

using

IDisposable

transactionScope

DBNull.Value


repositorios

Generics

migrations

-----------------

Params
	Permite apenas arrays

	private void Metodo(params int[] arrayIds) 
	{

	}

Optional parameters
	Passa valor default caso o método seja chamado vazio

	Class A { }
	
	private void Metodo(A a = null) 
	{
	
	}

Convert
	var mensagem = "aslçdkjf";

	var inteiro = Convert.ToInt32(mensagem);
	var inteiroComCast = Int32.Parse(mensagem);

	int inteiroComCast2 = int.MaxValue;
	// Retorna -1
	short valorShort = (short)inteiroComCast2;

Dynamic
	igual ao var do JavaScript

Anounymos Type
	cria uma nova classe anonima static, sem poder alterar os valores
	var tipoAnonimo = new { Id = 0, Nome = "" };

ExpandoObject

	dynamic a = new ExpandoObject()
	a.Nome = "";
	a.Id = 0;

Dictionary

Value Type (Tipos primitivos)
	passa uma cópia do valor

Reference Type
	passa uma referencia do valor

Garbage Collector
	Faz o desalocamento de referencias na heap, e cuida das varias na stack

-----------------

MVC
	Asp.NET MVC
	Pattern para arquitetura Front-End no visual studio com C#

	Model
		Dados (Para transitar entre View e Controller) - Apenas regra de negócio e informações para a View
		
	View
		Visão (HTML)
		
	Controller
		Servidor (Controlador das Views e Models) - Lógica - Tecnologia
			Actions

	Razor
		@: Texto
		<text></text>
		
		Helpers
			@Html.Raw()
			@Html.ActionLink("textoLink", "action", "controller") objectValues
			@Url.Action("actionName", "controller")
			@Url.Content()

			@RenderSection("name", false = required)
			@section Scripts || Styles {
				referencias...
			}

			@Html.Partial("nome da partialView", @model)

			
			
			@Html.TextBox("name", "value", attributes)
			@Html.TextBoxFor(model => model.Nome)

			@Html.AntiForgetToken()
			[ValidateAntityForgetToken]
			@ValidationSummary();

			DataNotation atributos nas propriedades
			[DisplayName("nome")]
			[Required]
			[StringLength(ErrorMessage = "mensagem")]
			[Range(typeof(tipo), min, max)]
			[RegularExpression()]
			[Compare("propriedade a comparar")]

			utilizar using

			@using (@Html.BeginForm("action", "controller", FormMethod.Post||Get new { @class = "class" }))
			{

			}

			@Enum.DropDownListFor()

	Routes
		
	Area
		
	QueryString
		$parametro=valor


	Partial View

	Bundles
		Minificação e Concatenação de Resources CSS e JavaScript

	web.config - namespaces

	ModelState.IsValid

	Pacote de validações client side ASP.Net MVC
		Install-Package jQuery.Validation.Unobtrusive

------------

ORM - Frameworks para acesso a banco de dados

	Entity Framework

	DataBaseFirst
		Install-Package EntityFramework

		Adicionar connectionString após 'configSection'

		Criar classe de BandeDeDados

		criar DbSet para entdades a serem mapeadaas

		criar classe de mapeamento

			HasKey para chaves
			Property(propriedade => propriedade.PropriedadeNome) para propriedades

			relacionamentos - HasRequired(); .WithOptional().Map(m => MapKey("id da coluna que cuida da FK"));
			WithOptional() - para dizer que o relacionamento é opcional

			ignore

			override void OnModelCreating(DbM)

			hascolumnname("nome da coluna no banco")

			ToTable("nome da tabela no banco"); // diz qual tabela deve ser utilizada

		para usar o banco
			using(var db = new BancoDeDados())
			{
				// Pesquisar

				// Pesquisar com referencia
					Objeto objeto = db.Include

				
				// Adicionar registro
					Cliente cliente =  new Cliente()
					{
						Nome = "Iago";
					};

					db.Entry(cliente).State = System.DAta.Entity.EntityState.Added;

					db.SaveChanges();

				// Alterar

					Cliente cliente = db.Cliente.Find(2);
	
					cliente.Nome = "nome diferente";

					// para todas as colunas
					db.Entry(cliente).State = System.DAta.Entity.EntityState. ? ;

					// para colunas especificas
					db.Entry(cliente).Property(p => p.Nome).IsModified = true;

					db.SaveChanges();

				// Deletar

					Cliente cliente = db.Cliente.Find(2);

					db.Entry(cliente).State = System.DAta.Entity.EntityState.Deleted;

					db.SaveChanges();
			}

	CodeFirst

		Migrations
			Versões da base - Versionamento do banco

		Configurações
			Via PK
				Enable-Migrations
				Add-Migration "nome da versão da migration"
				Update-Database
				Update-Database -Script
				retorna pra versão determinada: Update-Database -TargetMigration "nome da versão"

	Pacotes
		Deve ter instalado quem define e quem consome

------------

Autenticação e Segurança
	
	Autenticação - ter acesso a alguma coisa, estar apto a acessar tal coisa, ter acesso a parte privada

	Autorização - estando autenticado o que eu tenho acesso

	Padrões de autenticação
		oauth

	Atributos
		[Authorize] - utilizado na controller ou na action
		[AllowAnonymous] - permite que uma action possa ser visto por qualquer pessoa
		[Authorize(Roles = "nome do papel, identidade")]

	Métodos
		FormsAutenthication.SetAuthCokie(usuario, true);
		Session[""];

	para autenticar
		adicionar tag autenthication no web.config dentro da tag 'system.web'

		<autenticathion mode="forms">
			<forms loginUrl="" timeout="20"></forms>
		</autenticathion>

	Session
		Biblioteca pessoal

	para autorizar
		criar filters
		classe autorizador que herda de 'autorize attibrute'

		override onautorization
			var identidade = new GenericIdentity("identificador");
			string[] roles = {"Master", "Identidade1", "Identidade2"};
			var principal = new GenericPrincipal(identidade, roles);

			thread.CurrentPrincipal = principal;
			httpContext.Current.User = principal;
		
		criar model usuarioLogado
		criar model pra sessao

		prop usuario private set
		prop string[] permissoes private set

		ctor (usuario, permissoes)

		só pode ver os detalhes quem tiver permissões


		duas base controller 'externa' 'interna'


	Domain.Services
		retornar usuario por autenticação

		algoritmo de criptografia

		MD5 com SALT - ********* Pesquisar *********


Model e ViewModel
	model - classe que agrupa dados que não vão para uma View



AjaxBeginForm

EditorTemplates