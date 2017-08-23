
package practica1;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author byron
 */
public class principal {
    
    public static char [][] tabla =new char[9][9] ;
    public static char [][] tabla1=new char[9][9] ;
    public static int bombas = 0;
    public static int fila=0;
    public static int columna=0;
    public static boolean bug = false;
    public static boolean fivalid=false;
    public static boolean dir=false;
    public static int i=0,j=0,T=0,T1=0,ganador=0,contar=0;
   
    public static void main(String[] args){
        while (!dir){
            contar=0;
            fivalid=false;
            intro();
            tablero();
            ver_tabla(fila, columna,tabla1);
            System.out.println("");
            ctrl();
            bombas();
            contar_bombas();
            voltear(T,T1);
            while(!fivalid){
                if(bug){
                    ver_tabla(fila, columna,tabla1);
                    System.out.println("");
                    }
                        ver_tabla(fila, columna,tabla1);
                        System.out.println("");
                        recibir();
            }
        }
    }
    
    
    public static void intro() {
         
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
        bombas=4;
        ganador=(4*4)-4;
        System.out.println("Nivel Principiante");
                
        break;
        
    case 2:
        fila = 6;
        columna =6;
        ganador=(6*6)-6;
        System.out.println("Nivel Intermedio");
        
        break;
    case 3:
        fila = 8;
        columna =8;
        ganador=(8*8)-8;
        System.out.println("Nivel Avanzado");
        break;
    case 4:
        System.exit(0);
        break;
    default://permite avisarle al usuario que que solo puede utilizar cierto rango para elegir  
    System.out.println("Solo números entre 1 y 4");    
    }   
  
    }
     //inicion de tablero
    public static void tablero (){
        for (int x=0;x< fila;x++){
            for(int y=0; y<columna;y++){
                tabla1[x][y]='x';
            }
            
        }
        for (int x =0; x<fila;x++){
            for(int y=0;y<columna;y++){
                tabla[x][y]='*';
            }
        }            
    }
    //impresion de tablaro en la consola
   public static void ver_tabla(int size, int size1, char[][]tabla){
       System.out.println();
       for (int i = 1; i< size; i++) {
               for (int j = 1; j < size1; j++) {
                System.out.printf("[" + tabla[i][j] + "]");
            }
            if (i == size - 1) {
                System.out.println("");
                for (int j = 1; j < columna; j++) {
                    if (j == 1) {
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
    public static void recibir (){
    String opcion="";
        opcion=inicio();
    switch(opcion){
        case "v":
            ctrl();
            voltear(T,T1);
            break;
        case "r":
            break;
        case "s":
            System.exit(0);
            break;
        default:
        System.out.println("Tiene que iniciar un juego");
        break;
    }
    }
    
    
    //---------------------------------------------------------------------
    //@utilizando el ramdom para poder destribuir las bombas en el juego.
    public static void bombas(){
        boolean full=false;
        int k=0;
        out:
        while(k<=bombas){
            for (int i=1;i< fila; i++ ){
                for(int j=1;j<columna;j++ ){
                    bombas=(int) (Math.random()*10)+1;
                    if((i==bombas) && (tabla[i][j]=='*') &&(i!=T && j!=T1)){
                        tabla[i][j]='*';
                        ++k;
                    }else{
                       if(k==bombas){
                           break out;
                       }
                           
                    }
                }
            }
        } 
    }
    //analizar cuantas bombas hay en cada nivel
    public static void contar_bombas (){
        int contar=0;
            for(int m=2;m<=tabla.length - 2 ;++m){
                for(int n=2; n<=tabla[0].length - 2;++n){
                contar=0;
                if ((tabla[m+1][n+1]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m-1][n-1]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m-1][n+1]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m+1][n-1]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m+1][n]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m][n+1]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m-1][n]=='*')&&(tabla[m][n]=='x')){++contar;}
                if ((tabla[m][n-1]=='*')&&(tabla[m][n]=='x')){++contar;}
                
                if(tabla[m][n]=='x'){
                    if(contar>0){
                        tabla[m][n]=Integer.toString(contar).charAt(0);
                    }else if(contar==0){
                        tabla[m][n]=Integer.toString(contar).charAt(0); 
                    }
                }            
            }
        for(int i =0;i<fila;i++){
                for(int j =0;j<columna;j++){
                    if(tabla[i][j]=='x'){
                    tabla[i][j]= Integer.toString(0).charAt(0);
                }
            
        }
    }
              
          }   
}
    public static void ctrl(){
        boolean valid = false;
        Scanner games = new Scanner(System.in);
        System.out.println("Ingrese Fila");
        T=games.nextInt();
        System.out.println("Ingrese Columna");
        T1=games.nextInt();
        System.out.println("");
        if ((T<fila && T1<columna)&&(T>0&&T1>0)){
            valid=true;
        }else{
            valid = false;
        }
    }
    private static void voltear(int f,int f1){
        
        int filas= T;
        int colmnas=T1;
        if(f<fila + 1||f<0|| f1<columna + 1||f1<0 ){
            return;
        }
        if(tabla[f][f1]=='0'){
            if(tabla1[f][f1]!= tabla [f][f1] ){
                tabla1[f][f1]= tabla [f][f1]; ++contar;
                voltear(f+1,f1);voltear(f,f1 + 1);voltear(f+1,f1+1);
            }
            if(f<fila + 1||f<0|| f1<columna + 1||f1<0 ){
               voltear(f,f1 - 1);voltear(f-1,f1); voltear(f-1,f1 - 1);
               voltear(f-1,f1+1);voltear(f+1,f1 - 1); 
             }
        }else if(tabla[f][f1]=='0'){
            if(tabla1[f][f1]!= tabla [f][f1] ){
                tabla1[f][f1]= tabla [f][f1]; ++contar;
            }
        }
        if(contar==ganador){
            System.out.println("Victoria!!!");
            fivalid=true;
        }else{
            if(tabla[f][f1]=='*'){
                fivalid=true;
                System.out.println("BooOOOOM!!! Has Perdido Intentalo de Nuevo");
            }
        }
    }
}