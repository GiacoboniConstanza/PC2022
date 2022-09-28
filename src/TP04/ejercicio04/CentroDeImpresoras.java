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
                imprimiendo(i);
            } else {
                i++;
            }
        } while (!noSePudo && cant < i);

        Random random = new Random();
        int pos = random.nextInt((cant - 0 + 1) + 0);
        imprimiendo(pos);
    }

    private void imprimiendo(int p) {
        impresoraA[p].usar();
        System.out.println("Imprimiendo");
        impresoraA[p].terminar();
    }
}
