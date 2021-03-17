package Controller;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class ThreadIngress extends Thread{

	private int ingressos = 100;
	int idComprador;
	private Semaphore semaforo;
	
	public ThreadIngress(int idComprador, Semaphore semaforo) {
		this.idComprador = idComprador;
		this.semaforo = semaforo;
	}
	
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			fazerCompra();
			validarCompra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}


	private void fazLogin() {
		int tempoLogin = (int)((Math.random() * 1950) + 50);
		if (tempoLogin >= 1000) {
			System.out.println("Tempo esgotado");
		} else {
				try {
				Thread.sleep(tempoLogin);
			} 	catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	
	public void fazerCompra() {
		int tempoCompra = (int)((Math.random() * 2001) + 1000);
		if(tempoCompra > 2500) {
			System.out.println("Compra encerrada por exceder o limite de tempo");
		} else {
				try {
				Thread.sleep(tempoCompra);
			} 	catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	
	public void validarCompra() {
		int quantidadeIngresso = (int)((Math.random() * 4) + 1);
		if(quantidadeIngresso < ingressos) {
			ingressos = ingressos - quantidadeIngresso;
			System.out.println("Cliente #" + idComprador + " comprou " + quantidadeIngresso + ", e agora só restam: " + ingressos);
			
		} else {
			System.out.println("Ops, parece que todos os ingressos acabaram.");
		}
		
	}
	
	
	
}