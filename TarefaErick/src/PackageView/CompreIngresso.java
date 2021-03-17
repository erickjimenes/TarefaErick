package PackageView;

import java.util.concurrent.Semaphore;
import Controller.ThreadIngress;

public class CompreIngresso {
	
	public static void main(String []args) {
		int id = 0;
		int ingresso = 100;
		Semaphore semaforo = new Semaphore(ingresso);
		for(int i = 0; i < 100; i++) {
			Thread threadIngresso = new ThreadIngress(id, semaforo);
			threadIngresso.start();
			id++;
		}
	}
	
	
	
}