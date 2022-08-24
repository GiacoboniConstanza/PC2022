/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio05;

/**
 *
 * @author cotyg
 */
public class MiThread extends Thread {

    public void run() {
        System.out.println("Comenzando " + getName());
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("En " + getName() + ", el recuento " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " Interrumpido.");
        }
        System.out.println("Terminado " + getName());
    }
}
