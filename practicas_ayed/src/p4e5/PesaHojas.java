package p4e5;

import utiles.*;

public class PesaHojas {
	
	private static void pesar( ArbolBinario<Integer> a, int peso, int nivel, ListaEnlazadaGenerica<HojaPesada> l){
		
		if ( a.getDatoRaiz() != null ){
			int dato = a.getDatoRaiz();
			
			if (a.grado() == 0){
				l.agregar( new HojaPesada(dato, peso + nivel * dato));
			}
			else{
				PesaHojas.pesar(a.getHijoIzquierdo(),peso + nivel * dato, nivel+1, l);
				PesaHojas.pesar(a.getHijoDerecho(),peso + nivel * dato, nivel+1, l);
			}
		}	
	}
	
	public static ListaEnlazadaGenerica<HojaPesada> pesarArbol( ArbolBinario<Integer> a){
		
		ListaEnlazadaGenerica<HojaPesada> lista = new ListaEnlazadaGenerica<HojaPesada>();
		
		PesaHojas.pesar(a, 0, 1, lista);
		
		return lista;
	}

}
