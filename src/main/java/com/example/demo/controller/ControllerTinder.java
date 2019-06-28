package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;


@Controller
public class ControllerTinder {

	@Autowired
	private UsuarioService usuarioService;
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/new")
	public String addUser(ModelMap model) {
		logger.info("-- en NEW");
		model.addAttribute("user", new Usuario());
		return "UserFrom";
		
	}
	
}
