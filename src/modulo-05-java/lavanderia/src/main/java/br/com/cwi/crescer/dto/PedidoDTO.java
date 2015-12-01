package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDTO {

	private Long id;
	private Cliente cliente;
	private Long idCliente;
	private Date dataInclusao;
	private Date dataEntrega;
	private BigDecimal valorBruto;
	private BigDecimal valorDesconto;
	private BigDecimal valorTotal;
	private SituacaoPedido situacao;
	private List<Item> itens;
	
	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getIdPedido();
		this.cliente = pedido.getCliente();
		this.idCliente = pedido.getCliente().getIdCliente();
		this.dataInclusao = pedido.getDataInclusao();
		this.valorTotal = pedido.getValorFinal();
		this.itens = pedido.getItens();
		this.dataEntrega = pedido.getDataEntrega();
		this.valorBruto = pedido.getValorBruto();
		this.valorDesconto = pedido.getValorDesconto();
		this.situacao = pedido.getSituacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
}
