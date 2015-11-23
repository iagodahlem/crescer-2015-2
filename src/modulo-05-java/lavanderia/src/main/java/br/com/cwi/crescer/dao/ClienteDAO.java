package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDAO extends DAO {

	public ClienteDAO(EntityManager em) {
		super();
		super.em = em;
	}

	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
}
