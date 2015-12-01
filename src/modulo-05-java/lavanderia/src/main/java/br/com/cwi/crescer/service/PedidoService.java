package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.PedidoResumoDTO;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;
	private ItemDAO itemDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO, ItemDAO itemDAO) {
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
		this.itemDAO = itemDAO;
	}

	public PedidoDTO buscarPorId(Long id) {
		return new PedidoDTO(pedidoDAO.findById(id));
	}
	
	public List<PedidoResumoDTO> listarTodos() {

		List<Pedido> pedidos = pedidoDAO.listAll();

		List<PedidoResumoDTO> pedidosResumoDTO = new ArrayList<PedidoResumoDTO>();
		for (Pedido pedido : pedidos) {
			pedidosResumoDTO.add(new PedidoResumoDTO(pedido));
		}

		return pedidosResumoDTO;
	}
	
	public List<PedidoResumoDTO> listarPorCPFESituacao(String cpf, SituacaoPedido situacao) {
		
		List<Pedido> pedidos = pedidoDAO.listByCPFESituacao(cpf, situacao);

		List<PedidoResumoDTO> pedidosResumoDTO = new ArrayList<PedidoResumoDTO>();
		for (Pedido pedido : pedidos) {
			pedidosResumoDTO.add(new PedidoResumoDTO(pedido));
		}

		return pedidosResumoDTO;
	}

	public Long inserirPedidoInicial(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();
		pedido.setCliente(clienteDAO.findById(pedidoDTO.getIdCliente()));
		pedido.setValorBruto(new BigDecimal("0"));
		pedido.setValorFinal(new BigDecimal("0"));
		pedido.setDataInclusao(new Date());
		pedido.setSituacao(SituacaoPedido.PENDENTE);

		pedidoDAO.save(pedido);

		return pedido.getIdPedido();
	}

	public void processar(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		BigDecimal valorDesconto = obterValorDesconto(pedido);
		pedido.setValorDesconto(valorDesconto);
		pedido.setValorFinal(calculaValorFinalPedido(pedido));
		pedido.setDataEntrega(calcularDataEntrega(pedido));
		pedido.setSituacao(SituacaoPedido.PROCESSANDO);
		
		pedidoDAO.save(pedido);
	}
	
	public void cancelarPedido(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		pedido.setSituacao(SituacaoPedido.CANCELADO);
		pedidoDAO.save(pedido);
	}
	
	public boolean todosOsItensProcessados(List<ItemDTO> itensDTO) {
		for (ItemDTO itemDTO : itensDTO) {
			if (itemDTO.getSituacao() != SituacaoItem.PROCESSADO) {
				return false;
			}
		}
		return true;
	}
	
	public List<ItemDTO> listarItensPorIdPedido(Long idPedido) {
		List<Item> itens =  itemDAO.findByIdPedido(idPedido);
		List<ItemDTO> itensDTO = new ArrayList<ItemDTO>();
		
		for(Item item : itens){
			itensDTO.add(new ItemDTO(item));
		}
		return itensDTO;
	}
	
	public void retirarPedido(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		
		List<ItemDTO> itensDTO = listarItensPorIdPedido(idPedido);
		if (todosOsItensProcessados(itensDTO)) {
			pedido.setSituacao(SituacaoPedido.ENCERRADO);
			pedidoDAO.save(pedido);
		}
	}
	
	public Date calcularDataEntrega(Pedido pedido) {
		List<Item> itens = pedido.getItens();
		
		Long prazo = 0L;
		Long maiorPrazo = 0L;
		
		for (Item item : itens) {
			prazo = item.getProduto().getPrazo();
			if (maiorPrazo > prazo) {
				prazo = maiorPrazo;
			}
		}
		
		Date dataEntrega = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataEntrega);
		
		int diasAMais = prazo.intValue();
		calendar.add(Calendar.DAY_OF_MONTH,diasAMais);
		
		dataEntrega = calendar.getTime();
		
		return dataEntrega;
	}

	public BigDecimal calculaValorFinalPedido(Pedido pedido) {

		BigDecimal valorDesconto = obterValorDesconto(pedido);
		
		List<Item> itens = pedido.getItens();
		BigDecimal valorFinal = pedido.getValorFinal();

		for (Item item : itens) {
			valorFinal = valorFinal.add(item.getValorTotal());
		}

		return valorFinal.subtract(valorDesconto);
	}

	public BigDecimal somarPesoTotalDosItens(Pedido pedido) {

		List<Item> itens = pedido.getItens();
		BigDecimal pesoTotal = new BigDecimal("0");
		for (Item item : itens) {
			pesoTotal.add(item.getPeso());
		}

		return pesoTotal;
	}

	public BigDecimal obterValorDesconto(Pedido pedido) {

		BigDecimal valorDesconto = new BigDecimal("0");
		BigDecimal valorTotalPedido = pedido.getValorBruto();

		BigDecimal percentual1 = new BigDecimal("0.08");
		BigDecimal percentual2 = new BigDecimal("0.0487");
		BigDecimal percentual3 = new BigDecimal("0.04");
		BigDecimal valorEspecificado = new BigDecimal("90");
		BigDecimal pesoEspecificado = new BigDecimal("15");
		BigDecimal somaTotalPesoItens = somarPesoTotalDosItens(pedido);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(pedido.getDataInclusao());

		int diaDaSemana = calendar.get(GregorianCalendar.DAY_OF_WEEK);
		diaDaSemana -= 1;

		if (diaDaSemana == diasDaSemana.SEGUNDA.ordinal() || diaDaSemana == diasDaSemana.TERCA.ordinal()
				|| diaDaSemana == diasDaSemana.QUARTA.ordinal()) {

			valorDesconto = valorTotalPedido.multiply(percentual1);
			return valorDesconto;
		} else if ((valorTotalPedido.compareTo(valorEspecificado) > 0)
				|| somaTotalPesoItens.compareTo(pesoEspecificado) > 0) {
			valorDesconto = valorTotalPedido.multiply(percentual2);
		} else if (diaDaSemana == diasDaSemana.QUINTA.ordinal() || diaDaSemana == diasDaSemana.SEXTA.ordinal()) {
			valorDesconto = valorTotalPedido.multiply(percentual3);
		}

		return valorDesconto;

	}

	public static enum diasDaSemana {
		DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO
	}
	
	public List<SituacaoPedido> listarSituacoes() {
		List<SituacaoPedido> situacoes = new ArrayList<SituacaoPedido>();
		
		situacoes.add(SituacaoPedido.CANCELADO);
		situacoes.add(SituacaoPedido.ENCERRADO);
		situacoes.add(SituacaoPedido.PENDENTE);
		situacoes.add(SituacaoPedido.PROCESSADO);
		situacoes.add(SituacaoPedido.PROCESSANDO);
		
		return situacoes;
	}

}
