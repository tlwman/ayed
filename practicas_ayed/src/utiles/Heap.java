package utiles;

public class Heap<T> {

	private ListaEnlazadaGenerica<T> datos;
	private int cantElementos;
	
	public Heap(){
		this.datos = new ListaEnlazadaGenerica<T>();
		this.datos.agregar(null);
		this.cantElementos = 0;
	} 
	
	public Heap(ListaEnlazadaGenerica<T> lista){
		
	}

	public Heap(T datos[]){
		
	}
	
	public boolean esVacia(){
		return this.cantElementos == 0;
	}
	
	public T minimo(){
		return this.datos.elemento(1);
	}
	
	private void percolateUp(int pos){
		
		if (this.cantElementos < 2){
			return;
		}
		
		int posPadre = pos/2;
		T elem = this.datos.elemento(pos);
		T padre = this.datos.elemento( posPadre );
		
		while(pos > 1 && ( ((Comparable<T>)(elem)).compareTo(padre) < 0 )){
							
			this.datos.eliminar( posPadre );
			this.datos.agregar( elem, posPadre );
			this.datos.eliminar(pos);
			this.datos.agregar( padre, pos );
			
			pos = posPadre;
			posPadre = pos/2;
			
			elem = this.datos.elemento(pos);
			padre = this.datos.elemento( posPadre );
		}
	}
	
	public boolean agregar(T elem){
		
		this.datos.agregar(elem);
		this.cantElementos = this.cantElementos + 1;
		this.percolateUp(this.cantElementos);
		return true;
	}
	
	public T eliminar(){
		if (this.cantElementos <= 0){
			return null;
		}
		
		T retorno = this.minimo();
		
		T hi,hd = null;
		hi = this.datos.elemento(2);
		hd = this.datos.elemento(3);
		
		if ( this.cantElementos > 2){
			if (((Comparable<T>)(hi)).compareTo(hd) > 0){
				T aux = this.datos.elemento(2);
				this.datos.eliminar(2);
				this.datos.agregar(aux, 3);
			}
		}
		this.datos.eliminar(1);
		this.cantElementos--;	
		
		return retorno;
	}
}
