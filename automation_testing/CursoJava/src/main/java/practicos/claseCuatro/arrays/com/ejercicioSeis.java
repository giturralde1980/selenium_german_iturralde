package practicos.claseCuatro.arrays.com;
//Contar el número de elementos positivos, negativos y ceros en un array de 5 enteros.
//Mostrar la cantidad de números positivos, negativos y ceros: Ej. “Se ingresaron 2
//números positivos, 1 número negativo y 1 cero”
public class ejercicioSeis {
    public static void main (String args[])
    {
        int[] nums = new int[5];
        int pos = 0;
        int neg = 0;
        int cero = 0;

        nums[0]=1;
        nums[1]=4;
        nums[2]=0;
        nums[3]=0;
        nums[4]=-1;

        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                neg=neg+1;
            }else if(nums[i]>0)
            {
                pos=pos+1;
            }else
            {
                cero=cero+1;
            }
        }

        System.out.println("Negativos:" + neg);
        System.out.println("Positivos:" + pos);
        System.out.println("Ceros:" + cero);

    }
}
