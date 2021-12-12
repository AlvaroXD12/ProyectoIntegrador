package pe.edu.upeu.dao;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;
    
public class ProductoDao extends AppCrud{
    
    LeerTeclado leerTecla=new LeerTeclado();
    UtilsX util=new UtilsX();
    final String TABLA_PRODUCTO="Producto.txt";

    LeerArchivo leerArch;
    ProductoTO prodTO;

    String tipoProd="ArrozFaraon\nCereales\n";

    public Object[][] crearProducto() {

        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        prodTO = new ProductoTO();
        prodTO.setIdProd(generarId(leerArch,0,"p",1));
        prodTO.setNombre(leerTecla.leer("", "ingrese el nombre del producto"));
        prodTO.setPrecio(leerTecla.leer(0, "Ingrese el precio base del roducto"));
        prodTO.setUnidadMed(leerTecla.leer("", "ingresa unidad de medida"));
        prodTO.setTipo(leerTecla.leer("", "Ingrese el tipo("+tipoProd+")"));
        prodTO.setUtilidad(leerTecla.leer(0, "Ingrese la utilidad, ejemplo: 0.02"));
        prodTO.setStock(leerTecla.leer(0, "Ingrese el stock"));
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        return agregarContenido(leerArch,prodTO);
        
      
     

        
    }
    
}