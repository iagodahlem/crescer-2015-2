package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
public class Cidade {

	@Id
	@Column(name = "IDCidade")
	private long idCidade;
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "UF")
	@Basic(optional = false)
	private String uf;
}
