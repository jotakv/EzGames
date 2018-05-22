package datos;

/**
 * Clase que representa los usuarios
 * logueados en el sistema
 * @author EZGames
 */
public class Usuario extends Persona {

	/**
	 * Constructor de la clase usuario que
	 * llama al constructor de su padre: Persona
	 * @param id
	 * @param passwd
	 * @param name
	 * @param admin
	 * @param apellido
	 * @param correo
	 */
	public Usuario(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		super(id, passwd, name, admin, apellido, correo);
	}

}
