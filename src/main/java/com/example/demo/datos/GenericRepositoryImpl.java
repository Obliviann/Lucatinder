package com.example.demo.datos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servicios.UsuarioServiceImpl;

@Repository
@Transactional
public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements GenericRepositoryCustom<T, ID> {

	private static final Logger logger = LoggerFactory.getLogger(GenericRepositoryImpl.class);
	private final EntityManager entityManager;

	public GenericRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}
	
	/*@Override
    public void like(int id1, int id2) {
        // TODO Auto-generated method stub
        logger.info("--- En método like de la clase PerfilRpositoryImpl");
        entityManager.createNativeQuery("INSERT INTO lucatinder.contactos (idcontacto, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
          .setParameter(1, null)
          .setParameter(2, id1)
          .setParameter(3, id2)
          .executeUpdate();
    }*/

}