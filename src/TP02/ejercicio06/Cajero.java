/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio06;

/**
 *
 * @author cotyg
 */
public class Cajero {

    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " comienza a procesar la compra del cliente " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto " + (i + 1) + "->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
        }
        System.out.println("El cajero " + this.nombre + " ha terminado de procesar " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
    }

    private void esperarXsegundos(int tiempo) {
        tiempo = tiempo * 1000;
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Cajero interrumpido");
        }
    }
}
