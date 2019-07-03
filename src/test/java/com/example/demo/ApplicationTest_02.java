package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.datos.UsuarioRepository;
import com.example.demo.servicios.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ApplicationTest_02 {

	@PersistenceContext
    private EntityManager em;
 
	@Autowired
	private UsuarioService usuarioService;
    
    @Test
    public void testLike() throws Exception {
    	
    	int id1 = 1530;
    	int id2 = 1505;
    	
    	List<Integer> list = new ArrayList<Integer>();
    	List<Integer> list2 = new ArrayList<Integer>();
    	
    	list = em.createNativeQuery("SELECT fk_idusuario2 FROM lucatinder.contactos WHERE fk_idusuario LIKE :id1")
				.setParameter("id1", id1).getResultList();
    	
    	assertThat(list.size()).isEqualTo(0);
    	
    	list2 = em.createNativeQuery("SELECT fk_idusuario2 FROM lucatinder.contactos")
				.getResultList();
    	
    	usuarioService.like(id1, id2);
    	
    	assertThat(list2.size()).isEqualTo(em.createNativeQuery("SELECT fk_idusuario2 FROM lucatinder.contactos")
				.getResultList().size()-1);
    	
    }
	
}
