package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Control.Observator;

public class Gestion implements Observator {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Administrador> administradores;
	private ArrayList<Producto> productos;
	private DbConnection conex;
	private PreparedStatement consulta;
	private ResultSet res;

	public Gestion() {
		conex = new DbConnection();
		usuarios = new ArrayList<Usuario>();
		administradores = new ArrayList<Administrador>();
		productos = new ArrayList<Producto>();
		obtenerUsuarios();
		obtenerAdministrador();
		obtenerProductos();
	}

	private void ejecutarConsulta(String consultaSQL) {
		consulta = null;
		res = null;
		try {
			consulta = conex.getConnection().prepareStatement(consultaSQL);
			res = consulta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void obtenerUsuarios() {

		try {
			ejecutarConsulta("SELECT * FROM usuarios_pass");
			System.out.println("ID  NOMBRE PASSWORD  ADMINISTRADOR");

			while (res.next()) {
				int id = res.getInt("ID");
				String name = res.getString("USUARIOS");
				String pass = res.getString("PASSWORD");
				int isAdmin = res.getInt("ADMINISTRADOR");
				// quitar esta lineay todos los System.out en general
				System.out.println(id + "  " + name + "   " + pass + " "
						+ isAdmin + " ");
				if (isAdmin == 1) {
					administradores.add(new Administrador(id, pass, name, "",
							""));
				} else {
					usuarios.add(new Usuario(id, pass, name, "", ""));
				}
			}
			protocoloFinalizarConsulta();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e.toString());
		}
	}

	private void protocoloFinalizarConsulta() {
		// TODO Auto-generated method stub
		try {
			res.close();
			consulta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void obtenerAdministrador() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	private void obtenerProductos() {
		try {
			ejecutarConsulta("SELECT * FROM productos");
			System.out
					.println("CodArticulo  Plataforma Nombre articulo  precio");
			while (res.next()) {
				String cod = res.getString("CÓDIGOARTÍCULO");
				String plat = res.getString("PLATAFORMA");
				String nomartic = res.getString("NOMBREARTÍCULO");
				double precio = res.getDouble("PRECIO");
				productos.add(new Producto(cod, nomartic, plat, precio, 12));
				// quitar esta lineay todos los System.out en general
				System.out.println("  " + cod + "   " + plat + " " + nomartic
						+ " " + precio);

			}
			protocoloFinalizarConsulta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean existeProducto(String nombre) {
		for (Producto p : productos) {
			if (nombre.equalsIgnoreCase(p.get_nombre())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * permite consultar la lista de empleados
	 * 
	 * @return
	 */

	public boolean login(String usuario, String passwd) {
		for (Administrador administrador : administradores) {
			if (administrador.getNombre().equalsIgnoreCase(usuario)
					&& administrador.getPasswd().equalsIgnoreCase(passwd)) {
				return true;
			}
		}
		for (Usuario user : usuarios) {
			if (user.getNombre().equalsIgnoreCase(usuario)
					&& user.getPasswd().equalsIgnoreCase(passwd)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void addObservador(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void removeObservador(Object o) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void notifyLogin() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void notifyCompra() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void notifyModProducto() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}
}
