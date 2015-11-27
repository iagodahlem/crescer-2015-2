package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO extends AbstractDAO {

	public Cliente findById(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> listAll() {
		return em.createQuery("FROM Cliente", Cliente.class)
                .getResultList();
	}
	
	public List<Cliente> findBySituacao(SituacaoCliente situacao) {
		return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}
	
	public List<Cliente> listByNome(String nome) {
		return em.createQuery("FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
				.setParameter("nome", nome + "%")
				.getResultList();
	}
	
    @Transactional
    public Cliente save(Cliente cliente) {

        if (cliente.getIdCliente() == null) {
            em.persist(cliente);
            return cliente;
        }

        return em.merge(cliente);
    }
    
    @Transactional
    public void delete(Long id) {
    	em.remove(em.getReference(Cliente.class, id));
    }
	
}
