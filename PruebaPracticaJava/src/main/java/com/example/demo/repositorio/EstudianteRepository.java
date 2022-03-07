package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

	public List<Estudiante> findByEmail (String email);

	
}
