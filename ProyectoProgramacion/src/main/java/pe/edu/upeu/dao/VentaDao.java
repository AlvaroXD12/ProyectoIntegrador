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

       VentaTO ventTo=crearVenta();
       if(ventTo!=null){
           util.clearConsole();
           System.out.println("**********Agregar productos a carrito de ventas**********");
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
        
        leerArch=new LeerArchivo(TABLA_VENTA_DETALLE);

        return null;
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
