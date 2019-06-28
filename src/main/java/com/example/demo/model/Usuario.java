package com.example.demo.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	private int idusuario;
	private String nombre;
	private String genero;
	private Date edad;
	private String poblacion;
	private int idintereses;
	private String descripcion;
	
	
	
	
	
	
	@Id
	@GeneratedValue
	public int getIdusuario() {
		return idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	
	
	public String getGenero() {
		return genero;
	}
	public Date getEdad() {
		return edad;
	}
	
	
	public String getPoblacion() {
		return poblacion;
	}
	public int getIdintereses() {
		return idintereses;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public void setEdad(Date edad) {
		this.edad = edad;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	
	public void setIdintereses(int idintereses) {
		this.idintereses = idintereses;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
