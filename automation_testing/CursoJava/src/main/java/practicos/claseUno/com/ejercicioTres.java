package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioTres {
    public static void main (String args[])
    {
        /*
        Pedir el ingreso de 3 números y mostrar la suma de ellos.
    INICIO
    TECLADO;
    Int num1;
    Int num2;
    Int num3;

    MOSTRAR “Ingrese un numero”;
    GUARDAR num1;

    MOSTRAR “Ingrese otro numero”;
    GUARDAR num2;



         */
        int num1=0;
        int num2=0;
        int num3=0;
        int suma =0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        num1 = input.nextInt();
        System.out.println("Ingrese un numero");
        num2 = input.nextInt();
        System.out.println("Ingrese un numero");
        num3 = input.nextInt();
        suma = num1+num2+num3;
        System.out.println("El resultado de la suma es: "+suma);


    }
}
