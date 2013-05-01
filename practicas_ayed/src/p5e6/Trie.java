package p5e6;

import utiles.*;

public class Trie {

	private ArbolGeneral<Character> raiz;
	
	public Trie(){
		this.raiz = new ArbolGeneral<Character>('\0');
	}
	
	public void agregarCaracteres(ArbolGeneral<Character> arbol, String palabra){
		
		if (palabra.length() == 0){
			return;
		}
		
		char c = palabra.charAt(0);
		
		ListaEnlazadaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
		hijos.comenzar();
		while ( !hijos.fin() && (hijos.elemento().getDatoRaiz() != c)){
			hijos.proximo();
		}
		
		if (hijos.fin()){
			arbol.agregarHijo( new ArbolGeneral<Character>(c));
			this.agregarCaracteres(arbol.getHijos().elemento(arbol.getHijos().tamanio()-1), palabra.substring(1));
		}
		else{
			this.agregarCaracteres(hijos.elemento(), palabra.substring(1));
		}
	}
	
	public void agregarPalabra(String palabra){
		this.agregarCaracteres(this.raiz, palabra);
	}
	
	private ArbolGeneral<Character> getByDato(ArbolGeneral<Character> arbol, Character c){
		ListaEnlazadaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
		hijos.comenzar();
		while (!hijos.fin() && (c != hijos.elemento().getDatoRaiz())){
			hijos.proximo();
		}
		return (( hijos.fin() )? null : hijos.elemento());
	}
	
	private ArbolGeneral<Character> match(String inicio){
		ArbolGeneral<Character> a = this.raiz;
		
		for (int i=0 ; i<inicio.length() && (a != null) ; i++){
			a = this.getByDato(a, inicio.charAt(i));
		}
		return a;
	}
	
	private void nuevaPalabra(String palabra, ArbolGeneral<Character> arbol, ListaEnlazadaGenerica<String> retorno){

		palabra = palabra + arbol.getDatoRaiz();
		
		if (arbol.getHijos().esVacia()){
			retorno.agregar(palabra);
		}
		
		ListaEnlazadaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
		hijos.comenzar();
		while ( !hijos.fin() ){
			this.nuevaPalabra(palabra, hijos.elemento(), retorno);
			hijos.proximo();
		}
	}
	
	public ListaEnlazadaGenerica<String> getPalabrasEmpezando(String comienzo) {
		ListaEnlazadaGenerica<String> retorno = new ListaEnlazadaGenerica<String>();
		ArbolGeneral<Character> subarbol = this.match(comienzo);
		
		if (subarbol != null){
			ListaEnlazadaGenerica<ArbolGeneral<Character>> hijos = subarbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()){
				this.nuevaPalabra(comienzo, hijos.elemento(), retorno);
				hijos.proximo();
			}
		}
		
		return retorno;
	}
}
