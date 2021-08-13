package practicos.claseTres.com;

import java.util.Scanner;
//Método que reciba dos números y retorne su suma
public class ejercicioCuatro {
    public static void main(String args[])
    {
        int n1 = 0;
        int n2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese otro numero: ");
        n2 = input.nextInt();
        System.out.println(devolverSuma(n1, n2));
    }

    private static int devolverSuma(int n1, int n2) {
        return n1+n2;
    }
}
