package practicos.claseSeis_Herencia_Polimorfismo.ejercicioDos;

public class Developer extends Empleado {
    private String lenguage;

    public String getLenguage()
    {
        return this.lenguage;
    }

    public void setLenguage(String _lenguage)
    {
        this.lenguage=_lenguage;
    }

    public Developer(String _lenguage)
    {
        super("Emiliano Gnochhi",2000,34554321);
        this.lenguage=_lenguage;
    }

    public Developer()
    {
        this.lenguage="";
    }
}
