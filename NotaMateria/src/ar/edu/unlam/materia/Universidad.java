package ar.edu.unlam.materia;

import java.util.ArrayList;

package ar.edu.unlam.materia;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.materia.Comision;

public class Universidad {

	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Materia> guardarMateriasAprobada;
	private ArrayList<InscripcionMateria> inscripcionesMateria;
	private ArrayList<MateriasCorrelativas> materiasCorrelativas;
	private ArrayList<Aula> aulas;
	private ArrayList<CicloElectivo> cicloElectivo;
	private ArrayList<Curso> cursos;
	private ArrayList<AsignacionCursoAlumno> cursadas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Comision>comisiones;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
		this.materiasCorrelativas = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.cicloElectivo = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.cursadas = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.guardarMateriasAprobada = new ArrayList<>();
		this.comisiones = new ArrayList<>();
	}

	
	/*public void agregarAula(Aula aula) {
		this.aulas.add(aula);
	}
	
	public Integer obtenerCantidadAulas() {
		return this.aulas.size();//Devuelve la cantidad de elementos insertados
	}


	public Aula obtenerAulaPorNumero(Integer numeroDeAula) {
		for(int i = 0; i<  this.aulas.size();i++) {
			if(this.aulas.get(i).getNumeroDeAula().equals(numeroDeAula)) {
				return this.aulas.get(i);
			}
		}
		return null;
	}


	public void registrarMateria(Materia pb2) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean inscribirAlumnoAunMateria(Integer dni,Integer codigo) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		Integer cantidadDeInscriptos = this.obtenerCantidadInscriptosDeUnaMateria(codigo);
		if(alumno == null || materia == null && materia.getAula().getCapacidadDeLugares().equals(cantidadDeInscriptos) ) {
			return false;
		}
		
		ArrayList<Materia> correlativas = materia.getCorreclativas();
		for(int i = 0; i  < correlativas.size();i++) {
			Materia correlativa = correlativas.get(i);
			if(!estaAprobado(dni,correlativa.getCodigoMat())) {
				return false;
			}
		}
	}
	
	private boolean estaAprobado(Integer dni, Integer codigoMat) {
		// TODO Auto-generated method stub
		return false;
	}


	private Integer obtenerCantidadInscriptosDeUnaMateria(Integer codigo) {
		Integer cantidad = 0;
		for(int i = 0; i < this.inscripcionesMateria.size() ; i++) {
			if(this.inscripcionesMateria.get(i).getMateria().getCodigoMat().equals(codigo)) {
				cantidad++;
			}
		}
		return cantidad;
	}


	private Alumno buscarAlumnoPorDni(Integer dni) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean asignarAulaMateria(Integer numeroMateria,Integer numeroAula) {
		Boolean asigarAula = false;
		Materia materia = buscarMateriaPorCodigo(numeroMateria);
		Aula aula = this.obtenerAulaPorNumero(numeroAula);
		if(materia != null && aula!= null ) {
			materia.setAula(aula);
			asigarAula = true;
		}
		return asigarAula;
	}


	private Materia buscarMateriaPorCodigo(Integer numeroMateria) {
		// TODO Auto-generated method stub
		return null;
	}


/*	public Nota asgnarNota(AsignacionCursoAlumno asignacionCursoAlumno, Alumno alumno) {
		if(alumno != null &&  )
		return null;
	}

*/
/*	public Alumno BuscarAlumno(Curso curso, Alumno alumno) {
		for(int i = 0; i< this.cursos.size();i++) {
			if(this.cursos.get(i).getAlumno().equals(alumno)) {
				return this.cursos.get(i).getAlumno();
			}
		}
		return null;
	}*/


	public void cursadaFinalizada(AsignacionCursoAlumno asignacionCursoAlumno) {
		this.cursadas.add(asignacionCursoAlumno);
	}
