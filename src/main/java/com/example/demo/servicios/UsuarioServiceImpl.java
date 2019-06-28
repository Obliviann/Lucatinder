package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository; 

	@Override
	public Usuario create(Usuario user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public Usuario deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

}
