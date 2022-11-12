package TP05.ejercicio02;

import java.util.concurrent.Semaphore;

public class Contador {
	private int esperando = 0;
	private int comiendo = 0;
	private String tipo;
	private Semaphore puedeComer = new Semaphore(1);
	
	public Contador(String t) {
		this.tipo = t;
	}
	
	public int getComiendo() {
		return comiendo;
	}

	public int getEsperando(){
		return esperando;
	}
}
