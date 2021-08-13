package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;

//9) Método que reciba una lista de enteros, y retorne la verdadero si y sólo si la lista está
//vacía.
public class ejercicioNueve {
    public static void main(String args[]){
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(20);
        boolean esVacia=esListaVacia(nums);
        if(esVacia)
        {
            System.out.println("lista vacia");
        }else
        {
            System.out.println("lista no vacia");

        }
    }

    private static boolean esListaVacia(List<Integer> nums) {
        if(nums.isEmpty())
        {
            return true;
        }
        return false;
    }

}
