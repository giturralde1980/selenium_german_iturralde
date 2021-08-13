package practicos.claseCuatro.listas.com;
//Crear un método imprimirListaEnteros que reciba una lista de enteros, y los imprima
//en pantalla.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicioSeis {
    public static void main (String args[])
    {
        List<Integer> nombres = new ArrayList<Integer>();
        nombres.add(1);
        nombres.add(4);
        nombres.add(456);
        mostrarEnteros(nombres);

    }

    public static void mostrarEnteros(List<Integer> numeros)
    {
        for (int i = 0; i< numeros.size();i++)
        {
            System.out.println(numeros.get(i));
        }
    }
}
