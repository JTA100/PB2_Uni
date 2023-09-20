package ar.edu.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.materia.Alumno;
import ar.edu.unlam.materia.CicloElectivo;
import ar.edu.unlam.materia.Profesor;

public class TestAsignacionCursoProfesor {

	@Test
	public void agregarProfesorAUnaConmision() {
		
		String inicio = "2023-09-14";
		String finalizacion = "2023-12-31";
		String inscripcionInicio = "2023-09-13";
		String inscripcionFinalizacion = "2023-09-14";

		LocalDate fechaInicioCicloElectivo = LocalDate.parse(inicio);
		LocalDate fechaFinalizacionCicloElectivo = LocalDate.parse(finalizacion);
		LocalDate inscripcionDeMateriasInicio = LocalDate.parse(inscripcionInicio);
		LocalDate inscripcionDeMateriasFinalizacion = LocalDate.parse(inscripcionFinalizacion);

		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloElectivo, fechaFinalizacionCicloElectivo,
				inscripcionDeMateriasInicio, inscripcionDeMateriasFinalizacion);
		
		Profesor profesor = new Profesor("Andres");
		Profesor profesor2 = new Profesor("Marcos");
		
		Integer cantidadDeAlumno = 40;
		Integer cantidadDeProfesores = 0;
		Double horarioDeEntrada = 8.0;
		Double horarioDeSalida = 12.0;
		
		Comision comision = new Comision( cantidadDeAlumno, cantidadDeProfesores, null, null,horarioDeEntrada,horarioDeSalida, cicloElectivo);
		comision.agregarProfesor(profesor);
		comision.agregarProfesor(profesor2);
		
		
		
		
		/// asserts

		assertTrue(comision.verificarCantidadP());
		
	}

}
