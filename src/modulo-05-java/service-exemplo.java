package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	//private PessoaDAO pessoaDao;
	
	@Autowired
	public PessoaService() {
		super();
		//this.pessoaDao = pessoaDao;
	}
	
	public String buscarNomeComLogica(Long id) {
		return null;
	}
}