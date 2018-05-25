package com.uae.alumno.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
 			 System.out.println(sql);

			  ResultSet rs = conn.createStatement().executeQuery(sql);
	            while (rs.next()) {       
	                Alumno a = new Alumno();
	                a.setIdAlumno(rs.getInt("idAlumno"));
	                a.setNombre(rs.getString("nombres"));
	                a.setApellidos(rs.getString("apellidos"));
	                a.setEdad(rs.getInt("edad"));
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
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String insert = "INSERT INTO Alumno (nombres,apellidos,cum) "
					+ " values (?,?,?)";
		    
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellidos());
			ps.setFloat(3, alumno.getCum());
			
			System.out.println(insert);
			System.out.println("1) "+alumno.getNombre());
			System.out.println("2) "+alumno.getApellidos());
			System.out.println("3) "+alumno.getCum());
			
			//Ejecutamos el query en la base de datos
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Codigo que siempre se ejecutara
			// Se debe cerrar siempre la conexion a BDD
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update(Alumno alumno) {
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String update = "UPDATE Alumno set nombres = ? , apellidos = ? , CUM = ?, edad = ? Where idAlumno = ?";
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApellidos());
			ps.setFloat(3, alumno.getCum());
			ps.setFloat(4, alumno.getEdad());
			ps.setInt(5, alumno.getIdAlumno());
			
			System.out.println(update);
			System.out.println("1) "+alumno.getNombre());
			System.out.println("2) "+alumno.getApellidos());
			System.out.println("3) "+alumno.getCum());
			System.out.println("4) "+alumno.getEdad());
			System.out.println("5) "+alumno.getIdAlumno());

			//Ejecutamos el query en la base de datos
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Alumno alumno) {
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String  query = "Delete from Alumno where idAlumno = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, alumno.getIdAlumno());
			
			System.out.println(query);
			System.out.println("1) "+alumno.getIdAlumno());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


}
