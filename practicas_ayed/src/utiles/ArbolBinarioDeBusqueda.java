package utiles;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
	
	private NodoBinario<T> raiz;
	
	public ArbolBinarioDeBusqueda(){
		this.raiz = null;
	}
	
	public ArbolBinarioDeBusqueda( T dato){
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinarioDeBusqueda( NodoBinario<T> nodo){
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){
		return this.raiz;
	}
	
	public T getDatoRaiz(){
		return (this.raiz != null)? this.raiz.getDato() : null;
	}
	
	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo(){
		return new ArbolBinarioDeBusqueda<T>( this.raiz.getHijoIzquierdo() );
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho(){
		return new ArbolBinarioDeBusqueda<T>( this.raiz.getHijoDerecho() );
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
			this.raiz = new NodoBinario<T>(dato);
		}
		else{
			if (this.raiz.getDato().compareTo(dato) == 0){
				this.raiz.setDato(dato);
			}
			else{
				if (this.raiz.getDato().compareTo(dato) > 0){
					
					if (this.raiz.getHijoIzquierdo() == null){
						this.raiz.setHijoIzquierdo( new NodoBinario<T>(dato) );
					}
					else{
						this.getHijoIzquierdo().agregar(dato);
					}
				}
				else{

					if (this.raiz.getHijoDerecho() == null){
						this.raiz.setHijoDerecho( new NodoBinario<T>(dato) );
					}
					else{
						this.getHijoDerecho().agregar(dato);
					}
				}
			}
		}
	}
	
	private NodoBinario<T> reemplazar(T dato){
		
		if (this.esVacio()){
			return null;
		}
		
		ArbolBinarioDeBusqueda<T> hi = this.getHijoIzquierdo();
		ArbolBinarioDeBusqueda<T> hd = this.getHijoDerecho();
		
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
				ArbolBinarioDeBusqueda<T> n = this.getHijoDerecho();
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
}
