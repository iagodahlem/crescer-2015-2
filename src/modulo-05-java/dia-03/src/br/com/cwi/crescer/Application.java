package br.com.cwi.crescer;

import java.util.List;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.*;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

public class Application{

    public static void main(String[] args) throws SQLException {
    	
    	ClienteDao clienteDao = new ClienteDao();
    	
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(1L);
    	cliente.setNmCliente("Iago 2");
    	
    	Cliente cliente2 = new Cliente();
    	cliente2.setIdCliente(2L);
    	cliente2.setNmCliente("Iago 2");
    	
    	List<Cliente> list = clienteDao.find(cliente);
    	for (Cliente clienteEncontrado : list) {
    		System.out.println(clienteEncontrado.getNmCliente());
    	}
    	
    	/*
    	try {
            Connection connection = new ConnectionFactory().getConnection(); 
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        */
    	
    }
    
}
