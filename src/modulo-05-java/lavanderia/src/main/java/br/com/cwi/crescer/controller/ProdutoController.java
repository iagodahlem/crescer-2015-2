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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService, MaterialService materialService, ServicoService servicoService) {
		this.produtoService = produtoService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("produto/lista", "produtos", produtoService.listarTodos());
	}
	
	@RequestMapping(path = "/listarPorMaterialEServico", method=RequestMethod.GET)
	public ModelAndView listarPorMaterialEServico(@RequestParam("material") String material, 
			@RequestParam("servico") String servico) {
		return new ModelAndView("produto/lista", "produtos", produtoService
				.listarPorMaterialEServico(material, servico));
	}
	
	@RequestMapping(path = "/editar/{id}", method=RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.buscarPorId(id));
    }
	
    @RequestMapping(path = "/editar", method=RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO produtoDTO, 
    		BindingResult result,
    		final RedirectAttributes redirectAttributes) {
    	
    	if (result.hasErrors()) {
            return new ModelAndView("produto/edita");
        }
        
    	produtoService.atualizar(produtoDTO);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Produto editado com sucesso.");
        
        return new ModelAndView("redirect:/produtos");
    }
	
	@RequestMapping(path = "/inserir", method=RequestMethod.GET)
    public ModelAndView viewInsere() {
        return new ModelAndView("produto/insere", "produto", new ProdutoDTO());
    }
    
    @RequestMapping(path = "/inserir", method=RequestMethod.POST)
    public ModelAndView inserir(@Valid @ModelAttribute("produto") ProdutoDTO produtoDTO, 
    		BindingResult result,
    		final RedirectAttributes redirectAttributes) {
     
    	if (result.hasErrors()) {
            return new ModelAndView("produto/insere");
        }
    	
    	produtoService.inserir(produtoDTO);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso.");
    	
        return new ModelAndView("redirect:/produtos");
    }
	
	@ModelAttribute("materiais")
    public List<Material> comboMaterial() {
        return materialService.listarMateriais();
    }
	
	@ModelAttribute("servicos")
    public List<Servico> comboServico() {
        return servicoService.listarServicos();
    }
	
	@ModelAttribute("situacoes")
    public List<SituacaoProduto> comboSituacao() {
        return produtoService.listarSituacoes();
    }
	
}
