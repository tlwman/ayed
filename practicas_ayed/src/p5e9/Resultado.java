package p5e9;

import utiles.*;

public class Resultado {
	
	private int largo;
	private int sitios;
	private ListaEnlazadaGenerica<Ciudad> recorrido;
	
	public Resultado() {
		this.largo = 0;
		this.sitios = 0;
		this.recorrido = new ListaEnlazadaGenerica<Ciudad>();
	}
	
	public Resultado( int largo, int sitios) {
		this.largo = largo;
		this.sitios = sitios;
		this.recorrido = new ListaEnlazadaGenerica<Ciudad>();
	}	
	public Resultado( int largo, Ciudad ciudad) {
		this();
		this.largo = largo;
		this.sitios = ciudad.getSitiosTuristicos();
		this.recorrido.agregar(ciudad);
	}	
	
	public int getLargo() {
		return largo;
	}
	
	public void setLargo(int largo) {
		this.largo = largo;
	}
	
	public int getSitios() {
		return sitios;
	}
	
	public void setSitios(int sitios) {
		this.sitios = sitios;
	}
	
	public ListaEnlazadaGenerica<Ciudad> getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(ListaEnlazadaGenerica<Ciudad> recorrido) {
		this.recorrido = recorrido;
	}

	public boolean esMejor( Resultado res){
		return (this.largo > res.getLargo()) || ( (this.largo == res.getLargo()) && (this.sitios < res.getSitios()) );
	}
	
	public void agregarCiudad( Ciudad c){
		this.sitios = this.sitios + c.getSitiosTuristicos();
		this.recorrido.agregar(c);
	}

	public void acumularSubResultado( Resultado r ){
		this.largo = this.largo + r.getLargo();
		this.sitios = this.sitios + r.getSitios();
		
		ListaEnlazadaGenerica<Ciudad> ciudades = r.getRecorrido();
		ciudades.comenzar();
		while (! ciudades.fin() ){
			this.recorrido.agregar( ciudades.elemento() );
			ciudades.proximo();
		}
	}
}
