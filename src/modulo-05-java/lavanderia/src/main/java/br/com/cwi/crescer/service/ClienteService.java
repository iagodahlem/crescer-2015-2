package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

	private ClienteDAO clienteDAO;
	private CidadeDAO cidadeDAO;

	@Autowired
	public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
		this.clienteDAO = clienteDAO;
		this.cidadeDAO = cidadeDAO;
	}

	public List<ClienteResumoDTO> listarClientesAtivos() {

		List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);

		List<ClienteResumoDTO> clientesDTO = new ArrayList<ClienteResumoDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteResumoDTO(cliente));
		}

		return clientesDTO;
	}

	public List<ClienteResumoDTO> listarTodos() {

		List<Cliente> clientes = clienteDAO.listAll();

		List<ClienteResumoDTO> clientesDTO = new ArrayList<ClienteResumoDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteResumoDTO(cliente));
		}

		return clientesDTO;
	}
	
	public List<ClienteResumoDTO> listarPorNome(String nome) {

		List<Cliente> clientes = clienteDAO.listByNome(nome);

		List<ClienteResumoDTO> clientesDTO = new ArrayList<ClienteResumoDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteResumoDTO(cliente));
		}

		return clientesDTO;
	}

	public ClienteDTO buscarPorId(Long id) {
		return new ClienteDTO(clienteDAO.findById(id));
	}

	public void atualizar(ClienteDTO clienteDTO) {

		Cliente cliente = clienteDAO.findById(clienteDTO.getId());
		ClienteMapper.merge(clienteDTO, cliente);
		cliente.setCidade(cidadeDAO.findById(clienteDTO.getIdCidade()));
		cliente.setSituacao(clienteDTO.getSituacao());

		clienteDAO.save(cliente);
	}

	public void inserir(ClienteDTO clienteDTO) {

		Cliente cliente = ClienteMapper.getNewEntity(clienteDTO);
		cliente.setCidade(cidadeDAO.findById(clienteDTO.getIdCidade()));
		cliente.setSituacao(SituacaoCliente.ATIVO);

		clienteDAO.save(cliente);
	}

	public void remover(ClienteDTO clienteDTO) {
		Long id = clienteDTO.getId();
		if (id != null) {
			Cliente cliente = clienteDAO.findById(id);
			cliente.setSituacao(SituacaoCliente.INATIVO);
			clienteDAO.save(cliente);
		}
	}

	public List<SituacaoCliente> listarSituacoes() {
		List<SituacaoCliente> situacoes = new ArrayList<SituacaoCliente>();
		situacoes.add(SituacaoCliente.ATIVO);
		situacoes.add(SituacaoCliente.INATIVO);
		return situacoes;
	}

}
