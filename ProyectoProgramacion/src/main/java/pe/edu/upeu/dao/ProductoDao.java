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

        System.out.println("------------Cree su Producto------------");
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
       System.out.println("-----------------------Lista de Productos------------------------");
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

    public void reportarProductos(Object[][] data) {

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

    public void updateProducto() {
        
        util.clearConsole();
        reportarProductos();
        System.out.println("-------------------Cambiar Datos del Producto--------------------");
        String dataId =leerTecla.leer("", "Ingrese el Id del producto");
        prodTO=new ProductoTO();
        prodTO.setNombre(leerTecla.leer("", "Ingrese el nuevo nombre"));
        prodTO.setPesoKilos(leerTecla.leer("", "Ingrese el nuevo peso"));
        prodTO.setPrecio(leerTecla.leer(0.0, "Ingrese el nuevo precio"));
        prodTO.setStock(leerTecla.leer(0, "Ingrese el nuevo Stock"));
        prodTO.setUtilidad(leerTecla.leer(0.0, "Ingrese la nueva utilidad"));
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] data= editarRegistro(leerArch, 0, dataId, prodTO);
        reportarProductos(data);
    }

    public void deleteProducto(){
        util.clearConsole();
        reportarProductos();
        System.out.println("-----------------------Eliminar Producto------------------------");
        String dataId=leerTecla.leer("","Ingrese El Id del producto");
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] data=eliminarRegistros(leerArch, 0, dataId);
        util.clearConsole();
        reportarProductos(data);


    }


}