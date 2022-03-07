package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curso_id")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="estad")
	private String estado;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Curso(Long id, String nombre, String estado) {

		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public Curso() {
		super();
	}
	
	
		
}
