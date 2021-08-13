package practicos.claseCuatro.arrays.com;
//Crear un método llamado crearArregloBooleano que retorne un arreglo de 10
//posiciones de tipo booleanos donde todas sus posiciones tengan valor false.
public class ejercicioOcho {
    public static void main (String args[])
    {
        boolean[] booleans= crearArrergloBooleano();
        for (int i = 0; i<booleans.length;i++)
        {
            System.out.println("Valor del booleano: " + booleans[i]);
        }

    }

    public static boolean[] crearArrergloBooleano() {
        boolean[] booleanos = new boolean[10];
        return booleanos;
    }
}
