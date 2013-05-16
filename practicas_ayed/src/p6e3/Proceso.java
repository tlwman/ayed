package p6e3;

public class Proceso implements Comparable<Proceso> {
	
	private int id;
	private int prioridad;
	
	public Proceso(int id, int prioridad){
		this.id = id;
		this.prioridad = prioridad;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getId() {
		return id;
	}
	
	public int compareTo(Proceso p){
		return this.prioridad - p.getPrioridad();
	}

	public String toString(){
		return "  ID="+this.id+"		Prioridad="+this.prioridad;
	}
	
	public boolean equals(Object o){
		Proceso p = (Proceso) o;
		return (this.id == p.getId()) && (this.prioridad == p.getPrioridad());
	}
}
