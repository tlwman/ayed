package p6e8;

public class Proceso implements Comparable<Proceso> {
	
	private String id;
	private int prioridad;
	
	public Proceso(String id, int prioridad){
		this.id = id;
		this.prioridad = prioridad;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getId() {
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
		return (this.id.equals(p.getId())) && (this.prioridad == p.getPrioridad());
	}
}
