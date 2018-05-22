package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import control.Observator;
import control.ObservatorClases;

/**
 * Representa la capa de abstraccion de negocio
 * 
 * @author EZGames
 */
public class Gestion implements Observator<ObservatorClases> {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Administrador> administradores;
	private ArrayList<Producto> productos;
	private ArrayList<Valoracion> valoraciones;
	private DbConnection conex;
	private PreparedStatement consulta;
	private ResultSet res;
	private ProductoDAO productoDAO;
	private List<ObservatorClases> observadores;

	/**
	 * Constructor de la clase Gestion Crea la conexion y obtiene todas las
	 * listas de productos y usuarios disponibles
	 */
	public Gestion() {
		conex = new DbConnection();
		observadores = new ArrayList<>();
		usuarios = new ArrayList<Usuario>();
		administradores = new ArrayList<Administrador>();
		productos = new ArrayList<Producto>();
		valoraciones = new ArrayList<Valoracion>();
		obtenerUsuarios();
		obtenerProductos();
		obtenerValoraciones();
	}

	/**
	 * Ejecuta la consulta conectandose con la base de datos
	 * 
	 * @param consultaSQL
	 *            Representa la consulta que se le realiza a la base de datos
	 */
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

	/**
	 * Obtiene los usuarios y administradores de la base de datos y los almacena
	 * en una lista
	 */
	private void obtenerValoraciones() {
		ValoracionDAO valoracionDAO = new ValoracionDAO();
		ArrayList<Valoracion> valoracionest = new ArrayList<Valoracion>();
		valoracionest = valoracionDAO.listaDeValoraciones();
		Iterator<Valoracion> it = valoracionest.iterator();
		while(it.hasNext()) {
			valoraciones.add(it.next());
		}
		notificaValoraciones(valoraciones);
		
	}


	private void obtenerUsuarios() {
		PersonaDAO personaDAO = new PersonaDAO();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas = personaDAO.listaDePersonas();
		Iterator<Persona> it = personas.iterator();
		while(it.hasNext()) {
			Persona p = it.next();
			if(p.get_admin() == 1) administradores.add((Administrador) p);
			else usuarios.add((Usuario) p);
		}
	}

	/**
	 * Obtiene los productos de la base de datos y los almacena en una lista
	 */
	private void obtenerProductos() {
		productoDAO = new ProductoDAO();
		productos = productoDAO.listaDeProductos();
		notificaProductos(productos);
	}

	/**
	 * Permite buscar en la lista de productos si el producto buscado existe
	 * 
	 * @param nombre
	 *            nombre del producto a buscar
	 * @return producto si se encuentra o null
	 */
	public ArrayList<Producto> existeProducto(String nombre) {
		ArrayList<Producto> prodTemp = new ArrayList<Producto>();
		Iterator<Producto> it = productos.iterator();
		while(it.hasNext()) {
			Producto p = it.next();
			if(nombre.equalsIgnoreCase(p.get_nombre())) prodTemp.add(p);
			
		}
		return prodTemp;
	}

	public ArrayList<Producto> obtenerProductosPlataforma(String plataforma) {
		ArrayList<Producto> prodTemp = new ArrayList<Producto>();
		Iterator<Producto> it = productos.iterator();
		while(it.hasNext()) {
			Producto p = it.next();
			if(plataforma.equalsIgnoreCase(p.get_genero())) prodTemp.add(p);
			
		}
		notificaProductos(prodTemp);
		notificaValoraciones(valoraciones);
		return prodTemp;
	}

	private void notificaProductos(ArrayList<Producto> prodTemp) {
		for (ObservatorClases o : this.observadores) {
			o.busqueda(prodTemp);
		}

	}

	/**
	 * Permite loguear a un usuario en el sistema
	 * 
	 * @param usuario
	 *            nombre del usuario
	 * @param passwd
	 *            contrasena del usuario
	 * @return true si el login es correcto false en caso negativo
	 */
	public boolean login(String usuario, String passwd) {
		Iterator<Administrador> it = administradores.iterator();
		while(it.hasNext()) {
			Administrador a = it.next();
			if(a.getNombre().equalsIgnoreCase(usuario) 
					&& a.getPasswd().equalsIgnoreCase(passwd)) {
				notificaLogueado(a.getNombre(),a.get_apellido(),a.get_correo(),a.get_admin());
				return true;
			}
		}
		Iterator<Usuario> it2 = usuarios.iterator();
		while(it2.hasNext()) {
			Usuario u = it2.next();
			if(u.getNombre().equalsIgnoreCase(usuario) 
					&& u.getPasswd().equalsIgnoreCase(passwd)) {
				notificaLogueado(u.getNombre(),u.get_apellido(),u.get_correo(),u.get_admin());
				return true;
			}
		}
		return false;
	}

	@Override
	public void addObservador(ObservatorClases o) {
		observadores.add(o);
	}

	@Override
	public void removeObservador(ObservatorClases o) {
		observadores.remove(o);
	}

	private void notificaLogueado(String nombre, String apellido, String correo, int user) {
		String user1 = "";
		if(user == 1) user1 = "Administrador";
		else user1 = "Usuario";
		for (ObservatorClases o : this.observadores) {
			o.login(nombre,apellido,correo,user1);
		}
	}
	private void notificaValoraciones(ArrayList<Valoracion> valoraciones2) {
		for (ObservatorClases o : this.observadores) {
			o.valoraciones(valoraciones2);
		}
		
	}
}
