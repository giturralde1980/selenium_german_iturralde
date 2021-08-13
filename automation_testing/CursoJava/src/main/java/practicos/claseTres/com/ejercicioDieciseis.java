package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioDieciseis {
    //Crear un método llamado tipoTriangulo, que dado 3 valores enteros recibidos por
    //parámetro, imprima en pantalla si es escaleno, si es equilátero o isósceles.
    public static void main (String args [])
    {
        int a=0;
        int b=0;
        int c=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese lado a: ");
        a=input.nextInt();
        System.out.println("Ingrese lado b: ");
        b= input.nextInt();
        System.out.println("Ingrese lado c: ");
        c=input.nextInt();
        tipoTriangulo(a,b,c);
    }

    public static void tipoTriangulo(int a, int b, int c)
    {
        int resultado=0;
        if(a==b && a==c)
        {
            System.out.println("Triangulo equilatero");
        }else if (a==b && a!=c || b==c && b!=a || a==c && a!=b)
        {
            System.out.println("Triangulo isosceles");
        }else
        {
            System.out.println("Triangulo escaleno");
        }

    }
}
