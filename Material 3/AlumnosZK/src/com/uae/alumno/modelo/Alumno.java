package com.uae.alumno.modelo;

public class Alumno {
	
	private Integer idAlumno;
	private String nombre;
	private String apellidos;
	private Float cum;
	private Integer edad;
	
	
	
	public Alumno() {
		super();
	}

	public Alumno(Integer idAlumno, String nombre, String apellidos, Float cum, Integer edad) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cum = cum;
		this.edad = edad;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Float getCum() {
		return cum;
	}

	public void setCum(Float cum) {
		this.cum = cum;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
	
	

}
