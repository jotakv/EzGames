package control;
import java.util.ArrayList;

import datos.Producto;
import datos.Valoracion;
public interface ObservatorClases {

	public void login(String nombre,String apellido, String correo, String user);
	public void busqueda(ArrayList<Producto> p);
	public void valoraciones(ArrayList<Valoracion> v);
}
