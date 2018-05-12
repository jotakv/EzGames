package datos;

public class Producto {
    private String _id;
    private String _nombre;
    private String _genero;
    private double _precio;
    private int _stock;
    
    public Producto(String id, String nombre, String genero, double precio, int stock){
        _id = id;
        _nombre = nombre;
        _genero = genero;
        _precio = precio;
        _stock = stock;
    }
    
    
}
