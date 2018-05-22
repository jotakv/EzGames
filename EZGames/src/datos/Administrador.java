package datos;

/**
 * Clase que representa a los
 * administrador de EZGames
 * @author EZGames
 *
 */
public class Administrador extends Persona {
	
	/**
	 * Constructor de la clase administrador que
	 * llama al constructor de su padre: Persona
	 * @param id Identificador del administrador
	 * @param passwd Contrasena del administrador sin cifrar
	 * @param name Nombre del administrador
	 * @param admin Valor que indica si es administrador
	 * @param apellido Apellido del administrador
	 * @param correo Correo electronico del administrador
	 */
	public Administrador(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		super(id, passwd, name, admin, apellido, correo);
	}

}
