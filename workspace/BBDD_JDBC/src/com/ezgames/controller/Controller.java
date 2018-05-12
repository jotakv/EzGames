package com.ezgames.controller;

import java.sql.SQLException;

import com.ezgames.model.Consulta;
import com.ezgames.model.EjemploSingleton;
import com.ezgames.model.Gestion;

public class Controller {

	protected Gestion virtualStore;
	protected EjemploSingleton bd;
	private Consulta consulta;

	public Controller(Gestion virtualStore) {
		// TODO Auto-generated constructor stub
		this.virtualStore = virtualStore;
		consulta = new Consulta("");
	}

	public void run() {
		// TODO Auto-generated method stub
		virtualStore.run();
		// lanzar consulta

	}

	public void lanzarConsulta(String query, String colum) {
		// TODO Auto-generated method stub
		try {
			consulta.setQuery("SELECT * FROM PRODUCTOS WHERE PLATAFORMA=",
					"'PC'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
