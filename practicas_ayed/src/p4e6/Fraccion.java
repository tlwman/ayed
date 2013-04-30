package p4e6;

public class Fraccion {
	private int denominador;
	private int numerador;
	
	public Fraccion(int numerador, int denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	
	public boolean equals(Object object){
		Fraccion obj = (Fraccion) object;
		return (this.numerador == obj.getNumerador() ) && (this.denominador == obj.getDenominador() );
	}
	
	public String toString(){
		return this.numerador+"/"+this.denominador;
	}
	
	public int compareTo(Object o){
		Fraccion f = (Fraccion) o;
		int a,b;
		
		a = this.numerador  * f.getDenominador();
		b = f.getNumerador() * this.denominador;
		
		return a-b;
		
	}
}
