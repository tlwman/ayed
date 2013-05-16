package p5e4;

public class NodoIC {

	private boolean color;
	private int dim;
	
	public NodoIC(boolean color, int dim){
		this.color = color;
		this.dim = dim;
	}

	public boolean isColor( boolean color) {
		return color == this.color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
	
	public String toString(){
		return "Color: "+this.color +" dimension: "+ this.dim;
	}
}
