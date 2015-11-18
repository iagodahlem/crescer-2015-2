package br.com.cwi.crescer;

import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacao {

    public static void main(String[] args) throws SQLException {
    	
    	/*Cliente cliente = new Cliente();
    	cliente.setIdCliente(1L);
    	cliente.setNmCliente("Iago");
    	
    	ClienteDao clienteDao = new ClienteDao();
    	clienteDao.insert(cliente); */
    	
    	ClienteDao clienteDao = new ClienteDao();
    	
    	List<Cliente> list = clienteDao.listAll();
    	
    	for (Cliente cliente : list) {
    		System.out.println(cliente.getNmCliente());
    	}
    	
    	/*
    	try {
            Connection connection = new ConnectionFactory().getConnection(); 
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        */
    	
    	/*
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
    	*/
    	
    }
    
}
