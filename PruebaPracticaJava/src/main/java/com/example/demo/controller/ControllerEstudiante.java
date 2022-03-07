package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.business.EstudianteServicesImplementation;
import com.example.demo.domain.CursoDTO;
import com.example.demo.domain.EstudianteDTO;
import com.example.demo.models.Curso;
import com.example.demo.models.Estudiante;

@RestController
@RequestMapping("/api/estudiante")
public class ControllerEstudiante {

	@Autowired
	private EstudianteServicesImplementation implementation;
	
	@PostMapping("/estudiante")
	public ResponseEntity<?> createEstudiante (@RequestBody EstudianteDTO estudiantedto)throws Exception{
		
		Estudiante  estudiante = implementation.createEstudiante(estudiantedto);
		
		return new ResponseEntity<Estudiante>(estudiante,HttpStatus.CREATED);
	}
	@PutMapping("/estudiante/{id}")
	public ResponseEntity<?> updateEstudiante (@PathVariable (name="id") Long id,  @RequestBody EstudianteDTO estudiantedto)throws Exception{
		
		Estudiante estudiante = implementation.updateEstudiante(estudiantedto, id);
		
		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}
	
	@GetMapping("/estudiante")
	public ResponseEntity<List<Estudiante>> getEstudiante (){
		
		List<Estudiante>estudiantes = implementation.getEstudiante();
		
		return new ResponseEntity<List<Estudiante>>(estudiantes, HttpStatus.OK);
	}
	@DeleteMapping("/estudiante/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEstudiante (@PathVariable (name="id") Long id){
		
		implementation.deleteEstudiante(id);
	}
	
	
}
