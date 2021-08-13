package practicos.claseTres.com;

import java.util.Scanner;

//Realizar un método llamado calcularIva, que calcule el IVA (22%) dado un
//número float llamado sueldo, recibido por parámetro. Sugerencia: utilizar
//variables estáticas.
public class ejercicioDoce {
    public static float iva = 22;
    public static void main (String argsπ[]){
        float sueldo = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese sueldo: ");
        sueldo = input.nextFloat();
        calcularIva(sueldo);
    }

    public static void calcularIva(float valor){
        System.out.println(iva/100*valor);
    }
}
