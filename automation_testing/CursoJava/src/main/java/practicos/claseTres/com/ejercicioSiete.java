package practicos.claseTres.com;
//Crear un método que reciba un número entero n, y muestre en pantalla la suma
//desde 1 hasta ese número n. Ej. Si n es 4, se debe mostrar en pantalla 10.

import java.util.Scanner;

public class ejercicioSiete
{
    public static void main(String args[])
    {
        int n1 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero entero: ");
        n1 = input.nextInt();
        mostrarSumaPantalla(n1);
        //System.out.println("El mayor numero es: " + devolverMayor(n1, n2));
    }

    private static void mostrarSumaPantalla(int numero) {
        int suma = 0;
        for(int i=0; i<=numero;i++)
        {
            suma=suma+i;
        }
        System.out.println("Total: " + suma);
    }
}
