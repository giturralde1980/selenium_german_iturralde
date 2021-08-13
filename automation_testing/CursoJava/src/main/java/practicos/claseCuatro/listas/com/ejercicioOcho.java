package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;

//Método que reciba una lista de enteros, y retorne la cantidad de elementos de la misma.
public class ejercicioOcho {
    public static void main (String args[]){
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1000);
        numeros.add(2000);
        numeros.remove(1);
        numeros.size();
        int cantElementos = cantElementos(numeros);
        System.out.println("cantidad de elementos es: " + cantElementos);

    }

    private static int cantElementos(List<Integer> numeros) {
        return numeros.size();
    }

}
