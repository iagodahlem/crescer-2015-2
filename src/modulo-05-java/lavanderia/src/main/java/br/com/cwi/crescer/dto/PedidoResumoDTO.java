package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoResumoDTO {
	
	private Long id;
	private String cpfCliente;
	private String nomeCliente;
	private Date dataInclusao;
	private BigDecimal valorTotal;
	private SituacaoPedido situacao;
	
	public PedidoResumoDTO() {
		
	}
	
	public PedidoResumoDTO(Pedido pedido) {
		this.id = pedido.getIdPedido();
		this.cpfCliente = pedido.getCliente().getCpf();
		this.nomeCliente = pedido.getCliente().getNome();
		this.dataInclusao = pedido.getDataInclusao();
		this.valorTotal = pedido.getValorFinal();
		this.situacao = pedido.getSituacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
}
