package TP06.ejercicio07;

public class Cocinero implements Runnable{
    private Olla unaOlla;

    public Cocinero(Olla olla){
        this.unaOlla = olla;
    }

    public void run(){
        while(true){
            try {
                unaOlla.cocinar();
                unaOlla.usar();
                unaOlla.ponerComida();
                unaOlla.liberar();
                unaOlla.siguienteCanibal();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
