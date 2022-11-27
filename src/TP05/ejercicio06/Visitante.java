package TP05.ejercicio06;

public class Visitante implements Runnable {
    private Mirador unMirador;

    public Visitante(Mirador mirador){
        this.unMirador = mirador;
    }

    public void run(){
        while(true){
            try {
                unMirador.subirEscalera();
                System.out.println(Thread.currentThread().getName() + " ESTA EN LA ESCALERA");
                Thread.sleep(2000);
                unMirador.subirTobogan();
                System.out.println(Thread.currentThread().getName() + " SUBIO AL TOBOGAN");
                Thread.sleep(1000);
                unMirador.salirTobogan();
                System.out.println(Thread.currentThread().getName() + " SALIO DEL TOBOGAN");
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
