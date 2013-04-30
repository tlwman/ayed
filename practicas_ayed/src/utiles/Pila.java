package utiles;

import java.util.ArrayList;

public class Pila<T> {
	
	private ArrayList<T> vector;
	
	public Pila(){
		this.vector = new ArrayList<T>();
	}
	
	public void poner(T elemento){
		this.vector.add(0, elemento);
	}
	
	public T sacar(){
		return (!this.vector.isEmpty())? this.vector.remove(0) : null;
	}
	
	public int alto(){
		return this.vector.size();
	}
	
	public void vaciar(){
		while (this.vector.size() > 0)
			this.vector.remove(0);
	}
	
	public boolean esVacia(){
		return this.vector.isEmpty();
	}

}
