package com.ezgames.model;

import java.sql.*;

public class ConectaPruebas {

	private static Connection miConexion;

	public static void main(String[] args) {
		//Connection miConexion;
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pruebaaa", "root", ""); // lanzar
																			// una
																			// query

			Statement miSatatement = miConexion.createStatement(); // ejecutar
			// instruccion sql
			ResultSet miResultSet = miSatatement
					.executeQuery("SELECT * FROM PRODUCTOS WHERE PLATAFORMA='PC'");
//SELECT * FROM PRODUCTOS WHERE PLATAFORMA='PC'
			while (miResultSet.next()) {

				System.out.println(miResultSet.getString("CÓDIGOARTÍCULO")
						+ " " + miResultSet.getString("NOMBREARTÍCULO") + " "
						+ miResultSet.getString("PRECIO"));
			}

		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}
	}
}
