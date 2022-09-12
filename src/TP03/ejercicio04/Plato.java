/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio04;

/**
 *
 * @author Coqui
 */
public class Plato {

    private boolean ocupada = false;

    public boolean estaOcupado() {
        return ocupada;
    }

    public void usar() {
        ocupada = true;
    }

    public synchronized void comer() {
        System.out.println(Thread.currentThread().getName() + " 🍎🍎🍎");
        ocupada = false;
    }
}
