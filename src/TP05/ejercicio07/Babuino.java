package TP05.ejercicio07;

public class Babuino implements Runnable{
    private Cuerda unaCuerda;
    private boolean cruzo = false;
    private char direccion;

    public Babuino(Cuerda cuerda, char direccion){
        this.unaCuerda = cuerda;
        this.direccion = direccion;
    }

    public void run(){
        while(!cruzo){
            try {
                if(direccion == 'd'){
                    if(unaCuerda.cruzarDerecha()) {
                        //System.out.println(Thread.currentThread().getName() + " LOGRO CRUZAR DERECHA.");
                        cruzo = true;
                        //Thread.sleep(1000);
                        unaCuerda.salirDerecha();
                    }else{
                        System.out.println(Thread.currentThread().getName() + " NO PUDO CRUZAR DERECHA.");
                        unaCuerda.esperaDerecha();
                    }
                }else{
                    if(unaCuerda.cruzarIzquierda()){
                        //System.out.println(Thread.currentThread().getName() + " LOGRO CRUZAR IZQUIERDA.");
                        cruzo = true;
                        //Thread.sleep(1000);
                        unaCuerda.salirIzquierda();
                    }else{
                        System.out.println(Thread.currentThread().getName() + " NO PUDO CRUZAR IZQUIERDA.");
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

