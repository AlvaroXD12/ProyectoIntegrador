package pe.edu.upeu.modelo;

public class VentaTO {
    public String idVenta;
    public String dni;
    public String fecha;
    public double subtotal;
    public double descuento;
    public double totalimporte;

    public VentaTO(String idVenta, String dni, String fecha, double subtotal, double descuento, double totalimporte) {
        this.idVenta = idVenta;
        this.dni = dni;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.totalimporte = totalimporte;
    }
    public VentaTO() {
    }
    public String getIdVenta() {return idVenta;}
    public void setIdVenta(String idVenta) {this.idVenta = idVenta;}

    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}

    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}

    public double getSubtotal() {return subtotal;}
    public void setSubtotal(double subtotal) {this.subtotal = subtotal;}

    public double getDescuento() {return descuento;}
    public void setDescuento(double descuento) {this.descuento = descuento;}

    public double getTotalimporte() {return totalimporte;}
    public void setTotalimporte(double totalimporte) {this.totalimporte = totalimporte;}
    
}
