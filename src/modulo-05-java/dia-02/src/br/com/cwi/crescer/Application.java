package br.com.cwi.crescer;

import java.util.List;
import java.util.Scanner;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

public class Application{

    public static void main(String[] args) throws SQLException {
    	
    	Console console = System.console();
    	Scanner scanner = new Scanner(System.in);
    	
    	int operacao;
    	
    	String quebraDeLinha = "\n";
    	StringBuffer menu = new StringBuffer();
    	menu.append("===== Console App - Iago =====" + quebraDeLinha);
    	menu.append("1 - LinkedList" + quebraDeLinha);
    	menu.append("2 - DoublyLinkedList" + quebraDeLinha);
    	menu.append("3 - IO" + quebraDeLinha);
    	menu.append("4 - Sair" + quebraDeLinha);
    	
    	System.out.println(menu);

    	operacao = scanner.nextInt();
    	
    	if (operacao == 1) {
    		
    	} else if (operacao == 2) {
    		
    	} else if (operacao == 3) {
    		
    	} else {
    		
    	}
    	
    }
    
}
