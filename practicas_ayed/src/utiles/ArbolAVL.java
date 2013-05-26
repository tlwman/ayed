package utiles;

public class ArbolAVL<T extends Comparable<T>> {
	
	private NodoAVL<T> raiz;
	
	public ArbolAVL(){
		this.raiz = null;
	}
	
	public ArbolAVL( T dato){
		this.raiz = new NodoAVL<T>(dato);
	}

	private ArbolAVL( NodoAVL<T> nodo){
		this.raiz = nodo;
	}
	
	private NodoAVL<T> getRaiz(){
		return this.raiz;
	}
	
	public T getDatoRaiz(){
		return (this.raiz != null)? this.raiz.getDato() : null;
	}
	
	public ArbolAVL<T> getHijoIzquierdo(){
		return new ArbolAVL<T>( this.raiz.getHijoIzquierdo() );
	}

	public ArbolAVL<T> getHijoDerecho(){
		return new ArbolAVL<T>( this.raiz.getHijoDerecho() );
	}
	
	public boolean incluye(T dato){
		
		if (this.raiz != null){
			
			if (this.raiz.getDato().compareTo(dato) == 0 ){
				return true;
			}
			else{
				if (this.raiz.getDato().compareTo(dato) > 0){
					return this.getHijoIzquierdo().incluye(dato);
				}
				else{
					return this.getHijoDerecho().incluye(dato);
				}
			}
		}
		
		return false;
	}

	
	public T buscar(T dato){
		
		if (this.raiz != null){
			
			if (this.raiz.getDato().compareTo(dato) == 0 ){
				return this.raiz.getDato();
			}
			else{
				if (this.raiz.getDato().compareTo(dato) > 0){
					return this.getHijoIzquierdo().buscar(dato);
				}
				else{
					return this.getHijoDerecho().buscar(dato);
				}
			}
		}
		
		return null;
	}
	
	public void agregar(T dato){
		
		if ( this.raiz == null ){
			this.raiz = new NodoAVL<T>(dato);
		}
		else{
			if (this.raiz.getDato().compareTo(dato) == 0){
				this.raiz.setDato(dato);
			}
			else{
				if (this.raiz.getDato().compareTo(dato) > 0){
					
					if (this.raiz.getHijoIzquierdo() == null){
						this.raiz.setHijoIzquierdo( new NodoAVL<T>(dato) );
					}
					else{
						this.getHijoIzquierdo().agregar(dato);
					}
					
					if (this.getHijoIzquierdo().getAltura() > this.getHijoDerecho().getAltura()){
						this.getRaiz().setAltura( this.getRaiz().getAltura() + 1);
					}					
					
				}
				else{

					if (this.raiz.getHijoDerecho() == null){
						this.raiz.setHijoDerecho( new NodoAVL<T>(dato) );
					}
					else{
						this.getHijoDerecho().agregar(dato);
					}

					if (this.getHijoDerecho().getAltura() > this.getHijoIzquierdo().getAltura()){
						this.getRaiz().setAltura( this.getRaiz().getAltura() + 1);
					}										
					
				}
			}
		}
	}
	
	private NodoAVL<T> reemplazar(T dato){
		
		if (this.esVacio()){
			return null;
		}
		
		ArbolAVL<T> hi = this.getHijoIzquierdo();
		ArbolAVL<T> hd = this.getHijoDerecho();
		
		if (this.raiz.getDato().compareTo(dato) < 0){
			this.raiz.setHijoDerecho( hd.reemplazar(dato) );
			return this.raiz;
		}
		else if (this.raiz.getDato().compareTo(dato) > 0){
			this.raiz.setHijoIzquierdo( hi.reemplazar(dato) );
			return this.raiz;
		}
		else{
			
			if ( hi.getDatoRaiz() == null && hd.getDatoRaiz() == null){
				return null;
			}
			else if (hi.getDatoRaiz() == null){
				return hd.getRaiz();
			}
			else if (hd.getDatoRaiz() == null){
				return hi.getRaiz();
			}
			else {
				ArbolAVL<T> n = this.getHijoDerecho();
				while (n.getHijoIzquierdo().getDatoRaiz() != null){
					n = n.getHijoIzquierdo();
				}
				
				T nuevo = n.getDatoRaiz();
				this.eliminar(nuevo);
				this.raiz.setDato(nuevo);
				return this.raiz;
			}
		}
	}
	
	public void eliminar(T dato){
		
		if (this.raiz != null){
			this.raiz = this.reemplazar(dato);
		}
	}
	
	public boolean esVacio(){
		if (this.raiz == null) 
			return true;
		
		if (this.raiz.getDato() == null)
			return true;
		
		return false;
	}
	
	public int getAltura(){
		return (this.raiz == null)? -1 : this.raiz.getAltura();
	}
	
	private void rotacionSimpleIzq(){
		
	}
}
