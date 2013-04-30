package p3e1;

public class TestListaDeEnterosConArreglos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		
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
