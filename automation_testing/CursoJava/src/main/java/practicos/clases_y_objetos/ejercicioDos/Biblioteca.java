package practicos.clases_y_objetos.ejercicioDos;
//c) Crear una clase llamada Librería que contenga el main, y cree 2 objetos Libro (los
//valores que serán ingresados por el usuario) y mostrarlos por pantalla.
import java.util.Scanner;

public class Biblioteca {
    public static void main (String args[])
    {

        Scanner input = new Scanner(System.in);
        Libro l1= new Libro();
        System.out.println("+++++Libro uno+++++");
        System.out.println("Ingrese Isbn");
        l1.setIsbn(input.nextInt());
        //System.out.println("Ingrese Titulo");
        //l1.setTitulo(input.next());
        System.out.println("Ingrese Autor");
        l1.setAutor(input.next());
        System.out.println("Ingrese Numero de Paginas");
        l1.setNumero_de_Paginas(input.nextInt());

        System.out.println("+++++Libro dos+++++");
        System.out.println("Ingrese Isbn");
        int isbn=input.nextInt();
        System.out.println("Ingrese Titulo");
        String titulo = input.next();
        System.out.println("Ingrese Autor");
        String autor = input.next();
        System.out.println("Ingrese Numero de Paginas");
        int num_pag = input.nextInt();

        Libro l2 = new Libro(isbn, titulo, autor,num_pag);

        System.out.println(l1);
        System.out.println(l2);

    }
}
