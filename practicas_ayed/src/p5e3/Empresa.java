package p5e3;

import utiles.*;

public class Empresa {
	
	private ArbolGeneral<ListaEnlazadaGenerica<Empleado>> empleados;

	public ArbolGeneral<ListaEnlazadaGenerica<Empleado>> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArbolGeneral<ListaEnlazadaGenerica<Empleado>> empleados) {
		this.empleados = empleados;
	}
	
	public ListaEnlazadaGenerica<Integer> EmpleadosPorCategoria(){
		ListaEnlazadaGenerica<Integer> retorno = new ListaEnlazadaGenerica<Integer>();
		
		Cola<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> nivAct = new Cola<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>>();
		Cola<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> nivSgt = new Cola<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>>();
		Cola<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> tmp;
		ArbolGeneral<ListaEnlazadaGenerica<Empleado>> a;
		ListaEnlazadaGenerica<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> hijos;
		
		nivAct.agregar(this.empleados);
		
		while (!nivAct.esVacia()){
			int cant = 0;
			
			while (!nivAct.esVacia()){
				a = nivAct.sacar();
				cant = cant + a.getDatoRaiz().tamanio();
				hijos = a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()){
					nivSgt.agregar( hijos.elemento() );
					hijos.proximo();
				}
			}
			
			retorno.agregar(cant);
			
			tmp = nivAct;	nivAct = nivSgt; nivSgt = tmp;
		}
		return retorno;
	}
	
	public int categoriaConMasEmpleados(){
		
		ListaEnlazadaGenerica<Integer> res = this.EmpleadosPorCategoria();
		
		int i = 1;
		int cant = 0;
		int pos = i;
		
		res.comenzar();
		while (!res.fin()){
			if (res.elemento() > cant){
				cant = res.elemento();
				pos = i;
			}
			res.proximo();
			i++;
		}
		
		return pos;
	}
	
	public int cantidadTotalDeEmpleados() {
		
		ListaEnlazadaGenerica<Integer> res = this.EmpleadosPorCategoria();
		
		int cant = 0;

		res.comenzar();
		while (!res.fin()){
			cant = cant + res.elemento();
			res.proximo();
		}
		
		return cant;
	}
	
	private static Empleado masAntiguo( ListaEnlazadaGenerica<Empleado> plantel){
		if (plantel.esVacia()){
			return null;
		}
		
		int ant = -1;
		int pos = 0;
		int i = 0;
		
		plantel.comenzar();
		while (!plantel.fin()){
			if (plantel.elemento().getAntiguedad() > ant ){
				ant = plantel.elemento().getAntiguedad();
				pos = i;
			}
			plantel.proximo();
			i++;
		}
		
		return plantel.elemento(pos);	
	}
	
	private void promover(ArbolGeneral<ListaEnlazadaGenerica<Empleado>> jerarquia, Empleado promovido ){
		// Eliminar del nivel actual al promovido (o, retirado)
		jerarquia.getDatoRaiz().comenzar();
		while (jerarquia.getDatoRaiz().elemento() != promovido){
			jerarquia.getDatoRaiz().proximo();
		}
		jerarquia.getDatoRaiz().eliminar();
		
		// Si hay subjerarquias que provean sucesores, buscar al mas antiguo
		ListaEnlazadaGenerica<ArbolGeneral<ListaEnlazadaGenerica<Empleado>>> hijos = jerarquia.getHijos();
		if (hijos.esVacia()){
			return;
		}
		
		Empleado candidato = null;
		Empleado sucesor = new Empleado(0, "", -1);
		ArbolGeneral<ListaEnlazadaGenerica<Empleado>> origen;
		
		hijos.comenzar();
		origen = hijos.elemento();
		while(!hijos.fin()){
			candidato = Empresa.masAntiguo( hijos.elemento().getDatoRaiz() );
			if ( candidato.getAntiguedad() > sucesor.getAntiguedad() ){
				sucesor = candidato;
				origen = hijos.elemento();
			}
			hijos.proximo();
		}
		
		jerarquia.getDatoRaiz().agregar(sucesor);
		
		this.promover(origen, sucesor);
	}
	
	public void ReemplazarPresidente(){
		// Elimiar al mas antiguo de la jerarquia mas alta y promover reemplazos en cascada.
		this.promover(this.empleados, Empresa.masAntiguo( this.empleados.getDatoRaiz() ));
	}
}
