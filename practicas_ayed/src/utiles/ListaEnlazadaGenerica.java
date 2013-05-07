package utiles;

public class ListaEnlazadaGenerica<T> extends ListaGenerica<T> {
	
	
	class Nodo<T>{
		private T dato;
		private Nodo<T> siguiente;
		
		public Nodo(T dato){
			this.dato = dato;
			this.siguiente = null;
		}
		
		public T getDato() {
			return this.dato;
		}
		public void setDato(T dato) {
			this.dato = dato;
		}
		public Nodo<T> getSiguiente() {
			return this.siguiente;
		}
		public void setSiguiente(Nodo<T> siguiente) {
			this.siguiente = siguiente;
		}
	}

	private Nodo<T> inicio;
	
	private Nodo<T> actual;
	
	private int tamanio;
	
	public ListaEnlazadaGenerica(){
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
		return this.actual == null;
	}

	@Override
	public T elemento() {
		return (T) ((this.actual == null)? null : this.actual.getDato());
	}

	@Override
	public T elemento(int pos) {
		Nodo<T> n = this.seek(pos);
		return (n == null)? null : (T) n.getDato();
	}

	@Override
	public boolean agregar(T elem) {
		if (this.inicio != null){
			Nodo<T> n = seek(this.tamanio-1);
			n.setSiguiente(new Nodo<T>(elem));
			this.tamanio++;
		}
		else{
			this.inicio = new Nodo<T>(elem);
			this.tamanio = 1;
		}
		return true;
	}

	@Override
	public boolean agregar(T elem, int pos) {
		Nodo<T> nuevo = new Nodo<T>(elem);
		
		if (pos <= this.tamanio && pos >= 0){
			if (pos == 0){
				nuevo.setSiguiente( this.inicio );
				this.inicio = nuevo;
			}
			else if (pos > 0) {
				Nodo<T> ant = seek(pos-1);
				nuevo.setSiguiente(ant.getSiguiente());
				ant.setSiguiente(nuevo);
			}
			this.tamanio++;
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar() {
		if (this.actual != null){
			
			if (this.actual == this.inicio){
				this.inicio = this.inicio.getSiguiente();
			}
			else{
				Nodo<T> ant = this.inicio;
				while (ant.getSiguiente() != this.actual ){
					ant = ant.getSiguiente();
				}
				ant.setSiguiente( this.actual.getSiguiente() );
			}
			this.tamanio--;
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminar(int pos) {
		if (pos >= 0 && pos < this.tamanio ){
			if (pos == 0){
				this.inicio = this.inicio.getSiguiente();
			}
			else{
				Nodo<T> n = seek(pos-1);
				if (this.actual == n.getSiguiente()){
					this.actual = null;
				}
				n.setSiguiente( n.getSiguiente().getSiguiente() );
			}
			this.tamanio--;
			return true;
		}
		return false;
	}

	@Override
	public boolean esVacia() {
		return this.inicio == null;
	}

	@Override
	public boolean incluye(T elem) {
		Nodo<T> n = this.inicio;
		
		while (n != null && (! n.getDato().equals(elem) )){
			n = n.getSiguiente();
		}
		
		return n != null;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}
	
	private Nodo<T> seek(int pos){
		Nodo<T> n = this.inicio;
		
		while (n != null && pos > 0) {
			n = n.getSiguiente();
			pos--;
		}
		
		return n;
	}


}
