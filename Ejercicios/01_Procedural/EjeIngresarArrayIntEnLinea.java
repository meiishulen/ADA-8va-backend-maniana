import java.util.*;

/**
 * EjeIngresarArrayIntEnLinea Ingresar en una sola linea los numeros para ser
 * llenados a un array. Separados por espacios. 34 4 66
 */
public class EjeIngresarArrayIntEnLinea {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int[] numeros;

        String textoNumeros;
        char primerCaracter;

        System.out.println("Ingrese los numeros separados por espacios");

        textoNumeros = Teclado.nextLine();
        primerCaracter = textoNumeros.charAt(0);
        char[] caracteresTexto = textoNumeros.toCharArray();
        // Primero contar la cantidad de espacios que hay para saber
        // el tamanio del arreglo de numeros
        int cantEspacios = 0;
        for (int i = 0; i < caracteresTexto.length; i++) {
            if (caracteresTexto[i] == ' ')
                cantEspacios++;
        }

        numeros = new int[cantEspacios + 1];

        String numeroEnFormatoTexto = "";
        int contadorNumeros = 0;
        for (int i = 0; i < caracteresTexto.length; i++) {
            if (caracteresTexto[i] != ' ')
                numeroEnFormatoTexto = numeroEnFormatoTexto + caracteresTexto[i];
            else {
                contadorNumeros++;
                numeros[contadorNumeros] = textoANumero(numeroEnFormatoTexto);
                numeroEnFormatoTexto = "";
            }
        }

        System.out.println("Hasta aca");

    }

    public static int textoANumero(String texto) {
        char[] caracteres = texto.toCharArray();
        int numero = 0;
        int digitoASCII;
        int digito;
        for (int i = caracteres.length - 1; i >= 0; i--) {
            digitoASCII = caracteres[i];
            digito = digitoASCII - 48;
            numero += digito * (10 ^ (i-(caracteres.length -1)));

        }

        return numero;
    }
}