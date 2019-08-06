import java.util.*;

/**
 * EJe3
 */
public class EJe3 {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int a, b;

        a = Teclado.nextInt();

        b = Teclado.nextInt();

        if (a > b) {
            System.out.println(" A es mayor a B ");

        } else {
            if (a < b) {
                System.out.println(" A es menor B ");
            } else {
                System.out.println(" A es igual a B ");

            }

        }
    }
}