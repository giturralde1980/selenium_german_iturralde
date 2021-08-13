package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioDiez {
    //Crear un método que permita recibir el alto y ancho de un paralelogramo tipo, y
    //retorne su área.
    public static void main (String args[])
    {
        int alto=0;
        int ancho=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese alto: ");
        alto = input.nextInt();
        System.out.println("Ingrese ancho: ");
        ancho = input.nextInt();
        System.out.println("El area es: " + calculaArea(alto,ancho));

    }

    public static int calculaArea (int a, int b)
    {
        return a*b;
    }
}
