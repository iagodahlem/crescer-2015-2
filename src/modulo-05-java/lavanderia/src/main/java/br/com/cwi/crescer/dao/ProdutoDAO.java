package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends DAO {

	public ProdutoDAO(EntityManager em) {
		super();
		super.em = em;
	}
	
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}
}
