package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioOcho {
    public static void main(String args[])
    {
        int num1=0;
        int num2=0;
        int num3=0;
        int num4=0;
        int suma=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero");
        num1=input.nextInt();
        System.out.println("Ingrese numero");
        num2=input.nextInt();
        System.out.println("Ingrese numero");
        num3=input.nextInt();
        System.out.println("Ingrese numero");
        num4=input.nextInt();

        if (num1 <0)
            num1=num1 * (-1);

        if (num2 <0)
            num2=num2 * (-1);

        if (num3 <0)
            num3=num3 * (-1);

        if (num4 <0)
            num4=num4 * (-1);

        suma= num1+num2+num3+num4;
        System.out.println("Resultado: "+ suma);
    }

}

