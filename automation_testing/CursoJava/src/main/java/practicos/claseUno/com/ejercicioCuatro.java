package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioCuatro {
    public static void main(String args[])
    {
        /*

    Pedir el ingreso de un dato, e indicar si es menor o mayor a 0
    INICIO
    Int numero;
    TECLADO;
    MOSTRAR “Ingrese un numero”;
    GUARDAR numero;

    if ( numero > 0 ) {
        MOSTRAR “El numero es mayor a 0”;
    } else {
        MOSTRAR “El numero es menor o igual a 0”;
    }

    FIN

         */
        int num=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero:");
        num= input.nextInt();
        if (num>0) {
            System.out.println("El numero es mayor a 0");
        }else
        {
            System.out.println("El numero es menor a 0");
        }
    }
}
