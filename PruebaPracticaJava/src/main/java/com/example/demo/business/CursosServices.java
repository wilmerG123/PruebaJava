package com.example.demo.business;

import java.util.List;
import com.example.demo.domain.CursoDTO;
import com.example.demo.models.Curso;

public interface CursosServices {

	/**
	 * Interface donde se definen las operaciones de negocio a implementar 
	 * 
	 * @author wilmer garnica
	 *
	 */
	public Curso createCurso (CursoDTO cursodto);
	
	public Curso updateCurso (CursoDTO cursodto, Long id);
	
	public List<Curso>getCursos ();
	
	public void deleteCurso (Long id);
}
