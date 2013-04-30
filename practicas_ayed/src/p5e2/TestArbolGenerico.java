package p5e2;

import utiles.ArbolGeneral;

public class TestArbolGenerico {

	public static void main(String[] args){
		
		ArbolGeneral<String> fs = new ArbolGeneral<String>();
		
		fs.agregarHijo( new ArbolGeneral<String>("usr"));
		fs.agregarHijo( new ArbolGeneral<String>("bin"));
		fs.agregarHijo( new ArbolGeneral<String>("home"));
		fs.agregarHijo( new ArbolGeneral<String>("var"));
		
		fs.getHijos().elemento(0).agregarHijo( new ArbolGeneral<String>("share"));
		
		fs.getHijos().elemento(2).agregarHijo( new ArbolGeneral<String>("usuario"));
		fs.getHijos().elemento(2).getHijos().elemento(0).agregarHijo( new ArbolGeneral<String>("Documentos"));
		
		System.out.println("Altura:  "+fs.altura());
		System.out.println("Nivel de 'root': "+fs.nivel("root"));
		System.out.println("Nivel de 'bin': "+fs.nivel("bin"));
		System.out.println("Nivel de 'usuario': "+fs.nivel("usuario"));
		System.out.println("Nivel de 'foo': "+fs.nivel("foo"));
		System.out.println("Ancho del arbol: "+fs.ancho());
	}
}
