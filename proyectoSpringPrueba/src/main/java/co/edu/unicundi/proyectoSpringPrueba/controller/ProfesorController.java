package co.edu.unicundi.proyectoSpringPrueba.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.dto.Profesor;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
	
	//No utilizar
	@RequestMapping(value = "/retonarNombre", method = RequestMethod.GET)
	public String retornarNombre() {
		return "Johans ";
		
	}
	
	//@GetMapping(path = "/retornarApellido", produces = "application/xml")
	@GetMapping("/retornarApellido")
	public String retornarApellido() {
		return "González";
	}
	
	@GetMapping("/retornarInfo/{nombre}/{apellido}")
	public String retornarInfo(	@PathVariable String nombre, 
								@PathVariable String apellido) {
		return nombre + " " + apellido;
	}
	
	@PostMapping("/guardar")
	public Profesor guardar(@RequestBody Profesor profesor) {
		System.out.println(profesor.getId() + " " + profesor.getNombre() + " " + profesor.getApellido());
		return profesor;
	}
	
	@PutMapping("editar/{var}")
	public Profesor editar(	@PathVariable int var,
							@RequestBody Profesor profesor) {
		System.out.println(var + " " + profesor.getId() + " " + profesor.getNombre() + " " + profesor.getApellido());
		return profesor;
	}
	
	@DeleteMapping("eliminar/{id}") 
	public String elimianr(@PathVariable int id) {
		System.out.println(id);
		return "OK";
	}

}
