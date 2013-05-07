package p5e8;

import utiles.ArbolGeneral;
import utiles.ListaEnlazadaGenerica;
import p5e4.NodoIC;

public class QuadTree extends ArbolGeneral<NodoIC> {
	
	public QuadTree( int dim, boolean color){
		super(new NodoIC(color, dim));
	}
	
	public QuadTree( NodoIC dato){
		super( dato );
	}
	
	public int pixelsIn( boolean color){
		int total = 0;
		if ( this.getDatoRaiz() != null ){
				
			if ( this.getHijos().tamanio() == 0){
				if ( this.getDatoRaiz().isColor() == color ){
					int sup = this.getDatoRaiz().getDim();
					System.out.println(sup*sup+" pixels in "+color );
					return sup * sup;	
				}
			}
			else{
				ListaEnlazadaGenerica<ArbolGeneral<NodoIC>> hs = this.getHijos();
				hs.comenzar();
				while (!hs.fin()){
					QuadTree aux = new QuadTree( hs.elemento().getDatoRaiz() );
					
					if (aux.getDatoRaiz().isColor() == color){
						total = total + aux.pixelsIn(color);
					}
					hs.proximo();
				}
			}
		}
		
		return total;
	}
}
