package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/usuarios" })
public class UsuarioController {

	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.create(usuario);
	}
	
	@GetMapping(path = { "/{idusuario}" })
	public Usuario findOne(@PathVariable("idusuario") int id) {
		return usuarioService.findById(id);
	}
	
	@PutMapping()
	public Usuario update(@PathVariable("idusuario") int id, @RequestBody Usuario usuario) {
		usuario.setIdusuario(id);
		return usuarioService.update(usuario);
		
	}
	
	
	/*@DeleteMapping(path = { "/{idusuario}" })
	public Usuario delete(@PathVariable("idusuario") int id) {
		return usuarioService.deleteById(id);
	}*/
	
	
	@DeleteMapping(path = { "/{idusuario}" })
	public Usuario delete(@PathVariable("idusuario") int id) {
		return usuarioService.deleteById(id);
	}

	/*
	@GetMapping
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}*/
	
	
	//Rest para añadir generar los 10 usuarios
	@GetMapping(path = { "/ten" })
	public List<Usuario> generateTen() {
		return usuarioService.generateTen();
	}
	
	
	@PostMapping
	public void like(int id1, int id2) {
		logger.info("----- Ejecutando query en el servicio REST. Ruta del paquete: controller.UsuarioController.java -----");
		logger.info("id1 que recibe el REST: "+id1+" -- | -- id2 que recibe el REST: "+id2);
		usuarioService.like(id1, id2);
	}
	
}
