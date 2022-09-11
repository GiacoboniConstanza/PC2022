/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio03;

import java.util.Scanner;

/**
 *
 * @author cotyg
 */
public class Encargado extends Thread {
    
    private Sala sala;
    
    public Encargado(Sala sala) {
        this.sala = sala;
    }
    
    public void run() {
        System.out.println(getName() + " --> Elija un asiento del 0 al 9");
        Scanner sc = new Scanner(System.in);
        int asiento = sc.nextInt();
        sala.reservar(asiento);
    }
}
