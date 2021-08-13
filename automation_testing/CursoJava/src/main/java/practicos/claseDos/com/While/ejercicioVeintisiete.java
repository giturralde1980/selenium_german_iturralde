package practicos.claseDos.com.While;

import java.util.Scanner;
//27) Programa Java que muestre los números del 1 al 10 utilizando la instrucción while
public class ejercicioVeintisiete {
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        int contador = 1;
        while(contador <=10)
        {
            System.out.println(contador);
            contador++;
        }

    }
}
