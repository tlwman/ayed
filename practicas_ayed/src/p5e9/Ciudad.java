package p5e9;

public class Ciudad {
	
	private String nombre;
	private int sitiosTuristicos;
	
	public Ciudad( String nombre, int sitiosTuristicos){
		this.nombre = nombre;
		this.sitiosTuristicos = sitiosTuristicos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSitiosTuristicos() {
		return sitiosTuristicos;
	}

	public void setSitiosTuristicos(int sitiosTuristicos) {
		this.sitiosTuristicos = sitiosTuristicos;
	}

}
