package TP02.ejercicio06;


import TP02.ejercicio06.CajeroRunnable;
import TP02.ejercicio06.CajeroRunnable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author 23437650624
 */
public class MainRunnable {

    public static void main(String args[]) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        long initialTime = System.currentTimeMillis();

        CajeroRunnable cajero1 = new CajeroRunnable("Cajero 1", cliente1, initialTime);
        CajeroRunnable cajero2 = new CajeroRunnable("Cajero 2", cliente2, initialTime);

        Thread c1 = new Thread(cajero1);
        Thread c2 = new Thread(cajero2);

        c1.start();
        c2.start();
    }
}
