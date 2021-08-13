package practicos.claseCuatro.arrays.com;
//Crear un método que reciba un arreglo, y retorne la cantidad de elementos de la misma.
public class ejercicioSiete {
    public static void main(String args[]) {
        int[] numerosr = new int[44];
        System.out.println("largo del arreglo: " + devolverNumeroElementos(numerosr));

    }

    public static int devolverNumeroElementos(int[] nums)
    {
        return nums.length;
    }
}
