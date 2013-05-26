package utiles;

public class Iterador<T extends Comparable<T>> {
	
	private Pila<ArbolBinarioDeBusqueda<T>> pila;
	
	public Iterador(ArbolBinarioDeBusqueda<T> abb){
		
		this.pila = new Pila<ArbolBinarioDeBusqueda<T>>();
		
		while (abb.getDatoRaiz() != null){
			this.pila.poner( abb );
			abb = abb.getHijoIzquierdo();
		}
	}
	
	public boolean hasNext(){
		return !pila.esVacia();
	}
	
	public T next(){
		T retorno = null;
		
		if (!this.pila.esVacia()){
			ArbolBinarioDeBusqueda<T> nodo = this.pila.sacar();
			retorno = nodo.getDatoRaiz();
			nodo = nodo.getHijoDerecho();
			
			while (nodo.getDatoRaiz() != null){
				this.pila.poner(nodo);
				nodo = nodo.getHijoIzquierdo();
			}
		}
		
		return retorno;
	}
}
