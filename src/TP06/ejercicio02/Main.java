package TP06.ejercicio02;

import TP02.ejercicio03.ThreadEjemplo;

public class Main {
    public static void main(String[] args) {
        GestorSala unaSala = new GestorSala();
        Persona[] aPersonas = new Persona[100];
        Jubilado[] aJubilados = new Jubilado[100];
        ControlTemp eControlTemp = new ControlTemp(unaSala);

        // Hilos
        Thread[] hilosPersonas = new Thread[100];
        Thread[] hilosJubilados = new Thread[100];
        Thread hiloTemp = new Thread(eControlTemp);

        for (int i = 0; i < hilosJubilados.length; i++) {
            aJubilados[i] = new Jubilado(unaSala);
            hilosJubilados[i] = new Thread(aJubilados[i]);
            hilosJubilados[i].start();
        }
        for (int i = 0; i < hilosPersonas.length; i++) {
            aPersonas[i] = new Persona(unaSala);
            hilosPersonas[i] = new Thread(aPersonas[i]);
            hilosPersonas[i].start();
        }

        hiloTemp.start();

    }
}
