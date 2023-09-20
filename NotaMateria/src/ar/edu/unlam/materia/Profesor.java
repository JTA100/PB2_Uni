package ar.edu.unlam.materia;

public class Profesor {
	
	private String nombre;
	private Integer id_p;
	
	
	public Profesor( String nombre) {
		this.setNombre(nombre);
		this.id_p=0;
		
		incrementarId(id_p);
	}


	private void incrementarId(Integer id_p2) {
		
		this.id_p++;

	}


	
	//// getters y setters
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", id_p=" + id_p + "]";
	}
	

	

}
