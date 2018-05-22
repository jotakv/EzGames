package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Patron DAO con metodos CRUD para la entidad persona
 * 
 * @author Usuario
 *
 */
public class PersonaDAO {

	/**
	 * permite consultar la lista de productos
	 * 
	 * @return
	 */
	public ArrayList<Persona> listaDePersonas() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuarios_pass");
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				int id = res.getInt("ID");
				String name = res.getString("USUARIOS");
				String pass = res.getString("PASSWORD");
				int isAdmin = res.getInt("ADMINISTRADOR");
				String apellido = res.getString("APELLIDO");
				String correo = res.getString("CORREO");
				// quitar esta lineay todos los System.out en general
				System.out.println(id + "\t" + name + "\t" + pass + "\t"
						+ isAdmin + apellido + correo);
				if (isAdmin == 1) {
					personas.add(new Administrador(id, pass, name, isAdmin, apellido,
							correo));
				} else {
					personas.add(new Usuario(id, pass, name, isAdmin, apellido, correo));
				}
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar el usuario\n" + e);
		}
		return personas;
	}
}
