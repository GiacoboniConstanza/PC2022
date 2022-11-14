package TP06.ejercicio02;

public class ControlTemp implements Runnable{
    private GestorSala sala;

    public ControlTemp(GestorSala sala){
        this.sala = sala;
    }

    public void run(){
        int temp;
        while(true){
            temp = (int)(Math.random()*40+1);
            sala.notificarTemperatura(temp);
            System.out.println("La temperatura cambio a " + temp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
