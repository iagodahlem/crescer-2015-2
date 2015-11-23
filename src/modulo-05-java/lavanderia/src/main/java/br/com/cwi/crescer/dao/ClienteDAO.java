package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDAO extends AbstractDAO {

	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
}
