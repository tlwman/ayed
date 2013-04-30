package p3e2;

public class TestPilaDeEnteros {
	
	public static void main(String[] args) {
		PilaDeEnteros p1, p2;
		
		p1=new PilaDeEnteros();
		p1.poner(1);
		p1.poner(2);
		p2=p1;
		p2.sacar();
		System.out.println("El valor del tope de la pila p1 es:" + p1.sacar() );
	
	}
	
}
