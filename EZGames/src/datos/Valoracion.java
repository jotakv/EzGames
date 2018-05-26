package datos;
/**
 * 
 * Clase que representa las valoraciones
 * que los usuarios dejan sobre los
 * productos adquiridos
 * @author EZGames
 *
 */
public class Valoracion {
	
	private String _id;
	private String _usuario;
	private String _producto;
	private String _texto;
	
	/**
	 * Constructor de valoracion
	 * @param codigo Codigo de la valoracion
	 * @param producto Nombre del producto a valorar
	 * @param user Usuario que realiza la valoracion
	 * @param texto Campo que contiene la valoracion
	 */
	public Valoracion(String codigo, String producto, String user, String texto) {
		_id = codigo;
		_usuario = user;
		_producto = producto;
		_texto = texto;
	}
	/**
	 * Devuelve el usuario que realizo la valoracion
	 * @return usuario 
	 */
	public String get_usuario() {
		return _usuario;
	}
	/**
	 * Obtener el producto valorado
	 * @return nombre del producto
	 */
	public String get_producto() {
		return _producto;
	}
	/**
	 * Devuelve la valoracion
	 * @return texto que contiene la valoracion
	 */
	public String get_texto() {
		return _texto;
	}
	
	
}
