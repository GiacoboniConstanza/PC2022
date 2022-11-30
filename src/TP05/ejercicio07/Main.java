package TP05.ejercicio07;

public class Main {
    public static void main(String[] args) {
        Cuerda unaCuerda = new Cuerda();
        int cantBabuinos = 30;
        Babuino[] babuinos = new Babuino[cantBabuinos];
        Thread[] hilosBabuinos = new Thread[cantBabuinos];
        char direccion;
        for(int i = 0; i < cantBabuinos; i++){
            if(i%2==0){
                direccion = 'd';
            }else{
                direccion = 'i';
            }
            babuinos[i] = new Babuino(unaCuerda, direccion);
            hilosBabuinos[i] = new Thread(babuinos[i]);
            hilosBabuinos[i].start();
        }
    }
}
