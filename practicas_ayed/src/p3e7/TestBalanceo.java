package p3e7;

import java.util.Scanner;

public class TestBalanceo {
	
	public static boolean isOpening(char c){
		return (c == '(' || c == '{' || c == '[');
	}

	public static boolean isSemejante(char a, char b){
		switch (a){
			case '(':
				return (b == ')');
			case '{':
				return (b == '}');
			case '[':
				return (b == ']');
			default:
				return false;
		}
	}
	
	public static boolean isBalanced(String cadena){
		
		Pila p = new Pila();
		char c;
		
		for (int i=0 ; i<cadena.length() ; i++){
			c = cadena.charAt(i);
			
			if ( TestBalanceo.isOpening(c) ){
				p.apilar(c);
			}
			else{
				if (p.isVacia()){
					return false;
				}
				
				if ( TestBalanceo.isSemejante(p.tope(), c) ){
					p.sacar();
				}
				else{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		String cadena;
		String res;
		Scanner inp = new Scanner( System.in );
		
		do{
			cadena = inp.next();
			res = (TestBalanceo.isBalanced(cadena))? "Balanceada" : "Desbalanceada";
			System.out.println(cadena + ": " + res);
		} while (cadena != "");
		
		inp.close();
	}

}
