package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioNueve {
    public static void main(String args[]){
        /*
        Mostrar el resultado del examen:
        Si la nota está entre 0 y 59 → Eliminado
        Si la nota está entre 60 y 79 → Aprobado
        Si la nota está entre 80 y 100 → Aprobado con Excelente
        Si el numero esta fuera de 0 y 100, mostrar que se ha ingresado una nota invalida

         */
        int nota=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nota: ");
        nota = input.nextInt();

        if(nota > 0 &&  nota<= 59) {
            System.out.println("eliminado");
        }else if (nota >59 && nota < 80){
            System.out.print("aprobado");
        }else
            System.out.print("aprobado excelente");
    }
}
