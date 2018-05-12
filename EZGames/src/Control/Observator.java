package Control;

public interface Observator<T> {
 
        public void addObservador(T o);
	public void removeObservador(T o);
        
	// notifica login
	public void notifyLogin();
        public void notifyCompra();
        public void notifyModProducto();

}
