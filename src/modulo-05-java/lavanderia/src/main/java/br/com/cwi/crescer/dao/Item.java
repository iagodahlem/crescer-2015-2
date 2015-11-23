package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class Item extends DAO {

	public Item(EntityManager em) {
		super();
		super.em = em;
	}
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
}
