package TP05.ejercicio03;

public class Pasajero implements Runnable{
    private Tren unTren;
    private Boleteria unBoleteria;
    private boolean tieneBoleto = false;

    public Pasajero(Tren tren, Boleteria boleteria){
        this.unTren = tren;
        this.unBoleteria = boleteria;
    }

    public void run(){
        try {
            while(!tieneBoleto){
                unBoleteria.sacar();
                unBoleteria.usar();
                unBoleteria.comprarBoleto();
                System.out.println(Thread.currentThread().getName() + " COMPRO BOLETO");
                tieneBoleto = true;
                unBoleteria.liberar();
                unBoleteria.notificaVendedor();
            }
            if(tieneBoleto){
                unTren.subir();
                System.out.println(Thread.currentThread().getName() + " ha subido");
                unTren.puedeSubirSiguiente();
                unTren.bajar();
                System.out.println(Thread.currentThread().getName() + " ha bajado");
                unTren.puedeBajarSiguiente();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
