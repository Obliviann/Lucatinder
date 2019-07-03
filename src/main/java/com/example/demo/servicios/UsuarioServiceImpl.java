package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.datos.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.github.javafaker.Faker;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario create(Usuario user) {
		// TODO Auto-generated method stub
		System.out.println("--- " + user);
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
	public List<Usuario> findContactos(int id) {
		// TODO Auto-generated method stub

		List<Usuario> users = new ArrayList<Usuario>();
		users = repository.findAll();

		List<Integer> list = new ArrayList<Integer>();
		list = entityManager
				.createNativeQuery("SELECT fk_idusuario2 FROM lucatinder.descartes WHERE fk_idusuario LIKE :id1")
				.setParameter("id1", id).getResultList();

		for (int i = 0; i < users.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				logger.info(""+list.get(j));
				if (users.get(i).getIdusuario() == list.get(j)) {
					logger.info(""+users.get(i));
					users.remove(i);
				}
			}
		}

		List<Integer> list2 = new ArrayList<Integer>();
		list2 = entityManager
				.createNativeQuery("SELECT fk_idusuario2 FROM lucatinder.contactos WHERE fk_idusuario LIKE :id1")
				.setParameter("id1", id).getResultList();

		for (int k = 0; k < users.size(); k++) {
			for (int l = 0; l < list2.size(); l++) {
				if (users.get(k).getIdusuario() == list2.get(l)) {
					users.remove(k);
				}
			}
		}

		if (users.size() >= 1) {
			return users;
		} else {
			return generateTen();
		}

	}
	
	public List<Usuario> verMatches(int id) {
		List <Integer> idMatches= new ArrayList<Integer>();
		List <Usuario> matches = new ArrayList<Usuario>();
		idMatches = entityManager
					.createNativeQuery("SELECT idusuario FROM lucatinder.matches WHERE idusuario2 LIKE :id1 UNION SELECT idusuario2 FROM lucatinder.matches WHERE idusuario LIKE :id2")
					.setParameter("id1", id).setParameter("id2", id).getResultList();
		
		logger.info("-----------idMatches.Size" + idMatches.size());
		logger.info("" + id);
		for(int i=0;i<idMatches.size();i++) {
			logger.info("-------IDMATCHES" + idMatches.get(i));
			Usuario user = findById(idMatches.get(i));
			matches.add(user);
		}
		
		return matches;
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

		for (int i = 1; i <= 10; i++) {
			int genero = faker.number().numberBetween(0, 1);
			if (genero == 0) {
				Usuario user = new Usuario(faker.name().fullName(), "h", faker.date().birthday());
				listaUsuarios.add(user);
				repository.save(user);
			} else {
				Usuario user = new Usuario(faker.name().fullName(), "m", faker.date().birthday());
				listaUsuarios.add(user);
				repository.save(user);
			}
		}

		return listaUsuarios;
	}

	@Override
	@Transactional
	public void like(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("--- En método like de la clase PerfilRpositoryImpl");
		entityManager
				.createNativeQuery(
						"INSERT INTO lucatinder.contactos (idcontacto, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
				.setParameter(1, null).setParameter(2, id1).setParameter(3, id2).executeUpdate();

		List<Integer> list = new ArrayList<Integer>();
		list = entityManager
				.createNativeQuery("SELECT fk_idusuario FROM lucatinder.contactos WHERE fk_idusuario2 LIKE :id1")
				.setParameter("id1", id1).getResultList();

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)==id2) {
				logger.info("-----HAY MATCH CON EL ID "+id1);
				entityManager
				.createNativeQuery(
						"INSERT INTO lucatinder.matches (idmatch, idusuario, idusuario2) VALUES (?,?,?)")
				.setParameter(1, null).setParameter(2, id1).setParameter(3, id2).executeUpdate();
			}
		}

	}

	@Override
	@Transactional
	public void dislike(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("--- En método like de la clase PerfilRpositoryImpl");
		entityManager
				.createNativeQuery(
						"INSERT INTO lucatinder.descartes (iddescarte, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
				.setParameter(1, null).setParameter(2, id1).setParameter(3, id2).executeUpdate();
	}

}
