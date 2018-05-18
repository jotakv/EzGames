package Control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Gestion;
import datos.Producto;

public final class Controlador implements Observator<Object> {

	private static Controlador instance = null;// PATRON SINGLETON
	// atributo privado estatico de la clase
	private Gestion gestion;
	private boolean loged;

	/**
	 * Constructor privado (PATRON SINGLETON)
	 */
	private Controlador() {
		gestion = new Gestion();
		// obtenerUsuarios();
		// obtenerAdministradores();
		// obtenerProductos();
	}

	/**
	 * Metodo get estatico y publico para devolver el atributo. Devuelve la
	 * propia instancia. PATRON SINGLETON
	 * 
	 * @return
	 */
	public static Controlador getInstance() {
		if (instance == null)
			instance = new Controlador();
		return instance;
	}

	@Override
	public void addObservador(Object o) {
		gestion.addObservador(o);
	}

	@Override
	public void removeObservador(Object o) {
		gestion.removeObservador(o);
	}

	@Override
	public void notifyLogin() {

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

	public ArrayList<Producto> obtenerProductosPlataforma(String plataforma) {
		return gestion.obtenerProductosPlataforma(plataforma);
	}

	public Producto buscarProducto(String nombre) {
		Producto p = gestion.existeProducto(nombre);
		if (p != null)
			JOptionPane.showMessageDialog(null, "Producto encontrado\n");
		else
			JOptionPane.showMessageDialog(null, "Producto no encontrado\n");

		return p;
	}

	public void login(String usuario, String passwd) {
		loged = gestion.login(usuario, passwd);
		if (loged)
			JOptionPane.showMessageDialog(null, "Usuario logeado\n");
		else
			JOptionPane.showMessageDialog(null,
					"Usuario o contraseña incorrectas\n");

	}

	public boolean isLoged() {
		return loged;
	}

}
