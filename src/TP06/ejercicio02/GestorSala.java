package TP06.ejercicio02;

public class GestorSala {
    private int capacidad = 50;
    private int umbral = 30;
    private int cantPersonas = 0;
    private int cantJubiladosEsperando = 0;

    public synchronized void entrarSala() throws InterruptedException{
        while(cantPersonas >= capacidad && cantJubiladosEsperando > 0){
            this.wait();
        }
        cantPersonas++;
    }

    public synchronized void entrarSalaJubilado() throws InterruptedException{
        cantJubiladosEsperando++;
        while(cantPersonas >= capacidad){
            this.wait();
        }
        cantJubiladosEsperando--;
        cantPersonas++;
    }

    public synchronized void salirSala(){
        cantPersonas--;
        System.out.println(Thread.currentThread().getName() + " Salio de la sala");
        this.notifyAll();
    }

    public synchronized void notificarTemperatura(int temp){
        if(temp > umbral){
            capacidad = 35;
        }else{
            capacidad = 50;
        }
    }
}
