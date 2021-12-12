package pe.edu.upeu.modelo;


public class DescuentosTO {

    public DescuentosTO(double montodeventa, double montodescuentos) {
        this.montodeventa = montodeventa;
        this.montodescuentos = montodescuentos;
    }

    public double montodeventa;
    public double montodescuentos;

    public double getMontodeventa() {return montodeventa;}
    public void setMontodeventa(double montodeventa) {this.montodeventa = montodeventa;}

    public double getMontodescuentos() {return montodescuentos;}
    public void setMontodescuentos(double montodescuentos) {this.montodescuentos = montodescuentos;}

}
    
