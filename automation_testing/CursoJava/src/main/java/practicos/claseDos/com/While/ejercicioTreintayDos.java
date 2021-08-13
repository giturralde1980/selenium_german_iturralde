package practicos.claseDos.com.While;

import java.util.Scanner;

//32) Pedir el ingreso de números hasta que se ingrese 0 y se muestre el promedio de los
//mismos.
public class ejercicioTreintayDos {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int num = 1;
        while (num !=0) {
            System.out.println("ingrese numero: ");
            num = input.nextInt();
        }
    }
}

