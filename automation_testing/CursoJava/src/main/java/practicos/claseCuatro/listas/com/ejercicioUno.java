package practicos.claseCuatro.listas.com;

import java.util.ArrayList;
import java.util.List;

//Crear una clase llamada EjerciciosListas y agregar todos los métodos en esa clase.
public class ejercicioUno {
    public static void main (String args[]){
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1000);
        numeros.add(2000);
        numeros.remove(1);
        numeros.size();
        if (numeros.isEmpty()){
            System.out.println("lista vacia");
        }else
        {
            System.out.println("lista no vacia");
        }
        System.out.println("lista get: " + numeros.get(0));
        System.out.println("indice de 1000: " + numeros.indexOf(1000));
    }
}
