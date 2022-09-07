package TP02.ejercicio06;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author 23437650624
 */
public class CajeroRunnable implements Runnable {

    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public CajeroRunnable(String nombre, Cliente cliente, long initialTIme) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;

    }

    public void run() {
        System.out.println("El cajero " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente "
                    + this.cliente.getNombre() + "->Tiempo: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }
        System.out.println("El cajero" + this.nombre + " HA TERMINADO DE PROCESAR "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");
    }

    private void esperarXsegundos(int tiempo) {
        tiempo = tiempo * 1000;
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println(this.nombre + " interrumpido");
        }
    }
}
