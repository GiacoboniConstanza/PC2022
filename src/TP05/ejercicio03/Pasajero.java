package TP05.ejercicio03;

public class Pasajero implements Runnable{
    private Tren unTren;

    public Pasajero(Tren tren){
        this.unTren = tren;
    }

    public void run(){
        try {
            unTren.subir();
            System.out.println(Thread.currentThread().getName() + " ha subido");
            unTren.puedeSubirSiguiente();
            unTren.bajar();
            System.out.println(Thread.currentThread().getName() + " ha bajado");
            unTren.puedeBajarSiguiente();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
