package p7e0;

import utiles.*;

public class Test {

	public static void main(String[] args) {
		
		ArbolAVL<Integer> a = new ArbolAVL<Integer>(5);
		
		a.agregar(new Integer(2) );
		a.agregar(new Integer(8) );
		a.agregar(new Integer(9) );
		a.agregar(new Integer(30) );
		a.agregar(new Integer(0) );
		a.agregar(new Integer(-2) );
		a.agregar(new Integer(18) );
		a.agregar(new Integer(3) );
		a.agregar(new Integer(11) );
		/*
		Test.iio(a);
		
		a.eliminar(2);
		System.out.println("---------------------------");*/
		Test.iio(a);
			
		
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
}
