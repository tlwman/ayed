package p4e6;

import java.util.Scanner;

public class TestSternBrocot {
	
	public static Fraccion strToFraccion( String s){
		int barra = s.indexOf('/');
		int n = Integer.parseInt(  s.substring(0, barra) );
		int d = Integer.parseInt(  s.substring(barra+1) );
		
		return new Fraccion(n,d);
	}

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Fraccion f;
		String s;
		
		do {
			System.out.print("Ingrese una fraccion: ");
			s = sc.next();
			
			f = TestSternBrocot.strToFraccion(s);
			
			System.out.println(s+" = "+ NodoSternBrocot.toSternBrocot(f));
			System.out.println();
			
		} while ( !f.equals( new Fraccion(1, 1)) );
		
		sc.close();
	}
}
