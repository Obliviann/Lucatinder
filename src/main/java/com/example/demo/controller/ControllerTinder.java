package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;


@Controller
public class ControllerTinder {

	@Autowired
	private UsuarioService usuarioService;
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/")
	public String inicio(ModelMap model) {
		logger.info(" --- En INICIO ");
		model.addAttribute("user", new Usuario());
		return "inicio";
	}
	
	@RequestMapping("/listado")
	public String listado(ModelMap model) {
		logger.info("En el listado");
		model.addAttribute("listado", usuarioService.generateTen());
		return "bienvenida";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Usuario user) {
		logger.info("RegistroUsuario");
		usuarioService.create(user);
		return "redirect:/listado";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute ("user") Usuario user, ModelMap model) {
		if(usuarioService.findById(user.getIdusuario())!=null) {
			model.addAttribute("user", usuarioService.findById(user.getIdusuario()));
			return "redirect:/listado";
		}else{
			return "redirect:/";
		}
	}
	
		
	@GetMapping("/like")
	public String like(@ModelAttribute Usuario user) {
				logger.info("Acaba de darle al botón de like");
		return "redirect:/listado";
		
	}
	
	
	
	
	
	
	
	
}
