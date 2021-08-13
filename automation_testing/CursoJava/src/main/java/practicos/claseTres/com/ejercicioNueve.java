package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioNueve {
    //Crear un método que permita reciba el radio de un círculo, y retorne su área
    //(radio^2)*PI (utilizar una variable estática para el valor de PI)

    public static double PI = 3.141592;

    public static void main (String args[])
    {
        double radio = 0;
        double area = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese radio: ");
        radio = input.nextInt();
        area = calcularArea(radio);
        System.out.println("Area: " + Math.round(area * 100.0) / 100.0);


    }

    public static double calcularArea(double radio)
    {
        double area = (radio*2)* PI;
        return area;
    }
}
