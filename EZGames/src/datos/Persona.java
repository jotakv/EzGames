package datos;

public class Persona {
	private int _id;
	private String _passwd;
	private String _nombre;
	private String _apellido;
	private String _correo;
	private int _admin;

	public Persona(int id, String passwd, String name, int admin,
			String apellido, String correo) {
		_id = id;
		_passwd = passwd;
		_nombre = name;
		_admin = admin;
		_apellido = apellido;
		_correo = correo;
	}

	public String getNombre() {
		return _nombre;
	}

	public String getPasswd() {
		return _passwd;
	}

	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this._nombre = nombre;
	}
	public int get_admin() {
		return _admin;
	}
}
