package p7e0;

import utiles.*;

public class Test {

	public static void main(String[] args) {
		
		ArbolAVL<Integer> a = new ArbolAVL<Integer>(5);
		
		a.agregar(new Integer(2) );
		//System.out.println("agregado el 2");
		a.agregar(new Integer(8) );
		//System.out.println("agregado el 8");
		a.agregar(new Integer(9) );
		//System.out.println("agregado el 9");
		a.agregar(new Integer(30) );
		//System.out.println("agregado el 30");
		a.agregar(new Integer(0) );
		//System.out.println("agregado el 0");
		a.agregar(new Integer(-2) );
		//System.out.println("agregado el -2");
		a.agregar(new Integer(18) );
		//System.out.println("agregado el 18");
		a.agregar(new Integer(3) );
		//System.out.println("agregado el 3");
		a.agregar(new Integer(29) );
		a.agregar(new Integer(28) );
		a.agregar(new Integer(27) );
		a.eliminar(9);
		a.eliminar(8);
		//System.out.println("agregado el 11");

		/*
		Test.iio(a);
		
		a.eliminar(2);
		System.out.println("---------------------------");*/
		Test.iio(a);
		System.out.println("Cantidad de nodos: "+a.cantidadDeNodos()+" es min?: "+a.esMinimal());
		
		int[] v = new int[3];
		v[0] = 0;
		v[1] = 10;
		v[2] = 999;
		
		Test.luchu(a, v);
		
		System.out.println("Encontrados "+v[0]+" y "+v[2]);
		
		/*Iterador<Integer> it = new Iterador<Integer>(a); 
		while (it.hasNext()){
			System.out.println( it.next() );
		}*/
	}

	public static void iio( ArbolAVL<Integer> a){
		
		if (a.getDatoRaiz() != null){
						
			Test.iio(a.getHijoIzquierdo() );
			
			System.out.println(a.getDatoRaiz()+" altura: "+a.getAltura());
			
			Test.iio(a.getHijoDerecho() );
		}
	}
	

	public static void luchu( ArbolAVL<Integer> a, int[] v){
		
		if (a.getDatoRaiz() != null){
	
			if (a.getDatoRaiz() > v[0] && a.getDatoRaiz() < v[1]){
				v[0] = a.getDatoRaiz();
				Test.luchu(a.getHijoDerecho(), v);
			}
			else if (a.getDatoRaiz() > v[1] && a.getDatoRaiz() < v[2]){
				v[2] = a.getDatoRaiz();
				Test.luchu(a.getHijoIzquierdo(), v);
			}
			else{
				Test.luchu(a.getHijoIzquierdo(), v);
				Test.luchu(a.getHijoDerecho(), v);
			}			
			
		}
	}
}
