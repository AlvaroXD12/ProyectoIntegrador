package pe.edu.upeu.TareaNº03;

import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

public class EjerciciosMatriz {

    public void ejercicio09(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int f =0; f<matrizT.length ; f++) {
            for (int c = 0; c <=f; c++) {
                matrizT[f][(matrizT[0].length-f-1)+c]=num;
                num++;
            }
        }
        imprimirMatriz(matrizT);        
    }

    public void ejercicio16(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int c = 0; c < matrizT.length; c++) {
            for (int f =0; f<=c ; f++) {
                matrizT[(matrizT[0].length-1)-f][c]=num;
                num++;
            }
        }
        imprimirMatriz(matrizT);        
    }



    public void ejercicio18(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int c = 0; c < matrizT.length; c++) {
            for (int f =0; f<=c ; f++) {
                matrizT[f][(matrizT[0].length-1)-c]=num;
                num++;
            }
        }
        imprimirMatriz(matrizT);        
    }

    public void ejercicio07(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int f = 0; f < matrizT[0].length; f++) {
            for (int c =0; c < matrizT.length-f ; c++) {
                matrizT[f][c]=num;
                num++;
            }
        }

        imprimirMatriz(matrizT);        
    }

    public void ejercicio08(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int f = 0; f < matrizT[0].length; f++) {
            for (int c =0; c < matrizT.length-f; c++) {
                matrizT[f][c+f]=num;
                num++;
            }
        }

        imprimirMatriz(matrizT);        
    }

    public void ejercicio19(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int c = 0; c < matrizT[0].length; c++) {
            for (int f =0; f < matrizT.length-c ; f++) {
                matrizT[matrizT.length-f-1][matrizT.length-c-1]=num;
                num++;
            }
        }

        imprimirMatriz(matrizT);        
    }

    public void ejercicio20(int dimen, int num) {
        Object[][] matrizT=new Object[dimen][dimen];  

        for (int c = 0; c < matrizT[0].length; c++) {
            for (int f =0; f<=c ; f++) {
                matrizT[matrizT.length-f-1][matrizT.length-c-1]=num;
                num++;
            }
        }

        imprimirMatriz(matrizT);        
    }


    public void imprimirMatriz(Object[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
               if(matriz[i][j]!=null){
                System.out.print(matriz[i][j]+"\t");
               }else{
                System.out.print("\t");
               }                               
            }
            System.out.println();
        }
    }    


    public static void main(String[] args) {
        
        EjerciciosMatriz em=new EjerciciosMatriz();
        LeerTeclado lt=new LeerTeclado();

        System.out.println("Ejercico 7");
        em.ejercicio07(lt.leer(0, "Ingrese la Dimension"), 0);

        System.out.println("Ejercico 8");
        em.ejercicio08(lt.leer(0, "Ingrese la Dimension"), 0);
        
        System.out.println("Ejercicio 9");
        em.ejercicio09(lt.leer(0, "Ingrese la Dimension"), 0);

        System.out.println("Ejercicio 16");
        em.ejercicio16(lt.leer(0, "Ingrese la Dimension"), 0);

        System.out.println("Ejercicio 18");
        em.ejercicio18(lt.leer(0, "Ingrese la Dimension"), 0);

        System.out.println("Ejercico 19");
        em.ejercicio19(lt.leer(0, "Ingrese la Dimension"), 0);

        System.out.println("Ejercico 20");
        em.ejercicio20(lt.leer(0, "Ingrese la Dimension"), 0);
    }
    
}