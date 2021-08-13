package practicos.claseUno.com;

import java.util.Scanner;

//Programa Java que lea dos números y muestre los números desde el menor hasta el mayor


public class ejercicioOnce {

        public static void main(String args[]){
        int num1=0;
        int num2=0;
        int mayor = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("ingrese un numero");
        num1=input.nextInt();

        System.out.println("ingrese un numero");
        num2=input.nextInt();

        if (num1!=num2)
        {
            if(num1>num2) {
                for (int i = num1; i <= num2; i++) {
                    System.out.println(i);
                }
            }else
            {
                for (int i = num2; i >= num1; i--) {
                    System.out.println(i);
                }
            }
        }else
        {
            System.out.println("Numeros iguales, nada para hacer....");
        }

    }
}
