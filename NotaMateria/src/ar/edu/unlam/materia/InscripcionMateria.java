package ar.edu.unlam.materia;

public class InscripcionMateria {

	private Alumno alumno;
	private Materia materia;
	private Nota nota;
	private Aula aula;
	
	public InscripcionMateria(Alumno alumno,Materia materia,Aula aula) {
	this.alumno = alumno;
	this.materia = materia;
	this.aula = aula;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	
}
