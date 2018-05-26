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
	 * @return this
	 */
	public static Controlador getInstance() {
		if (instance == null)
			instance = new Controlador();
		return instance;
	}

	/**
	 * Comunica con gestion para anadir observer
	 * @param o observadores a anadir
	 */
	public void addObservador(ObservatorClases o) {
		gestion.addObservador(o);
	}
	/**
	 * Comunica con gestion para eliminar observer
	 * @param o observador a remover
	 */
	public void removeObservador(ObservatorClases o) {
		gestion.removeObservador(o);
	}
	/**
	 * Controla la gestion de loguearse del usuario
	 * @param usuario nombre de usuario
	 * @param passwd contrasena del usuario
	 */
	public void login(String usuario, String passwd) {
		loged = gestion.login(usuario, passwd);
		if (loged)
			JOptionPane.showMessageDialog(null, "Usuario logeado\n");
		else
			JOptionPane.showMessageDialog(null,
					"Usuario o contrase�a incorrectas\n");

	}
	/**
	 * Obtiene lista de productos por plataforma
	 * @param plataforma nombre de la plataforma para filtrar
	 * @return lista de productos segun la busqueda
	 */
	public ArrayList<Producto> obtenerProductosPlataforma(String plataforma) {
		return gestion.obtenerProductosPlataforma(plataforma);
	}
	/**
	 * Permite buscar un producto
	 * @param nombre nombre del producto a buscar
	 * @return lista de productos segun la busqueda
	 */
	public ArrayList<Producto> buscarProducto(String nombre) {
		ArrayList<Producto> prodTemp = gestion.existeProducto(nombre);
		return prodTemp;
	}
	/**
	 * Permite conocer si el usuario esta logueado
	 * @return logueado o no
	 */
	public boolean isLoged() {
		return loged;
	}

}