//tener un metodo que verifique si el alumno prociono la materia 

	public boolean validarSiPromociona(AsignacionCursoAlumno asignacionCursoAlumno) {
		Double parcial1 = asignacionCursoAlumno.getParcial1().getParcial1();
		Double parcial2 = asignacionCursoAlumno.getParcial2().getParcial1();
		if( parcial1 >= 7 && parcial1 <= 10 &&  parcial2 >= 7 && parcial2 <= 10) {
			return true;
		}
		return false;
	}


	public boolean validarSiAprueba(AsignacionCursoAlumno asignacionCursoAlumno) {
		Double parcial1 = asignacionCursoAlumno.getParcial1().getParcial1();
		Double parcial2 = asignacionCursoAlumno.getParcial2().getParcial1();
		if( (parcial1 <= 10 && parcial1 >= 4 && parcial2 >= 4 && parcial2 <= 6) || (parcial2 <= 10 && parcial2 >= 4 && parcial1 >= 4 && parcial1 <= 6))  {
			return true;
		}	
		return false;
	
	}


	public boolean validarSiRecursa(AsignacionCursoAlumno asignacionCursoAlumno) {
		Double parcial1 = asignacionCursoAlumno.getParcial1().getParcial1();
		Double parcial2 = asignacionCursoAlumno.getParcial2().getParcial1();
		if( parcial1 < 4 && parcial2 < 4) {
			return true;
		}
		return false;
	}


	public boolean validarRecuperatorio(AsignacionCursoAlumno asignacionCursoAlumno) {
		Double parcial1 = asignacionCursoAlumno.getParcial1().getParcial1();
		Double parcial2 = asignacionCursoAlumno.getParcial2().getParcial1();
		Double recuperatorio = asignacionCursoAlumno.getRecuperatorio().getParcial1();
		
		if( (parcial1 <= 10 && parcial1 >= 4 && parcial2 >= 4 && parcial2 <= 6) || (parcial2 <= 10 && parcial2 >= 4 && parcial1 >= 4 && parcial1 <= 6) && recuperatorio >= 4 &&  recuperatorio <= 6 )  {
			return true;// Va a final
		}
		else if((parcial1 <= 10 && parcial1 >= 4 && parcial2 >= 4 && parcial2 <= 6) || (parcial2 <= 10 && parcial2 >= 4 && parcial1 >= 4 && parcial1 <= 6) && recuperatorio >= 7 &&  recuperatorio <= 10 ) {
			return true;// Promociono )
		}
		
		return false;
	}


	

	public boolean inscribirAlumno(CicloElectivo cicloElectivo2, Alumno alumno, LocalDate fechaQueSeQuiereInscribir) {
		if(cicloElectivo2.getInscripcionDeMateriasInicio().equals(fechaQueSeQuiereInscribir)  && alumno != null) {
			return true;
		}
		return false;
	}


	public boolean insribirAlumnoAMateria(Alumno alumno, Universidad universidad) {
		
		
		return false;
	}


	public void agregarAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}


	public void agregarTodasLasMaterias() {
		//Primer cuatrimestre
		Materia pb1 = new Materia("pb1",2619);
		Materia informaticaGeneral = new Materia("InformaticaGeneral",2620);
		Materia matematicaGeneral = new Materia("matematicaGeneral",2621);
		Materia inglesTecnico1 = new Materia("inglesTecnico1",2622);
		//Segundo cuatrimestre
		Materia pb2 = new Materia("pb2",2623);
		Materia pw1 = new Materia("pw1",2624);
		Materia baseDeDatos = new Materia("baseDeDatos",2625);
		Materia disenioGrafico = new Materia("disenioGrafico",2626);
		Materia inglesTecnico2 = new Materia("inglesTecnico2",2627);
		//Tercer cuatrimestre
		Materia disenioDeAplicacionesWeb = new Materia("disenioDeAplicacionesWeb",2629);
		Materia pw2 = new Materia("pw2",2628);
		Materia visualizacionesEInterfaces = new Materia("visualizacionesEInterfaces",2630);
		Materia tallerWeb1 = new Materia("tallerWeb1",2631);
		//Cuarto cuatrimestre
		Materia  baseDeDatos2 = new Materia("baseDeDatos2",2632);
		Materia pw3 = new Materia("pw3",2633);
		Materia tecnologiasDeRedes = new Materia("tecnologiasDeRedes",2634);
		Materia tallerWeb2 = new Materia("tallerWeb2",2635);
		Materia seguridadYCalidadEnAplicacionesWeb = new Materia("seguridadYCalidadEnAplicacionesWeb",2636);
		
		this.materias.add(pb1);
		this.materias.add(informaticaGeneral);
		this.materias.add(matematicaGeneral);
		this.materias.add(inglesTecnico1);
		this.materias.add(pb2);
		this.materias.add(pw1);
		this.materias.add(baseDeDatos);
		this.materias.add(disenioGrafico);
		this.materias.add(inglesTecnico2);
		this.materias.add(disenioDeAplicacionesWeb);
		this.materias.add(pw2);
		this.materias.add(visualizacionesEInterfaces);
		this.materias.add(tallerWeb1);
		this.materias.add(baseDeDatos2);
		this.materias.add(pw3);
		this.materias.add(tecnologiasDeRedes);
		this.materias.add(tallerWeb2);
		this.materias.add(seguridadYCalidadEnAplicacionesWeb);	
	}


	public boolean insribirAlumnoAMateria(Alumno alumno, Materia materia1, Materia materia2, Materia materia3, Materia materia4,Materia materia5,Comision comision) {//Solo se puede anotar en 5 mat debido a los horarios
		  boolean verificar = false;
		  final int LIMITE_DE_MATERIAS = 5; // Establece el límite deseado

		    ArrayList<Materia> materiasAInscribir = new ArrayList<>();
		    materiasAInscribir.add(materia1);
		    materiasAInscribir.add(materia2);
		    materiasAInscribir.add(materia3);
		    materiasAInscribir.add(materia4);
		    materiasAInscribir.add(materia5);

		    int contadorMateriasInscriptas = 0;

		    for (Materia materia : materiasAInscribir) {
		        if (materia != null) {
		            if (contadorMateriasInscriptas >= LIMITE_DE_MATERIAS) {
		            	
		                verificar = true; // El alumno ya se inscribió en el límite de materias
		            }

		            if (this.alumnos.contains(alumno) && this.materias.contains(materia) && (this.guardarMateriasAprobada.contains(materia) == false)) {// No verifica si ya aprobo la materia 
		                contadorMateriasInscriptas++;
		            } else {
		                verificar = true; // El alumno ya se inscribió en el límite de materias; // La materia no cumple alguna condición
		                this.comisiones.add(comision);
		                /*
		                 * Comision: Representa grupos de estudiantes que cursarán una materia en un ciclo lectivo específico . Tiene asignados profesores, alumnos, y registros de exámenes.
		                 */
		            }
		        }
		    }

		    return verificar; // El alumno se inscribió en todas las materias correctamente
		}


	public boolean guardarMateriaAprobada(Materia materia, Alumno alumno, Comision comision) {
	    for (Comision c : this.comisiones) {
	if (c.equals(comision) && c.getAlumno().equals(alumno)) {
	this.guardarMateriasAprobada.add(materia);
	            return true;
	        }
	    }
	return false;
	}


