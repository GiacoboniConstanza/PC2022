package TP05.ejercicio06;

public class Main {
    public static void main(String[] args) {
        Mirador unMirador = new Mirador();
        Encargado uEncargado = new Encargado(unMirador);
        int cantVisitantes = 20;
        Visitante[] visitantes = new Visitante[cantVisitantes];
        Thread[] hilosVisitantes = new Thread[cantVisitantes];
        Thread hiloEncargado = new Thread(uEncargado);
        hiloEncargado.start();

        for(int i = 0; i < cantVisitantes; i++){
            visitantes[i] = new Visitante(unMirador);
            hilosVisitantes[i] = new Thread(visitantes[i]);
            hilosVisitantes[i].start();
        }

    }
}
