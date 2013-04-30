package utiles;

public class NodoGeneral<T> {

	private T dato;
	private ListaEnlazadaGenerica<NodoGeneral<T>> listaHijos;
	
	public NodoGeneral( T dato ) {
		this.listaHijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ListaEnlazadaGenerica<NodoGeneral<T>> getHijos() {
		return listaHijos;
	}

	public void setListaHijos(ListaEnlazadaGenerica<NodoGeneral<T>> listaHijos) {
		this.listaHijos = listaHijos;
	}
}
