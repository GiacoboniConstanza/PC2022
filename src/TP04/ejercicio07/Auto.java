/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio07;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotyg
 */
public class Auto implements  Runnable{
    private GestorCruce elCruce;
    private char direccion;

    public Auto(GestorCruce elCruce, char direccion) {
        this.elCruce = elCruce;
        this.direccion = direccion;
    }
    
    public void run(){
        if(direccion=='n'){
            elCruce.llegaNorte();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
            elCruce.saleNorte();
        }else if(direccion=='o'){
            elCruce.llegaOeste();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
            elCruce.saleOeste();
        }
    }
}