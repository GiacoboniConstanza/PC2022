/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio02;

/**
 *
 * @author Xavi
 */
public class Vida {

    private int vida;

    public Vida(int vida) {
        this.vida = vida;
    }

    public synchronized void modificarVida(int n) {
        vida += n;
    }
}
