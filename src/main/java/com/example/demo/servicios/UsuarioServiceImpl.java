package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.github.javafaker.Faker;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository; 

	@Override
	public Usuario create(Usuario user) {
		// TODO Auto-generated method stub
		System.out.println("--- "+user);
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
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>(); 
		
		for(int i = 1; i <= 10; i++) {
			int genero = faker.number().numberBetween(0, 1);
			if(genero==0) {
				Usuario user = new Usuario(faker.name().fullName(), "h", faker.date().birthday());
				listaUsuarios.add(user);
				repository.save(user);
			}else {
				Usuario user = new Usuario(faker.name().fullName(), "m", faker.date().birthday());
				listaUsuarios.add(user);
				repository.save(user);
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public void like(int id1, int id2) {
		
		
	}
	
	

}
