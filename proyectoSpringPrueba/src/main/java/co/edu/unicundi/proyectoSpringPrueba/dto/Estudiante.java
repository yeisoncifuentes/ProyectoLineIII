package co.edu.unicundi.proyectoSpringPrueba.dto;

import co.edu.unicundi.proyectoSpringPrueba.service.imp.IUniversidad;

public class Estudiante {

	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private IUniversidad universidad;
	
	public Estudiante() {
		
	}
	
	public Estudiante(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public IUniversidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(IUniversidad universidad) {
		this.universidad = universidad;
	}
	
	
		
}
