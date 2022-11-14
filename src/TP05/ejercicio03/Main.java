package TP05.ejercicio03;

public class Main {
    public static void main(String[] args) {
        int cantPasajeros = 15;
        Tren unTren = new Tren();
        Boleteria unaBoleteria = new Boleteria();
        ControlTren unChofer = new ControlTren(unTren);
        Pasajero pasajeros[] = new Pasajero[cantPasajeros];
        Thread hilosPasajeros[] = new Thread[cantPasajeros];
        Thread hiloChofer = new Thread(unChofer);
        VendedorTickets unVendedor = new VendedorTickets(unaBoleteria);
        Thread hiloVendedor = new Thread(unVendedor);
        
        hiloVendedor.start();
        hiloChofer.start();

        for(int i = 0; i < cantPasajeros; i++){
            pasajeros[i]=new Pasajero(unTren, unaBoleteria);
            hilosPasajeros[i]=new Thread(pasajeros[i]);
            hilosPasajeros[i].start();
        }
    }
}
