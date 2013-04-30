package p5e3;

public class Empleado {

	private int antiguedad;
	private String nombre;
	private int categoria;
	
	public Empleado(int categoria, String nombre, int antiguedad){
		this.categoria = categoria;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
}
