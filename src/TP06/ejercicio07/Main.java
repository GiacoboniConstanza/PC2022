package TP06.ejercicio07;

public class Main {
    public static void main(String[] args) {
        Olla unaOlla = new Olla();
        Cocinero cocinero = new Cocinero(unaOlla);
        Canibal[] canibales = new Canibal[20];
        Thread hiloCocinero = new Thread(cocinero);
        Thread[] hilosCanibales = new Thread[20];
        for (int i = 0; i < canibales.length; i++) {
            canibales[i] = new Canibal(unaOlla);
            hilosCanibales[i] = new Thread(canibales[i]);
            hilosCanibales[i].start();
        }
        hiloCocinero.start();
    }
}
