package lep3.alumnos.model;

public class Alumno {
	
	private Integer idAlumno;
	private String nombre;
	private String apellidos;
	private Float cum;
	
	public Alumno(int idAlumno, String nombre, String apellidos, float cum) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cum = cum;
	}

	public Alumno() {
		super();
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
	
	
	
	
	
	

}
