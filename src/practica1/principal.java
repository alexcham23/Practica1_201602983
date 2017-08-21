
package practica1;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class principal {
    
    public static int bombas = 0;
    public static char [][] tabla =new char[9][9] ;
    public static int fila=0;
    public static int columna=0;
    public static int i=0,j=0,T=0,T1=0,contar = 0;
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
     public static void menu(){ 
       int opcion;
 Scanner opc = new Scanner(System.in);
 
        System.out.println("-----------------------");        
        System.out.println("     BUSCAMINAS!!!!    ");
        System.out.println("     1.Principiante    ");
        System.out.println("     2.Intermedio      ");
        System.out.println("     3.Experto         ");
        System.out.println("     4.Salir          ");

System.out.println("Ingrese Opcion");
opcion = opc.nextInt(); 
        System.out.println("-----------------------");
switch(opcion){
    case 1:
        fila = 4;
        columna =4;
        System.out.println("Nivel Principiante");
        tablero();
        ver_tabla(fila,columna,tabla);
        inicio();
        break;
        
    case 2:
        fila = 6;
        columna =6;
        System.out.println("Nivel Intermedio");
        tablero();
        ver_tabla(fila,columna,tabla);
        inicio();
        break;
    case 3:
        fila = 8;
        columna =8;
        System.out.println("Nivel Avanzado");
        tablero();
        ver_tabla(fila,columna,tabla);        
        inicio();
        break;
    case 4:
        break;
    default://permite avisarle al usuario que que solo puede utilizar cierto rango para elegir  
    System.out.println("Solo números entre 1 y 3");    
    }   
  
    }
     //inicion de tablero
    public static void tablero (){
        for (i=0;i< fila;i++){
            for(j=0; j<columna;j++){
                tabla[i][j]='x';
            }
        }
                    
    }
    //impresion de tablaro en la consola
   public static void ver_tabla(int size, int size1, char[][]tabla){
       System.out.println();
       for (int a = 0; a < size; a++) {
               for (int b = 0; b < size1; b++) {
                System.out.printf("[" + tabla[a][b] + "]");
            }
            if (i == size - 1) {
                System.out.println("");
                for (int j = 0; j < columna; j++) {
                    if (j == 0) {
                        System.out.print("");
                    }
                    System.out.printf("");
                }
            }
            System.out.println("");
        }
    }
  
    public static String inicio(){
		Scanner scan =new Scanner (System.in);
                System.out.println("---------------------------");
		System.out.println("Voltear: v");
		System.out.println("Reiniciar:r");
		System.out.println("salir:s"); 
                
                                
		System.out.println("Ingrese opcion: ");
		return scan.next();
	}
    //---------------------------------------------------------------------
    //@utilizando el ramdom para poder destribuir las bombas en el juego.
    public static void bombas(){
        
        while(i<=bombas){
            for (int i=0;i< fila; i++ ){
                for(int j=0;j<columna;j++ ){
                    bombas=(int) (Math.random()*10)+1;
                    if((i!=T && j!=T1)&& (tabla[i][j]=='*') &&(j==bombas)){
                        tabla[i][j]='*';
                        ++i;
                    }else{
                       if(i==bombas){
                           break;
                       }
                           
                    }
                }
            }
        } 
    }
    //analizar cuantas bombas hay en cada nivel
    public static void contar_bombas (){
            for(int m=1;m<tabla[0].length - 1 ;m++){
                for(int n=1; n<tabla[0].length - 1;n++){
                contar=0;
                if ((tabla[m+1][n+1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m-1][n-1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m-1][n+1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m+1][n-1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m-1][n-1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m+1][n]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m][n+1]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m-1][n]=='*')&&(tabla[m][n]=='*')){++contar;}
                if ((tabla[m][n-1]=='*')&&(tabla[m][n]=='*')){++contar;}
                
                if(tabla[m][n]=='*'){
                    if(contar>0){
                        tabla[m][n]=Integer.toString(contar).charAt(0);
                    }
                }            
            }
        for(int i =0;i<fila;i++){
                for(int j =0;j<columna;j++){
                    if(tabla[i][j]=='*'){
                    tabla[i][j]= Integer.toString(0).charAt(0);
                }
            
        }
    }
              
          }   
}
}