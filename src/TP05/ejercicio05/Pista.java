package TP05.ejercicio05;
import java.util.concurrent.*;

public class Pista {
    private int aterrizajes = 0;
    private int maxAterrizajes = 10;
    private int despegues = 0;
    private int despegueEspera = 0;
    private int aterrizajeEspera = 0;
    private boolean puedeDespegar = true;
    private Semaphore semPista = new Semaphore(1);
    private Semaphore semAterrizar = new Semaphore(1, true);
    private Semaphore semDespegar =  new Semaphore(1, true);

    public boolean aterrizar(){
        boolean exito = false;
        if(aterrizajes < maxAterrizajes){
            puedeDespegar = false;
            aterrizajes++;
            System.out.println(">> ATERRIZAJES: " + aterrizajes);
            System.out.println("");
            exito = true;
            System.out.println(Thread.currentThread().getName() + " PUDO ATERRIZAR");
            if(aterrizajeEspera>0){
                System.out.println("libero una espera en aterrizaje");
                semAterrizar.release();
                aterrizajeEspera--;
            }else if(despegueEspera>0){
                puedeDespegar = true;
            }
        }else{
            aterrizajeEspera++;
            System.out.println(">> ATERRIZAJES EN ESPERA: " + aterrizajeEspera);
            System.out.println("");
            puedeDespegar = true;
        }
        return exito;
    }

    public boolean despegar(){
        boolean exito = false;
        //falta condicion para ver si ya no hay mas aterrizajes, asi puede despegar igual
        if(puedeDespegar){
            exito = true;
            aterrizajes = 0;
            despegues++;
            System.out.println(">> DESPEGUES: " + despegues);
            System.out.println("");
            System.out.println(Thread.currentThread().getName() + " PUDO DESPEGAR");
            if(aterrizajeEspera > 0){
                puedeDespegar = false;
            }else if(despegueEspera>0){
                System.out.println("libero una espera de despegue");
                semDespegar.release();
                despegueEspera--;
            }
        }else{
            despegueEspera++;
            System.out.println(">> DESPEGUES EN ESPERA: " + despegueEspera);
            System.out.println("");
            System.out.println(Thread.currentThread().getName() + " QUISO DESPEGAR PERO ESPERA");
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
