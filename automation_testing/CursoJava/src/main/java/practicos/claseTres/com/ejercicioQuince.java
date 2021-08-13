package practicos.claseTres.com;

import java.util.Scanner;
//Crear un método que retorne la suma de los números pares entre 1 y n, siendo n
//un parámetro.
public class ejercicioQuince {
    public static void main (String args [])
    {
        int numero=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese numero: ");
        numero=input.nextInt();
        int resultado = calcularSuma(numero);
        System.out.println("Resultado: " + resultado);

    }

    public static int calcularSuma(int numero)
    {
        int resultado = 0;
        for (int i=1; i<=numero;i++)
        {
            if(i%2==0) {
                resultado=resultado+i;
            }
        }
        return resultado;
    }

}
