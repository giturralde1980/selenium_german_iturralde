package practicos.claseTres.com;

import java.util.Scanner;

//Crear un método que retorne verdadero si y sólo si el número es par, de lo
//contrario, debe retornar falso.
public class ejercicioOcho {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int numero = 0;
        System.out.println("Ingrese numero: ");
        numero = input.nextInt();
        boolean esNumPar = esPar(numero);
        if (esNumPar == true)
        {
            System.out.println("Es par");
        }else
        {
            System.out.println("No es par");
        }

    }

    public static boolean esPar(int numero)
    {
        boolean esPar = false;
        if(numero % 2 == 0)
        {
            esPar = true;
        }
        return esPar;
    }
}
