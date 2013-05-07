package p5e10;

import utiles.ListaEnlazadaGenerica;

public class BuscarTenor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coro c = new Coro( new Corista("Miguel", "Tomczuk", "tenors") );
		
		// 2do
		c.agregarSubCoro( new Coro( new Corista("Jennifer", "Anniston", "soprano")) );
		c.agregarSubCoro( new Coro( new Corista("Nadia", "Herrera", "tensor")) );
		c.agregarSubCoro( new Coro( new Corista("Cintia", "Madeira", "contraalto")) );
		
		// 3er
		Coro a = c.getSubCoros().elemento(0);
		c.agregarSubCoro( new Coro( new Corista("Paula", "Masching", "bajo")) );
		c.agregarSubCoro( new Coro( new Corista("Lara", "Bernusconi", "bajo")) );
		c.agregarSubCoro( new Coro( new Corista("Uma", "Thurman", "bajo")) );

		Coro b = c.getSubCoros().elemento(1);
		b.agregarSubCoro( new Coro( new Corista("Claudia", "Albertario", "bajo")) );
		b.agregarSubCoro( new Coro( new Corista("Jessica", "Cirio", "bajo")) );
		b.agregarSubCoro( new Coro( new Corista("Pamela", "Entraigas", "bajo")) );

		Coro d = c.getSubCoros().elemento(2);
		d.agregarSubCoro( new Coro( new Corista("Ana", "Llenderosa", "bajo")) );
		d.agregarSubCoro( new Coro( new Corista("Ernestina", "Krum", "bajo")) );
		d.agregarSubCoro( new Coro( new Corista("Valeria", "Pereyra", "bajo")) );

		// 4to
		Coro e = b.getSubCoros().elemento(2);
		e.agregarSubCoro( new Coro( new Corista("XXX1", "das", "bajo")) );
		e.agregarSubCoro( new Coro( new Corista("XXX2", "das", "bajo")) );
		e.agregarSubCoro( new Coro( new Corista("XXX3", "das", "bajo")) );
		
		ListaEnlazadaGenerica<Coro> camino = c.getRecorrido("Cintia", "Madeira");
		camino.comenzar();
		while(!camino.fin()){
			System.out.println(camino.elemento().getDatoRaiz());
			camino.proximo();
		}
		
		System.out.println("Ultimo entre "+c.ultimoTenorEntre("Pamela", "Entraigas", "XXX3", "das"));
		
	}

}
