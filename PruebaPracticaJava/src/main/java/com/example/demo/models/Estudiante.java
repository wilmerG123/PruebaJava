package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estudiante {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudiante_id")
	private Long estudianteId;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "email")
	private String email;
	@Column(name = "estado")
	private String estado;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	
	public Long getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Long estudianteId) {
		this.estudianteId = estudianteId;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Estudiante(Long estudianteId, String nombres, String apellidos, String email, String estado,
			Date fechaNacimiento, Curso curso) {
		
		this.estudianteId = estudianteId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
		this.curso = curso;
	}

	public Estudiante() {
		super();
	}

	
	
	
}
