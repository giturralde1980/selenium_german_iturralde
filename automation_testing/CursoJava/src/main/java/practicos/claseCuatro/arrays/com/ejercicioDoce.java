package practicos.claseCuatro.arrays.com;
//Crear un método que reciba una arreglo de floats, y retorne el promedio de los mismos.
public class ejercicioDoce {
    public static void main(String args[]){
        float[] fl= new float[2];
        fl[0]=3;
        fl[1]=4;
        System.out.println(devolverPromedio(fl));
    }

    public static float devolverPromedio(float[] fl) {
        float suma = 0;
        for (int i = 0; i<fl.length;i++)
        {
            suma=suma+fl[i];
        }
        return suma/fl.length;
    }
}

