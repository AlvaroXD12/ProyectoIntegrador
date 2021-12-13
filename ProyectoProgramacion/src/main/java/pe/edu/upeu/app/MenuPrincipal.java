package pe.edu.upeu.app;

import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.dao.VentaDao;
public class MenuPrincipal {

  LeerTeclado lt= new LeerTeclado();
  UsuarioDao uDao;
  ProductoDao prodDao;
  VentaDao ventDao;

  public void mainLogin() {
    uDao=new UsuarioDao();
    if (uDao.login()) {

      menuOpciones();

      
    }else{
      System.out.println("Intente Nuevamente!!");
      mainLogin();
    }
  }

  public void menuOpciones(){
      int opcionesA=0;
      System.out.println("______________¶¶¶¶___1¶¶¶___1¶¶¶__________________");
      System.out.println("_______________1¶¶¶1___¶¶¶1___¶¶¶¶________________");
      System.out.println("_________________1¶¶1____¶¶¶____¶¶¶_______________");
      System.out.println("___________________¶¶1____¶¶1____¶¶1______________");
      System.out.println("___________________¶¶¶____¶¶¶____¶¶¶______________");
      System.out.println("__________________1¶¶1___1¶¶1____¶¶1______________");
      System.out.println("_________________¶¶¶____¶¶¶1___1¶¶1_______________");
      System.out.println("________________11_____111_____11_________________");
      System.out.println("__________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶¶¶¶¶¶¶¶¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶_______¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("_¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("_¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________");
      System.out.println("__________¶¶___1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1________");
      System.out.println("__________1¶¶___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_________");
      System.out.println("____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶11__________");
      System.out.println("11_____________________________________________111");
      System.out.println("1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1");
      System.out.println("__¶¶111111111¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶111111111¶__");
      System.out.println("--------------------------------------------------");
      System.out.println("-----------█▒▒▒█▒█▀▒█▒▒█▀▒█▀█▒█▀█▀█▒█▀------------");
      System.out.println("-----------█▒█▒█▒█▀▒█▒▒█▒▒█▒█▒█▒█▒█▒█▀------------");
      System.out.println("-----------█▄█▄█▒██▒█▄▒█▄▒█▄█▒█▒█▒█▒██------------");
      System.out.println("--------------------------------------------------");
      String msg="\nIngrese el Algoritmo que desea Probar"+ 
      "\n1=Crear Producto"+
      "\n2=Listar Producto"+
      "\n3=Editar Producto"+
      "\n4=Eliminar Producto"+
      "\n5=Crear Usuario"+
      "\n6=Registrar Venta"+
      "\n7=Reportar Ventas";
      opcionesA=lt.leer(0, msg);  
      while(opcionesA!=0){
          switch(opcionesA) {
            case 1: { 
              prodDao=new ProductoDao();
              prodDao.crearProducto();
              } break;
            case 2: {
              prodDao=new ProductoDao();
              prodDao.reportarProductos();
            }  break;
            case 3:{
              prodDao=new ProductoDao();
              prodDao.updateProducto();
            }  break; 
            case 4:{
              prodDao=new ProductoDao();
              prodDao.deleteProducto();
            }  break; 
            case 5:{
              uDao=new UsuarioDao();
              uDao.crearUsuario();
            }  break; 
            case 6:{
              ventDao=new VentaDao();
              ventDao.registrarVenta();
            }  break; 
            case 7:{
              ventDao=new VentaDao();
              ventDao.reporteVentasRangoFecha();
            }  break;    
            default: System.out.println("El Algoritmo no existe!");
          }   
        System.out.println("");      
        opcionesA=lt.leer(0,msg);        
      }
  }
}
