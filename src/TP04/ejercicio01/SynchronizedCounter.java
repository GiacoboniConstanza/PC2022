/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio01;

/**
 *
 * @author cotyg
 */
public class SynchronizedCounter {

    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}

/*
el metodo decrement deberia ser synchronized
*/