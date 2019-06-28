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
	public String inicio() {
		return "inicio";
	}
	
	@RequestMapping("/listado")
	public String listado(ModelMap model) {
		logger.info("En el listado");
		model.addAttribute("listado", usuarioService.generateTen());
		return "inicio";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Usuario user) {
		logger.info("RegistroUsuario");
		usuarioService.create(user);
		return "redirect:/listado";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute int id, ModelMap model) {
		if(usuarioService.findById(id)!=null) {
			model.addAttribute("user", usuarioService.findById(id));
			return "redirect:/listado";
		}else{
			return "redirect:/inicio";
		}
	}
}
