package ar.edu.materia;

import org.junit.Test;
	import static org.junit.Assert.assertTrue;

	import java.time.LocalDate;

	import org.junit.Test;

	import ar.edu.unlam.materia.Alumno;
	import ar.edu.unlam.materia.AsignacionCursoAlumno;
	import ar.edu.unlam.materia.CicloElectivo;
	import ar.edu.unlam.materia.Curso;
	import ar.edu.unlam.materia.Materia;
	import ar.edu.unlam.materia.Nota;
	import ar.edu.unlam.materia.Universidad;

	public class TestAsignacionCursoAlumno {

		@Test
		public void queUnAlumnoSePuedaInscribirAUnaMateria() {
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
			// verificar que el alumno se pueda inscribir en el dia correcto
			LocalDate diaQueSeQuiereInscribir = LocalDate.parse(inicio);
			boolean verificacion = cicloElectivo.verificarDiaDeInscripcion(diaQueSeQuiereInscribir);
			assertTrue(verificacion);

			// Si es el dia de inscripcion que se anote a una materia o mas
			// Materias
			Materia materia = new Materia("pb1", 2619);

			Universidad universidad = new Universidad("Unlam");
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			universidad.agregarAlumno(alumno);
			universidad.agregarTodasLasMaterias();
		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			
			Comision comision = new Comision( cantidadDeAlumno, cantidadDeProfesores, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			boolean insribirAlumnoAMateria = universidad.insribirAlumnoAMateria(alumno, materia, null, null, null, null,comision);// Solo te puedes anotar en 5 materias
			assertTrue(insribirAlumnoAMateria);
		}
		
		/*@Test public void asignarNota() { 
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, cantidadDeProfesores, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 4.0; 
		    Double notaParcial2 = 4.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
	       boolean notaFinalSiVaAFinal = asignacionCursoAlumno.notaFinalSiVaAFinal(parcial1,parcial2,alumno,curso);
	        assertTrue(notaFinalSiVaAFinal); // Si va a final se le asigna una nota del final
	        
	        Double notaFinals = 10.0; 
		    finals = new Nota(notaFinals);
		    
	        boolean asignarFinal = asignacionCursoAlumno.asignarNotaFinal(notaFinals,alumno,curso);
	        assertTrue(asignarFinal);
	        
	        boolean notaFinalSiAprueba = asignacionCursoAlumno.notaFinalSiAprobo(finals, alumno, curso);
	        //assertTrue(notaFinalSiAprueba);
	        
	       // boolean notaSiPromociona = asignacionCursoAlumno.promociona(parcial1,parcial2,alumno,curso);
	     //   assertTrue(notaSiPromociona);
	        
	       // boolean notaSiRecursa = asignacionCursoAlumno.recursa(parcial1,parcial2,alumno,curso);
	       // assertTrue(notaSiRecursa);
		}*/
		
		@Test public void guardarMateriasAprobadas() {
			Alumno alumno = new Alumno(1234, "Estevez", "Gaston");
			Materia materia = new Materia("pb1", 2619);
			
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
			//Se crea una comision 		
			Integer cantidadDeAlumno = 100;
			Integer cantidadDeProfesores = 0;
			Double horarioDeEntrada = 8.0;
			Double horarioDeSalida = 12.0;
			Comision comision = new Comision( cantidadDeAlumno, cantidadDeProfesores, alumno, materia,horarioDeEntrada,horarioDeSalida, cicloElectivo);
			//Se crea un curso
			Curso curso = new Curso(comision);
			
			// En la clase AsignacionCurso se relaciona con el alumno y curso
			Nota parcial1 = null; 
			Nota parcial2 = null;
			Nota recuperatorio = null;
			Nota finals = null;
		    AsignacionCursoAlumno asignacionCursoAlumno = new AsignacionCursoAlumno(alumno, parcial1, parcial2,recuperatorio,finals);
		    
		    asignacionCursoAlumno.agregarCurso(curso);
		    //Se crean las notas
		    Double notaParcial1 = 6.0; 
		    Double notaParcial2 = 4.0; 
		    parcial1 = new Nota(notaParcial1); 
		    parcial2 = new Nota(notaParcial2); 
		    boolean asignarNota1 = asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso);
		    boolean asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,curso);
		    assertTrue(asignarNota1); 
		    assertTrue(asignarNota2);
		    
	       /* boolean notaFinalSiVaAFinal = asignacionCursoAlumno.notaFinalSiVaAFinal(parcial1,parcial2,alumno,curso);
	        assertTrue(notaFinalSiVaAFinal); // Si va a final se le asigna una nota del final
	        
		    Double notaFinals = 9.0; 
		    finals = new Nota(notaFinals);
		    boolean asignarFinal = asignacionCursoAlumno.asignarNotaFinal(finals,alumno,curso);
	        assertTrue(asignarFinal);*/
	        
	        Double notaRecuperatorio = 4.0;
	        recuperatorio = new Nota(notaRecuperatorio);
	        boolean asignarRecupe
	       // boolean notaSiPromociona = asignacionCursoAlumno.promociona(parcial1,parcial2,alumno,curso);
	       // assertTrue(notaSiPromociona);
	        
	      //  boolean notaSiRecursa = asignacionCursoAlumno.recursa(parcial1,parcial2,alumno,curso);
	      //  assertTrue(notaSiRecursa);
	        
	        // Si aprueba la materia la unlam la guarda
	        // Y para hacer eso se necesita que el la comision guarde el registro de notas y verifique que este aprobada  
	        // y que la unlam busque la comision con la materia aprobada

	        boolean verificarSiEstaAprobadoElFinal = comision.validarNotaFinal(finals,asignacionCursoAlumno,curso);
	        assertTrue(verificarSiEstaAprobadoElFinal);
	        
	        //boolean verificarSiEstaAprobado = comision.validarNota(parcial1,parcial2,asignacionCursoAlumno,curso);
	       // assertTrue(verificarSiEstaAprobado);// si es verdadero
	     
	        Universidad universidad = new Universidad("Unlam");
	        universidad.agregarComision(comision);
	        boolean guardarMateriaAprobada = universidad.guardarMateriaAprobada(materia,alumno,comision);
	        assertTrue(guardarMateriaAprobada);
		}

		/*
		 * @Test public void ObtenerPromedioNotaYNotaFinal() { // Se crea un alumno
		 * String nombre = "Gaston"; String apellido = "Estevez"; Integer dni = 1234;
		 * Alumno alumno = new Alumno(dni, apellido, nombre);
		 * 
		 * // En la clase AsignacionCurso se relaciona con el alumno y cursow Integer id
		 * = 1; Nota parcial1 = null; Nota parcial2 = null; Nota recuperatorio = null;
		 * AsignacionCursoAlumno asignacionCursoAlumno = new
		 * AsignacionCursoAlumno(alumno, id, parcial1, parcial2,recuperatorio);
		 * 
		 * 
		 * String numeroDeComision = "1-2363"; Integer horarioDeSalida = 12; Integer
		 * horarioDeEntrada = 7; Curso curso = new Curso(numeroDeComision,
		 * horarioDeEntrada, horarioDeSalida);
		 * 
		 * asignacionCursoAlumno.agregarCurso(curso); Double notaParcial1 = 5.0; Double
		 * notaParcial2 = 6.5; parcial1 = new Nota(notaParcial1); parcial2 = new
		 * Nota(notaParcial2); boolean asignarNota1 =
		 * asignacionCursoAlumno.asignarParcial1(parcial1, alumno, curso); boolean
		 * asignarNota2 = asignacionCursoAlumno.asignarParcial2(parcial2, alumno,
		 * curso); assertNotNull(asignacionCursoAlumno.getParcial2()); //
		 * assertTrue(asignarNota2); boolean notaFinalSiVaAFinal =
		 * asignacionCursoAlumno.notaFinalSiVaAFinal(parcial1.getParcial1(),parcial2.
		 * getParcial2(),alumno,curso); assertTrue(notaFinalSiVaAFinal); /* Double
		 * notaRecuperatorio = 5.0; recuperatorio = new Nota(notaRecuperatorio);
		 */

	}

}
