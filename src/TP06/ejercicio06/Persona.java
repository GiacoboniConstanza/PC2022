package TP06.ejercicio06;

public class Persona implements Runnable{
    private Sala sala;

    public Persona(Sala sala){
        this.sala = sala;
    }

    public void run(){
        while(true){
            try {
                sala.entrarSala();
                Thread.sleep(1000);
                sala.salirSala();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
