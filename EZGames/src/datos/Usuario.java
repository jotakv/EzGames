/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author usuario_local
 */
public class Usuario extends Persona {

	public Usuario(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		super(id, passwd, name, admin, apellido, correo);
	}

}
