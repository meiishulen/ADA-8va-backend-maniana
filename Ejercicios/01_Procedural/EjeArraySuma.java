import java.util.*;
/**
 * EjeArraySuma
 */
public class EjeArraySuma {

    public static Scanner Teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int[] a = new int[7];
        int[] b = new int[7];
        int[] c = new int[7];
        
        //Ingreso el primer array A
        for (int i = 0; i<7 ; i++){
            System.out.println("Ingrese nro del array A");
            a[i]= Teclado.nextInt();
        }
        
        //Ingreso el segundo array b
        for (int i = 0; i<7 ; i++){
            System.out.println("Ingrese nro del array B");
            b[i]= Teclado.nextInt();
        }

        
        //sumo A+B
        for (int i = 0; i<7 ; i++){
            c[i] = a[i] + b[i];
        }

        
        //Muestro C
        System.out.println("El valor de array C es ");
          
        for (int i = 0; i<7 ; i++){
            System.out.println(c[i]);
        }
    }
}