package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ExibeClienteController extends AbstractClienteController {

	@Autowired
	public ExibeClienteController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
	@RequestMapping(path = "/{id}", method=RequestMethod.GET)
	public ModelAndView viewExibe(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarPorId(id));
	}
	
}
