package p3e1;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {
	
	private int actual;

	private int[] datos;

	private int tamLogico;
	
	
	public ListaDeEnterosConArreglos(){
		
		this.tamLogico = 0;
		this.actual = -1;
		this.datos = new int[100];
	}
	
	@Override
	public void comenzar(){
		if (this.tamLogico > 0){
			this.actual = 0;
		}
		else{
			this.actual = -1;
		}
	}
	
	@Override
	public void proximo(){
		if (this.actual >= 0 && this.actual < (this.tamLogico)){
			this.actual++;
		}		
	}
	
	@Override
	public boolean fin(){
		return this.actual >= this.tamLogico;
	}
	
	@Override
	public int elemento(){
		return this.datos[this.actual];
	}
	
	@Override
	public int elemento(int pos){
		return this.datos[pos];
	}
	
	@Override
	public boolean agregar(int elem){
		if (this.tamLogico < 100){
			this.datos[this.tamLogico++] = elem;
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean agregar(int elem, int pos){
		if (this.tamLogico < 100 && pos >= 0 && pos <= this.tamLogico){
			for (int i=this.tamLogico ; i>pos ; i--){
				this.datos[i] = this.datos[i-1];
			}
			this.datos[pos] = elem;
			this.tamLogico++;
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean eliminar(){
		if (this.actual != -1){
			for (int i=this.actual ; i<this.tamLogico-1 ; i++){
				this.datos[i] = this.datos[i+1];
			}
			this.tamLogico--;
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean eliminar(int pos){
		if (pos>=0 && pos<this.tamLogico){
			for (;pos<this.tamLogico-1 ; pos++){
				this.datos[pos] = this.datos[pos+1];
			}
			this.tamLogico--;
			return true;
		}
		else{
			return false;
		}		
	}
	
	@Override
	public boolean esVacia(){
		return this.tamLogico == 0;
	}
	
	@Override
	public boolean incluye(int elem){
		int i=0;
		while (i<this.tamLogico){
			if (this.datos[i] == elem){ 
				return true;
			}
			i++;
		}
		return false;
	}
	
	@Override
	public int tamanio(){
		return this.tamLogico;
	}
}
