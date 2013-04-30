package p4e6;

public class NodoSternBrocot {

	private Fraccion izquierda, derecha, este;
	
	public NodoSternBrocot(){
		this.izquierda = new Fraccion(0,1);
		this.derecha = new Fraccion(1,0);
		this.este = new Fraccion(1,1);
	}
	
	public NodoSternBrocot( Fraccion izquierda, Fraccion derecha){
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.este =  new   Fraccion(izquierda.getNumerador()   + derecha.getNumerador() , 
									izquierda.getDenominador() + derecha.getDenominador() );
	}

	public Fraccion getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Fraccion izquierda) {
		this.izquierda = izquierda;
	}

	public Fraccion getDerecha() {
		return derecha;
	}

	public void setDerecha(Fraccion derecha) {
		this.derecha = derecha;
	}

	public Fraccion getEste() {
		return este;
	}

	public void setEste(Fraccion este) {
		this.este = este;
	}
	
	public static String toSternBrocot(Fraccion f){
		
		String camino = "";
		
		NodoSternBrocot n = new NodoSternBrocot();
		Fraccion e = n.getEste();
		
		while ( ! e.equals(f) ){
			
			if (e.compareTo(f) > 0 ){
				camino = camino + "L";
				n = new NodoSternBrocot(n.getIzquierda(), n.getEste() );
			}
			else {
				camino = camino + "R";
				n = new NodoSternBrocot(n.getEste(), n.getDerecha());
			}
			
			e = n.getEste();
		}
		
		return (camino.equals(""))? "I" : camino;
		
	}
 }
