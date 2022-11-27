package TP05.ejercicio06;
import java.util.concurrent.Semaphore;

public class Mirador {
    private int escalones = 10;
    private int opcion = 1;
    private Semaphore escalera = new Semaphore(escalones, true);
    private Semaphore tobogan1 = new Semaphore(1, true);
    private Semaphore tobogan2 = new Semaphore(1, true);
    private Semaphore mutexHabilitado = new Semaphore(1);

    public void subirEscalera() throws InterruptedException{
        escalera.acquire();
    }

    public void subirTobogan() throws InterruptedException{
        mutexHabilitado.acquire();
        if(opcion == 1){
            mutexHabilitado.release();
            tobogan1.acquire();
        }else{
            mutexHabilitado.release();
            tobogan2.acquire();
        }
        escalera.release();
    }

    public void salirTobogan() throws InterruptedException{
        mutexHabilitado.acquire();
        if(opcion == 1){
            mutexHabilitado.release();
            tobogan1.release();
        }else{
            mutexHabilitado.release();
            tobogan2.release();
        }
    }

    public void cambiarTobogan() throws InterruptedException{
        tobogan1.acquire();
        tobogan2.acquire();
        mutexHabilitado.acquire();
        if(opcion == 1){
            opcion = 2;
        }else{
            opcion = 1;
        }
        mutexHabilitado.release();
        tobogan2.release();
        tobogan1.release();
    }
}
