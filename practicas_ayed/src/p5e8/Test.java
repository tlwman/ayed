package p5e8;

import utiles.ListaEnlazadaGenerica;

public class Test {

	public static void main(String[] args) {
		QuadTree a = new QuadTree( 64, false );
		
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, true ) );

		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, true));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, false));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, true));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, false));
		
		/*
		 * Expected output: 
		 * 		tot pixs -> 64*64 = 4096
		 * 		TRUE -> (16*16) + (16*16) = 512
		 * 		FALSE -> 4096 - 512 = 3584
		 */
		//System.out.print("Cant de pixels en false: "+a.pixelsIn(false));
		System.out.print("Cant de pixels en true: " + Test.pixelsIn(a, 1024, true) );
	}

	
	public static int pixelsIn(QuadTree qt, int area, boolean color){
		int ret = 0;
		
		if ( qt.getHijos().esVacia() ){
			if ( qt.getDatoRaiz().isColor( color ) ){
				ret = area;
			}
		}
		else{
			ListaEnlazadaGenerica<QuadTree> hijos = qt.getSubQuads();
			hijos.comenzar();
			while (!hijos.fin()){
				ret = ret + Test.pixelsIn( hijos.elemento(), area/4, color );
				hijos.proximo();
			}
		}
		
		return ret;
	}
	
}
