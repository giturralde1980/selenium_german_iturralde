package practicos.claseTres.com;
//18. Realizar un método llamado validarNumero, que recibe 4 parametros:
//a) Un mensaje para mostrar: mensaje
//b) Un mensaje de error: error
//c) Un entero llamado: mínimo
//d) Un entero llamado: máximo
//Se debe pedir el ingreso de números indicando el mensaje por parámetro para solicitar
//el número. En caso de que se ingrese un número fuera del rango, mostrar el mensaje
//de error y pedir que ingrese un número que se encuentre dentro del rango.
//El método debe retornar un entero que se encuentre dentro del rango comprendido
//entre el máximo y el mínimo.

import java.util.Scanner;

public class ejercicioDieciocho {

    public static Scanner input;


    public static void main(String args[])
    {
        int numero = 0;
        int min=0;
        int max = 0;
        System.out.println(validarNumero("Ingrese número", "error", min,max));
    }

    public static int validarNumero(String mensaje, String error, int max, int min)
    {
        input = new Scanner(System.in);
        int numero = 0;
        boolean esValido=false;
        while(esValido==false)
        {

            System.out.println(mensaje+": ");
            numero = input.nextInt();
            System.out.println(mensaje + " minimo");
            min = input.nextInt();
            System.out.println(mensaje + " maximo");
            max = input.nextInt();
            if(numero<min || numero>max)
            {
                System.out.println(error);
            }else
            {
                esValido = true;
            }
        }

        return numero;
    }
}
