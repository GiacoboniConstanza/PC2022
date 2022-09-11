/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio03;

/**
 *
 * @author cotyg
 */
public class Sala {

    private boolean[] asientos = new boolean[10];

    public synchronized void reservar(int pos) {
        if (!asientos[pos]) {
            asientos[pos] = true;
            System.out.println(Thread.currentThread().getName() + " --> Reservado con exito");
        } else {
            System.out.println(Thread.currentThread().getName() + " --> No pudo reservarse");
        }
    }
}
