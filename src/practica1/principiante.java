package practica1;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class principiante {
 public static Scanner scan = new Scanner(System.in);
    public void level1(){
        int matriz[][] = new int[4][4];
       for (int x=0; x < matriz.length; x++) {
  for (int y=0; y < matriz[x].length; y++) {
  }
}
    }
public static String inicio(){
		System.out.println("---------------------------");
		System.out.println("Voltear carta: v");
		System.out.println("Reiniciar juego: r");
		System.out.println("salir:s"); 
                
                                
		System.out.println("Ingrese opcion: ");
		return scan.next();
	}
}