package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Crear una lista de Strings y agregar nombres. Luego, mostrarle al usuarios la lista de
//nombres y solicitar que ingrese el nombre que desea buscar. Si el nombre no se
//encuentra en la lista, entonces se debe mostrar “La persona no se encuentra en la lista”.
//De lo contrario, se debe mostrar en que lugar de la lista se encuentra almacenado ese
//nombre.
public class ejercicioCinco {
    public static void main (String args[])
    {
        List<String> nombres = new ArrayList<String>();
        nombres.add("german");
        nombres.add("mario");
        nombres.add("hugo");
        for (int i = 0; i< nombres.size();i++)
        {
            System.out.println(nombres.get(i));
        }

        String nom = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre: " );
        nom = input.next();
        if (nombres.contains(nom))
        {
            System.out.println("existe");
        }else
        {
            System.out.println("no existe");
        }

    }
}
