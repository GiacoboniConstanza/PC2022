/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP02.ejercicio01;

/**
 *
 * @author cotyg
 */
public class testRecurso {

    public static void main(String[] args) {
        Cliente juan = new Cliente();
        juan.setName("Juan");
        Cliente ines = new Cliente();
        ines.setName("Ines");
        ines.start();
        juan.start();
        //Recurso.uso();
    }
}

/*
a) cuantos hilos de control participan en la ejecucion?
participan 3 hilos, el main, Cliente y Recurso t

b) cual es la funcionalidad del metodo "uso" de Recurso?
crea un nuevo hilo llamado t e imprime por consola

c)Indique la salida posible
opcion 1 (primera vez):
Soy Juan
en Recurso soy: Juan
Soy Ines
en Recurso soy: Ines

opcion 2 (segunda vez):
Soy Ines
Soy Juan
en Recurso soy: Ines
en Recurso soy: Juan

d) que sucede si agrega la linea Recurso.uso() al final del main?
se muestra por consola:
en Recurso soy: Main

e) que sucede si al cambiar el orden de las instrucciones start()?
en la primera ejecucion cambiara el orden en que se muestran los nombres en la consola,
es decir comenzara a ejecurtarse primero el otro hilo
*/
