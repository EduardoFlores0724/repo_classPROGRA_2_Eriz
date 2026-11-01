/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torrecontrol;

/**
 *
 * @author Eriz  Flores 
 */


public class DronBase {
    String codigoSerie;
    double nivelEnergia;
    boolean enLinea;

    public DronBase(String codigoSerie, double nivelEnergia, boolean enLinea) {
        this.codigoSerie = codigoSerie;
        setNivelEnergia(nivelEnergia);
        this.enLinea = enLinea;
    }

    private void calibrarGiroscopioInterno() {
        System.out.println("Dron " + codigoSerie + ": Calibrando giroscopio interno y sensores de estabilidad de forma autónoma.");
    }

    public String getCodigoSerie() {
        return codigoSerie;
    }

    public void setCodigoSerie(String codigoSerie) {
        this.codigoSerie = codigoSerie;
    }

    public double getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(double nivelEnergia) {
        if (nivelEnergia < 0.0) {
            this.nivelEnergia = 0.0;
        } else if (nivelEnergia > 100.0) {
            this.nivelEnergia = 100.0;
        } else {
            this.nivelEnergia = nivelEnergia;
        }
        calibrarGiroscopioInterno();
    }

    public boolean isEnLinea() {
        return enLinea;
    }

    public void setEnLinea(boolean enLinea) {
        this.enLinea = enLinea;
    }

    public void transmitirEstadoRed() {
        System.out.println("--- Transmisión de Telemetría ---");
        System.out.println("Código de Serie: " + codigoSerie);
        System.out.println("Nivel de Energía: " + nivelEnergia + "%");
        System.out.println("En línea (Lista para órdenes): " + (enLinea ? "Sí" : "No"));
        System.out.println("Balizas virtuales: Destellando correctamente.");
    }
}//fin de class
