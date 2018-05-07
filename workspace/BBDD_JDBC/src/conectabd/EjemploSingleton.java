package conectabd;

import java.sql.*;

public class EjemploSingleton {

	// Propiedades
	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;

	// Constructor
	private EjemploSingleton() {

		String url = "jdbc:mysql://localhost:3306/test";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "usuario";
		String password = "password";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	} // Fin constructor

	// Métodos
	public static Connection getConnection() {

		if (conn == null) {
			new EjemploSingleton();
		}

		return conn;
	} // Fin getConnection
}