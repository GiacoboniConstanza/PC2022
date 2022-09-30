/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio04;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cotyg
 */
public class CentroDeImpresoras {

    private Impresora[] impresoraA;
    private Impresora[] impresoraB;
    Semaphore semBuscando = new Semaphore(1);

    public CentroDeImpresoras(Impresora[] impresoraA, Impresora[] impresoraB) {
        this.impresoraA = impresoraA;
        this.impresoraB = impresoraB;
    }

    public void imprimirA() {
        try {
            semBuscando.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CentroDeImpresoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        while (noSePudo && i < cant) {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                semBuscando.release();
                imprimiendoTryA(i);
            } else {
                i++;
            }
        }

        if (noSePudo) {
            Random random = new Random();
            int pos = random.nextInt((cant - 0) + 0);
            semBuscando.release();
            imprimiendoA(pos);
        }
    }

    private void imprimiendoA(int p) {
        impresoraA[p].usar();
        System.out.println(Thread.currentThread().getName() + "Imprimiendo A");
        impresoraA[p].terminar();
    }

    private void imprimiendoTryA(int p) {
        System.out.println(Thread.currentThread().getName() + " Imprimiendo A");
        impresoraA[p].terminar();
    }

    public void imprimirB() {
        int cant = impresoraB.length;
        int i = 0;
        boolean noSePudo = true;
        while (noSePudo && i < cant) {
            if (impresoraB[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendoTryB(i);
            } else {
                i++;
            }
        }
        if (noSePudo) {
            Random random = new Random();
            int pos = random.nextInt((cant - 0) + 0);
            imprimiendoB(pos);
        }
    }

    private void imprimiendoB(int p) {
        impresoraB[p].usar();
        System.out.println(Thread.currentThread().getName() + " Imprimiendo B");
        impresoraB[p].terminar();
    }

    private void imprimiendoTryB(int p) {
        System.out.println(Thread.currentThread().getName() + " Imprimiendo B");
        impresoraB[p].terminar();
    }

    public void imprimirX() {
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        while (noSePudo && i < cant) {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendoTryA(i);
            } else {
                i++;
            }
        }

        if (noSePudo) {
            cant = impresoraB.length;
            i = 0;
            while (noSePudo && i < cant) {
                if (impresoraB[i].intentarImprimir()) {
                    noSePudo = false;
                    imprimiendoTryB(i);
                } else {
                    i++;
                }
            }
            if (noSePudo) {
                Random random = new Random();
                int pos = random.nextInt((cant - 0) + 0);
                imprimiendoB(pos);
            }
        }
    }
}
