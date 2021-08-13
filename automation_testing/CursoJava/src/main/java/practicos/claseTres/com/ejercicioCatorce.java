package practicos.claseTres.com;

import java.util.Scanner;

//Método llamado convertirAMillas, que reciba un entero llamado kilómetros y
//retorne el equivalente a las millas. Se debe imprimir el valor en millas en
//pantalla. (1 milla = 1.6 kms)
public class ejercicioCatorce {

    public static double milla=1.6;

    public static void main (String args [])
    {
        int km=0;
        double millasCalculadas=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese kilometros: ");
        km=input.nextInt();
        millasCalculadas=convertirAMillas(km);
        System.out.println("Millas calculadas: " + millasCalculadas);
    }

    public static double convertirAMillas(int kilometros)
    {
        return (double)kilometros * milla;
    }

}
