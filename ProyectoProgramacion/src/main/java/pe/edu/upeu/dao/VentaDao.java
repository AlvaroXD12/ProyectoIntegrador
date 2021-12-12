package pe.edu.upeu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.UtilsX;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.modelo.VentaDetalleTO;
import pe.edu.upeu.modelo.VentaTO;
import pe.edu.upeu.modelo.ClienteTO;

public class VentaDao extends AppCrud{

    LeerTeclado leerTecla=new LeerTeclado();
    UtilsX util=new UtilsX();

    final String TABLA_VENTAS="Ventas.txt";
    final String TABLA_VENTA_DETALLE="VentaDetalle.txt";
    final String TABLA_PRODUCTO="Producto.txt";
    final String TABLA_CLIENTE="Cliente.txt";

    LeerArchivo leerArch;
    ProductoTO prodTO;
    VentaTO venTO;
    VentaDetalleTO ventaDetalleTO;
    ClienteTO clienteTO;

    SimpleDateFormat formatofechahora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
    
    public void registrarVenta(){

       double subtotalXX=0;
       double totalImporteXX=0;
       double descuentoXX=0;

       VentaTO ventTo=crearVenta();
       String opcion="SI";

       if(ventTo!=null){
           //util.clearConsole();
           System.out.println("**********Agregar productos a carrito de ventas**********");
           do{
               VentaDetalleTO dataVD=carritoVenta(ventTo);
               subtotalXX=subtotalXX+dataVD.getPrecioTotal();
               opcion=leerTecla.leer("", "¿Desea agragar un producto más? SI/NO");
           }while (opcion.toUpperCase().equals("SI"));

           //Actualizar Tabla Ventas
           if(leerTecla.leer("SI", "Desea aplicar Descuento? SI/NO").toUpperCase().equals("SI")){
               //por implementar

           }else{
               descuentoXX=0;
           }
           totalImporteXX=subtotalXX-descuentoXX;
           ventTo.setDescuento(descuentoXX);
           ventTo.setSubtotal(subtotalXX);
           ventTo.setTotalimporte(totalImporteXX);

           leerArch=new LeerArchivo(TABLA_VENTAS);
           editarRegistro(leerArch, 0, ventTo.getIdVenta(), ventTo);
         
        }
    }       

    
    public VentaTO crearVenta(){
        leerArch=new LeerArchivo(TABLA_VENTAS);

        venTO=new VentaTO();
        venTO.setIdVenta(generarId(leerArch, 0, "V", 1)); 
        String dnix=leerTecla.leer("", "Ingrese el Dni del cliente"); 
        venTO.setDni(crearCliente(dnix)); 
        Date fecha=new Date();
        venTO.setFecha(formatofechahora.format(fecha));
        venTO.setSubtotal(0);
        venTO.setDescuento(0);
        venTO.setTotalimporte(0);
        
        leerArch=new LeerArchivo(TABLA_VENTAS);
        agregarContenido(leerArch, venTO);

        leerArch=new LeerArchivo(TABLA_VENTAS);
        if(buscarContenido(leerArch, 0, venTO.getIdVenta()).length==1){
            return venTO;
        }else{ 
            System.out.println("Intente nuevamente:");           
            return crearVenta();
        }         
                       
    }

    public String crearCliente(String dni) {     
        leerArch=new LeerArchivo(TABLA_CLIENTE);
        Object[][] dataCli=buscarContenido(leerArch, 0,dni);
        if(dataCli!=null){
            return dni;
        }else{
            if(dni!=null && dataCli==null){
                ClienteDao cDao=new ClienteDao();
                cDao.crearCliente(dni);
                
            }
            return dni;
        }
       
    }

    public VentaDetalleTO carritoVenta(VentaTO venT){
        mostrarProducto();
        ventaDetalleTO=new VentaDetalleTO();
        leerArch=new LeerArchivo(TABLA_VENTA_DETALLE);

        ventaDetalleTO.setIdDetVenta(generarId(leerArch, 0, "DV", 2));
        ventaDetalleTO.setIdVenta(venT.getIdVenta());
        ventaDetalleTO.setIdProd(leerTecla.leer("","Ingrese el Id del Producto a vender"));
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] prodData=buscarContenido(leerArch, 0, ventaDetalleTO.getIdProd());
        if(prodData!=null){
            double precioX=Double.parseDouble(String.valueOf(prodData[0][4]))
            +Double.parseDouble(String.valueOf(prodData[0][5]));
            ventaDetalleTO.setPrecioUnit(precioX);
        }
        ventaDetalleTO.setCantidad(leerTecla.leer(0, "Ingrese la cantidad"));
        ventaDetalleTO.setPrecioTotal(ventaDetalleTO.getPrecioUnit()*ventaDetalleTO.getCantidad());
        leerArch=new LeerArchivo(TABLA_VENTA_DETALLE);
        agregarContenido(leerArch, ventaDetalleTO);

        return ventaDetalleTO;
    }

    public void mostrarProducto(){
        leerArch=new LeerArchivo(TABLA_PRODUCTO);
        Object[][] data=listarContenido(leerArch);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i][0]+"="+data[i][1]+
            "(Precio:"+
            (
            Double.parseDouble(String.valueOf(data[i][3]))+
            Double.parseDouble(String.valueOf(data[i][4]))
            )
            +" / Stock: "+ data[i][5]+") |\t");
        }
        System.out.println("\n");
    }
    
}
