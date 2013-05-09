package utiles;

class NodoGenerico<T>{
	private T dato;
	private NodoGenerico<T> siguiente;
	
	public NodoGenerico(T dato){
		this.dato = dato;
		this.siguiente = null;
	}
	
	public T getDato() {
		return this.dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoGenerico<T> getSiguiente() {
		return this.siguiente;
	}
	public void setSiguiente(NodoGenerico<T> siguiente) {
		this.siguiente = siguiente;
	}
}
