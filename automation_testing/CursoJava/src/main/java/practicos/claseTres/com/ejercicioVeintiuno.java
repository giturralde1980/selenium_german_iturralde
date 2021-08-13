package practicos.claseTres.com;

import java.util.Scanner;

//Realizar un método llamado calcularPromedio, que solicite el ingreso de números
//hasta que se ingrese 0, y que calcule el promedio de los mismos. Se debe utilizar el
//método ingresarNumero.
public class ejercicioVeintiuno {
    public static void main (String args[])
    {
        ingresarNumeros();
    }

    public static void ingresarNumeros(){
        int numero = -1;
        int resultado = 0;
        int contador =0;
        Scanner input = new Scanner(System.in);
        while (numero != 0)
        {
            System.out.println("Ingrese un numero: ");
            numero=input.nextInt();
            resultado=resultado+numero;
            if(numero != 0)
            {
                contador++;
            }
        }

        System.out.println("resultado: " + resultado);
        System.out.println("contador: " + contador);
        System.out.println("El promedio es: " +calcularPromedio(resultado,contador));
    }

    public static int calcularPromedio(int num1,int num2)
    {
        return num1/num2;
    }
}
