package utiles;

public class ArbolBinario <T>{

	protected NodoBinario<T> raiz;
	
	public ArbolBinario(){
		this.raiz = null;
	}
	
	public ArbolBinario( T dato ){
		this.raiz = new NodoBinario<T>(dato);
	}
	
	protected ArbolBinario(NodoBinario<T> nodo){
		this.raiz = nodo;
	}

	protected NodoBinario<T> getRaiz(){
		return this.raiz;
	}
	
	public T getDatoRaiz(){
		return (this.raiz == null)? null : this.raiz.getDato() ;
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho(){
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}
	
	public void agregarHijoDerecho(ArbolBinario<T> hijo){
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}
	
	public void eliminarHijoIzquierdo(){
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho(){
		this.raiz.setHijoDerecho(null);
	}
	
	private void agregarFronterizos( ListaEnlazadaGenerica<T> lista){
			
		if (this.getHijoDerecho().getDatoRaiz() == null && this.getHijoIzquierdo().getDatoRaiz() == null){
			lista.agregar(this.getDatoRaiz());
		}
		else{	
			if ( this.getHijoIzquierdo().getDatoRaiz() != null){
				this.getHijoIzquierdo().agregarFronterizos(lista);
			}
			
			if ( this.getHijoDerecho().getDatoRaiz() != null){
				this.getHijoDerecho().agregarFronterizos(lista);
			}
		}
	}
	
	public ListaEnlazadaGenerica<T> frontera(){
		ListaEnlazadaGenerica<T> retorno = new ListaEnlazadaGenerica<T>();
		
		this.agregarFronterizos(retorno);
		
		return retorno;
	}
	
	public boolean equal( ArbolBinario<T> unArbolBinario){
	
		T datoThis, datoUn;
		datoThis = this.getDatoRaiz();
		datoUn = unArbolBinario.getDatoRaiz();

		if(datoThis instanceof Integer && datoUn instanceof Integer ){
			return datoThis.equals(datoUn);
		}
		else{
			return false;
		}
	}
	
	public boolean esMenor(ArbolBinario<T> arbol){
		
		int este = (Integer)this.getDatoRaiz();
		int elOtro = (Integer)arbol.getDatoRaiz();
		
		if ( este < elOtro ){
			return true;
		}
		else if (este == elOtro){
			T thi = this.getHijoIzquierdo().getDatoRaiz();
			T ahi = this.getHijoDerecho().getDatoRaiz();
			
			if (thi != null && ahi != null){
				if ((Integer)thi < (Integer)ahi){
					return true;
				}
				else if ((Integer)thi == (Integer)ahi){
					T thd = arbol.getHijoIzquierdo().getDatoRaiz();
					T ahd = arbol.getHijoDerecho().getDatoRaiz();
					
					if (thd != null && ahd != null){
						if ((Integer)thd < (Integer)ahd){
							return true;
						}
					}
					return false;
				}
				return false;
			}
			
			
			
		}
		
		return false;
	}
	
	public int grado(){
		int nhijos = 0;
		if (this.raiz == null)
			return 0;
		if (this.getHijoIzquierdo().getDatoRaiz() != null )
			nhijos++;
		if (this.getHijoDerecho().getDatoRaiz() != null )
			nhijos++;
		return nhijos;
	}
	
	public boolean lleno(){
		ListaEnlazadaGenerica<ArbolBinario<T>> colaAct = new ListaEnlazadaGenerica<ArbolBinario<T>>();
		ListaEnlazadaGenerica<ArbolBinario<T>> colaSgt = new ListaEnlazadaGenerica<ArbolBinario<T>>();
		ListaEnlazadaGenerica<ArbolBinario<T>> colaAux;
		
		ArbolBinario<T> nodo;
		
		colaAct.agregar( this );
		
		while ( ! colaAct.esVacia() ){
			nodo = colaAct.elemento(0);
			colaAct.eliminar(0);
			
			if ( nodo.grado() == 0 ){
				while (! colaAct.esVacia() ) {
					nodo = colaAct.elemento(0);
					colaAct.eliminar(0);
					
					if ( nodo.grado() != 0) 
						return false;
				}
				return true;
			}
			else if ( nodo.grado() == 2 ){
				colaSgt.agregar(nodo.getHijoIzquierdo());
				colaSgt.agregar(nodo.getHijoDerecho());
				 while (! colaAct.esVacia() ){
		
					nodo = colaAct.elemento(0);
					colaAct.eliminar(0);
					
					if (nodo.grado() != 2)
						return false;
					colaSgt.agregar(nodo.getHijoIzquierdo());
					colaSgt.agregar(nodo.getHijoDerecho());
				 }
			}
			else{
				return false;
			}
			
			colaAux = colaSgt;
			colaSgt = colaAct;
			colaAct = colaAux;
		}
		
		return true;		
	}
	
	public int altura(){
		
		if (this.grado() == 0)
			return -1;
		
		int i,d;
		
		i = this.getHijoIzquierdo().altura() ;
		d = this.getHijoDerecho().altura() ;
		
		return 1 + ((i>d)?i:d);
	}

	public boolean completo(){
		ListaEnlazadaGenerica<ArbolBinario<T>> colaAct = new ListaEnlazadaGenerica<ArbolBinario<T>>();
		ListaEnlazadaGenerica<ArbolBinario<T>> colaSgt = new ListaEnlazadaGenerica<ArbolBinario<T>>();
		ListaEnlazadaGenerica<ArbolBinario<T>> colaAux;
		
		ArbolBinario<T> nodo;
		
		colaAct.agregar( this );
		int nivel = 0;
		int altura = this.altura();
		
		while ( ! colaAct.esVacia() && nivel < altura ){
			nodo = colaAct.elemento(0);
			colaAct.eliminar(0);
			
			if ( nodo.grado() != 2 )
				return false;
			
			colaSgt.agregar(nodo.getHijoIzquierdo());
			colaSgt.agregar(nodo.getHijoDerecho());
			
			while (! colaAct.esVacia() ){
	
				nodo = colaAct.elemento(0);
				colaAct.eliminar(0);
				
				if (nodo.grado() != 2)
					return false;
				colaSgt.agregar(nodo.getHijoIzquierdo());
				colaSgt.agregar(nodo.getHijoDerecho());
			 }
			
			colaAux = colaSgt;
			colaSgt = colaAct;
			colaAct = colaAux;
			nivel++;
		}
		
		boolean anterior=false, actual=true;
		while (! colaAct.esVacia() ){
			nodo = colaAct.elemento(0);
			colaAct.eliminar(0);
			
			anterior = actual;
			if (nodo.getHijoIzquierdo().getDatoRaiz() != null){
				colaSgt.agregar(nodo.getHijoIzquierdo());
				actual = true;
			}
			else{
				actual = false;
			}
			
			if (!anterior && actual) 
				return false;
			
			anterior = actual;
			if (nodo.getHijoDerecho().getDatoRaiz() != null){
				colaSgt.agregar(nodo.getHijoDerecho());
				actual = true;
			}
			else{
				actual = false;
			}
			if (!anterior && actual) 
				return false;
			
		}
			
		while (! colaSgt.esVacia()){
			nodo = colaSgt.elemento(0);
			colaSgt.eliminar(0);
			
			if ( nodo.grado() != 0){
				return false;
			}
		}
		
		return true;		
	}
	
}
