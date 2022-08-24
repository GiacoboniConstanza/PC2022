/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio05;

/**
 *
 * @author cotyg
 */
public class MiHilo implements Runnable {

    String nombreHilo;

    public void unHilo(String nombre) {
        nombreHilo = nombre;
    }

    public void run() {
        System.out.println("Comenzando " + nombreHilo);
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + nombreHilo + ", el recuento " + contar);
            }
        } catch (InterruptedException e) {
            System.out.println(nombreHilo + " Interrumpido.");
        }
        System.out.println("Terminado " + nombreHilo);
    }
}
