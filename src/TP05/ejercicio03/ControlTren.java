package TP05.ejercicio03;

public class ControlTren implements Runnable{
    private Tren unTren;

    public ControlTren(Tren tren){
        this.unTren = tren;
    }

    public void run(){
        while(true){
            try {
                unTren.liberarEntrada();
                System.out.println("--PUEDEN SUBIR LOS PASAJEROS--");
                System.out.println("");
                unTren.comenzarViaje();
                System.out.println("--EL TREN COMENZO A VIAJAR--");
                Thread.sleep(2000);
                unTren.llegoDestino();
                unTren.bajarPasajeros();
                unTren.comenzarViaje();
                System.out.println("--EL TREN ESTA VOLVIENDO--");
                System.out.println("");
                Thread.sleep(2000);
                unTren.regresoOrigen();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
