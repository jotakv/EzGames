package Control;

import javax.swing.JOptionPane;

import datos.Gestion;

public class Controlador implements Observator<Object> {

	private static Controlador instance = null;
	private Gestion gestion;
	private boolean isLoged;

	public Controlador() {
		gestion = new Gestion();
		// obtenerUsuarios();
		// obtenerAdministradores();
		// obtenerProductos();
	}

	// PATRON SINGLETON
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

	public void login(String usuario, String passwd) {
		isLoged = gestion.login(usuario, passwd);
		if (isLoged) {
			JOptionPane.showMessageDialog(null, "Usuario logeado\n");

		}
	}
}
