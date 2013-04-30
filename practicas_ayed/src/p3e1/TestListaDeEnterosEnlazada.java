package p3e1;

public class TestListaDeEnterosEnlazada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		
		for(String a: args){
			n = Integer.parseInt(a);
			lista.agregar(n);
		}
		
		lista.comenzar();
		
		while (lista.fin() == false){
			System.out.println("-> "+lista.elemento() );
			lista.proximo();
		}
		
	}


}
