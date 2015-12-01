package br.com.cwi.crescer.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class AbstractClienteController {

	protected ClienteService clienteService;
	protected CidadeService cidadeService;

	@Autowired
	public AbstractClienteController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}
	
	@ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
    
    @ModelAttribute("situacoes")
    public List<SituacaoCliente> comboSituacao() {
        return clienteService.listarSituacoes();
    }
    
    // REST
 	@ResponseBody
 	@RequestMapping(path = "/rest/{id}")
 	public ClienteDTO buscarCliente(@PathVariable("id") Long id) {
 	    return clienteService.buscarPorId(id);
 	}
}
