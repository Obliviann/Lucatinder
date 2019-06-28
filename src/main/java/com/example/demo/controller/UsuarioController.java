package com.example.demo.controller;

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
	
	
}
