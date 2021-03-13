package co.edu.unicundi.proyectoSpringPrueba.controller;

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
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.proyectoSpringPrueba.dto.Estudiante;

import co.edu.unicundi.proyectoSpringPrueba.service.imp.IEstudianteService;
import co.edu.unicundi.proyectoSpringPrueba.util.ExcepcionGenerica;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping(path = "/retornar", produces = "application/xml")
	public Estudiante retornarEstudiante() {
		Estudiante est = new Estudiante(1070, "Johans", "González Montero");
		return est;
	}

	@GetMapping(path = "/retornarIny")
	public Estudiante retornarEstudianteInyeccion() {
		Estudiante est = estudianteService.retornaInfo();
		return est;
	}

	@GetMapping("/crearLista")
	public ResponseEntity<List<Estudiante>> crearLista() {
		return new ResponseEntity<List<Estudiante>>(estudianteService.listarCreados(), HttpStatus.OK);
	}
 
	// @GetMapping(path = "/retornarApellido", produces = "application/xml")
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		try {

			return new ResponseEntity<List<Estudiante>>(estudianteService.listar(), HttpStatus.OK);
		} catch (ExcepcionGenerica e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/obtenerId/{id}")
	public ResponseEntity<?> retornarInfo(@PathVariable int id) {
		try {
			return new ResponseEntity<Estudiante>(estudianteService.obtener(id), HttpStatus.OK);

		} catch (ExcepcionGenerica e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Estudiante estudiante) {
		try {
			estudianteService.guardar(estudiante);

			return new ResponseEntity<Estudiante>(estudiante, HttpStatus.CREATED);
		} catch (ExcepcionGenerica e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Estudiante estudiante) {
		try {
			estudianteService.modificar(estudiante);
			return new ResponseEntity<Estudiante>(estudianteService.obtener(estudiante.getId()), HttpStatus.OK);

		} catch (ExcepcionGenerica e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> elimianr(@PathVariable int id) {
		try {
			estudianteService.eliminar(id);

			return new ResponseEntity<String>(" ", HttpStatus.NO_CONTENT);

		} catch (ExcepcionGenerica e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
}
