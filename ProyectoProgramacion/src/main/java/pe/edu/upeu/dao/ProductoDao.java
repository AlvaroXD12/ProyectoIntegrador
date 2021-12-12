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


    public Object[][] crearProducto() {

        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        prodTO = new ProductoTO();
        prodTO.setIdProd(generarId(leerArch,0,"p",1));
        prodTO.setNombre(leerTecla.leer("", "ingrese el nombre del producto"));
        prodTO.setPrecio(leerTecla.leer(0.0, "Ingrese el precio base del producto"));
        prodTO.setPesoKilos(leerTecla.leer("", "ingrese los kilos del saco"));
        prodTO.setTipo(leerTecla.leer("", "Ingrese el tipo de producto"));
        prodTO.setUtilidad(leerTecla.leer(0, "Ingrese la utilidad, ejemplo: 0.02"));
        prodTO.setStock(leerTecla.leer(0, "Ingrese el stock"));
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        return agregarContenido(leerArch,prodTO);
        
    }

    public void reportarProductos() {
        util.clearConsole();
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
       Object[][] data= listarContenido(leerArch);
       util.pintarLine('H', 32);
       util.pintarTextHeadBody('H', 3, "ID,Nombre,Precio,Stock,Kilos");
       System.out.println("");        
       util.pintarLine('H', 32);
       String dataPrint="";
       for (int i = 0; i < data.length; i++) {            
            dataPrint=data[i][0]+","+data[i][1]+","+data[i][3]+","+data[i][5]+","+data[i][6];
            util.pintarTextHeadBody('B', 3, dataPrint);   
       }
       util.pintarLine('H', 32);
       System.out.println();
    }


}