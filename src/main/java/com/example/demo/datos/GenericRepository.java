package com.example.demo.datos;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface GenericRepository extends GenericRepositoryCustom<Usuario, Integer> {

}
