package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Control.Observator;

public class Gestion implements Observator {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Administrador> administradores;
	private ArrayList<Producto> productos;

	public Gestion() {
		usuarios = new ArrayList<Usuario>();
		administradores = new ArrayList<Administrador>();
		productos = new ArrayList<Producto>();
		obtenerUsuarios();
		obtenerAdministrador();
		obtenerProductos();
	}

	private void obtenerUsuarios() {

		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuarios_pass");
			ResultSet res = consulta.executeQuery();
			System.out.println("ID  NOMBRE PASSWORD  ADMINISTRADOR");
			while (res.next()) {
				// persona.setIdPersona(Integer.parseInt(res.getString("id")));
				int id = res.getInt("ID");

				// persona.setNombre(res.getString("USUARIOS"));
				String name = res.getString("USUARIOS");
				String pass = res.getString("PASSWORD");
				int isAdmin = res.getInt("ADMINISTRADOR");
				// quitar esta linea
				// y todos los System.out en general
				System.out.println(id + "  " + name + "   " + pass + " "
						+ isAdmin + " ");
				if (isAdmin == 1) {
					administradores.add(new Administrador(id, pass, name, "",
							""));//
				} else {
					usuarios.add(new Usuario(id, pass, name, "", ""));
				}

				// la siguiente linea es una prueba

				// obviamente hay que coregirla

			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
			e.printStackTrace();
		}
		// return miEmpleado;
	}

	private void obtenerAdministrador() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	private void obtenerProductos() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
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
