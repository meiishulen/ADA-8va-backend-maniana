import java.util.*;

/**
 * CodingBatArray1CommonEnd
 */

public class CodingBatArray1CommonEnd {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int n;
        int[] a;
        int[] b;

        System.out.println("Ingrese el largo de los arreglos");

        n = Teclado.nextInt();

        a = new int[n];
        // el largo de B es diferente
        b = new int[n + 1];


        // ingreso los valores de a
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el elemento " + i + "de A");
            a[i] = Teclado.nextInt();
        }
        
        // ingreso los valores de b
        for (int i = 0; i < n + 1; i++) {
            System.out.println("Ingrese el elemento " + i + " de B");
            b[i] = Teclado.nextInt();
        }

        // f[0] va a pasar a ser 3.14159
        boolean resultadoComparacion;

        resultadoComparacion = commonEnd(a, b);
        System.out.println("Ambos array comparten primer y/o ultimo elemento: " + resultadoComparacion);

    }

    static public boolean commonEnd(int[] v1, int[] v2) {
        // pregunto por el primer elemento

        if (v1[0] == v2[0]) {
            return true;
        }
        // checkeo por el ultimo elemento
        else if (v1[v1.length - 1] == v2[v2.length - 1]) {
            return true;
        }

        return false;

    }
}