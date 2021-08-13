package practicos.clases_y_objetos.ejercicioTres;
import java.time.LocalDate;
import java.util.Date;
//3) Ejercicio
//○ Crear una clase llamada Persona que contenga el nombre y apellido de una
//persona.
//○ Agregar un atributo documento de tipo int y un atributo int de tipo edad.
//○ Agregar un método llamado toString que muestre los datos de la persona.
//○ Agregar un método llamado mostrarAñoNacimiento de retorno void que
//imprima en pantalla el año de nacimiento de la persona. Sugerencia: utilizar el
//atributo edad.
//○ Crear una clase llamada GestionUsuarios que contenga el método main. Se
//debe pedir el ingreso de dos personas al usuario.
//○ Invocar al método que mostrarAñoNacimiento para cada usuario creado.
public class Persona {
    private String Nombre;
    private String Apellido;
    private int Documento;
    private int Edad;

    public String getNombre()
    {
        return this.Nombre;
    }

    public void setNombre(String nombre){
        this.Nombre=nombre;
    }

    public String getApellido()
    {
        return this.Apellido;
    }

    public void setApellido (String apellido)
    {
        this.Apellido=apellido;
    }

    public int getDocumento()
    {
        return this.Documento;
    }
    public void setDocumento(int doc)
    {
        this.Documento=doc;
    }

    public int getEdad()
    {return this.Edad;}

    public void setEdad(int edad){
        this.Edad=edad;
    }

    public void  mostrarAñoNacimiento()
    {
        LocalDate.now().getYear();
        int año= LocalDate.now().getYear() - this.Edad;
        System.out.println("El año de nacimiento es: " + año);
    }

    public String toString()
    {
        return this.Nombre + this.Apellido + this.Documento;

    }

}
