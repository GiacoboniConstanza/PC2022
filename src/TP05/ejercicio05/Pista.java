package TP05.ejercicio05;
import java.util.concurrent.*;

public class Pista {
    private int aterrizajes = 0;
    private int maxAterrizajes = 10;
    private int despegueEspera = 0;
    private int aterrizajeEspera = 0;
    private boolean puedeDespegar = false;
    private Semaphore semPista = new Semaphore(1);
    private Semaphore semAterrizar = new Semaphore(1, true);
    private Semaphore semDespegar =  new Semaphore(1, true);

    public boolean aterrizar(){
        boolean exito = false;
        if(aterrizajes <= maxAterrizajes && despegueEspera > 0){
            aterrizajes++;
            System.out.println(">> ATERRIZAJES: " + aterrizajes);
            System.out.println("");
            exito = true;
            System.out.println(Thread.currentThread().getName() + " PUDO ATERRIZAR");
            if(aterrizajeEspera>0){
                semAterrizar.release();
                aterrizajeEspera--;
                System.out.println(Thread.currentThread().getName() + " QUIZO ATERRIZAR PERO ESPERA");
            }
        }else{
            aterrizajeEspera++;
            System.out.println(">> ATERRIZAJES EN ESPERA: " + aterrizajes);
            System.out.println("");
            puedeDespegar = true;
        }
        return exito;
    }

    public boolean despegar(){
        boolean exito = false;
        if(puedeDespegar){
            if(aterrizajeEspera > 0){
                despegueEspera++;
                System.out.println(">> DESPEGUES EN ESPERA: " + aterrizajes);
                System.out.println("");
                System.out.println(Thread.currentThread().getName() + " QUIZO DESPEGAR PERO ESPERA");
            }else{
                exito = true;
                System.out.println(">> DESPEGUES: " + aterrizajes);
                System.out.println("");
                System.out.println(Thread.currentThread().getName() + " PUDO DESPEGAR");
                if(despegueEspera>0){
                    semDespegar.release();
                    despegueEspera--;
                }
            }
        }else{
            despegueEspera++;
            System.out.println(">> DESPEGUES EN ESPERA: " + aterrizajes);
            System.out.println("");
            System.out.println(Thread.currentThread().getName() + " QUIZO DESPEGAR PERO ESPERA");
        }
        return exito;
    }

    public void usar() throws InterruptedException{
        semPista.acquire();
    }

    public void liberar(){
        semPista.release();
    }

    public void esperaAterrizaje() throws InterruptedException{
        semAterrizar.acquire();
    }

    public void esperarDespegue() throws InterruptedException{
        semDespegar.acquire();
    }
}
