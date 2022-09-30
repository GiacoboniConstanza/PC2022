/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP04.ejercicio04;

import java.util.Scanner;

/**
 *
 * @author cotyg
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Elija una cantidad de impresoras A");
        int cantA = sc.nextInt();
        System.out.println("Elija una cantidad de impresoras B");
        int cantB = sc.nextInt();
        
        Impresora[] impA = new Impresora[cantA];
        Impresora[] impB = new Impresora[cantB];

        for (int a = 0; a < cantA; a++) {
            impA[a] = new Impresora('a');
        }

        for (int b = 0; b < cantB; b++) {
            impB[b] = new Impresora('b');
        }

        CentroDeImpresoras centro = new CentroDeImpresoras(impA, impB);

        Usuario[] usuarios = new Usuario[5];
        for (int i = 0; i < 5; i++) {
            usuarios[i] = new Usuario('x', centro);
        }

        Thread[] hilosUsu = new Thread[5];

        for (int j = 0; j < 5; j++) {
            hilosUsu[j] = new Thread(usuarios[j]);
        }

        for (int k = 0; k < 5; k++) {
            hilosUsu[k].start();
        }
    }
}
