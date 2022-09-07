/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio02;

/**
 *
 * @author Xavi
 */
public class Orco extends Thread {

    private Vida vida;

    public Orco(Vida vida ) {
        this.vida = vida;
    }

    public void run() {
        vida.modificarVida(-3);
    }
}
