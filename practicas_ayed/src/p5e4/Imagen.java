package p5e4;

import utiles.*;

public class Imagen {
	private boolean matriz[][];
	private int dim;
	
	public Imagen(boolean[][] matriz, int dim){
		this.matriz = matriz;
		this.dim = dim;
	}
	
	public int getDim() {
		return dim;
	}
		
	public boolean mismoColor(){
		boolean prim = this.matriz[0][0];
		int  i=0, j=0;
		
		for ( i=0 ; i<this.dim ; i++ ){
			for ( j=0 ; j<this.dim ; j++ ){	
				if (prim != this.matriz[i][j]){
					return false;
				}
			}	
		}
		
		return true;
	}
	
	public boolean color(){
		return this.matriz[0][0];
	}
	
	public boolean[][] subImagen(int i1, int i2,int j1,int j2){
		boolean[][] retorno = new boolean[this.dim/2][this.dim/2];
		int i = i1;
		int j = j1;
		
		for( ; i<i2 ; i++){
			for(; j<j2 ; j++){
				retorno[i-i1][j-j1] = this.matriz[i][j];
			}	
		}
		return retorno;
	}
	
	public ListaEnlazadaGenerica<Imagen> getSubImagenes(){
		ListaEnlazadaGenerica<Imagen> subs = new ListaEnlazadaGenerica<Imagen>();
		
		if (this.dim <= 1){
			subs.agregar(this);
		}
		else{
			subs.agregar( new Imagen(this.subImagen(0, this.dim/2, 0, this.dim/2), this.dim/2) );
			subs.agregar( new Imagen(this.subImagen(this.dim/2, this.dim, 0, this.dim/2), this.dim/2) );
			subs.agregar( new Imagen(this.subImagen(0, this.dim/2, this.dim/2, this.dim), this.dim/2) );
			subs.agregar( new Imagen(this.subImagen(this.dim/2, this.dim, this.dim/2, this.dim), this.dim/2) );
		}
		return subs;
	}
	
	public ArbolGeneral<NodoIC>getComprimida(){
		ArbolGeneral<NodoIC> n;
		
		if (this.mismoColor()){
			n = new ArbolGeneral<NodoIC>( new NodoIC(this.color(), this.getDim()));
		}
		else{
			n = new ArbolGeneral<NodoIC>( new NodoIC(false, 0));
			ListaEnlazadaGenerica<Imagen> subs = this.getSubImagenes();
			
			subs.comenzar();
			while (!subs.fin()){
				n.agregarHijo(subs.elemento().getComprimida());
				subs.proximo();
			}
		}
		
		return n;
	}
}
