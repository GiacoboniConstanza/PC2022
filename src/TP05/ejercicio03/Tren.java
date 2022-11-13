package TP05.ejercicio03;
import java.util.concurrent.*;

public class Tren {
    private int max_pasajeros = 5;
    private int pasajerosAbordo = 0;
    private Semaphore semSubir = new Semaphore(0);
    private Semaphore semBajar = new Semaphore(0);
    private Semaphore semViajar = new Semaphore(0);
    private Semaphore semPuerta = new Semaphore(1);

    public void liberarEntrada() throws InterruptedException{
        semPuerta.acquire();
        System.out.println(">> PUERTA ABIERTA");
        System.out.println("");
        semSubir.release();
    }

    public void comenzarViaje() throws InterruptedException{
        semViajar.acquire();
        System.out.println("✧･ﾟ: *✧･ﾟ:* 　　 *:･ﾟ✧*:･ﾟ✧");
        System.out.println("");
    }

    public void llegoDestino(){
        semPuerta.release();
        System.out.println(">> LLEGO A DESTINO");
        System.out.println("");
    }

    public void bajarPasajeros() throws InterruptedException{
        semPuerta.acquire();
        System.out.println(">> PUERTA ABIERTA");
        System.out.println("");
        semBajar.release();
    }

    public void regresoOrigen(){
        semPuerta.release();
        System.out.println(">> VOLVIO A ORIGEN");
        System.out.println("");
    }

    public void subir() throws InterruptedException{
        semSubir.acquire();
        pasajerosAbordo++;
    }

    public void puedeSubirSiguiente(){
        if(pasajerosAbordo == max_pasajeros){
            semViajar.release();
        }else{
            semSubir.release();
        }
    }

    public void bajar() throws InterruptedException{
        semBajar.acquire();
        pasajerosAbordo--;
    }

    public void puedeBajarSiguiente(){
        if(pasajerosAbordo == 0){
            semViajar.release();
        }else{
            semBajar.release();
        }
    }
}
