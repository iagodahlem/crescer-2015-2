package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ItemDTO;

@Service
public class ItemService {

	private ItemDAO itemDAO;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
		this.itemDAO = itemDAO;
		this.pedidoDAO = pedidoDAO;
		this.produtoDAO = produtoDAO;
	}
	
	public ItemDTO buscarPorId(Long id) {
		return new ItemDTO(itemDAO.findById(id));
	}
	
	public List<ItemDTO> listarItensPorIdPedido(Long idPedido) {
		List<Item> itens =  itemDAO.findByIdPedido(idPedido);
		List<ItemDTO> itensDTO = new ArrayList<ItemDTO>();
		
		for(Item item : itens){
			itensDTO.add(new ItemDTO(item));
		}
		return itensDTO;
	}
	
	public BigDecimal getValorTotalItem(Item item) {
		BigDecimal valorUnitarioItem = item.getValorUnitario();
		BigDecimal pesoItem = item.getPeso();
		
		return valorUnitarioItem.multiply(pesoItem);
	}
	
	public void inserir(ItemDTO itemDTO) {
		Item item = new Item();
		Pedido pedido = pedidoDAO.findById(itemDTO.getIdPedido());
		Produto produto = produtoDAO.findById(itemDTO.getIdProduto());
		
		item.setPedido(pedido);
		item.setPeso(itemDTO.getPeso());
		item.setProduto(produto);
		item.setValorUnitario(produto.getValor());
		item.setValorTotal(getValorTotalItem(item));
		item.setSituacao(SituacaoItem.PENDENTE);
		itemDAO.save(item);
	}
	
	public void processaPedido(Long idPedido) {
		Pedido pedido = pedidoDAO.findById(idPedido);
		pedido.setSituacao(SituacaoPedido.PROCESSADO);
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
	
	public void processarItem(ItemDTO itemDTO) {
		Item item = itemDAO.findById(itemDTO.getId());
		item.setSituacao(SituacaoItem.PROCESSADO);
		itemDAO.save(item);
		
		List<ItemDTO> itensDTO = listarItensPorIdPedido(itemDTO.getIdPedido());
		
		if (todosOsItensProcessados(itensDTO)) {
			processaPedido(itemDTO.getIdPedido());
		}
	}
	
	public void processarTodosItens(List<ItemDTO> itensDTO, Long idPedido) {
		for (ItemDTO itemDTO : itensDTO) {
			Item item = itemDAO.findById(itemDTO.getId());
			item.setSituacao(SituacaoItem.PROCESSADO);
			itemDAO.save(item);
		}
		processaPedido(idPedido);
	}
	
}
