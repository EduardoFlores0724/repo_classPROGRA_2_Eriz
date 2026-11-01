/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package torrecontrol;

/**
 *
 * @author Eriz  Flores 
 */
public class TorreControl {

    public static void main(String[] args) {
        System.out.println("=== OPERACIÓN 'CIELOS LIMPIOS' - TORRE DE CONTROL ===");
        
        DronReconocimiento[] escuadronTactico = new DronReconocimiento[3];
        DronCargaAmbiental[] escuadronPesado = new DronCargaAmbiental[2];
        
        escuadronTactico[0] = new DronReconocimiento("DT-01", 90.0, true);
        escuadronTactico[1] = new DronReconocimiento("DT-02", 85.0, true);
        escuadronTactico[2] = new DronReconocimiento("DT-03", 95.0, true);
        
        escuadronPesado[0] = new DronCargaAmbiental("DC-01", 88.0, true, 45.0);
        escuadronPesado[1] = new DronCargaAmbiental("DC-02", 92.0, true, 35.0);
        
        System.out.println("\n--- SUPERVISIÓN DEL ESCUADRÓN TÁCTICO ---");
        for (int i = 0; i < escuadronTactico.length; i++) {
            System.out.println("\n[Unidad: " + escuadronTactico[i].getCodigoSerie() + "]");
            escuadronTactico[i].generarMapeoEstocastico();
            escuadronTactico[i].analizarAmenazas();
        }
        
        System.out.println("\n--- SUPERVISIÓN DEL ESCUADRÓN PESADO ---");
        for (int i = 0; i < escuadronPesado.length; i++) {
            System.out.println("\n[Unidad: " + escuadronPesado[i].getCodigoSerie() + "]");
            double pesoSimulado = (i == 0) ? 20.0 : 40.0;
            escuadronPesado[i].engancharDesecho(pesoSimulado);
            escuadronPesado[i].descargarContenedorBase();
        }
        
        System.out.println("\n--- APLICANDO DESGASTE POST-MISIÓN Y PRUEBA DE SETTERS ---");
        escuadronTactico[0].setNivelEnergia(50.0);
        escuadronTactico[1].setNivelEnergia(-10.0);
        escuadronTactico[2].setNivelEnergia(150.0);
        
        escuadronPesado[0].setNivelEnergia(75.0);
        escuadronPesado[1].setNivelEnergia(60.0);
        
        System.out.println("\n--- TELEMETRÍA FINAL DE TODAS LAS UNIDADES ---");
        
        System.out.println("\nEscuadrón Táctico:");
        for (int i = 0; i < escuadronTactico.length; i++) {
            System.out.println("");
            escuadronTactico[i].transmitirEstadoRed();
        }
        
        System.out.println("\nEscuadrón Pesado:");
        for (int i = 0; i < escuadronPesado.length; i++) {
            System.out.println("");
            escuadronPesado[i].transmitirEstadoRed();
        }
        
        System.out.println("\nSimulación finalizada con éxito.");
    }
}//fin de class