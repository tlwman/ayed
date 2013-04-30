package p4e1;

import utiles.*;

public class clasePruebas {

	public static void ej1(){
		ArbolBinario<Character> a = new ArbolBinario<Character>('A');
		ArbolBinario<Character> b, d;
		
		a.agregarHijoIzquierdo(new ArbolBinario<Character>('B'));
		a.agregarHijoDerecho(new ArbolBinario<Character>('C'));
		
		b = a.getHijoIzquierdo();
		b.agregarHijoIzquierdo(new ArbolBinario<Character>('D'));
		b.agregarHijoDerecho(new ArbolBinario<Character>('E'));
		
		d = b.getHijoIzquierdo();
		d.agregarHijoIzquierdo(new ArbolBinario<Character>('F'));
		
		ListaEnlazadaGenerica<Character> res = a.frontera();
		
		res.comenzar();
		while ( ! res.fin() ){
			System.out.print("["+res.elemento()+"] > ");
			res.proximo();
		}
	}
	
	public static void ej3(){
		ArbolBinario<Character> a = new ArbolBinario<Character>('A');
		ArbolBinario<Character> b, c;
		
		a.agregarHijoIzquierdo(new ArbolBinario<Character>('B'));
		a.agregarHijoDerecho(new ArbolBinario<Character>('C'));
		
		b = a.getHijoIzquierdo();
		b.agregarHijoIzquierdo(new ArbolBinario<Character>('D'));
		b.agregarHijoDerecho(new ArbolBinario<Character>('E'));
		
		c = a.getHijoDerecho();
		c.agregarHijoIzquierdo(new ArbolBinario<Character>('F'));
		c.agregarHijoDerecho(new ArbolBinario<Character>('G'));
		
		if (a.lleno()){
			System.out.print("Arbol lleno ");
		}else{
			System.out.print("Arbol NO lleno ");
		}
	}
	

	public static void ej4(){
		ArbolBinario<Character> a = new ArbolBinario<Character>('A');
		ArbolBinario<Character> b, c;
		
		a.agregarHijoIzquierdo(new ArbolBinario<Character>('B'));
		a.agregarHijoDerecho(new ArbolBinario<Character>('C'));
		
		b = a.getHijoIzquierdo();
		b.agregarHijoIzquierdo(new ArbolBinario<Character>('D'));
		b.agregarHijoDerecho(new ArbolBinario<Character>('E'));
		
		c = a.getHijoDerecho();
		c.agregarHijoIzquierdo(new ArbolBinario<Character>('F'));
		c.agregarHijoDerecho(new ArbolBinario<Character>('G'));
		
		if (a.completo()){
			System.out.print("Arbol completo ");
		}else{
			System.out.print("Arbol NO completo ");
		}
	}	
	
	public static void main(String[] args) {
		clasePruebas.ej4();
	}

}
