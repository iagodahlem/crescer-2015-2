package br.com.cwi.crescer.application;

import java.sql.SQLException;
import java.util.Scanner;


public class App {

	public static void main(String[] args) throws SQLException {
		
		int operacao;
		Operations op = new Operations();
		Scanner scanner = new Scanner(System.in);
		
		Menu menu = new Menu();
		
		operacao = scanner.nextInt();
		
		if (operacao == 1) {
	    	op.selecionarCliente();
		}
		if (operacao == 2) {
			op.inserirCliente();
		}
		if (operacao == 3) {
			
		}
		if (operacao == 4) {
			
		}
		
	}

}
