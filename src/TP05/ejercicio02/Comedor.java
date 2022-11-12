package TP05.ejercicio02;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Comedor {
	private Semaphore platos = new Semaphore(10);
	private Semaphore prioridad = new Semaphore(1);
	
	HashMap<String, Contador> contador = new HashMap<String, Contador>();
	
	public void comer(String tipo) {
		Contador unContador = contador.get(tipo);
		
	}
}
