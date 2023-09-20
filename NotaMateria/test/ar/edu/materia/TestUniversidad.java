package ar.edu.materia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.materia.Alumno;
import ar.edu.unlam.materia.AsignacionCursoAlumno;
import ar.edu.unlam.materia.Nota;
import ar.edu.unlam.materia.Universidad;

public class TestUniversidad {

	/*@Test
	public void queSePuedaAgregarUnAulaALaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);

		Integer cantidadDeLugares = 50;
		Integer numeroDeAula = 10;
		Aula aula = new Aula(numeroDeAula, cantidadDeLugares);

		unlam.agregarAula(aula);
		Integer ve = 1;
		Integer obtenerNumeroDeAula = unlam.obtenerCantidadAulas();

		assertEquals(ve, obtenerNumeroDeAula);

		// BuscarUnAulaPorNumero
		Aula buscarAula = unlam.obtenerAulaPorNumero(numeroDeAula);
		assertEquals(aula, buscarAula);
	}

	@Test
	public void buscarUnAula() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);

		Integer cantidadDeLugares = 50;
		Integer numeroDeAula = 10;
		Aula aula = new Aula(numeroDeAula, cantidadDeLugares);
		unlam.agregarAula(aula);

		Aula buscarAula = unlam.obtenerAulaPorNumero(numeroDeAula);
		assertEquals(aula, buscarAula);
	}

	@Test
	public void queNoSePuedaInscribirAUnAlumnoAUnaMateriaSiSuperoLaCantidadMaxima() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);

		// Se crea una materia
		String nombreMat = "PB1";
		Integer codigo = 1;
		Materia pb2 = new Materia(nombreMat, codigo);

		unlam.registrarMateria(pb2);

		String nombreMate2 = "PB2";
		Integer codigoMat2 = 2;
		ArrayList<Materia> correlativas = new ArrayList();
	}
*/
	@Test
	public void obtenerPromedioYValidarSiApruebaPromocionaORecursa() {
		// Se crea un alumno
		String nombreAlumno = "Gaston";
		String apellido = "Estevez";
		Integer dni = 1234;
		Alumno alumno = new Alumno(dni,apellido,nombreAlumno);
		
		// Se crea una cursada
		Integer id = 1;
		Double parcial1 = 6.0;
		Double parcial2 = 6.0;
		Double recuperatorioValor = 2.0;
		Nota nota1 = new Nota(parcial1);
		Nota nota2 = new Nota(parcial2);
		Nota recuperatorio = new Nota(recuperatorioValor);
		AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, id, nota1, nota2,recuperatorio);
		
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		
		boolean validarPromocion = unlam.validarSiPromociona(asignacionCursoAlumno);
		//assertTrue(validarPromocion);
		boolean validarAprobado = unlam.validarSiAprueba(asignacionCursoAlumno);//Va a recuperar una de las 2 notas y dependiendo eso va a final o no
		assertTrue(validarAprobado);
		boolean validarRecursar = unlam.validarSiRecursa(asignacionCursoAlumno);
		//assertTrue(validarRecursar);
		boolean validarRecuperatorio = unlam.validarRecuperatorio(asignacionCursoAlumno);
		assertTrue(validarRecuperatorio);

		

	}

	

}
