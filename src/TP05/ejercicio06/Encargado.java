package TP05.ejercicio06;

public class Encargado implements Runnable {
    private Mirador unMirador;

    public Encargado(Mirador mirador){
        this.unMirador = mirador;
    }

    public void run(){
        while(true){
            try {
                unMirador.cambiarTobogan();
                System.out.println(">> SE CAMBIO TOBOGAN");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
