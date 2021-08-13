package practicos.claseCuatro.arrays.com;
//Crear un método llamado imprimirArreglo que imprima en pantalla todos los elementos
//de un array de enteros el cual es recibido por parámetro
public class ejercicioNueve {
    public static void main(String args[]){
        int[] ent= new int[3];
        imprimirArreglo(ent);
    }

    public static void imprimirArreglo(int[] ent) {
        for (int i = 0; i<ent.length;i++)
        {
            System.out.println("Valor del entero: " + ent[i]);
        }

    }
}
