package ar.edu.materia;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.materia.Alumno;
import ar.edu.unlam.materia.AsignacionCursoAlumno;
import ar.edu.unlam.materia.Aula;
import ar.edu.unlam.materia.Curso;
import ar.edu.unlam.materia.Materia;
import ar.edu.unlam.materia.Nota;
import ar.edu.unlam.materia.Universidad;

public class TestCurso {

	  @Test public void agregarUnaMateriaYAsignarUnAula() {
	  
	  // Se crea un alumno String nombre = "Gaston"; String apellido = "Estevez";
		  String nombre = "Gaston";
		  String apellido = "Estevez"; 
		  Integer dni = 1234;
	  Alumno alumno = new Alumno(dni,apellido,nombre);
	  
	  //Se crea una materia 
	  Integer codigo = 1234;
	  String nombreMat = "Ingles";
	  Materia materia = new Materia(nombreMat, codigo);
	  
	  //Se crea un aula
	  Integer cantidadMaxAlumno = 100; 
	  Integer numeroDeAula = 255;
	  Aula aula = new Aula(numeroDeAula,cantidadMaxAlumno);
	  
	  //En la clase AsignacionCurso se relaciona con el alumno y cursow
	  Integer id = 1;
	  Nota parcial1= null; 
	  Nota parcial2 = null;
	  AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno,id,parcial1,parcial2);
	  
	  //Se crea un curso 
	  String numeroDeComision = "1-2363"; 
	  Integer horarioDeSalida = 12; 
	  Integer horarioDeEntrada = 7; 
	  Curso curso = new Curso(numeroDeComision,horarioDeEntrada,horarioDeSalida);
	  
	  //Se le asigna un aula al curso
	  boolean AsignarAula = curso.agregarAula(aula); assertTrue(AsignarAula);
	  
	  //Se le agrega una materia al curso 
	  boolean agregarMateria = curso.agregarMateria(materia); assertTrue(agregarMateria);
	  
	  //El asignacionCursoAlumno se le agrega un curso
	  asignacionCursoAlumno.agregarCurso(curso); 
	  }
	 

	
	  @Test public void asignarUnAlumnoAlCurso() { // Se crea un alumno
	  String nombre = "Gaston";
	  String apellido = "Estevez"; 
	  Integer dni = 1234;
	  Alumno alumno = new Alumno(dni,apellido,nombre);
	  //En la clase AsignacionCurso se relaciona con el alumno y cursow Integer id
	   Nota parcial1= null;
	   Nota parcial2 = null; 
	   Integer id = 1;
	   AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno,id,parcial1,parcial2);
	  
	  String numeroDeComision = "1-2363"; Integer horarioDeSalida = 12; Integer
	  horarioDeEntrada = 7; Curso curso = new Curso(numeroDeComision,horarioDeEntrada,horarioDeSalida);
	  curso.agregarAlumnoAlCurso(curso, asignacionCursoAlumno);
	   }
	 

	@Test
	public void buscarUnAlumnoEnUnCursoYAsignarUnaNota() {
		// Se crea un alumno
		String nombre = "Gaston";
		String apellido = "Estevez";
		Integer dni = 1234;
		Alumno alumno = new Alumno(dni, apellido, nombre);

		// En la clase AsignacionCurso se relaciona con el alumno y cursow
		Integer id = 1;
		Nota parcial1 = null;
		Nota parcial2 = null;
		AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, id, parcial1, parcial2);

		String numeroDeComision = "1-2363";
		Integer horarioDeSalida = 12;
		Integer horarioDeEntrada = 7;
		Curso curso = new Curso(numeroDeComision, horarioDeEntrada, horarioDeSalida);
		assertTrue(asignacionCursoAlumno.agregarCurso(curso));
		assertTrue(asignacionCursoAlumno.asignarCursoAlAlumno(alumno, curso));
		// BuscarAlumno con su curso
		Alumno buscar = curso.buscarAlumno(alumno, asignacionCursoAlumno, curso);
		assertNotNull(buscar);
		// Si lo ecuentra se le asigna una nota
		Double notaParcial1 = 5.0;
		Double notaParcial2 = 6.5;
		parcial1 = new Nota(notaParcial1);
		parcial2 = new Nota(notaParcial2);

		asignacionCursoAlumno.setParcial1(parcial1);
		asignacionCursoAlumno.setParcial2(parcial2);
		//Una vez que al alumno se le asigno las notas de los parciales se lo guarda la unlam
		//y verifica si aprobo no o si tiene que ir a final
		Universidad unlam = new Universidad("Unlam");
		unlam.cursadaFinalizada(asignacionCursoAlumno);

	}

	/*
	 * @Test public void cadaCursoTranscurreEnUnDeterminadoAño() { String
	 * numeroDeComision = "1-2363"; Integer horarioDeSalida = 12; Integer
	 * horarioDeEntrada = 7; Curso curso = new
	 * Curso(numeroDeComision,horarioDeEntrada,horarioDeSalida);
	 * 
	 * Integer anio = 2023; CicloElectivo cicloElectivo = new CicloElectivo(anio);
	 * //Como cada curso transcurre en un determinado año se debe saber el año
	 * boolean anioElectivo = curso.agregarAnioElectivo(cicloElectivo);
	 * assertTrue(anioElectivo); }
	 */

}
