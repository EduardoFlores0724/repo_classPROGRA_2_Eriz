/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torrecontrol;

/**
 *
 * @author Eriz  Flores 
 */

public class DronCargaAmbiental extends DronBase {
    double cargaMaximaPermitida;
    double cargaActual;

    public DronCargaAmbiental(String codigoSerie, double nivelEnergia, boolean enLinea, double cargaMaximaPermitida) {
        super(codigoSerie, nivelEnergia, enLinea);
        this.cargaMaximaPermitida = cargaMaximaPermitida;
        this.cargaActual = 0.0;
    }

    public boolean evaluarPesoObjeto(double pesoNuevo) {
        if ((cargaActual + pesoNuevo) > cargaMaximaPermitida) {
            return true;
        }
        return false;
    }

    public void engancharDesecho(double pesoNuevo) {
        System.out.println("Dron de Carga " + codigoSerie + ": Evaluando objeto de " + pesoNuevo + " kg...");
        if (evaluarPesoObjeto(pesoNuevo)) {
            System.out.println("Maniobra abortada: El objeto es demasiado pesado para la capacidad máxima del dron.");
        } else {
            cargaActual += pesoNuevo;
            System.out.println("¡Éxito! Objeto enganchado. Carga actual: " + cargaActual + " kg.");
        }
    }

    public void descargarContenedorBase() {
        System.out.println("Dron de Carga " + codigoSerie + ": Abriendo compuerta en base para vaciar desechos...");
        cargaActual = 0.0;
        System.out.println("Contenedor descargado de manera segura. Carga actual reiniciada a: " + cargaActual + " kg.");
    }
}//fin de class
