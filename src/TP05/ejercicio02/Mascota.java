package TP05.ejercicio02;

public class Mascota implements Runnable{
	private String tipo;
	private Comedor comedor;
	
	public Mascota(String t, Comedor c) {
		this.tipo = t;
		this.comedor = c;
	}
	
	public void run() {
		
	}
}
