package com.example.demo.servicios;

import java.util.List;

import com.example.demo.model.Usuario;

public interface UsuarioService {

	Usuario create(Usuario user);

	Usuario deleteById(int id);

	List<Usuario> findAll();

	Usuario findById(int id);

	Usuario update(Usuario user);
	
}
