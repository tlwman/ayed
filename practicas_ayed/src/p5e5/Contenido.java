package p5e5;

public class Contenido {
	
	private String nombre;
	private String tema;
	private int pagInicio;
	private char tipo;
	
	public Contenido(String nombre, String tema, int pagInicio, char tipo){
		this.nombre = nombre;
		this.tema = tema;
		this.pagInicio = pagInicio;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public int getPagInicio() {
		return pagInicio;
	}
	public void setPagInicio(int pagInicio) {
		this.pagInicio = pagInicio;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public boolean esSeccion(){
		return this.tipo == 'S';
	}
	public boolean esCapitulo(){
		return this.tipo == 'C';
	}
	public boolean esApendice(){
		return this.tipo == 'A';
	}
}
