package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Item;

@Repository
public class ItemDAO extends DAO {

	public ItemDAO(EntityManager em) {
		super();
		super.em = em;
	}
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
}