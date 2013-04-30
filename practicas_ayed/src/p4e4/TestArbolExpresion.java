package p4e4;

public class TestArbolExpresion {
	
	public static void main(String[] args){
		ArbolExpresion a = ArbolExpresion.convertirPostfija("cab+*de/+");
		
		TestArbolExpresion.mostrarAEPO(a);
	}
	
	public static void mostrarAEPO( ArbolExpresion a){

		if (a.getDatoRaiz() != null){
			TestArbolExpresion.mostrarAEPO( a.getHijoIzquierdo() );
			TestArbolExpresion.mostrarAEPO( a.getHijoDerecho() );
		
			System.out.println( "[" + a.getDatoRaiz() + "]" );
		}
	}
}
