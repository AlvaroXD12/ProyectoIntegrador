package pe.edu.upeu.modelo;

public class ProductoTO {
   public String idProd; 
   public String nombre; 
   public String tipo;
   public double precio;
   public double utilidad;
   public int stock;
   public String pesoKilos;

   

   public ProductoTO(String idProd, String nombre, String tipo, double precio, double utilidad, int stock,
         String pesoKilos) {
      this.idProd = idProd;
      this.nombre = nombre;
      this.tipo = tipo;
      this.precio = precio;
      this.utilidad = utilidad;
      this.stock = stock;
      this.pesoKilos = pesoKilos;
   }
   
   public ProductoTO() {
}

public String getIdProd() {return idProd;}
   public void setIdProd(String idProd) {this.idProd = idProd;}

   public String getNombre() {return nombre;}
   public void setNombre(String nombre) {this.nombre = nombre;}

   public String getTipo() {return tipo;}
   public void setTipo(String tipo) {this.tipo = tipo;}

   public double getPrecio() {return precio;}
   public void setPrecio(double precio) {this.precio = precio;}

   public double getUtilidad() {return utilidad;}
   public void setUtilidad(double utilidad) {this.utilidad = utilidad;}

   public int getStock() {return stock;}
   public void setStock(int stock) {this.stock = stock;}

   public String getPesoKilos() {return pesoKilos;}
   public void setPesoKilos(String pesoKilos) {this.pesoKilos = pesoKilos;}
   
}
