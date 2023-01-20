package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.VentanaVentas;

/**
 *
 * MESSI
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
