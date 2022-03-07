package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CursoDTO;
import com.example.demo.models.Curso;
import com.example.demo.repositorio.CursoRepository;
@Service
public class CursosServicesImplementation implements CursosServices{

	
	@Autowired
	private CursoRepository cursorepository;
	
	@Override
	public Curso createCurso(CursoDTO cursodto) {

		Curso curso = new Curso();
		curso.setNombre(cursodto.getNombre());
		curso.setEstado(validarEstado(cursodto.getEstado()));
		// Guardado en BBDD
		return cursorepository.save(curso);
	}

	@Override
	public Curso updateCurso(CursoDTO cursodto, Long id) {

		Curso curso = new Curso();
		curso.setId(id);
		curso.setNombre(cursodto.getNombre());
		curso.setEstado(validarEstado(cursodto.getEstado()));
		// Actualizado en BBDD
		return cursorepository.save(curso);
	}

	@Override
	public List<Curso> getCursos() {

		List<Curso> cursos = cursorepository.findAll();

		return cursos;
	}

	@Override
	public void deleteCurso(Long id) {

		cursorepository.deleteById(id);

	}
	public String validarEstado (int estado) {
		String estadoSaliente = "";
		
		if(estado ==0) {
			estadoSaliente = "INACTIVO";
		}else if(estado==1){
			estadoSaliente = "ACTIVO";
		}else {
			throw new IllegalArgumentException("El estado que tratas de ingresar no existe");
		}
		
		return estadoSaliente;
	}

	
	
}
