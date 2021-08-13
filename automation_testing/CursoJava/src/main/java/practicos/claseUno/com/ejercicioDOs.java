package practicos.claseUno.com;

import java.util.Scanner;

public class ejercicioDOs {
    public static void main (String args[])
    {

        /*
     Pedir el ingreso del nombre y el año de nacimiento. Mostrar el nombre y la edad de la persona.
    //INICIO   FIN    TECLADO   GUARDAR   MOSTRAR

    INICIO
        TECLADO;
        String nombre;
        Int año;
        MOSTRAR “Ingrese su nombre”;
        GUARDAR nombre;
        MOSTRAR “Ingrese su año de nacimiento”;
        GUARDAR año;

        Int edad = 2021 - año;
        MOSTRAR “Su nombre es “ + nombre + “ y su edad es “ + edad;

    FIN

         */
        String nombre="";
        int año=0;
        int edad=0;

        Scanner input = new Scanner(System.in);

        System.out.println("ingrese su nombre");
        nombre= input.next();

        System.out.println("ingrese edad");
        edad=input.nextInt();

       año=2021-edad;

       System.out.println("El nombre es: " + nombre
               + " y el año de nacimiento:" + año);

    }
}
