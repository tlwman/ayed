package p3e8;

import java.util.ArrayList;

public class ListaInvertidaDeGramas {
	
	class NodoLIG{
		private String grama;
		private ArrayList<String> listaPalabras;
		
		public NodoLIG(String grama) {
			this.grama = grama;
			this.listaPalabras = new ArrayList<String>();
		}
		
		public void addPalabra(String palabra){
			this.listaPalabras.add(palabra);
		}

		public String getGrama() {
			return grama;
		}

		public ArrayList<String> getListaPalabras() {
			return listaPalabras;
		}
	}

	private int longGrama = 1;
	private ArrayList<NodoLIG> listaGramas;
	
	private int indiceDe(String grama){
		int ret = -1;
		
		for (int i=0 ; i<(this.listaGramas.size()) && (ret==-1) ; i++){
			if ( this.listaGramas.get(i).getGrama().equals(grama) ){
				ret = i;
			}
		}
		
		return ret;
	}
	
	public ListaInvertidaDeGramas(int longGrama){
		if (longGrama <= 0){
			longGrama = 1;
		}
		this.longGrama = longGrama;
		this.listaGramas = new ArrayList<NodoLIG>();
	}
	
	private ArrayList<String> crearListaDeGramas(String palabra){
		/*
		 *  Retorna un ArrayList de Strings con los gramas resultantes de factorizar 
		 *  'palabra'.
		 */
		
		ArrayList<String> retorno = new ArrayList<String>();
		
		if ( palabra.length() < this.longGrama ) { return retorno; }
		
		int numGramas = palabra.length() - this.longGrama;
		for (int i=0 ; i <= numGramas ; i++){
			retorno.add( palabra.substring(i,i+this.longGrama) );
		}
		
		return retorno;
	}

	private ArrayList<String> crearConjuntoDeGramas(String palabra){
		/*
		 *  Retorna un ArrayList de Strings con los gramas (sin repetir) resultantes de factorizar 'palabra'.
		 */
		
		ArrayList<String> retorno = new ArrayList<String>();
		
		if ( palabra.length() < this.longGrama ) { return retorno; }
		
		String grama;
		int numGramas = palabra.length() - this.longGrama;
		
		for (int i=0 ; i <= numGramas ; i++){
			grama = palabra.substring(i,i+this.longGrama);
			if ( !retorno.contains(grama) ){
				retorno.add( grama );
			}
		}
		
		return retorno;
	}
	
	public void agregar(String palabra) {
		/*
		 * Agrega los gramas del string enviado como parámetro a
		 * la lista y asocia el parámetro a cada uno de los gramas agregados.
		 */
		
		ArrayList<String> gramas = this.crearListaDeGramas(palabra);
		
		for (String grama : gramas){
			if (-1 == this.indiceDe(grama) ){
				this.listaGramas.add( new NodoLIG(grama) );
			}
			
			int pos = this.indiceDe(grama);
			
			NodoLIG nodo = this.listaGramas.get(pos);
			
			nodo.addPalabra(palabra);
		}
	}
	
	public ArrayList<String> recuperarListaDePalabras(String palabra){ 
		/* 
		 *  Retorna una lista de todas las
		 *	palabras en la lista invertida que poseen al menos uno de los gramas del
		 *	parámetro.
		 */

		ArrayList<String> retorno = new ArrayList<String>();
		
		ArrayList<String> gramas = this.crearConjuntoDeGramas(palabra);
		
		int indice;
		NodoLIG nodo;
		ArrayList<String> palabras;
		
		for ( String grama : gramas){
			indice = this.indiceDe(grama);
			if (indice != -1){
				nodo = this.listaGramas.get(indice);
				palabras = nodo.getListaPalabras();
				
				for (String p : palabras){
					if ( !retorno.contains(p) ){
						retorno.add(p);
					}
				}
			}
		}
		
		
		return retorno;
	}
	

}
