package p4e10;

import utiles.*;

public class RecorridoGuiado {

	public static void main(String[] args){
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(20);
		
		arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		arbol.agregarHijoDerecho(new ArbolBinario<Integer>(4));	
		
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(6));
		
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(8));
		
		ListaEnlazadaGenerica<ArbolBinario<Integer>> l = RecorridoGuiado.recorridoGuiado(arbol);
		l.comenzar(); int i = 1;
		RecorridoGuiado.mostrar(arbol);
		while (!l.fin()){
			System.out.println(i+": "+l.elemento().getDatoRaiz());
			i++;
			l.proximo();
		}
	}
	
	public static ArbolBinario<Integer> remMenor( ListaEnlazadaGenerica<ArbolBinario<Integer>> lista){
		
		if (lista.esVacia())
			return null;
		
		ArbolBinario<Integer> menor = lista.elemento(0);
		int pos = 0;
		
		for (int i=1 ; i<lista.tamanio() ; i++){
			if (lista.elemento(i).getDatoRaiz() < menor.getDatoRaiz() ){
				menor = lista.elemento(i);
				pos = i;
			}
		}
		
		lista.eliminar(pos);
		return menor;
	}
	
	public static ListaEnlazadaGenerica<ArbolBinario<Integer>> recorridoGuiado(ArbolBinario<Integer> arbol){
		
		ListaEnlazadaGenerica<ArbolBinario<Integer>> retorno = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
		
		if (arbol.getDatoRaiz() == null)
			return retorno;
		
		ListaEnlazadaGenerica<ArbolBinario<Integer>> l = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
		
		l.agregar(arbol);
		ArbolBinario<Integer> n;
		
		while (!l.esVacia()){
			
			n = RecorridoGuiado.remMenor(l);
			retorno.agregar(n);
			
			if (n.getHijoIzquierdo().getDatoRaiz() != null)
				l.agregar(n.getHijoIzquierdo());
			if (n.getHijoDerecho().getDatoRaiz() != null)
				l.agregar(n.getHijoDerecho());
		}
		
		return retorno;
	}
	
	public static void mostrar( ArbolBinario<Integer> a){

		if (a.getDatoRaiz() != null){
			RecorridoGuiado.mostrar( a.getHijoIzquierdo() );
			System.out.println( "[" + a.getDatoRaiz() + "]" );
			RecorridoGuiado.mostrar( a.getHijoDerecho() );
		}
	}
}
