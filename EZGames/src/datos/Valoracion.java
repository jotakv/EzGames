package datos;

public class Valoracion {
	
	private String _id;
	private String _usuario;
	private String _producto;
	private String _texto;
	
	public Valoracion(String codigo, String producto, String user, String texto) {
		_id = codigo;
		_usuario = user;
		_producto = producto;
		_texto = texto;
	}

	public String get_usuario() {
		return _usuario;
	}

	public String get_producto() {
		return _producto;
	}

	public String get_texto() {
		return _texto;
	}
	
	
}
