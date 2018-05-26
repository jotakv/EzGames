package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *Clase que permite implementar el patron DAO
 * en lo referente a las valoraciones
 * @author EZGames
 */
public class ProductoDAO {

	/**
	 * permite consultar la lista de productos
	 * @return lista de productos
	 */
	public ArrayList<Producto> listaDeProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM productos");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {

				String cod = res.getString("CÓDIGOARTÍCULO");
				String plat = res.getString("PLATAFORMA");
				String nomartic = res.getString("NOMBREARTÍCULO");
				double precio = res.getDouble("PRECIO");
				int stock = res.getInt("STOCK");
				productos.add(new Producto(cod, nomartic, plat, precio, stock));
				System.out.println(cod + "--------" + plat + "--------" + nomartic + "--------"
						+ precio);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar el producto\n" + e);
		}
		return productos;
	}

}
