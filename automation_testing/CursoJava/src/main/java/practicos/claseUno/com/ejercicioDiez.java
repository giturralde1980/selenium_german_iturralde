package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioDiez {
    //Pedir el ingreso de 3 números e indicar cual es el repetido. Ej.     1    4    4.   => El número repetido es el 4
    public static void main(String args[]){
        int num1=0;
        int num2=0;
        int num3=0;

        Scanner input = new Scanner(System.in);
        System.out.println("ingrese un numero");
        num1=input.nextInt();

        System.out.println("ingrese un numero");
        num2=input.nextInt();

        System.out.println("ingrese un numero");
        num3=input.nextInt();

        if(num1==num2) {
            System.out.println("numero repetido: " +num1);
        }else if (num1==num3)
        {
            System.out.println("numero repetido: " + num3 );
        }else if (num2 == num3)
        {
            System.out.println("numero repetido: " +num2);
        }else
        {
            System.out.println("No hay repetidos");
        }

    }
}
