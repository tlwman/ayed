package p5e10;

public class Corista {
	
	private String nombre;
	private String apellido;
	private String categoria;
	
	public Corista( String nombre, String apellido, String categoria){
		this.nombre = nombre;
		this.apellido = apellido;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public boolean seLlama(String nombre, String apellido){
		return ( apellido == this.apellido && nombre == this.nombre );
	}
	
	public boolean equals(Object obj){
		Corista c = (Corista) obj;
		return ( c.getApellido() == this.apellido && c.getNombre() == this.nombre && c.getCategoria() == this.categoria );
	}
	
	public String toString(){
		return "Nombre y apellido: "+this.nombre+" "+this.apellido+"\nCategoria: "+this.categoria+"\n";
	}
}
