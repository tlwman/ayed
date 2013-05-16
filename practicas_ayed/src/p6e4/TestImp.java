package p6e4;

public class TestImp {

	public static void main(String[] args) {
		
		Impresora i = new Impresora();

		String a[] = {	"Primer documento a imprimir", 
						"hola mundo!", 
						"Un documento largo en tercer lugar, no muy util que digamos.", 
						"este es el ultimo orejon del tarro, por ahora.." };
		
		for (String s : a){
			i.nuevoDocumento( new Documento(s) );	
		}
		
		while ( i.imprimir() );		
	}

}
