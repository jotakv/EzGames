package conectabd;

import java.sql.*;

public class ConectaPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// user: root
			// password: ""
			// "" es vacio
			Connection miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pruebas", "root", "");
			// lanzar una query

			Statement miSatatement = miConexion.createStatement();
			// ejecutar instruccion sql
			ResultSet miResultSet = miSatatement
					.executeQuery("SELECT * FROM PRODUCTOS");

			while (miResultSet.next()) {

				System.out.println(miResultSet.getString("CÓDIGOARTÍCULO")
						+ " " + miResultSet.getString("NOMBREARTÍCULO") + ""
						+ miResultSet.getString("PRECIO"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
