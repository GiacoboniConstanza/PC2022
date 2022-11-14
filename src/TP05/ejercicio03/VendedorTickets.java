package TP05.ejercicio03;

public class VendedorTickets implements Runnable{
    private Boleteria unaBoleteria;

    public VendedorTickets(Boleteria boleteria){
        this.unaBoleteria = boleteria;
    }

    public void run(){
        while(true){
            try {
                unaBoleteria.agregar();
                unaBoleteria.usar();
                unaBoleteria.ponerBoleto();
                System.out.println("EL VENDEDOR TIENE BOLETO");
                unaBoleteria.liberar();
                unaBoleteria.notificaPasajero();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
