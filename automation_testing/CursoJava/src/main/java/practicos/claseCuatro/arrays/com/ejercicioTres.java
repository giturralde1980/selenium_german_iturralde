package practicos.claseCuatro.arrays.com;
//Definir un arreglo de Booleanos con 9 posiciones. Imprimir todos los valores del arreglo.
public class ejercicioTres {
    public static void main (String args[]){
        boolean [] booleanos = new boolean[9];
        for (int i=0; i < booleanos.length; i++)
        {
            System.out.println("valor del booleano: " + booleanos[i]);
        }
    }
}
