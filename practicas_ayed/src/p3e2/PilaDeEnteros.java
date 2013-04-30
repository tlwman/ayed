package p3e2;

import p3e1.ListaDeEnterosEnlazada;

public class PilaDeEnteros {
	
	private ListaDeEnterosEnlazada datos;
	
	public PilaDeEnteros(){
		this.datos = new ListaDeEnterosEnlazada();
	}
	
	public void poner(int elem){
		this.datos.agregar(elem);
	}
	
	public int sacar(){
		int dato = this.datos.elemento(this.datos.tamanio()-1);
		this.datos.eliminar( this.datos.tamanio()-1 );
		
		return dato;
	}
	
	public boolean esVacia(){
		return this.datos.esVacia();
	}
	
	public int tope(){
		return this.datos.elemento(this.datos.tamanio()-1);
	}
}
