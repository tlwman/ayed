package p5e6;

import utiles.ListaEnlazadaGenerica;
import java.util.*;

public class TestTrie {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		String w;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("palabra a agregar al TRIE: ");
		w = sc.next();
		
		while (! w.equals(".") ){
			t.agregarPalabra(w);
			System.out.print("palabra a agregar al TRIE: ");
			w = sc.next();	
		}
		
		System.out.println();
		System.out.println("Listar palabras que empiezen con: ");
		w = sc.next();
		while (!w.equals(".")){
			ListaEnlazadaGenerica<String> res = t.getPalabrasEmpezando(w);		
			res.comenzar();
			while (!res.fin()){
				System.out.println(res.elemento());
				res.proximo();
			}
			System.out.println();
			System.out.println("Listar palabras que empiezen con: ");
			w = sc.next();
		}
			
		sc.close();
	}
}
