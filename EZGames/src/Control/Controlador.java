package control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Gestion;
import datos.Producto;

public final class Controlador {

	private static Controlador instance = null;// PATRON SINGLETON
	// atributo privado estatico de la clase
	private Gestion gestion;
	private boolean loged;

	/**
	 * Constructor privado (PATRON SINGLETON)
	 */
	private Controlador() {
		gestion = new Gestion();
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

	public void addObservador(ObservatorClases o) {
		gestion.addObservador(o);
	}

	public void removeObservador(ObservatorClases o) {
		gestion.removeObservador(o);
	}

	public void login(String usuario, String passwd) {
		loged = gestion.login(usuario, passwd);
		if (loged)
			JOptionPane.showMessageDialog(null, "Usuario logeado\n");
		else
			JOptionPane.showMessageDialog(null,
					"Usuario o contrase�a incorrectas\n");

	}

	public ArrayList<Producto> obtenerProductosPlataforma(String plataforma) {
		return gestion.obtenerProductosPlataforma(plataforma);
	}

	public ArrayList<Producto> buscarProducto(String nombre) {
		ArrayList<Producto> prodTemp = gestion.existeProducto(nombre);
		if (!prodTemp.isEmpty())
			JOptionPane.showMessageDialog(null, "Producto encontrado\n");
		else
			JOptionPane.showMessageDialog(null, "Producto no encontrado\n");

		return prodTemp;
	}

	public boolean isLoged() {
		return loged;
	}

}
