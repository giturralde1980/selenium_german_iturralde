package practicos.claseTres.com;

import java.util.Scanner;

//Crear un método que reciba un entero, y muestre en pantalla la cantidad de
//dólares y de euros que representa ese número
public class ejercicioOnce {

    public static double precioEuro=0.019;
    public static double precioDolar=0.023;

    public static void main (String args[])
    {
        int numero = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese número: ");
        numero = input.nextInt();
        mostrarEuroDolar(numero);

    }

    public static void mostrarEuroDolar(int numero)
    {
        double euro = (double) numero * precioEuro;
        double dolar = (double) numero * precioDolar;
        System.out.println("El precio del dolar es: "+ dolar);
        System.out.println("El precio del euro es: "+ euro);
    }
}
