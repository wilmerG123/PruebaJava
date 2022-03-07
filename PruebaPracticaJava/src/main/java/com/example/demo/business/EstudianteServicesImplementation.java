package com.example.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.EstudianteDTO;
import com.example.demo.models.Estudiante;
import com.example.demo.repositorio.CursoRepository;
import com.example.demo.repositorio.EstudianteRepository;

@Service
public class EstudianteServicesImplementation implements EstudianteServices {

	@Autowired
	private EstudianteRepository estudianterepo;
	@Autowired
	private CursoRepository cursorepo;

	@Override
	public Estudiante createEstudiante(EstudianteDTO estudiantedto) {

	
			Estudiante estudiante = new Estudiante();
			estudiante.setNombres(estudiantedto.getNombres());
			estudiante.setApellidos(estudiantedto.getApellidos());
			estudiante.setEmail(estudiantedto.getEmail());
			// Validacion de Correo en BBDD
			if (!estudianterepo.findByEmail(estudiante.getEmail()).isEmpty()) {
				throw new IllegalArgumentException("El correo Ya existe");
			}
			estudiante.setFechaNacimiento(estudiantedto.getFechaNacimiento());
			estudiante.setEstado(validarEstado(estudiantedto.getEstado()));
			Long idcurso = estudiantedto.getCurso().getId();
			if(!validarCursoXid(estudiantedto.getCurso().getId())) {
				throw new IllegalArgumentException("Curso con el ID " + idcurso + " no existe");
			}
			estudiante.setCurso(estudiantedto.getCurso());
			
			// Guardado en BBDD
			
		return estudianterepo.save(estudiante);
	}

	@Override
	public Estudiante updateEstudiante(EstudianteDTO estudiantedto, Long id) throws Exception {

		if (!validarEstudianteXid(id)) {
			throw new IllegalArgumentException("Estudiante con el ID " + id + " no existe");
		}

		Optional<Estudiante> estudiante = estudianterepo.findById(id);

		String emailEstudiante = estudiante.get().getEmail();
		estudiante.get().setEstudianteId(id);
		estudiante.get().setNombres(estudiantedto.getNombres());
		estudiante.get().setApellidos(estudiantedto.getApellidos());

		if (estudiante.get().getEmail().equals(estudiantedto.getEmail())) {
			estudiante.get().setEmail(estudiantedto.getEmail());
		} else {
			if (!estudianterepo.findByEmail(estudiantedto.getEmail()).isEmpty()) {

				throw new IllegalArgumentException("El Correo " + estudiantedto.getEmail() + " Ya existe en BBDD");
			}
		}

		estudiante.get().setEmail(estudiantedto.getEmail());
		estudiante.get().setFechaNacimiento(estudiantedto.getFechaNacimiento());
		estudiante.get().setEstado(validarEstado(estudiantedto.getEstado()));
		estudiante.get().setCurso(estudiantedto.getCurso());

		return estudianterepo.save(estudiante.get());
	}

	@Override
	public List<Estudiante> getEstudiante() {

		List<Estudiante> estudiantes = estudianterepo.findAll();

		return estudiantes;
	}

	@Override
	public void deleteEstudiante(Long id) {

		estudianterepo.deleteById(id);

	}
	
	public boolean validarEstudianteXid(Long id) {

		if (estudianterepo.existsById(id)) {
			return true;
		}
		return false;
	}
	
	public boolean validarCursoXid(Long id) {

		if (cursorepo.existsById(id)) {
			return true;
		}
		return false;
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
