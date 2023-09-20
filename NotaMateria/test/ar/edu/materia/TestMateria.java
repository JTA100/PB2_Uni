package ar.edu.materia;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ar.edu.unlam.materia.Materia;

public class TestMateria {
	
	@Test
	public void CrearUnaMateria() {
		Integer codigo = 123;
		String nombre = "Ingles";
		
		Materia materia = new Materia(nombre,codigo);
		assertNotNull(materia);
	}
	

	@Test
	public void AsignarUnaMateriaAUnCurso() {
		
	}
	
	
	@Test
	public void obtenerPromedio() {
	}
				/*
				 * Tarea hacer la intraconsulta real con lo que hizo el profe
				 * Una materia puede estar Asociada a varias comisiones 
				 * Una comision pertence a un ciclo Lectivoy asignar profesores a los cursos
				 * asignar Profesores a los cursos .   Un prof cada 20 alumnos,pedir cuatrimestre y años
				 * aborgea01 
				 */
	}

	
	

