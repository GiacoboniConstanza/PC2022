package TP05.ejercicio07;

public class Babuino implements Runnable{
    private Cuerda unaCuerda;
    private char direccion;
    private boolean cruzo = false;

    public Babuino(Cuerda cuerda, char direccion){
        this.unaCuerda = cuerda;
        this.direccion = direccion;
    }

    public void run(){
        while(!cruzo){
            try {
                if(direccion == 'd'){
                    if(unaCuerda.subirDerecha()){
                        Thread.sleep(2000);
                        unaCuerda.bajarDerecha();
                        cruzo = true;
                    }else{
                        unaCuerda.esperaDerecha();
                    }
                }else{
                    if(unaCuerda.subirIzquierda()){
                        Thread.sleep(2000);
                        unaCuerda.bajarIzquierda();
                        cruzo = true;
                    }else{
                        unaCuerda.esperaIzquierda();
                    }
                } 
            }catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

