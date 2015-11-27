package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Authorities;
import br.com.cwi.crescer.domain.AuthoritiesID;

@Repository
public class AuthoritiesDAO extends AbstractDAO {

	public Authorities findById(AuthoritiesID authsID) {
		return em.find(Authorities.class, authsID);
	}
	
	public List<Authorities> listAll() {
        return em.createQuery("FROM Authorities", Authorities.class)
                .getResultList();
    }
	
}
