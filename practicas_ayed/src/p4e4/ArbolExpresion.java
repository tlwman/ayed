package p4e4;

import utiles.*;

public class ArbolExpresion extends ArbolBinario<Character> {
	
	public ArbolExpresion(char c){
		super(c);
	}
	
	protected ArbolExpresion( NodoBinario<Character> nodo){
		this.raiz = nodo;
	}

	public ArbolExpresion getHijoIzquierdo(){
		return new ArbolExpresion(this.raiz.getHijoIzquierdo());
	}

	public ArbolExpresion getHijoDerecho(){
		return new ArbolExpresion(this.raiz.getHijoDerecho());
	}
	
	public void agregarHijoIzquierdo(ArbolExpresion hijo){
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}
	
	public void agregarHijoDerecho(ArbolExpresion hijo){
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}
	
	private static Cola<Character> strCola(String str){
		Cola<Character> cola = new Cola<Character>(); 
		
		for (char c : str.toCharArray() )
			cola.agregar(c);
		
		return cola;		
	}
	
	private static boolean esOperador(char c){
		return ( (c == '+')||(c == '/')||(c == '*')||(c == '-') );
	}
	
	public static ArbolExpresion convertirPostfija( String expresion){
		
		Cola<Character> e = ArbolExpresion.strCola(expresion);
		Pila<ArbolExpresion> p = new Pila<ArbolExpresion>();
		
		while (! e.esVacia() ){
			char c = e.sacar();
			
			if ( ArbolExpresion.esOperador(c) ){
				ArbolExpresion a = new ArbolExpresion( c );
				
				a.agregarHijoDerecho( p.sacar() );
				a.agregarHijoIzquierdo( p.sacar() );		
				
				p.poner(a);
			}
			else{
				p.poner( new ArbolExpresion(c) );
			}
		}
		
		return p.sacar();		
	}
}
