package practicos.claseTres.com;

import java.util.Scanner;

//Realizar un método que reciba dos números y retorne el mayor ambos
public class ejercicioSeis {
    public static void main(String args[])
    {
        int n1 = 0;
        int n2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero entero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese otro numero: ");
        n2 = input.nextInt();
        System.out.println("El mayor numero es: " + devolverMayor(n1, n2));
    }

    private static float devolverMayor(int n1, int n2) {
        if (n1>n2)
        {
            return n1;
        }else
        {
            return n2;
        }
    }
}
