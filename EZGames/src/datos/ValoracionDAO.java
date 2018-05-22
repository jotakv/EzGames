package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ValoracionDAO {

	
	public ArrayList<Valoracion> listaDeValoraciones() {
		ArrayList<Valoracion> valoraciones = new ArrayList<Valoracion>();
		DbConnection conex = new DbConnection();
		
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM valoraciones");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {

				String cod = res.getString("CODIGO");
				String producto = res.getString("PRODUCTO");
				String usuario = res.getString("USUARIO");
				String texto = res.getString("TEXTO");
				valoraciones.add(new Valoracion(cod, producto, usuario, texto));
				System.out.println(cod + "--------" + producto + "--------" + usuario + "--------"
						+ texto);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la valoracion\n" + e);
		}
		return valoraciones;
	}
		
}
