package TP06.ejercicio02;

public class Jubilado extends Persona{

    public Jubilado(GestorSala sala) {
        super(sala);
        //TODO Auto-generated constructor stub
    }
    
    public void run(){
        try {
            sala.entrarSalaJubilado();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " JUBILADO esta mirando cuadros");
            //System.out.println(Thread.currentThread().getName() + " jubilado esta mirando cuadros");
            sala.salirSala();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
