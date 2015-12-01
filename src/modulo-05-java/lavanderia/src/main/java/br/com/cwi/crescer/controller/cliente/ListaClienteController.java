package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ListaClienteController extends AbstractClienteController {

	@Autowired
	public ListaClienteController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarTodos());
	}
	
	@RequestMapping(path = "/listarPorNome", method=RequestMethod.GET)
	public ModelAndView listarPorNome(@RequestParam("nome") String nome) {
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarPorNome(nome));
	}
	
}
