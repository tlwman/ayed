package p5e7;

import utiles.*;

public class TestCaudales {

	public static void main(String[] args) {

		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>();
		/*
		a.agregarHijo( (new ArbolGeneral<Integer>(2)));
		a.agregarHijo( (new ArbolGeneral<Integer>(3)));
		a.agregarHijo( (new ArbolGeneral<Integer>(4)));
		a.agregarHijo( (new ArbolGeneral<Integer>(5)));
		
		a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(6));
		a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(7));
		a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(8));
		
		a.getHijos().elemento(1).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(9));
		a.getHijos().elemento(1).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(10));
		*/
		System.out.println("Minimo caudal: "+a.minCaudal(1000));
	}

}
