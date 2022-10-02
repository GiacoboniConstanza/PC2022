/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio07;

import java.util.concurrent.Semaphore;

/**
 *
 * @author cotyg
 */
public class Control implements Runnable {
    private GestorCruce elCruce;

    public Control(GestorCruce elCruce) {
        this.elCruce = elCruce;
    }
    
    public void run(){
        int i = 0;
        while (i < 10){
            char semActivo = elCruce.getSemActivo();
            if(semActivo == 'n'){
                elCruce.setSemActivo('o');
                elCruce.liberarOeste();
            }else if(semActivo == 'o'){
                elCruce.setSemActivo('n');
                elCruce.liberarNorte();
            }
            i++;
        }
    }
}
