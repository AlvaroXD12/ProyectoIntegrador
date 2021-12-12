package pe.edu.upeu.app;

import pe.edu.upeu.modelo.ClienteTO;

/**
 * Hello world!
 *
 */
public class App{

    public static ClienteTO[] cliente;

    public static void ejemploCleinteVector() {
        System.out.println( "Hola AlvaroXD12" );

        cliente=new ClienteTO[3];

        cliente[0]=new ClienteTO("43631917", "Max Maguiña", "953502845");
        cliente[1]=new ClienteTO("43631918", "Maritza Chilet", "991192200");
        cliente[2]=new ClienteTO("72317841", "Alicia Maguiña", "912635175");
        System.out.println("DNI\tNombre\t\tCelular");
        for (ClienteTO cliente : cliente) {
            System.out.println(cliente.getDni()+"\t"+cliente.getNombre()+"\t\t"+cliente.getCelular());
        }        
    }
    public static void main( String[] args ){    
        MenuPrincipal mp=new MenuPrincipal();
        mp.mainLogin();

    }
}
