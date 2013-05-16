package p6e5;

import utiles.Heap;
import utiles.ListaEnlazadaGenerica;

public class HeapCombinable<T> extends Heap<T> {

	
	public HeapCombinable(){
		super();
	} 
	
	public HeapCombinable(ListaEnlazadaGenerica<Comparable<T>> lista){
		super(lista);
	}

	public HeapCombinable(Comparable<T> datos[]){
		super(datos);
	}
	
	private boolean pertenece(int i, Comparable<T> e){

		if ( i<= this.cantElementos ){
		
			if (this.datos.get(i).compareTo((T)e) <= 0 ){
				if (this.datos.get(i) == e){
					return true;
				}
				return ( this.pertenece(2*i, e) || this.pertenece(2*i+1, e) );
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public Heap unionCon(Heap otraHeap){
		
		while ( !otraHeap.esVacia() ){
			Comparable<T> e = (Comparable<T>) otraHeap.eliminar();
			
			if ( !this.pertenece(1, e) ){
				this.agregar(e);
			}
		}
		
		return this;
	}

	public Heap interseccionCon(Heap otraHeap){
		
		HeapCombinable<T> actuales = new HeapCombinable<T>();
		
		while (!this.esVacia()){
			actuales.agregar( (Comparable<T>) this.eliminar() );
		}
		
		while ( !otraHeap.esVacia() ){
			Comparable<T> e = (Comparable<T>) otraHeap.eliminar();
			
			if ( actuales.pertenece(1, e) ){
				this.agregar(e);
			}
		}
		
		return this;
	}
	
}
