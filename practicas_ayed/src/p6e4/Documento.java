package p6e4;

public class Documento implements Comparable<Documento> {

	private String contenido;
	
	public Documento(){
		this.contenido = "";

	}
	
	public Documento(String c){
		this.contenido = c;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public int compareTo(Documento d){
		return this.contenido.length() - d.getContenido().length();
	}
	
	public String toString(){
		return this.contenido;
	}
	
}
