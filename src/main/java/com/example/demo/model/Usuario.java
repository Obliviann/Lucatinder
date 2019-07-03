package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
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
	private Integer idintereses;
	private String descripcion;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int idusuario, String nombre, String genero, Date edad, String poblacion, Integer idintereses,
			String descripcion) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.poblacion = poblacion;
		this.idintereses = idintereses;
		this.descripcion = descripcion;
	}

	
	public Usuario(String nombre, String genero, Date edad) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}

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
	public Integer getIdintereses() {
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
	
	@Column(nullable=true)
	public void setIdintereses(Integer idintereses) {
		this.idintereses = idintereses;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad
				+ ", poblacion=" + poblacion + ", idintereses=" + idintereses + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
}
