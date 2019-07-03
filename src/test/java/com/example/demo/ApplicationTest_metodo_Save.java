package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ApplicationTest_metodo_Save {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Test
	public void pruebaCreate() throws Exception {

		int cant1 = (int) repository.count();
		Usuario Antonio = new Usuario("Antonio", "h", new Date(1995, 05, 05));
		usuarioService.create(Antonio);
		int cant2 = (int) repository.count();

		assertTrue(cant2 == (cant1 + 1));
		assertTrue(repository.existsById(Antonio.getIdusuario()));

		repository.delete(Antonio);
		
	}

}
