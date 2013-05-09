package p6e2;

import utiles.Heap;
import java.util.*;

public class TestHeap {

	public static void main(String args[]){
		
		Heap<Integer> cola = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		while (!s.equals(".")){
			cola.agregar(Integer.valueOf(s));
			s = sc.next();
		}
		
		while (!cola.esVacia()){
			int n = cola.eliminar();
			System.out.println("Descolando: "+n);
		}
	
		sc.close();
		
	}
}
