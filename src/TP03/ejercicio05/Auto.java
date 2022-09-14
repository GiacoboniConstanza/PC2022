/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio05;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotyg
 */
public class Auto extends Vehiculo implements Runnable {

    private Surtidor surtidor;

    public Auto(Surtidor surtidor, String marca, String patente, String modelo, int km, int combustible) {
        super(marca, patente, modelo, km, combustible);
        this.surtidor = surtidor;
    }

    public void run() {
        int cargado;
        do {
            combustible -= 2;
            if (combustible <= 6) {
                cargado = surtidor.cargar();
                if (cargado != 0) {
                    combustible += cargado;
                    System.out.println("Cargaste combustible con exito");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("No habia mas combustible");
                }
            }
        } while (combustible > 0);

    }

}
