package datos;
/**
 * Clase que representa a los productos
 * @author EZGames
 *
 */
public class Producto {
	private String _id;
	private String _nombre;
	private String _genero;
	private double _precio;
	private int _stock;

	/**
	 * Constructor de un producto
	 * @param id Identificador del producto
	 * @param nombre Nombre del producto
	 * @param genero Genero del producto
	 * @param precio Precio de venta del producto
	 * @param stock Unidades disponibles del producto
	 */
	public Producto(String id, String nombre, String genero, double precio,
			int stock) {
		_id = id;
		_nombre = nombre;
		_genero = genero;
		_precio = precio;
		_stock = stock;
	}
	
	/**
	 * Devuelve el nombre del producto
	 * @return nombre del producto
	 */
	public String get_nombre() {
		return _nombre;
	}
	/**
	 * Devuelve el genero del producto
	 * @return genero del producto
	 */
	public String get_genero() {
		return _genero;
	}
	/**
	 * Devuelve el precio del producto
	 * @return precio del producto
	 */
	public double get_precio() {
		return _precio;
	}
	/**
	 * Devuelve el stock del producto
	 * @return stock del producto
	 */
	public int get_stock() {
		return _stock;
	}
	/**
	 * Permite modificar el stock de un producto
	 * @param _stock nuevo stock disponible
	 */
	public void set_stock(int _stock) {
		this._stock = _stock;
	}
	/**
	 * Permite modificar el precio de un producto
	 * @param _precio nuevo precio del producto
	 */
	public void set_precio(double _precio) {
		this._precio = _precio;
	}
	public String get_id() {
		return _id;
	}

}
