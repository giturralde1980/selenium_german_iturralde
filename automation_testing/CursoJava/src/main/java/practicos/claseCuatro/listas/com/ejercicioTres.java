package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3) Solicitar el ingreso de números hasta ingresar 0. Almacenar todos los valores
//ingresados en una lista
public class ejercicioTres {
    public static void main (String args[])
    {
        int i = -1;
        List<Integer> numGuardados = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        while (i != 0)
        {
            System.out.println("Ingrese numero: ");
            i= input.nextInt();
            numGuardados.add(i);
        }
    }
}
