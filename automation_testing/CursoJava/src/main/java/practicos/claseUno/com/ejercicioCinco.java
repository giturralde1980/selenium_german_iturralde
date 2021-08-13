package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioCinco {
    public static void main(String args[]){
        /*
        Pedir el ingreso de 3 números, indicar si hay números repetidos.
    INICIO
    TECLADO;
    Int num1;
    Int num2;
    Int num3;

    MOSTRAR “Ingrese un numero”;
    GUARDAR num1;

    MOSTRAR “Ingrese otro numero”;
    GUARDAR num2;

    MOSTRAR “Ingrese el ultimo numero”;
    GUARDAR num3;

         */
        int num1=0;
        int num2=0;
        int num3=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        num1=input.nextInt();
        System.out.println("Ingrese otro número: ");
        num2=input.nextInt();
        System.out.println("Ingrese otro número número: ");
        num3=input.nextInt();
        if (num1==num2 || num1==num3 || num2 == num3)
        {
            System.out.println("Hay numeros repetidos");
        }

    }
}
