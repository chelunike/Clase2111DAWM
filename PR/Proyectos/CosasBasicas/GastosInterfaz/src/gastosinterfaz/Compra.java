package gastosinterfaz;
/**
 * @author yo
 */
public  class Compra implements IGastos{
    
    private String product;
    private int unid;
    private double precio;
    
    public Compra(String producto, int unidades, double precioUnid){
        this.product = producto;
        this.unid = unidades;
        this.precio = precioUnid;
    }    
    
    @Override
    public double pagar(){
        return unid*precio;
    }
    
    public String descripcion(){
        return product+ "\t"+ unid+ "\t"+ precio;
    }
    
    
}
