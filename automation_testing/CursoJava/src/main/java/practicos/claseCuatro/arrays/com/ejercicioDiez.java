package practicos.claseCuatro.arrays.com;
//Crear un método llamado imprimirArreglo que imprima en pantalla todos los elementos
//de un array de booleanos el cual es recibido por parámetro.
public class ejercicioDiez {
    public static void main(String args[]){
        boolean[] booleans= new boolean[33];
        imprimirArreglo(booleans);
    }

    public static void imprimirArreglo(boolean[] booleanos) {
        for (int i = 0; i<booleanos.length;i++)
        {
            System.out.println("Valor del booleano: " + booleanos[i]);
        }

    }
}
