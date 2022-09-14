/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio04;

/**
 *
 * @author Coqui
 */
public class Hamaca {

    private boolean ocupada = false;

    public boolean estaOcupado() {
        return ocupada;
    }

    public synchronized void dormir() {
        if(!estaOcupado()){
            System.out.println(Thread.currentThread().getName() + " 🌟🌙🌟");
            ocupada = true;
        }
    }
}
