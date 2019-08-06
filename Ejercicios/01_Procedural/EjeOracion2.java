import java.util.*;

/**
 * EjeOracion
 */
public class EjeOracion2 {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int cantVocales = 0;
        int cantEspacios = 0;
        int cantPuntos = 0;

        String oracion;
        char[] letras;


        System.out.println("Igrese una oracion");
        
        oracion = Teclado.nextLine();

        letras = oracion.toCharArray();

        for (int i = 0; i < letras.length; i++)
        {
            if (esVocal(letras[i])) {
                cantVocales++;
            } else if (letras[i] == ' ') {
                cantEspacios++;

            }
        }
        
        cantPuntos++;

        System.out.println("Vocales " + cantVocales);
        System.out.println("Espacios " + cantEspacios);
        System.out.println("Puntos " + cantPuntos);
    }

    static boolean esVocal(char caracter2) {

        switch (caracter2) {
        case 'A':
        case 'a':
        case 'E':
        case 'e':
        case 'é':
        case 'i':
        case 'o':
        case 'u':
            return true;
        }
        return false;
    }

}