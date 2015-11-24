package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteResumoDTO;

@Service
public class ClienteService {

	private ClienteDAO clienteDAO;

	@Autowired
	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public List<ClienteResumoDTO> listarClientesAtivos() {
		
		List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
		
		List<ClienteResumoDTO> clientesDTO = new ArrayList<ClienteResumoDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteResumoDTO(cliente));
		}
		
		return clientesDTO;
	}
	
}
