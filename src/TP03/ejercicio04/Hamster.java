/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio04;

import java.util.Random;

/**
 *
 * @author Coqui
 */
public class Hamster extends Thread {

    private Hamaca hamaca;
    private Plato plato;
    private Rueda rueda;

    public Hamster(Hamaca hamaca, Plato plato, Rueda rueda) {
        this.hamaca = hamaca;
        this.plato = plato;
        this.rueda = rueda;
    }

    public void run() {
        Random random = new Random();
        int opcion = random.nextInt((3 + 1) + 1);

        switch (opcion) {
            case 1:
                if (plato.estaOcupado()) {
                    plato.usar();
                    plato.comer();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Se murio comiendo");
                    }
                }
                break;
            case 2:
                if (rueda.estaOcupado()) {
                    rueda.usar();
                    rueda.correr();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Se murio corriendo");
                    }
                }
                break;
            case 3:
                if (hamaca.estaOcupado()) {
                    hamaca.dormir();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Se murio durmiendo");
                    }
                }
                break;
        }
    }
}
