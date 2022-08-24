/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio04;

/**
 *
 * @author cotyg
 */
public class ThreadEjemplo implements Runnable {

    private String nombreHilo;

    public ThreadEjemplo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    public String getName() {
        return nombreHilo;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        ThreadEjemplo hilo1 = new ThreadEjemplo("Maria");
        ThreadEjemplo hilo2 = new ThreadEjemplo("Jose");
        
        Thread h1 = new Thread(hilo1);
        Thread h2 = new Thread(hilo2);

        h1.start();
        h2.start();

        System.out.println("Termina thread main");
    }
}
