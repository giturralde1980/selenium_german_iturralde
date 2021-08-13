package practicos.claseTres.com;

import java.util.Scanner;
//Método que reciba un número entero y un número double, y retorne su
//multiplicación
public class ejercicioCinco {
    public static void main(String args[])
    {
        int n1 = 0;
        float n2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero entero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese numero flotante: ");
        n2 = input.nextFloat();
        System.out.println(devolverMultiplicacion(n1, n2));
    }

    private static float devolverMultiplicacion(int n1, float n2) {
        float numero = (float) n1;
        return numero * n2;
    }
}
