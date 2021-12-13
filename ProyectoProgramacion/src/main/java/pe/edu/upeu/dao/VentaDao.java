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

       double subtotalXX=0.0;
       double totalImporteXX=0.0;
       double descuentoXX=0.0;

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
               System.out.println("ingrese el descuento");
               descuentoXX=0.1*subtotalXX;
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
        Object[][] dataCli=null;
        dataCli=buscarContenido(leerArch, 0, dni);
        System.out.println("VEr:"+dataCli.length);
        if(dataCli==null || dataCli.length==0){
            if(dataCli.length==0){
                ClienteDao cDao=new ClienteDao();
                cDao.crearCliente(dni);                
            }
            return dni;
            
        }else{
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
    
    public void reporteVentasRangoFecha(){
        util.clearConsole();
        util.clearConsole();
        System.out.println("===================Registro Ventas==================");
        String fechaInit=leerTecla.leer("", "Ingrese F. Inicio (dd-MM-yyyy)");
        String fechaFinal=leerTecla.leer("", "Ingrese F. Final (dd-MM-yyyy)");
        leerArch=new LeerArchivo(TABLA_VENTAS);
        Object[][] dataV=listarContenido(leerArch);
        int contadorVRD=0;
        try {
            //Para saber que cantidad de registros coinciden con el rango de fecha
            for (int i = 0; i < dataV.length; i++) {
                String[] fechaVentor=String.valueOf(dataV[i][2]).split(" ");
                Date fechaVentaX=formatofecha.parse(fechaVentor[0]);
                if(
                (fechaVentaX.after(formatofecha.parse(fechaInit)) || fechaInit.equals(fechaVentor[0])) && 
                (fechaVentaX.before(formatofecha.parse(fechaFinal)) || fechaFinal.equals(fechaVentor[0]))
                ){
                    contadorVRD++; 
                }
            }

            //Pasar los datos a un Vetor de tipo VentaTO segun Rango Fechas
            VentaTO[] dataReal=new VentaTO[contadorVRD];
            int indiceVector=0;
            for (int i = 0; i < dataV.length; i++) {
                String[] fechaVentor=String.valueOf(dataV[i][2]).split(" ");
                Date fechaVentaX=formatofecha.parse(fechaVentor[0]);
                if(
                (fechaVentaX.after(formatofecha.parse(fechaInit)) || fechaInit.equals(fechaVentor[0])) && 
                (fechaVentaX.before(formatofecha.parse(fechaFinal)) || fechaFinal.equals(fechaVentor[0]))
                ){
                   VentaTO vTo=new VentaTO();
                   vTo.setIdVenta(dataV[i][0].toString());
                   vTo.setDni(dataV[i][1].toString());
                   vTo.setFecha(dataV[i][2].toString());
                   vTo.setDescuento(Double.parseDouble(String.valueOf(dataV[i][4])));
                   vTo.setSubtotal(Double.parseDouble(String.valueOf(dataV[i][3])));
                   vTo.setTotalimporte(Double.parseDouble(String.valueOf(dataV[i][5])));
                   dataReal[indiceVector]=vTo;
                   indiceVector++;
                }
            } 
            //Imprimir Ventas  
            System.out.println("----------------Reporte ventas ente"+fechaInit+" y "+fechaFinal+"----------------");
            util.pintarLine('H', 40);
            util.pintarTextHeadBody('H', 3, "ID,DNI cliente,Fecha, Sub. Total, Descuento, Imp.Total");
            System.out.println("");
            double subtotalX=0, descuentoX=0, importeTX=0;
            util.pintarLine('H', 40);
            for (VentaTO TOv : dataReal) {
                String datax=TOv.getIdVenta()+","+TOv.getDni()+","+TOv.getFecha()+","+
                TOv.getSubtotal()+","+TOv.getDescuento()+","+TOv.getTotalimporte();
                subtotalX+=TOv.getSubtotal(); 
                descuentoX+=TOv.getDescuento(); 
                importeTX+=TOv.getTotalimporte();
                util.pintarTextHeadBody('B', 3, datax); 
            }
            System.out.println("");
            util.pintarLine('H', 40);
            System.out.println("|Sub Total: S/"+subtotalX+" | Descuento: S/."+descuentoX+"| Imp. Total: S/."+importeTX);
            util.pintarLine('H', 40);
             
         } catch (Exception e){
            System.err.println("Error al reportar!");
        }  

    }
    
        
}  
