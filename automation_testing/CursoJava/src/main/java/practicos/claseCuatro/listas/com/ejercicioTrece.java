package practicos.claseCuatro.listas.com;
//ejercicio trece devolver el mayor
import java.util.ArrayList;
import java.util.List;

public class ejercicioTrece {
    public static void main (String args[]){
        List<Integer> num = new ArrayList<Integer>();
        num.add(443);
        num.add(44);
        num.add(3211);
        System.out.println("El mayor es: " + devolverMayor(num));
    }

    private static int devolverMayor(List<Integer> num) {
        int menor=-1;
        for (int i=0;i< num.size();i++)
        {
            if (menor == -1)
            {
                menor = num.get(i);
            } else if (menor < num.get(i))
            {
                menor = num.get(i);
            }
        }
        return menor;
    }
}
