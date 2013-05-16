package p6e4;

import utiles.Heap;

public class Impresora implements DispositivoImpresion {

	private Heap cola;
	
	public Impresora(){
		this.cola = new Heap();
	}
	
	@Override
	public void nuevoDocumento(Documento d) {
		this.cola.agregar(d);
	}

	@Override
	public boolean imprimir() {
		Documento d = (Documento)this.cola.eliminar();
		
		if (d == null){
			return false;
		}
		
		System.out.println(d);
		return true;
	}

}
