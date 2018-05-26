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
	 * @param id Identificador de usuario
	 * @param passwd Contrasena de usuario
	 * @param name Nombre de usuario
	 * @param admin Tipo de usuario
	 * @param apellido Apellido del usuario
	 * @param correo Correo electronico del usuario
	 */
	public Usuario(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		super(id, passwd, name, admin, apellido, correo);
	}

}
