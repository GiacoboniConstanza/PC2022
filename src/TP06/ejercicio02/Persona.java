package TP06.ejercicio02;

public class Persona implements Runnable{
    protected GestorSala sala;

    public Persona(GestorSala sala){
        this.sala = sala;
    }

    public void run(){
        try {
            sala.entrarSala();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " PERSONA esta mirando cuadros");
            sala.salirSala();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
