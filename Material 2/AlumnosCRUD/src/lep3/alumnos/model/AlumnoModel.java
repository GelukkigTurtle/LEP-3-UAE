package lep3.alumnos.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoModel {
	
	public ArrayList<Alumno> getAll(){
		Connection conn = null;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			conn = new ConexionBDD().getConnection();
			 String sql = "Select * from Alumno";
			  ResultSet rs = conn.createStatement().executeQuery(sql);
	            while (rs.next()) {       
	                Alumno a = new Alumno();
	                a.setIdAlumno(rs.getInt("idAlumno"));
	                a.setNombre(rs.getString("nombres"));
	                a.setApellidos(rs.getString("apellidos"));
	                a.setCum(rs.getFloat("cum"));

	                alumnos.add(a);
	            }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return alumnos;
		
	}
	
	public void insert(Alumno alumno) {
		
	}
	
	public void update(Alumno alumno) {
			
	}
	
	public void delete(Alumno alumno) {
		
	}


}
