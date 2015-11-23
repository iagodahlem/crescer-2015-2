package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDAO extends DAO {
	
	public MaterialDAO(EntityManager em) {
		super();
		super.em = em;
	}
	
	public Material findById(Long id) {
		return em.find(Material.class, id);
	}
}
