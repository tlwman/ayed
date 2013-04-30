package p5e4;

import utiles.ArbolGeneral;
import utiles.ListaEnlazadaGenerica;

public class TestImagenes {
	
	public static void printArbolNodoIC( ArbolGeneral<NodoIC> a){
		if (a.getDatoRaiz() != null){
			System.out.println(a.getDatoRaiz());
			ListaEnlazadaGenerica<ArbolGeneral<NodoIC>> hijos = a.getHijos();
			hijos.comenzar();
			while( !hijos.fin() ){
				TestImagenes.printArbolNodoIC(hijos.elemento());
				hijos.proximo();
			}
		}
	}

	public static void main(String[] args){
		boolean[][] img = { {true, true, false, false},
							{true, true, false, true},
							{false, false, true, false},
							{false, false, true, false}};
		
		Imagen i = new Imagen(img, 4);
		
		ArbolGeneral<NodoIC> n = i.getComprimida();
		TestImagenes.printArbolNodoIC(n);
	}
}
