package practicos.claseCuatro.arrays.com;
//Crear un array de números de 100 posiciones, que contendrá los números del 1 al 100.
//Obtener la suma de todos ellos y el promedio.
public class ejercicioCuatro {
    public static void main (String args[]){
        int[] numeros = new int[100];
        int suma = 0;
        for(int i=0;i<numeros.length;i++)
        {
            numeros[i] = i;
            suma = suma + i;
        }

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + suma/ numeros.length);
    }
}
