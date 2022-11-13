package TP05.ejercicio03;

public class Main {
    public static void main(String[] args) {
        int cantPasajeros = 15;
        Tren unTren = new Tren();
        ControlTren unChofer = new ControlTren(unTren);
        Pasajero pasajeros[] = new Pasajero[cantPasajeros];
        Thread hilosPasajeros[] = new Thread[cantPasajeros];
        Thread hiloChofer = new Thread(unChofer);

        hiloChofer.start();

        for(int i = 0; i < cantPasajeros; i++){
            pasajeros[i]=new Pasajero(unTren);
            hilosPasajeros[i]=new Thread(pasajeros[i]);
            hilosPasajeros[i].start();
        }
    }
}
