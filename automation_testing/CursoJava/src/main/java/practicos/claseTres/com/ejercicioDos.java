package practicos.claseTres.com;

import java.util.Scanner;

public class ejercicioDos {
    //Método que reciba un número entero e imprima en pantalla en caso de ser
    //mayor a 20, “Es mayor a 20”. De lo contrario, imprimir “No es mayor a 20”.
    public static void main(String args[]){
        int numero = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        numero = input.nextInt();
        mayorOmenor(numero);
    }

    public static void mayorOmenor(int numero)
    {
        if (numero>20)
        {
            System.out.println("El numero es mayor a 20.");
        }else
        {
            System.out.println("El numero es menor a 20.");
        }
    }
}
