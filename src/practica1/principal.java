
package practica1;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author byron
 */
public class principal {
    
   public static char[][] tabla = new char[9][9];
    public static char[][] tabla2 = new char[9][9];
    public static int fila = 0;
    public static int columna = 0;
    public static int bombas = 0;
    public static int xc = 0;
    public static int yc = 0;
    public static int ganador= 0;
    public static boolean fin = false;
    public static boolean debug = false;
    public static int contador = 0;
    public static boolean ciclo = false;
   
    public static void main(String[] args){
       
        intro();
        while (!ciclo){
            contador=0;
            fin=false;
            tablero();
            ver_tabla(fila, columna,tabla2);
            System.out.println("");
            recibir();
            bombas();
            contar_bombas();
            recursivvoltear(xc,yc);
            while(!fin){
                if(debug){
                    ver_tabla(fila, columna,tabla);
                    System.out.println("");
                    }
                        ver_tabla(fila, columna,tabla2);
                        System.out.println("");
                        recibir();
                        recursivvoltear(xc,yc);
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
        fila = 5;
        columna =5;
        bombas=4;
        ganador=12;
        System.out.println("Nivel Principiante");
                
        break;
        
    case 2:
        fila = 7;
        columna =7;
        bombas=8;
        ganador=28;
        System.out.println("Nivel Intermedio");
        
        break;
    case 3:
        fila = 9;
        columna =9;
        bombas=12;
        ganador=52;
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
        for (int l = 1; l < fila; l++) {
            for (int m = 1; m < columna; m++) {
                tabla2[l][m] = 'x';
            }
        }
        for (int l = 1; l < fila; l++) {
            for (int m = 1; m < columna; m++) {
                tabla[l][m] = 'x';
            }
        }
    }
    //impresion de tablero en la consola
    //length y length0 es el tamaño de la matriz
   public static void ver_tabla(int length, int length0, char[][]tabla){
       for (int i = 1; i < length; i++) {
            if (i == 1) {
                System.out.println("");
                System.out.println("---------------------");
            }
            System.out.printf("");
            for (int j = 1; j < length0; j++) {
                System.out.printf("[" + tabla[i][j] + "]");
            }
            if (i == length - 1) {
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
                System.out.println("  Menu   ");
		System.out.println("Voltear: v");
		System.out.println("Reiniciar:r");
		System.out.println("salir:s"); 
                                              
		System.out.println("Ingrese opcion: ");
		return scan.next();
}
    
    String conf, sel;
    public static void recibir (){
        
    

    String opcion="";
        opcion=inicio();
        try{
    switch(opcion){
        case "v":
            ctrl2();
            break;
        case "r":
            System.out.print("\n");
                        
            menu();    
	    break;
        case "s":
        intro();
            break;
        default:
        System.out.println("***REALIZASTE UNA MALA ELECCION INTENTA DE NUEVO***");
        break;
            }
        }catch (Exception v){
            System.out.println("");
        }
    }
    
    
    //---------------------------------------------------------------------
    //@utilizando el ramdom para poder destribuir las bombas en el juego.
    public static void bombas(){
         boolean full = false;
        int d = 0;
        out:
        while (d <= bombas) {
            for (int i = 1; i < fila; i++) {
                for (int j = 1; j < columna; j++) {
                    int bomba = aleatorio(columna);
                    if ((j == bomba) && (tabla[i][j] == 'x') && (i != xc && j != yc)) {
                        tabla[i][j] = '*';
                        ++d;
                        if (d == bombas) {
                            break out;
                        }
                    }
                }
            }
        }
    }
    public static void solucionario (){
         System.out.println("-----------------");
               System.out.println(" Solucionario!!!\n");
               for(int a=0;a<fila;a++){
                   System.out.println("");
                 for(int b=0;b<columna;b++){
                   System.out.print("[  "+tabla[a][b]+"  ]");
                     System.out.println("");
                     System.out.println("");
                     System.out.println("-------------------");
            }
        }
    }
    //esto nos permite de forma aleatoria las bombas del juego
     public static int aleatorio(int limite){
     Random cart=new Random();
     int vol=(int)(Math.random()*limite);
     return vol;
    }
    //analizar cuantas bombas hay en cada nivel(culumna y fila)
    public static void contar_bombas (){
        int contador = 0;
        for (int m = 2; m <= tabla.length - 2; ++m) {
            for (int n = 2; n <= tabla[0].length - 2; ++n) {
                contador = 0;
                if ((tabla[m + 1][n + 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m - 1][n - 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m - 1][n + 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m + 1][n - 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m - 1][n] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m + 1][n] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m][n + 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if ((tabla[m][n - 1] == '*') && (tabla[m][n] == 'x')) {
                    contador++;
                }
                if (tabla[m][n] == 'x') {
                    if (contador > 0) {
                        tabla[m][n] = Integer.toString(contador).charAt(0);
                    } else if (contador == 0) {
                        tabla[m][n] = Integer.toString(contador).charAt(0);
                    }
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (tabla[i][j] == 'x') {
                    tabla[i][j] = Integer.toString(0).charAt(0);
                }
            }
        }
}
   public static void ctrl2(){///aqui es donde estaba intentado hacer eso del x,y
       Scanner scan = new Scanner(System.in);
       String confirmacion = null, seleccion;
            
               boolean valid = false;
        while (!valid) {
            System.out.println("  ingrese numero (n,m) desder 1 en adelante  ");
               seleccion=scan.nextLine();
               seleccion.replaceAll("","");
              
               xc=Integer.parseInt(""+seleccion.charAt(0));
              yc=Integer.parseInt(""+seleccion.charAt(seleccion.length()-1));
              
               xc--;
               yc--;
               System.out.println(""+(xc++)+","+(yc++)+" ?");//en esta parte aparecera otra coordenada un pequeño erro que no pude areglar
               if ((xc <=fila && yc <= columna) && (xc > 0 && yc > 0)) {
                valid = true;
            } else {
                valid = false;
            }
        }
               
               }
   //crtl esto nos servira para ver en que fila y columna queremos voltear pero es con el metodo pi de fila y columana
    public static void ctrl(){
       Scanner sc = new Scanner(System.in);
        boolean valid = false;
        try{
        while (!valid) {
            System.out.println("Introduce tu movimiento!");
            System.out.print("Introduce la fila ");
            xc = sc.nextInt();
            System.out.print("Introduce la columna ");
            yc = sc.nextInt();
            System.out.println("");
              
              if ((xc < fila && yc < columna) && (xc > 0 && yc > 0)) {
                valid = true;
            } else {
                valid = false;
                }
              
            }
        }catch (Exception a){
            System.out.println("INTENTALO DE NUEVO ");
        }
    }
     public static void recursivvoltear(int f, int d) {
        int vec0 = xc;
        int vec1 = yc;
        if (f > fila - 1 || f < 0 || d > columna - 1 || d < 0) {
            return;
        }        
        if (tabla[f][d] == '0') {
            if (tabla2[f][d] != tabla[f][d]) {
                tabla2[f][d] = tabla[f][d];
                ++contador;
                recursivvoltear(f + 1, d);
                recursivvoltear(f, d + 1);
                recursivvoltear(f + 1, d + 1);
            }
            if (f > fila - 1 || f < 0 || d > columna - 1 || d < 0) {
                recursivvoltear(f, d - 1);
                recursivvoltear(f - 1, d);
                recursivvoltear(f - 1, d - 1);
                recursivvoltear(f- 1, d + 1);
                recursivvoltear(f + 1, d - 1);
            }
        } else if ((tabla[f][d] > '0')) {
            if (tabla2[f][d] != tabla[f][d]) {
                tabla2[f][d] = tabla[f][d];
                ++contador;
            }
        }
        if (contador == ganador) {
            System.out.println("congratuletions you won!!!");
            fin = true;
        }else if (tabla[vec0][vec1] == '*') {
            fin = true;
            System.out.println("¡¡¡Game Over!!!");
            System.out.println("");
            
            System.out.println("-----------------");
               System.out.println(" Solucionario!!!\n");
               for(int a=1;a<fila;a++){
                   System.out.println("");
                 for(int b=1;b<columna;b++){
                   System.out.print("["+tabla[a][b]+"]");
                     
                 } 
           
            }   
        }     
     }
}