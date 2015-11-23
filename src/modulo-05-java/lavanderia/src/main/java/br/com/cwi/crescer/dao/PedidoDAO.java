package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;

@Repository
public class PedidoDAO extends DAO {

	public PedidoDAO(EntityManager em) {
		super();
		super.em = em;
	}
	
	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
}
