package TP05.ejercicio03;
import java.util.concurrent.*;

public class Boleteria {
    private int tickets = 0;
    private Semaphore semVendedor = new Semaphore(1);
    private Semaphore semPasajero = new Semaphore(0);
    private Semaphore semDisponible = new Semaphore(1);

    public Boleteria(){

    }

    public void agregar() throws InterruptedException{
        semVendedor.acquire();
    }

    public void usar() throws InterruptedException{
        semDisponible.acquire();
    }

    public void ponerBoleto(){
        tickets++;
    }

    public void liberar(){
        semDisponible.release();
    }

    public void notificaVendedor(){
        semVendedor.release();
    }

    public void sacar() throws InterruptedException{
        semPasajero.acquire();
    }

    public void notificaPasajero(){
        semPasajero.release();
    }

    public void comprarBoleto(){
        tickets--;
    }

}
