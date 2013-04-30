package utiles;

import java.util.ArrayList;

public class Cola<T> {
	
	private ArrayList<T> vector;
	
	public Cola(){
		this.vector = new ArrayList<T>();
	}
	
	public void agregar(T elemento){
		this.vector.add(elemento);
	}
	
	public T sacar(){
		return (!this.vector.isEmpty())? this.vector.remove(0) : null;
	}
	
	public T tope(){
		return (!this.vector.isEmpty())? this.vector.get(0) : null;
	}
	
	public int largo(){
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
