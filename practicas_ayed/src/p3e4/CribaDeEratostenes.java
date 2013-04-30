package p3e4;

import p3e1.ListaDeEnterosEnlazada;

public class CribaDeEratostenes {
	
	public static ListaDeEnterosEnlazada obtenerPrimos(ListaDeEnterosEnlazada naturales){
		
		ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
		
		for (int i= 1 ; i<naturales.tamanio() ; i++){
			l1.agregar( naturales.elemento(i) );		// l1 va de 2 a n
		}
		
		ListaDeEnterosEnlazada aux;
		int pos=0;
		int ult = l1.elemento(pos);
		int fin = (int)Math.sqrt(naturales.tamanio() );
		int n;
		
		while ( ult < fin ){
			System.out.println(ult+" de "+fin);
			
			for (int i=0; i<=pos ; i++){
				l2.agregar( l1.elemento(0) );
				l1.eliminar( 0 ); 
			}
			
			while (!l1.esVacia() ){
				n = l1.elemento(0);
				l1.eliminar( 0 );
				
				if (n % ult != 0){
					l2.agregar( n );
				}
			}
			
			aux = l1;
			l1 = l2;
			l2 = aux;
			
			ult = l1.elemento(pos);
			pos++;
		}
		
		return l1;
	}
	
public static ListaDeEnterosEnlazada obtenerPrimos(ListaDeEnterosEnlazada naturales, int arreglo){
		int tam = naturales.tamanio()-1;
		int[] vec = new int[tam];
		ListaDeEnterosEnlazada primos = new ListaDeEnterosEnlazada();
		
		// Se llena el vector con los N >= 2
		for (int i= 1 ; i<naturales.tamanio() ; i++){
			vec[i-1] = naturales.elemento(i);
		}
		
		// El primer primo ocupa la primer pos. del vector,
		// El fin del algoritmo llega al identificar un primo >= raiz(tam)
		int pos=0;
		int fin = (int)Math.sqrt(naturales.tamanio() );
		int ult; 
		
		// Se descartan todos los multiplos de c/primo conocido
		do {
			ult = vec[pos];
			
			// marca los multiplos de vec[pos]=ult a partir de pos+1...
			for (int i=pos+1; i<tam ; i++){
				if (vec[i] % ult == 0){
					vec[i] = 0;
				}
			}
			
			// busco el siguiente nº primo
			pos++;
			while ( vec[pos] == 0 ){
				pos++;
			}
		} while ( ult < fin );
		
		
		for (int i=0 ; i < tam ; i++){
			if (vec[i] != 0){
				primos.agregar(vec[i]);
		
			}
		}
		return primos;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada primos, milNaturales = new ListaDeEnterosEnlazada();
		
		for (int i=1 ; i<1001 ; i++){
			milNaturales.agregar(i);
		}
		
		primos = CribaDeEratostenes.obtenerPrimos(milNaturales, 18);
		
		primos.comenzar();
		
		while (primos.fin() == false){
			System.out.println("nº primo: "+primos.elemento() );
			primos.proximo();
		}
	}

}
