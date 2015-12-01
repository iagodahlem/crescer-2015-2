package br.com.cwi.crescer.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO extends AbstractDAO {
	
	public Pedido findById(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> listAll() {
		return em.createQuery("FROM Pedido", Pedido.class)
                .getResultList();
	}
	
	public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido c WHERE c.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }
	
	public List<Pedido> listByCPFESituacao(String cpf, SituacaoPedido situacao) {
		StringBuilder sql = new StringBuilder("FROM Pedido p WHERE 1=1");

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		if (cpf != null) {
			sql.append(" AND p.cliente.cpf LIKE :cpf");
			parameters.put("cpf", cpf);
		}
		if (situacao != null) {
			sql.append(" AND p.situacao LIKE :situacao");
			parameters.put("situacao", situacao);
		}

		TypedQuery<Pedido> query = em.createQuery(sql.toString(), Pedido.class);

		Set set = parameters.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			query.setParameter(mentry.getKey().toString(), mentry.getValue());
		}
		
		return query.getResultList();
	}
	
	@Transactional
    public Pedido save(Pedido pedido) {

        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }

        return em.merge(pedido);
    }
	
}
