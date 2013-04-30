package p4e3;

import utiles.*;

public class ArbolMinMax extends ArbolBinario<DatoMinMax>{
	
	public ArbolMinMax(int valor, boolean esMax){
		super( new DatoMinMax(valor, esMax) );
	}
	
	public ArbolMinMax( NodoBinario<DatoMinMax> nodoBinario ){
		super(nodoBinario);
	}
	
	public ArbolMinMax getHijoIzquierdo(){
		return new ArbolMinMax(this.raiz.getHijoIzquierdo());
	}

	public ArbolMinMax getHijoDerecho(){
		return new ArbolMinMax(this.raiz.getHijoDerecho());
	}
	
	
	public void agregarHijoIzquierdo(ArbolMinMax hijo){
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}
	
	public void agregarHijoDerecho(ArbolMinMax hijo){
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}
	
	private int maximo(int hi, int hd){
		int val = this.getDatoRaiz().getValor();
		if (val > hi){
			return ((val>hd)? val : hd);
		}
		else{
			return ((hi>hd)? hi : hd);
		}
	}
	
	private int minimo(int hi, int hd){
		int val = this.getDatoRaiz().getValor();
		if (val < hi){
			return ((val<hd)? val : hd);
		}
		else{
			return ((hi<hd)? hi : hd);
		}
	}	
	public int evaluar(){
		
		if ((this.getHijoIzquierdo().getDatoRaiz() == null) && (this.getHijoDerecho().getDatoRaiz() == null)){
			return this.getDatoRaiz().getValor(); 
		}
		
		int hi, hd;
		hi = hd = ((this.getDatoRaiz().esMax())? Integer.MIN_VALUE : Integer.MAX_VALUE );
		
		if (this.getHijoIzquierdo().getDatoRaiz() != null){
			hi = this.getHijoIzquierdo().evaluar();
		}
		
		if (this.getHijoDerecho().getDatoRaiz() != null){
			hd = this.getHijoDerecho().evaluar();
		}
		
		if (this.getDatoRaiz().esMax())
			return this.maximo(hi, hd);
		else
			return this.minimo(hi, hd);
		
	}
	
}
