package p5e10;

import utiles.ArbolGeneral;
import utiles.ListaEnlazadaGenerica;
import utiles.NodoGeneral;

public class Coro extends ArbolGeneral<Corista> {
	
	protected Coro( NodoGeneral<Corista> nodo) {
		this.raiz = nodo;
	}
	
	public Coro( Corista corista) {
		this.raiz = new NodoGeneral<Corista>( corista);
	}
	
	public ListaEnlazadaGenerica<Coro> getSubCoros(){
		ListaEnlazadaGenerica<NodoGeneral<Corista>> nodos = this.getRaiz().getHijos();
		
		ListaEnlazadaGenerica<Coro> retorno = new ListaEnlazadaGenerica<Coro>();
		nodos.comenzar();
		while(! nodos.fin()){
			retorno.agregar( new Coro(nodos.elemento()) );
			nodos.proximo();
		}
		
		return retorno;
	}
	
	public void agregarSubCoro(Coro c){
		if (this.getRaiz() != null){
			this.getRaiz().getHijos().agregar(c.getRaiz());
		}
	}
	
	public void buscar( String nombre, String apellido, ListaEnlazadaGenerica<Coro>retorno) {
		
		if ( this.getDatoRaiz() != null){
			if ( this.getDatoRaiz().seLlama( nombre, apellido )){
				retorno.agregar(this);
			}
			else{
				ListaEnlazadaGenerica<Coro> tmp = this.getSubCoros();
				tmp.comenzar();
				while(!tmp.fin() && (retorno.tamanio() == 0)){
					tmp.elemento().buscar(nombre, apellido, retorno);
					if (retorno.tamanio() != 0){
						retorno.agregar(this, 0);
					}
					tmp.proximo();
				}
			}
		}
	}
	
	public ListaEnlazadaGenerica<Coro> getRecorrido(String nombre, String apellido){
		
		ListaEnlazadaGenerica<Coro> retorno = new ListaEnlazadaGenerica<Coro>();

		this.buscar(nombre, apellido, retorno);
		
		return retorno;
	}
	
	public String ultimoTenorEntre(String nombreA, String apellidoA, String nombreB, String apellidoB){
		
		String ultimoTenor = null;
		
		if (this.getDatoRaiz() != null){
			ListaEnlazadaGenerica<Coro> r1 = this.getRecorrido(nombreA, apellidoA);
			ListaEnlazadaGenerica<Coro> r2 = this.getRecorrido(nombreB, apellidoB);
			
			r1.comenzar();
			r2.comenzar();
			while ( !r1.fin() && r1.elemento().getDatoRaiz().equals( r2.elemento().getDatoRaiz() ) ){
				
				if (r1.elemento().getDatoRaiz().getCategoria() == "tenor"){
					ultimoTenor = r1.elemento().getDatoRaiz().getNombre()+" "+r1.elemento().getDatoRaiz().getApellido();
				}
				
				r1.proximo();
				r2.proximo();
			}
		}
		
		return ultimoTenor;
	}
}
