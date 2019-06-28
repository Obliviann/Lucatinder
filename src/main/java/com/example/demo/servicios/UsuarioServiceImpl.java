package com.example.demo.servicios;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.github.javafaker.Faker;

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
		Usuario user = findById(id);
		if (user != null) {
			repository.delete(user);
		}
		return user;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Usuario update(Usuario user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public List<Usuario> generateTen() {
		// TODO Auto-generated method stub
		Faker faker = new Faker(new Locale("es"));
		return null;
	}

}
