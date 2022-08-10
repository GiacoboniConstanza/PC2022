/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP01.ejercicio02;

import java.util.*;
import assets.Fecha;

/**
 *
 * @author Coqui
 */
public class Puerto {

    private Set colAlquileres = new HashSet();
    private int valorFijo;

    public void registrarAlquiler(int nroAmarre, Barco barco, Fecha fechaInicio, Fecha fechaFin) {
        Alquiler unAlquiler = new Alquiler(fechaInicio, fechaFin, nroAmarre, barco);
        colAlquileres.add(unAlquiler);
    }

    public int calcularValor(Alquiler unAlquiler) {
        return unAlquiler.calcularValor(valorFijo);
    }
}
