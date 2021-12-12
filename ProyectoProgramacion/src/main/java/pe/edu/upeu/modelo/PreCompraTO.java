package pe.edu.upeu.modelo;

public class PreCompraTO {
   public String  idPreCompra;
   public String idProv;
   public String fecha;
   public String idProd;
   public int cantidad;
   public double precio;
   public int cantDevol;
   public double totalPago;
   public int estado;

   

   public PreCompraTO(String idPreCompra, String idProv, String fecha, String idProd, int cantidad, double precio,
         int cantDevol, double totalPago, int estado) {
      this.idPreCompra = idPreCompra;
      this.idProv = idProv;
      this.fecha = fecha;
      this.idProd = idProd;
      this.cantidad = cantidad;
      this.precio = precio;
      this.cantDevol = cantDevol;
      this.totalPago = totalPago;
      this.estado = estado;
   }
   
   public String getIdPreCompra() {return idPreCompra;}
   public void setIdPreCompra(String idPreCompra) {this.idPreCompra = idPreCompra;}

   public String getIdProv() {return idProv;}
   public void setIdProv(String idProv) {this.idProv = idProv;}

   public String getFecha() {return fecha;}
   public void setFecha(String fecha) {this.fecha = fecha;}

   public String getIdProd() {return idProd;}
   public void setIdProd(String idProd) {this.idProd = idProd;}

   public int getCantidad() {return cantidad;}
   public void setCantidad(int cantidad) {this.cantidad = cantidad;}

   public double getPrecio() {return precio;}
   public void setPrecio(double precio) {this.precio = precio;}
   
   public int getCantDevol() {return cantDevol;}
   public void setCantDevol(int cantDevol) {this.cantDevol = cantDevol;}

   public double getTotalPago() {return totalPago;}
   public void setTotalPago(double totalPago) {this.totalPago = totalPago;}

   public int getEstado() {return estado;}
   public void setEstado(int estado) {this.estado = estado;}
   
}
