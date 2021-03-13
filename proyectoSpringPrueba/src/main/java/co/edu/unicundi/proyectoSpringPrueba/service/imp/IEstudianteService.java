package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.List;

import co.edu.unicundi.proyectoSpringPrueba.dto.Estudiante;
import co.edu.unicundi.proyectoSpringPrueba.util.ExcepcionGenerica;

public interface IEstudianteService {

	Estudiante retornaInfo();
	
	void  crearLista();
	
	 List<Estudiante> listarCreados();
	
	
	 
	 List<Estudiante> listar() throws ExcepcionGenerica ;
	 
	 Estudiante obtener(int id) throws ExcepcionGenerica ;
	 
	 void guardar(Estudiante estudiante) throws ExcepcionGenerica ;
	 
	 void modificar(Estudiante estudiante) throws ExcepcionGenerica ;
	 
	 void eliminar(int id) throws ExcepcionGenerica ;
	 
	 Estudiante obtenerNombreApellido(Estudiante estudianteEntrada);
	 
	
	
}
