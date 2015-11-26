package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());
	}
	
	@RequestMapping(path = "/{id}", method=RequestMethod.GET)
	public ModelAndView viewExibe(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarPorId(id));
	}
	
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarPorId(id));
    }
	
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO, 
    		BindingResult result,
    		final RedirectAttributes redirectAttributes) {
    	
    	if (result.hasErrors()) {
            return new ModelAndView("cliente/edita");
        }
        
    	clienteService.atualizar(clienteDTO);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Cliente editado com sucesso.");
        
        return new ModelAndView("redirect:/clientes");
    }
    
    @RequestMapping(path = "/inserir", method = RequestMethod.GET)
    public ModelAndView viewInsere() {
        return new ModelAndView("cliente/insere", "cliente", new ClienteDTO());
    }
    
    @RequestMapping(path = "/inserir", method = RequestMethod.POST)
    public ModelAndView inserir(@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO, 
    		BindingResult result,
    		final RedirectAttributes redirectAttributes) {
     
    	if (result.hasErrors()) {
            return new ModelAndView("cliente/insere");
        }
    	
    	clienteService.inserir(clienteDTO);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso.");
    	
        return new ModelAndView("redirect:/clientes");
    }
    
    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView viewRemove(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/remove", "cliente", clienteService.buscarPorId(id));
    }
    
    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remover(ClienteDTO clienteDTO, final RedirectAttributes redirectAttributes) {

    	clienteService.remover(clienteDTO);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Cliente removido com sucesso.");
    	
        return new ModelAndView("redirect:/clientes");
    }
    
    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
	
}
