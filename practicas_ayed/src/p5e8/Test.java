package p5e8;

public class Test {

	public static void main(String[] args) {
		QuadTree a = new QuadTree( 64, false );
		
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, false ) );
		a.agregarHijo( new QuadTree( 32, false ) );

		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, true));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, false));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, true));
		a.getHijos().elemento(1).agregarHijo(new QuadTree(16, false));
		
		/*
		 * Expected output: 
		 * 		tot pixs -> 64*64 = 4096
		 * 		TRUE -> (16*16) + (16*16) = 512
		 * 		FALSE -> 4096 - 512 = 3584
		 */
		System.out.print("Cant de pixels en false: "+a.pixelsIn(false));
	}

}
