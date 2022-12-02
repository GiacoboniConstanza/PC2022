package TP05.ejercicio07;
import java.util.concurrent.Semaphore;

public class Cuerda {
    /* Char de prioridad
    * n --> ninguno
    * d --> derecha
    * i --> izquierda
    */
    private char ladoPrioridad = 'n';
    private int cantMaxima = 5;
    private int cruzando = 0;
    private int esperaDerecha = 0;
    private int esperaIzquierda = 0;
    private Semaphore semDerecha = new Semaphore(1, true);
    private Semaphore semIzquierda = new Semaphore(1, true);
    private Semaphore mutexCuerda = new Semaphore(1, true);

    public boolean subirDerecha() throws InterruptedException{
        boolean exito = false;
        mutexCuerda.acquire();
        if(ladoPrioridad == 'n'){
            ladoPrioridad = 'd';
            cruzando++;
            exito = true;
            System.out.println(">> Primer babuino derecha cruzando.("+Thread.currentThread().getName()+")");
            mutexCuerda.release();
        }else if(ladoPrioridad == 'd' && cruzando <= cantMaxima){
            cruzando++;
            exito = true;
            System.out.println(">> Babuino derecha cruzando. ("+Thread.currentThread().getName()+")");
            mutexCuerda.release();
        }else{
            esperaDerecha++;
            mutexCuerda.release();
        }
        return exito;
    }

    public void esperaDerecha() throws InterruptedException{
        mutexCuerda.acquire();
        esperaDerecha++;
        System.out.println(">> Babuino derecha esperando.("+Thread.currentThread().getName()+")");
        mutexCuerda.release();

        semDerecha.acquire();

        mutexCuerda.acquire();
        esperaDerecha--;
        System.out.println(">> Babuino derecha liberado("+Thread.currentThread().getName()+")");
        mutexCuerda.release();
    }

    public void bajarDerecha() throws InterruptedException{
        mutexCuerda.acquire();
        cruzando--;
        if(cruzando == 0){ 
            if(esperaIzquierda > 0){
                ladoPrioridad = 'i';
                System.out.println("Ultimo babuino derecha cambia prioridad para IZQUIERDA("+Thread.currentThread().getName()+")");
                semIzquierda.release();
            }else if(esperaDerecha > 0){
                System.out.println("Ultimo babuino derecha libera espera("+Thread.currentThread().getName()+")");
                semDerecha.release();
            }else if(esperaDerecha == 0 && esperaIzquierda == 0){
                System.out.println("Ultimo babuino derecha cambia prioridad para NADIE("+Thread.currentThread().getName()+")");
                ladoPrioridad = 'n';
            }
        }
        mutexCuerda.release();
    }

    public boolean subirIzquierda() throws InterruptedException{
        boolean exito = false;
        mutexCuerda.acquire();
        if(ladoPrioridad == 'n'){
            ladoPrioridad = 'i';
            cruzando++;
            System.out.println(">> Primer babuino izquierda cruzando.("+Thread.currentThread().getName()+")");
            exito = true;
            mutexCuerda.release();
        }else if(ladoPrioridad == 'i' && cruzando <= cantMaxima){
            cruzando++;
            exito = true;
            System.out.println(">> Babuino izquierda cruzando.("+Thread.currentThread().getName()+")");
            mutexCuerda.release();
        }else{
            esperaIzquierda++;
            mutexCuerda.release();
        }
        return exito;
    }

    public void esperaIzquierda() throws InterruptedException{
        mutexCuerda.acquire();
        esperaIzquierda++;
        System.out.println(">> Babuino izquierda esperando.("+Thread.currentThread().getName()+")");
        mutexCuerda.release();

        semIzquierda.acquire();
        
        mutexCuerda.acquire();
        esperaIzquierda--;
        System.out.println(">> Babuino izquierda liberado("+Thread.currentThread().getName()+")");
        mutexCuerda.release();
    }

    public void bajarIzquierda() throws InterruptedException{
        mutexCuerda.acquire();
        cruzando--;
        if(cruzando == 0){
            if(esperaDerecha > 0){
                ladoPrioridad = 'd';
                System.out.println("Ultimo babuino izquierda cambia prioridad para DERECHA("+Thread.currentThread().getName()+")");
                semDerecha.release();
            }else if(esperaIzquierda > 0){
                System.out.println("Ultimo babuino izquierda libera espera("+Thread.currentThread().getName()+")");
                semIzquierda.release();
            }else if(esperaDerecha == 0 && esperaIzquierda == 0){
                System.out.println("Ultimo babuino izquierda cambia prioridad para NADIE("+Thread.currentThread().getName()+")");
                ladoPrioridad = 'n';
            }
        }
        mutexCuerda.release();
    }
}
