package practicos.claseSeis_Herencia_Polimorfismo.ejercicioDos;

public class Empleado {
    protected String nombre;
    protected int telefono;
    protected int sueldo;

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String _nombre)
    {
        this.nombre=_nombre;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public void setTelefono(int _telefono)
    {
        this.telefono=_telefono;
    }

    public int getSueldo(){
        return this.sueldo;
    }

    public void setSueldo(int _sueldo)
    {
        this.telefono=_sueldo;
    }

    public Empleado(String _nombre, int _sueldo, int _telefono)
    {
        this.nombre=_nombre;
        this.sueldo=_sueldo;
        this.telefono=_telefono;
    }

    public Empleado()
    {
        this.nombre="";
        this.telefono=0;
        this.sueldo=0;
    }


}
