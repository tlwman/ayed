package p4e3;

public class testNodoMinMax {
	
	public static void main(String[] args){
		
		ArbolMinMax arbol = new ArbolMinMax(5, false );
		
		arbol.agregarHijoIzquierdo( new ArbolMinMax( 1, true));
		arbol.agregarHijoDerecho( new ArbolMinMax( 5, true));
		
		ArbolMinMax hi = arbol.getHijoIzquierdo();
		ArbolMinMax hd = arbol.getHijoDerecho();
		
		hd.agregarHijoIzquierdo( new ArbolMinMax( 999, true ));
		hi.agregarHijoDerecho( new ArbolMinMax( 11, true ));
		
		System.out.println("Arbol evaluado: " + arbol.evaluar() );
	}
}
