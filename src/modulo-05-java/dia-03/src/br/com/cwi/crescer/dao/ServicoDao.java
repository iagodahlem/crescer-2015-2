package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {
	
	public void insert(Servico servico) throws SQLException {

		Servico novoServico = new Servico();
		Long id = novoServico.getIdServico();
		String descricao = novoServico.getDsServico();
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			PreparedStatement statement = connection.prepareStatement(" insert into servico (idServico, dsServico) values (?, ?) ");
			statement.setLong(1, id);
			statement.setString(2, descricao);
			
			statement.execute();
			
		} 
		catch (SQLException e) {
			throw e;
		}
	}
	
	public List<Servico> listAll() throws SQLException {
		List<Servico> list = new ArrayList<Servico>();
		
		try(Connection connection = new ConnectionFactory().getConnection();) {
			String query = "select idServico, dsServico from servico";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Servico servico  = new Servico();
				servico.setIdServico(resultSet.getLong(1));
		    	servico.setDsServico(resultSet.getString(2));
		    	
		    	list.add(servico);
			}
		}
		catch(SQLException e) {
			throw e;
		}
		return list;
	}
	
}
