package p3e8;

import java.util.ArrayList;

public class testListaDeGramas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListaInvertidaDeGramas lig = new ListaInvertidaDeGramas(2);
		lig.agregar("universidad");
		lig.agregar("universo");
		lig.agregar("salida");
		
		ArrayList<String> palabras = lig.recuperarListaDePalabras("universidadsalerso");
		
		for ( String p : palabras){
			System.out.println(p);
		}
	}

}
