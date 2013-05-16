package p6e5;

import java.util.Random;

import p6e3.Proceso;

public class TestHeapCom {

	private static int ids = 0;
	
	private static Proceso ranProc(){
		Random r = new Random();
		TestHeapCom.ids = TestHeapCom.ids + 1;
		//return new Proceso(r.nextInt(15), TestHeapCom.ids);
		int ran = r.nextInt(40);
		return new Proceso(ran, ran);
	}
	
	public static void main(String args[]){
		Proceso a[] = new Proceso[30];
		Proceso b[] = new Proceso[30];
		
		for (int i = 0 ; i< 30 ; i++){
			a[i] = TestHeapCom.ranProc();
		}
		
		for (int i = 0; i< 25 ; i++){
			b[i] = a[i];
		}
		
		for (int i = 25 ; i< 30 ; i++){
			b[i] = TestHeapCom.ranProc();
		}
		
		
		HeapCombinable<Proceso> h1 = new HeapCombinable<Proceso>(a);
		HeapCombinable<Proceso> h2 = new HeapCombinable<Proceso>(b);
		
		System.out.println("------------------ h1 ------------------");
		h1.dump();
		System.out.println("------------------ h2 ------------------");
		h2.dump();
		//h1.unionCon(h2);
		h1.interseccionCon(h2);
		System.out.println("---------------Resultado---------------");
		h1.dump();
	}
}
