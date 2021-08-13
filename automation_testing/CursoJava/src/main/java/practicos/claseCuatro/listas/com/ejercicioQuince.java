package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Método leerValores(): pide por teclado los números y los almacena en el ArrayList. La
//lectura acaba cuando se introduce el valor -99. El método devuelve mediante return el
//ArrayList con los valores introducidos.
public class ejercicioQuince {
    public static void main(String args[])
    {
        List<Integer> valores = new ArrayList<Integer>();
        valores = leerValores();
        for (int i=0;i< valores.size();i++)
        {
            System.out.println("valor: " + valores.get(i));
        }

    }

    public static List<Integer> leerValores()
    {
        Scanner input = new Scanner(System.in);
        int tope = 0;
        List<Integer> valores = new ArrayList<Integer>();
        while (tope != -99) {
            System.out.println("ingrese número");
            tope = input.nextInt();
            valores.add(tope);
        }
        return valores;
    }
}
