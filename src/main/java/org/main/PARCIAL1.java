package org.main;

import controlador.ControladorVentas;
import modelo.ArrayVentas;
import vista.VentanaVentas;

/**
 *
 * Julian David Rendon Cardona - 2177387 - julian.david.rendon@correounivalle.edu.co
 */
public class PARCIAL1 {

    public static void main(String[] args) 
    {
        VentanaVentas ventanaVentas = new VentanaVentas();
        ArrayVentas arrayVentas = new ArrayVentas();
        ControladorVentas controlador = new ControladorVentas(ventanaVentas, arrayVentas);
        ventanaVentas.setVisible(true);
    }
}
