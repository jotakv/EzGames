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
	private ProductoDAO productoDAO;
	private PersonaDAO personaDAO;

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
		personaDAO = new PersonaDAO();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas = personaDAO.listaDePersonas();
		for (Persona persona : personas) {
			if (persona.get_admin() == 1) {
				administradores.add((Administrador) persona);
			} else {
				usuarios.add((Usuario) persona);
			}
		}
	}

	private void obtenerAdministrador() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	private void obtenerProductos() {
		productoDAO = new ProductoDAO();
		productos = productoDAO.listaDeProductos();
	}

	public ArrayList<Producto> obtenerProductosPlataforma(String plataforma) {
		ArrayList<Producto> prodTemp = new ArrayList<Producto>();
		for (Producto p : productos) {
			if (plataforma.equalsIgnoreCase(plataforma)) {
				prodTemp.add(p);
			}
		}
		return prodTemp;
	}

	public Producto existeProducto(String nombre) {
		for (Producto p : productos) {
			if (nombre.equalsIgnoreCase(p.get_nombre())) {
				return p;
			}
		}
		return null;
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
