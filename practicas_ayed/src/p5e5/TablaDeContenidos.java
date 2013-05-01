package p5e5;

import utiles.*;

public class TablaDeContenidos {

	private ArbolGeneral<Contenido> raiz;
	
	public TablaDeContenidos( ArbolGeneral<Contenido> toc){
		this.raiz = toc;
	}
	
	public ListaEnlazadaGenerica<String> temasSecciones(){

		ListaEnlazadaGenerica<String> retorno = new ListaEnlazadaGenerica<String>();
		ListaEnlazadaGenerica<ArbolGeneral<Contenido>> hijos = this.raiz.getHijos();
		String str = "";
		
		hijos.comenzar();
		while (!hijos.fin()){
			Contenido cont = hijos.elemento().getDatoRaiz();
			
			if ( cont.esCapitulo() ){
				str = cont.getNombre() + ", " + cont.getTema() + ", "+ cont.getPagInicio()+", ";
			}
			else{
				str = "";
			}
			hijos.proximo();
			if ( !str.equals("") ){
				str = str + (( !hijos.fin() )? (hijos.elemento().getDatoRaiz().getPagInicio() - 1) : "ultima página");
				retorno.agregar(str);
			}
		}
		return retorno;
	}
	
	public ListaEnlazadaGenerica<Contenido> capitulosMasAltos(){
		
		ListaEnlazadaGenerica<ArbolGeneral<Contenido>> hijos = this.raiz.getHijos();
		ListaEnlazadaGenerica<Contenido> retorno = new ListaEnlazadaGenerica<Contenido>();
		
		hijos.comenzar();
		int maxAlt = 0;
		while ( !hijos.fin() ){
			
			if (hijos.elemento().getDatoRaiz().esCapitulo()){
				int altura = hijos.elemento().altura();
				if ( altura > maxAlt ){
					retorno = new ListaEnlazadaGenerica<Contenido>();
					retorno.agregar(hijos.elemento().getDatoRaiz());
					maxAlt = altura;
				}
				else if (maxAlt == altura){
					retorno.agregar(hijos.elemento().getDatoRaiz());
				}	
			}
			hijos.proximo();
		}
		return retorno;
	}
	
	public static void buscarMasAnchos(ArbolGeneral<Contenido> a, ListaEnlazadaGenerica<Contenido> lista){
		if (a.getDatoRaiz() != null){
			int nHijos = a.getHijos().tamanio();
			
			if (lista.esVacia()){
				lista.agregar(new Contenido("dummy", "cantHijos", nHijos, 'X'));
				lista.agregar(a.getDatoRaiz());
			}
			else{
				int max = lista.elemento(0).getPagInicio();
				if (nHijos > max){
					lista = new ListaEnlazadaGenerica<Contenido>();
					lista.agregar(new Contenido("dummy", "cantHijos", nHijos, 'X'));
					lista.agregar(a.getDatoRaiz());
				}
				else if (nHijos == max){
					lista.agregar(a.getDatoRaiz());
				}
			}
			
			ListaEnlazadaGenerica<ArbolGeneral<Contenido>> hijos = a.getHijos();
			
			hijos.comenzar();
			while (!hijos.fin()){
				TablaDeContenidos.buscarMasAnchos(hijos.elemento(), lista);
				hijos.proximo();
			}
		}
	}
	
	public ListaEnlazadaGenerica<Contenido> capitulosMasAnchos(){
			
		ListaEnlazadaGenerica<Contenido> retorno = new ListaEnlazadaGenerica<Contenido>();
				
		TablaDeContenidos.buscarMasAnchos(this.raiz, retorno);
		retorno.eliminar(0);
		return retorno;
	}
	
}
