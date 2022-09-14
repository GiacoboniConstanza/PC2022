/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio05;

/**
 *
 * @author cotyg
 */
public class Surtidor {

    private int disponible = 500;

    public synchronized int cargar() {
        int carga = 0;
        if (disponible <= 30) {
            carga = 30;
            disponible += -30;
        }
        return carga;
    }

}
