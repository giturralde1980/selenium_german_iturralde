package practicos.claseCuatro.arrays.com;

public class ejercicioOnce {
    public static void main(String args[]){
        float[] fl= new float[33];
        imprimirArreglo(fl);
    }

    public static void imprimirArreglo(float[] fl) {
        for (int i = 0; i<fl.length;i++)
        {
            System.out.println("Valor del booleano: " + fl[i]);
        }

    }
}
