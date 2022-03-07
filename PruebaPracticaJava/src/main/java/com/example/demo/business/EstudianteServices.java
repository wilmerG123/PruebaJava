package com.example.demo.business;

import java.util.List;	import com.example.demo.domain.EstudianteDTO;
import com.example.demo.models.Estudiante;

/**
 * Interface donde se definen las operaciones de negocio a implementar 
 * 
 * @author wilmer garnica
 *
 */
public interface EstudianteServices {

	public Estudiante createEstudiante (EstudianteDTO estudiantedto)throws Exception;
	
	public Estudiante updateEstudiante (EstudianteDTO estudiantedto, Long id)throws Exception;
	
	public List<Estudiante> getEstudiante ();
	
	public void deleteEstudiante (Long id);
	
	}
	