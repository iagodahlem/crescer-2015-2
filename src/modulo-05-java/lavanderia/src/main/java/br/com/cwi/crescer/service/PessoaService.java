package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PessoaDAO;

@Service
public class PessoaService {

	private PessoaDAO pessoaDao;
	
	@Autowired
	public PessoaService(PessoaDAO pessoaDao) {
		super();
		this.pessoaDao = pessoaDao;
	}
	
	public String buscarNomeComLogica(Long id) {
		return null;
	}
}
