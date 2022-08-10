/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP01.ejercicio02;

/**
 *
 * @author cotyg
 */
public class Deportivo extends Barco {

    private int potencia;

    public Deportivo(int potencia, String matricula, int eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int calcularModulo() {
        return super.calcularModulo() + potencia;
    }

}
