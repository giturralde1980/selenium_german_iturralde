package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioUno {
    //1. Escribir un método que reciba un número y retorne su doble
    public static void main (String args[])
    {
        int numero = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        numero = input.nextInt();
        System.out.println(devolverDoble(numero));
    }

    public static int devolverDoble(int numero)
    {
        return (numero*2);
    }
}
