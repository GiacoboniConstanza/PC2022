/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio04;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotyg
 */
public class Impresora {

    private char tipo;
    private Semaphore semDisponible;
    
    public Impresora(char tipo) {
        this.tipo = tipo;
        this.semDisponible = new Semaphore(1, true);
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void usar(){
        try {
            semDisponible.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminar(){
        semDisponible.release();
    }
    
    public boolean intentarImprimir(){
        return (this.semDisponible.tryAcquire());
    }
}
