/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio02;

/**
 *
 * @author Xavi
 */
public class Main {
    public static void main(String[] args) {
        Vida vida = new Vida(10);
        Orco orco = new Orco(vida);
        Curandero curandero = new Curandero(vida);
        orco.start();
        curandero.start();
    }
}
