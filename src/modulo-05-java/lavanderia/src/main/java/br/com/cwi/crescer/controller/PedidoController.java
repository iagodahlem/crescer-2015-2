package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ClienteService clienteService;
	private ItemService itemService;
	private ServicoService servicoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService, 
			ClienteService clienteService, 
			ServicoService servicoService,
			ItemService itemService) {
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.itemService = itemService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodos());
	}
	
	@RequestMapping(path = "/listarPorCPFESituacao", method = RequestMethod.GET)
	public ModelAndView listarPorCPFESituacao(@RequestParam("cpf") String cpf,
			@RequestParam("situacao") SituacaoPedido situacao) {
		return new ModelAndView("pedido/lista", "pedidos",
				pedidoService.listarPorCPFESituacao(cpf, situacao));
	}
	
	private List<ItemDTO> listaItens(Long idPedido){
		return itemService.listarItensPorIdPedido(idPedido);
	}
	
	@RequestMapping(path = "/{id}", method=RequestMethod.GET)
	public ModelAndView viewExibe(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPorId(id));
		model.addObject("itens", listaItens(id));
		return model;
	}
	
	@RequestMapping(path = "/inserir", method=RequestMethod.GET)
    public ModelAndView viewInsere() {
        return new ModelAndView("pedido/insere", "pedido", new PedidoDTO());
    }
	
	@RequestMapping(path = "/inserir", method=RequestMethod.POST)
    public ModelAndView inserir(@Valid @ModelAttribute("pedido") PedidoDTO pedidoDTO) {
		Long idPedido = pedidoService.inserirPedidoInicial(pedidoDTO);
		
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setIdPedido(idPedido);
		
		return new ModelAndView("pedido/insereItem", "item", itemDTO);
    }
	
	@RequestMapping(path = "/inserirItem", method=RequestMethod.GET)
    public ModelAndView viewInsereItem(@ModelAttribute("item") ItemDTO itemDTO) {
        return new ModelAndView("pedido/insereItem", "item", itemDTO);
    }
	
	@RequestMapping(path = "/inserirItem", method=RequestMethod.POST)
	public ModelAndView inserirItem(@Valid @ModelAttribute("item") ItemDTO itemDTO) {
		itemService.inserir(itemDTO);
		return new ModelAndView("pedido/insereItem", "item", itemDTO);
	}
	
	@RequestMapping(path = "/processar/{idPedido}", method=RequestMethod.GET)
    public ModelAndView processaPedido(@PathVariable("idPedido") Long idPedido) {
		pedidoService.processar(idPedido);
        return new ModelAndView("redirect:/pedidos");
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/cancelar/{id}", method=RequestMethod.GET)
	public ModelAndView cancelar(@Valid @PathVariable("id") Long id) {
		pedidoService.cancelarPedido(id);
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodos());
	}
	
	@RequestMapping(path = "/encerrar/{id}", method=RequestMethod.GET)
	public ModelAndView encerrar(@Valid @PathVariable("id") Long id) {
		pedidoService.retirarPedido(id);
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodos());
	}
	
	@ModelAttribute("clientes")
    public List<Cliente> comboClientes() {
        return clienteService.listAtivos();
    }
	
	@ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listarServicos();
    }
	
	@ModelAttribute("situacoes")
    public List<SituacaoPedido> comboSituacoes() {
        return pedidoService.listarSituacoes();
    }
	
}
