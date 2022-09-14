/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP03.ejercicio05;

/**
 *
 * @author cotyg
 */
public abstract class Vehiculo {
    protected String marca;
    protected String patente;
    protected String modelo;
    protected int km;
    protected int combustible;

    public Vehiculo(String marca, String patente, String modelo, int km, int combustible) {
        this.marca = marca;
        this.patente = patente;
        this.modelo = modelo;
        this.km = km;
        this.combustible = combustible;
    }

    public String getMarca() {
        return marca;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKm() {
        return km;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }
    
    
}
