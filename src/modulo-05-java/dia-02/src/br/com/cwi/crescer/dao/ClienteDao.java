package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {

	public void insert(Cliente cliente) throws SQLException {
		
		Cliente novoCliente = cliente;
		Long id = cliente.getIdCliente();
		String nome = cliente.getNmCliente();
		String cpf = cliente.getNrCPF();
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			//Statement stmt = connection.createStatement();
			//stmt.execute(" insert into cliente (idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ") ");
			
			PreparedStatement statement = connection.prepareStatement(" insert into cliente (idCliente, nmCliente, nrCpf) values (?, ? ,?) ");
			statement.setLong(1, id);
			statement.setString(2, nome);
			statement.setString(3, cpf);
			
			statement.execute();
			
		} 
		catch (SQLException e) {
			throw e;
		}
	}
	
	public List<Cliente> listAll() throws SQLException {
		List<Cliente> list = new ArrayList<Cliente>();
		
		try(Connection connection = new ConnectionFactory().getConnection();) {
			String query = "select idCliente, nmCliente, nrCpf from cliente";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong(1));
		    	cliente.setNmCliente(resultSet.getString(2));
		    	cliente.setNrCPF(resultSet.getString(3));
		    	
		    	list.add(cliente);
			}
			
		}
		catch(SQLException e) {
			throw e;
		}
		return list;
	}
	
}
