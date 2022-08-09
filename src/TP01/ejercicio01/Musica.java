/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP01.ejercicio01;

/**
 *
 * @author cotyg
 */
public class Musica {

    //No importa el tipo de instrumento
    //seguira funcionando debido al polimorfismo:
    static void afinar(Instrumento i) {
        i.tocar();
    }

    static void afinarTodo(Instrumento[] e) {
        for (int i = 0; i < e.length; i++) {
            afinar(e[i]);
        }
    }

    public static void main(String[] args) {
        Instrumento[] orquesta = new Instrumento[5];
        int i = 0;

        //Up-casting al asignarse el arreglo
        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Piano();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Guzla();
        orquesta[i++] = new Ukelele();
        afinarTodo(orquesta);
    }
}
