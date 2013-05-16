package p6e3;

import utiles.MaxHeap;
import java.util.Random;
import java.util.Scanner;

public class TestHeap {
	
	public static int ids = 0;
	
	private static Proceso ranProc(){
		Random r = new Random();
		TestHeap.ids = TestHeap.ids + 1;
		int n = r.nextInt(15);
		return new Proceso(n, n);
	}

	public static void main(String args[]){

		MaxHeap<Proceso> jip = new MaxHeap<Proceso>();

		for (int i= 0 ; i<30 ; i++){
			jip.agregar( TestHeap.ranProc() );
		}
		
		jip.dump();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Posicion en el arbol del proceso a bajar: ");
		String si = sc.next();

		System.out.println("Nueva prioridad: ");
		String sp = sc.next();
		
		jip.bajarElemento(Integer.valueOf(si), Integer.valueOf(sp));
		
		while (!jip.esVacia()){
			Proceso p = jip.extract();
			System.out.println("Descolando: "+p);
		}
		
	
		sc.close();
	}
}
