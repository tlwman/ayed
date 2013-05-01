package p5e5;

import utiles.ArbolGeneral;
import utiles.ListaEnlazadaGenerica;

import java.util.Scanner;

public class TestTOC {

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
		
		TablaDeContenidos toc = new TablaDeContenidos( TestTOC.generar() );
		
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
