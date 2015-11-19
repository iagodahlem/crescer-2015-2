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

	public int insert(Cliente cliente) throws SQLException {
		
		String nome = cliente.getNmCliente();
		String cpf = cliente.getNrCPF();
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			String sql = " insert into cliente (idCliente, nmCliente, nrCpf) values (cliente_seq.nextval, ? ,?) ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, cpf);
			
			return statement.executeUpdate();
		} 
		catch (SQLException e) {
			throw e;
		}
	}
	
	public int update(Cliente cliente) throws SQLException {
		
		Long id = cliente.getIdCliente();
		String nome = cliente.getNmCliente();
		String cpf = cliente.getNrCPF();
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			String sql = " update cliente set nmCliente = ?, nrCpf = ? where idcliente = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, cpf);
			statement.setLong(3, id);
			
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public int delete(Long idCliente) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			String sql = (" delete from cliente where idcliente = ? ");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idCliente);
			
			return statement.executeUpdate();
		}
		catch (SQLException e){
			throw e;
		}
	}
	
	public Cliente load(Long idCliente) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			Cliente cliente = new Cliente();
			
			String sql = " select idcliente, nmcliente, nrcpf from cliente where idcliente = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idCliente);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				cliente.setIdCliente(resultSet.getLong(1));
				cliente.setNmCliente(resultSet.getString(2));
				cliente.setNrCPF(resultSet.getString(3));
			}
			else {
				throw new RuntimeException("Registro não encontrado.");
			}
			
			return cliente;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public Cliente loadByName(String nome) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			Cliente cliente = new Cliente();
			
			String sql = " select idcliente, nmcliente, nrcpf from cliente where nmcliente = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				cliente.setIdCliente(resultSet.getLong(1));
				cliente.setNmCliente(resultSet.getString(2));
				cliente.setNrCPF(resultSet.getString(3));
			}
			else {
				throw new RuntimeException("Registro não encontrado.");
			}
			
			return cliente;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public List<Cliente> find(Cliente cliente) throws SQLException {
		
		Long id = cliente.getIdCliente();
		String nome = cliente.getNmCliente();
		String cpf = cliente.getNrCPF();
		
		boolean idNotNull = id != null ? true : false;
		boolean nomeNotNull = nome != null ? true : false;
		boolean cpfNotNull = nome != null ? true : false;
		
		List<Cliente> clientesEncontrados = new ArrayList<Cliente>();
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			StringBuilder sql = new StringBuilder(" select nmcliente, nrcpf from cliente where 1=1 ");
			List<Object> parameters = new ArrayList<Object>();
			
			if (nomeNotNull) {
				sql.append(" and nmcliente = ? ");
				parameters.add(nome);
			}
			if (cpfNotNull) {
				sql.append(" and nrcpf = ? ");
				parameters.add(cpf);
			}
			if (idNotNull) {
				sql.append(" and idcliente = ? ");
				parameters.add(id);
			}
			
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			
			for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Cliente clienteEncontrado = new Cliente();
				clienteEncontrado.setIdCliente(resultSet.getLong(1));
		    	clienteEncontrado.setNmCliente(resultSet.getString(2));
		    	clienteEncontrado.setNrCPF(resultSet.getString(3));
		    	clientesEncontrados.add(clienteEncontrado);
			}
			
			return clientesEncontrados;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public List<Cliente> listAll() throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()) {
			
			List<Cliente> list = new ArrayList<Cliente>();
			
			String sql = "select idCliente, nmCliente, nrCpf from cliente";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong(1));
		    	cliente.setNmCliente(resultSet.getString(2));
		    	cliente.setNrCPF(resultSet.getString(3));
		    	
		    	list.add(cliente);
			}
			
			return list;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
}
