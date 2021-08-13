package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;


//Método que reciba una lista de booleanos, y verdadero si y sólo si, todos los elementos
//de la lista son true. De lo contrario se debe retornar false. Sugerencia: utilizar
//cortocircuito.
public class ejercicioCatorce {
    public static void main(String args[])
    {
        List<Boolean> bulean = new ArrayList<Boolean>();
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        bulean.add(true);
        boolean result = devolverListaBool(bulean);
        System.out.println("Son todos true?: " + result);
    }

    private static boolean devolverListaBool(List<Boolean> bulean) {
        boolean result = false;
        for (int i =0; i<bulean.size();i++)
        {
            if(bulean.get(i) == true) {
                result=true;
            }
        }
        return result;
    }
}
