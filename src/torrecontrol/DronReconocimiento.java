/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torrecontrol;

/**
 *
 * @author Eriz  Flores 
 */


import java.util.Random;

public class DronReconocimiento extends DronBase {
    int[] lecturasTermicas;

    public DronReconocimiento(String codigoSerie, double nivelEnergia, boolean enLinea) {
        super(codigoSerie, nivelEnergia, enLinea);
        this.lecturasTermicas = new int[7];
    }

    public void generarMapeoEstocastico() {
        Random random = new Random();
        System.out.println("Dron Táctico " + codigoSerie + ": Ejecutando mapeo estocástico en los 7 cuadrantes...");
        for (int i = 0; i < lecturasTermicas.length; i++) {
            lecturasTermicas[i] = random.nextInt(51);
        }
    }

    private void emitirAlertaIncendio() {
        System.out.println("¡ALERTA ROJA! Posible incendio en el sector monitoreado por el dron " + codigoSerie);
    }

    public void analizarAmenazas() {
        boolean peligroDetectado = false;
        System.out.println("Dron Táctico " + codigoSerie + ": Analizando lecturas térmicas...");
        for (int i = 0; i < lecturasTermicas.length; i++) {
            System.out.println(" - Cuadrante " + (i + 1) + " -> Lectura: " + lecturasTermicas[i]);
            if (lecturasTermicas[i] > 35) {
                peligroDetectado = true;
            }
        }
        
        if (peligroDetectado) {
            emitirAlertaIncendio();
        } else {
            System.out.println("Dron Táctico " + codigoSerie + ": Sin amenazas críticas en los cuadrantes.");
        }
    }
}// fin de class
