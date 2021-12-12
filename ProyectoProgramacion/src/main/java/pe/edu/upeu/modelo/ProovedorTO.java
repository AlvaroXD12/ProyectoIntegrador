package pe.edu.upeu.modelo;

public class ProovedorTO {
    public String idProved;
    public String nombre;
    public String celular;
    public String direccion;

    public ProovedorTO() {
    }

    public ProovedorTO(String idProved, String nombre, String celular, String direccion) {
        this.idProved = idProved;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
    }
    public String getIdProved() {return idProved;}
    public void setIdProved(String idProved) {this.idProved = idProved;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCelular() {return celular;}
    public void setCelular(String celular) {this.celular = celular;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    
    
}
