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
                if(tipo=='a'){
                    System.out.println(Thread.currentThread().getName() + " VA A USAR LA PISTA PARA ATERRIZAR");
                    if(unaPista.aterrizar()){
                        pudo = true;
                        unaPista.liberar();
                    }else{
                        unaPista.liberar();
                        unaPista.esperaAterrizaje();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " VA A USAR LA PISTA PARA DESPEGAR");
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
