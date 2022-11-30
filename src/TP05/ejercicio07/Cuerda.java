package TP05.ejercicio07;
import java.util.concurrent.Semaphore;

public class Cuerda {
    private int esperaDerecha = 0;
    private int esperaIzquierda = 0;
    private int cantCruzando = 0;
    private char ladoPrioridad = 'd';
    private Semaphore capacidad = new Semaphore(5);
    private Semaphore semEsperaDerecha = new Semaphore(1,true);
    private Semaphore semEsperaIzquierda = new Semaphore(1, true);
    private Semaphore mutexCruzando = new Semaphore(1, true);
    private Semaphore mutexPrioridad = new Semaphore(1, true);
    private Semaphore mutexEspera = new Semaphore(1, true);
    public Cuerda(){

    }

    public boolean cruzarDerecha() throws InterruptedException{
        boolean exito = false;
        mutexPrioridad.acquire();
        System.out.println(Thread.currentThread().getName() + " INTENTA CRUZAR DERECHA.");
        if(ladoPrioridad == 'd'){
            mutexPrioridad.release();
            if(cantCruzando < 5){
                capacidad.acquire();
                mutexCruzando.acquire();
                cantCruzando++;
                mutexCruzando.release();
                exito = true;
            }
        }else{
            mutexPrioridad.release();
        }
        return exito;
    }

    public boolean cruzarIzquierda() throws InterruptedException{
        boolean exito = false;
        mutexPrioridad.acquire();
        System.out.println(Thread.currentThread().getName() + " INTENTA CRUZAR IZQUIERDA.");
        if(ladoPrioridad == 'i'){
            mutexPrioridad.release();
            if(cantCruzando < 5){
                capacidad.acquire();
                mutexCruzando.acquire();
                cantCruzando++;
                mutexCruzando.release();
                exito = true;
            }
        }else{
            mutexPrioridad.release();
        }
        return exito;
    }

    public void salirDerecha() throws InterruptedException{
        capacidad.release();
        mutexCruzando.acquire();
        cantCruzando--;
        System.out.println(Thread.currentThread().getName() + " TERMINO DE CRUZAR DERECHA.");
        //hacer un if grande para si soy el ultimo
        //if(ultimo)
        //pregunto si hay esperando del otro lado
        //pregunto x los de mi lado
        //si no hay nadie cambio la prioridad a una tercer letra
        
        if(cantCruzando == 0 && esperaIzquierda > 0){
            mutexCruzando.release();
            mutexPrioridad.acquire();
            System.out.println("SE CAMBIO LA PRIORIDAD >>IZQUIERDA<<");
            ladoPrioridad = 'i';
            mutexPrioridad.release();
        }else{
            mutexCruzando.release();
            mutexEspera.acquire();
            if(esperaDerecha>0){
                System.out.println("SE LIBERA UNA ESPERA DE DERECHA");
                semEsperaDerecha.release();
                //esperaDerecha--;
            }
            mutexEspera.release();
        }
    }

    public void salirIzquierda() throws InterruptedException{
        capacidad.release();
        mutexCruzando.acquire();
        cantCruzando--;
        System.out.println(Thread.currentThread().getName() + " TERMINO DE CRUZAR IZQUIERDA.");
        mutexCruzando.release();
        if(cantCruzando == 0 && esperaDerecha > 0 && ladoPrioridad== 'i'){
            mutexPrioridad.acquire();
            System.out.println("SE CAMBIO LA PRIORIDAD >>DERECHA<<");
            ladoPrioridad = 'd';
            mutexPrioridad.release();
        }else{
            mutexEspera.acquire();
            if(esperaIzquierda>0 && ladoPrioridad == 'i'){
                System.out.println("SE LIBERA UNA ESPERA DE IZQUIERDA");
                semEsperaIzquierda.release();
                //esperaIzquierda--;
            }
            mutexEspera.release();
        }
    }

    public void esperaDerecha() throws InterruptedException{
        esperaDerecha++;
        semEsperaDerecha.acquire();
        esperaDerecha--;
    }

    public void esperaIzquierda() throws InterruptedException{
        semEsperaIzquierda.acquire();
        esperaIzquierda++;
    }
}
