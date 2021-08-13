package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;

//Crear un método imprimirListaStrings que reciba una lista de Strings, y los imprima en
//pantalla.
public class ejercicioSiete {
    public static void main (String args[])
    {
        List<String> nombres = new ArrayList<String>();
        nombres.add("german");
        nombres.add("mario");
        nombres.add("hugo");
        imprimirLista(nombres);
    }

    private static void imprimirLista(List<String> nombres) {
        for(int i=0; i<nombres.size();i++)
        {
            System.out.println(nombres.get(i));
        }
    }
}
