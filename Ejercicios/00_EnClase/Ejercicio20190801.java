import java.utils.*;
/**
 * Ejercicio20190801
 */
public class Ejercicio20190801 {

    public static Sanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int n;
        int[] nros;
        int suma = 0;

        System.out.println("Ingrese cant nros");

        boolean hay13;

        for(int i = 0; i < n; i++)
        {
            nros[i]=Teclado.nextInt();

        }

        for(int i = 0; i < n; i++)
        {
           if ( nros[i] == 13)
           {
               hay13= true;
           }
           else {
                if (!hay13)
                {
                 
                    suma = suma + nros[i];
                }
                else
                {
                    hay13 = false;
                }
           }
            
        }

        System.out.println("La suma es"+ suma);
    }
}