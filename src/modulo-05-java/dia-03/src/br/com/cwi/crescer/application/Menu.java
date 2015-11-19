package br.com.cwi.crescer.application;

public class Menu {

	String quebraLinha = "\n";
	String divisao = "----------------------------------------";
	String header = "===== LAVANDERIA - INCLUIR PEDIDOS ===== ";
	String op1 = "1 - Incluir pedido selecionando um cliente existente";
	String op2 = "2 - Incluir pedido inserindo novo cliente";
	String op3 = "3 - Listar pedido(s) de determinado cliente";
	String op4 = "4 - Buscar pedido";
	
	public Menu() {
		StringBuilder menu = new StringBuilder();
		menu.append(header);
		menu.append(quebraLinha);
		menu.append(divisao);
		menu.append(quebraLinha);
		menu.append(op1);
		menu.append(quebraLinha);
		menu.append(op2);
		menu.append(quebraLinha);
		menu.append(op3);
		menu.append(quebraLinha);
		menu.append(op4);
		menu.append(quebraLinha);
		
		System.out.println(menu);
	}
	
}
