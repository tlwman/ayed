package p3e1;

public abstract class ListaDeEnteros {
	
	public abstract void comenzar();
	
	public abstract void proximo();
	
	public abstract boolean fin();
	
	public abstract int elemento();
	
	public abstract int elemento(int pos);
	
	public abstract boolean agregar(int elem);
	
	public abstract boolean agregar(int elem, int pos);
	
	public abstract boolean eliminar();
	
	public abstract boolean eliminar(int pos);
	
	public abstract boolean esVacia();
	
	public abstract boolean incluye(int elem);
	
	public abstract int tamanio();
	
}
