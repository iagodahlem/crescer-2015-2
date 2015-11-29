package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTO {

	private Long id;
	
	private Long idMaterial;
	private String materialDescricao;
	
	private Long idServico;
	private String servicoDescricao;
	
	private BigDecimal valor;
	private Long prazo;
	private SituacaoProduto situacao;
	
	public ProdutoDTO() {
	}
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getIdProduto();
		this.idMaterial = produto.getMaterial().getIdMaterial();
		this.materialDescricao = produto.getMaterial().getDescricao();
		this.idServico = produto.getServico().getIdServico();
		this.servicoDescricao = produto.getServico().getDescricao();
		this.valor = produto.getValor();
		this.prazo = produto.getPrazo();
		this.situacao = produto.getSituacao();
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public SituacaoProduto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProduto situacao) {
		this.situacao = situacao;
	}
	
	public String getMaterialDescricao() {
		return this.materialDescricao;
	}
	
	public String getServicoDescricao() {
		return this.servicoDescricao;
	}

	public void setMaterialDescricao(String materialDescricao) {
		this.materialDescricao = materialDescricao;
	}

	public void setServicoDescricao(String servicoDescricao) {
		this.servicoDescricao = servicoDescricao;
	}
	
}
