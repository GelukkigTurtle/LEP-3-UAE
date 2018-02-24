package lep3.alumnos.model;

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
			properties.load(new FileInputStream("src/lep3/alumnos/setting.properties"));
			String driverName = properties.getProperty("driverName");
			String jdbcUrl = properties.getProperty("jdbcUrl");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String serverName = properties.getProperty("serverName");
			String port = properties.getProperty("port");
			String databaseName = properties.getProperty("databaseName");
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
