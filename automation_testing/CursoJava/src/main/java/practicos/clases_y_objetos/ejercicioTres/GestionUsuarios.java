package practicos.clases_y_objetos.ejercicioTres;

public class GestionUsuarios {
    public static void main (String args[])
    {
        System.out.println("Persona uno");
        Persona p = new Persona();
        p.setNombre("german");
        p.setApellido("iturralde");
        p.setDocumento(3970158);
        p.setEdad(40);
        System.out.println(p);
        p.mostrarAñoNacimiento();

        System.out.println("Persona dos");
        Persona p1 = new Persona();
        p1.setNombre("andres");
        p1.setApellido("coppola");
        p1.setDocumento(3455432);
        p1.setEdad(21);
        System.out.println(p1);
        p.mostrarAñoNacimiento();
    }
}
