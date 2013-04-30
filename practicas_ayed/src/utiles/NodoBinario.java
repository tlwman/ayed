package utiles;

public class NodoBinario <T>{

	private T dato;
	private NodoBinario<T> hijoIzquierdo;
	private NodoBinario<T> hijoDerecho;
	
	public NodoBinario(T dato){
		this.dato = dato;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
	}
	public NodoBinario<T> getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(NodoBinario<T> hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public NodoBinario<T> getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(NodoBinario<T> hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public T getDato() {
		return this.dato;
	}
	
	

}
