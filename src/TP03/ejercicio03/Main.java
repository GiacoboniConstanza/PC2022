/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio03;

/**
 *
 * @author Coqui
 */
public class Main {

    public static void main(String[] args) {
        Sala sala1 = new Sala();

        Encargado encargado1 = new Encargado(sala1);
        encargado1.setName("Uno");
        Encargado encargado2 = new Encargado(sala1);
        encargado2.setName("Dos");

        encargado1.start();
        encargado2.start();
    }
}
