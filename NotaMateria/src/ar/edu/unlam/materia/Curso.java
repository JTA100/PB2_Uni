package ar.edu.unlam.materia;

import java.util.ArrayList;

import ar.edu.materia.Comision;

public class Curso {
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Alumno>alumnos;
	private Comision comision;

	
	public Curso(Comision comision) {
		this.comision = comision;
		this.materias = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}
	
	public Comision getComision() {
		return comision;
	}


	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}





	public ArrayList<Materia> getMaterias() {
		return materias;
	}




	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}


	public ArrayList<Aula> getAulas() {
		return aulas;
	}


	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}


	public boolean agregarMateria(Materia materia) {
		return this.materias.add(materia);
	}


	public boolean agregarAula(Aula aula) {
		return this.aulas.add(aula);
	}



	public void setAnioDeCursada(ArrayList<CicloElectivo> anioDeCursada) {
	}

	public boolean agregarAlumnoAlCurso(Curso curso,AsignacionCursoAlumno asignacionCursoAlumno) {
		Alumno alumno = asignacionCursoAlumno.getAlumno() ;
			if(alumno != null && curso != null) {
				this.alumnos.add(alumno);
				asignacionCursoAlumno.agregarCurso(curso);
				return true;
		}
			return false;
	}


	public Alumno buscarAlumno(Alumno alumno, AsignacionCursoAlumno asignacionCursoAlumno,Curso curso) {
		for(int i = 0; i< this.alumnos.size();i++) {
			if(this.alumnos.get(i).equals(alumno) && asignacionCursoAlumno.getCursos().get(i).equals(curso)) {
				return this.alumnos.get(i);
				
			}
		}
		return null;
	}


	@Override
	public String toString() {
		return "Curso [materias=" + materias + ", aulas=" + aulas + ", alumnos=" + alumnos + ", comision=" + comision
				+ "]";
	}


	}

	