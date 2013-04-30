package p3e1;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	
	class NodoEntero{
		private int dato;
		private NodoEntero siguiente;
		
		public NodoEntero(int dato){
			this.dato = dato;
			this.siguiente = null;
		}
		
		public int getDato() {
			return this.dato;
		}
		public void setDato(int dato) {
			this.dato = dato;
		}
		public NodoEntero getSiguiente() {
			return this.siguiente;
		}
		public void setSiguiente(NodoEntero siguiente) {
			this.siguiente = siguiente;
		}
	}

	private NodoEntero inicio;
	
	private NodoEntero actual;
	
	private int tamanio;
	
	public ListaDeEnterosEnlazada(){
		this.actual = null;
		this.inicio = null;
		this.tamanio = 0;
	}
	
	@Override
	public void comenzar() {
		this.actual = this.inicio;

	}

	@Override
	public void proximo() {
		if (this.actual != null){
			this.actual = this.actual.getSiguiente();
		}
	}

	@Override
	public boolean fin() {
		return (this.actual == null) || (this.actual.getSiguiente() == null);
	}

	@Override
	public int elemento() {
		return (this.actual == null)? 0 : this.actual.getDato();
	}

	@Override
	public int elemento(int pos) {
		NodoEntero n = this.seek(pos);
		return (n == null)? 0 : n.getDato();
	}

	@Override
	public boolean agregar(int elem) {
		if (this.inicio != null){
			
			NodoEntero n = seek(this.tamanio-1);
			n.setSiguiente(new NodoEntero(elem));
			this.tamanio++;
		}
		else{
			this.inicio = new NodoEntero(elem);
			this.tamanio = 1;
		}
		return true;
	}

	@Override
	public boolean agregar(int elem, int pos) {
		if (pos>=0 && this.tamanio >= pos){
			NodoEntero n = seek(pos-1);
			NodoEntero m = new NodoEntero(elem);
			
			m.setSiguiente(n.getSiguiente());
			n.setSiguiente(m);
			this.tamanio++;
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean eliminar() {
		if (this.actual != null){
			this.actual = this.actual.getSiguiente();
			this.tamanio--;
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(int pos) {
		
		NodoEntero n = seek(pos);
		if (n != null){
			n = n.getSiguiente();
			this.tamanio--;
			if (pos == 0){
				this.inicio = n;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean esVacia() {
		return this.inicio == null;
	}

	@Override
	public boolean incluye(int elem) {
		NodoEntero n = this.inicio;
		
		while (n != null && n.getDato() != elem){
			n = n.getSiguiente();
		}
		
		return n != null;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}
	
	private NodoEntero seek(int pos){
		NodoEntero n = this.inicio;
		
		while (n != null && pos > 0) {
			n = n.getSiguiente();
			pos--;
		}
		
		return n;
	}

}
