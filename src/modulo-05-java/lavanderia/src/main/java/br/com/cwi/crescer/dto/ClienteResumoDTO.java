package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;

public class ClienteResumoDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String situacao;
	
	public ClienteResumoDTO() {

	}
	
	public ClienteResumoDTO(Cliente cliente) {
		this.id = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.situacao = cliente.getSituacao().toString();
	}	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
