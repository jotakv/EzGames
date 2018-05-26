package datos;

/**
 * Clase que representa a una persona
 * @author EZGames
 *
 */
public class Persona {
	private int _id;
	private String _passwd;
	private String _nombre;
	private String _apellido;
	private String _correo;
	private int _admin;

	/**
	 * Constructor de Persona.
	 * @param id Identificador de la persona
	 * @param passwd Contrase�a de la persona
	 * @param name Nombre de la persona
	 * @param admin Valor que indica si es administrador
	 * @param apellido Apellido de la persona
	 * @param correo Correo electronico de la persona
	 */
	public Persona(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		_id = id;
		_passwd = passwd;
		_nombre = name;
		_admin = admin;
		_apellido = apellido;
		_correo = correo;
	}
	/**
	 * Devuelve el nombre del usuario
	 * @return nombre
	 */
	public String get_nombre() {
		return _nombre;
	}
	/**
	 * Devuelve el apellido del usuario
	 * @return apellido
	 */
	public String get_apellido() {
		return _apellido;
	}
	/**
	 * Devuelve el correo electronico del usuario
	 * @return correo electronico
	 */
	public String get_correo() {
		return _correo;
	}

	/**
	 * Devuelve el nombre del usuario
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return _nombre;
	}

	/**
	 * Devuelve el password del usuario
	 * @return password del usuario
	 */
	public String getPasswd() {
		return _passwd;
	}

	/**
	 * Permite modificar el nombre del usuario
	 * @param nombre nuevo nombre del usuario
	 */
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	
	/**
	 * Permite conocer si el usuario es o no administrador
	 * @return 1 si administrador 0 si usuario
	 */
	public int get_admin() {
		return _admin;
	}
}
