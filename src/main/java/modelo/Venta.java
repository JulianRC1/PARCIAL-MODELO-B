
package modelo;

/**
 *
 * MESSI
 */
public class Venta 
{
    private static int numeroAnho;
    private int anho;
    private double cantidadVentas;
    private double variacionVentas;
    private double diferenciaVentas;
    
    public Venta(int auxAnho, double auxCantidadVentas, double auxVariacionVentas, double auxDiferenciaVentas)
    {
        numeroAnho++;
        anho  = numeroAnho ;
        this.cantidadVentas = auxCantidadVentas;
        this.variacionVentas = auxVariacionVentas;
        this.diferenciaVentas = auxDiferenciaVentas;
    }
    
    public int getAnho()
    {
        return anho;
    }
    
    public void setAnho()
    {
        anho = numeroAnho;
    }
    
    public double getCantidadVentas()
    {
        return cantidadVentas;
    }
    
    public double getVariacionVentas()
    {
        return variacionVentas;
    }
    
    public double getDiferenciaVentas()
    {
        return diferenciaVentas;
    }
}
