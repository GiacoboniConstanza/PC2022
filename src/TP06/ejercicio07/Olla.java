package TP06.ejercicio07;
import java.util.concurrent.*;

public class Olla {
    private Semaphore semCocinero = new Semaphore(0);
    private Semaphore semCanibal = new Semaphore(1, true);
    private Semaphore semDisponible = new Semaphore(1);
    private int comida = 5;

    public void comer() throws InterruptedException{
        semCanibal.acquire();
       // System.out.println(Thread.currentThread().getName() + "--QUIERE COMER--");
    }

    public void usar() throws InterruptedException{
        semDisponible.acquire();
    }

    public void liberar(){
        semDisponible.release();
    }

    public void notificaCocinero(){
        semCocinero.release();
        System.out.println(Thread.currentThread().getName() + "--AVISO AL COCINERO--");
    }

    public void siguienteCanibal(){
        semCanibal.release();
    }

    public void sacarComida(){
        if(comida>0){
            comida--;
            System.out.println(Thread.currentThread().getName() + "--COMIO--");
            semCanibal.release();
        }else{
            notificaCocinero();
        }
    }

    public void cocinar() throws InterruptedException{
        semCocinero.acquire();
        System.out.println("--COCINANDO--");
    }

    public void ponerComida(){
        comida = 5;
    }

}
