package p6e8;

public class TestCDP {
	public static void main(String args[]){
		ConjuntoDeProcesos c = new ConjuntoDeProcesos();
		
		c.agregarProceso("bash", 4);
		c.agregarProceso("transmission", 1);
		c.agregarProceso("gnome-do", 0);
		c.agregarProceso("cron", 3);
		c.agregarProceso("vlc", 2);
		
		System.out.println("---------------Procesos-----------------");
		c.dump();

		System.out.println("---------------Inc VLC -----------------");
		c.incrementarPrioridad("vlc");
		
		System.out.println("-----------------Rtdos-------------------");
		c.dump();	
	}
}
