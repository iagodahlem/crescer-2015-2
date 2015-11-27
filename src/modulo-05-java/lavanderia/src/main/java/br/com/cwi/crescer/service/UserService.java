package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.AuthoritiesDAO;
import br.com.cwi.crescer.dao.UsersDAO;
import br.com.cwi.crescer.domain.Authorities;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enabled;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.dto.UserDTO;

@Service
public class UserService {

	private UsersDAO usersDAO;
	private AuthoritiesDAO authsDAO;

	@Autowired
	public UserService(UsersDAO usersDAO, AuthoritiesDAO authsDAO) {
		this.usersDAO = usersDAO;
		this.authsDAO = authsDAO;
	}

	public List<UserDTO> listarUsuariosAtivos() {
		
		List<Authorities> auths = authsDAO.listAll();

		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (Authorities auth : auths) {
			String username = auth.getAuthoritiesID().getUsername().getUsername();
			String flag = auth.getAuthoritiesID().getAuthority();
			usersDTO.add(new UserDTO(username, flag));
		}

		return usersDTO;
	}
	
}
