package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioDiecisiete {
    public static void main (String args []) {
        int a = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        a = input.nextInt();
        System.out.println("Factorial: " + calcularFactorial(a));

    }

    public static int calcularFactorial(int numero)
    {
        int resultado = 1;
        for (int i=1; i<=numero;i ++)
        {
            resultado=resultado*i;
        }
        return resultado;
    }
}
