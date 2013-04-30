package p5e3;

import utiles.ListaEnlazadaGenerica;
import java.util.Random;
import utiles.*;

public class testEmpresa {
	
	private static String ranNom(){
		Random r = new Random();
		String s = "";
		
		int largo = 6 + r.nextInt(6);
		for (int i = 0 ; i<largo ; i++){
			char c = Character.toChars( r.nextInt(26)+96 )[0];
			s = s + c;
		}
		return s;
	}
	
	private static int ranAnt(){
		return (new Random()).nextInt(15);
	}
	
	private static Empleado ranEmp(int i){
		return new Empleado(i, testEmpresa.ranNom(), testEmpresa.ranAnt() );
	}
	
	private static String strEmpleados(ListaEnlazadaGenerica<Empleado> lis ){
		String s = "[ ";
		lis.comenzar();
		while(!lis.fin()){
			s = s + lis.elemento().getNombre();
			lis.proximo();
			if (! lis.fin()){
				s = s + ", ";
			}
		}
		s = s + "]";
		return s;
	}
	
	private static void poEmps(ArbolGeneral<ListaEnlazadaGenerica<Empleado>> a){
		if (a.getDatoRaiz() != null){
			System.out.println(testEmpresa.strEmpleados(a.getDatoRaiz()));
			ListaEnlazadaGenerica<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> h = a.getHijos();
			h.comenzar();
			while (!h.fin()){
				testEmpresa.poEmps(h.elemento());
				h.proximo();
			}
		}
	}
	
	public static void main(String[] args){
		Empresa e = new Empresa();
		
		ListaEnlazadaGenerica<Empleado> nivel = new ListaEnlazadaGenerica<Empleado>();
		nivel.agregar(new Empleado(1,"Yo",999));
		ArbolGeneral<ListaEnlazadaGenerica<Empleado>> plantel = new ArbolGeneral<ListaEnlazadaGenerica<Empleado>>(nivel);
		
		nivel = new ListaEnlazadaGenerica<Empleado>();
		nivel.agregar(new Empleado(2,"Vice",2));
		nivel.agregar(new Empleado(2,"Vice^2",1));
		nivel.agregar(new Empleado(2,"Ñoqui",19));
		nivel.agregar(new Empleado(2,"Ñoqui",19));
		nivel.agregar(new Empleado(2,"Ñoqui",19));
		plantel.agregarHijo( new ArbolGeneral<ListaEnlazadaGenerica<Empleado>>(nivel) );
		
		nivel = new ListaEnlazadaGenerica<Empleado>();
		nivel.agregar(new Empleado(3,"Ñoqui",19));
		nivel.agregar(new Empleado(3,"Ñoqui",29));
		nivel.agregar(new Empleado(3,"Ñoqui Viejo",39));
		nivel.agregar(new Empleado(3,"Doctor",2));
		plantel.getHijos().elemento(0).agregarHijo( new ArbolGeneral<ListaEnlazadaGenerica<Empleado>>(nivel) );
	
		e.setEmpleados(plantel);
		testEmpresa.poEmps(plantel);
		
		System.out.println("Nivel con mas Emps: "+e.categoriaConMasEmpleados());
		System.out.println("Total Emps: "+e.cantidadTotalDeEmpleados());
		
		e.ReemplazarPresidente();
		testEmpresa.poEmps(e.getEmpleados());
		
	}
}
