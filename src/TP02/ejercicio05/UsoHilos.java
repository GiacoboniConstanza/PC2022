/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio05;

/**
 *
 * @author cotyg
 */
public class UsoHilos {

    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando");
        MiHilo mh = new MiHilo();
        mh.unHilo("1");
        Thread nuevoHilo = new Thread(mh);
        nuevoHilo.start();
        /*MiHilo mh2 = new MiHilo();
        mh2.unHilo("2");
        Thread nuevoHilo2 = new Thread(mh2);
        nuevoHilo2.start();
        MiHilo mh3 = new MiHilo();
        mh3.unHilo("3");
        Thread nuevoHilo3 = new Thread(mh3);
        nuevoHilo3.start();*/
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
            //nuevoHilo.sleep(1000);
            //el metodo sleep() es estatico y solo afecta al hilo actual, no importa que lo llame otro
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}

/*
a) que pasaria si quitamos el sleep()? cual seria la salida del programa?
si se quita el sleep() en consola aparecera
Hilo principal finalizado
Comenzando 1
si se mantiene, en consola aparecera
Comenzando 1
Hilo principal finalizado

b)el main(), siempre termina al final o puede suceder que termine antes que el run()?
por que sucede esto?
puede terminar antes por el planificador del cpu

d) hacer 3 hilos y ejecutarlos, que ocurre? se ejecutan en orden?
los hilos no se ejecutan en orden por el indeterminismo debido al planificador del cpu
 */
