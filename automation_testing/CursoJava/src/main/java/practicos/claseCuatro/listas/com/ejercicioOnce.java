package practicos.claseCuatro.listas.com;
//11) Método que reciba una lista de enteros, y retorne el promedio de los mismos.
import java.util.ArrayList;
import java.util.List;

public class ejercicioOnce {
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
        int suma = devolverPromedio(num);
        System.out.println("promedio: " + suma);
    }

    private static int devolverPromedio(List<Integer> num) {
        int suma = 0;
        for (int i=0; i<num.size();i++)
        {
            suma=suma+num.get(i);
        }
        return suma/num.size();
    }
}
