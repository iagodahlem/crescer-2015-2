package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDAO extends DAO {

	public CidadeDAO(EntityManager em) {
		super();
		super.em = em;
	}

	public Cidade findById(Long id) {
		return em.find(Cidade.class, id);
	}
}
