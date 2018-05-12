package com.ezgames.model;

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

		String url = "jdbc:mysql://localhost:3306/pruebaaa";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String password = "";

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