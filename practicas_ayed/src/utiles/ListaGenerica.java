package utiles;

public abstract class ListaGenerica<T> {
		
		public abstract void comenzar();
		
		public abstract void proximo();
		
		public abstract boolean fin();
		
		public abstract T elemento();
		
		public abstract T elemento(int pos);
		
		public abstract boolean agregar(T elem);
		
		public abstract boolean agregar(T elem, int pos);
		
		public abstract boolean eliminar();
		
		public abstract boolean eliminar(int pos);
		
		public abstract boolean esVacia();
		
		public abstract boolean incluye(T elem);
		
		public abstract int tamanio();
	
}
