package com.example.demo.servicios;

import java.util.List;

import com.example.demo.model.Usuario;

public interface UsuarioService {

	Usuario create(Usuario user);

	Usuario deleteById(int id);

	List<Usuario> findAll();
	
	List<Usuario> findContactos(int id);

	Usuario findById(int id);

	Usuario update(Usuario user);
	
	List<Usuario> generateTen();
	
	Usuario like(int id1, int id2);
	
	Usuario dislike(int id1, int id2);
	
	List<Usuario> verMatches(int id1);
	
}
