package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;

//10) Método que reciba una lista de enteros, y retorne la suma.
public class ejercicioDiez {
    public static void main (String args[])
    {
        List<Integer> num = new ArrayList<Integer>();
        num.add(443);
        num.add(44);
        num.add(3211);
        num.add(443);
        num.add(44);
        num.add(3211);
        num.add(443);
        num.add(44);
        num.add(3211);
        num.add(443);
        num.add(44);
        num.add(3211);
        int suma = devolverSuma(num);
        System.out.println("La suma es: " + suma);
    }

    private static int devolverSuma(List<Integer> num) {
        int suma = 0;
        for (int i=0; i<num.size();i++)
        {
            suma=suma+num.get(i);
        }
        return suma;
    }
}
