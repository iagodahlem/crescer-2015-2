package br.com.cwi.crescer.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO {

	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}
	
	public Produto findByMaterialEServico(String material, String servico) {
		return em.createQuery("FROM Produto p WHERE p.material.descricao = :material AND "
				+ "p.servico.descricao = :servico", Produto.class)
				.setParameter("material", material)
				.setParameter("servico", servico)
				.getSingleResult();
	}

	public List<Produto> listAll() {
		return em.createQuery("FROM Produto", Produto.class).getResultList();
	}
	
	public List<Produto> listByServico(Long id) {
		return em.createQuery("FROM Produto p WHERE p.servico.idServico = :id", Produto.class)
				.setParameter("id", id)
				.getResultList();
	}

	public List<Produto> listByMaterialEServico(String material, String servico) {
		StringBuilder sql = new StringBuilder("FROM Produto p WHERE 1=1");

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		if (material != null) {
			sql.append(" AND p.material.descricao LIKE :material");
			parameters.put("material", material);
		}
		if (servico != null) {
			sql.append(" AND p.servico.descricao LIKE :servico");
			parameters.put("servico", servico);
		}

		TypedQuery<Produto> query = em.createQuery(sql.toString(), Produto.class);

		Set set = parameters.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			query.setParameter(mentry.getKey().toString(), mentry.getValue() + "%");
		}
		
		return query.getResultList();
	}

	@Transactional
	public Produto save(Produto produto) {

		if (produto.getIdProduto() == null) {
			em.persist(produto);
			return produto;
		}

		return em.merge(produto);
	}

}
