package utiles;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;
	
	private ArbolGeneral(NodoGeneral<T> nodo){
		this.raiz = nodo;
	}
	
	public ArbolGeneral(){
		this.raiz = null;
	}
	
	public ArbolGeneral(T dato){
		this.raiz = new NodoGeneral<T>(dato);
	}
	
	public ArbolGeneral(T dato, ListaEnlazadaGenerica<ArbolGeneral<T>> listaHijos) {
		this(dato);
		ListaEnlazadaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();
		listaHijos.comenzar();
		while (! listaHijos.fin() ){
			hijos.agregar( listaHijos.elemento().getRaiz() );
			listaHijos.proximo();
		}
		
		this.raiz.setListaHijos(hijos);
	}
	
	protected NodoGeneral<T> getRaiz(){
		return this.raiz;
	}
	
	public T getDatoRaiz(){
		return (this.raiz != null)? this.raiz.getDato() : null;
	}
	
	public ListaEnlazadaGenerica<ArbolGeneral<T>> getHijos(){
		ListaEnlazadaGenerica<ArbolGeneral<T>> retorno = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaEnlazadaGenerica<NodoGeneral<T>> hijos = this.raiz.getHijos();
		
		hijos.comenzar();
		while (! hijos.fin() ){
			retorno.agregar( new ArbolGeneral<T>( hijos.elemento() ) );
			hijos.proximo();
		}
		
		return retorno;
	}
	
	public void agregarHijo(ArbolGeneral<T> unHijo) {
		ListaEnlazadaGenerica<NodoGeneral<T>> hijos = this.raiz.getHijos();
		
		hijos.agregar( unHijo.getRaiz() );
		
		this.raiz.setListaHijos(hijos);
	}

	public void eliminarHijo(ArbolGeneral<T> unHijo) {
		ListaEnlazadaGenerica<NodoGeneral<T>> hijos = this.raiz.getHijos();
		
		hijos.comenzar();
		while( !hijos.fin() && (hijos.elemento() != unHijo.getRaiz())){
			hijos.proximo();
		}
		if (hijos.elemento() == unHijo.getRaiz()){
			hijos.eliminar();
		}
		this.raiz.setListaHijos(hijos);
	}
	
	public int altura() {
		if (this.raiz == null){
			return -1;
		}
		
		ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		
		if (hijos.esVacia())
			return 0;
		
		int maxAltura = 0;
		int altura;
		
		hijos.comenzar();
		while(!hijos.fin()){
			altura = hijos.elemento().altura();
			if (altura > maxAltura){
				maxAltura = altura;
			}
			hijos.proximo();
		}
		
		return 1 + maxAltura;
	}
	
	public boolean include( T dato){
		ListaEnlazadaGenerica<NodoGeneral<T>> hijos = this.raiz.getHijos();
		boolean retorno = false;
		
		hijos.comenzar();
		while ( !hijos.fin() && !retorno ){
			if ( hijos.elemento().getDato().equals(dato) ){
				retorno = true;
			}
			hijos.proximo();
		}
		return retorno;
	}
	
	public int nivel( T dato){
		if ( this.raiz.getDato().equals(dato) ){
			return 0;
		}
		
		if (this.raiz.getHijos().esVacia()){
			return -1;
		}
		
		ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		int nivel = -1;
		
		hijos.comenzar();
		while ( !hijos.fin() && nivel<0 ){
			nivel = hijos.elemento().nivel(dato);
			hijos.proximo();
		}
		
		return (nivel < 0)? nivel : nivel + 1;
	}
	
	public int ancho(){
		
		if (this.raiz == null){
			return 0;
		}
		
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		
		cola.agregar(this);
		cola.agregar(new ArbolGeneral<T>());
		int gradoMax = 0;
		
		while ( !cola.esVacia() ){
			int grado = 0;
			
			while ( (!cola.esVacia()) && (cola.tope().getDatoRaiz() != null) ){
				grado++;
				ArbolGeneral<T> act = cola.sacar();
				ListaEnlazadaGenerica<ArbolGeneral<T>> hijosAct = act.getHijos();
				hijosAct.comenzar();
				while (!hijosAct.fin()){
					cola.agregar( hijosAct.elemento() );
					hijosAct.proximo();
				}
				cola.agregar(new ArbolGeneral<T>());
			}
			if (!cola.esVacia()){
				cola.sacar();
			}
			if (grado > gradoMax){
				gradoMax = grado;
			}
		}
		
		return gradoMax;
	}
	
	public double minCaudal( double litros){
		double min = Double.MAX_VALUE;
		
		if (this.getDatoRaiz() != null){
			
			if ( this.getHijos().esVacia() ){
				return litros;
			}
			else{
				ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				
				double subCaudal = litros / hijos.tamanio(); 
				double act;
								
				hijos.comenzar();
				while( !hijos.fin() ){
					act = hijos.elemento().minCaudal( subCaudal );
	
					if ( act < min){
						min = act;
					}				
					hijos.proximo();
				}
			}
		}
		return min;
	}
	
}
