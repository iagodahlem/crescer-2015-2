package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "Pessoa")
public class Pessoa {
	
	public static final String SEQUENCE_NAME = "pessoa_seq";

	@Id
	@Column(name = "IDPessoa")
	private Long idPessoa;
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "IDEndereco", length = 10)
	private String idEndereco;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
}
