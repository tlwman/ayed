package p5e9;

import utiles.*;

public class Recorrido {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArbolGeneral<Ciudad> mapa = new ArbolGeneral<Ciudad>( new Ciudad( "Buenos Aires", 15) );
		
		//mapa.agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("Rosario", 13)) );
		//mapa.agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("Parana", 12)) );
		//mapa.agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("Bahia Blanca", 6)) );
		
		//mapa.getHijos().elemento(0).agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("Mendoza", 8)) );
		//mapa.getHijos().elemento(0).agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("San Miguel de Tucuman", 12)) );
		
		//mapa.getHijos().elemento(0).getHijos().elemento(0).agregarHijo( new ArbolGeneral<Ciudad>(new Ciudad("Salta", 11)) );
		
		//mapa.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Ciudad>(new Ciudad("Puerto Madryn", 4)) );

		Resultado res = Recorrido.buscarRecorrido( mapa );
		ListaEnlazadaGenerica<Ciudad> rec = res.getRecorrido();

		System.out.println("Recorrido: "+res.getLargo()+", "+res.getSitios());
		rec.comenzar();
		while (!rec.fin()){
			System.out.println( rec.elemento().getNombre());
			rec.proximo();
		}
		
	}

	public static Resultado buscarRecorrido( ArbolGeneral<Ciudad> a){
		
		Resultado res = new Resultado();
		
		if ( a.getDatoRaiz() != null){
			res.setLargo(1);
			res.agregarCiudad( a.getDatoRaiz());

			if ( a.getHijos().tamanio() != 0){
				
				ListaEnlazadaGenerica<ArbolGeneral<Ciudad>> hijos = a.getHijos();
				Resultado mejor = new Resultado( Integer.MAX_VALUE, Integer.MIN_VALUE );
				
				hijos.comenzar();
				while ( !hijos.fin() ){
					Resultado tmp = buscarRecorrido(hijos.elemento());
					
					if ( mejor.esMejor( tmp ) ){
						mejor = tmp;
					}
					hijos.proximo();
				}
				
				res.acumularSubResultado( mejor );
			}
		}
		
		return res;
	}
}
