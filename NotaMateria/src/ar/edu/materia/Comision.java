package ar.edu.materia;


	import java.util.ArrayList;

import ar.edu.unlam.materia.Alumno;
import ar.edu.unlam.materia.AsignacionCursoAlumno;
import ar.edu.unlam.materia.CicloElectivo;
import ar.edu.unlam.materia.Curso;
import ar.edu.unlam.materia.Materia;
import ar.edu.unlam.materia.Nota;
import ar.edu.unlam.materia.Profesor;

	public class Comision {


		private Integer id;
		private Integer cantidadDeAlumnos;
		private Integer cantidadDeProfesores;
		private Alumno alumno;
		private Materia materia;
		private Double horarioDeEntrada;
		private Double horarioDeSalida;
		private ArrayList<Nota>guardarNotas;
		private ArrayList<Profesor>profesores;



		public Comision( Integer cantidadDeAlumno, Integer cantidadDeProfesores, Alumno alumno, Materia materia,
				Double horarioDeEntrada, Double horarioDeSalida, CicloElectivo cicloElectivo) {
			this.id = 0;
			incrementarElIdentificador();
			this.cantidadDeAlumnos = cantidadDeAlumno;
			this.cantidadDeProfesores = cantidadDeProfesores;
			this.alumno = alumno;
			this.materia = materia;
			this.horarioDeEntrada = horarioDeEntrada;
			this.horarioDeSalida  = horarioDeSalida;
			this.guardarNotas = new ArrayList<>();
			this.profesores = new ArrayList<>();
		}
		
		private void incrementarElIdentificador(){
			this.id++;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getCantidadDeAlumnos() {
			return cantidadDeAlumnos;
		}

		public void setCantidadDeAlumnos(Integer cantidadDeAlumnos) {
			this.cantidadDeAlumnos = cantidadDeAlumnos;
		}

		public Integer getCantidadDeProfesores() {
			return cantidadDeProfesores;
		}

		public void setCantidadDeProfesores(Integer cantidadDeProfesores) {
			this.cantidadDeProfesores = cantidadDeProfesores;
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

		public Double getHorarioDeEntrada() {
			return horarioDeEntrada;
		}

		public void setHorarioDeEntrada(Double horarioDeEntrada) {
			this.horarioDeEntrada = horarioDeEntrada;
		}


		public Double getHorarioDeSalida() {
			return horarioDeSalida;
		}

		public void setHorarioDeSalida(Double horarioDeSalida) {
			this.horarioDeSalida = horarioDeSalida;
		}

		public ArrayList<Nota> getGuardarNotas() {
			return guardarNotas;
		}

		public void setGuardarNotas(ArrayList<Nota> guardarNotas) {
			this.guardarNotas = guardarNotas;
		}
		
		public ArrayList<Profesor> getProfesores() {
			return profesores;
		}

		public void setProfesores(ArrayList<Profesor> profesores) {
			this.profesores = profesores;
		}

		@Override
		public String toString() {
			return "Comision [id=" + id + ", cantidadDeAlumnos=" + cantidadDeAlumnos + ", cantidadDeProfesores="
					+ cantidadDeProfesores + ", alumno=" + alumno + ", materia=" + materia + ", horarioDeEntrada="
					+ horarioDeEntrada + ", horarioDeSalida=" + horarioDeSalida + ", guardarNotas=" + guardarNotas + "]";
		}



		
		
		public boolean validarNota(Nota parcial1, Nota parcial2,AsignacionCursoAlumno asignacionCursoAlumno,Curso curso) {
			ArrayList<Curso> cursos = asignacionCursoAlumno.getCursos();
			for(int i = 0; i < cursos.size();i++)
			if(curso != null && cursos.get(i).equals(curso))
			if(asignacionCursoAlumno.promociona(parcial1, parcial2, alumno, curso)) {
				this.guardarNotas.add(parcial1);
				this.guardarNotas.add(parcial2);
				return true;
			}
			return false;
		}

		public boolean validarNotaFinal(Nota finals, AsignacionCursoAlumno asignacionCursoAlumno, Curso curso) {
			ArrayList<Curso> cursos = asignacionCursoAlumno.getCursos();
			for(int i = 0; i < cursos.size();i++)
			if(curso != null && cursos.get(i).equals(curso))
			if(asignacionCursoAlumno.notaFinalSiAprobo(finals, alumno, curso)) {
				this.guardarNotas.add(finals);
				return true;
			}
			return false;
		}

		public Integer CantidadDeProfesores(Integer cantidadDeAlumno) {
			Integer resultado= cantidadDeAlumno/20;
			return resultado;
		}

		public void agregarProfesor(Profesor profesor) {
			
			this.profesores.add(profesor);
			
		}

		public boolean verificarCantidadP() {
			
			if(this.profesores.size() == (this.cantidadDeAlumnos/20)) {
				
				return true;
				
			}
			
			return false;
			
		}
		
		

}
