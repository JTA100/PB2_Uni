package ar.edu.unlam.materia;

public class Aula {
private Integer numeroDeAula;
private Integer capacidadDeLugares;

	public Aula(Integer numeroDeAula, Integer capacidadDeLugares) {
		this.numeroDeAula = numeroDeAula;
		this.capacidadDeLugares = capacidadDeLugares;
	}

	public Integer getNumeroDeAula() {
		return numeroDeAula;
	}

	public void setNumeroDeAula(Integer numeroDeAula) {
		this.numeroDeAula = numeroDeAula;
	}

	@Override
	public String toString() {
		return "Aula [numeroDeAula=" + numeroDeAula + ", capacidadDeAlumno=" + capacidadDeLugares + "]";
	}

	

	public void setCapacidadDeAlumno(Integer capacidadDeAlumno) {
		this.capacidadDeLugares = capacidadDeAlumno;
	}

	public Integer getCapacidadDeLugares() {
		return capacidadDeLugares;
	}

}
