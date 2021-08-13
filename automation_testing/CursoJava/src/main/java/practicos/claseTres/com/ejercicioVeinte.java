package practicos.claseTres.com;

import java.util.Scanner;

//Realizar 4 métodos que reciba dos parámetros cada uno y retornen un número
//float. Los métodos tendrán los siguientes nombres: calcularSuma, calcularResta,
//calcularDivision, calcularMutiplicacion.
public class ejercicioVeinte
{
    public static void main(String args[]){
        float num1=0;
        float num2=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        num1=input.nextFloat();
        System.out.println("Ingrese otro numero: ");
        num2=input.nextFloat();
        System.out.println("El resultado de la suma es: " + calcularSuma(num1,num2));
        System.out.println("El resultado de la resta es: " + calcularResta(num1,num2));
        System.out.println("El resultado de la division es: " + calcularDivision(num1,num2));
        System.out.println("El resultado de la multiplicacion es: " + calcularMultiplicacion(num1,num2));
    }

    public static float calcularSuma(float num1, float num2)
    {
        return num1+num2;
    }

    public static float calcularResta(float num1, float num2)
    {
        return num1-num2;
    }

    public static float calcularMultiplicacion(float num1, float num2)
    {
        return num1*num2;
    }

    public static float calcularDivision(float num1, float num2)
    {
        return num1/num2;
    }
}
