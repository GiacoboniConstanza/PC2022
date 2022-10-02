/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio07;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotyg
 */
public class GestorCruce {

    private Semaphore semNorte = new Semaphore(1, true);
    private Semaphore semOeste = new Semaphore(0, true);
    private char semActivo = 'o';

    public void llegaNorte() {
        try {
            semNorte.acquire();
            System.out.println(Thread.currentThread().getName() + " esta cruzando el semaforo norte");
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saleNorte() {
        System.out.println(Thread.currentThread().getName() + " termino de cruzar");
        semNorte.release();
    }

    public void llegaOeste() {
        try {
            semOeste.acquire();
            System.out.println(Thread.currentThread().getName() + " esta cruzando el semaforo oeste");
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saleOeste() {
        System.out.println(Thread.currentThread().getName() + " termino de cruzar");
        semOeste.release();
    }

    public char getSemActivo() {
        return semActivo;
    }

    public void setSemActivo(char semActivo) {
        this.semActivo = semActivo;
    }

    public void liberarOeste(){
        semOeste.release();
    }
    
    public void liberarNorte(){
        semNorte.release();
    }
}
