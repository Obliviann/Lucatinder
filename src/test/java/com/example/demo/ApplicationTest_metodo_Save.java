package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.example.demo.servicios.UsuarioService;
import com.example.demo.servicios.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ApplicationTest_metodo_Save {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;

	@Test	
	public void pruebaCreate() throws Exception {

		int cant1 = (int) repository.count();
		logger.info("--------------------" + cant1);
		Date date = new Date(1995,05,05);
		Usuario Antonio = new Usuario("Antonio", "h", date);
		usuarioService.create(Antonio);
		int cant2 = (int) repository.count();
		logger.info("--------------------" + cant2);

		assertTrue(cant2 == (cant1 + 1));
		assertTrue(repository.existsById(Antonio.getIdusuario()));
		
		repository.delete(Antonio);

	}

}
