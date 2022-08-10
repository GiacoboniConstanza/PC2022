/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP01.ejercicio02;

/**
 *
 * @author cotyg
 */
public class Velero extends Barco {

    private int nroMastil;

    public Velero(int nroMastil, String matricula, int eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.nroMastil = nroMastil;
    }

    public int getNroMastil() {
        return nroMastil;
    }

    public void setNroMastil(int nroMastil) {
        this.nroMastil = nroMastil;
    }

    public int calcularModulo() {
        return super.calcularModulo() + nroMastil;
    }
}
