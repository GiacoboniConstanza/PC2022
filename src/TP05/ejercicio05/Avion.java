package TP05.ejercicio05;

public class Avion implements Runnable{
    private Pista unaPista;
    private char tipo;
    private boolean pudo = false;

    public Avion(Pista pista, char tipo){
        this.unaPista = pista;
        this.tipo = tipo;
    }

    public void run(){
        while(!pudo){
            try {
                unaPista.usar();
                System.out.println(Thread.currentThread().getName() + " VA A USAR LA PISTA");
                if(tipo=='a'){
                    if(unaPista.aterrizar()){
                        pudo = true;
                        unaPista.liberar();
                    }else{
                        unaPista.liberar();
                        unaPista.esperaAterrizaje();
                    }
                }else{
                    if(unaPista.despegar()){
                        pudo = true;
                        unaPista.liberar();
                    }else{
                        unaPista.liberar();
                        unaPista.esperarDespegue();
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
