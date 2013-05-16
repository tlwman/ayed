package utiles;

public class HeapEnlazada<T> {

	private ListaEnlazadaGenerica<T> datos;
	private int cantElementos;
	
	public HeapEnlazada(){
		this.datos = new ListaEnlazadaGenerica<T>();
		this.datos.agregar(null);
		this.cantElementos = 0;
	} 
	
	public HeapEnlazada(ListaEnlazadaGenerica<T> lista){
		
	}

	public HeapEnlazada(T datos[]){
		
	}
	
	public boolean esVacia(){
		return this.cantElementos == 0;
	}
	
	public T minimo(){
		return (this.cantElementos > 0)? this.datos.elemento(1) : null;
	}
	
	private void percolateUp(int pos){
		
		Comparable <T> e = (Comparable <T>) this.datos.elemento(pos);
		
		while ( (pos/2 > 0) && (e.compareTo( this.datos.elemento(pos/2) ) < 0 ) ) {
			
			this.datos.eliminar(pos);
			this.datos.agregar(this.datos.elemento(pos/2), pos);
						
			pos = pos/2;
		}
		
		this.datos.eliminar( pos);
		this.datos.agregar((T)e, pos);
		
	}
	
	public boolean agregar(T elem){

		this.datos.agregar(elem);
		this.cantElementos = this.cantElementos + 1;
		this.percolateUp(this.cantElementos);
		return true;
	}
	
	private void percolateDown( int pos ){
	
		T elem = this.datos.elemento(pos);
		boolean sigoBajando = true;
		
		while ( (pos*2<=this.cantElementos) && (sigoBajando) ){
			
			int ph = pos*2;
			T h = this.datos.elemento(ph);
			
			if (this.cantElementos > ph){
				if (  ((Comparable<T>)h).compareTo(this.datos.elemento(ph+1)) > 0 ){
					ph = ph+1;
					h = this.datos.elemento(ph);
				}
			}
			
			if ( ((Comparable<T>)h).compareTo(elem) > 0){
				sigoBajando = false;
			}
			else{
				this.datos.eliminar(pos);
				this.datos.agregar(h, pos);
				pos = ph;
			}
		}
		
		this.datos.eliminar(pos);
		this.datos.agregar(elem, pos);
	}
	
	public T eliminar(){
		
		if (this.cantElementos <= 0){
			return null;
		}
		
		T retorno = this.minimo();
		
		if (this.cantElementos > 1){
			this.datos.eliminar(1);
			this.datos.agregar(this.datos.elemento(this.cantElementos-1), 1);
			this.datos.eliminar(this.cantElementos);
			this.cantElementos = this.cantElementos - 1;
			
			this.percolateDown(1);
		}
		else{
			this.datos.eliminar(1);
			this.cantElementos = 0;
		}
		
		return retorno;
	}
	
	public void dump() {
		for( int i = 1 ; i<= this.cantElementos ; i++ ){
			System.out.println(i+": "+this.datos.elemento(i));
		}
	}
}
