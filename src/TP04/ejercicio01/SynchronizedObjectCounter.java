/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio01;

/**
 *
 * @author cotyg
 */
public class SynchronizedObjectCounter {

    private int c = 0;

    public void increment() {
        synchronized ((Integer) c) {
            c++;
        }
        //se sincroniza con el lock del objeto de c
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
        //se sincroniza con la instancia pero no impide q se acceda
        //al lock del objeto c
    }

    public int value() {
        return c;
    }
}

/*
al ser diferentes lock se puede decrementar e incrementar al mismo tiempo
*/
