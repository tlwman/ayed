package utiles;

import java.util.*;

public class Heap<T> {
	
	protected ArrayList<Comparable<T>> datos;
	protected int cantElementos;
	
	public Heap(){
		this.cantElementos = 0;
		this.datos = new ArrayList<Comparable<T>>();
		this.datos.add(null);
	} 
	
	public Heap(ListaEnlazadaGenerica<Comparable<T>> lista){
		this();
		lista.comenzar();
		while( !lista.fin() ){
			this.agregar( lista.elemento() );
			lista.proximo();
		}
	}

	public Heap(Comparable<T> datos[]){
		this();
		for (int i=0 ; i<datos.length ; i++){
			this.datos.add(datos[i]);
		}
		
		this.cantElementos = datos.length;
		for (int i = ((datos.length-1)/2) ; i > 0 ; i--){
			this.percolateDown(i);
		}
	}
	
	public boolean esVacia(){
		return this.cantElementos == 0;
	}
	
	public T minimo(){
		return (this.cantElementos > 0)? (T)this.datos.get(1) : null;
	}
	
	protected void percolateUp(int pos){
		
		Comparable<T> e = this.datos.get(pos);
		
		while ( (pos/2 > 0) && ( e.compareTo( (T)this.datos.get(pos/2) ) < 0 ) ) {
			this.datos.set(pos, this.datos.get(pos/2));
			pos = pos/2;
		}
		
		this.datos.set(pos, e);
		
	}
	
	public boolean agregar(Comparable<T> elem){
		
		this.cantElementos = this.cantElementos + 1;
		this.datos.add(elem);
		this.percolateUp(this.cantElementos);
		return true;

	}
	
	protected void percolateDown( int pos ){
	
		Comparable<T> elem = this.datos.get(pos);
		boolean sigueBajando = true;
		
		while ( (pos*2<=this.cantElementos) && (sigueBajando) ){
			
			int ph = pos*2;
			
			if (this.cantElementos > ph){
				if (  this.datos.get(ph).compareTo((T)this.datos.get(ph+1)) > 0 ){
					ph = ph+1;
				}
			}
			
			if ( this.datos.get(ph).compareTo((T)elem) > 0){
				sigueBajando = false;
			}
			else{
				this.datos.set(pos, this.datos.get(ph));
				pos = ph;
			}
		}
		
		this.datos.set(pos, elem);
	}
	
	public T eliminar(){
	
		T retorno = (T)this.minimo();
		
		if (this.cantElementos > 0){
			this.datos.set(1, this.datos.get(this.cantElementos));
			this.cantElementos = this.cantElementos - 1;
			this.percolateDown(1);
		}
		
		return retorno;
	}
	
	public void dump() {
		for( int i = 1 ; i<= this.cantElementos ; i++ ){
			System.out.println(i+": "+this.datos.get(i));
		}
	}
}
