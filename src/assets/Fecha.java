/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

/**
 *
 * @author cotyg
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        setFecha(dia, mes, anio);
    }

    private void setFecha(int dia, int mes, int anio) {
        if (fechaCorrecta(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    private boolean fechaCorrecta(int dia, int mes, int anio) {
        boolean diaCorrecto, mesCorrecto, anioCorrecto;
        anioCorrecto = anio > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2 -> {
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
            }
            case 4, 6, 9, 11 ->
                diaCorrecto = dia >= 1 && dia <= 30;
            default ->
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && anioCorrecto;
    }

    private boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
    }

    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    public int restarDias(Fecha fechaFinal) {
        int dias = 0;
        if (this.anio == fechaFinal.getAnio()) {
            if (this.mes == fechaFinal.getMes()) {
                dias = fechaFinal.getDia() - this.dia;
            } else if (this.mes < fechaFinal.getMes()) {
                //terminar
                //
                //
            }
        }
        return dias;
    }
}
