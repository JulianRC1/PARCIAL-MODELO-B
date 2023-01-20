package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.VentanaVentas;

/**
 *
 * Julian David Rendon Cardona - 2177387 - julian.david.rendon@correounivalle.edu.co
 */
public class ControladorVentas 
{
    private final VentanaVentas ventanaVentas;
    private final ArrayVentas arrayVentas;
    
    public ControladorVentas(VentanaVentas auxVentanaVentas, ArrayVentas auxArrayVentas)
    {
        this.ventanaVentas = auxVentanaVentas;
        this.arrayVentas = auxArrayVentas;
        
        VentaListener ventasListener = new VentaListener();
        this.ventanaVentas.addBtnAgregarAnhoListener(ventasListener);
    }
    
    public void listarVentasAgregar(Venta auxVenta)
    {
        int auxAnho = auxVenta.getAnho();
        double auxCantidadVentas = auxVenta.getCantidadVentas();
        double auxDiferenciaVentas = auxVenta.getDiferenciaVentas();
        double auxVariacionVentas = auxVenta.getVariacionVentas();
        
        DefaultTableModel tabla = (DefaultTableModel) ventanaVentas.getModelTablaHistorial();
        tabla.addRow(new Object[]{auxAnho, auxCantidadVentas, auxDiferenciaVentas, auxVariacionVentas}); 
    }
    
    private void listarVentasEditar(Venta auxVenta)
    {
        int auxAnho = auxVenta.getAnho();
        double auxCantidadVentas = auxVenta.getCantidadVentas();
        double auxDiferenciaVentas = auxVenta.getDiferenciaVentas();
        double auxVariacionVentas = auxVenta.getVariacionVentas();

        DefaultTableModel tabla = (DefaultTableModel) ventanaVentas.getModelTablaHistorial();
        int auxFila = ventanaVentas.getFilaSeleccionadaTablaHistorial();

        tabla.setValueAt(auxAnho, auxFila, 0);
        tabla.setValueAt(auxCantidadVentas, auxFila, 1);
        tabla.setValueAt(auxDiferenciaVentas, auxFila, 2);
        tabla.setValueAt(auxVariacionVentas, auxFila, 3);
    }

    private void listarVentasEliminar()
    {
        DefaultTableModel tabla = (DefaultTableModel) ventanaVentas.getModelTablaHistorial();
        int auxFila = ventanaVentas.getFilaSeleccionadaTablaHistorial();
        tabla.removeRow(auxFila);
    }
    
    public void agregarVenta()
    {
        Venta auxVenta;
        int auxAnho;
        double auxCantidadVentas;
        double auxDiferenciaVentas;
        double auxVariacionVentas;
        
        auxCantidadVentas = Double.parseDouble(ventanaVentas.getTxtCantidadVentas());
        
        if(auxCantidadVentas > 0)
        {
            auxAnho = arrayVentas.getVentas().size() + 1;
            
            if(auxAnho == 1)
            {
                auxVenta = new Venta(auxAnho, auxCantidadVentas, auxDiferenciaVentas=0, auxVariacionVentas=0);
                listarVentasAgregar(auxVenta);
                arrayVentas.agregarVenta(auxVenta);
                ventanaVentas.vaciarTxtVentas();
            }
            if(auxAnho > 1)
            {
                System.out.println(auxAnho);
                auxDiferenciaVentas = auxCantidadVentas - arrayVentas.getVenta(auxAnho-1).getCantidadVentas();
                auxVariacionVentas = auxDiferenciaVentas/arrayVentas.getVenta(auxAnho-1).getCantidadVentas();
                auxVenta = new Venta(auxAnho, auxCantidadVentas, auxDiferenciaVentas, auxVariacionVentas);
                listarVentasAgregar(auxVenta);
                arrayVentas.agregarVenta(auxVenta);
                ventanaVentas.vaciarTxtVentas();
            }
        }
    }
    
    class VentaListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("Agregar Año"))
            {
                agregarVenta();
            }
        }
        
    }
}
