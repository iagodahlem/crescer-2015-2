package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

	public int insert(Pedido pedido) throws SQLException {
		
		Long idCliente = pedido.getIdCliente();
		String descricao = pedido.getDsPedido();
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			String sql = " insert into pedido (idPedido, idCliente, dsPedido) values (pedido_seq.nextval, ? ,?) ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idCliente);
			statement.setString(2, descricao);
			
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public int update(Pedido pedido) throws SQLException {
		
		Long idPedido = pedido.getIdPedido();
		Long idCliente = pedido.getIdCliente();
		String descricao = pedido.getDsPedido();
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			String sql = " update pedido set idCliente = ?, dsPedido = ? where idPedido = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idCliente);
			statement.setString(2, descricao);
			statement.setLong(3, idPedido);
			
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public int delete(Long idPedido) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {

			String sql = " delete from pedido where idPedido = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idPedido);
			
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public Pedido load(Long idPedido) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {

			Pedido pedido = new Pedido();
			
			String sql = " select idPedido, idCliente, dsPedido from pedido where idPedido = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idPedido);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				pedido.setIdPedido(resultSet.getLong(1));
				pedido.setIdCliente(resultSet.getLong(2));
				pedido.setDsPedido(resultSet.getString(3));
			}
			else {
				throw new RuntimeException("Registro não encontrado.");
			}
			
			return pedido;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	
	public List<Pedido> listByCliente(Long idCliente) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			
			List<Pedido> pedidos = new ArrayList<Pedido>();			
			
			String sql = " select idPedido, idCliente, dsPedido where idCliente = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, idCliente);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Pedido pedidoEncontrado = new Pedido();
		    	pedidoEncontrado.setIdPedido(resultSet.getLong(1));
		    	pedidoEncontrado.setIdCliente(resultSet.getLong(2));
		    	pedidoEncontrado.setDsPedido(resultSet.getString(3));
		    	
		    	pedidos.add(pedidoEncontrado);
			}
			
			return pedidos;
		}
		catch(SQLException e) {
			throw e;
		} 
	}
	
}
