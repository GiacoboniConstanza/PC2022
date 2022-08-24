/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio03;

/**
 *
 * @author cotyg
 */
public class ThreadEjemplo extends Thread {

    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        new ThreadEjemplo("Maria").start();
        new ThreadEjemplo("Jose").start();
        System.out.println("Termina thread main");
    }
}

/*
a) si lo ejecuto varias veces, que sucede?
se ejecuta el main, imprime Termina thread main
luego se ejecuta el for del hilo maria
se ejecuta el for del hilo jose
imprime por consola termina thread maria
imprime por consola termina thread jose
 */
