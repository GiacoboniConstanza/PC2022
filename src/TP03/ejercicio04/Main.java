/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio04;

/**
 *
 * @author Coqui
 */
public class Main {

    public static void main(String[] args) {
        Hamaca hamaca = new Hamaca();
        Plato plato = new Plato();
        Rueda rueda = new Rueda();

        Hamster h1 = new Hamster(hamaca, plato, rueda);
        h1.setName("Jon");
        Hamster h2 = new Hamster(hamaca, plato, rueda);
        h2.setName("Ygritte");

        h1.start();
        h2.start();
        
        try{
            h1.join();
            h2.join();
        } catch (InterruptedException e){
            
        }
    }
}
