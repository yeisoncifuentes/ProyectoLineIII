package co.edu.unicundi.proyectoSpringPrueba.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicundi.proyectoSpringPrueba.dto.Estudiante;
import co.edu.unicundi.proyectoSpringPrueba.util.ExcepcionGenerica;

@Service
public class EstudianteServiceImp implements IEstudianteService {

	@Autowired
	@Qualifier("andes")
	private IUniversidad universidadService;

	List<Estudiante> estudiantes = new ArrayList<Estudiante>();

	@Override
	public Estudiante retornaInfo() {
		Estudiante estudiante = new Estudiante(1070, "Johans", "González Montero");
		estudiante.setUniversidad(universidadService);
		String nombU = universidadService.nombreUniversidad();
		System.out.println(nombU);
		return estudiante;
	}

	@Override
	public void crearLista() {

		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Yeison", "Cifuentes"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Ana", "Salamanca"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Jime", "Suares"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Cielo", "Ortiz"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Juan", "Gonzales"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Felipe", "Palacios"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Jose", "Linares"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Carlos", "Rodriguez"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Pepe", "Pelaes"));
		estudiantes.add(new Estudiante(estudiantes.size() + 1, "Julieth", "Ramirez"));

		for (Estudiante estudiante : estudiantes) {
			estudiante.setUniversidad(universidadService);
		}

	}

	@Override
	public List<Estudiante> listarCreados() {
		this.crearLista();
		return estudiantes;
	}

	@Override
	public List<Estudiante> listar() throws ExcepcionGenerica  {
		try {
			if (!estudiantes.isEmpty()) {
				return estudiantes;
			} else {
				throw new ExcepcionGenerica("No existen estudiantes");
			}
		} catch (ExcepcionGenerica e) {

			throw new ExcepcionGenerica(e.getMessage());
		} catch (Exception ex) {

			throw new ExcepcionGenerica("Ocurrio un error en el servidor");
		}

	}

	@Override
	public Estudiante obtener(int id) throws ExcepcionGenerica  {
		try {
			boolean encontrado = false;
			Estudiante estudianteObtenido = new Estudiante(0, "NaN", "NaN");
			for (Estudiante estudiante : estudiantes) {
				if (estudiante.getId() == id) {
					estudianteObtenido = estudiante;
					encontrado = true;
				}
			}
			if (encontrado) {
				return estudianteObtenido;
			} else {
				throw new ExcepcionGenerica("No existe el estudiante con el id " + id);
			}
		} catch (ExcepcionGenerica e) {

			throw new ExcepcionGenerica(e.getMessage());
		} catch (Exception ex) {

			throw new ExcepcionGenerica("Ocurrio un error en el servidor");
		}

	}

	@Override
	public void guardar(Estudiante estudiante) throws ExcepcionGenerica  {

		try {
			if (this.obtenerNombreApellido(estudiante).getId() == 0) {

				estudiante.setId(estudiantes.size() + 1);
				estudiante.setUniversidad(universidadService);
				estudiantes.add(estudiante);
			} else {
				throw new ExcepcionGenerica("El estudiante ya existe");
			}
		} catch (ExcepcionGenerica e) {
			throw new ExcepcionGenerica(e.getMessage());
		} catch (Exception ex) {
			throw new ExcepcionGenerica("Ocurrio un error en el servidor");
		}

	}

	@Override
	public void modificar(Estudiante estudianteM) throws ExcepcionGenerica {
		try {
			this.obtener(estudianteM.getId());
			for (Estudiante estudiante : estudiantes) {
				if (estudiante.getId() == estudianteM.getId()) {
					if (this.obtenerNombreApellido(estudianteM).getId() == estudianteM.getId()
							|| this.obtenerNombreApellido(estudianteM).getId() == 0) {
						estudiante.setNombre(estudianteM.getNombre());
						estudiante.setApellido(estudianteM.getApellido());
					} else {
						throw new ExcepcionGenerica("El estudiante ya existe");
					}
				}
			}
		} catch (ExcepcionGenerica e) {
			throw new ExcepcionGenerica(e.getMessage());
		} catch (Exception ex) {
			throw new ExcepcionGenerica("Ocurrio un error en el servidor");
		}

	}

	@Override
	public void eliminar(int id) throws ExcepcionGenerica  {
		try {
			this.obtener(id);
			for (Estudiante estudiante : estudiantes) {
				if (estudiante.getId() == id) {
					estudiantes.remove(estudiante);
					return;
				}
			}
		} catch (ExcepcionGenerica e) {

			throw new ExcepcionGenerica(e.getMessage());
		} catch (Exception ex) {
			throw new ExcepcionGenerica("Ocurrio un error en el servidor");
		}

	}

	@Override
	public Estudiante obtenerNombreApellido(Estudiante estudianteEntrada) {
		Estudiante estudianteFiltrado = new Estudiante(0, "Nan", "Nan");
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getNombre().equals(estudianteEntrada.getNombre())
					&& estudiante.getApellido().equals(estudianteEntrada.getApellido())) {

				estudianteFiltrado = estudiante;
			}
		}
		return estudianteFiltrado;
	}

}
