package com.example.demo.datos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepositoryCustom<T, ID extends Serializable> extends JpaRepository<T, ID> {

	//void like(int id1, int id2);

}
