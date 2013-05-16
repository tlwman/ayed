package p6e2;

import utiles.Heap;

public class TestHeap {

	public static void main(String args[]){
		Integer a[] = {5, 8, 12, 9 ,7, 10, 21,	6 ,8, 14 ,4};
		Heap<Integer> cola = new Heap<Integer>(a);
		/*Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		while (!s.equals(".")){
			cola.agregar(Integer.valueOf(s));
			s = sc.next();
		}
		*/
		cola.dump();
		
		while (!cola.esVacia()){
			Integer n = cola.eliminar();
			System.out.println("Descolando: "+n);
		}
	
		//sc.close();
	}
}
