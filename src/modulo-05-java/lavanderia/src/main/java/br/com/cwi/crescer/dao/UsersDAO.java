package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enabled;

@Repository
public class UsersDAO extends AbstractDAO {

	public Users findByUsername(String nome) {
		return em.find(Users.class, nome);
	}
	
	public List<Users> findByEnabled(Enabled enabled) {
		return em.createQuery("FROM Users u WHERE u.enabled = :enabled", Users.class)
				.setParameter("enabled", enabled)
				.getResultList();
	}
	
    @Transactional
    public Users save(Users user) {

        if (user.getUsername() == null) {
            em.persist(user);
            return user;
        }

        return em.merge(user);
    }
    
    @Transactional
    public void delete(String nome) {
    	em.remove(em.getReference(Users.class, nome));
    }
    
}
