
package practica1;

import java.util.Scanner;

/**
 *
 * @author byron
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        String ir_menu;
        Scanner salto = new Scanner(System.in);
     System.out.println("Jaime Alejandro Armira Us");
     System.out.println("201602983");
     System.out.println("IPC1 'A' Practica 1 ");
     System.out.println("Buscaminas!!!");
     ir_menu = salto.nextLine();
    menu();
    }
    static void menu(){ 
       int opcion;
 Scanner opc = new Scanner(System.in);
 
        System.out.println("-----------------------");        
        System.out.println("     BUSCAMINAS!!!!    ");
        System.out.println("     1.Principiante    ");
        System.out.println("     2.Intermedio      ");
        System.out.println("     3.Experto         ");
        System.out.println("     4.Ssalir          ");

System.out.println("Ingrese Opcion");
opcion = opc.nextInt(); 
        System.out.println("-----------------------");
switch(opcion){
    case 1:
        break;
        
    case 2:
        break;
    case 3:
        break;
    case 4:
        break;
    default://permite avisarle al usuario que que solo puede utilizar cierto rango para elegir  
    System.out.println("Solo números entre 1 y 3");    
    }   
  
    }
    
}
