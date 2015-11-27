package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("cliente/lista", "clientes", null);
	}
	
}
