package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	private int idUsuario;
	private String Nombre;
	private String Género;
	private Date Edad;
	private String Población;
	private int idIntereses;
	private String Descripción;
	
	

	
	@Id
	@GeneratedValue
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
	public String getGénero() {
		return Género;
	}
	public void setGénero(String género) {
		Género = género;
	}
	
	
	
	public Date getEdad() {
		return Edad;
	}
	public void setEdad(Date edad) {
		Edad = edad;
	}
	
	
	
	public String getPoblación() {
		return Población;
	}
	public void setPoblación(String población) {
		Población = población;
	}
	
	
	
	public int getIdIntereses() {
		return idIntereses;
	}
	public void setIdIntereses(int idIntereses) {
		this.idIntereses = idIntereses;
	}
	
	
	
	public String getDescripción() {
		return Descripción;
	}
	public void setDescripción(String descripción) {
		Descripción = descripción;
	}
	
	
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", Nombre=" + Nombre + ", Género=" + Género + ", Edad=" + Edad
				+ ", Población=" + Población + ", idIntereses=" + idIntereses + ", Descripción=" + Descripción + "]";
	}
	
	
	
	
}
