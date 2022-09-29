/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio04;

import java.util.Random;

/**
 *
 * @author cotyg
 */
public class CentroDeImpresoras {

    private Impresora[] impresoraA;
    private Impresora[] impresoraB;

    /* public CentroDeImpresoras(Impresora[] impresoraA, Impresora[] impresoraB) {
        this.impresoraA = impresoraA;
        this.impresoraB = impresoraB;
    }
     */
    public void imprimirA() {
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendoA(i);
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        Random random = new Random();
        int pos = random.nextInt((cant - 0 + 1) + 0);
        imprimiendoA(pos);
    }

    private void imprimiendoA(int p) {
        impresoraA[p].usar();
        System.out.println("Imprimiendo");
        impresoraA[p].terminar();
    }

    public void imprimirB() {
        int cant = impresoraB.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraB[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendoB(i);
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        Random random = new Random();
        int pos = random.nextInt((cant - 0 + 1) + 0);
        imprimiendoB(pos);
    }

    private void imprimiendoB(int p) {
        impresoraB[p].usar();
        System.out.println("Imprimiendo");
        impresoraB[p].terminar();
    }

    public void imprimirX() {
        int cant = impresoraA.length;
        int i = 0;
        boolean noSePudo = true;
        do {
            if (impresoraA[i].intentarImprimir()) {
                noSePudo = false;
                imprimiendoA(i);
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        if (!noSePudo) {
            cant = impresoraB.length;
            i = 0;
            do {
                if (impresoraB[i].intentarImprimir()) {
                    noSePudo = false;
                    imprimiendoB(i);
                } else {
                    i++;
                }
            } while (!noSePudo && cant < i);
            Random random = new Random();
            int pos = random.nextInt((cant - 0 + 1) + 0);
            imprimiendoB(pos);
        }
    }
}
