package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioSiete {


    //Peder el ingreso de 3 números e indicar si NO hay repetidos, es decir, si son todos diferentes.

    public static void main(String args[]){
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
        if (num1!=num2 && num1!=num3 && num2!=num3)
        {
            System.out.println("No hay numeros repetidos");
        }




    }
}
