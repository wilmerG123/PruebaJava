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
import com.example.demo.business.CursosServicesImplementation;
import com.example.demo.domain.CursoDTO;
import com.example.demo.models.Curso;

@RestController
@RequestMapping("api/curso")
public class ControllerCurso {

	@Autowired
	private CursosServicesImplementation	 implementation;
	
	@PostMapping("/curso")
	public ResponseEntity<?> createCurso (@RequestBody CursoDTO cursodto){
		
		Curso curso = implementation.createCurso(cursodto);
		
		return new ResponseEntity<Curso>(curso,HttpStatus.CREATED);
	}
	@PutMapping("/curso/{id}")
	public ResponseEntity<?> updateCurso (@PathVariable (name="id") Long id, @RequestBody CursoDTO cursodto){
		
		Curso curso = implementation.updateCurso(cursodto, id);
		
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@GetMapping("/curso")
	public ResponseEntity<List<Curso>> getCursos (){
		
		List<Curso> cursos = implementation.getCursos();
		
		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}
	@DeleteMapping("/curso/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCurso (@PathVariable (name="id") Long id){
		
		implementation.deleteCurso(id);
	}
	
	
}
