package br.com.cwi.crescer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/itens")
public class ItemController {

	private ItemService itemService;
	private PedidoService pedidoService;

	@Autowired
	public ItemController(ItemService itemService, PedidoService pedidoService) {
		this.itemService = itemService;
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping(path = "/processar/{id}", method=RequestMethod.GET)
	public ModelAndView processar(@PathVariable("id") Long id) {
		
		ItemDTO itemDTO = itemService.buscarPorId(id);
		itemService.processarItem(itemDTO);
		
		ModelAndView model = new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPorId(itemDTO.getIdPedido()));
		model.addObject("itens", itemService.listarItensPorIdPedido(itemDTO.getIdPedido()));
		return model;
	}
	
	@RequestMapping(path = "/processarTodos/{id}", method=RequestMethod.GET)
	public ModelAndView processarTodos(@PathVariable("id") Long id) {
		
		List<ItemDTO> itensDTO = itemService.listarItensPorIdPedido(id);
		itemService.processarTodosItens(itensDTO, id);
		
		ModelAndView model = new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPorId(id));
		model.addObject("itens", itemService.listarItensPorIdPedido(id));
		return model;
	}
	
}
