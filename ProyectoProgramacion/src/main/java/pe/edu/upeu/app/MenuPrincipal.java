package pe.edu.upeu.app;

import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.utils.LeerTeclado;

public class MenuPrincipal {

  LeerTeclado lt= new LeerTeclado();
  ProductoDao prodDao;

  public void menuOpciones(){
      int opcionesA=0;
      System.out.println("-------------------------------");
      String msg="\nIngrese el Algoritmo que desea Probar"+ 
      "\n1=Crear producto"+
      "\n2=listar producto"  
      ;
   
      opcionesA=lt.leer(0, msg);  
      while(opcionesA!=0){
          switch(opcionesA) {
            case 1: { 
              prodDao=new ProductoDao();
              prodDao.crearProducto();
              } break;
            case 2: break;
            default: System.out.println("El Algoritmo no existe!");
          }   
        System.out.println("------------------------------"); //15.511.210.043.330.985.984.000.000        
        opcionesA=lt.leer(0,msg);        
      }
  }
}
