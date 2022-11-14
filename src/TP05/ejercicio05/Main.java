package TP05.ejercicio05;

public class Main {
    public static void main(String[] args) {
        Pista unaPista = new Pista();
        Avion[] aviones = new Avion[20];
        Thread[] hilosAviones = new Thread[20];

        for (int i = 0; i < hilosAviones.length; i++) {
            if(i%3==0){
                aviones[i] = new Avion(unaPista, 'd');
            }else{
                aviones[i] = new Avion(unaPista, 'a');
            }
            hilosAviones[i] = new Thread(aviones[i]);
            hilosAviones[i].start();
        }
    }
}
