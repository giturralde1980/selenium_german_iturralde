package practicos.claseCuatro.arrays.com;
//13. Crear un método que reciba un arreglo de enteros, y retorne el menor.
public class ejercicioTrece {
    public static void main (String args[]){
        int[]  nums = new int[4];
        nums[0]=337;
        nums[1]=55;
        nums[2]=41;
        nums[3]=32;
        int menor = devolverMenor(nums);
        System.out.println("Menor: " + menor);
    }

    private static int devolverMenor(int[] nums) {
        int menor = 0;
        for(int i=0;i < nums.length;i++){
            if(i==0)
            {
                menor=nums[i];
            }
            if(menor > nums[i])
            {
                menor=nums[i];
            }
        }
        return menor;
    }

}
