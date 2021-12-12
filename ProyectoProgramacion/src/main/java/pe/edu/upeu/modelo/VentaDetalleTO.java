package pe.edu.upeu.modelo;

public class VentaDetalleTO {
    public String idDetVenta;
    public String idVenta;
    public String idProd;
    public int cantidad;
    public double precioUnit;
    public double precioTotal;

    public VentaDetalleTO(String idDetVenta, String idVenta, String idProd, int cantidad, double precioUnit,
            double precioTotal) {
        this.idDetVenta = idDetVenta;
        this.idVenta = idVenta;
        this.idProd = idProd;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.precioTotal = precioTotal;
    }
    public String getIdDetVenta() {return idDetVenta;}
    public void setIdDetVenta(String idDetVenta) {this.idDetVenta = idDetVenta;}

    public String getIdVenta() {return idVenta;}
    public void setIdVenta(String idVenta) {this.idVenta = idVenta;}

    public String getIdProd() {return idProd;}
    public void setIdProd(String idProd) {this.idProd = idProd;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public double getPrecioUnit() {return precioUnit;}
    public void setPrecioUnit(double precioUnit) {this.precioUnit = precioUnit;}

    public double getPrecioTotal() {return precioTotal;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    

}
