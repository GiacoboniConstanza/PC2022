package TP06.ejercicio06;
import java.util.concurrent.locks.*;;

public class Sala {
    private int cantCamillas = 4;
    private int camillasOcupadas = 0;
    private int cantRevistas = 9;
    private int revistasOcupadas = 0;
    private Lock lock = new ReentrantLock();
    private Condition esperaRevista = lock.newCondition();

    public void sacarSangre() throws InterruptedException{
        if(camillasOcupadas<cantCamillas){
            camillasOcupadas++;
        }else{
            if(revistasOcupadas<cantRevistas){
                revistasOcupadas++;
            }else{
                esperaRevista.await();
            }
        }
    }
}
