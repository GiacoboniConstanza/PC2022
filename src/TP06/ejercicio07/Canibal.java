package TP06.ejercicio07;

public class Canibal implements Runnable{
    private Olla unaOlla;
    private boolean comio = false;

    public Canibal(Olla olla){
        this.unaOlla = olla;
    }

    public void run(){
        while(true){
            try {
                unaOlla.comer();
                unaOlla.usar();
                unaOlla.sacarComida();
                unaOlla.liberar();
                //unaOlla.notificaCocinero();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
