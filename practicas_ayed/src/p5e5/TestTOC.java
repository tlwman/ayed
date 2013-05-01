package p5e5;

import utiles.ArbolGeneral;
import utiles.ListaEnlazadaGenerica;

import java.util.Scanner;

public class TestTOC {

	public static ArbolGeneral<Contenido> gen(){
		ArbolGeneral<Contenido> a = new ArbolGeneral<Contenido>(new Contenido("tapa", "java", 0, 'T'));
		a.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("capitulo1", "constructores", 1, 'C')) );
		a.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("capitulo3", "herencia", 12, 'C')) );
		a.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("capitulo3", "hilos", 21, 'C')) );
		a.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("apendice", "interfaces", 37, 'A')) );
		
		ArbolGeneral<Contenido> b = a.getHijos().elemento(0);
		b.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("1.1", "java", 1, 'S')) );
		b.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("1.2", "java", 4, 'S')) );
		b.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("1.3", "java", 8, 'S')) );

		ArbolGeneral<Contenido> d = a.getHijos().elemento(2);
		d.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("3.1", "java", 21, 'S')) );
		d.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("3.2.1", "java", 29, 'S')) );

		ArbolGeneral<Contenido> e = d.getHijos().elemento(1);
		e.agregarHijo( new ArbolGeneral<Contenido>(new Contenido("3.2.2", "java", 32, 'S')) );
		
		return a;
	}
	
	public static ArbolGeneral<Contenido> generar(){
		ArbolGeneral<Contenido> a;
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Nombre: ");	String nom = sc.next();
		System.out.print("Tema: ");	String tem = sc.next();
		System.out.print("Pagina de Inicio: ");	int pi = sc.nextInt();
		System.out.print("Tipo: ");	char t = sc.next().charAt(0);
		
		a = new ArbolGeneral<Contenido>(new Contenido(nom, tem, pi, t));
		
		System.out.print("Agregar un hijo a "+nom+"?: ");	t = sc.next().charAt(0);
		while (t == 's'){
			a.agregarHijo( TestTOC.generar());
			System.out.print("Agregar un hijo a "+nom+"?: ");	t = sc.next().charAt(0);
		}
		sc.close();
		return a;
	}
	
	public static void main(String[] args){
		
		TablaDeContenidos toc = new TablaDeContenidos( TestTOC.gen() );
		
		ListaEnlazadaGenerica<String> n = toc.temasSecciones();
		System.out.println("Capitulos: ");
		n.comenzar();
		while(!n.fin()){
			System.out.println(n.elemento());
			n.proximo();
		}		
		
		ListaEnlazadaGenerica<Contenido> l = toc.capitulosMasAltos();
		System.out.print("Capitulos con anidaciones mas profundas:");
		l.comenzar();
		while(!l.fin()){
			System.out.println(l.elemento().getNombre());
			l.proximo();
		}
		
		l = toc.capitulosMasAnchos();
		System.out.println();
		System.out.println();
		System.out.print("Secciones con mas hijos:");
		l.comenzar();
		while(!l.fin()){
			System.out.println(l.elemento().getNombre());
			l.proximo();
		}
	}
	
}
