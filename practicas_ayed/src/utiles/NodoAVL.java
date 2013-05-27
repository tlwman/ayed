package utiles;

public class NodoAVL <T>{

	private T dato;
	private int altura;
	private NodoAVL<T> hijoIzquierdo;
	private NodoAVL<T> hijoDerecho;
	
	public NodoAVL(T dato){
		this.dato = dato;
		this.altura = 0;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
	}
	public NodoAVL<T> getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(NodoAVL<T> hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public NodoAVL<T> getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(NodoAVL<T> hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public T getDato() {
		return this.dato;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public void actAltura() {
		int ai = (this.hijoIzquierdo != null)? this.hijoIzquierdo.altura : -1;
		int ad = (this.hijoDerecho != null)? this.hijoDerecho.altura : -1;
		
		this.altura = 1 + ((ai > ad)? ai : ad);
	}
}
