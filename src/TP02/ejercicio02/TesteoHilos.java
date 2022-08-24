/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio02;

/**
 *
 * @author cotyg
 */
public class TesteoHilos {

    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        System.out.println("En el main");
    }
}

/*
a) como es el comportamiento de las diferentes ejecuciones?
primero se ejecuta lo del main y luego lo del hilo miHilo

b) se podria forzar las ejecuciones para que se comporte de una manera determinada?
al cambiar de posicion el miHilo.start() no hay ningun cambio
se puede agregar un sleep en MiEjecucion para cambiarlo o implementar condicionales al start
*/
