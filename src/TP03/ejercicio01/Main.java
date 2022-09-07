/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio01;

/**
 *
 * @author Xavi
 */
public class Main {

    public static void main(String[] args) {
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }

}

/*
a) ejecute el codigo y comente el resultado, que correccion deberia realizar para mejorar
la proteccion de los datos?

la cuenta bancaria esta siendo un recurso compartido que cambia, no es solo de lectura
por lo que se vuelve una seccion critica cada vez que se quiere realizar una extraccion
se deberia utilizar un synchronized en el metodo retiroBancario para asegurar que se realicen
las modificaciones de forma correcta.
*/