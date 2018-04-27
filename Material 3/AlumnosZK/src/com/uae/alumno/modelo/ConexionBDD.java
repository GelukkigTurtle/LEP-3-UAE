package com.uae.alumno.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexionBDD {

	private Connection connection;

	public ConexionBDD() {
		Properties properties = new Properties();
		try {
			//this.getServletContext().getRealPath(File.separator));
			/*properties.load(new FileInputStream("src/settings.properties"));
			String driverName = properties.getProperty("driverName");
			String jdbcUrl = properties.getProperty("jdbcUrl");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String serverName = properties.getProperty("serverName");
			String port = properties.getProperty("port");
			String databaseName = properties.getProperty("databaseName");*/
			
			String driverName = "com.mysql.jdbc.Driver";
			String jdbcUrl = "jdbc:mysql://";
			String user = "root";
			String password = "1234";
			String serverName = "localhost";
			String port = "3306";
			String databaseName = "lep3";
			
			try {
				Class.forName(driverName);
				connection = DriverManager.getConnection(jdbcUrl + serverName + ":" + port + "/" + databaseName, user,
						password);
				if (connection != null) {
					System.out.println("Conexion a BDD ha sido exitosa!");
				} else {
					System.out.println("Conexion a la BDD Fallida!");
				}
			} catch (Exception e) {
				System.out.println("Conexion a la BDD Fallida!");
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
