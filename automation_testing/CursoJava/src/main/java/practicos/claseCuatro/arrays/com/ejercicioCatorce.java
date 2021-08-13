package practicos.claseCuatro.arrays.com;
//14. Crear un método que reciba un arreglo de enteros, y retorne el mayor.
public class ejercicioCatorce {
    public static void main (String args[]){
        int[]  nums = new int[4];
        nums[0]=337;
        nums[1]=525;
        nums[2]=41;
        nums[3]=32;
        int mayor = devolverMayor(nums);
        System.out.println("Mayor: " + mayor);
    }

    private static int devolverMayor(int[] nums) {
        int mayor = 0;
        for(int i=0;i < nums.length;i++){
            if(i==0)
            {
                mayor=nums[i];
            }
            if(mayor < nums[i])
            {
                mayor=nums[i];
            }
        }
        return mayor;
    }
}
