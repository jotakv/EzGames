package Control;

import javax.swing.JOptionPane;

import datos.Gestion;

public final class Controlador implements Observator<Object> {

	private static Controlador instance = null;// PATRON SINGLETON
	// atributo privado estatico de la clase
	private Gestion gestion;
	private boolean loged;
	private boolean existeProducto;

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

	public void buscarProducto(String nombre) {
		existeProducto = gestion.existeProducto(nombre);
		if (existeProducto)
			JOptionPane.showMessageDialog(null, "Producto encontrado\n");
		else
			JOptionPane.showMessageDialog(null, "Producto no encontrado\n");
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
