package modelo;

import modelo.Venta;
import java.util.ArrayList;

/**
 *
 * MESSI
 */
public class ArrayVentas
{
    private final ArrayList<Venta> ventas;
    
    public ArrayVentas()
    {
        ventas = new ArrayList<Venta>();
    }
    
    public Venta getVenta(int auxAnho)
    {
        Venta auxVenta = null;
        
        for(Venta venta: ventas)
        {
            auxVenta = venta;
            break;
        }
        return auxVenta;
    }
    
    public boolean agregarVenta(Venta auxVenta)
    {
        ventas.add(auxVenta);
        return true;
    }
    
    public boolean eliminarVenta(Venta auxVenta)
    {
        ventas.remove(auxVenta);
        return true;
    }
    
    public boolean editarVenta(Venta auxVenta)
    {
        if(ventas.contains(auxVenta))
        {
            int pos = ventas.indexOf(auxVenta);
            ventas.set(pos, auxVenta);
            return true;
        }
        return false;
    }
    
    public boolean eliminarAllVentas(Venta auxVenta)
    {
        ventas.clear();
        return true;
    }
    
    public ArrayList<Venta> getVentas()
    {
        return ventas;
    }
}
