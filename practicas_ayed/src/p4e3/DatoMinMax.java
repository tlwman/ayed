package p4e3;

public class DatoMinMax {
	
	private boolean esMax;
	private int valor;
	
	public DatoMinMax(int valor, boolean esMax){
		this.valor = valor;
		this.esMax = esMax;
	}

	public boolean esMax(){
		return this.esMax;
	}
	
	public void setValor(int valor){
		this.valor = valor;
	}

	public void setMax(){
		this.esMax = true;
	}

	public void setMin(){
		this.esMax = false;
	}
	
	public boolean esMin(){
		return !this.esMax;
	}
	
	public int getValor(){
		return this.valor;
	}
}
