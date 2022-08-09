/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP01.ejercicio02;

import assets.Fecha;

/**
 *
 * @author cotyg
 */
public class Alquiler {

    private Fecha fechaInicial;
    private Fecha fechaFinal;
    private int posAmarre;
    private Barco barco;

    public Alquiler(Fecha fechaInicial, Fecha fechaFinal, int posAmarre, Barco barco) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posAmarre = posAmarre;
        this.barco = barco;
    }

    public Fecha getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Fecha fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Fecha getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Fecha fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getPosAmarre() {
        return posAmarre;
    }

    public void setPosAmarre(int posAmarre) {
        this.posAmarre = posAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

}
