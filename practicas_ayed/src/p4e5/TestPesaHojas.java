package p4e5;

import utiles.*;

public class TestPesaHojas {
	
	public static void main( String[] args){
		
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> b, c;
		
		a.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		a.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		
		b = a.getHijoIzquierdo();
		b.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		
		c = a.getHijoDerecho();
		c.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		c.agregarHijoDerecho(new ArbolBinario<Integer>(1));
		
		ListaEnlazadaGenerica<HojaPesada> res = PesaHojas.pesarArbol(a);
		
		res.comenzar();
		while ( ! res.fin() ){
			System.out.println( res.elemento().getDato()+" > "+res.elemento().getPeso());
			res.proximo();
		}
		
	}

}
