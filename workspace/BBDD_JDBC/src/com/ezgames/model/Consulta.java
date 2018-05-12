package com.ezgames.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
	private String query;
	private Connection miConexion;
	private String result;

	public Consulta(String s) {
		// TODO Auto-generated constructor stub
		this.query = s;
		miConexion = EjemploSingleton.getConnection();
	}

	public void setQuery(String query, String plataforma) throws SQLException {

		this.query = query;

		// ejecutar instruccion sql
		ResultSet miResultSet = null;
		try {
			Statement miSatatement = miConexion.createStatement();
			// miResultSet = miSatatement
			// .executeQuery("SELECT * FROM PRODUCTOS WHERE PLATAFORMA="
			// + plataforma);
			String fullQuery = query + plataforma;
			System.out.println(fullQuery);
			miResultSet = miSatatement.executeQuery(fullQuery);
			// select NOMBREARTICULO WHERE CODIGOARTICULO='ART01'
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (miResultSet.next()) {

			result = miResultSet.getString("CÓDIGOARTÍCULO") + " "
					+ miResultSet.getString("NOMBREARTÍCULO") + ""
					+ miResultSet.getString("PRECIO");
			// System.out.println(miResultSet.getString("CÓDIGOARTÍCULO") + " "
			// + miResultSet.getString("NOMBREARTÍCULO") + ""
			// + miResultSet.getString("PRECIO"));
		}
	}

	public String getResult() {
		return result;
	}

}
