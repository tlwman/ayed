package p5e5;

public class Contenido {
	
	private String nombre;
	private String tema;
	private int pagInicio;
	
	public Contenido(String nombre, String tema, int pagInicio){
		this.nombre = nombre;
		this.tema = tema;
		this.pagInicio = pagInicio;
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
	
	

}