/*	public boolean guardarMateriaAprobrada(Materia materia, Alumno alumno, Comision comision) {
		for(int i = 0; i < this.comisiones.size();i++) {
			if(this.comisiones.get(i).equals(comision) && this.alumnos.get(i).equals(alumno) ) {
				this.guardarMateriasAprobada.add(comision.getMateria());
				return true;
			}
		}
		return false;
	}*/


	public void agregarAsignacionCursoAlumno(AsignacionCursoAlumno asignacionCursoAlumno) {
		this.cursadas.add(asignacionCursoAlumno);
	}


	public void agregarComision(Comision comision) {
		this.comisiones.add(comision);
	}
	
	/*
	// BUSCAR ALUMNO
	public Alumno buscarAlumno(Integer dni) {
		for (int i = 0; i < this.alumnos.length; i++) {
			if (this.alumnos[i] != null && this.alumnos[i].getDni() == dni) {
				return this.alumnos[i];
			}

		}
		return null;
	}

	// BUSCAR CODIGO DE MATERIA

	// REGISTRAR UN USUARIO
	public Alumno agregarAlumno(Alumno alumno) {
		for (int i = 0; i < this.alumnos.length; i++) {
			if (this.alumnos[i] == null) {
				return this.alumnos[i] = alumno;
			}
		}
		return null;
	}

	// REGISTRAR UNA MATERIA
	public Materia agregarMateria(Materia materia) {
		for (int i = 0; i < this.materias.length; i++) {
			if (this.materias[i] == null) {
				return this.materias[i] = materia;
			}
		}
		return null;
	}

	// CALIFICAR para pasando cod de nota,y meteria
	/*public boolean evaluar(Integer dni, AsignacionCursoProfesor cursada) {
		if(cursada.getAlumno().getDni().equals(dni) && cursada.getNota().getValor() >= 4) {
			return true;
		}
		return false;
	}*/

	/*public AsignacionCursoProfesor buscarCursada(AsignacionCursoProfesor cursada) {
		for(int i = 0; i< this.cursadas.length;i++) {
			if(this.cursadas[i] != null && this.cursadas[i].equals(cursada)) {
				return this.cursadas[i] ;
			}
		}
		return null;
	}

	public AsignacionCursoProfesor agregarCursada(AsignacionCursoProfesor cursada) {
		for (int i = 0; i < this.cursadas.length; i++) {
			if (this.cursadas[i] == null) {
				return this.cursadas[i] = cursada;
			}
		}
		return null;
	}

	public Integer buscarCodigo(Integer codigoMat) {
		for (int i = 0; i < this.codigos_mat.length; i++) {
			if (this.codigos_mat[i] != null && this.codigos_mat[i].equals(codigoMat)) {
				return this.codigos_mat[i];
			}
		}
		return null;
	}*/

	/*public Nota buscarNotaAlumno(Alumno buscarAlumno, Integer buscarCodigo, AsignacionCursoProfesor buscarCursada) {
			if(buscarCursada.getMateria().getCodigoMat().equals(buscarCodigo) && buscarCursada.getAlumno().equals(buscarAlumno)) {
				return buscarCursada.getNota();
			}
		return null;
	}*/



	/*public Nota asignarNota(Nota nota, Alumno buscarAlumno, AsignacionCursoProfesor cursada,Integer codMat) {
		if(cursada.getAlumno().equals(buscarAlumno) && cursada.getMateria().getCodigoMat().equals(codMat)) {
			 cursada.setNota(nota);
			 return cursada.getNota();
	}
		return null;

	}*/
	
	/*public Double promedioNotas(Nota nota1,Nota nota2) {
		Double resultado = 0.0;
		resultado = (double) ((nota1.getValor() + nota2.getValor()) / 2);
	return resultado;
	}*/

	
	/*public boolean validarMateriaAprobada(Nota nota1,Nota nota2) {
		if(nota1.getValor() >= 7 && nota2.getValor() >= 7) {
			return true;
		}
		
		return false;
	}


	public boolean guardarMateriaAprobada(AsignacionCursoProfesor agregarCursadaPb2, Alumno alumno, Materia materia1,boolean validarSiApruebaONoPB2) {
		for(int i = 0; i< this.materiasAprobadas.length;i++) {
			// Si se encuentra el curso donde esta el alumno con su materia y aprobo
			if(this.materiasAprobadas[i] == null && agregarCursadaPb2.getAlumno().equals(alumno) && agregarCursadaPb2.getMateria().equals(materia1) && validarSiApruebaONoPB2) {
				this.materiasAprobadas[i] = materia1;
				return true;
			}
		}
		return false;
	}

	public boolean verificarInscrirAMateria(boolean guardarMateriasAprobadasPB2, boolean guardarMateriasAprobadasPW1,
			boolean guardarMateriasAprobadasBDB, Materia agregarMateria4) {
		if(guardarMateriasAprobadasPB2 && guardarMateriasAprobadasPW1 && guardarMateriasAprobadasBDB) {
			return true;
		}
		return false;
	}*/
}