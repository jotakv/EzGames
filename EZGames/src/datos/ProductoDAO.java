package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Patron DAO con metodos CRUD
 * 
 * @author Usuario
 *
 */
public class ProductoDAO {

	/**
	 * permite consultar la lista de productos
	 * 
	 * @return
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
				productos.add(new Producto(cod, nomartic, plat, precio, 12));
				System.out.println(cod + "--------" + plat + "--------"
						+ nomartic + "--------" + precio);
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
