package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioTrece
{
    //13. Dado un número, un máximo y un mínimo (recibido por parámetro), retorne
    //verdadero si el número está dentro del máximo y el mínimo. Si el número se
    //encuentra dentro del max y min, el método debe mostrar “El numero es valido”
    //sino, se debe retornar, “El numero esta fuera de rango.”
    public static void main (String args[])
    {
        int numero = 0;
        int maximo = 0;
        int minimo = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        numero=input.nextInt();
        System.out.println("Ingrese minimo: ");
        minimo=input.nextInt();
        System.out.println("Ingrese maximo: ");
        maximo=input.nextInt();
        boolean resultado = devolerValido(numero,maximo,minimo);
        if (resultado == true)
        {
            System.out.println("Valido");
        }else
        {
            System.out.println("Fuera de rango");
        }
    }


    public static boolean devolerValido(int numero, int maximo, int minimo){
        boolean valido = false;
        if(numero < minimo || numero > maximo)
        {
            valido=false;
        }else
        {
            valido=true;
        }

        return valido;
    }
}
