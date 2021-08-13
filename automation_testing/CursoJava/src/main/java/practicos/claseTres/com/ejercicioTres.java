package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioTres {
    //Método que reciba dos enteros y retorne la multiplicación de la misma.
    public static void main(String args[])
    {
        int n1 = 0;
        int n2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese otro numero: ");
        n2 = input.nextInt();
        System.out.println(devolverDoble(n1, n2));
    }

    public static int devolverDoble(int n1, int n2)
    {
        return (n1*n2);
    }
}
