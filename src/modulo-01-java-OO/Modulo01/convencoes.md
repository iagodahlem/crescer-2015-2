CONVENÇÕES PARA UTILIZAÇÃO NO PROJETO CRESCER 2015-02

Java

Classes
	Deve iniciar com letra maiúscula e camelCase. Exemplos:
		public class Elfo
		public class DataTerceiraEra

Métodos
	Deve iniciar com letra minúscula e camelCase. Exemplos:
		public void atirarEmDwaf()
		public void matarElfo()

Git
	Guideline baseada na documentação do angular
Commits
	Toda mensagem de commit consiste num Type, Scope, e Subject

	Types:

	feat: Nova feature
	fix: Correção de um bug
	docs: Apenas modificações em documentação
	style: Alterações que não afetam o significado do código (de espaço em branco, formatação, faltando ponto e vírgula, etc)
	refactor: Uma alteração de código que não corrige bug nem adiciona uma nova feature
	perf: Uma mudança no código que reflete na performance
	test: Adição de testes
	chore: Alterações no processo de construção ou ferramentas auxiliares e bibliotecas, tais como geração de documentação

	Scope:
	O scope deve ter qualquer coisa especificando o local de mudança do commit

	Subject:
	O subject contêm descrições sucintas da mudança:
		Usar o imperativo, tempo presente: "mudança", não "mudou", nem "mudanças"
		Não utilizar primeira letra maiúscula
		Não utilizar ponto (.) no final da descrição 