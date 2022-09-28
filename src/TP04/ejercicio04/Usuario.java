/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio04;

/**
 *
 * @author cotyg
 */
public class Usuario implements Runnable {

    private char tipo;
    private CentroDeImpresoras centro;

    public Usuario(char tipo) {
        this.tipo = tipo;
    }

    public void run() {
        tipo = java.lang.Character.toLowerCase(tipo);
        switch (tipo) {
            case 'a':
                imprimirA();
                break;
            /*case 'b':
                imprimirB();
                break;
            case 'x':
                imprimirX();
                break;*/
            default:
                System.out.println("elegi bien, kpo");
                break;

        }
    }

    private void imprimirA() {
        centro.imprimirA();
    }
}
