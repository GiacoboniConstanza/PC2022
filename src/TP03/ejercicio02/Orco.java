/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio02;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Xavi
 */
public class Orco extends Thread {

    private Vida vida;

    public Orco(Vida vida) {
        this.vida = vida;
    }

    public void run() {
        while(vida.getVida() > 0) {
            try {
                this.atacar();
                if (vida.getVida() < 0) {
                    System.out.println("Moriste");
                }
            } catch (InterruptedException e) {
                Logger.getLogger(Orco.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private void atacar() throws InterruptedException {
        if (vida.getVida() > 0) {
            vida.modificarVida(-3);
            System.out.println("Fue atacado");
        } else {
            System.out.println("No se pudo atacar porque no tiene vida");
        }
    }
}
