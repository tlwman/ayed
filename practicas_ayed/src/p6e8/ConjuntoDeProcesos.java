package p6e8;

import utiles.MaxHeap;

public class ConjuntoDeProcesos {
	
	private MaxHeap<Proceso> jip;
	private int cantidad;
	
	public ConjuntoDeProcesos(){
		this.jip = new MaxHeap<Proceso>();
		this.cantidad = 0;
	}
	
	public void agregarProceso (String id, int prioridad){
		this.jip.agregar( new Proceso(id, prioridad) );
		this.cantidad = this.cantidad + 1;
	}
	
	public String retornarMayorPrioridad(){
		return this.jip.maximo().getId();
	}
	
	public void incrementarPrioridad (String id){
		
		MaxHeap<Proceso> aux = new MaxHeap<Proceso>();
		boolean encontrada = false;
		
		while (!this.jip.esVacia() && !encontrada){
			Proceso p = this.jip.eliminar();
			System.out.println(">>>"+p);
			if (p.getId().equals(id)){
				encontrada = true;
				p.setPrioridad( p.getPrioridad() + 1);
			}
			aux.agregar( p );
		}
		
		while ( !aux.esVacia() ){
			System.out.println(">>>>>>"+aux.maximo());
			this.jip.agregar( aux.eliminar() );
		}
	}
	
	public void dump(){
		this.jip.dump();
	}
	
}
