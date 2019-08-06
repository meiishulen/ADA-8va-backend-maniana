import java.util.*;

/**
 * EjerBisiesto
 */
public class EjerBisiesto {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int anio;
        System.out.println("Ingrese un anio");
        anio = Teclado.nextInt();
        System.out.println("El anio ingresado es "+anio);

        System.out.println("Es anio bisiesto? "+esAnioBisiesto(anio));


        if (esAnioBisiesto(anio) == true) {
            System.out.println("Es anio bisiesto");
        } else {
            System.out.println("No es anio bisiesto");
        }
        System.out.println("El anio despues de funcion es "+anio);
        
    }

    public static boolean esAnioBisiesto(int anio) {

        return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
        
    }

}