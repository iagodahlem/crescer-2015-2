package br.com.cwi.crescer.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class InsereClienteController extends AbstractClienteController {

	@Autowired
	public InsereClienteController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
	@RequestMapping(path = "/inserir", method=RequestMethod.GET)
    public ModelAndView viewInsere() {
        return new ModelAndView("cliente/insere", "cliente", new ClienteDTO());
    }
    
    @RequestMapping(path = "/inserir", method=RequestMethod.POST)
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
	
}
