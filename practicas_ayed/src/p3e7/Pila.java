package p3e7;

public class Pila {
	class Nodo{
		private char dato;
		private Nodo siguiente;
		
		public Nodo(char c){
			this.dato = c;
			this.siguiente = null;
		}

		public char getDato() {
			return dato;
		}

		public void setDato(char dato) {
			this.dato = dato;
		}

		public Nodo getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}
	}
	
	private Nodo tope;
	
	public void apilar(char c){
		Nodo ntope = new Nodo(c);
		ntope.setSiguiente(this.tope);
		this.tope = ntope;
	}

	public char sacar(){
		char c = this.tope.getDato();
		this.tope = this.tope.getSiguiente();
		
		return c;
	}
	
	public char tope(){
		return this.tope.getDato();
	}
	
	public boolean isVacia(){
		return this.tope == null;
	}
}
