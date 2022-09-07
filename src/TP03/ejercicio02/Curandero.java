/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavi
 */
public class Curandero extends Thread {

    private Vida vida;

    public Curandero(Vida v) {
        this.vida = v;
    }

    public void run() {
        while(vida.getVida() > 0) {
            try {
                this.curar();
                if (vida.getVida() < 0) {
                    System.out.println("Moriste");
                }
            } catch (InterruptedException e) {
                Logger.getLogger(Curandero.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private void curar() throws InterruptedException {
        if (vida.getVida() > 0) {
            vida.modificarVida(3);
            System.out.println("Fue curado");
        } else {
            System.out.println("No se pudo atacar porque no tiene vida");
        }
    }
}
